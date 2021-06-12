package application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.AnuncioDao;
import model.dao.DaoFactory;
import model.dao.EnderecoDao;
import model.dao.FavoritoDao;
import model.dao.MidiaDao;
import model.dao.UsuarioDao;
import model.entities.Anuncio;
import model.entities.Endereco;
import model.entities.MidiaAnuncio;
import model.entities.Usuario;

public class Menu {

	public static void main(String[] args) {

		// WilliwSmith@gmail.com 1234567 id no banco == 6
		// jadensmith10@gmail.com 1234567 id no nanco == 15
		// "jadensmith928@gmail.com", "1234567" id no banco == 59
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
		Endereco endereco = enderecoDao.findById(33);
		Usuario usuario = usuarioDao.login("jadensmith928@gmail.com", "1234567");

		visualizarAnuncios();

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
		System.out.println("+ ------------------------------------------- +");
		System.out.println("   Visualizacao das informacoes de endereco:    ");
		System.out.println(endereco);
		System.out.println("+ ------------------------------------------- +");
		System.out.println("|    01 - Para atualizar as informacoes       |");
		System.out.println("|    02 - Para voltar ao menu principal       |");
		System.out.println("|    03 - Fechar o programa                   |");
		System.out.println("+ ------------------------------------------- +");
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

	private static void cadastraEndereco(Usuario usuario) {
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
		Scanner entrada = new Scanner(System.in);
		Endereco endereco = new Endereco();

		endereco.setUsuario(usuario);

		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	PetMatch: Te conectando com um animalzinho para adocao!             |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println(" Para o cadastro do endereco preencha as informacoes abaixo: ");
		System.out.print(" CEP: ");
		endereco.setCep(entrada.nextLine());
		System.out.print(" Estado: ");
		endereco.setUf(entrada.nextLine());
		System.out.print(" Cidade: ");
		endereco.setCidade(entrada.nextLine());
		System.out.print(" Bairro: ");
		endereco.setBairro(entrada.nextLine());
		System.out.print(" Rua: ");
		endereco.setRua(entrada.nextLine());
		System.out.print(" Numero: ");
		endereco.setNumero(entrada.nextInt());
		System.out.print(" Complemento: ");
		endereco.setComplemento(entrada.nextLine());
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	Cadastro registrado com sucesso! :D                                 |");
		System.out.println("+ ------------------------------------------------------------------------- +");

		enderecoDao.insert(endereco);

		entrada.close();
	}

	private static void opcoesDeAnuncio() {
		System.out.println("+ -------------------------------------- +");
		System.out.println("|    Bem-Vindo as opcoes de anuncio!     |");
		System.out.println("+ -------------------------------------- +");
		System.out.println("|    00 - Visualizar todos os anuncios   |");
		System.out.println("|    01 - Criar Anuncio                  |");
		System.out.println("|    01 - Acesso aos meus anuncios       |");
		System.out.println("|    03 - Para voltar ao menu principal  |");
		System.out.println("|    04 - Fechar o programa              |");
		System.out.println("+ -------------------------------------- +");
	}

	private static void cadastrarAnuncio(Endereco endereco, Usuario autor) {

		Scanner entrada = new Scanner(System.in);

		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		Anuncio anuncio = new Anuncio();

		anuncio.setAutor(autor);
		anuncio.setEndereco(endereco);
		
		//fazer verificacao do endereco

		System.out.println("+ ----------------------------------------- +");
		System.out.println("|    Preencha TODAS as informacoes abaixo:  |");
		System.out.println("+ ----------------------------------------- +");
		System.out.print("    Insira o nome do seu animalzinho: ");
		anuncio.setNomeDoAnimal(entrada.nextLine());
		System.out.print("    Escreva uma descricao: ");
		anuncio.setDescricao(entrada.nextLine());
		System.out.print("    Idade (apenas em números): ");
		anuncio.setIdade(entrada.nextInt());
		entrada.nextLine();
		System.out.print("    Especie: ");
		anuncio.setEspecie(entrada.nextLine());
		System.out.print("    Raca: ");
		anuncio.setRaca(entrada.nextLine());
		System.out.print("    Genero: ");
		anuncio.setGenero(entrada.nextLine());
		System.out.print("    Porte (pequeno/medio/grande): ");
		anuncio.setPorte(entrada.nextLine());
		System.out.println("    Status de Vacinacao: ");
		System.out.print("    Digite true para SIM e false para NAO: ");
		anuncio.setStatusVacinacao(entrada.nextBoolean());
		entrada.nextLine();
		System.out.println("    Status de Castracao: ");
		System.out.print("    Digite true para SIM e false para NAO: ");
		anuncio.setStatusCastracao(entrada.nextBoolean());
		entrada.nextLine();
		System.out.println("    Status de Vermifugo: ");
		System.out.print("    Digite true para SIM e false para NAO: ");
		anuncio.setStatusVermifugo(entrada.nextBoolean());
		entrada.nextLine();

		MidiaDao midiaDao = DaoFactory.createMidiaDao();
		List<MidiaAnuncio> midiaList = new ArrayList<>();
		System.out.print("\nAdicionando midias: ");

		int confirma = 1;
		while(confirma < 2) {
			System.out.println("Digite o caminho da midia (max: 5 midias): ");
			midiaList.add(new MidiaAnuncio(entrada.nextLine()));

			if(midiaList.size() < 5) {
				System.out.println("Adicionar outra midia? SIM (1) NAO (2)");
				confirma = entrada.nextInt();
				entrada.nextLine();
			} else 
				break;
		}

		System.out.println("Midias adicionadas!");
		anuncio.setMidia(midiaList);

		anuncio.setDataAnuncio(LocalDateTime.now());
		anuncioDao.insert(anuncio);

		System.out.println(" ");
		System.out.println("Anuncio Cadastrado!");
		System.out.println(anuncio);

		for(int i = 0; i < midiaList.size(); i++) {
			midiaList.get(i).setAnuncio(anuncio);
			midiaDao.insert(midiaList.get(i));
		}

		System.out.println("+ -------------------------------------- +");

		entrada.close();
	}

	private static void visualizarMeusAnuncios(Usuario usuario) {
		Scanner entrada = new Scanner (System.in);
		int userAnswer = 0;
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		List <Anuncio> anuncioList = anuncioDao.findByUserId(usuario.getIdUsuario());
		if(anuncioList != null) {
			System.out.println("   Anuncios encontrados: ");
			for(int i = 0; i < anuncioList.size(); i++) {
				System.out.println("   Anuncio " + anuncioList.get(i).getIdAnuncio() + ":");
				System.out.println(anuncioList.get(i));
				System.out.println("");
			}
		} else {
			System.out.println("Nenhum anuncio foi encontrado!");
		}
		entrada.close();
	}

	private static void visualizarAnuncios() {
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		List <Anuncio> anuncioList = anuncioDao.getAllAnuncios();

		if(anuncioList != null) {
			for(Anuncio anuncio : anuncioList) {
				System.out.println("   Anuncio " + anuncio.getIdAnuncio() + ":");
				System.out.println(anuncio);
				System.out.println(" ");
			}
		} else {
			System.out.println("Ainda não temos anuncios publicados!");
			System.out.println("Seja o primeiro a criar um anuncio!");
		}

	}
	
	private static void visualizarFavoritos(Usuario usuario) {
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		List<Anuncio> listFavorito = anuncioDao.findAnunciosFavoritados(usuario);
		if(listFavorito != null) {
			for(Anuncio anuncio : listFavorito) {
				System.out.println("   Anuncio " + anuncio.getIdAnuncio() + ":");
				System.out.println(anuncio);
				System.out.println(" ");
			}
		} else {
			System.out.println("Voce ainda nao possui anuncios favoritados");
		}

	}
	
}


