package util;
import controller.UsuariosController;
import dao.*;
import model.Reserva;
import model.Usuario;

import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {

        Conexao conexao = new Conexao();

        //Usuario usuario = new Usuario("Keven", "keven@gmail.com", "54321", 1 );
        UsuariosController usuariosController = new UsuariosController();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                //Testando a autenticação de um usuario
                usuariosController.autenticarCredenciais("keven@gmail.com", "54321");



                condb.close();
                System.out.println("Conexão encerrada!");
            } catch (Exception erro) {
                System.out.println("Erro ao encerra a conexão" + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao Banco de Dados!");
        }
    }
}
/*UsuariosDAO usuariosDAO = new UsuariosDAO();
                usuariosDAO.deletarUsuario();
                System.out.println("Usuario deletado com sucesso!");

                PedidosDAO pedidosDAO = new PedidosDAO();
                pedidosDAO.deletarPedidos();
                System.out.println("Pedidos deletado com sucesso!");

                RoleDAO roleDAO = new RoleDAO();
                roleDAO.deletarRole();
                System.out.println("Role deletado com sucesso!");

                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.deletarCliente();
                System.out.println("Cliente deletado com sucesso!");

                AdicionalDAO adicionalDAO = new AdicionalDAO();
                adicionalDAO.deletarAdicional();
                System.out.println("Adicional deletado com sucesso!");

                QuartoDAO quartoDAO = new QuartoDAO();
                quartoDAO.deletarQuarto();
                System.out.println("Quarto deletado com sucesso!");*/