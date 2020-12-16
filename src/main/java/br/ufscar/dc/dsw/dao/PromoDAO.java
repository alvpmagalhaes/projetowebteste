package br.ufscar.dc.dsw.dao;

import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.ufscar.dc.dsw.domain.Promo;

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

        List<Promo> listaPromos = new ArrayList<>();

        String sql = "SELECT * from CadastroPromocoes wher nome_peca";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String cnpj = resultSet.getString("cnpj");
                String nome_peca = resultSet.getString("nome_peca");
                String endereco = resultSet.getString("url");
                String preco = resultSet.getString("preco");
                Promo promo = new Promo(cnpj, nome_peca, endereco, preco);
                listaPromos.add(promo);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromos;
    }


}
