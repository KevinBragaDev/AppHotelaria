package dao;

import model.Quarto;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartoDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos (nome, numero, qnt_cama_casal, qnt_cama_solteiro, preco, disponivel)" +
                    " VALUES " + "(?, ?, ?, ?, ?, ?);");
            novoQuarto.setString(1, "Quarto Solteiro");
            novoQuarto.setString(2, "123");
            novoQuarto.setInt(3, 1);
            novoQuarto.setInt(4, 1);
            novoQuarto.setDouble(5, 300.00);
            novoQuarto.setBoolean(6, true);

            int linhaAfetada = novoQuarto.executeUpdate();
            if (linhaAfetada > 0) {
                System.out.println("Quarto inserido com sucesso! " + linhaAfetada + " Linha Afetada com sucesso!");
                return true;
            }
            return true;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }
    public boolean atualizarQuarto() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement alterarQuarto = conndb.prepareStatement
                    ("UPDATE quartos " + "SET nome = ?, numero = ?, qnt_cama_casal = ?, qnt_cama_solteiro = ?, preco = ?, disponivel = ? WHERE id = ?;");
            alterarQuarto.setString(1, "Quarto Casal");
            alterarQuarto.setString(2, "321");
            alterarQuarto.setInt(3, 5);
            alterarQuarto.setInt(4, 3);
            alterarQuarto.setDouble(5, 500.00);
            alterarQuarto.setBoolean(6, true);
            alterarQuarto.setInt(7, 1);
            int linhaAfetada = alterarQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar pedido: "+erro);
        } return false;
    }

    public void pesquisarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaQuarto = conndb.prepareStatement("SELECT nome, numero, qnt_cama_casal, qnt_cama_solteiro, preco, disponivel " +
                    "FROM quartos WHERE id = ?");
            buscaQuarto.setInt(1, 1);
            ResultSet resultado = buscaQuarto.executeQuery();
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String numero = resultado.getString("numero");
                int qnt_cama_casal = resultado.getInt("qnt_cama_casal");
                int qnt_cama_solteiro = resultado.getInt("qnt_cama_solteiro");
                double preco = resultado.getDouble("preco");
                boolean disponivel = resultado.getBoolean("disponivel");
                System.out.println("nome: " + nome + "numero: " + numero + " qnt_cama_casal: " + qnt_cama_casal + " qnt_cama_solteiro: " + qnt_cama_solteiro + " preco: " + preco + " disponivel: " + disponivel);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar quarto: "+erro);
        }
    }

    public boolean deletarQuarto() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement removeQuarto = conndb.prepareStatement
                    ("DELETE FROM quartos WHERE id = ?;");
            removeQuarto.setInt(1, 1);
            int linhaAfetada = removeQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar pedido: " + erro);
        } return false;
    }
}
