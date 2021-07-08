package br.com.pojos;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdm;

	private String usernameAdm;
	private String nomeAdm;
	private String emailAdm;
	private String senhaAdm;
	private String confirmarSenhaAdm;

	public int getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(int idAdm) {
		this.idAdm = idAdm;
	}

	public String getUsernameAdm() {
		return usernameAdm;
	}

	public void setUsernameAdm(String usernameAdm) {
		this.usernameAdm = usernameAdm;
	}

	public String getNomeAdm() {
		return nomeAdm;
	}

	public void setNomeAdm(String nomeAdm) {
		this.nomeAdm = nomeAdm;
	}

	public String getEmailAdm() {
		return emailAdm;
	}

	public void setEmailAdm(String emailAdm) {
		this.emailAdm = emailAdm;
	}

	public String getSenhaAdm() {
		return senhaAdm;
	}

	public void setSenhaAdm(String senhaAdm) {
		this.senhaAdm = senhaAdm;
	}

	public String getConfirmarSenhaAdm() {
		return confirmarSenhaAdm;
	}

	public void setConfirmarSenhaAdm(String confirmarSenhaAdm) {
		this.confirmarSenhaAdm = confirmarSenhaAdm;
	}

	public Adm() {

	}

	public Adm(int idAdm, String nomeAdm, String emailAdm, String userAdm, String senhaAdm, String confirmarSenhaAdm) {
		this.usernameAdm = usernameAdm;
		this.idAdm = idAdm;
		this.nomeAdm = nomeAdm;
		this.emailAdm = emailAdm;
		this.senhaAdm = senhaAdm;
		this.confirmarSenhaAdm = confirmarSenhaAdm;
	}

}
