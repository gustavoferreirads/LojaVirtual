<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-inner"  style="color: #ffffff;">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar">e</span>
                    <span class="icon-bar">eqweqwe</span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand brand"  style="color: #ffffff;" href="#">Minha Loja Virtual</a>
                <p class="navbar-text pull-right" style="color: #ffffff;">
                    Olá ${usuarioLogado.nome}
                </p>
            </div>
            <div class="navbar-collapse collapse " >
                <ul class="nav navbar-nav">
                    <li class=""><a href="#">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
                <form class="navbar-form navbar-right" role="form" action="logar" method="post">
                </form>
            </div><!--/.navbar-collapse -->
        </div>
    </div>
<div id="accordian">
    <ul>
        <li class="active">
            <h3><span class="icon-dashboard"></span>Catálago</h3>
            <ul>
                <li><a href="#">Reports</a></li>
                <li><a href="#">Search</a></li>
                <li><a href="#">Graphs</a></li>
                <li><a href="#">Settings</a></li>
            </ul>
        </li>
        <li >
            <h3><span class="icon-tasks"></span>Conteúdo</h3>
            <ul>
                <li><a href="#">Today's tasks</a></li>
                <li><a href="#">Urgent</a></li>
                <li><a href="#">Overdues</a></li>
                <li><a href="#">Recurring</a></li>
                <li><a href="#">Settings</a></li>
            </ul>
        </li>
        <li >
            <h3><span class="icon-tasks"></span>Vendas</h3>
            <ul>
                <li><a href="#">Today's tasks</a></li>
                <li><a href="#">Urgent</a></li>
                <li><a href="#">Overdues</a></li>
                <li><a href="#">Recurring</a></li>
                <li><a href="#">Settings</a></li>
            </ul>
        </li>
        <!-- we will keep this LI open by default -->
        <li class="active">
            <h3><span class="icon-tasks"></span>Relatório</h3>
            <ul>
                <li><a href="#">Today's tasks</a></li>
                <li><a href="#">Urgent</a></li>
                <li><a href="#">Overdues</a></li>
                <li><a href="#">Recurring</a></li>
                <li><a href="#">Settings</a></li>
            </ul>
        </li>
        <li>
            <h3><span class="icon-calendar"></span>Segurança</h3>
            <ul>
                <li><a href="#">Current Month</a></li>
                <li><a href="#">Current Week</a></li>
                <li><a href="#">Previous Month</a></li>
                <li><a href="#">Previous Week</a></li>
                <li><a href="#">Next Month</a></li>
                <li><a href="#">Next Week</a></li>
                <li><a href="#">Team Calendar</a></li>
                <li><a href="#">Private Calendar</a></li>
                <li><a href="#">Settings</a></li>
            </ul>
        </li>
        <li>
            <h3><span class="icon-heart"></span>Configurações</h3>
            <ul>
                <li><a href="#">Global favs</a></li>
                <li><a href="#">My favs</a></li>
                <li><a href="#">Team favs</a></li>
                <li><a href="#">Settings</a></li>
            </ul>
        </li>
    </ul>
</div>