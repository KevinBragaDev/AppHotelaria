package controller;
import dao.UsuariosDAO;
import model.Usuario;

public class UsuariosController {
    private final UsuariosDAO usuariosDao;

    /*Construtor para inicializar objeto UsuariosController()
    Ao inicializa-lo, o construtor de UsuariosDAO() será executado,
    o que significa que a camada de Controle estara verificando
    se os parametros necessarios foram informados para que sejam enviados as requisiçoes (package DAO) */

    public UsuariosController() {
        this.usuariosDao = new UsuariosDAO();
    }

    /* Metodo para verificar se os parametros necessarios para autenticação
    estão presentes, ou seja, não podem ser vazios ou nulos; se estiverem presentes,
     um objeto de Usuario é inicializado como uma instancia*/

    public boolean autenticarCredenciais(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false; }
        Usuario usuario = new Usuario ("", email, senha, 0);
        return usuariosDao.autenticarUsuario(usuario);
    }
}
