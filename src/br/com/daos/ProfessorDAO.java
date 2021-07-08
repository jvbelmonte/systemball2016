package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.Professor;

public class ProfessorDAO extends GenericDAO<Integer, Professor> {

	public ProfessorDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
