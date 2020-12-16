package br.ufscar.dc.dsw.domain;


public class SitesDeVenda {
	
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String endereco;
	private String telefone;
	

	

	public SitesDeVenda(int id, String nome) {
		// TODO Auto-generated constructor stub
        this.id = id;
        this.nome = nome;
      
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getEndereco() {
		return endereco;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


}


