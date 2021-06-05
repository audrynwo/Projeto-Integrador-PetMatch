package application;

import java.util.Scanner;

import model.dao.AnuncioDao;
import model.dao.DaoFactory;
import model.dao.EnderecoDao;
import model.dao.UsuarioDao;
import model.entities.Anuncios;
import model.entities.Endereco;
import model.entities.Usuario;

public class Teste {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

		/** System.out.println("\n=== TESTE 3: delete(usuario obj) sem endereco =====");
		System.out.println("Digitar o ID que vai ser apagado do bd");
		int id = scanner.nextInt();
		usuarioDao.deleteById(id);
		System.out.println("Apaagoouu"); **/

		System.out.println("\n=== TESTE 1: insert(usuario obj) =====");
		Usuario usuario1 = new Usuario("121-121-122-98", "Willow", "Smith", "jadensmith@gmail.com", "1234567");
		usuarioDao.insert(usuario1);
		System.out.println("Primeiro usuario inserido! Id_usuario = " + usuario1.getIdUsuario());

		System.out.println("\n=== TESTE 2: update(usuario obj) =====");
		usuario1 = usuarioDao.findById(usuario1.getIdUsuario());
		usuario1.setFotoPerfil("midia.jpgOverThinkingIT");
		usuarioDao.update(usuario1);
		System.out.println("Update completed");

		/** System.out.println("\n=== TESTE 3: delete(usuario obj) sem endereco =====");
		System.out.println("Digitar o ID que vai ser apagado do bd");
		id = scanner.nextInt();
		usuarioDao.deleteById(id);
		System.out.println("Apaagoouu"); **/

		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
		// String cep, String uf, String cidade, String bairro, String rua, int numero, String complemento, Usuario usuario
		System.out.println("==== TESTE 3: INSERT ENDERECO =====");
		Endereco endereco1 = new Endereco("93218432" , "rs" , "canoas" , "igara" , "tres marias" , 72 , usuario1);
		enderecoDao.insert(endereco1);
		System.out.println("Primeiro usuario inserido! Id_usuario = " + endereco1.getIdEndereco());
		endereco1.setComplemento("casa roxa");
		enderecoDao.update(endereco1);
		System.out.println("Update completed");
		
		
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		System.out.println("==== TESTE 4: INSERT ANUNCIO =====");
		Anuncios anuncio = new Anuncios("Bolinha", "bolinnha.jpgMidia", "fofa", 2, "cao", "shitzu", "feminino", "pequeno", true, true, true, usuario1, endereco1);
		anuncioDao.insert(anuncio);
		System.out.println("Primeiro anuncio cadastrado! Id_anuncio: " + anuncio.getIdAnuncio());
		anuncio.setDescricao("comilona");
		anuncioDao.update(anuncio);
		System.out.println("Atualizado!");

		scanner.close();
	}

}
