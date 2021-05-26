package entities;

/**
 * Classe responsavel por representar o Endereco do Usuario
 * @author Audryn Weber de Oliveira
 * */
public class Endereco {
	
	private int idEndereco;
	private String uf;
	private String cidade;
	private String bairro;
	private String rua;
	private String complemento;
	private String cep;

	public Endereco(String cep, String uf, String cidade) {
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
	}

	public Endereco(String cep, String uf, String cidade, String bairro, String rua, String complemento) {
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.complemento = complemento;

	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

}

