package br.com.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.TorneioDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Torneio;

@Path("/aluno")
public class TorneioService {
	
	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private TorneioDAO torneioDAO = new TorneioDAO(sem.getEntityManager());
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Torneio torneio){
		try{
			sem.getEntityManager().getTransaction().begin();
			torneioDAO.save(torneio);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Torneio cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	

}
