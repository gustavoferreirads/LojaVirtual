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
    <form id="form" role="form" action="salvarProduto" enctype="multipart/form-data" actionRemove="removeProduto">
        <input type="hidden" name="id" value="${produto.id}"/>

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
                <loja:input label="label.preco_de_venda" type="text" name="valorVenda" value="${produto.valorVenda}" classForm="margin-right-small" classe="form-control money" required="required" id="precoDeVenda"  placeHolder="0,00" />
                <loja:input label="label.preco_de_custo" type="text" name="valorLiquido" value="${produto.valorLiquido}" classe="form-control money" classForm="margin-right-small" id="precoDeCusto" required="'required'" placeHolder="0,00" />
                <loja:input label="label.estoque_inicial" format="number" type="number" name="quantidade" value="${produto.quantidade}" classe="form-control" id="estoqueInicial" required="required"/>
            </div>
        </div>

        <loja:selectOptions id="situacao" label="label.tipo_de_frete" name="situacao" list="${situacoes}" value="${produto.situacao}" classe="form-control"/>

        <%--Todo: colocar em uma tag --%>
        <div class="form-group">
            <label class="">Fotos: </label>
            <div id="drop_zone" class="empty" onclick="getFile();">
                <div id="list">
                    <c:forEach var="imagem" items="#{produto.imagens}">
                        <div class="photo">
                            <img id="${imagem.idImagem}" src="data:image/jpeg;base64,"<c:out value='${imagem.bytes}'/> />
                        </div>
                    </c:forEach>
                </div>
                <div class="fileHidden">
                    <input id="files" type="file" name="files" />
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
    </form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/file.upload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/mask.js"></script>