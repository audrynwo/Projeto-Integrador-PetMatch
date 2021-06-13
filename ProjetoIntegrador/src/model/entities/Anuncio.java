package model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavel por representar os Anuncios do Usuario
 * @author Audryn Weber de Oliveira
 * */

public class Anuncio implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	

	private int idAnuncio;
	private String descricao;
	private List<MidiaAnuncio> midia;
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

	public Anuncio() {
		this.autor = new Usuario();
		this.endereco = new Endereco();
	}

	public Anuncio(String nomeDoAnimal, String descricao, int idade, String especie, String raca, String genero, 
			String porte, boolean statusVacinacao, boolean statusCastracao, boolean statusVermifugo, Usuario autor, Endereco endereco) {
		this.nomeDoAnimal = nomeDoAnimal;
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
		this.midia = new ArrayList<>();
		dataAnuncio = LocalDateTime.now();
		statusAdocao = false;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<MidiaAnuncio> getMidia() {
		return midia;
	}

	public void setMidia(List<MidiaAnuncio> midia) {
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
		return this.autor;
	}

	public void setAutor(Usuario usuario) {
		this.autor = usuario;
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
		Anuncio other = (Anuncio) obj;
		if (idAnuncio != other.idAnuncio)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return ("   Nome: " + nomeDoAnimal + "\n   Descricao: " + descricao + "\n   Especie: " + especie
				+ "\n   Raca: " + raca + "\n   Genero: " + genero + "\n   Porte: " + porte + "\n   Idade: " + idade 
				+ "\n   Vacinacao: " + statusVacinacao + "\n   Castracao: " + statusCastracao
				+ "\n   Vermifugo: " + statusVermifugo + "\n   Status de Adocao: " + statusAdocao 
				+ "\n   Data de publicacao: " + dataAnuncio.format(formatter));
	}
}