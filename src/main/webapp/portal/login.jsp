<%--
  Created by IntelliJ IDEA.
  User: Gustavo Ferreira
  Date: 20/09/2014
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="loja" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/portal.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <title></title>
</head>

<body class="navbar-inverse">

<div class="container">

    <form class="form-signin" role="form" action="logar" method="post">
        <h2 class="form-signin-heading portal-color-white">Loja Virtual</h2>
        <input type="email" name="login" placeholder="Email" class="form-control" required="required" autofocus="true">
        <input type="password" name="senha" placeholder="Senha" class="form-control " required="required" >
        <button class="btn btn-lg btn-success btn-block" type="submit">Logar</button>
        <%@ include file="template/message.jsp" %>
    </form>

</div>

<%@ include file="template/footer.jsp" %>