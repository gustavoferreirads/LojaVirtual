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

<div class="content">
    <div class="breadCrumbs" style="width: 1024px;">
        <div class="conteudoBreadCrumbs">
            <div class="boxConteudo">
				<span class=" menuBreadCrumb breadCrumbLinkValido">
                <img src="${pageContext.request.contextPath}/resources/images/icons/home.png">
                    <a href="home">Início</a></span>
				<span class=" menuBreadCrumb breadCrumbLinkValido">
                    <a href="#">Listagem de Usuários</a></span>
				<span class=" menuBreadCrumb breadCrumbLinkInvalido breadCrumbAtual">
                    <img src="http://www.lojavirtual.com.br/img/admin_loja/icone_editar.png">
                                            Adicionar Usuário
                </span>
            </div>
        </div>
    </div>
    <div class="subTitulo timeLineAnchor">Dados do Usuário</div>
    <div class="boxInformacoesPrincipais boxConteudoBlocoPagina">
    <form role="form">
        <div class="form-group">
            <label for="exampleInputEmail1">E-mail</label>
            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Insira seu email...">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Senha</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha...">
        </div>
        <div class="form-group">
            <label for="exampleInputFile">Foto</label>
            <input type="file" id="exampleInputFile">

            <p class="help-block">Escolha uma foto em seu computador.</p>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> Administrador?
            </label>
        </div>
        <button type="submit" class="btn btn-success">Salvar</button>
    </form>
</div>
</div>