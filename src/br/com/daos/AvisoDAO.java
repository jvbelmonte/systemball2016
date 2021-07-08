package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.Aviso;

public class AvisoDAO extends GenericDAO<Integer, Aviso> {

	public AvisoDAO(EntityManager entityManager) {
		super(entityManager);
	}
}
