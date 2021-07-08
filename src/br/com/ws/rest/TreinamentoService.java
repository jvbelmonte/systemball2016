package br.com.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.TreinamentoDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Treinamento;

@Path("/aluno")
public class TreinamentoService {
	
	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private TreinamentoDAO treinamentoDAO = new TreinamentoDAO(sem.getEntityManager());
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Treinamento treinamento){
		try{
			sem.getEntityManager().getTransaction().begin();
			treinamentoDAO.save(treinamento);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Treinamento cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	

}
