package br.com.cliente;

import java.text.DateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		CallWS service = new CallWS();
		
		System.out.println("---------Hello-------------");
		service.getHello("Aluno");
		
		System.out.println("---------POST-------------");
		Usuario usuario = new Usuario();
		Usuario usuario1 = new Usuario();
		DateFormat f = DateFormat.getDateInstance();
		try {
			usuario.setCpf("999.999.999-99");
			usuario.setEmail("jolsimar.afonso.defoe@gmail.com");
			usuario.setNome("Jolsimar Afonso DeFoé");
			usuario.setEndereco("Rua das Grápias");
			Date dataNascimento = f.parse("07/03/1994");
			usuario.setNascimento(dataNascimento);
			usuario.setNumero(34);
			service.postClient(usuario);
			
			usuario1.setCpf("199.935.980-99");
			usuario1.setEmail("jfksdjfkl.bernardo.defoe@gmail.com");
			usuario1.setNome("Bernardo jsafhjksgf DeFoé");
			usuario1.setEndereco("Rua das Merdas");
			dataNascimento = f.parse("07/08/2008");
			usuario1.setNascimento(dataNascimento);
			usuario1.setNumero(50);
			service.postClient(usuario1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println("---------GET-------------");
		//service.getClient("2");
		
		//System.out.println("---------GET LIST-------------");
		//service.getListClient();
		
		//System.out.println("---------PUT-------------");
		//service.putClient("1", "Oliver da Costa");
		
		//System.out.println("---------DELETE-------------");
		//service.deleteClient("1");
	}

}
