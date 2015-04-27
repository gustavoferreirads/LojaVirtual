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

                <button type="button" class="navbar-toggle lateral collapsed" data-toggle="collapse" data-target="#accordian">
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
                    <span class="portal-color-secundary">Olá</span>  ${usuarioLogado.nome} <span>!</span>
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
<div id="main">