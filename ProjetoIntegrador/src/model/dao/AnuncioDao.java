package model.dao;

import java.util.List;
import model.entities.Anuncio;

public interface AnuncioDao {
	
	void insert(Anuncio obj);
	void update(Anuncio obj);
	void deleteById(int id);
	List<Anuncio> findByUserInput(String userFilterInput);
	public Anuncio findById(Integer id);
}
