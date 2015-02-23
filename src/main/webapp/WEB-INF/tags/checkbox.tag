<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="required" required="false" %>
<%@ attribute name="classeLabel" required="false" %>
<%@ attribute name="value" required="true" %>
<%@ attribute name="classForm" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="form-group ${classForm}">
    <label class="checkbox-inline ${classeLabel}">
        <input type="checkbox" id="${id}" value="${value}" name="${name}" required="${required}">
        <fmt:message key="${label}"/>
    </label>
</div>