package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.EnderecoDao;
import model.entities.Endereco;

public class EnderecoDaoJDBC implements EnderecoDao{

	private Connection conn;

	public EnderecoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Endereco obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO usuario "
							+ "(cep, uf, cidade, bairro, rua, numero, complemento) "
							+ "VALUES "
							+ "(?, ?, ?, ?, ?, ?, ?",
							Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getCep());
			st.setString(2, obj.getUf());
			st.setString(3, obj.getCidade());
			st.setString(4, obj.getBairro());
			st.setString(5, obj.getRua());
			st.setInt(6, obj.getNumero());
			st.setString(7, obj.getComplemento());

			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdEndereco(id);
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
	public void update(Endereco obj) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE usuario "
							+ "SET cep = ?, uf = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, complemento = ? "
							+ "WHERE id_usuario = ?");	
			st.setString(1, obj.getCep());
			st.setString(2, obj.getUf());
			st.setString(3, obj.getCidade());
			st.setString(4, obj.getBairro());
			st.setString(5, obj.getRua());
			st.setInt(6, obj.getNumero());
			st.setString(7, obj.getComplemento());
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
			st = conn.prepareStatement("DELETE FROM endereco WHERE id_endereco = ?");
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

	@Override
	public List<Endereco> findByCidade(String cidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
