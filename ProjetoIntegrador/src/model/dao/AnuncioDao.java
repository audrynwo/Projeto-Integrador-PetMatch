package model.dao;

import java.util.List;
import model.entities.Anuncio;
import model.entities.Usuario;

public interface AnuncioDao {
	
	void insert(Anuncio obj);
	void update(Anuncio obj);
	void deleteById(int id);
	public Anuncio findById(Integer id);
	public List<Anuncio> findByUserInput(String userFilterInput);
	public List<Anuncio> findByUserId(Integer id);
	public List<Anuncio> getAllAnuncios();
	List<Anuncio> findAnunciosFavoritados(Usuario obj);
}
