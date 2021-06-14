package model.dao;

import java.util.List;

import model.entities.Conversa;
import model.entities.Usuario;

public interface ConversaDao {
	void insert(Conversa obj);
	void deleteById(int id);
	public Conversa findById(Integer id);
	List<Conversa> findByUsuario(Usuario usuario);
}
