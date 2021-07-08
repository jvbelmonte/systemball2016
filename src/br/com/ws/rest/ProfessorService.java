package br.com.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.ProfessorDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Professor;

@Path("/aluno")
public class ProfessorService {
	
	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private ProfessorDAO professorDAO = new ProfessorDAO(sem.getEntityManager());
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Professor professor){
		try{
			sem.getEntityManager().getTransaction().begin();
			professorDAO.save(professor);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Professor cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	

}
