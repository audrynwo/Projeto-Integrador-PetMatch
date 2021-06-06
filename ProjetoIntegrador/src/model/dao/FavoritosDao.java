package model.dao;

import java.util.List;
import model.entities.Favoritos;

public interface FavoritosDao {
	void insert(Favoritos obj);
	void deleteById(int id);
	List<Favoritos> findFavorito(Favoritos obj);
	public Favoritos findById(Integer id);

}
