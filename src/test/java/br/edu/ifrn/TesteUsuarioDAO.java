package br.edu.ifrn;

import br.edu.ifrn.modelo.Usuario;
import br.edu.ifrn.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

    public static void main(String[] args) {
        testeDeletar();
    }

    public static void testeInserir() {
        Usuario usuario = new Usuario();

        usuario.setNome("José da Silva");
        usuario.setLogin("jose");
        usuario.setSenha("123456");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.Inserir(usuario);
    }
    
    public static void testeAlterar() {
        Usuario usuario = new Usuario();
        
        usuario.setId(3);
        usuario.setNome("José da Silva Santos");
        usuario.setLogin("jose");
        usuario.setSenha("senhanova");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.Alterar(usuario);
    }

    public static void testeDeletar() {
        Usuario usuario = new Usuario();
        
        usuario.setId(2);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.Deletar(usuario);
    }
    
}
