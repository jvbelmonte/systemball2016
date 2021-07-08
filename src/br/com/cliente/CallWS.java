package br.com.cliente;


import java.util.List;


import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class CallWS {
	private Client cliente;

	public CallWS() {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getClasses().add(JacksonJsonProvider.class);
		cliente = Client.create(clientConfig);
	}
	
	public void getHello(String hello){
		WebResource resource = cliente.resource("http://localhost:8080/Systemball/rest/hello");
		String valor = resource.path(hello).accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(valor);
	}
	
	public void getClient(String id){
		WebResource resource = cliente.resource("http://localhost:8080/Systemball/rest/cliente");
		Usuario resultado = resource.path(id).accept(MediaType.APPLICATION_JSON).get(Usuario.class);
		System.out.println(resultado.getNome());
		System.out.println(resultado.getContrato());
		System.out.println(resultado.getEmail());
	}
	
	public void getListClient(){
		WebResource resource = cliente.resource("http://localhost:8080/Systemball/rest/cliente");
		List<Usuario> resultados = resource.type(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Usuario>>() {});
		System.out.println(resultados.size());
		for (Usuario resultado : resultados) {
			System.out.println(resultado.getNome());
			System.out.println(resultado.getEmail());
			System.out.println();
		}
	}
	
	public void putClient(String id, String nome) {
		WebResource resource = cliente.resource("http://localhost:8080/Systemball/rest/cliente");
		Usuario usuario = resource.path(id).accept(MediaType.APPLICATION_JSON).get(Usuario.class);
		usuario.setNome(nome);
		ClientResponse resultado = resource.path(id).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, usuario);
		String retorno = resultado.getEntity(String.class);
		System.out.println(resultado.toString());
		System.out.println(resultado.getStatus());
		System.out.println(retorno);
	}
	
	public void postClient(Usuario usuario) {
		WebResource resource = cliente.resource("http://localhost:8080/Systemball/rest/cliente");
		ClientResponse resultado = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, usuario);
		String retorno = resultado.getEntity(String.class);
		System.out.println(resultado.toString());
		System.out.println(resultado.getStatus());		
		System.out.println(retorno);
	}
	
	public void deleteClient(String id) {
		WebResource resource = cliente.resource("http://localhost:8080/Systemball/rest/cliente");
		ClientResponse resultado = resource.path(id).delete(ClientResponse.class);
		String retorno = resultado.getEntity(String.class);
		System.out.println(resultado.toString());
		System.out.println(resultado.getStatus());		
		System.out.println(retorno);
	}
}
