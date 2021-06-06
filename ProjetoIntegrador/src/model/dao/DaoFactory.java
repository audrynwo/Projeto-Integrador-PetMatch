package model.dao;

import db.DB;
import model.dao.impl.AnuncioDaoJDBC;
import model.dao.impl.ConversaDaoJDBC;
import model.dao.impl.EnderecoDaoJDBC;
import model.dao.impl.FavoritosDaoJDBC;
import model.dao.impl.RecadosDaoJDBC;
import model.dao.impl.UsuarioDaoJDBC;

public class DaoFactory {

	public static AnuncioDao createAnuncioDao() {
		return new AnuncioDaoJDBC(DB.getConnection());
	}
	public static EnderecoDao createEnderecoDao() {
		return new EnderecoDaoJDBC(DB.getConnection());
	}
	public static FavoritosDao createFavoritosDao() {
		return new FavoritosDaoJDBC(DB.getConnection());
	}
	public static RecadosDao createRecadosDao() {
		return new RecadosDaoJDBC(DB.getConnection());
	}
	public static UsuarioDao createUsuarioDao() {
		return new UsuarioDaoJDBC(DB.getConnection());
	}
	public static ConversaDao createConversaDao() {
		return new ConversaDaoJDBC(DB.getConnection());
	}
}

