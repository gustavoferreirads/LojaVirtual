<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="classe" required="false" %>
<%@ attribute name="required" required="false" %>
<%@ attribute name="classeLabel" required="false" %>
<%@ attribute name="sizeInputClass" required="false" %>
<%@ attribute name="list" type="java.lang.Object"  required="true" %>
<%@ attribute name="value" required="true" %>
<%@ attribute name="classForm" required="false" %>
<%@ attribute name="sizeInput" required="false" %>
<div class="${classForm}">
    <label for="${id}" class="${classeLabel}"><fmt:message key="${label}"/>: </label>
    <div class="${sizeInput}">
        <form:select id="${id}" path="${name}"  cssClass="${classe}"  >
            <form:options items="${list}" itemLabel="nome"  />
        </form:select>
        <%--<select name="${name}" onchange=""  class="${classe}" id="${id}" required="${required}">--%>
            <%--<c:forEach items="${list}" var="item">--%>
                <%--<option value="${item}" ${value == item ? 'selected' : ''}>--%>
                    <%--<c:out value="${item}"/>--%>
                <%--</option>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>
    </div>

</div>
