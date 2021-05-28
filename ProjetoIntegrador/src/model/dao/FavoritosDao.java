package model.dao;

import model.entities.Favoritos;

public interface FavoritosDao {
	void insert(Favoritos obj);
	void deleteById(int id);
}
