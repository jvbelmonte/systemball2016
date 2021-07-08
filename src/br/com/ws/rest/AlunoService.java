package br.com.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.AlunoDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Aluno;

@Path("/aluno")
public class AlunoService {
	
	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private AlunoDAO alunoDAO = new AlunoDAO(sem.getEntityManager());
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Aluno aluno){
		try{
			sem.getEntityManager().getTransaction().begin();
			alunoDAO.save(aluno);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Aluno cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	

}
