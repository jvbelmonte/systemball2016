package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.Chamada;

public class ChamadaDAO extends GenericDAO<Integer, Chamada> {
	
	public ChamadaDAO(EntityManager entityManager){
		super(entityManager);
	}
	

}