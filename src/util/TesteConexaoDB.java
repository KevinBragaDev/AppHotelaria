package util;
import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
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
