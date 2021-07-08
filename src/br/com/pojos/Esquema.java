package br.com.pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Esquema {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEsquema;
	
	//VARIOS ESQUEMAS POSSUEM VARIOS TREINAMENTOS
	@ManyToMany(mappedBy = "esquemas", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Treinamento.class)
	private List<Treinamento> treinamentos = new ArrayList<Treinamento>();
	
	private String imagem;

	public int getIdEsquema() {
		return idEsquema;
	}

	public void setIdEsquema(int idEsquema) {
		this.idEsquema = idEsquema;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public Esquema(){
		
	}
	
	public Esquema(String imagem){
		this.imagem = imagem;
	}

}
