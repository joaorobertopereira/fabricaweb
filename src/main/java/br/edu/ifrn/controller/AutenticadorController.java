package br.edu.ifrn.controller;

import br.edu.ifrn.modelo.Usuario;
import br.edu.ifrn.persistencia.jdbc.UsuarioDAO;
import com.sun.prism.Texture;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession sessao = req.getSession(false);
        
        if (sessao!=null){
            sessao.invalidate();
            
        }
        
        resp.sendRedirect("login.html");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        
        Usuario usuario = new Usuario();
        
        
        usuario.setLogin(login);
        usuario.setSenha(senha);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = new Usuario();
        usuarioAutenticado = usuarioDAO.AutenticaUsuario(usuario);
        
        if (usuarioAutenticado != null){
            
            HttpSession sessao = req.getSession();
            
            sessao.setAttribute("usuarioAutenticado", usuarioAutenticado);
            
            sessao.setMaxInactiveInterval(60*5);
            
            req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
            
        } else {
            resp.getWriter().print("<script> window.alert('Usuario nao encontrado'); location.href='login.html' </script>");
        }
    }
    
    
    
}
