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
import model.dao.ConversaDao;
import model.entities.Conversa;
import model.entities.Usuario;

public class ConversaDaoJDBC implements ConversaDao {
	private Connection conn;

	public ConversaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	private Conversa instantiateConversa(ResultSet rs) throws SQLException {
		Conversa obj = new Conversa();
		obj.setIdConversa(rs.getInt("id_conversa"));
		obj.getUsuarioRemetente().setIdUsuario(rs.getInt("id_usuario_remetente"));
		obj.getUsuarioDestinatario().setIdUsuario(rs.getInt("id_usuario_destinatario"));

		return obj;
	}

	@Override
	public void insert(Conversa obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO conversa "
							+ "(id_usuario_remetente, id_usuario_destinatario) "
							+ "VALUES "
							+ "(?, ?)",
							Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getUsuarioRemetente().getIdUsuario());
			st.setInt(2, obj.getUsuarioDestinatario().getIdUsuario());

			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdConversa(id);
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
	public void deleteById(int id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM conversa WHERE id_conversa = ?");
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
	public Conversa findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM conversa WHERE id_conversa = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Conversa obj = instantiateConversa(rs);
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
	public List<Conversa> findByUsuario(Usuario usuario) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM conversa WHERE id_usuario_remetente = ?");
			st.setInt(1, usuario.getIdUsuario());
			rs = st.executeQuery();
			List<Conversa> conversaList = new ArrayList<>();
			while(rs.next()) {
				Conversa obj = instantiateConversa(rs);
				conversaList.add(obj);
			}
			return conversaList;
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
