package br.edu.ifrn.controller;

import br.edu.ifrn.modelo.Usuario;
import br.edu.ifrn.persistencia.jdbc.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuarioController.do")
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String acao = req.getParameter("acao");

        if (acao.equals("excluir")) {
            String id = req.getParameter("id");
            Usuario usuario = new Usuario();
            if (id != null) {
                usuario.setId(Integer.parseInt(id));
            }

            UsuarioDAO usuarioDAO = null;
            usuarioDAO = new UsuarioDAO();
            usuarioDAO.Deletar(usuario);
            resp.sendRedirect("usuarioController.do?acao=listar");

        } else if (acao.equals("listar")) {
            UsuarioDAO usuarioDAO = null;
            usuarioDAO = new UsuarioDAO();

            List<Usuario> listaUsuarios = usuarioDAO.buscaTodos();
            req.setAttribute("listar", listaUsuarios);

            RequestDispatcher Dispatcher = req.getRequestDispatcher("WEB-INF/listaUsuarios.jsp");
            Dispatcher.forward(req, resp);

        } else if (acao.equals("alterar")) {

            UsuarioDAO usuarioDAO = null;
            String id = req.getParameter("id");
            Usuario usuario = new Usuario();
            usuarioDAO = new UsuarioDAO();

            usuario = usuarioDAO.buscaPorId(Integer.parseInt(id));
            req.setAttribute("usuario", usuario);

            RequestDispatcher Dispatcher = req.getRequestDispatcher("WEB-INF/salvarUsuario.jsp");
            Dispatcher.forward(req, resp);
            resp.sendRedirect("usuarioController.do?acao=listar");

        } else if (acao.equals("incluir")) {
            Usuario usuario = new Usuario();
            usuario.setId(0);
            usuario.setNome("");
            usuario.setLogin("");
            usuario.setSenha("");
            req.setAttribute("usuario", usuario);
            
            RequestDispatcher Dispatcher = req.getRequestDispatcher("WEB-INF/salvarUsuario.jsp");
            Dispatcher.forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        Usuario usuario = new Usuario();

        if (id != null) {
            usuario.setId(Integer.parseInt(id));
        }

        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);

        UsuarioDAO usuarioDAO = null;
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.Salvar(usuario);
        resp.sendRedirect("usuarioController.do?acao=listar");
    }

}
