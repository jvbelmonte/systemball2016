package br.com.daos;

import javax.persistence.EntityManager;

import br.com.pojos.User;

public class UserDAO extends GenericDAO<Integer, User> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}
}
