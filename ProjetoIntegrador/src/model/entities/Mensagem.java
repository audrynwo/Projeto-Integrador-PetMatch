package model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mensagem implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idMensagem;
	private String textoMensagem;
	private LocalDateTime dataMensagem;
	private Conversa conversa;

	public Mensagem() {
		this.conversa = new Conversa();
	}
	public Mensagem(String textoMensagem, Conversa conversa) {
		this.textoMensagem = textoMensagem;
		dataMensagem = LocalDateTime.now();
		this.conversa = conversa;
	}
	public int getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}
	public String getTextoMensagem() {
		return textoMensagem;
	}
	public void setTextoMensagem(String texto_mensagem) {
		this.textoMensagem = texto_mensagem;
	}
	public LocalDateTime getDataMensagem() {
		return dataMensagem;
	}
	public void setDataMensagem(LocalDateTime data_mensagem) {
		this.dataMensagem = data_mensagem;
	}
	public Conversa getConversa() {
		return conversa;
	}
	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMensagem;
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
		Mensagem other = (Mensagem) obj;
		if (idMensagem != other.idMensagem)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return ("texto_mensagem = " + textoMensagem + "\n data_mensagem = " + dataMensagem + "\n conversa = "
				+ conversa);
	}

}