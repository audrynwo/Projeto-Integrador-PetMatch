package entities;

/**
 * Classe responsavel por representar os recados
 * @author Kaiane Ferreira
 * */

public class Recados {
	
	private String titulo;
	private String texto;
	private String midia;
	
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
	
}
