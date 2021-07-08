package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.Diario;

public class DiarioDAO extends GenericDAO<Integer, Diario> {
	
	public DiarioDAO(EntityManager entityManager){
		super(entityManager);
	}
	

}