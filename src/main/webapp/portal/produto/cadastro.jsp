<%--
  Created by IntelliJ IDEA.
  User: Gustavo Ferreira
  Date: 20/09/2014\t
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="loja" %>

        <loja:cabecalhoInterno tituloAnterior="label.listagem_produtos" titulo="label.adicionar_produto" subTitulo="label.dados_produto" voltar="'consultaUsuarios'" />
        <div class="boxConteudoBlocoPagina">
        <form id="form" role="form" action="salvarUsuario"  actionRemove="removeUsuario">
                <input type="hidden" name="id" value="${produto.id}"/>

                <loja:input     id="nome"
                                label="label.nome"
                                type="text"
                                name ="nome"
                                value ="${produto.nome}"
                                classe ="form-control"
                                required="required"
                                placeholder="Insira o nome do usuário..." />


                <loja:text-area label="label.descricao"
                                type="text"
                                name="nome"
                                value="${produto.descricao}"
                                classe="form-control"
                                required="required"
                                id="nome"
                                row="3" />

                <div class="form-inline">
                </div>
               <loja:botoesDeAcao msg_dialog="msg_remocao_produto" disabledRemove="${produto.id != null}" voltar="'consultaUsuarios'"/>
        </form>
    </div>