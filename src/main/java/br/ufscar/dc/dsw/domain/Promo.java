package br.ufscar.dc.dsw.domain;

public class Promo {
	
	private int id;
	private String email;
	private String senha;
	private String cnpj;
	private String nome_peca;
	private String url;
	private String preco;
	private String dia;
	private String horario;
	
	
	public Promo(int id, String nome_peca, String cnpj, String url, String preco, String dia, String horario) {
		this.id = id;
		this.nome_peca = nome_peca;
		this.cnpj = cnpj;
		this.url = url;
		this.preco = preco;
		this.dia = dia;
		this.horario = horario;

	}
	
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;

	}
	
	public void setNome_peca(String nome_peca) {
		this.nome_peca = nome_peca;
	}

	
	
	
	
	public String getEmail() {
		return email;
	}

	public String getNome_peca() {
		return nome_peca;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getSenha() {
		return senha;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}


}
