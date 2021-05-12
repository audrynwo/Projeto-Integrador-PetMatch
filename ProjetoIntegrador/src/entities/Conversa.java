package entities;

/**
 * Classe responsavel por representar a conversa entre usuarios
 * @author Kaiane Ferreira
 * */

import java.time.LocalDate;

public class Conversa {

	private LocalDate dataMensagem;
	private Usuario usuarioRemetente;
	private Usuario usuarioDestinatario;
	private String mensagem;

	public Conversa(Usuario usuarioRemetente, Usuario usuarioDestinatario, String mensagem) {
		this.usuarioRemetente = usuarioRemetente;
		this.usuarioDestinatario = usuarioRemetente;
		this.mensagem = mensagem;
		dataMensagem = LocalDate.now(); 
	}

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
	public LocalDate getDataMensagem() {
		return dataMensagem;
	}

}