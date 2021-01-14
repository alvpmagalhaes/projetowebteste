package br.ufscar.dc.dsw.dao;

import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufscar.dc.dsw.domain.Promo;
import br.ufscar.dc.dsw.domain.SalasDeTeatro;
import br.ufscar.dc.dsw.domain.SitesDeVenda;

public class PromoDAO extends GenericDAO{
	
	public void insert(Promo promo) {

        String sql = "INSERT INTO CadastroPromocoes (cnpj, nome_peca, url, preco, dia, horario) VALUES (?, ?, ?, ?, ?,?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, promo.getCnpj());
            statement.setString(2, promo.getNomePeca());
            statement.setString(3, promo.getEndereco());
            statement.setString(4, promo.getPreco());
            statement.setDate(5, (Date) promo.getDiahora());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         
    }
	
	
	 public List<Promo> getAll() {

	        List<Promo> listateatros = new ArrayList<>();

	        String sql = "SELECT * from SalasDeTeatro";
	try {
	            Connection conn = this.getConnection();
	            Statement statement = conn.createStatement();

	            ResultSet resultSet = statement.executeQuery(sql);
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String cnpj = resultSet.getString("cnpj");
	                String nome = resultSet.getString("nome");
	                String email = resultSet.getString("email");
	                String senha = resultSet.getString("senha");
	                String cidade = resultSet.getString("cidade");
	        
	                SitesDeVenda sitesdevenda = new SitesDeVenda(id, nome);
	               //  Editora editora = new Editora(editora_id, cnpj, nome);
	                Promo promos = new Promo (id, nome, cnpj, cidade);
	               // Livro livro = new Livro(id, titulo, autor, ano, preco, editora);
	                listateatros.add(Promos);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return listapromo;
	    }


}
