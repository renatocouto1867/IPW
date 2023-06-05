<%--
  Created by IntelliJ IDEA.
  User: renatocouto
  Date: 28/05/2023
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login-Sistema</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <script src="script.js"></script>
</head>
<body>
<div id="divLogin">
    <c:if test="${not empty param.mensagem}">
        <section class="mensagem">
                ${param.mensagem}
        </section>
    </c:if>
    <form action="logar" method="post">
        <div id="divUsuario">
            <label for="inputUsuario">Usuário:</label>
            <input type="text" id="inputUsuario" name="inputUsuario" required><br>
        </div>

        <div id="divSenha">
            <label for="inputSenha">Senha:</label>
            <div id="divInputSenha">
                <input type="password" id="inputSenha" name="inputSenha" required><br>
                <input id="botaoMostrarSenha" type="button" onclick="senhaVisivel('inputSenha')" value="Mostrar">
            </div>
        </div>
        <div id="divBotoes">
            <input id="botaoEntrar" type="submit" value="Entrar">
        </div>
    </form>

</div>
</body>
</html>
