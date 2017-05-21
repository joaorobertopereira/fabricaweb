
<%@page import="br.edu.ifrn.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salvar - Usuario </title>
        <script src="js/vendor/jquery.js"></script>
        <script src="js/uikit.min.js"></script>
        <script src="js/core/button.min.js"></script>
        <script src="js/core/modal.min.js"></script>

    </head>
    <body>
        <%@include file="menu.jsp" %>
        <% Usuario usuario = (Usuario)request.getAttribute("usuario");%>
        <div id="salvar" class="uk-modal">
            <div class="uk-modal-dialog">
                <div class="uk-modal-header">Salvar Usuario</div>
                <form class="uk-form uk-form-horizontal" action="usuarioController.do" method="post">
                    <fieldset>
                        <div class="uk-form-row">
                            <label class="uk-form-label" title="ID">
                                <input type="number" placeholder="Informe o ID" class="uk-form-width-medium" name="id" value="<%=usuario.getId()%>">
                            </label>      
                        </div>
                        <div class="uk-form-row">
                            <label class="uk-form-label" title="Nome">
                                <input type="text" placeholder="Informe o Nome" class="uk-form-width-medium" name="nome" value="<%=usuario.getNome()%>">
                            </label>      
                        </div>
                        <div class="uk-form-row">
                            <label class="uk-form-label" title="Login">
                                <input type="text" placeholder="Informe o Login" class="uk-form-width-medium" name="login" value="<%=usuario.getLogin()%>">
                            </label>      
                        </div>
                        <div class="uk-form-row">
                            <label class="uk-form-label" title="Senha">
                                <input type="text" placeholder="Informe a Senha" class="uk-form-width-medium" name="senha" value="<%=usuario.getSenha()%>">
                            </label>      
                        </div>
                    </fieldset>
                    <div class="uk-modal-footer">
                        <input type="submit" value="Salvar">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
