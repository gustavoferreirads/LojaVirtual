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

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title></title>
</head>


<html>
<body>
<h3>Bem vindo</h3>

<%@ include file="portal/template/menu.jsp" %>

<form action="logar" method="post">
    <!--<div style="display:none; ">-->




    <%@ include file="portal/template/message.jsp" %>

    Login: <br/> <input type="text" name="login"/><br/>
    Senha: <br/> <input type="password" name="senha"/><br/>
    <input type="submit" value="Login">
</form>

<%@ include file="portal/template/footer.jsp" %>
</body>
</html>
