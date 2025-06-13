package dao;

import model.Usuario;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosDAO {

    private Conexao conexao = new Conexao();

        public boolean inserirUsuario(/*Usuario usuario*/) {
            try {
                Connection conndb = conexao.conectar();
                PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios" +
                        "(nome, email, senha, cargo_id) VALUES (?, ?, md5(?), ?);");
                //Setar os parametros
                novoUsuario.setString(1, "Kevin");
                novoUsuario.setString(2, "kevin.c.o.braga@gmail.com");
                novoUsuario.setString(3, "123");
                novoUsuario.setInt(4, 1);

                int linhaAfetada = novoUsuario.executeUpdate();
                return linhaAfetada > 0;
            } catch (Exception erro) {
                System.out.println("Erro ao inserir ususario: "+erro);
                return false;
            }
        }
    public boolean atualizarUsuario() {
        Connection conndb = conexao.conectar();
        try {
            PreparedStatement alterarUsuario = conndb.prepareStatement
                    ("UPDATE usuarios" + "SET nome = ?, email = ?, senha = md5(?) + ?, " +
                      "fk_cargos = ? WHERE id = ?;");
            alterarUsuario.setString(1,"Keven");
            alterarUsuario.setString(2, "keven@gmail.com");
            alterarUsuario.setInt(4,1);
            alterarUsuario.setInt(5,1);

            int linhaAfetada = alterarUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar usuario: "+erro);
        } return false;
    }
    public void pesquisarUsuario() {
            try {
                Connection conndb = conexao.conectar();
                PreparedStatement buscaUsuario = conndb.prepareStatement("SELECT nome, email " +
                        "FROM usuarios WHERE id = ?");
                buscaUsuario.setInt(1, 1);
                ResultSet resultado = buscaUsuario.executeQuery();

             while (resultado.next());{
                 String nome = resultado.getString("nome");
                 String email = resultado.getString("email");
                    System.out.println("Nome: " + nome + " Email: " + email);
                }
                conndb.close();
            }
            catch (Exception erro) {
                System.out.println("Erro ao pesquisar usuario: "+erro);
            }
    }

        public boolean deletarUsuario() {
            Connection conndb = conexao.conectar();
            try {
                PreparedStatement removeUsuario = conndb.prepareStatement
                        ("DELETE FROM usuarios WHERE id = ?;");
                removeUsuario.setInt(1, 1);
                int linhaAfetada = removeUsuario.executeUpdate();
                conndb.close();
                return linhaAfetada > 0;
            }
            catch (Exception erro) {
                System.out.println("Erro ao deletar usuario: " + erro);
            } return false;
        }

}
