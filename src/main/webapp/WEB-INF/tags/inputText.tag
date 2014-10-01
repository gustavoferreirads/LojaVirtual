<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="type" required="true" %>

<label for="${id}"><fmt:message key="${label}"/></label>
<input type="${type}" id="${id}" name="${id}" />