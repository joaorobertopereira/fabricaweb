package br.edu.ifrn.persistencia.jdbc;

import br.edu.ifrn.modelo.Usuario;
import com.sun.prism.Texture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private final Connection conexao = ConexaoFactory.getConnection();

    public void Inserir(Usuario usuario) {
        if (usuario.getId() == null || usuario.getId() == 0 ) {
            String SQL = "INSERT INTO USUARIO (nome,login,senha) VALUES (?,?,MD5(?))";
            try {
                try (PreparedStatement Query = conexao.prepareStatement(SQL)) {
                    Query.setString(1, usuario.getNome());
                    Query.setString(2, usuario.getLogin());
                    Query.setString(3, usuario.getSenha());
                    // Executa SQL
                    Query.execute();
                    // Fecha a Query
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            String SQL = "INSERT INTO USUARIO (id,nome,login,senha) VALUES (?,?,?,MD5(?))";
            try {
                try (PreparedStatement Query = conexao.prepareStatement(SQL)) {
                    Query.setInt(1, usuario.getId());
                    Query.setString(2, usuario.getNome());
                    Query.setString(3, usuario.getLogin());
                    Query.setString(4, usuario.getSenha());
                    // Executa SQL
                    Query.execute();
                    // Fecha a Query
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void Alterar(Usuario usuario) {
        String SQL = "UPDATE USUARIO SET nome=?,login=?,senha=MD5(?) WHERE id = ?";
        try {
            try (PreparedStatement Query = conexao.prepareStatement(SQL)) {
                Query.setString(1, usuario.getNome());
                Query.setString(2, usuario.getLogin());
                Query.setString(3, usuario.getSenha());
                Query.setInt(4, usuario.getId());
                // Executa SQL
                Query.execute();
                // Fecha a Query
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Deletar(Usuario usuario) {
        String SQL = "DELETE FROM USUARIO WHERE id = ?";
        try {
            try (PreparedStatement Query = conexao.prepareStatement(SQL)) {
                Query.setInt(1, usuario.getId());
                // Executa SQL
                Query.execute();

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean VerificaUsuario(Usuario usuario) {
        String SQL = "SELECT id FROM USUARIO WHERE id = ?";
        Boolean retorno = false;
        try {
            try (PreparedStatement Query = conexao.prepareStatement(SQL)) {
                Query.setInt(1, usuario.getId());
                // Executa SQL
                ResultSet resultSet = Query.executeQuery();

                retorno = resultSet.next();
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public void Salvar(Usuario usuario) {
        if (usuario.getId() != null && usuario.getId() != 0) {
            Alterar(usuario);
        } else {
            Inserir(usuario);
        }
    }

    public Usuario buscaPorId(Integer id) {
        String SQL = "SELECT * FROM USUARIO WHERE id = ?";
        Usuario usuario = null;
        try {
            try (PreparedStatement Query = conexao.prepareStatement(SQL)) {
                Query.setInt(1, id);
                // Executa SQL
                ResultSet resultado = Query.executeQuery();

                if (resultado.next()) {
                    usuario = new Usuario();
                    usuario.setId(resultado.getInt("id"));
                    usuario.setNome(resultado.getString("nome"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setSenha(resultado.getString("senha"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public List<Usuario> buscaTodos() {
        String SQL = "SELECT * FROM USUARIO ORDER BY id";
        List<Usuario> lista = new ArrayList<>();
        try {
            try (PreparedStatement Query = conexao.prepareStatement(SQL)) {
                // Executa SQL
                ResultSet resultado = Query.executeQuery();

                while (resultado.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultado.getInt("id"));
                    usuario.setNome(resultado.getString("nome"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setSenha(resultado.getString("senha"));
                    lista.add(usuario);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Usuario AutenticaUsuario(Usuario usuario) {
        String SQL = "SELECT * FROM USUARIO WHERE login = ? and senha = MD5(?)";
        Usuario usuarioAutenticado = null;
        try {
            try (PreparedStatement Query = conexao.prepareStatement(SQL)) {
                Query.setString(1, usuario.getLogin());
                Query.setString(2, usuario.getSenha());
                // Executa SQL
                ResultSet resultado = Query.executeQuery();

                if (resultado.next()) {
                    usuarioAutenticado = new Usuario();
                    usuarioAutenticado.setId(resultado.getInt("id"));
                    usuarioAutenticado.setNome(resultado.getString("nome"));
                    usuarioAutenticado.setLogin(resultado.getString("login"));
                    usuarioAutenticado.setSenha(resultado.getString("senha"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioAutenticado;        
    }

}
