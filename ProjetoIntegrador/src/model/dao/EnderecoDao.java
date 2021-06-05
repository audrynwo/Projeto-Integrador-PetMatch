package model.dao;

import model.entities.Endereco;
import java.util.List;

public interface EnderecoDao {
	void insert(Endereco obj);
	void update(Endereco obj);
	void deleteById(int id);
	List<Endereco> findByCidade(String cidade);
	public Endereco findById(Integer id);
}
