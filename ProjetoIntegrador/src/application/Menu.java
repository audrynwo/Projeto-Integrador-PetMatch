package application;

import java.util.Scanner;
import model.entities.Usuario;

public class Menu {
	
	public static void main(String[] args) {
		menuInicial();
		
	}

	private static void menuInicial() {
		
		Scanner entrada = new Scanner(System.in);
		Usuario usuario = new Usuario();
				
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	PetMatch: Te conectando com um animalzinho para adoção!                 |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	Primeiro passo: Criação de perfil. Por favor, preencha as               |");
		System.out.println("| informações abaixo:                                                       |");
		System.out.println("+   Seu primeiro nome:						                                +");
		usuario.setNome(entrada.nextLine());
		System.out.println("+   Sobrenome:							                                    +");
		usuario.setSobrenome(entrada.nextLine());
		System.out.println("+   Email:");
	}
	
}

/** 

|    Sobrenome:							   |
|    Email: 								   |
|    Defina uma senha: 						   |
------------------------------------------------------------------------ +
 **/