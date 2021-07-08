package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.Esquema;

public class EsquemaDAO extends GenericDAO<Integer, Esquema> {
	
	public EsquemaDAO(EntityManager entityManager){
		super(entityManager);
	}
	

}