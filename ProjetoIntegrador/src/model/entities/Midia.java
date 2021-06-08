package model.entities;

public class Midia {

	//ideal é que essa lista de midia estivesse na classe de anuncio, sendo cada elemento um obj de midia
	private int idMidia;
	private Anuncios anuncio;
	private String caminhoMidia; 
	
	public Midia() {
		
	}
	
	public Midia(String caminhoMidia) {
		this.caminhoMidia = caminhoMidia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMidia;
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
		Midia other = (Midia) obj;
		if (idMidia != other.idMidia)
			return false;
		return true;
	}

	public int getIdMidia() {
		return idMidia;
	}

	public void setIdMidia(int idMidia) {
		this.idMidia = idMidia;
	}

	public Anuncios getAnuncio() {
		return anuncio;
	}

	public void setIdAnuncio(Anuncios anuncio) {
		this.anuncio = anuncio;
	}

	public String getCaminhoMidia() {
		return caminhoMidia;
	}

	public void setCaminhoMidia(String caminhoMidia) {
		this.caminhoMidia = caminhoMidia;
	}
	
}
