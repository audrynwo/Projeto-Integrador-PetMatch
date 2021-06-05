package model.dao.impl;

import java.sql.Connection;
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

}
