package br.com.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.EsquemaDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Esquema;

@Path("/aluno")
public class EsquemaService {
	
	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private EsquemaDAO esquemaDAO = new EsquemaDAO(sem.getEntityManager());
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Esquema esquema){
		try{
			sem.getEntityManager().getTransaction().begin();
			esquemaDAO.save(esquema);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Aluno cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	

}
