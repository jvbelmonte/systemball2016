package br.com.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAviso;

	//VARIOS AVISOS POSSUEM 1 USUARIO
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "idUser")
	private User user;
	
	//VARIOS AVISOS POSSUEM UMA TURMA
	@ManyToOne(targetEntity=Turma.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "idTurma")
	private Turma turma;
	
	private String destinatario;
	private String remetente;
	private String avisoPrivado;
	private String avisoTurma;
	private String avisoGeral;
	private Date data;

	
	public String getAvisoPrivado() {
		return avisoPrivado;
	}

	public void setAvisoPrivado(String avisoPrivado) {
		this.avisoPrivado = avisoPrivado;
	}

	public String getAvisoTurma() {
		return avisoTurma;
	}

	public void setAvisoTurma(String avisoTurma) {
		this.avisoTurma = avisoTurma;
	}

	public String getAvisoGeral() {
		return avisoGeral;
	}

	public void setAvisoGeral(String avisoGeral) {
		this.avisoGeral = avisoGeral;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIdAviso() {
		return idAviso;
	}

	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public Aviso() {

	}

	public Aviso(int idAviso, String destinatario, String remetente, String avisoPrivado, String avisoTurma, String avisoGeral) {
		this.idAviso = idAviso;
		this.destinatario = destinatario;
		this.remetente = remetente;
		this.avisoPrivado = avisoPrivado;
		this.avisoTurma = avisoTurma;
		this.avisoGeral = avisoGeral;
		this.data = data;
	}

}
