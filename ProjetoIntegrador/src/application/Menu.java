package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class Menu {

	public static void main(String[] args) {
		//se tu quiser testar o visualizaPerfil() so descomenta as proximas duas linhas linhas:
		Usuario usuario = menuInicial();
		// visualizaPerfil(usuario);
		// menuPrincipal();
		// opcoesDePerfil();
	}

	protected static Usuario menuInicial() {
		
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		Scanner entrada = new Scanner(System.in);
		Usuario usuario = new Usuario();

		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	PetMatch: Te conectando com um animalzinho para adocao!             |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println(" Primeiro passo: Criacao de perfil. Por favor, preencha as informacoes abaixo: ");
		System.out.print(" Seu primeiro nome: ");
		usuario.setNome(entrada.nextLine());
		System.out.print(" Sobrenome: ");
		usuario.setSobrenome(entrada.nextLine());
		System.out.print(" CPF: ");
		usuario.setCpf(entrada.nextLine());
		System.out.print(" Email: ");
		usuario.setEmail(entrada.nextLine());
		System.out.print(" Defina uma senha: ");
		usuario.setSenha(entrada.nextLine());
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	Cadastro registrado com sucesso! :D                                 |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		
		usuarioDao.insert(usuario);
		entrada.close();

		return usuario;
	}
	
	private static void menuPrincipal() {
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|	Bem-Vindo ao menu de opcoes do PetMatch!:         |");
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|    01 - Opcoes de perfil 				  |");
		System.out.println("|    02 - Opcoes de anuncios 			 	  |");
		System.out.println("|    03 - Opcoes de favoritos 			 	  |");
		System.out.println("|    04 - Opcoes de conversa 			 	  |");
		System.out.println("|    05 - Fechar o programa				  |");
		System.out.println("+ ------------------------------------------------------- +");
		
	
	}
	
	private static void opcoesDePerfil() {
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|	Bem-Vindo ao seu perfil!                          |");
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|    00 - Visualizar as informacoes do perfil 		  |");
		System.out.println("|    01 - Para atualizar as informacoes do perfil 	  |");
		System.out.println("|    01 - Para apagar o perfil 	                          |");
		System.out.println("|    03 - Para voltar ao menu principal	 	   	  |");
		System.out.println("|    04 - Fechar o programa				  |");
		System.out.println("+ ------------------------------------------------------- +");
	}
	
	private static void visualizaPerfil(Usuario usuario) {
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("     Visualizacao de perfil:                             ");
		System.out.println(" ");
		System.out.println(usuario);
		System.out.println(" ");
		System.out.println("- ------------------------------------------------------- -");
		System.out.println("|    01 - Para atualizar as informacoes do perfil 	  |");
		System.out.println("|    02 - Para voltar ao menu principal	 	   	  |");
		System.out.println("|    03 - Fechar o programa				  |");
		System.out.println("- ------------------------------------------------------- -");
	}
	
	private static void atualizaPerfil() {
		System.out.println("+ ----------------------------------------- +");
		System.out.println("|	 Atualizacao do perfil:             |");
		System.out.println("+ ----------------------------------------- +");
		System.out.println("|    00 - Atualizar foto de perfil 	    |");
		System.out.println("|    01 - Alterar nome 	                    |");
		System.out.println("|    02 - Alterar sobrenome	 	    |");
		System.out.println("|    03 - Alterar CPF			    |");
		System.out.println("|    04 - Alterar email 		    |");
		System.out.println("|    05 - Alterar senha 	            |");
		System.out.println("|    06 - Alterar celular 	   	    |");
		System.out.println("|    07 - Alterar CPF			    |");
		System.out.println("- ----------------------------------------- -");
		System.out.println("|    11 - Para voltar ao menu principal	    |");
		System.out.println("|    22 - Fechar o programa	            |");
		System.out.println("- ----------------------------------------- -");
	
	}

}


