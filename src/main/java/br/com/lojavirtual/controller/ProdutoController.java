package br.com.lojavirtual.controller;

import br.com.lojavirtual.api.exception.ValidationException;
import br.com.lojavirtual.api.modelo.Imagem;
import br.com.lojavirtual.api.modelo.Produto;
import br.com.lojavirtual.api.servico.IProdutoDao;
import br.com.lojavirtual.impl.servico.FileValidator;
import br.com.lojavirtual.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static br.com.lojavirtual.business.ProdutoBusiness.validate;
import static br.com.lojavirtual.util.GridList.formatJsonList;

/**
 * Created by Gustavo Ferreira on 19/09/2014.
 */

@Controller
public class ProdutoController extends ControllerAction {

    private final String TAG_IMG = "<img id=\"%s\" class=\"thumb\" data-placement=\"top\" data-toggle=\"tooltip\" title=\"Clique para editar\" src='%s/%s'/>";

    @Inject
    private IProdutoDao produtoDao;

    @Autowired
    private FileValidator validator;
    private Produto.TipoDeFrete[] fretes = Utils.sort(Produto.TipoDeFrete.values());
    private Produto.Situacao[] situacoes = Utils.sort(Produto.Situacao.values());
    private List<Imagem> imagens = new ArrayList<>();


    private void adicionaListas(Model model) {
        model.addAttribute("fretes", fretes);
        model.addAttribute("situacoes", situacoes);
    }

    @RequestMapping("/consultaProdutos")
    public String lista() {
        return "portal/produto/consulta";
    }

    @RequestMapping("/listarProdutos")
    public void lista(HttpServletResponse response, @PathParam("current") Integer current, @PathParam("rowCount") Integer rowCount) {
        try {
            List<Produto> produtos = produtoDao.busqueTodosLazy(((current - 1) * rowCount), rowCount, "");
            String jsonReturn = formatJsonList(response, produtos, current, rowCount, String.valueOf(produtoDao.busqueTodos().size())); //TODO: Tem que implementar um count
            response.getWriter().write(jsonReturn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/cadastroDeProduto")
    public String abrirCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        adicionaListas(model);
        return "portal/produto/cadastro";
    }

    @RequestMapping("/carregaProduto")
    public String carregaProduto(Long id, Model model) {
        Produto produto = produtoDao.carreguePorId(id);
        model.addAttribute("produto", produto);
        adicionaListas(model);
        imagens = produto.getImagens();
        return "portal/produto/cadastro";
    }


    @RequestMapping("/salvarProduto")
    public String salvarProduto(Produto produto, Model model, HttpServletRequest request) {
        try {
            validate(produto);
            produto.setImagens(imagens);
            produto.setUsuario((br.com.lojavirtual.api.modelo.Usuario) request.getSession().getAttribute("usuarioLogado"));
            produto = produtoDao.salve(produto);
            model.addAttribute("produto", produto);
            adicionaListas(model);
            setImagens(produto.getImagens());
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
        produto = new Produto();
        model.addAttribute("produto", produto);
        adicionaListas(model);
        setImagens(produto.getImagens());
        return "portal/produto/cadastro";
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(MultipartHttpServletRequest request, HttpServletResponse response) {
        try {
            Imagem imagem = new Imagem();
            Iterator<String> itr = request.getFileNames();
            MultipartFile file = request.getFile(itr.next());
            imagem.setLength(file.getBytes().length);
            imagem.setBytes(file.getBytes());
            imagem.setType(file.getContentType());
            imagem.setDescricao(file.getOriginalFilename());
            imagens.add(imagem);

            return String.format(TAG_IMG, imagem.getUuid(), request.getRequestURL().toString().replace("upload", "getImg"), imagem.getUuid());
        } catch (IOException e) {e.printStackTrace();}

        return "";
    }

    @RequestMapping(value = "/getImg/{value}", method = RequestMethod.GET)
    public void get(HttpServletResponse response, @PathVariable String value) {
        try {
            Imagem imagem = getImage(value);
            response.setContentType(imagem.getType());
            response.setContentLength(imagem.getLength());
            FileCopyUtils.copy(imagem.getBytes(), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/removeImg", method = RequestMethod.GET)
    public void removeImg(HttpServletResponse response, @PathParam(value = "id") String uuId) {
        imagens.remove(getImage(uuId));
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
        addSucessMessage(request);
        return "portal/produto/consulta";
    }

    private Imagem getImage(String uuId) {
        for (Imagem imagem : imagens) {
            if (imagem.getUuid().equals(uuId)) {
                return imagem;
            }
        }
        return null;
    }


    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
}
