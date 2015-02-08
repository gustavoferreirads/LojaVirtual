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

    <loja:cabecalhoInterno tituloAnterior="label.listagem_usuarios" titulo="label.adicionar_usuario" subTitulo="label.dados_usuario" voltar="'consultaUsuarios'" />

        <div class="boxConteudoBlocoPagina">
        <form id="form" role="form" action="salvarUsuario"  actionRemove="removeUsuario">
                <input type="hidden" name="id" value="${usuario.id}"/>
                <loja:input label="label.nome" type="text" name="nome" value="${usuario.nome}"  classe="form-control" required="required" id="nome" placeholder="Insira o nome do usuário..." />
                <div class="form-inline">
                    <loja:input label="label.email" type="email" name="login" value="${usuario.login}" classForm="margin-right-small" classe="form-control" required="required" id="email" placeholder="Insira seu email..." />
                    <loja:input label="label.senha" type="password" name="senha" classe="form-control" classForm="margin-right-small" id="senha" required="required" placeholder="Senha..."/>
                    <loja:input label="label.confirma_senha" type="password" name="confirmSenha" classe="form-control" id="senha" required="required" placeholder="Senha..."/>
                </div>
               <loja:botoesDeAcao msg_dialog="msg_remocao_usuario" disabledRemove="${usuario.id != null}" voltar="'consultaUsuarios'"/>
        </form>

    </div>