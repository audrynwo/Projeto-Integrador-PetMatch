package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.AnuncioDao;
import model.entities.Anuncios;


public class AnuncioDaoJDBC implements AnuncioDao {

	private Connection conn;

	public AnuncioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Anuncios obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO anuncio " 
							+ "(nome_do_animal, descricao, data_anuncio, idade, especie, raca, genero, porte, status_vacinanao, status_castracao, status_vermifugo, status_adocao, id_usuario, id_endereco) "
							+ "VALUES " 
							+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)",
							Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNomeDoAnimal());
			st.setString(2, obj.getDescricao());
			st.setTimestamp(3, obj.getDataAnuncio());
			st.setInt(4, obj.getIdade());
			st.setString(5, obj.getEspecie());
			st.setString(6, obj.getRaca());
			st.setString(7, obj.getGenero());
			st.setString(8, obj.getPorte());
			st.setBoolean(9, obj.isStatusVacinacao());
			st.setBoolean(10, obj.isStatusCastracao());
			st.setBoolean(11, obj.isStatusVermifugo());
			st.setBoolean(12, obj.isStatusAdocao());
			st.setInt(13, obj.getAutor().getIdUsuario());
			st.setInt(14, obj.getEndereco().getIdEndereco());
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setIdAnuncio(id);
				}
				DB.closeResultSet(rs);
			} else {
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
	public void update(Anuncios obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE anuncio "
					+ "SET nome_do_animal = ?, descricao = ?, data_anuncio = ?, idade = ?, especie = ?, raca = ?, genero = ?, porte = ?, status_vacinacao = ?, status_castracao = ?, status_vermifugo = ?, status_adocao = ?, id_usuario = ?, id_endereco = ?,"
					+ "WHERE id_usuario = ?");	
			st.setString(1, obj.getNomeDoAnimal());
			st.setString(2, obj.getDescricao());
			st.setTimestamp(3, obj.getDataAnuncio());
			st.setInt(4, obj.getIdade());
			st.setString(5, obj.getEspecie());
			st.setString(6, obj.getRaca());
			st.setString(7, obj.getGenero());
			st.setString(8, obj.getPorte());
			st.setBoolean(9, obj.isStatusVacinacao());
			st.setBoolean(10, obj.isStatusCastracao());
			st.setBoolean(11, obj.isStatusVermifugo());
			st.setBoolean(12, obj.isStatusAdocao());
			st.setInt(13, obj.getAutor().getIdUsuario());
			st.setInt(14, obj.getEndereco().getIdEndereco());
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
			st = conn.prepareStatement("DELETE FROM anuncio WHERE id_anuncio = ?");
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
	public List<Anuncios> findByEspecie(String especie) {
		// TODO Auto-generated method stub
		return null;
	} 


}
