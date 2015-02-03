package br.com.lojavirtual.controller;

import br.com.lojavirtual.api.exception.ValidationException;
import br.com.lojavirtual.api.modelo.Usuario;
import br.com.lojavirtual.api.servico.IUsuarioDao;
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

import static br.com.lojavirtual.business.UsuarioBusiness.validate;
import static br.com.lojavirtual.util.GridList.formatJsonList;

/**
 * Created by Gustavo Ferreira on 19/09/2014.
 */

@Controller
public class UsuarioController extends ControllerAction {

    @Autowired
    @Qualifier("usuarioDAO")
    private IUsuarioDao usuarioDao;

    public UsuarioController() {
    }

    @RequestMapping("/login")
    public String execute() {
        return "portal/login";
    }

    @RequestMapping("/cadastroDeUsuario")
    public String abrirCadastro() {
        return "portal/usuario/cadastro";
    }

    @RequestMapping("/carregaUsuario")
    public String carregaUsuario(Long id, Model model) {
        model.addAttribute("usuario", usuarioDao.carreguePorId(id));
        return "portal/usuario/cadastro";
    }

    @RequestMapping("/logar")
    public String logar(Usuario usuario, HttpServletRequest request) {
        usuario = usuarioDao.busqueUsuarioPorLoginESenha(usuario);
        if (usuario != null) {
            request.getSession().setAttribute("usuarioLogado", usuario);
            return "portal/index";
        }
        addErrorMessage(request, "usuario_nao_encontrado");
        return "forward:login";
    }

    @RequestMapping("/salvarUsuario")
    public String salvarUsuario(Usuario usuario, Model model, HttpServletRequest request) {
        try {
            validate(usuario);
            model.addAttribute("usuario", usuarioDao.salve(usuario));
            addSucessMessage(request);
        } catch (ValidationException e) {
            addErrorMessage(request, e.getMessage());
        } catch (Exception e) {
            addErrorMessage(request);
            e.printStackTrace();
        } finally {
            return "portal/usuario/cadastro";
        }
    }

    @RequestMapping("/salvarUsuarioNovo")
    public String salvarENovoUsuario(Usuario usuario, Model model, HttpServletRequest request) {
        String retorno = salvarUsuario(usuario, model, request);
        model.addAttribute("usuario", new Usuario());
        return retorno;
    }

    @RequestMapping("/consultaUsuarios")
    public String lista() {
        return "portal/usuario/consulta";
    }

    @RequestMapping("/listaUsuarios")
    public void lista(HttpServletResponse response, @PathParam("current") Integer current, @PathParam("rowCount") Integer rowCount) {
        try {
            List<Usuario> usuarios = usuarioDao.busqueTodosLazy(((current - 1) * rowCount), rowCount, "");
            String jsonReturn = formatJsonList(response, usuarios, current, rowCount, String.valueOf(usuarioDao.busqueTodos().size()));
            response.getWriter().write(jsonReturn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/removeUsuarioId")
    public String removeUsuarioId(Long id, HttpServletRequest request) {
//        model.addAttribute("usuario", usuarioDao.carreguePorId(id));
        addSucessMessage(request);
        return "portal/usuario/consulta";
    }


    @RequestMapping("/removeUsuario")
    public String removeUsuario(Long id, Model model, HttpServletRequest request) {
        model.addAttribute("usuario", usuarioDao.carreguePorId(id));
        addSucessMessage(request);
        return "portal/usuario/consulta";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "forward:login";
    }
}
