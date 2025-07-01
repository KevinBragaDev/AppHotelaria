package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO pedidos (usuario_id, cliente_id, pagamento) VALUES " +
                    "(?, ?, ?);");
            novoPedido.setInt(1, 1);
            novoPedido.setInt(2, 1);
            novoPedido.setString(3, "PIX");

            int linhaAfetada = novoPedido.executeUpdate();
            if (linhaAfetada > 0) {
                System.out.println("Pedido inserido com sucesso! " + linhaAfetada + " Linha Afetada com sucesso!");
                return true;
            }
            return true;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Pedido: " + erro);
            return false;
        }
    }
    public boolean atualizarPedido() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement alterarPedido = conndb.prepareStatement
                    ("UPDATE pedidos " + "SET usuario_id = ?, cliente_id = ?, pagamento = ? WHERE id = ?;");
            alterarPedido.setInt(1, 1);
            alterarPedido.setInt(2, 1);
            alterarPedido.setString(3, "Credito");
            alterarPedido.setInt(4, 3);

            int linhaAfetada = alterarPedido.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar pedido: "+erro);
        } return false;
    }

    public void pesquisarPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaPedido = conndb.prepareStatement("SELECT usuario_id, cliente_id, pagamento " +
                    "FROM pedidos WHERE id = ?");
            buscaPedido.setInt(1, 3);
            ResultSet resultado = buscaPedido.executeQuery();

            while (resultado.next()) {
            int usuario_id = resultado.getInt("usuario_id");
            int cliente_id = resultado.getInt("cliente_id");
            String pagamento = resultado.getString("pagamento");
                System.out.println("Usuario: " + usuario_id + " Cliente: " + cliente_id + " Pagamento: " + pagamento);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar pedido: "+erro);
        }
    }

     public boolean deletarPedidos() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement removePedido = conndb.prepareStatement
                    ("DELETE FROM pedidos WHERE id = ?;");
            removePedido.setInt(1, 1);
            int linhaAfetada = removePedido.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar pedido: " + erro);
        } return false;
    }
}
