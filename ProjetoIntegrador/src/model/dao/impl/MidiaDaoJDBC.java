package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.MidiaDao;
import model.entities.MidiaAnuncio;

public class MidiaDaoJDBC implements MidiaDao{

	private Connection conn;

	public MidiaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	private MidiaAnuncio instantiateMidia(ResultSet rs) throws SQLException {
		MidiaAnuncio obj = new MidiaAnuncio();
		obj.setCaminhoMidia(rs.getString("caminho_midia"));
		obj.getAnuncio().setIdAnuncio(rs.getInt("id_anuncio"));
		obj.setIdMidia(rs.getInt("id_midia"));
		return obj;
	}

	@Override
	public void insert(MidiaAnuncio obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO midia " 
							+ "(caminho_midia, id_anuncio) " + "VALUES "
							+ "(?, ?)",
							Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getCaminhoMidia());
			st.setInt(2, obj.getAnuncio().getIdAnuncio()); 

			int rowsAffected = st.executeUpdate();

			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setIdMidia(id);
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
	public void update(MidiaAnuncio obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE midia "
							+ "SET caminho_midia = ?, id_anuncio = ? "
							+ "WHERE id_midia = ?");	
			st.setString(1, obj.getCaminhoMidia());
			st.setInt(2, obj.getAnuncio().getIdAnuncio());
			st.setInt(3, obj.getIdMidia());
			
			st.executeUpdate();
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
					"DELETE FROM midia WHERE id_midia = ?");

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
	public MidiaAnuncio findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM midia WHERE id_midia = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				MidiaAnuncio obj = instantiateMidia(rs);
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
