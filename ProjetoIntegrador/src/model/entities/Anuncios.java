package model.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavel por representar os Anuncios do Usuario
 * @author Audryn Weber de Oliveira
 * */

public class Anuncios implements Serializable {

	private static final long serialVersionUID = 1L;


	private int idAnuncio;
	private String descricao;
	private List<String> midia = new ArrayList<>();
	private String nomeDoAnimal;
	private String especie;
	private String raca;
	private String genero;
	private String porte;
	private int idade;
	private LocalDateTime dataAnuncio;
	private boolean statusVacinacao;
	private boolean statusCastracao;
	private boolean statusVermifugo;
	private boolean statusAdocao;
	private Usuario autor;
	private Endereco endereco;

	public Anuncios () {
	}

	public Anuncios(String nomeDoAnimal,  String midia, String descricao, int idade, String especie, String raca, String genero, 
			String porte, boolean statusVacinacao, boolean statusCastracao, boolean statusVermifugo, Usuario autor, Endereco endereco) {
		this.nomeDoAnimal = nomeDoAnimal;
		this.midia.add(midia);
		this.descricao = descricao;
		this.idade = idade;
		this.especie = especie;
		this.raca = raca;
		this.genero = genero;
		this.porte = porte;
		this.statusVacinacao = statusVacinacao;
		this.statusCastracao = statusCastracao;
		this.statusVermifugo = statusVermifugo;
		this.autor = autor;
		this.endereco = endereco;
		dataAnuncio = LocalDateTime.now();
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

	public boolean isStatusAdocao() {
		return statusAdocao;
	}

	public void setStatusAdocao(boolean statusAdocao) {
		this.statusAdocao = statusAdocao;
	}

	public LocalDateTime getDataAnuncio() {
		return dataAnuncio;
	}

	public void setDataAnuncio(LocalDateTime dataAnuncio) {
		this.dataAnuncio = dataAnuncio;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAnuncio;
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
		Anuncios other = (Anuncios) obj;
		if (idAnuncio != other.idAnuncio)
			return false;
		return true;
	}

}