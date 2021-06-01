package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class UsuarioDaoJDBC implements UsuarioDao {

	private Connection conn;

	public UsuarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Usuario obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO usuario "
							+ "(cpf, email, nome, sobrenome, senha, celular, foto_de_perfil) "
							+ "VALUES "
							+ "(?, ?, ?, ?, ?, ?, ?",
							Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getCpf());
			st.setString(2, obj.getEmail());
			st.setString(3, obj.getSobrenome());
			st.setString(4, obj.getSenha());
			st.setString(5, obj.getCelular());
			st.setString(6, obj.getFotoPerfil());

			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdUsuario(id);
				}
				DB.closeResultSet(rs);
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
	public void update(Usuario obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE usuario "
					+ "SET cpf = ?, email = ?, nome = ?, sobrenome = ?, senha = ?, celular = ?, foto_de_perfil = ? "
					+ "WHERE id_usuario = ?");	
			st.setString(1, obj.getCpf());
			st.setString(2, obj.getEmail());
			st.setString(3, obj.getSobrenome());
			st.setString(4, obj.getSenha());
			st.setString(5, obj.getCelular());
			st.setString(6, obj.getFotoPerfil());
			st.setInt(7, obj.getIdUsuario());
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
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

}
