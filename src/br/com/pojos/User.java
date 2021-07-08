package br.com.pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tipoUser;
	
	//VARIOS USUARIOS POSSUEM UMA CHAMADA
	@ManyToOne(targetEntity=Chamada.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "idChamada")
	private Chamada chamada;
	
	//VARIOS USUARIOS POSSUEM UMA ESTATISTICA
	@ManyToOne(targetEntity=Estatistica.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "idEstatistica")
	private Estatistica estatistica;
	
	//UM USUARIO POSSUI UM DIARIO
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idDiario")
	private Diario diario;
	
	// 1 USUARIO POSSUI "VARIOS" AVISOS
	@OneToMany(mappedBy = "user", targetEntity = Aviso.class, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Aviso> userAvisos = new ArrayList<Aviso>();
	
	//VARIOS USUARIOS POSSUEM UMA TURMA
	@ManyToOne(targetEntity=Turma.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "idTurma")
	private Turma turma;
	
	private String nome;
	private String email;
	private String user;
	private String senha;

	public int getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(int tipoUser) {
		this.tipoUser = tipoUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public User(){
		
	}
	
	public User(int tipoUser, String nome, String email, String user, String senha){
		this.tipoUser = tipoUser;
		this.nome = nome;
		this.email = email;
		this.user = user;
		this.senha = senha;
	}
	
}
