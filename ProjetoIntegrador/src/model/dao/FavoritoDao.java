package model.dao;

import java.util.List;
import model.entities.Favorito;

public interface FavoritoDao {
	void insert(Favorito obj);
	void deleteById(int id);
	List<Favorito> findFavorito(Favorito obj);
	public Favorito findById(Integer id);

}
