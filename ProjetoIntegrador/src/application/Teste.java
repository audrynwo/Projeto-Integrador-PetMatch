package application;

import java.util.List;
import java.util.Scanner;

import model.dao.AnuncioDao;
import model.dao.DaoFactory;
import model.dao.EnderecoDao;
import model.dao.FavoritosDao;
import model.dao.RecadosDao;
import model.dao.UsuarioDao;
import model.entities.Anuncios;
import model.entities.Endereco;
import model.entities.Favoritos;
import model.entities.Recados;
import model.entities.Usuario;

public class Teste {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		FavoritosDao favoritoDao = DaoFactory.createFavoritosDao();
		RecadosDao recadosDao = DaoFactory.createRecadosDao();

		/**System.out.println("\n=== TESTE 1: insert(usuario obj) =====");
		Usuario usuario1 = new Usuario("121-121-122-83", "Willow", "Smith", "jadensmithsks@gmail.com", "1234567");
		usuarioDao.insert(usuario1);
		System.out.println("Primeiro usuario inserido! Id_usuario = " + usuario1.getIdUsuario());

		System.out.println(usuario1);

		System.out.println("\n=== TESTE 2: update(usuario obj) =====");
		usuario1 = usuarioDao.findById(usuario1.getIdUsuario());
		usuario1.setFotoPerfil("midia.jpgOverThinkingIT");
		usuarioDao.update(usuario1);
		System.out.println("Update completed"); 

		String cep, String uf, String cidade, String bairro, String rua, int numero, String complemento, Usuario usuario
		System.out.println("\n==== TESTE 3: INSERT ENDERECO =====");
		Endereco endereco1 = new Endereco("9321-8432" , "rs" , "canoas" , "igara" , "tres marias" , 72 , usuario1);
		enderecoDao.insert(endereco1);
		System.out.println("Endereco inserido! Id_endereco = " + endereco1.getIdEndereco());
		endereco1.setComplemento("casa roxa");
		enderecoDao.update(endereco1);
		System.out.println("Update completed");

		System.out.println("\n==== TESTE 4: INSERT ANUNCIO =====");
		Anuncios anuncio = new Anuncios("Bolinha", "bolinnha.jpgMidia", "fofa", 2, "cao", "shitzu", "feminino", "pequeno", true, true, true, usuario1, endereco1);
		anuncioDao.insert(anuncio);
		System.out.println("Primeiro anuncio cadastrado! Id_anuncio: " + anuncio.getIdAnuncio());
		anuncio.setDescricao("comilona");
		anuncioDao.update(anuncio);
		System.out.println("Atualizado!");

		System.out.println("\n==== TESTE 5: INSERT FAVORITOS =====");
		Favoritos favorito = new Favoritos(usuario1, anuncio);
		favoritoDao.insert(favorito);
		System.out.println("Primeiro anuncio favorito! Id_favorito: " + favorito.getIdFavoritos());

		List<Favoritos> list = favoritoDao.findFavorito(favorito);
		for (Favoritos obj : list) {
			System.out.println("anuncio favoritado " + obj);
		}
		System.out.println("\n==== TESTE DELETE FAVORITOS =====");
		favoritoDao.deleteById(favorito.getIdFavoritos());

		//string titulo string texto e string midia
		System.out.println("\n==== TESTE 5: INSERT RECADO =====");
		Recados recado = new Recados("cao para adocao amigavel", "amo muito meu doguinho mas n tenho mais espaco em casa", "lucy.jpgMidia");
		recadosDao.insert(recado);
		System.out.println("Primeiro recado cadastrado! Id_recado: " + recado.getIdRecados());
		recado.setMidia("caoFofo.jpgMidia");
		recadosDao.update(recado);
		System.out.println("Atualizado!"); 

		System.out.println("\n=== TESTE 1: delete(recados obj) sem endereco =====");
		System.out.println("Digite o ID do RECADO que sera apagado do bd: ");
		int id = scanner.nextInt();
		recadosDao.deleteById(id);
		System.out.println("======== Recado apaagado! ====="); 

		System.out.println("\n=== TESTE 2: delete(anuncio obj) =====");
		System.out.println("Digite o ID do ANUNCIO que vai ser apagado do bd: ");
		id = scanner.nextInt();
		anuncioDao.deleteById(id);
		System.out.println("======== Anuncio apaagado!========="); 

		System.out.println("\n=== TESTE 3: delete(endereco obj) =====");
		System.out.println("Digite o ID do ENDERECO que sera apagado do bd: ");
		id = scanner.nextInt();
		enderecoDao.deleteById(id);
		System.out.println("===== Endereco apaagado! ====="); 

		System.out.println("\n=== TESTE 4: delete(usuario obj) =====");
		System.out.println("Digite o ID do USUARIO que sera apagado do bd: ");
		id = scanner.nextInt();
		usuarioDao.deleteById(id);
		System.out.println("===== Usuario apaagado! ====="); 

		System.out.println("====== Fim do programa!! =======");
		System.out.println("O CRUD ATUAL FUNCIONA!!! :D");
		 */

		scanner.close();
	}

}
