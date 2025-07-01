package dao;
import model.Cliente;
import model.Usuario;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT  INTO clientes (nome,email,telefone,cpf) VALUES" +
                    "(?,?,?,?);");
            novoCliente.setString(1, "Kevin");
            novoCliente.setString(2, "kevin@gmail.com");
            novoCliente.setString(3, "123456789");
            novoCliente.setString(4, "123456");
            int linhaAfetada = novoCliente.executeUpdate();
            if (linhaAfetada > 0) {
                System.out.println("Cliente inserido com sucesso! " + linhaAfetada + " Linha Afetada com sucesso!");
                return true;
            }
            return true;
        }    catch (Exception erro) {
            System.out.println("Erro ao inserir Cliente: " + erro);
            return false;
        }
    }
    public boolean atualizarCliente() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement alterarCliente = conndb.prepareStatement
                    ("UPDATE clientes " + "SET nome = ?, email = ?, telefone = ?, cpf = ? WHERE id = ?;");
            alterarCliente.setString(1, "Mateus");
            alterarCliente.setString(2, "mateus@gmail.com");
            alterarCliente.setString(3, "987654321");
            alterarCliente.setString(4, "654321");
            alterarCliente.setInt(5, 1);

            int linhaAfetada = alterarCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar cliente: "+erro);
        } return false;
    }

    public void pesquisarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaCliente = conndb.prepareStatement("SELECT nome, email, telefone, cpf " +
                    "FROM clientes WHERE id = ?");
            buscaCliente.setInt(1, 1);
            ResultSet resultado = buscaCliente.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String telefone = resultado.getString("telefone");
                String cpf = resultado.getString("cpf");
                System.out.println("nome: " + nome + " email: " + email + " telefone: " + telefone + " cpf: " + cpf);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar cliente: "+erro);
        }
    }

     public boolean deletarCliente() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement removeCliente = conndb.prepareStatement
                    ("DELETE FROM clientes WHERE id = ?;");
            removeCliente.setInt(1, 1);
            int linhaAfetada = removeCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar cliente: " + erro);
        } return false;
    }
}

