package br.ufscar.dc.dsw.domain;

public class SalasDeTeatro {
	
	private int id;
	private String email;
	private String senha;
	private String cnpj;
	private String nome;
	private String cidade;
	
	
	public SalasDeTeatro(int id, String nome, String cnpj, String cidade) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.cidade = cidade;

	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;

	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getCidade() {
		return cidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
