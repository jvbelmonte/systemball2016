package br.com.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Chamada {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idChamada;
	
	//UMA CHAMADA POSSUI VARIOS USUARIOS
	@OneToMany(mappedBy = "chamada", targetEntity = User.class, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<User> usersCham = new ArrayList<User>();
	
	public int getIdChamada() {
		return idChamada;
	}
	public void setIdChamada(int idChamada) {
		this.idChamada = idChamada;
	}
	private String nome;
	private Date data;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public Chamada(){
		
	}
	
	public Chamada(int idChamada, String nome, Date data){
		this.idChamada = idChamada;
		this.nome = nome;
		this.data = data;
	}

}
