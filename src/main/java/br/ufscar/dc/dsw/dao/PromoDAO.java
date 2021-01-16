package br.ufscar.dc.dsw.dao;

import java.util.List;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufscar.dc.dsw.domain.Editora;
import br.ufscar.dc.dsw.domain.Livro;
import br.ufscar.dc.dsw.domain.Promo;

public class PromoDAO extends GenericDAO{
	
	public void insert(Promo promo) {

        String sql = "INSERT INTO CadastroPromocoes (id, cnpj, nome_peca, url, preco, dia, horario) VALUES (?, ?, ?, ?, ?,?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setInt(1, promo.getId());
            statement.setString(2, promo.getCnpj());
            statement.setString(3, promo.getNome_peca());
            statement.setString(4, promo.getUrl());
            statement.setString(5, promo.getPreco());
            statement.setString(6, promo.getDia());
            statement.setString(7, promo.getHorario());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         
    }
	
	
	 public List<Promo> getAll() {

	        List<Promo> listapromo = new ArrayList<>();

	        String sql = "SELECT * from CadastroPromocoes";
	try {
	            Connection conn = this.getConnection();
	            Statement statement = conn.createStatement();

	            ResultSet resultSet = statement.executeQuery(sql);
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String cnpj = resultSet.getString("cnpj");
	                String nome_peca = resultSet.getString("nome_peca");
	                String url = resultSet.getString("url");
	                String preco = resultSet.getString("preco");
	                String dia = resultSet.getString("dia");
	                String horario = resultSet.getString("horario");
	               
	                Promo promo = new Promo (id, cnpj, nome_peca, url, preco, dia, horario);
	               
	                listapromo.add(promo);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return listapromo;
	    }

	 public void delete(Livro livro) {
	        String sql = "DELETE FROM Livro where id = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setLong(1, livro.getId());
	            statement.executeUpdate();

	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public void update(Livro livro) {
	        String sql = "UPDATE Livro SET titulo = ?, autor = ?, ano = ?, preco = ?";
	        sql += ", editora_id = ? WHERE id = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setString(1, livro.getTitulo());
	            statement.setString(2, livro.getAutor());
	            statement.setInt(3, livro.getAno());
	            statement.setFloat(4, livro.getPreco());
	            statement.setFloat(5, livro.getEditora().getId());
	            statement.setLong(6, livro.getId());
	            statement.executeUpdate();

	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public Promo get(int id) {
	        Promo promo = null;

	        String sql = "SELECT * from CadastroPromocoes l where l.id = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setInt(1, id);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                String cnpj = resultSet.getString("cnpj");
	                String nome_peca = resultSet.getString("nome_peca");
	                String url = resultSet.getString("url");
	                String preco = resultSet.getString("preco");
	                String dia = resultSet.getString("dia");
	                String horario = resultSet.getString("horario");


	                promo = new Promo(id, cnpj, nome_peca, url, preco, dia, horario);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return promo;
	    }
	    
	    public void insert(Livro livro) {

	        String sql = "INSERT INTO Livro (titulo, autor, ano, preco, editora_id) VALUES (?, ?, ?, ?, ?)";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);;

	            statement = conn.prepareStatement(sql);
	            statement.setString(1, livro.getTitulo());
	            statement.setString(2, livro.getAutor());
	            statement.setInt(3, livro.getAno());
	            statement.setFloat(4, livro.getPreco());
	            statement.setLong(5, livro.getEditora().getId());
	            statement.executeUpdate();

	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

}
