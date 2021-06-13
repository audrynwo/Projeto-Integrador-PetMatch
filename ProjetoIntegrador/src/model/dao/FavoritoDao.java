package model.dao;

import model.entities.Anuncio;
import model.entities.Favorito;
import model.entities.Usuario;

public interface FavoritoDao {
	void insert(Favorito obj);
	void deleteByUserAndAnuncioId(Usuario usuario, Anuncio anuncio);
	public Favorito findById(Integer id);

}
