package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.AnuncioDao;
import model.entities.Anuncio;
import model.entities.Usuario;

public class AnuncioDaoJDBC implements AnuncioDao {

	private Connection conn;

	public AnuncioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	private Anuncio instantiateAnuncio(ResultSet rs) throws SQLException {
		Anuncio obj = new Anuncio();
		obj.setIdAnuncio(rs.getInt("id_anuncio"));
		obj.setDescricao(rs.getString("descricao"));
		obj.setNomeDoAnimal(rs.getString("nome_do_animal"));
		obj.setEspecie(rs.getString("especie"));
		obj.setRaca(rs.getString("raca"));
		obj.setGenero(rs.getString("genero"));
		obj.setPorte(rs.getString("porte"));
		obj.setIdade(rs.getString("idade"));
		obj.setDataAnuncio(rs.getTimestamp("data_anuncio").toLocalDateTime());
		obj.getAutor().setIdUsuario(rs.getInt("id_usuario"));
		obj.getEndereco().setIdEndereco(rs.getInt("id_endereco"));
		obj.setStatusAdocao(rs.getBoolean("status_adocao"));
		obj.setStatusVacinacao(rs.getBoolean("status_vacinacao"));
		obj.setStatusCastracao(rs.getBoolean("status_castracao"));
		obj.setStatusVermifugo(rs.getBoolean("status_vermifugo"));

		return obj;
	}

	@Override
	public void insert(Anuncio obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO anuncio " 
							+ "(nome_do_animal, descricao, data_anuncio, idade, especie, "
							+ "raca, genero, porte, status_vacinacao, status_castracao, "
							+ "status_vermifugo, status_adocao, id_usuario, id_endereco) "
							+ "VALUES " 
							+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNomeDoAnimal());
			st.setString(2, obj.getDescricao());
			st.setTimestamp(3, Timestamp.valueOf(obj.getDataAnuncio()));
			st.setString(4, obj.getIdade());
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
	public void update(Anuncio obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE anuncio "
							+ "SET nome_do_animal = ?, descricao = ?, "
							+ "data_anuncio = ?, idade = ?, especie = ?, "
							+ "raca = ?, genero = ?, porte = ?, "
							+ "status_vacinacao = ?, status_castracao = ?, "
							+ "status_vermifugo = ?, status_adocao = ?, id_usuario = ?, "
							+ " id_endereco = ? WHERE id_anuncio = ?");	
			st.setString(1, obj.getNomeDoAnimal());
			st.setString(2, obj.getDescricao());
			st.setTimestamp(3, Timestamp.valueOf(obj.getDataAnuncio()));
			st.setString(4, obj.getIdade());
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
			st.setInt(15, obj.getIdAnuncio());
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
	public Anuncio findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM anuncio WHERE id_anuncio = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Anuncio obj = instantiateAnuncio(rs);
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

	@Override
	public List<Anuncio> findByUserInput(String userFilterInput) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(userFilterInput);
			rs = st.executeQuery();
			List<Anuncio> filterList = new ArrayList<>();
			while(rs.next()) {
				Anuncio obj = instantiateAnuncio(rs);
				filterList.add(obj);
			}
			return filterList;
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
	public List<Anuncio> findByUserId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM anuncio WHERE id_usuario = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			List<Anuncio> filterList = new ArrayList<>();
			while(rs.next()) {
				Anuncio obj = instantiateAnuncio(rs);
				filterList.add(obj);
			}
			return filterList;
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
	public List<Anuncio> getAllAnuncios() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM anuncio");
			rs = st.executeQuery();
			List<Anuncio> filterList = new ArrayList<>();
			while(rs.next()) {
				Anuncio obj = instantiateAnuncio(rs);
				filterList.add(obj);
			}
			return filterList;
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
	public List<Anuncio> findAnunciosFavoritados(Usuario obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Anuncio> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT a.* FROM favorito f INNER JOIN anuncio a ON f.id_anuncio = a.id_anuncio WHERE f.id_usuario = ?");
			st.setInt(1, obj.getIdUsuario());
			rs = st.executeQuery();
			while(rs.next()) {
				Anuncio anuncio = new Anuncio();
				anuncio.setIdAnuncio(rs.getInt("id_anuncio"));
				anuncio.setDescricao(rs.getString("descricao"));
				anuncio.setNomeDoAnimal(rs.getString("nome_do_animal"));
				anuncio.setEspecie(rs.getString("especie"));
				anuncio.setRaca(rs.getString("raca"));
				anuncio.setGenero(rs.getString("genero"));
				anuncio.setPorte(rs.getString("porte"));
				anuncio.setIdade(rs.getString("idade"));
				anuncio.setDataAnuncio(rs.getTimestamp("data_anuncio").toLocalDateTime());
				anuncio.getAutor().setIdUsuario(rs.getInt("id_usuario"));
				anuncio.getEndereco().setIdEndereco(rs.getInt("id_endereco"));
				anuncio.setStatusAdocao(rs.getBoolean("status_adocao"));
				anuncio.setStatusVacinacao(rs.getBoolean("status_vacinacao"));
				anuncio.setStatusCastracao(rs.getBoolean("status_castracao"));
				anuncio.setStatusVermifugo(rs.getBoolean("status_vermifugo"));
				list.add(anuncio);
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

}
