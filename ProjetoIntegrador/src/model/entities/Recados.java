package model.entities;

import java.io.Serializable;

/**
 * Classe responsavel por representar os recados
 * @author Kaiane Ferreira
 * */

public class Recados implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idRecados;
	private String titulo;
	private String texto;
	private String midia;

	public Recados() {
	}

	public Recados(String titulo, String texto, String midia) {
		this.titulo = titulo;
		this.texto = texto;
		this.midia = midia;
	}

	public Recados(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public int getIdRecados() {
		return idRecados;
	}

	public void setIdRecados(int idRecados) {
		this.idRecados = idRecados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRecados;
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
		Recados other = (Recados) obj;
		if (idRecados != other.idRecados)
			return false;
		return true;
	}

}
