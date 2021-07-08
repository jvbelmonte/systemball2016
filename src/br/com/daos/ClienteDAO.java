package br.com.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Cliente;

public class ClienteDAO extends GenericDAO<Integer, Cliente> {

	public ClienteDAO(EntityManager entity) {
		super(entity);
	}
		
	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientes(){
		this.em.getTransaction().begin();
		Query consulta = this.em.createQuery("Select cliente from Cliente as cliente");
		List<Cliente> clientes = consulta.getResultList();
		this.em.getTransaction().commit();
		return clientes;
	}
	
	public Cliente consultaId(int id){
		this.em.getTransaction().begin();
		Cliente cliente = this.getById(id);
		this.em.getTransaction().commit();
		return cliente;
	}
}
