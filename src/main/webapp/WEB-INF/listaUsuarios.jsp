<%@page import="java.util.List"%>
<%@page import="br.edu.ifrn.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuários</title>
        <link rel="stylesheet" href="css/uikit.gradient.min.css"/>
        <link rel="stylesheet" href="css/uikit.docs.min.css">
        <script src="js/vendor/jquery.js"></script>
        <script src="js/uikit.min.js"></script>
        <script src="js/core/button.min.js"></script>
        <script src="js/core/modal.min.js"></script>
        
        <script type="text/javascript">
            function confirmaExclusao(id) {
                if (window.confirm("Deseja realmente Excluir o registro ?")) {
                    location.href = "usuarioController.do?acao=excluir&id=" + id;
                }
            }

        </script>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="uk-container">
            <%List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listar");%>

            <a class="uk-button uk-button-primary uk-button-small" href="usuarioController.do?acao=incluir">
                <span class="uk-margin-small-right uk-icon-user-plus"></span>Incluir</a>

            <div class="uk-overflow-auto">
                <table class="uk-table uk-table-hover uk-table-small">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Login</th>
                            <th>Senha</th>
                            <th class="">Ação</th>
                        </tr>
                    </thead>
                    <%for (Usuario u : listaUsuarios) {%>
                    <tbody>
                        <tr>
                            <td><%out.print(u.getId());%></td>
                            <td><%out.print(u.getNome());%></td>
                            <td><%out.print(u.getLogin());%></td>
                            <td><%out.print(u.getSenha());%></td>
                            <td><a class="uk-button uk-button-secondary uk-button-small" href="usuarioController.do?acao=alterar&id=<%out.print(u.getId());%>">
                                    <span class="uk-margin-small-right uk-icon-hover uk-icon-edit"></span>Editar</a>
                                <a class="uk-button uk-button-danger uk-button-small" href="javascript:confirmaExclusao(<%out.print(u.getId());%>)">
                                    <span class="uk-margin-small-right uk-icon-trash-o"></span>Excluir</a></td>
                        </tr>    
                    </tbody>                
                    <%}%>
                </table>      
            </div>
        </div>

        <!--Tela Salvar Usuario -->
        


    </body>
</html>
