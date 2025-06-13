package dao;


import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirRole() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoRole = conndb.prepareStatement("INSERT  INTO cargos (nome) VALUES" + "(?);");
            novoRole.setString(1, "Atendente");
            int linhaAfetada = novoRole.executeUpdate();
            if (linhaAfetada > 0) {
                System.out.println("Cargo inserido com sucesso! " + linhaAfetada + " Linha Afetada com sucesso!");
                return true;
            }
            return true;
        }    catch (Exception erro) {
            System.out.println("Erro ao inserir Role: " + erro);
            return false;
        }
    }
    public boolean atualizarRole() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement alterarRole = conndb.prepareStatement
                    ("UPDATE cargos" + "SET nome = ? WHERE id = ?;");
            alterarRole.setString(1, "Zelador");
            int linhaAfetada = alterarRole.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar cargo: "+erro);
        } return false;
    }



     public boolean deletarRole() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement removeRole = conndb.prepareStatement
                    ("DELETE FROM cargos WHERE id = ?;");
            removeRole.setInt(1, 1);
            int linhaAfetada = removeRole.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar cargo: " + erro);
        } return false;
    }
}
