package br.com.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Adm;

public class AdmDAO extends GenericDAO<Integer, Adm> {

	public AdmDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	@SuppressWarnings("unchecked")
	public List<Adm> listarAdms(){
		this.em.getTransaction().begin();
		Query consulta = this.em.createQuery("Select adm from Adm as adm");
		List<Adm> adms = consulta.getResultList();
		this.em.getTransaction().commit();
		return adms;
	}
	
	public Adm consultaId(int id){
		this.em.getTransaction().begin();
		Adm adm = this.getById(id);
		this.em.getTransaction().commit();
		return adm;
	}
}
