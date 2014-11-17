<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="type" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="classe" required="false" %>
<%@ attribute name="required" required="false" %>
<%@ attribute name="classeLabel" required="false" %>
<%@ attribute name="placeholder" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="form-group">
    <label for="${id}" class="${classe}"> <fmt:message key="${label}"/>: </label>
    <input class="$" name="${name}" required="${required}" placeholder="${placeHolder}" type="${type}"
           id="${id}" name="${id}"/>
</div>