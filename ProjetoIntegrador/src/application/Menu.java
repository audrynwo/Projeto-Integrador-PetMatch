package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.EnderecoDao;
import model.dao.UsuarioDao;
import model.entities.Endereco;
import model.entities.Usuario;

public class Menu {

	public static void main(String[] args) {
		
		// WilliwSmith@gmail.com 1234567 id no banco == 6
		// jadensmith10@gmail.com 1234567 id no nanco == 15
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
		//Usuario usuario = usuarioDao.login("WilliwSmith@gmail.com", "1234567");
		Endereco endereco = enderecoDao.findById(4);
		Usuario usuario = usuarioDao.findById(endereco.getUsuario().getIdUsuario());
		endereco.setUsuario(usuario);
		visualizaEnderecoInfo(endereco); 
		
	}

	
	private static void menuInicial() {
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	PetMatch: Te conectando com um animalzinho para adocao!             |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	O “PetMatch” é uma proposta de sistema para adoção de animais,	    |");
		System.out.println("| com o objetivo de criar caminhos  mais curtos e eficientes entre as duas  |");
		System.out.println("| pontas do processo de adoção (o doador e o adotante), proporcionando uma  |");
		System.out.println("| adoção responsável para os animaizinhos que precisam de uma família!      |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|   	Já possui cadastro?						    |");
		System.out.println("|	1 - Sim. Fazer login.						    |");
		System.out.println("|	2 - Não. Quero realizar meu cadastro!			            |");
		System.out.println("+ ------------------------------------------------------------------------- +");
	}
	
	protected static Usuario cadastraUsuario() {
		
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		Scanner entrada = new Scanner(System.in);
		Usuario usuario = new Usuario();

		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	PetMatch: Te conectando com um animalzinho para adocao!             |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println(" Para a criacao do perfil preencha as informacoes abaixo: ");
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
		System.out.println("|    02 - Opcoes de endereco 			 	  |");
		System.out.println("|    02 - Opcoes de anuncios 			 	  |");
		System.out.println("|    03 - Acesso aos anuncios favoritos 	          |");
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
	
	private static void opcoesDeEndereco() {
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|	Bem-Vindo as opcoes de endereco!                  |");
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|    00 - Visualizar as informacoes de endereco 	  |");
		System.out.println("|    01 - Para atualizar as informacoes de endereco 	  |");
		System.out.println("|    01 - Para remover o endereco	                  |");
		System.out.println("|    03 - Para voltar ao menu principal	 	   	  |");
		System.out.println("|    04 - Fechar o programa				  |");
		System.out.println("+ ------------------------------------------------------- +");
	}

	private static void visualizaEnderecoInfo(Endereco endereco) {
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("     Visualizacao das inforacoes de endereco:                             ");
		System.out.println(" ");
		System.out.println(endereco);
		System.out.println(" ");
		System.out.println("- ------------------------------------------------------- -");
		System.out.println("|    01 - Para atualizar as informacoes 	  |");
		System.out.println("|    02 - Para voltar ao menu principal	 	   	  |");
		System.out.println("|    03 - Fechar o programa				  |");
		System.out.println("- ------------------------------------------------------- -");
	}
	
	private static void atualizaEndereco() {
		System.out.println("+ ----------------------------------------- +");
		System.out.println("|	 Atualizacao de endereco:           |");
		System.out.println("+ ----------------------------------------- +");
		System.out.println("|    00 - Atualizar CEP 	            |");
		System.out.println("|    01 - Alterar estado 	            |");
		System.out.println("|    02 - Alterar cidade 	            |");
		System.out.println("|    03 - Alterar bairro	            |");
		System.out.println("|    04 - Alterar rua		            |");
		System.out.println("|    05 - Alterar numero 	            |");
		System.out.println("|    06 - Alterar complemento 	   	    |");
		System.out.println("- ----------------------------------------- -");
		System.out.println("|    11 - Para voltar ao menu principal	    |");
		System.out.println("|    22 - Fechar o programa	            |");
		System.out.println("- ----------------------------------------- -");
	
	} 

}


