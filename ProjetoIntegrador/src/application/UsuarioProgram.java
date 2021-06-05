package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class UsuarioProgram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		
		/** System.out.println("\n=== TESTE 3: delete(usuario obj) sem endereco =====");
		System.out.println("Digitar o ID que vai ser apagado do bd");
		int id = scanner.nextInt();
		usuarioDao.deleteById(id);
		System.out.println("Apaagoouu ^~^"); **/
		
		System.out.println("\n=== TESTE 1: insert(usuario obj) =====");
		Usuario usuario1 = new Usuario("121-121-122-12", "Willow", "Smith", "WilliwSmith@gmail.com", "1234567");
		usuarioDao.insert(usuario1);
		System.out.println("Primeiro usuário inserido! Id_usuário = " + usuario1.getIdUsuario());
		
		System.out.println("\n=== TESTE 2: update(usuario obj) =====");
		usuario1 = usuarioDao.findById(usuario1.getIdUsuario());
		usuario1.setFotoPerfil("midia.jpgOverThinkingIT");
		usuarioDao.update(usuario1);
		System.out.println("Update completed");
		
		/** System.out.println("\n=== TESTE 3: delete(usuario obj) sem endereco =====");
		System.out.println("Digitar o ID que vai ser apagado do bd");
		id = scanner.nextInt();
		usuarioDao.deleteById(id);
		System.out.println("Apaagoouu ^~^"); **/

		
		scanner.close();
	}

}
