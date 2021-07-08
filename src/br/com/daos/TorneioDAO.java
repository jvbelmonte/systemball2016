package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.Torneio;

public class TorneioDAO extends GenericDAO<Integer, Torneio> {

	public TorneioDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
