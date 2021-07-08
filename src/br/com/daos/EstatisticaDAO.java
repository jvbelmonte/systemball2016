package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.Estatistica;

public class EstatisticaDAO extends GenericDAO<Integer, Estatistica> {

	public EstatisticaDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
