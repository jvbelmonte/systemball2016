package br.com.pojos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Torneio {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTorneio;
	
	//VARIOS TORNEIOS POSSUI VARIAS TURMAS
	@ManyToMany(mappedBy = "turmaTorneios", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Turma.class)
	private List<Torneio> usersTorneio = new ArrayList<Torneio>();
	
	private Date horario;
	private Date data;
	
	public int getIdTorneio() {
		return idTorneio;
	}

	public void setIdTorneio(int idTorneio) {
		this.idTorneio = idTorneio;
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

	public Torneio(){
		
	}
	
	public Torneio(int idTorneio, Date horario, Date data){
		this.idTorneio = idTorneio;
		this.horario = horario;
		this.data = data;
	}

}
