package br.com.pojos;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Diario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDiario;
	
	//UM DIARIO POSSUI UM USUARIO
	@OneToOne(mappedBy = "diario", targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;
	
	private String descricao;
	
	public int getIdDiario() {
		return idDiario;
	}
	public void setIdDiario(int idDiario) {
		this.idDiario = idDiario;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Diario(){
		
	}
	
	public Diario(int idDiario, String descricao){
		this.idDiario = idDiario;
		this.descricao = descricao;
	}

}
