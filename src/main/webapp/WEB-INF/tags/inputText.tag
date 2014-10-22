
<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="type" required="true" %>
<%@ attribute name="cssClass" required="false" %>
<%@ attribute name="placeHolder" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<label for="${id}" class="label-default"> <fmt:message key="${label}"/>:  </label>
<input class="${cssClass}" placeholder="${placeHolder}" type="${type}" id="${id}" name="${id}" />