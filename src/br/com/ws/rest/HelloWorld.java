package br.com.ws.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorld {
	
	@GET
	@Path("/{nome}")
	@Produces(MediaType.TEXT_PLAIN + "; charset=utf-8")
	public String sayHello(@PathParam("nome") String nome) {
		String retorno = "Web Service diz: Olá " + nome + "!";
		return retorno;
	}
}
