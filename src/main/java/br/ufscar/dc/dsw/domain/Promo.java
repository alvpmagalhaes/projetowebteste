package br.ufscar.dc.dsw.domain;

import java.util.*;

public class Promo {
	
	private String endereco;
	private String cnpjTeatro;
	private String nomePeca;
	private String preco;
	private Date diahora;
	
	public Promo(String nomePeca) {
	}
	
	public Promo(String cnpj, String nome_peca, String endereco2, String preco2) {
		// TODO Auto-generated constructor stub
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setCnpj(String cnpjTeatro) {
		this.cnpjTeatro = cnpjTeatro;
	}
	
	public void setPeca(String peca) {
		this.nomePeca = peca;
	}
	
	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCnpj() {
		return cnpjTeatro;
	}
	
	public String getPreco() {
		return preco;
	}
	
	public Date getDiahora() {
		return diahora;
	}
	
	public String getNomePeca() {
		return nomePeca;
	}
	

}
