package br.edu.ifrn;

import br.edu.ifrn.modelo.Usuario;
import br.edu.ifrn.persistencia.jdbc.UsuarioDAO;
import java.util.List;

public class TesteUsuarioDAO {

    public static void main(String[] args) {
       testaAutenticaUsuario();
        
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
        
        usuario.setId(13);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.Deletar(usuario);
    }
    
    public static void testeSalvar(){
       Usuario usuario = new Usuario();
        
       // usuario.setId(10);
        usuario.setNome("Ubiratan Novo");
        usuario.setLogin("ubiratan");
        usuario.setSenha("554433");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.Salvar(usuario); 
    }

    private static void testeBuscaPorId(int id) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscaPorId(id);
        System.out.println(usuario.toString());
    }

    private static void testeBuscarTodos() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> lista = usuarioDAO.buscaTodos();
        for( Usuario u: lista){
            System.out.println(u.toString());
        }
        
    }

    private static void testaAutenticaUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setLogin("maria.silva");
        usuario.setSenha("123456");
        
        if (usuarioDAO.AutenticaUsuario(usuario)){
            System.out.println("Usuario Autenticado.");
        } else {
            System.out.println("Usuario Nao Localizado.");
        }
    }
    
}
