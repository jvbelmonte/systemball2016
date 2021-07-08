package br.com.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.EstatisticaDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Estatistica;

@Path("/aluno")
public class EstatisticaService {
	
	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private EstatisticaDAO estatisticaDAO = new EstatisticaDAO(sem.getEntityManager());
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Estatistica estatistica){
		try{
			sem.getEntityManager().getTransaction().begin();
			estatisticaDAO.save(estatistica);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Estatistica cadastrada com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	

}
