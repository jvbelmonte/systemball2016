package br.com.ws.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.pojos.Cliente;

@Path("frete")
public class TransporteService {

	@GET
	@Path("/getValor/{estado}")
	@Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
	public String getFrete (@PathParam("estado") String estado) {
		float total = 0;
		if (estado.equalsIgnoreCase("RS")) {
			total = 20;
		} else {
			return "Infelizmente não entregamos no estado solicitado!";
		}
		return "O valor do frete é R$" + Float.toString(total) + "!";
	}
	
	@GET
	@Path("/clientes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getClientes(){
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		Random r = new Random();
		Cliente c = new Cliente();
		Integer id = r.nextInt(100);
		c.setNome("Joana da Costa Pimentel");
		c.setEmail("joana.pimentel@gmail.com");
		c.setId(id);
		listaClientes.add(c);
		
		c = new Cliente();
		id = r.nextInt(100);
		c.setNome("Euzébio da Silva");
		c.setEmail("euzebio.silva@hotmail.com");
		c.setId(id);
		listaClientes.add(c);
		
		return listaClientes;
	}
}
