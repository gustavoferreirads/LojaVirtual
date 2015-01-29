<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-inner"  >
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand brand portal-color-white"  href="#">
                    Minha Loja
                    <span class="portal-color-secundary">Virtual</span>
                </a>
                <p class="pull-right portal-sair" >
                    <a class="btn btn-danger btn-xs" role="button" href="logout">Sair</a>
                </p>
                <p class="navbar-text pull-right portal-color-white" >
                    <span class="portal-color-secundary">Olá</span>  ${usuarioLogado.nome}!
                </p>
            </div>
            <div class="navbar-collapse collapse " >
                <ul class="nav navbar-nav">
                    <li><a class="a-menu-portal portal-color-white" href="home">Home</a></li>
                    <li><a class="a-menu-portal portal-color-white" href="#about">Sobre</a></li>
                    <li><a class="a-menu-portal portal-color-white" href="#contact">Contato</a></li>
                </ul>
            </div><!--/.navbar-collapse -->
        </div>
    </div>
<div id="accordian">
    <ul>
        <li class="active">
            <h3><img class="icon-menu" src="${pageContext.request.contextPath}/resources/images/icons/catalago.png"/>Catálago</h3>
            <ul>
                <li><a  href="#">Produtos</a></li>
            </ul>
        </li>
        <li class="active">
            <h3><img class="icon-menu" src="${pageContext.request.contextPath}/resources/images/icons/catalaco.png"/>Conteúdo</h3>
            <ul>
                <li><a href="#">Categoria</a></li>
                <li><a href="#">Sub Categoria</a></li>
            </ul>
        </li>
        <li class="active">
            <h3><img class="icon-menu" src="${pageContext.request.contextPath}/resources/images/icons/marketing2.png"/>Marketing</h3>
            <ul>
                <li><a href="#">Banner</a></li>
                <li><a href="#">Destaque</a></li>
                <li><a href="#">Promoção</a></li>
                <li><a href="#">Cupom de Desconto</a></li>
            </ul>
        </li>
        <li >
            <h3><img class="icon-menu" src="${pageContext.request.contextPath}/resources/images/icons/financeiro.png"/>Financeiro</h3>
            <ul>
                <li><a href="#">Vendas</a></li>
                <li><a href="#">Pedidos</a></li>
                <li><a href="#">Clientes</a></li>
            </ul>
        </li>
        <li>
            <h3><img class="icon-menu" src="${pageContext.request.contextPath}/resources/images/icons/relatorio.png"/>Relatório</h3>
            <ul>
                <li><a href="#">Faturamento</a></li>
                <li><a href="#">Estoque</a></li>
                <li><a href="#">Cliente</a></li>
                <li><a href="#">Produtos</a></li>
            </ul>
        </li>
        <li>
            <h3><img class="icon-menu" src="${pageContext.request.contextPath}/resources/images/icons/seguranca.png"/>Segurança</h3>
            <ul>
                <li><a href="#" action="cadastroDeUsuario" >Usuários</a></li>
                <li><a href="#" action="consultaUsuarios"> Usuários Consulta</a></li>
                <li><a href="#">Grupos</a></li>
                <li><a href="#">Permissões</a></li>
            </ul>
        </li>
        <li>
            <h3><img class="icon-menu" src="${pageContext.request.contextPath}/resources/images/icons/configuracao1.png"/>Configurações</h3>
            <ul>
                <li  class="active"><a id="menu" href="#">Logo</a></li>
                <li><a href="#">Cores</a></li>
                <li><a href="#">Layout</a></li>
                <li><a href="#">Endereco</a></li>
            </ul>
        </li>
    </ul>
</div>