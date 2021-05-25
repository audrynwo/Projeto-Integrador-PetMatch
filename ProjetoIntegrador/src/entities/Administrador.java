package entities;

/**
 *Classe responsavel por representar o Administrador que tambem e um Usuario
 * @author Audryn Weber de Oliveira
 * */
public class Administrador extends Usuario {

	private boolean alteraStatusAnuncio;

	public Administrador(String nome, String sobrenome, String email, String senha) {
		super(nome, sobrenome, email, senha);
	}

	public void setStatusPerfil(boolean statusPerfil) {
		this.statusPerfil = statusPerfil;
	}

/**	private void alteraStatusPerfil() {
		if(isStatusPerfil() == false){
			statusPerfil = true;
		} else {
			statusPerfil = false;
		}
	} */
	
	protected void alteraStatusAnuncio(Anuncios anuncio) {
		if(anuncio.isStatusAnuncio() == false){
			alteraStatusAnuncio = true;
			anuncio.setStatusAnuncio(alteraStatusAnuncio);
		} else {
			alteraStatusAnuncio = false;
			anuncio.setStatusAnuncio(alteraStatusAnuncio);
		}
	}
}
