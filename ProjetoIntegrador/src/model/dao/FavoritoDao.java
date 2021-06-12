package model.dao;

import model.entities.Favorito;

public interface FavoritoDao {
	void insert(Favorito obj);
	void deleteById(int id);
	public Favorito findById(Integer id);

}
