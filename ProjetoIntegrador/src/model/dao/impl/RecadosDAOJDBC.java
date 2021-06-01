package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.RecadosDao;
import model.entities.Recados;

public class RecadosDAOJDBC implements RecadosDao {

	Connection conn;

	public RecadosDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Recados obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO recado " +
					" (titulo, texto, midia) VALUES " + 
					"(?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getTitulo());
			st.setString(2, obj.getTexto());
			st.setString(3, obj.getMidia());

			int rowsAffected = st.executeUpdate();

			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setIdRecados(id);
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
	public void update(Recados obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE recado " + " SET titulo = ?, texto = ?, midia = ?"
					+ " WHERE id_recado = ?");
			st.setString(1, obj.getTitulo());
			st.setString(2, obj.getTexto());
			st.setString(3, obj.getMidia());
			
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
					"DELETE FROM recado WHERE id_recado = ?");
			
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
