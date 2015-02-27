package br.com.lojavirtual.controller;

import br.com.lojavirtual.api.exception.ValidationException;
import br.com.lojavirtual.api.modelo.Imagem;
import br.com.lojavirtual.api.modelo.Produto;
import br.com.lojavirtual.api.servico.IProdutoDao;
import br.com.lojavirtual.impl.servico.FileValidator;
import br.com.lojavirtual.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
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

    @Autowired
    private FileValidator validator;

    private Produto.TipoDeFrete[] fretes = Utils.sort(Produto.TipoDeFrete.values());
    private Produto.Situacao[] situacoes = Utils.sort(Produto.Situacao.values());

    private Produto produto;


    public ProdutoController() {
        init();
    }

    @RequestMapping("/cadastroDeProduto")
    public String abrirCadastro(Model model) {
        model.addAttribute("fretes", fretes);
        model.addAttribute("situacoes", situacoes);
        return "portal/produto/cadastro";
    }

    @RequestMapping("/carregaProduto")
    public String carregaProduto(Long id, Model model) {
        produto = produtoDao.carreguePorId(id);
        model.addAttribute("produto", produto);
        return "portal/produto/cadastro";
    }


    @RequestMapping("/salvarProduto")
    public String salvarProduto(Produto produto, Model model, HttpServletRequest request) {
        try {
            // TODO : posso implementar a classe org.springframework.validation.Validator
            validate(produto);
            produto = produtoDao.salve(produto);
            model.addAttribute("produto", produto);
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
        produto = new Produto();
        model.addAttribute("produto", produto);
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
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(MultipartHttpServletRequest request, HttpServletResponse response) {
        Iterator<String> itr = request.getFileNames();
        MultipartFile file = request.getFile(itr.next());
        try {
            Imagem imagem = new Imagem();
            imagem.setLength(file.getBytes().length);
            imagem.setBytes(file.getBytes());
            imagem.setType(file.getContentType());
            imagem.setDescricao(file.getOriginalFilename());
            produto.getImagens().add(imagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "<img class=\"thumb\" src='"+request.getRequestURL().toString().replace("upload","getLast")+"/"+new Date().getTime()+"'/>";
    }

    @RequestMapping(value = "/getLast/{value}", method = RequestMethod.GET)
    public void get(HttpServletResponse response, @PathVariable String value) {
        try {
            Integer last = produto.getImagens().size() - 1;
            response.setContentType(produto.getImagens().get(last).getType());
            response.setContentLength(produto.getImagens().get(last).getLength());
            FileCopyUtils.copy(produto.getImagens().get(last).getBytes(), response.getOutputStream());
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
    public String removeProduto(Produto produto, HttpServletRequest request) {
        produtoDao.delete(produto);
        init();
        addSucessMessage(request);
        return "portal/produto/consulta";
    }

    public void init() {
        produto = new Produto();
    }
}
