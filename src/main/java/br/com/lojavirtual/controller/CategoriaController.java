package br.com.lojavirtual.controller;

import br.com.lojavirtual.api.exception.ValidationException;
import br.com.lojavirtual.api.modelo.Categoria;
import br.com.lojavirtual.api.servico.ICategoriaDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

/**
 * Created by Gustavo Ferreira on 19/09/2014.
 */

@Controller
public class CategoriaController extends ControllerAction {

    @Inject
    private ICategoriaDao categoriaDao;

    public CategoriaController() {
    }

    @RequestMapping("/cadastroDeCategoria")
    public String abrirCadastro() {
        return "portal/categoria/cadastro";
    }

    @RequestMapping("/carregaCategoria")
    public String carregaCategoria(Long id, Model model) {
        model.addAttribute("categoria", categoriaDao.carreguePorId(id));
        return "portal/categoria/cadastro";
    }

    @RequestMapping("/salvarCategoria")
    public String salvarCategoria(Categoria categoria, Model model, HttpServletRequest request) {
        try {
            model.addAttribute("categoria", categoriaDao.salve(categoria));
            addSucessMessage(request);
        } catch (ValidationException e) {
            addErrorMessage(request, e.getMessage());
        } catch (Exception e) {
            addErrorMessage(request);
            e.printStackTrace();
        } finally {
            return "portal/categoria/cadastro";
        }
    }

    @RequestMapping("/salvarCategoriaNovo")
    public String salvarENovoCategoria(Categoria categoria, Model model, HttpServletRequest request) {
        String retorno = salvarCategoria(categoria, model, request);
        model.addAttribute("categoria", new Categoria());
        return retorno;
    }

    @RequestMapping("/consultaCategorias")
    public String lista() {
        return "portal/categoria/consulta";
    }

    @RequestMapping("/listarCategorias")
    public void lista(HttpServletResponse response, @PathParam("current") Integer current, @PathParam("rowCount") Integer rowCount) {
        try {
//            String jsonReturn = formatJsonList(response, categorias, current, rowCount, String.valueOf(categoriaDao.busqueTodos().size()));
//            response.getWriter().write(jsonReturn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/removeCategoriaId")
    public String removeCategoriaId(Long id, HttpServletRequest request) {
        categoriaDao.delete(categoriaDao.carreguePorId(id));
        addSucessMessage(request);
        return "portal/categoria/consulta";
    }

    @RequestMapping("/removeCategoria")
    public String removeCategoria(Categoria categoria,  HttpServletRequest request) {
        categoriaDao.delete(categoria);
        addSucessMessage(request);
        return "portal/categoria/consulta";
    }

}
