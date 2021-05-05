package entities;

/**
 * Classe responsável por representar os usuários
 * @author Kaiane Ferreira
 * */

import java.time.LocalDate;

public class Conversa {
	
	private LocalDate data;
	private String mensagem;
	private Usuario usuarioRemetente;
	private Usuario usuarioDestinatario;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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
	public LocalDate getData() {
		return data;
	}
	
}
