package entities;

/**
 * Classe responsavel por representar os Anuncios do Usuario
 * @author Audryn Weber de Oliveira
 * */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Anuncios {

	private int idAnuncio;
	private String descricao;
	private List<String> midia = new ArrayList<>();
	private String nomeDoAnimal;
	private String especie;
	private String raca;
	private String genero;
	private String porte;
	private int idade;
	private LocalDate dataAnuncio;
	private boolean statusVacinacao;
	private boolean statusCastracao;
	private boolean statusVermifugo;
	private boolean statusAnuncio;
	private boolean statusAdocao;
	private Usuario autor;
	private Endereco endereco;

	public Anuncios(String descricao, String midia, String nomeDoAnimal, String especie, String raca, String genero, 
			String porte, int idade, boolean statusVacinacao, boolean statusCastracao, boolean statusVermifugo, Usuario autor) {
		this.descricao = descricao;
		this.midia.add(midia);
		this.nomeDoAnimal = nomeDoAnimal;
		this.especie = especie;
		this.raca = raca;
		this.genero = genero;
		this.porte = porte;
		this.idade = idade;
		this.statusVacinacao = statusVacinacao;
		this.statusCastracao = statusCastracao;
		this.statusVermifugo = statusVermifugo;
		this.autor = autor;
		dataAnuncio = LocalDate.now();
		statusAnuncio = true;
		statusAdocao = false;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<String> getMidia() {
		return midia;
	}

	public void setMidia(List<String> midia) {
		this.midia = midia;
	}

	public String getNomeDoAnimal() {
		return nomeDoAnimal;
	}

	public void setNomeDoAnimal(String nomeDoAnimal) {
		this.nomeDoAnimal = nomeDoAnimal;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isStatusVacinacao() {
		return statusVacinacao;
	}

	public void setStatusVacinacao(boolean statusVacinacao) {
		this.statusVacinacao = statusVacinacao;
	}

	public boolean isStatusCastracao() {
		return statusCastracao;
	}

	public void setStatusCastracao(boolean statusCastracao) {
		this.statusCastracao = statusCastracao;
	}

	public boolean isStatusVermifugo() {
		return statusVermifugo;
	}

	public void setStatusVermifugo(boolean statusVermifugo) {
		this.statusVermifugo = statusVermifugo;
	}
	
	public boolean isStatusAnuncio() {
		return statusAnuncio;
	}
	
	public void setStatusAnuncio(boolean statusAnuncio) {
		this.statusAnuncio = statusAnuncio;
	}
	
	public boolean isStatusAdocao() {
		return statusAdocao;
	}
	
	public void setStatusAdocao(boolean statusAdocao) {
		this.statusAdocao = statusAdocao;
	}

	public LocalDate getDataAnuncio() {
		return dataAnuncio;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario usuario) {
		this.autor = usuario;
	}

	/**
	 * Metodo responsvel por controlar que nao tenham mais de cinco midias em um anuncio.
	 * @authors Aundryn Weber e Kaiane Ferreira
	 */
	public void controlaMidia(String midia) {
		if(this.midia.size() < 5) {
			this.midia.add(midia);
		}
	}

	/**
	 * Metodo responsavel por remover midias e controlar que exista,
	 * no minimo, uma midia no anuncio.
	 * @authors Aundryn Weber e Kaiane Ferreira 
	 */

	public void excluiMidia(String midia) {
		if(this.midia.size() > 0) {
			this.midia.remove(midia);
		}
	}

	public int getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
}