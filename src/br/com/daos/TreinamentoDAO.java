package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.Treinamento;

public class TreinamentoDAO extends GenericDAO<Integer, Treinamento> {

	public TreinamentoDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
