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


    <div class="breadCrumbs" >
        <div class="conteudoBreadCrumbs">
            <div class="boxConteudo">
				<span class=" menuBreadCrumb breadCrumbLinkValido">
                <img src="${pageContext.request.contextPath}/resources/images/icons/home.png">
                    <a href="home" ><spring:message code="label.home"/></a></span>
				<%--<span class=" menuBreadCrumb breadCrumbLinkValido">--%>
                    <%--<a href="listarUsuario">Listagem de Usuários</a></span>--%>
				<span class=" menuBreadCrumb breadCrumbLinkInvalido breadCrumbAtual">
                    <img src="${pageContext.request.contextPath}/resources/images/icons/atual.png">
                    Listagem de Usuários
                </span>
            </div>
        </div>
    </div>
    <%@ include file="./../template/message.jsp" %>
    <div class="subTitulo timeLineAnchor">Dados do Usuário</div>
    <div class="boxInformacoesPrincipais boxConteudoBlocoPagina">
        <form id="form" role="form" action="" >
            <table id="grid-keep-selection" class="table table-condensed table-hover table-striped" action="listarUsuarios" actionNew="cadastroDeUsuario" actionEdit="carregaUsuario" actionRemove="remo">
                <thead>
                <tr>
                    <th data-column-id="id" data-type="numeric" data-identifier="true">Código</th>
                    <th data-column-id="nome" data-type="numeric" data-identifier="true">Nome</th>
                    <th data-column-id="login">E-mail</th>
                    <!--   <th data-column-id="received" data-order="desc">Received</th>-->
                    <!--<th data-column-id="link" data-formatter="link" data-sortable="false">Link</th>-->
                </tr>
                </thead>
            </table>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/resources/js/grid.js"></script>


