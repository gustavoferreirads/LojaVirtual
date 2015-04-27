<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="accordian">
    <ul>
        <li class="active">
            <h3><img class="icon-menu"
                     src="${pageContext.request.contextPath}/resources/images/icons/conteudo.png"/>Catálago</h3>
            <ul>
                <li><a href="#">Clientes</a></li>
                <li><a href="#" action="consultaProdutos">Produtos</a></li>
                <li><a href="#" action="consultaCategorias">Categorias</a></li>
            </ul>
        </li>
        <li class="active">
            <h3><img class="icon-menu"
                     src="${pageContext.request.contextPath}/resources/images/icons/catalago.png"/>Conteúdo</h3>
            <ul>
                <li><a href="#">Comentários</a></li>
                <li><a href="#">Chamados</a></li>
                <li><a href="#">Rastreio</a></li>
            </ul>
        </li>
        <li class="">
            <h3><img class="icon-menu"
                     src="${pageContext.request.contextPath}/resources/images/icons/marketing2.png"/>Marketing</h3>
            <ul>
                <li><a href="#">Promoção</a></li>
                <li><a href="#">Destaque</a></li>
                <li><a href="#">Cupom de Desconto</a></li>
                <li><a href="#">Notificações</a></li>
                <li><a href="#">Mala Direta</a></li>
            </ul>
        </li>
        <li>
            <h3><img class="icon-menu"
                     src="${pageContext.request.contextPath}/resources/images/icons/financeiro.png"/>Financeiro</h3>
            <ul>
                <li><a href="#">Vendas</a></li>
                <li><a href="#">Pedidos</a></li>
            </ul>
        </li>
        <li>
            <h3><img class="icon-menu"
                     src="${pageContext.request.contextPath}/resources/images/icons/relatorio.png"/>Relatório</h3>
            <ul>
                <li><a href="#">Faturamento</a></li>
                <li><a href="#">Estoque</a></li>
                <li><a href="#" action="consultaClientes">Cliente</a></li>
                <li><a href="#">Produtos</a></li>
            </ul>
        </li>
        <li>
            <h3><img class="icon-menu"
                     src="${pageContext.request.contextPath}/resources/images/icons/seguranca.png"/>Segurança</h3>
            <ul>
                <li><a href="#" action="consultaUsuarios">Usuários</a></li>
                <li><a href="#">Grupos</a></li>
                <li><a href="#">Permissões</a></li>
                <li><a href="#">Backup</a></li>
            </ul>
        </li>
        <li>
            <h3><img class="icon-menu"
                     src="${pageContext.request.contextPath}/resources/images/icons/configuracao1.png"/>Configurações
            </h3>
            <ul>
                <li class="active"><a id="menu" href="#">Aparência Geral</a></li>
                <li><a href="#">Banner</a></li>
                <li><a href="#">Formas de Envio</a></li>
                <li><a href="#">Formas de Pagamento</a></li>
                <li><a href="#">Configurações Gerais</a></li>
            </ul>
        </li>
    </ul>
</div>
<div id="content" class="content">