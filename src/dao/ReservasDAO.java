package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservasDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirReservas() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoReserva = conndb.prepareStatement("INSERT INTO reservas" +
                    "(pedido_id, quarto_id, adicional_id, fim, inicio) VALUES (?, ?, ?, ?, ?);");
            //Setar os parametros
            novoReserva.setInt(1, 1);
            novoReserva.setInt(2, 1);
            novoReserva.setInt(3, 1);
            //novoReserva.setDate(4, )
            //novoReserva.setDate(4, )

            int linhaAfetada = novoReserva.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir reserva: " + erro);
            return false;
        }
    }

    public boolean atualizarReservas() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement alterarReserva = conndb.prepareStatement
                    ("UPDATE reservas" +
                            "SET pedido_id = ?, quarto_id = ?, adicional_id = ?, fim = ?, inicio = ?" + " WHERE id = ?;");
            alterarReserva.setInt(1, 1);
            alterarReserva.setInt(2, 2);
            alterarReserva.setInt(3, 2);
            //alterarReserva.setDate(4, );
            //alterarReserva.setDate(5, );

            int linhaAfetada = alterarReserva.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar reserva: " + erro);
        }
        return false;
    }

    public void pesquisarReservas() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaReserva = conndb.prepareStatement("SELECT pedido_id, quarto_id, fim, inicio " +
                    "FROM reservas WHERE id = ?");
            buscaReserva.setInt(1, 1);
            ResultSet resultado = buscaReserva.executeQuery();
            while (resultado.next());{
                int pedido_id = resultado.getInt("pedido_id");
                int quarto_id = resultado.getInt("quarto_id");

                //falta fim e inicio pq esta em datetime

                System.out.println("pedido_id: " + pedido_id + " quarto_id: " + quarto_id);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar reserva: " + erro);
        }
    }

    public boolean deletarReserva() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement removeReserva = conndb.prepareStatement
                    ("DELETE FROM reservas WHERE id = ?;");
            removeReserva.setInt(1, 1);
            int linhaAfetada = removeReserva.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar reserva: " + erro);
        }
        return false;
    }
}

