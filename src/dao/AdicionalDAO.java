package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionalDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirAdicional() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicional = conndb.prepareStatement("INSERT  INTO adicionais (nome,preco) VALUES" +
                    "(?,?);");
            novoAdicional.setString(1, "Kevin");
            novoAdicional.setDouble(2, 500.00);
            int linhaAfetada = novoAdicional.executeUpdate();
            if (linhaAfetada > 0) {
                System.out.println("Adicional inserido com sucesso! " + linhaAfetada + " Linha Afetada com sucesso!");
                return true;
            }
            return true;
        }    catch (Exception erro) {
            System.out.println("Erro ao inserir Adicional: " + erro);
            return false;
        }
    }
    public boolean atualizarAdicional() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement alterarAdicional = conndb.prepareStatement
                    ("UPDATE adicionais " + "SET nome = ?, preco = ? WHERE id = ?;");
            alterarAdicional.setString(1, "Mateus");
            alterarAdicional.setDouble(2, 200.00);
            alterarAdicional.setInt(3, 1);

            int linhaAfetada = alterarAdicional.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar adicional: "+erro);
        } return false;
    }

    public void pesquisarAdicional() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaAdicional = conndb.prepareStatement("SELECT nome, preco " +
                    "FROM adicionais WHERE id = ?");
            buscaAdicional.setInt(1, 1);
            ResultSet resultado = buscaAdicional.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                Double preco = resultado.getDouble("preco");
                System.out.println("nome: " + nome + " preco: " + preco);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar adicional: "+erro);
        }
    }

     public boolean deletarAdicional() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement removeAdicional = conndb.prepareStatement
                    ("DELETE FROM adicionais WHERE id = ?;");
            removeAdicional.setInt(1, 1);
            int linhaAfetada = removeAdicional.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar adicional: " + erro);
        } return false;
    }
}

