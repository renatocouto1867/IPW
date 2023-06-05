<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Clinica Medica</title>
  <link rel="stylesheet" href="styles.css">
  <script src="script.js"></script>
</head>
<body>

<div id="divPrincipal">
  <div id="divMenu">
    <nav dir="navMenu">
      <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="index.jsp?pessoa=b">Cadastro Paciente</a></li>
        <li><a href="index.jsp?pessoa=a">Cadastro Medico</a></li>
        <li><a href="">Nova consulta</a></li>
        <li><a href="">Editar</a><ul>
          <li><a href="">Paciente</a></li>
          <li><a href="">Medico</a></li>
        </ul></li>
        <li><a href="">Relatórios</a><ul>
          <li><a href="">Listar Consultas</a></li>
          <li><a href="">Consulta por data</a></li>
          <li><a href="">Consulta por paciente</a></li>
          <li><a href="">Pesquisar paciente</a></li>
          <li><a href="">Pesquisar Medico</a></li>
        </ul></li>
      </ul>
    </nav>
    <p>
      <c:if test="${not empty sessionScope.usuario}">
        Seja bem vindo!<br>${sessionScope.usuario.nome}<br>
        <a href="sair">Sair</a>
      </c:if>
    </p>

  </div>
  <div id="divTela">
    <c:if test="${not empty param.mensagem}">
      <section class="mensagem">
          ${param.mensagem}
      </section>
    </c:if>

    <c:choose>
      <c:when test="${param.pessoa eq 'a'}">
        <c:import url="WEB-INF/pessoa.jsp?tipo=1"/>
      </c:when>

      <c:when test="${param.pessoa eq 'b'}">
        <c:import url="WEB-INF/pessoa.jsp?tipo=2"/>
      </c:when>
    </c:choose>

  </div>

</div>

</body>
</html>