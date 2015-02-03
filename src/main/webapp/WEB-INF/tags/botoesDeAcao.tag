<%@ attribute name="disabledRemove" required="true" %>
<%@ attribute name="voltar" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="form-actions-button">
    <button type="submit" class="btn btn-default" onclick="submitForm();"><fmt:message key="label.salvar"/></button>
    <button type="submit" class="btn btn-default" onclick="submitNewForm();"><fmt:message key="label.salvar_novo"/></button>
    <button type="submit" class="btn btn-danger ${disabledRemove == false ? 'hidden' : ''}" onclick="removeObject();"><fmt:message key="label.remover"/></button>
    <button type="submit" class="btn btn-primary btn-back ${voltar == null ? 'hidden' : ''}"  onclick="goBack(${voltar});"><fmt:message key="label.voltar"/></button>
</div>