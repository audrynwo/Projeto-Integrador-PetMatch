package model.dao;

import model.entities.Endereco;

public interface EnderecoDao {
	void insert(Endereco obj);
	void update(Endereco obj);
	void deleteById(int id);
	public Endereco findById(Integer id);
}
