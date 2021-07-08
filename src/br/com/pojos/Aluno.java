package br.com.pojos;

import javax.persistence.*;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAluno;

	private String nomeAluno;
	private String userAluno;
	private String emailAluno;
	private String senhaAluno;
	private String confirmarSenhaAluno;

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getUserAluno() {
		return userAluno;
	}

	public void setUserAluno(String userAluno) {
		this.userAluno = userAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public String getSenhaAluno() {
		return senhaAluno;
	}

	public void setSenhaAluno(String senhaAluno) {
		this.senhaAluno = senhaAluno;
	}

	public String getConfirmarSenhaAluno() {
		return confirmarSenhaAluno;
	}

	public void setConfirmarSenhaAluno(String confirmarSenhaAluno) {
		this.confirmarSenhaAluno = confirmarSenhaAluno;
	}

	public Aluno() {

	}

	public Aluno(int idAluno, String nomeAluno, String userAluno, String emailAluno, String senhaAluno, String confirmarSenhaAluno) {
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
		this.userAluno = userAluno;
		this.emailAluno = emailAluno;
		this.senhaAluno = senhaAluno;
		this.confirmarSenhaAluno = confirmarSenhaAluno;
	}

}
