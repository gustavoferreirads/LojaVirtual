<%--
  Created by IntelliJ IDEA.
  User: Gustavo Ferreira
  Date: 20/09/2014\t
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="loja" %>


<loja:cabecalhoInterno tituloAnterior="label.listagem_produtos" titulo="label.adicionar_produto"
                       subTitulo="label.dados_produto" voltar="'consultaProdutos'"/>
<div class="boxConteudoBloco">

    <form:form id="form" modelAttribute="produto" action="salvarProduto" method="post"  actionRemove="removeProduto" enctype="multipart/form-data">

        <input type="hidden" name="id" value="${produto.id}"/>
        <input type="hidden" name="dataCadastro" value="${produto.dataCadastro}"/>

        <loja:input id="nome"
                    label="label.nome"
                    type="text"
                    name="nome"
                    value="${produto.nome}"
                    classe="form-control"
                    required="required"
                    placeHolder="Insira o nome do Produto..."/>

        <div class="form-group">
            <div class="form-inline">
                <loja:input label="label.preco_de_venda" type="text" name="valorVenda" value="${produto.valorVenda}" classForm="margin-right-small" classe="form-control money" required="required" id="precoDeVenda"  placeHolder="0,00"  autoFocus="true"/>
                <loja:input label="label.preco_de_custo" type="text" name="valorLiquido" value="${produto.valorLiquido}" classe="form-control money" classForm="margin-right-small" id="precoDeCusto" required="required" placeHolder="0,00" />
                <loja:input label="label.estoque_inicial" format="number" type="number" name="quantidade" value="${produto.quantidade}" classe="form-control" id="estoqueInicial" required="required" placeHolder="0"/>
            </div>
        </div>
        <loja:selectOptions id="situacao" label="label.situacao" name="situacao" list="${situacoes}" value="${produto.situacao}"  classForm="margin-right-mini" classe="form-control"/>

        <div id="frete_correio" class="form-group">
            <div class="form-inline">
                <loja:selectOptions id="tipoDeFrete" label="label.tipo_de_frete" name="tipoDeFrete" list="${fretes}" value="${produto.tipoDeFrete}" classForm="margin-right-mini" classe="form-control"/>
                <loja:input label="label.peso" type="text" name="peso" value="${produto.peso}" classForm="margin-right-mini" classe="form-control weight" sizeInput="input-small-to-medium" required="required" id="peso"  placeHolder="0,000" />
                <loja:input label="label.altura" type="number" name="altura" value="${produto.altura}" classForm="margin-right-mini" classe="form-control " sizeInput="input-small-to-medium" required="required" id="altura" placeHolder="0" />
                <loja:input label="label.largura" type="number" name="largura" value="${produto.largura}" classForm="margin-right-mini" classe="form-control" sizeInput="input-small-to-medium" required="required" id="largura"  placeHolder="0" />
                <loja:input label="label.profundidade" type="number" name="profundidade" value="${produto.profundidade}"  classForm="" classe="form-control" sizeInput="input-small-to-medium" id="profundidade" required="required" placeHolder="0" />
            </div>
        </div>

        <loja:checkbox id="paginaInicial" label="label.exibir_pagina_inicial" value="${produto.paginaInicial}" name="paginaInicial" classForm="margin-right-mini" />
        <loja:checkbox id="paginaInicial" label="label.exibir_pagina_banner" value="${produto.banner}" name="banner" classForm="margin-right-mini" />
        <loja:checkbox id="paginaInicial" label="label.exibir_lancamento" value="${produto.lancamento}" name="lancamento" />

        <%--Todo: colocar em uma tag --%>
        <div class="form-group">
            <label class="">Fotos: </label>
            <div id="drop_zone" class="empty">
                <div id="list">
                    <c:forEach var="imagem" items="#{produto.imagens}">
                        <div class="photo">
                            <img id="${imagem.uuid}" src="data:image/jpeg;base64,"<c:out value='${imagem.bytes}'/> />
                        </div>
                    </c:forEach>
                    <div class="photo">
                        <img id="empty" src="${pageContext.request.contextPath}/resources/images/icons/empty.png" data-toggle="tooltip" data-placement="top" title="Clique para adicionar uma imagem" onclick="getFile();" />
                    </div>
                </div>
            </div>
        </div>
        <loja:text-area label="label.descricao"
                        type="text"
                        name="descricao"
                        value="${produto.descricao}"
                        classe="form-control"
                        required="required"
                        id="descricao"
                        row="3"/>

        <loja:botoesDeAcao msg_dialog="msg_remocao_produto" disabledRemove="${usuario.id != null}" voltar="'consultaProdutos'"/>
    </form:form>


    <div class="fileHidden">
        <input id="files" type="file" name="files" />
    </div>

    <div class="modal fade modalPreview" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span></button>
                    <h4 class="modal-title" id="myLargeModalLabel">
                        <fmt:message key="label.pre_visualizacao"/>
                    </h4>
                </div>
                <div class="modal-body">
                    <div id="preview">
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="btRemoveImg" type="button" class="btn btn-danger" data-toggle="modal" data-target=".modalPreview" ><fmt:message key="label.excluir_foto"/></button>
                    <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="label.fechar"/></button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/file.upload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/mask.js"></script>