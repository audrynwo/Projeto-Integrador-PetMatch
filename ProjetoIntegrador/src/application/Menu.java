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
import model.dao.RecadosDao;
import model.dao.UsuarioDao;
import model.entities.Anuncio;
import model.entities.Endereco;
import model.entities.Favorito;
import model.entities.MidiaAnuncio;
import model.entities.Recados;
import model.entities.Usuario;

public class Menu {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

		Endereco endereco = new Endereco();
		Usuario usuario = new Usuario();

		menuInicial();
		int userAnswer = entrada.nextInt();
		entrada.nextLine();
		switch(userAnswer) {
		case 1:
			while(true) {
				System.out.print("Digite o seu e-mail: ");
				String email = entrada.nextLine();
				System.out.print("Digite sua senha: ");
				String senha = entrada.nextLine();
				usuario = usuarioDao.login(email, senha);
				if(usuario != null )
					break;
				else {
					System.out.println("Senha ou e-mail incorreto. Por favor, tente novamente.");
				}
			}																						
			break;
		case 2:
			usuario = cadastraUsuario();
			System.out.println(" ");
			System.out.println(" ...");
			System.out.println("Falta só mais um pouquinho para completar seu cadastro... ;D");
			System.out.println(" ...");
			System.out.println(" ");
			endereco = cadastraEndereco(usuario);
			break;
		}

		if(userAnswer == 1) {
			endereco = enderecoDao.findByUserId(usuario.getIdUsuario());
		}

		while(true) {
			menuPrincipal();
			System.out.println(" ");
			System.out.println("Sua resposta: ");
			while(!entrada.hasNextInt()) {
				entrada.next();
			} 
			//String userInput = entrada.nextLine();
			//userAnswer = Integer.parseInt(userInput);

			userAnswer = entrada.nextInt();
			if(userAnswer == 55)
				break;

			System.out.println(" ");
			switch (userAnswer) {
			case(1):
				opcoesDePerfil(usuario);
			break;
			case(2):
				opcoesDeEndereco(endereco);
			break;
			case(3):
				opcoesDeAnuncio(endereco, usuario);
			break;
			case(4):
				visualizarFavoritos(usuario);
			break;
			case(5):
				break;
			case(6):
				apagaPerfil(usuario, endereco);
			break;
			case(55):
				break;
			}
		}
		entrada.close();
	}

	private static void menuInicial() {
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	PetMatch: Te conectando com um animalzinho para adocao!             |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	O PetMatch eh uma proposta de sistema para adocao de animais,	    |");
		System.out.println("| com o objetivo de criar caminhos  mais curtos e eficientes entre as duas  |");
		System.out.println("| pontas do processo de adocao (o doador e o adotante), proporcionando uma  |");
		System.out.println("| adocao responsavel para os animaizinhos que precisam de uma familia!      |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|   	Ja possui cadastro?						    |");
		System.out.println("|	1 - Sim! Fazer login.						    |");
		System.out.println("|	2 - Nao, mas quero realizar meu cadastro!			            |");
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

		return usuario;
	}

	private static Endereco cadastraEndereco(Usuario usuario) {
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
		entrada.nextLine();
		System.out.print(" Complemento: ");
		endereco.setComplemento(entrada.nextLine());
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println("|	Cadastro registrado com sucesso! :D                                 |");
		System.out.println("+ ------------------------------------------------------------------------- +");
		System.out.println(" ");

		enderecoDao.insert(endereco);
		return endereco;
	}

	private static void menuPrincipal() {
		System.out.println(" ");
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|	Bem-Vindo ao menu de opcoes do PetMatch!:         |");
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|     1 - Opcoes de perfil 				  |");
		System.out.println("|     2 - Opcoes de endereco 			 	  |");
		System.out.println("|     3 - Opcoes de anuncios 			 	  |");
		System.out.println("|     4 - Acesso aos anuncios favoritos 	          |");
		System.out.println("|     5 - Opcoes de conversa 			 	  |");
		System.out.println("|     6 - Excluir perfil 			     	  |");
		System.out.println("|    55 - Fechar o programa				  |");
		System.out.println("+ ------------------------------------------------------- +");
	}

	private static void opcoesDePerfil(Usuario usuario) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|	Bem-Vindo ao seu perfil!                          |");
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|     1 - Visualizar as informacoes do perfil 		  |");
		System.out.println("|     2 - Para atualizar as informacoes do perfil 	  |");
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println(" ");
		System.out.print("Sua resposta: ");
		int userAnswer = entrada.nextInt();
		System.out.println(" ");
		switch (userAnswer) {
		case(1):
			visualizaPerfil(usuario);
		break;
		case(2):
			atualizaPerfil(usuario);
		break;
		}
	}

	private static void opcoesDeEndereco(Endereco endereco) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|	Bem-Vindo as opcoes de endereco!                  |");
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("|     1 - Visualizar as informacoes de endereco 	  |");
		System.out.println("|     2 - Para atualizar as informacoes de endereco 	  |");
		System.out.println("|     3 - Para remover o endereco	                  |");
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println(" ");
		System.out.print("Sua resposta: ");
		int userAnswer = entrada.nextInt();
		System.out.println(" ");
		switch (userAnswer) {
		case(1):
			visualizaEnderecoInfo(endereco);
		break;
		case(2):
			atualizaEndereco(endereco);
		break;
		case(3):
			removeEndereco(endereco);
		break;
		}
	}

	private static void visualizaPerfil(Usuario usuario) {
		System.out.println("+ ------------------------------------------------------- +");
		System.out.println("     Visualizacao de perfil:                             ");
		System.out.println(" ");
		System.out.println(usuario);
		System.out.println(" ");
		System.out.println("- ------------------------------------------------------- -");
	}

	private static void visualizaEnderecoInfo(Endereco endereco) {
		System.out.println("+ ------------------------------------------- +");
		System.out.println("   Visualizacao das informacoes de endereco:    ");
		System.out.println(endereco);
		System.out.println(" ");
		System.out.println("+ ------------------------------------------- +");
	}

	private static void atualizaPerfil(Usuario usuario) {
		Scanner entrada = new Scanner(System.in); 
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		System.out.println("+ ----------------------------------------- +");
		System.out.println("|	 Atualizacao do perfil:             |");
		System.out.println("+ ----------------------------------------- +");
		System.out.println("|     1 - Atualizar foto de perfil 	    |");
		System.out.println("|     2 - Alterar nome 	                    |");
		System.out.println("|     3 - Alterar sobrenome	 	    |");
		System.out.println("|     4 - Alterar CPF			    |");
		System.out.println("|     5 - Alterar email 		    |");
		System.out.println("|     6 - Alterar senha 	            |");
		System.out.println("|     7 - Alterar celular 	   	    |");
		System.out.println("- ----------------------------------------- -");

		System.out.print("Sua resposta: ");
		int userAnswer = entrada.nextInt();
		entrada.nextLine();
		if(userAnswer == 1) {
			System.out.print("Nova informacao: ");
			usuario.setFotoPerfil(entrada.nextLine());
		} else if (userAnswer == 2) {
			System.out.print("Nova informacao: ");
			usuario.setNome(entrada.nextLine());
		} else if (userAnswer == 3) {
			System.out.print("Nova informacao: ");
			usuario.setSobrenome(entrada.nextLine());
		} else if (userAnswer == 4) {
			System.out.print("Nova informacao: ");
			usuario.setCpf(entrada.nextLine());
		} else if (userAnswer == 5) {
			System.out.print("Nova informacao: ");
			usuario.setEmail(entrada.nextLine());
		} else if (userAnswer == 6) {
			System.out.print("Nova informacao: ");
			usuario.setSenha(entrada.nextLine());
		} else if (userAnswer == 7) {
			System.out.print("Nova informacao: ");
			usuario.setCelular(entrada.nextLine());
		} else if (userAnswer == 8) {
			System.out.print("Nova informacao: ");
			usuario.setNome(entrada.nextLine());
		} 
		usuarioDao.update(usuario);
		System.out.println("Infomacao atualizada!");
		System.out.println(" ");

	}

	private static void atualizaEndereco(Endereco endereco) {
		Scanner entrada = new Scanner(System.in);
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao(); 
		System.out.println("+ ----------------------------------------- +");
		System.out.println("|	 Atualizacao de endereco:           |");
		System.out.println("+ ----------------------------------------- +");
		System.out.println("|     1 - Atualizar CEP 	            |");
		System.out.println("|     2 - Alterar estado 	            |");
		System.out.println("|     3 - Alterar cidade 	            |");
		System.out.println("|     4 - Alterar bairro	            |");
		System.out.println("|     5 - Alterar rua		            |");
		System.out.println("|     6 - Alterar numero 	            |");
		System.out.println("|     7 - Alterar complemento 	   	    |");
		System.out.println("- ----------------------------------------- -");

		System.out.print("Sua resposta: ");
		int userAnswer = entrada.nextInt();
		entrada.nextLine();
		if(userAnswer == 1) {
			System.out.print("Nova informacao: ");
			endereco.setCep(entrada.nextLine());
		} else if (userAnswer == 2) {
			System.out.print("Nova informacao: ");
			endereco.setUf(entrada.nextLine());
		} else if (userAnswer == 3) {
			System.out.print("Nova informacao: ");
			endereco.setCidade(entrada.nextLine());
		} else if (userAnswer == 4) {
			System.out.print("Nova informacao: ");
			endereco.setBairro(entrada.nextLine());
		} else if (userAnswer == 5) {
			System.out.print("Nova informacao: ");
			endereco.setRua(entrada.nextLine());
		} else if (userAnswer == 6) {
			System.out.print("Nova informacao: ");
			endereco.setNumero(entrada.nextInt());
		} else if (userAnswer == 7) {
			System.out.print("Nova informacao: ");
			endereco.setComplemento(entrada.nextLine());
		} 
		enderecoDao.update(endereco);
		System.out.println("Infomacao atualizada!");
	}

	private static void apagaPerfil(Usuario usuario, Endereco endereco) {
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
		MidiaDao midiaDao = DaoFactory.createMidiaDao();
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();

		List <Anuncio> anuncioList = anuncioDao.findByUserId(usuario.getIdUsuario());
		for(int i = 0; i < anuncioList.size(); i++) {
			anuncioList.get(i).setMidia(midiaDao.findByAnuncioId(anuncioList.get(i).getIdAnuncio()));
			for(int j = 0; j < anuncioList.get(i).getMidia().size(); j++) {
				MidiaAnuncio midia = anuncioList.get(i).getMidia().get(j);
				midiaDao.deleteById(midia.getIdMidia());
			}
			anuncioDao.deleteById(anuncioList.get(i).getIdAnuncio());
		}

		enderecoDao.deleteById(endereco.getIdEndereco());
		usuarioDao.deleteById(usuario.getIdUsuario());
		System.out.println("Perfil apagado!");
	}

	private static void removeEndereco(Endereco endereco) {
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
		MidiaDao midiaDao = DaoFactory.createMidiaDao();

		List <Anuncio> anuncioList = anuncioDao.findByUserId(endereco.getUsuario().getIdUsuario());
		for(int i = 0; i < anuncioList.size(); i++) {
			anuncioList.get(i).setMidia(midiaDao.findByAnuncioId(anuncioList.get(i).getIdAnuncio()));
			for(int j = 0; j < anuncioList.get(i).getMidia().size(); j++) {
				MidiaAnuncio midia = anuncioList.get(i).getMidia().get(j);
				midiaDao.deleteById(midia.getIdMidia());
			}
			anuncioDao.deleteById(anuncioList.get(i).getIdAnuncio());
		}

		enderecoDao.deleteById(endereco.getIdEndereco());
		System.out.println("Endereco apagado!");
	}

	private static void opcoesDeAnuncio(Endereco endereco, Usuario usuario) {
		Scanner entrada = new Scanner(System.in);
		int userAnswer = 0;

		System.out.println("+ -------------------------------------- +");
		System.out.println("|    Bem-Vindo as opcoes de anuncio!     |");
		System.out.println("+ -------------------------------------- +");
		System.out.println("|     1 - Visualizar todos os anuncios   |");
		System.out.println("|     2 - Criar Anuncio                  |");
		System.out.println("|     3 - Acesso aos meus anuncios       |");
		System.out.println("|     4 - Para voltar ao menu principal  |");
		System.out.println("+ -------------------------------------- +");

		System.out.println(" ");
		System.out.println("Digite sua resposta: ");
		userAnswer = entrada.nextInt();
		entrada.nextLine();

		switch(userAnswer){
		case 1:
			visualizarAnuncios(usuario);
			break;

		case 2:
			cadastrarAnuncio(endereco, usuario);
			break;
		case 3:
			visualizarMeusAnuncios(usuario);
			break;
		case 4:
			break;
		}
	}

	private static void cadastrarAnuncio(Endereco endereco, Usuario autor) { 
		Scanner entrada = new Scanner(System.in);

		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		Anuncio anuncio = new Anuncio();

		anuncio.setAutor(autor);
		anuncio.setEndereco(endereco);

		System.out.println("+ ----------------------------------------- +");
		System.out.println("|    Preencha TODAS as informacoes abaixo:  |");
		System.out.println("+ ----------------------------------------- +");
		System.out.print("    Insira o nome do seu animalzinho: ");
		anuncio.setNomeDoAnimal(entrada.nextLine());
		System.out.print("    Escreva uma descricao: ");
		anuncio.setDescricao(entrada.nextLine());
		System.out.print("    Idade (especifique se é em anos, meses, semanas ou dias): ");
		anuncio.setIdade(entrada.nextLine());
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
	}

	private static void visualizarMeusAnuncios(Usuario usuario) {
		Scanner entrada = new Scanner (System.in);
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		MidiaDao midiaDao = DaoFactory.createMidiaDao();
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		List <Anuncio> anuncioList = anuncioDao.findByUserId(usuario.getIdUsuario());

		if(anuncioList != null) {
			for(Anuncio anuncio : anuncioList) {
				anuncio.setAutor(usuarioDao.findById(anuncio.getAutor().getIdUsuario()));
			}
			System.out.println("   Anuncios encontrados ");
			System.out.println(" ");
			for(int i = 0; i < anuncioList.size(); i++) {
				System.out.println("   Anuncio publicado por: " + anuncioList.get(i).getAutor().getNome() 
						+ anuncioList.get(i).getAutor().getSobrenome());
				System.out.println(anuncioList.get(i));
				System.out.println(" ");
				System.out.println("   Atualizar o anuncio (1)");
				System.out.println("   Deletar anuncio (2)");
				System.out.println("   Visualizar o proximo (3)");
				System.out.print("   Digite sua resposta: ");
				int userAnswer = entrada.nextInt();
				System.out.println(" ");

				if(userAnswer == 1) {
					while(userAnswer != 5) {
						atualizaAnuncio(anuncioList.get(i));
						System.out.println(" ");
						System.out.println("Anuncio atualizado!");
						System.out.println(" ");
						System.out.println("Fazer outra atualizacao?");
						System.out.print("SIM (4), NÃO (5)");
						userAnswer = entrada.nextInt();
						entrada.nextLine();
					} 
				} else if (userAnswer == 2) {
					anuncioList.get(i).setMidia(midiaDao.findByAnuncioId(anuncioList.get(i).getIdAnuncio()));
					for(int j = 0; j < anuncioList.get(i).getMidia().size(); j++) {
						MidiaAnuncio midia = anuncioList.get(i).getMidia().get(j);
						midiaDao.deleteById(midia.getIdMidia());
					}
					anuncioDao.deleteById(anuncioList.get(i).getIdAnuncio());
					System.out.println("Anuncio excluido.");
				}
			}
		} else {
			System.out.println("Voce nao criou nenhum anuncio ainda!");
		}
	}

	private static void visualizarAnuncios(Usuario usuario) {
		Scanner entrada = new Scanner(System.in);
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		RecadosDao recadosDao = DaoFactory.createRecadosDao();
		FavoritoDao favoritoDao = DaoFactory.createFavoritosDao();
		List <Anuncio> anuncioList = anuncioDao.getAllAnuncios();
		int cont = 0;
		int contId = 0;
		if(anuncioList != null) {
			for(Anuncio anuncio : anuncioList) {
				anuncio.setAutor(usuarioDao.findById(anuncio.getAutor().getIdUsuario()));
			}
			for(Anuncio anuncio : anuncioList) {
				System.out.println("   Anuncio publicado por: " + anuncio.getAutor().getNome() 
						+ anuncio.getAutor().getSobrenome());
				System.out.println(anuncio);
				System.out.println(" ");
				System.out.println("   (1) Favoritar anuncio");
				System.out.println("   (2) Visuaizar proximo anuncio");
				System.out.print("   Digite sua resposta: ");
				int userAnswer = entrada.nextInt();
				entrada.nextLine();
				System.out.println(" ");
				
				if(userAnswer == 1) {
					Favorito favorito = new Favorito(usuario, anuncio);
					favoritoDao.insert(favorito);
					System.out.println(" ");
					System.out.println("Anuncio Favoritado!");
					System.out.println(" ");
				}
				cont++;
				if(cont %3 == 0) {
					Recados recados = new Recados();
					System.out.println(" ");
					recados = recadosDao.findById(contId);
					System.out.println(recados);
					System.out.println(" ");
					contId++;
				}
			}
		} else {
			System.out.println("Ainda nao temos anuncios publicados!");
			System.out.println("Seja o primeiro a criar um anuncio!");
		}

	}

	private static void visualizarFavoritos(Usuario usuario) {
		Scanner entrada = new Scanner(System.in);
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		FavoritoDao favoritoDao = DaoFactory.createFavoritosDao();
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		List<Anuncio> listFavorito = anuncioDao.findAnunciosFavoritados(usuario);
		System.out.println("Bem vindo aos anuncios favoritos!");
		System.out.println(" ");
		if(listFavorito.size() > 0) {
			for(Anuncio anuncio : listFavorito) {
				anuncio.setAutor(usuarioDao.findById(anuncio.getAutor().getIdUsuario()));
			}
			for(Anuncio anuncio : listFavorito) {
				System.out.println("   Anuncio publicado por: " + anuncio.getAutor().getNome() 
						+ anuncio.getAutor().getSobrenome());
				System.out.println(anuncio);
				System.out.println(" ");
				System.out.println("   Remover anuncio dos favoritos?");
				System.out.println("   Desfavoritar anuncio (1)");
				System.out.println("   Proximo anuncio (2)");
				System.out.print("   Digite sua resposta: ");
				int userAnswer = entrada.nextInt();
				System.out.println(" ");
				
				if(userAnswer == 1) {
					favoritoDao.deleteByUserAndAnuncioId(usuario, anuncio);
					System.out.println("   Anuncio removido dos favoritos!");
					System.out.println("   Próximo anuncio: ");
					System.out.println(" ");
				}
			}
		} else {
			System.out.println("Voce ainda nao possui anuncios favoritados");
			System.out.println(" ");
		}
	}

	private static void atualizaAnuncio(Anuncio anuncio) {
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		Usuario usuario = usuarioDao.findById(anuncio.getAutor().getIdUsuario());
		Scanner entrada = new Scanner(System.in);

		System.out.println(" ");
		System.out.println("+ -------------------------------------- +");
		System.out.println("|	 Atualizacao de anuncio:         |");
		System.out.println("+ -------------------------------------- +");
		System.out.println("|     1 - Alterar nome do pet            |");
		System.out.println("|     2 - Alterar descricao              |");
		System.out.println("|     3 - Alterar idade                  |");
		System.out.println("|     4 - Alterar especie                |");
		System.out.println("|     5 - Alterar raca                   |");
		System.out.println("|     6 - Alterar genero                 |");
		System.out.println("|     7 - Alterar porte                  |");
		System.out.println("|     8 - Status de Vacinacao            |");
		System.out.println("|     9 - Status de Castracao            |");
		System.out.println("|    10 - Status do Vermifugo		 |");
		System.out.println("- -------------------------------------- -");

		System.out.println(" ");
		System.out.print("Sua resposta: ");
		int userAnswer = entrada.nextInt();
		entrada.nextLine();
		System.out.println(" ");
		switch(userAnswer) {
		case(1):
			System.out.print("Novo nome: ");
		anuncio.setNomeDoAnimal(entrada.nextLine());
		anuncioDao.update(anuncio);
		break;
		case(2):
			System.out.print("Nova descricao: ");
		anuncio.setDescricao(entrada.nextLine());
		anuncioDao.update(anuncio);
		break;
		case(3):
			System.out.print("Nova idade: ");
		anuncio.setIdade(entrada.nextLine());
		entrada.nextLine();
		anuncioDao.update(anuncio);
		break;
		case(4):
			System.out.print("Defina a especie: ");
		anuncio.setEspecie(entrada.nextLine());
		anuncioDao.update(anuncio);
		break;
		case(5):
			System.out.print("Defina a raca: ");
		anuncio.setRaca(entrada.nextLine());
		anuncioDao.update(anuncio);
		break;
		case(6):
			System.out.print("Defina o genero: ");
		anuncio.setGenero(entrada.nextLine());
		anuncioDao.update(anuncio);
		break;
		case(7):
			System.out.print("Defina o porte: ");
		anuncio.setPorte(entrada.nextLine());
		anuncioDao.update(anuncio);
		break;
		case(8):
			System.out.print("Status de Vacinacao: digite true para SIM e false para NAO:");
		anuncio.setStatusVacinacao(entrada.nextBoolean());
		anuncioDao.update(anuncio);
		break;
		case(9):
			System.out.print("Status de Castracao: digite true para SIM e false para NAO:");
		anuncio.setStatusCastracao(entrada.nextBoolean());
		anuncioDao.update(anuncio);
		break;
		case(10):
			System.out.print("Status de Vermifugo: digite true para SIM e false para NAO:");
		anuncio.setStatusVermifugo(entrada.nextBoolean());
		anuncioDao.update(anuncio);
		break;
		}
	}
}


