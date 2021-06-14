package model.entities;

import java.io.Serializable;

/**
 * Classe responsavel por representar a conversa entre usuarios
 * @author Kaiane Ferreira
 * */


public class Conversa implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idConversa;
	private Usuario usuarioRemetente;
	private Usuario usuarioDestinatario;

	public Conversa() {
		this.usuarioRemetente = new Usuario();
		this.usuarioDestinatario = new Usuario();
	}
	
	public Conversa(Usuario usuarioRemetente, Usuario usuarioDestinatario) {
		this.usuarioRemetente = usuarioRemetente;
		this.usuarioDestinatario = usuarioDestinatario;
	}

	public Usuario getUsuarioRemetente() {
		return usuarioRemetente;
	}
	public void setUsuarioRemetente(Usuario usuarioRemetente) {
		this.usuarioRemetente = usuarioRemetente;
	}
	public Usuario getUsuarioDestinatario() {
		return usuarioDestinatario;
	}
	public void setUsuarioDestinatario(Usuario usuarioDestinatario) {
		this.usuarioDestinatario = usuarioDestinatario;
	}

	public int getIdConversa() {
		return idConversa;
	}

	public void setIdConversa(int idConversa) {
		this.idConversa = idConversa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idConversa;
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
		Conversa other = (Conversa) obj;
		if (idConversa != other.idConversa)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ( "\nUsuario Remetente: " + usuarioRemetente
				+ "\nUsuario Destinatario: " + usuarioDestinatario + "\nId da Conversa: " + idConversa);
	}

}