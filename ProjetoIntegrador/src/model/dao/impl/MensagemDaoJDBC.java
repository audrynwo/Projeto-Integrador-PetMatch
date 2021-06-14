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
import model.dao.MensagemDao;
import model.entities.Conversa;
import model.entities.Mensagem;

public class MensagemDaoJDBC implements MensagemDao {
	private Connection conn;

	public MensagemDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	private Mensagem instantiateMensagem(ResultSet rs) throws SQLException {
		Mensagem obj = new Mensagem();
		obj.setIdMensagem(rs.getInt("id_mensagem"));
		obj.setTextoMensagem(rs.getString("texto_mensagem"));
		obj.setDataMensagem((rs.getTimestamp("data_mensagem").toLocalDateTime()));
		obj.getConversa().setIdConversa(rs.getInt("id_conversa"));

		return obj;
	}
	@Override
	public void insert(Mensagem obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO mensagem " 
							+ "(texto_mensagem, data_mensagem, id_conversa) "
							+ "VALUES " 
							+ "(?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getTextoMensagem());
			st.setTimestamp(2, Timestamp.valueOf(obj.getDataMensagem()));
			st.setInt(3, obj.getConversa().getIdConversa());

			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setIdMensagem(id);
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
	public void deleteById(int id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM mensagem WHERE id_mensagem = ?");
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
	public List<Mensagem> findByConversa(Conversa conversa){
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM mensagem WHERE id_conversa = ?");
			st.setInt(1, conversa.getIdConversa());
			rs = st.executeQuery();
			List<Mensagem> mensagemList = new ArrayList<>();
			while(rs.next()) {
				Mensagem obj = instantiateMensagem(rs);
				mensagemList.add(obj);
			}
			return mensagemList;
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
	public Mensagem findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM mensagem WHERE id_mensagem = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Mensagem obj = instantiateMensagem(rs);
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