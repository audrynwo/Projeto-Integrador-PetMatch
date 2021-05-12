package entities;

/**
 *Classe responsavel por representar o Administrador que também é um Usuario
 * @author Audryn Weber de Oliveira
 * */
public class Administrador extends Usuario {
	private boolean alteraStatusPerfil;

	public Administrador(String nome, String sobrenome, String email, String senha) {
		super(nome, sobrenome, email, senha);

	}
	private void ativaPerfil() {
		if(isStatusPerfil() == false){
			alteraStatusPerfil = true;
			setStatusPerfil(alteraStatusPerfil);
		}else {

			alteraStatusPerfil = false;
			setStatusPerfil(alteraStatusPerfil);
		}
	}
}
