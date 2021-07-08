package br.com.cliente;

import java.util.Date;

public class Usuario {
	
	private Integer contrato;
	private String nome;
	private String cpf;
	private String email;
	private Date nascimento;
	private String endereco;
	private int numero;
	
	public Usuario (){
		
	}
	
	public Usuario (int contrato, String nome, String cpf, String email, Date nascimento, String endereco, int numero) {
		super();
		this.contrato = contrato;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.numero = numero;
	}

	public Integer getContrato() {
		return contrato;
	}

	public void setContrato(Integer id) {
		this.contrato = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
