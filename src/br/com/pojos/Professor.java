package br.com.pojos;
import javax.persistence.*;

@Entity
public class Professor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProfessor;
	
	private String nomeProfessor;
	private String userProfessor;
	private String emailProfessor;
	private String senhaProfessor;
	private String confirmarSenhaProfessor;
	

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getUserProfessor() {
		return userProfessor;
	}

	public void setUserProfessor(String userProfessor) {
		this.userProfessor = userProfessor;
	}

	public String getEmailProfessor() {
		return emailProfessor;
	}

	public void setEmailProfessor(String emailProfessor) {
		this.emailProfessor = emailProfessor;
	}

	public String getSenhaProfessor() {
		return senhaProfessor;
	}

	public void setSenhaProfessor(String senhaProfessor) {
		this.senhaProfessor = senhaProfessor;
	}

	public String getConfirmarSenhaProfessor() {
		return confirmarSenhaProfessor;
	}

	public void setConfirmarSenhaProfessor(String confirmarSenhaProfessor) {
		this.confirmarSenhaProfessor = confirmarSenhaProfessor;
	}

	public Professor(){
		
	}
	
	public Professor(int idProfessor, String nomeProfessor, String userProfessor, String emailProfessor, String senhaProfessor, String confirmarSenhaProfessor){
		this.idProfessor = idProfessor;
		this.nomeProfessor = nomeProfessor;
		this.userProfessor = userProfessor;
		this.emailProfessor = emailProfessor;
		this.senhaProfessor = senhaProfessor;
		this.confirmarSenhaProfessor = confirmarSenhaProfessor;
	}

}
