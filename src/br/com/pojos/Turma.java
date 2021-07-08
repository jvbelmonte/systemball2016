package br.com.pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Turma {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTurma;
	
	//UMA TURMA POSSUI VARIOS USUARIOS
	@OneToMany(mappedBy = "turma", targetEntity = User.class, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<User> usersTurma = new ArrayList<User>();
	
	//VARIAS TURMAS POSSUEM VARIOS TORNEIOS
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Torneio.class)
	private List<Torneio> turmaTorneios = new ArrayList<Torneio>();
	
	//UMA TURMA POSSUI VARIOS TREINAMENTOS
	@OneToMany(mappedBy = "turma", targetEntity = Treinamento.class, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Treinamento> turmaTreinamentos = new ArrayList<Treinamento>();
	
	//UMA TURMA POSSUI VARIOS AVISOS
	@OneToMany(mappedBy = "turma", targetEntity = Aviso.class, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Aviso> turmaAvisos = new ArrayList<Aviso>();
	
	
	private String nome;

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Turma(){
		
	}
	
	public Turma(int idTurma, String nome){
		this.idTurma = idTurma;
		this.nome = nome;
	}

}
