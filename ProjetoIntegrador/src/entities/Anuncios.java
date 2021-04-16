package entities;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe responsável por representar os Anuncios do Usuário
 * @author Audryn Weber de Oliveira
 * */
import java.time.LocalDate;
public class Anuncios {
	String descricao;
	List<String> midia = new ArrayList<>();
	String nomeDoAnimal;
	String especie;
	String raca;
	String genero;
	String porte;
	int idade;
	LocalDate dataAnuncio;
	boolean statusVacinacao;
	boolean statusCastracao;
	boolean statusVermifugo;
	
	public Anuncios(String descricao, String midia, String nomeDoAnimal, String especie, String raca, String genero, 
			String porte, int idade, boolean statusVacinacao, boolean statusCastracao, boolean statusVermifugo) {
	this.descricao = descricao;
	this.midia.add(midia);
	if(this.midia.isEmpty() == true) {
		
	}
	if(this.midia.size() > 5) {
		
	}
	
	this.nomeDoAnimal = nomeDoAnimal;
	this.especie = especie;
	this.raca = raca;
	this.genero = genero;
	this.porte = porte;
	this.idade = idade;
	this.statusVacinacao = statusVacinacao;
	this.statusCastracao = statusCastracao;
	this.statusVermifugo = statusVermifugo;
	
	}
	
}
