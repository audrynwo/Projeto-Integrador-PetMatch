package model.dao;

import java.util.List;
import model.entities.Anuncios;

public interface AnuncioDao {
	
	void insert(Anuncios obj);
	void update(Anuncios obj);
	void deleteById(int id);
	List<Anuncios> findByUserInput(String especie);
}
