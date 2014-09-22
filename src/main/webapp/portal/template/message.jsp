<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% if(request.getAttribute("error") != null){ %>
<div id="messageError" style=" color: red;">
    <p> <fmt:message key="${error}"/></p>
</div>
<%}%>

