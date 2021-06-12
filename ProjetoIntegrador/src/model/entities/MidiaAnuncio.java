package model.entities;

public class MidiaAnuncio {

	private int idMidia;
	private Anuncio anuncio;
	private String caminhoMidia; 
	
	public MidiaAnuncio() {
		this.anuncio = new Anuncio();
	}
	
	public MidiaAnuncio(String caminhoMidia) {
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
		MidiaAnuncio other = (MidiaAnuncio) obj;
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

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public String getCaminhoMidia() {
		return caminhoMidia;
	}

	public void setCaminhoMidia(String caminhoMidia) {
		this.caminhoMidia = caminhoMidia;
	}

	@Override
	public String toString() {
		return ("caminhoMidia = " + caminhoMidia);
	}
	
}
