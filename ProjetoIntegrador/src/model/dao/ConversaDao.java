package model.dao;

import java.util.List;

import model.entities.Conversa;

public interface ConversaDao {
	void insert(Conversa obj);
	void update(Conversa obj);
	void deleteById(int id);
	public Conversa findById(Integer id);
	List<Conversa> findByIdUsuario(String id );
}
