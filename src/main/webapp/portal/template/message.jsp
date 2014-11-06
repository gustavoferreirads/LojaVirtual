<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% if(request.getAttribute("error") != null){ %>

<div class="alert alert-danger" role="alert">
    <p> <fmt:message key="${error}"/></p>
</div>
<%}%>

<% if(request.getAttribute("sucess") != null){ %>

<div class="alert alert-success" role="alert">
    <p> <fmt:message key="${sucess}"/></p>
</div>
<%}%>

