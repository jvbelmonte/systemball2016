package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.Aluno;

public class AlunoDAO extends GenericDAO<Integer, Aluno> {
	
	public AlunoDAO(EntityManager entityManager){
		super(entityManager);
	}
	

}
