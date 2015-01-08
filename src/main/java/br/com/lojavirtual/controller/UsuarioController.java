package br.com.lojavirtual.controller;

import br.com.lojavirtual.api.modelo.Usuario;
import br.com.lojavirtual.api.servico.IUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            model.addAttribute("tarefa", usuarioDao.salve(usuario));
            request.setAttribute("sucess", "msg_operacao_sucesso");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "portal/usuario/cadastro";
    }

    @RequestMapping("listaTarefas")
    public String lista(Model model) {
        model.addAttribute("usuarios", usuarioDao.busqueTodos());
        return "portal/usuario/lista";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "forward:login";
    }

}
