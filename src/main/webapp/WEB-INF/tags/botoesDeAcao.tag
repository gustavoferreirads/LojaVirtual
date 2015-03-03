<%@ attribute name="disabledRemove" required="true" %>
<%@ attribute name="voltar" required="false" %>
<%@ attribute name="msg_dialog" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="form-actions-button">
    <button type="submit" class="btn btn-success" onclick="submitForm();"><fmt:message key="label.salvar"/></button>
    <button type="submit" class="btn btn-default" onclick="submitNewForm();"><fmt:message key="label.salvar_novo"/></button>
    <button type="button" class="btn btn-danger bt-remove ${disabledRemove == false ? 'hidden' : ''}" data-toggle="modal" data-target=".modalDialog" ><fmt:message key="label.remover"/></button>
    <button type="button" class="btn btn-primary btn-back ${voltar == null ? 'hidden' : ''}"  onclick="goBack(${voltar});" ><fmt:message key="label.voltar"/></button>
</div>

<div class="modal fade modalDialog" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span></button>
                <h4 class="modal-title" id="mySmallModalLabel">
                    <fmt:message key="label.atencao"/>
                </h4>
            </div>
            <div class="modal-body">
                <fmt:message key="${msg_dialog}"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="label.nao"/></button>
                <button type="button" class="btn btn-default bt-remove" data-toggle="modal" onclick="removeObject();" data-target=".modalDialog" >
                    <fmt:message key="label.sim"/>
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div>