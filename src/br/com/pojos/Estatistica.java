package br.com.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Estatistica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEst;

	//UMA ESTATISTICA POSSUI VARIOS USUARIOS
	@OneToMany(mappedBy = "estatistica", targetEntity = User.class, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<User> usersEst = new ArrayList<User>();
		
	private int assist;
	private int gols;
	private int desarmes;
	private int faltas;

	public int getIdEst() {
		return idEst;
	}

	public void setIdEst(int idEst) {
		this.idEst = idEst;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public int getDesarmes() {
		return desarmes;
	}

	public void setDesarmes(int desarmes) {
		this.desarmes = desarmes;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public Estatistica() {

	}

	public Estatistica(int idEst, int assist, int gols, int desarmes, int faltas) {
		this.idEst = idEst;
		this.assist = assist;
		this.gols = gols;
		this.desarmes = desarmes;
		this.faltas = faltas;
	}

}
