package br.com.lojavirtual.controller;

import br.com.lojavirtual.api.modelo.Usuario;
import br.com.lojavirtual.api.servico.IUsuarioDao;
import br.com.lojavirtual.util.GridList;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import static br.com.lojavirtual.util.GridList.formatJsonList;
import static java.lang.String.format;

/**
 * Created by Gustavo Ferreira on 19/09/2014.
 */

@Controller
public class UsuarioController {

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
    public String executeCadastro() {
        return "portal/usuario/cadastro";
    }

    @RequestMapping("/logar")
    public String logar(Usuario usuario, HttpServletRequest request) {
        usuario = usuarioDao.busqueUsuarioPorLoginESenha(usuario);
        if (usuario != null) {
            request.getSession().setAttribute("usuarioLogado", usuario);
            return "portal/index";
        }
        request.setAttribute("error", "usuario_nao_encontrado");

        return "forward:login";
    }

    @RequestMapping("/salvarUsuario")
    public String salvarUsuario(Usuario usuario, Model model, HttpServletRequest request) {
        try {
            model.addAttribute("usuario", usuarioDao.salve(usuario));
            request.setAttribute("sucess", "msg_operacao_sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "msg_operacao_erro");
        } finally {
            return "portal/usuario/cadastro";
        }
    }

    @RequestMapping("/consultaUsuarios")
    public String lista(Model model) {
        model.addAttribute("usuarios", usuarioDao.busqueTodos());
        return "portal/usuario/consulta";
    }

    @RequestMapping("/carregaUsuarios")
    public void lista(HttpServletResponse response, @PathParam("current") String current, @PathParam("rowCount") String rowCount) {
        try {
            List<Usuario> usuarios = usuarioDao.busqueTodosLazy(new Integer(current), new Integer(rowCount), "");
            String jsonReturn = formatJsonList(response, usuarios, current, rowCount);
            response.getWriter().write(jsonReturn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "forward:login";
    }

}
