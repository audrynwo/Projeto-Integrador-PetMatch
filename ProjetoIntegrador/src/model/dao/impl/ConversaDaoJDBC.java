package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import model.dao.ConversaDao;
import model.entities.Conversa;

public class ConversaDaoJDBC implements ConversaDao {
	private Connection conn;

	public ConversaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Conversa obj) {
		PreparedStatement st = null;

	}

	@Override
	public void update(Conversa obj) {

	}

	@Override
	public void deleteById(int id) {

	}

	@Override
	public List<Conversa> findByIdUsuario(String id) {
		return null;
	}

	@Override
	public Conversa findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
