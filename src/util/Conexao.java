package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    private String DRIVER;
    private String URL;
    private String USER;
    private String PASS;

    public Conexao() {
        carregarConfiguracoes();
    }
    //Metodo com os parametros de configuraçao das variaveis de ambiente
    private void carregarConfiguracoes() {
        Properties props = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream
                ("config.properties")) {
            props.load(inputPropsConfig);
            DRIVER = props.getProperty("DRIVER");
            URL = props.getProperty("URL");
            USER = props.getProperty("USER");
            PASS = props.getProperty("PASS");
        }
        catch (IOException erro) {
            System.out.println("Erro ao carregar configurações: " + erro.getMessage());
        }
    }

    public Connection conectar() {

        Connection condb = null;

        try {
        //Especifica a rota do Driver a ser carregado (JDBC para SGBD MySQL)
            Class.forName(DRIVER);

        /*Inicializar o driver já carregado por meio do metodo getConnection(IP, porta,
        nome do banco, usuario, senha)*/

        condb = DriverManager.getConnection(URL, USER , PASS);
            System.out.println("Conectado com sucesso!");
            return condb;
        }

        catch (SQLException | ClassNotFoundException erro) {
            System.out.println(" Erro ao conectar ao Banco de Dados " + erro);
            return null;
        }
    }
}