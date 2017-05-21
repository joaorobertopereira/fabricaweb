<%-- 
    Document   : index
    Created on : 08/04/2017, 12:49:14
    Author     : joao
--%>

<%@page import="br.edu.ifrn.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        
        <h1>Bem vindo</h1>
        
        
        
        <h2><% Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioAutenticado");
               out.print(usuario.getNome()); 
            %></h2>
    </body>
</html>
