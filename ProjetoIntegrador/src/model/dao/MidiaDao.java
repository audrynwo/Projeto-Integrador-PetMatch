package model.dao;

import java.util.List;

import model.entities.MidiaAnuncio;

public interface MidiaDao {
	void insert(MidiaAnuncio obj);
	void update(MidiaAnuncio obj);
	void deleteById(int id);
	public MidiaAnuncio findById(Integer id);
	public List<MidiaAnuncio> findByAnuncioId(Integer id);
}
