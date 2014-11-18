<%--
  Created by IntelliJ IDEA.
  User: Gustavo Ferreira
  Date: 20/09/2014\t
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="loja" %>

<div class="content">
    <div class="breadCrumbs" style="width: 1024px;">
        <div class="conteudoBreadCrumbs">
            <div class="boxConteudo">
				<span class=" menuBreadCrumb breadCrumbLinkValido">
                <img src="${pageContext.request.contextPath}/resources/images/icons/home.png">
                    <a href="home"><spring:message code="label_home"/></a></span>
				<span class=" menuBreadCrumb breadCrumbLinkValido">
                    <a href="listarUsuario">Listagem de Usuários</a></span>
				<span class=" menuBreadCrumb breadCrumbLinkInvalido breadCrumbAtual">
                    <img src="${pageContext.request.contextPath}/resources/images/icons/atual.png">
                    Adicionar Usuário
                </span>
            </div>
        </div>
    </div>
    <%@ include file="./../template/message.jsp" %>
    <div class="subTitulo timeLineAnchor">Dados do Usuário</div>
    <div class="boxInformacoesPrincipais boxConteudoBlocoPagina">
    <form id="form" role="form" action="salvarUsuario" >
            <input type="hidden" name="id"/>
            <loja:input label="label.email" type="email" name="login" classe="form-control" required="required" id="email" placeholder="Insira seu email..." />
            <loja:input label="label.senha" type="password" name="senha" classe="form-control" id="senha" required="required" placeholder="Senha..."/>
        <button type="button" onclick="submitForm();" class="btn btn-default">Salvar</button>
    </form>
</div>
</div>