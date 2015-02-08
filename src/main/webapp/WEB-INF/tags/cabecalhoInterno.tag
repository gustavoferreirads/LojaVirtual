<%@ attribute name="subTitulo" required="false" %>
<%@ attribute name="titulo" required="false" %>
<%@ attribute name="tituloAnterior" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="voltar" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="loja" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="breadCrumbs">
    <div class="conteudoBreadCrumbs">
        <div class="boxConteudo">
				<span class=" menuBreadCrumb ">
                    <img src="${pageContext.request.contextPath}/resources/images/icons/home.png">
                    <a href="home">
                        <spring:message code="label.home"/>
                    </a></span>
            <c:if test="${voltar != null and titulo != null }">
                    <span class="menuBreadCrumb">
                        <a href="#" onclick="goBack(${voltar});">
                            <spring:message code="${tituloAnterior}"/>
                        </a>
                    </span>
            </c:if>

				<span class="menuBreadCrumb breadCrumbAtual">
                    <img src="${pageContext.request.contextPath}/resources/images/icons/atual.png">
                    <spring:message code="${titulo}"/>
                </span>
        </div>
    </div>
</div>

<% if (request.getAttribute("error") != null) { %>
    <div class="alert alert-danger" role="alert">
        <p><fmt:message key="${error}"/></p>
    </div>
<%}%>

<% if (request.getAttribute("sucess") != null) { %>
    <div class="alert alert-success" role="alert">
        <p><fmt:message key="${sucess}"/></p>
    </div>
<%}%>

<div class="subTitulo">
    <spring:message code="${subTitulo}"/>
</div>