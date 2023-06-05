<%--
  Created by IntelliJ IDEA.
  User: renatocouto
  Date: 03/06/2023
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" %>

<c:choose>
    <c:when test="${param.tipo eq '1'}">
        <h1>Cadastro Médico</h1>
    </c:when>
    <c:when test="${param.tipo eq '2'}">
        <h1>Cadastro de Paciente</h1>
    </c:when>
</c:choose>

<form id="formPessoa" method="post" action="cadastrarmedico">
    <label for="nome">Nome:</label>
    <input type="text" name="nome" id="nome" required>

    <label for="dataNascimento">Data de Nascimento:</label>
    <input type="date" name="dataNascimento" id="dataNascimento" required>

    <label for="sexoBiologico">Sexo Biológico:</label>
    <select name="sexoBiologico" id="sexoBiologico" required>
        <option value="">Selecino uma opção</option>
        <option value="M">M</option>
        <option value="F">F</option>
    </select>


    <label for="nomeMae">Nome da Mãe:</label>
    <input type="text" name="nomeMae" id="nomeMae" required>

    <label for="naturalidadeMunicipio">Naturalidade (Município):</label>
    <input type="text" name="naturalidadeMunicipio" id="naturalidadeMunicipio" required>

    <label for="naturalidadeEstado">Naturalidade (Estado):</label>
    <select name="naturalidadeEstado" id="naturalidadeEstado" required>
        <option value="">Selecino uma opção</option>
        <option value="AC">Acre (AC)</option>
        <option value="AL">Alagoas (AL)</option>
        <option value="AP">Amapá (AP)</option>
        <option value="AM">Amazonas (AM)</option>
        <option value="BA">Bahia (BA)</option>
        <option value="CE">Ceará (CE)</option>
        <option value="DF">Distrito Federal (DF)</option>
        <option value="ES">Espírito Santo (ES)</option>
        <option value="GO">Goiás (GO)</option>
        <option value="MA">Maranhão (MA)</option>
        <option value="MT">Mato Grosso (MT)</option>
        <option value="MS">Mato Grosso do Sul (MS)</option>
        <option value="MG">Minas Gerais (MG)</option>
        <option value="PA">Pará (PA)</option>
        <option value="PB">Paraíba (PB)</option>
        <option value="PR">Paraná (PR)</option>
        <option value="PE">Pernambuco (PE)</option>
        <option value="PI">Piauí (PI)</option>
        <option value="RJ">Rio de Janeiro (RJ)</option>
        <option value="RN">Rio Grande do Norte (RN)</option>
        <option value="RS">Rio Grande do Sul (RS)</option>
        <option value="RO">Rondônia (RO)</option>
        <option value="RR">Roraima (RR)</option>
        <option value="SC">Santa Catarina (SC)</option>
        <option value="SP">São Paulo (SP)</option>
        <option value="SE">Sergipe (SE)</option>
        <option value="TO">Tocantins (TO)</option>
    </select>


    <label for="endereco">Endereço completo:</label>
    <input type="text" name="endereco" id="endereco" required>
    <c:choose>
        <c:when test="${param.tipo eq '1'}">
            <label for="crm">CRM:</label>
            <input type="text" name="crm" id="crm" required>
            <label for="especialidade">Especialidade:</label>
            <input type="text" name="especialidade" id="especialidade" required>
        </c:when>
        <c:when test="${param.tipo eq '2'}">
            <label for="convenio">Convênio:</label>
            <input type="text" name="convenio" id="convenio" required>
        </c:when>
    </c:choose>
    <div id="divCadLogin">
        <div id="divInpuLogin">
            <label for="login">Login:</label>
            <input type="text" name="login" id="login" required>
        </div>
        <div id="divCadSenha">
            <label for="senha">Senha:</label>
            <input type="password" name="senha" id="senha" required>
            <input id="botaoMostrarSenha" type="button" onclick="senhaVisivel('senha')" value="Mostrar">
        </div>
    </div>
    <input type="submit" value="Salvar">
</form>
