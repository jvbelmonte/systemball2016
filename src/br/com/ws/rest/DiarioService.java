package br.com.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.DiarioDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Diario;

@Path("/aluno")
public class DiarioService {
	
	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private DiarioDAO diarioDAO = new DiarioDAO(sem.getEntityManager());
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Diario diario){
		try{
			sem.getEntityManager().getTransaction().begin();
			diarioDAO.save(diario);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Diario cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	

}
