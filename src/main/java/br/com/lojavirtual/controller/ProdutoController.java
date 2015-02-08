package br.com.lojavirtual.controller;

import br.com.lojavirtual.api.exception.ValidationException;
import br.com.lojavirtual.api.modelo.Produto;
import br.com.lojavirtual.api.servico.IProdutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

import static br.com.lojavirtual.business.ProdutoBusiness.validate;
import static br.com.lojavirtual.util.GridList.formatJsonList;

/**
 * Created by Gustavo Ferreira on 19/09/2014.
 */

@Controller
public class ProdutoController extends ControllerAction {

    @Autowired
    @Qualifier("produtoDAO")
    private IProdutoDao produtoDao;

    public ProdutoController() {
    }

    @RequestMapping("/cadastroDeProduto")
    public String abrirCadastro() {
        return "portal/produto/cadastro";
    }

    @RequestMapping("/carregaProduto")
    public String carregaProduto(Long id, Model model) {
        model.addAttribute("produto", produtoDao.carreguePorId(id));
        return "portal/produto/cadastro";
    }

    @RequestMapping("/salvarProduto")
    public String salvarProduto(Produto produto, Model model, HttpServletRequest request) {
        try {
            validate(produto);
            model.addAttribute("produto", produtoDao.salve(produto));
            addSucessMessage(request);
        } catch (ValidationException e) {
            addErrorMessage(request, e.getMessage());
        } catch (Exception e) {
            addErrorMessage(request);
            e.printStackTrace();
        } finally {
            return "portal/produto/cadastro";
        }
    }

    @RequestMapping("/salvarProdutoNovo")
    public String salvarENovoProduto(Produto produto, Model model, HttpServletRequest request) {
        String retorno = salvarProduto(produto, model, request);
        model.addAttribute("produto", new Produto());
        return retorno;
    }

    @RequestMapping("/consultaProdutos")
    public String lista() {
        return "portal/produto/consulta";
    }

    @RequestMapping("/listarProdutos")
    public void lista(HttpServletResponse response, @PathParam("current") Integer current, @PathParam("rowCount") Integer rowCount) {
        try {
            List<Produto> produtos = produtoDao.busqueTodosLazy(((current - 1) * rowCount), rowCount, "");
            String jsonReturn = formatJsonList(response, produtos, current, rowCount, String.valueOf(produtoDao.busqueTodos().size()));
            response.getWriter().write(jsonReturn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/removeProdutoId")
    public String removeProdutoId(Long id, HttpServletRequest request) {
        produtoDao.delete(produtoDao.carreguePorId(id));
        addSucessMessage(request);
        return "portal/produto/consulta";
    }


    @RequestMapping("/removeProduto")
    public String removeProduto(Produto produto,  HttpServletRequest request) {
        produtoDao.delete(produto);
        addSucessMessage(request);
        return "portal/produto/consulta";
    }
}
