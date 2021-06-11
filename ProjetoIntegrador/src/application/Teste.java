package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.AnuncioDao;
import model.dao.ConversaDao;
import model.dao.DaoFactory;
import model.dao.EnderecoDao;
import model.dao.FavoritoDao;
import model.dao.MensagemDao;
import model.dao.MidiaDao;
import model.dao.RecadosDao;
import model.dao.UsuarioDao;
import model.entities.Anuncio;
import model.entities.Conversa;
import model.entities.Endereco;
import model.entities.Favorito;
import model.entities.Mensagem;
import model.entities.MidiaAnuncio;
import model.entities.Recados;
import model.entities.Usuario;


public class Teste {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int id = 41;

		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
		AnuncioDao anuncioDao = DaoFactory.createAnuncioDao();
		FavoritoDao favoritoDao = DaoFactory.createFavoritosDao();
		RecadosDao recadosDao = DaoFactory.createRecadosDao();
		MidiaDao midiaDao = DaoFactory.createMidiaDao();
		ConversaDao conversaDao = DaoFactory.createConversaDao();
		MensagemDao mensagemDao = DaoFactory.createMensagemDao();


		System.out.println("\n=== TESTE 1: insert(usuario obj) =====");
		Usuario usuario1 = new Usuario("989-876-543-21", "Willow", "Smith", "willowsmithE@gmail.com", "1234567");
		usuarioDao.insert(usuario1);
		System.out.println("Usuario inserido! Id_usuario: " + usuario1.getIdUsuario()); 

		/**System.out.println("\n=== TESTE 2: insert(usuario obj) =====");
		Usuario usuario2 = new Usuario("321-654-987-21", "Jaden", "Smith", "c.syresmith@gmail.com", "1234567");
		usuarioDao.insert(usuario2);
		System.out.println("Usuario inserido! Id_usuario: " + usuario2.getIdUsuario());  **/
		
		System.out.println("\n=== TESTE DELETE USUARIO 1 =====");
		System.out.println("Digite o ID dO USUARIO que sera apagado do bd: ");
		id = scanner.nextInt();
		usuarioDao.deleteById(id);
		System.out.println("======== usuario apagado! =====");
		
		/**System.out.println("\n=== TESTE DELETE USUARIO 2 =====");
		System.out.println("Digite o ID dO USUARIO que sera apagado do bd: ");
		id = scanner.nextInt();
		usuarioDao.deleteById(id);
		System.out.println("======== usuario apagado! =====");

		System.out.println("\n=== TESTE CONVERSA =====");
		Conversa conversaU = new Conversa(usuario1, usuario2);
		conversaDao.insert(conversaU);
		System.out.println("id_conversa " + conversaU.getIdConversa()); 


		System.out.println("TESTE INSERT MENSAGEM");
		Mensagem mensagemU = new Mensagem("oi!" , conversaU);
		mensagemDao.insert(mensagemU);	
		System.out.println("id_mensagem " + mensagemU.getIdMensagem()); 
		System.out.println(mensagemU.getTextoMensagem());

		System.out.println("\n=== TESTE DELETE MENSAGEM =====");
		System.out.println("Digite o ID da MENSAGEM que sera apagada do bd: ");
		id = scanner.nextInt();
		mensagemDao.deleteById(id);
		System.out.println("======== mensagem apagada! ====="); 

		//String cep, String uf, String cidade, String bairro, String rua, int numero, String complemento, Usuario usuario
		System.out.println("\n==== TESTE 2: INSERT ENDERECO =====");
		Endereco endereco1 = new Endereco("9321-8432" , "rs" , "canoas" , "igara" , "tres marias" , 72 , usuario1);
		enderecoDao.insert(endereco1); 

		List<MidiaAnuncio> midias = new ArrayList<>();
		midias.add(new MidiaAnuncio("midia1.jpg"));
		midias.add(new MidiaAnuncio("midia2.jpg"));
		midias.add(new MidiaAnuncio("midia3.jpg"));
		midias.add(new MidiaAnuncio("midia2.jpg"));
		midias.add(new MidiaAnuncio("midia3.jpg"));
		midias.add(new MidiaAnuncio("midia3.jpg"));

		System.out.println("\n==== TESTE: INSERT ANUNCIO =====");
		Anuncio anuncio = new Anuncio("Bolinha", midias, "fofa", 2, "ave", "andorinha", "feminino", "pequeno", true, true, true, usuario1, endereco1);
		anuncioDao.insert(anuncio);
		System.out.println("Anuncio cadastrado! Id_anuncio: " + anuncio.getIdAnuncio());
		System.out.println("\n ==== INSERT MIDIA ANUNCIO ===");
		for(int i = 0; i < midias.size(); i++) {
			midias.get(i).setAnuncio(anuncio);
			midiaDao.insert(midias.get(i));
			System.out.println("Midia cadastrada! Id_midia: " + midias.get(i).getIdMidia());
		}

		System.out.println("\n==== TESTE: INSERT ANUNCIO 1 =====");
		Anuncio anuncio1 = new Anuncio("Bola", midias, "comilao", 2, "suina", "porco", "masculino", "medio", true, true, true, usuario1, endereco1);
		anuncioDao.insert(anuncio1);
		System.out.println("Anuncio cadastrado! Id_anuncio: " + anuncio.getIdAnuncio());
		System.out.println("\n ==== INSERT MIDIA ANUNCIO 1 ===");
		for(int i = 0; i < midias.size(); i++) {
			midias.get(i).setAnuncio(anuncio1);
			midiaDao.insert(midias.get(i));
			System.out.println("Midia cadastrada! Id_midia: " + midias.get(i).getIdMidia());
		}

		System.out.println("\n==== TESTE: INSERT ANUNCIO 2 =====");
		Anuncio anuncio2 = new Anuncio("Nuna", midias, "preguicosa", 2, "peixe", "tulipa", "feminino", "pequeno", true, true, true, usuario1, endereco1);
		anuncioDao.insert(anuncio2);
		System.out.println("Anuncio cadastrado! Id_anuncio: " + anuncio.getIdAnuncio());

		System.out.println("\n ==== INSERT MIDIA ANUNCIO 2 ===");
		for(int i = 0; i < midias.size(); i++) {
			midias.get(i).setAnuncio(anuncio2);
			midiaDao.insert(midias.get(i));
			System.out.println("Midia cadastrada! Id_midia: " + midias.get(i).getIdMidia()); 
		}

		String userFilterInput = "SELECT * FROM anuncio WHERE porte LIKE ";
		
		userFilterInput = userFilterInput + scanner.nextLine();
		List <Anuncio> anuncioList = anuncioDao.findByUserInput(userFilterInput);

		for(int i = 0; i < anuncioList.size(); i++) {
			System.out.println("Anuncios encontrados: ");
			System.out.println(anuncioList.get(i).getNomeDoAnimal()); 
		} **/

		System.out.println("====== Fim do programa!! =======");
		scanner.close();
	}

}
