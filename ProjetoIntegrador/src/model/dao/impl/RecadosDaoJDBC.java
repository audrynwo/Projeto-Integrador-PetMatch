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
import model.entities.Usuario;

public class RecadosDaoJDBC implements RecadosDao {

	Connection conn;

	public RecadosDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	private Recados instantiateRecados(ResultSet rs) throws SQLException {
		Recados obj = new Recados();
		obj.setIdRecados(rs.getInt("id_recado"));
		obj.setTitulo(rs.getString("titulo"));
		obj.setTexto(rs.getString("texto"));
		obj.setMidia(rs.getString("midia"));

		return obj;
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
	@Override
	public Recados findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM usuario WHERE id_recado = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Recados obj = instantiateRecados(rs);
				return obj;
			}
			return null;
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeResultSet(rs);
		}
	}
}
