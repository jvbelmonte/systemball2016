package br.com.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.TurmaDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Turma;

@Path("/aluno")
public class TurmaService {
	
	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private TurmaDAO turmaDAO = new TurmaDAO(sem.getEntityManager());
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Turma turma){
		try{
			sem.getEntityManager().getTransaction().begin();
			turmaDAO.save(turma);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Turma cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	

}
