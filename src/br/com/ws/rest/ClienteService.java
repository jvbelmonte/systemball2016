package br.com.ws.rest;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.ClienteDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Cliente;

@Path("/cliente")
public class ClienteService {

	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private ClienteDAO clienteDAO = new ClienteDAO(sem.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Cliente consultar(@PathParam("id") int id_cliente){
		int exceptionNumber = 500;
		try{
			Cliente cliente = clienteDAO.consultaId(id_cliente);
			if(cliente == null){
				exceptionNumber = 404;
				throw new Exception("No client with this id");
			}
			return cliente;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listar(){
		int exceptionNumber = 500;
		try{
			List<Cliente> clientes = clienteDAO.listarClientes();
			if (clientes.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("No clients registred");
				}
			return clientes;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Path("/gerar")
	@Produces(MediaType.TEXT_PLAIN)
	public String gerar(){
		try{
			DateFormat f = DateFormat.getDateInstance();
			sem.getEntityManager().getTransaction().begin();
			Cliente c = new Cliente();
			c.setNome("Joana da Costa Pimentel");
			c.setEmail("joana.pimentel@gmail.com");
			Date dataNascimento = f.parse("21/03/1980"); 
			c.setNascimento(dataNascimento);
			c.setEndereco("Rua A");
			c.setNumero(23);
			c.setCpf("111.111.111-11");
			clienteDAO.save(c);
			
			c = new Cliente();
			c.setNome("Euzébio da Silva");
			c.setEmail("euzebio.silva@hotmail.com");
			dataNascimento = f.parse("19/10/1990"); 
			c.setNascimento(dataNascimento);
			c.setEndereco("Rua Sei lá do que");
			c.setNumero(1541);
			c.setCpf("222.222.222-22");
			clienteDAO.save(c);
			sem.getEntityManager().getTransaction().commit();
			return "Clientes Gerados com sucesso!";
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Cliente cliente){
		try{
			sem.getEntityManager().getTransaction().begin();
			clienteDAO.save(cliente);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Cliente cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, Cliente cliente){
		int exceptionNumber = 500;
		try{
			Cliente clientePer = clienteDAO.consultaId(id);
			if(clientePer == null){
				exceptionNumber = 404;
				throw new Exception("No client with this id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				cliente.setId(id);
				clienteDAO.save(cliente);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("Cliente alterado com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") int id_cliente){
		int exceptionNumber = 500;
		try{
			Cliente cliente = clienteDAO.consultaId(id_cliente);
			if(cliente == null){
				exceptionNumber = 404;
				throw new Exception("No client with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			clienteDAO.delete(cliente);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Cliente excluído com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
}

