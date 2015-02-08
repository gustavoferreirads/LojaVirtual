<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="type" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="classe" required="false" %>
<%@ attribute name="required" required="false" %>
<%@ attribute name="classeLabel" required="false" %>
<%@ attribute name="sizeInputClass" required="false" %>
<%@ attribute name="placeholder" required="false" %>
<%@ attribute name="value" required="false" %>

<%@ attribute name="classForm" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="form-group ${classForm}">
    <label for="${id}" class="${classeLabel}"><fmt:message key="${label}"/>: </label>
    <div class="${sizeInputClass}">
        <input class="${classe}" name="${name}" value="${value}" required="${required}" placeholder="${placeHolder}" type="${type}" id="${id}" />
    </div>
</div>