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

<div class="content" >
    <h1>Cadastro de Usuário</h1>
    <p>Aqui você pode gerenciar e administrar sua loja virtual.</p>

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