package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.FavoritosDao;
import model.entities.Favoritos;

public class FavoritosDAOJDBC implements FavoritosDao {

	private Connection conn;
	
	public FavoritosDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Favoritos obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO favorito " 
			+ "(id_usuario, id_anuncio) " + "VALUES "
			+ "(?, ?)",
			Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getUsuario().getIdUsuario());
			st.setInt(2, obj.getAnuncio().getIdAnuncio());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setIdFavoritos(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(int id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"DELETE FROM favorito WHERE id_anuncio = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

}
