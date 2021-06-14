package model.dao;

import java.util.List;

import model.entities.Conversa;
import model.entities.Mensagem;

public interface MensagemDao {
	void insert(Mensagem obj);
	void deleteById(int id);
	public Mensagem findById(Integer id);
	public List<Mensagem> findByConversa(Conversa conversa);
}
