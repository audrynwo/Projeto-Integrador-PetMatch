package entities;

/**
 * Classe responsavel por representar os favoritos
 * @author Kaiane Ferreira
 * */

public class Favoritos {

	private int idFavoritos;
	private Usuario usuario;
	private Anuncios anuncio;

	public Favoritos(Usuario usuario, Anuncios anuncio) {
		this.usuario = usuario;
		this.anuncio = anuncio;
	}

	public int getIdFavoritos() {
		return idFavoritos;
	}

	public void setIdFavoritos(int idFavoritos) {
		this.idFavoritos = idFavoritos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Anuncios getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncios anuncio) {
		this.anuncio = anuncio;
	}
	
}
