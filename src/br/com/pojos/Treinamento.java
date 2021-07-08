package br.com.pojos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Treinamento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTreinamento;
	
	//VARIOS TREINAMENTOS POSSUEM UMA TURMA
	@ManyToOne(targetEntity=Turma.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "idTurma")
	private Turma turma;
	
	//VARIOS TREINAMENTOS POSSUEM VARIOS ESQUEMAS
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Esquema.class)
	private List<Esquema> esquemas = new ArrayList<Esquema>();
	
	private Date horario;
	private Date data;
	private int maxAlunos;
	
	public int getIdTreinamento() {
		return idTreinamento;
	}

	public void setIdTreinamento(int idTreinamento) {
		this.idTreinamento = idTreinamento;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getMaxAlunos() {
		return maxAlunos;
	}

	public void setMaxAlunos(int maxAlunos) {
		this.maxAlunos = maxAlunos;
	}

	public Treinamento(){
		
	}
	
	public Treinamento(int idTreinamento, Date horario, Date data, int maxAlunos){
		this.idTreinamento = idTreinamento;
		this.horario = horario;
		this.data = data;
		this.maxAlunos = maxAlunos;
	}
}
