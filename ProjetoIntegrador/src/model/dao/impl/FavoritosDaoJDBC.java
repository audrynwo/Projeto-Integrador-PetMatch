package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.FavoritosDao;
import model.entities.Favoritos;

public class FavoritosDaoJDBC implements FavoritosDao {

	private Connection conn;

	public FavoritosDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	private Favoritos instantiateFavoritos(ResultSet rs) throws SQLException {
		Favoritos obj = new Favoritos();
		obj.setIdFavoritos(rs.getInt("id_favorito"));
		obj.getAnuncio().setIdAnuncio(rs.getInt("id_anuncio"));
		obj.getUsuario().setIdUsuario(rs.getInt("id_usuario"));
		return obj;
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

	@Override
	public List<Favoritos> findFavorito(Favoritos obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT id_anuncio FROM favorito WHERE id_usuario = ?");
			st.setInt(1, obj.getUsuario().getIdUsuario());
			rs = st.executeQuery();
			List<Favoritos> list = new ArrayList<>();
			while(rs.next()) {
				obj.getAnuncio().setIdAnuncio(rs.getInt("id_anuncio"));;
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	@Override
	public Favoritos findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM favorito WHERE id_favorito = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Favoritos obj = instantiateFavoritos(rs);
				return obj;
			}
			return null;
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

}
