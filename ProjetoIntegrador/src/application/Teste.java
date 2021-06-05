package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.EnderecoDao;
import model.dao.UsuarioDao;
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
		System.out.println("==== TESTE 1: INSERT ENDERECO =====");
		Endereco endereco1 = new Endereco("93218432" , "rs" , "canoas" , "igara" , "tres marias" , 72 , usuario1 );
		enderecoDao.insert(endereco1);
		System.out.println("Primeiro usuario inserido! Id_usuario = " + endereco1.getIdEndereco());
		endereco1.setComplemento("casa roxa");
		enderecoDao.update(endereco1);
		System.out.println("Update completed");

		scanner.close();
	}

}
