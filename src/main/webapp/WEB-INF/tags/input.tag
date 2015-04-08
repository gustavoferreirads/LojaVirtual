<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="type" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="classe" required="false" %>
<%@ attribute name="required" required="false" %>
<%@ attribute name="classeLabel" required="false" %>
<%@ attribute name="sizeInput" required="false" %>
<%@ attribute name="placeHolder" required="false" %>
<%@ attribute name="value" required="false" %>
<%@ attribute name="format" required="false" %>
<%@ attribute name="autoFocus" required="false" %>
<%@ attribute name="classForm" required="false" %>
<%@ attribute name="simbol" required="false" %>
<%@ attribute name="iconLabel" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="form-group ${classForm}">
    <c:if test="${not empty iconLabel}"  >
        <img class="vertical-align-text-bottom" src="${pageContext.request.contextPath}/resources/images/icons/${iconLabel}"/>
    </c:if>
    <label for="${id}" class="${classeLabel}"><fmt:message key="${label}"/>: </label>

    <div class="${sizeInput}">
            <c:if test="${not empty simbol}"  >
                <div class="input-group">
                    <div class="input-group-addon"><fmt:message key="${simbol}"/></div>
            </c:if>

            <input id="${id}"
                   class="${classe}"
                   autofocus="${autoFocus}"
                   name="${name}"
                   format="${format}"
                   value="${value}"
                   required="${required}"
                   type="${type}"
                   placeholder="${placeHolder}"/>

            <c:if  test="${not empty simbol}">
                </div>
            </c:if>
    </div>
</div>