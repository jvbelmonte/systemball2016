package br.com.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.AdmDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Adm;
import br.com.pojos.Cliente;

@Path("/adm")
public class AdmService {
	
	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private AdmDAO admDAO = new AdmDAO(sem.getEntityManager());
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Adm consultar(@PathParam("id") int id_adm){
		int exceptionNumber = 500;
		try{
			Adm adm = admDAO.consultaId(id_adm);
			if(adm == null){
				exceptionNumber = 404;
				throw new Exception("Nenhum adm com esse id");
			}
			return adm;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Adm> listar(){
		int exceptionNumber = 500;
		try{
			List<Adm> adm = admDAO.listarAdms();
			if (adm.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("Nenhum adm registrado.");
				}
			return adm;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Adm adm){
		try{
			sem.getEntityManager().getTransaction().begin();
			admDAO.save(adm);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Adm cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, Adm adm){
		int exceptionNumber = 500;
		try{
			Adm admPer = admDAO.consultaId(id);
			if(admPer == null){
				exceptionNumber = 404;
				throw new Exception("Nenhum adm com esse id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				adm.setIdAdm(id);
				admDAO.save(adm);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("Adm alterado com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") int id_adm){
		int exceptionNumber = 500;
		try{
			Adm adm = admDAO.consultaId(id_adm);
			if(adm == null){
				exceptionNumber = 404;
				throw new Exception("Nenhum adm com esse id");
			}
			sem.getEntityManager().getTransaction().begin();
			admDAO.delete(adm);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Adm excluído com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}	

}
