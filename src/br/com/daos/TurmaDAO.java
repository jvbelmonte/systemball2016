package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.Turma;

public class TurmaDAO extends GenericDAO<Integer, Turma> {
	
	public TurmaDAO(EntityManager entityManager){
		super(entityManager);
	}
	

}