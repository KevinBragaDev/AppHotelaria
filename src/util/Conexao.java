package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private  String DRIVER = "com.mysql.cj.jdbc.Driver";
    private  String URL = "jdbc:mysql://localhost:3306/hotelaria";
    private  String USER = "dbaHotel";
    private  String PASS = "dbaHotel123";

    public Connection conectar() {

        Connection con = null;

        try {
        //Especifica a rota do Driver a ser carregado (JDBC para SGBD MySQL)

            Class.forName(DRIVER);


        /*Inicializar o driver já carregado por meio do metodo getConnection(IP, porta,
        nome do banco, usuario, senha)*/

        con = DriverManager.getConnection(URL, USER , PASS);
            return con;
        }

        catch (SQLException | ClassNotFoundException erro) {
            System.out.println(" Erro ao conectar ao Banco de Dados " + erro);
            return null;
        }
    }
}