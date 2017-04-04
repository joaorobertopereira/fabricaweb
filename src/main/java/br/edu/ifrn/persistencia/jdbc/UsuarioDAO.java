package br.edu.ifrn.persistencia.jdbc;

import br.edu.ifrn.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private final Connection conexao = ConexaoFactory.getConnection();

    public void Inserir(Usuario usuario) {
        String SQL = "INSERT INTO USUARIO (nome,login,senha) VALUES (?,?,?)";
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

    }

    public void Alterar(Usuario usuario) {
        String SQL = "UPDATE USUARIO SET nome=?,login=?,senha=? WHERE id = ?";
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
                // Fecha a Query
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
