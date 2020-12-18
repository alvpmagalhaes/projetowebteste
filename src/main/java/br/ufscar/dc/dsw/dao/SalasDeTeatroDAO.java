package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.SalasDeTeatro;
import br.ufscar.dc.dsw.domain.SitesDeVenda;

public class SalasDeTeatroDAO extends GenericDAO {

    public void insert(SalasDeTeatro salasdeteatro) {

        String sql = "INSERT INTO SalasDeTeatro (id, cnpj, nome, email, senha, cidade) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setInt(1, salasdeteatro.getId());
            statement.setString(2, salasdeteatro.getCnpj());
            statement.setString(3, salasdeteatro.getNome());
            statement.setString(4, salasdeteatro.getEmail());
            statement.setString(5, salasdeteatro.getSenha());
            statement.setString(6,  salasdeteatro.getCidade());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<SalasDeTeatro> getAll() {

        List<SalasDeTeatro> listateatros = new ArrayList<>();

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
                SalasDeTeatro salasdeteatro = new SalasDeTeatro (id, nome, cnpj, cidade);
               // Livro livro = new Livro(id, titulo, autor, ano, preco, editora);
                listateatros.add(salasdeteatro);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listateatros;
    }

    public void delete(SalasDeTeatro salasdeteatro) {
        String sql = "DELETE FROM SalasDeTeatro where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, salasdeteatro.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   /* public void update(SalasDeTeatro salasdeteatro) {
        String sql = "UPDATE SalasDeTeatro SET cnpj = ?, nome = ?, email = ?, cidade = ?";
       // sql += ", SiteVendaDeIngressos_id = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, salasdeteatro.getCnpj());
            statement.setString(2, salasdeteatro.getNome());
            statement.setString(3, salasdeteatro.getEmail());
            statement.setString(4, salasdeteatro.getCidade());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } */

  /*  public SalasDeTeatro get(int id) {
        SalasDeTeatro salasdeteatro = null;

        String sql = "SELECT * from SalasDeTeatro l, Editora e where l.id = ? and l.EDITORA_ID = e.ID";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                int ano = resultSet.getInt("ano");
                float preco = resultSet.getFloat("preco");

                Long editoraID = resultSet.getLong("editora_id");
                Editora editora = new EditoraDAO().get(editoraID);

                livro = new Livro(id, titulo, autor, ano, preco, editora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return livro;
    } */
}