package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class Menu {

	public static void main(String[] args) {
		menuInicial();

	}

	private static void menuInicial() {
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		Scanner entrada = new Scanner(System.in);
		Usuario usuario = new Usuario();

		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	PetMatch: Te conectando com um animalzinho para adocao!             |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("Primeiro passo: Criacao de perfil. Por favor, preencha as informacoes abaixo: ");
		System.out.print("Seu primeiro nome: ");
		usuario.setNome(entrada.nextLine());
		System.out.print("Sobrenome: ");
		usuario.setSobrenome(entrada.nextLine());
		System.out.print("CPF: ");
		usuario.setCpf(entrada.nextLine());
		System.out.print("Email: ");
		usuario.setEmail(entrada.nextLine());
		System.out.print("Defina uma senha: ");
		usuario.setSenha(entrada.nextLine());
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	Cadastro registrado com sucesso! :D                                 |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		usuarioDao.insert(usuario);
		entrada.close();
	}

}

