package entities;

import java.io.Serializable;

/**
 * Classe responsavel por representar os favoritos
 * @author Kaiane Ferreira
 * */

public class Favoritos implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFavoritos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favoritos other = (Favoritos) obj;
		if (idFavoritos != other.idFavoritos)
			return false;
		return true;
	}

}
