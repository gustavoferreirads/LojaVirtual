package br.com.lojavirtual.controller;

import br.com.lojavirtual.api.modelo.Usuario;
import br.com.lojavirtual.api.servico.IUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
        System.out.println("Executando a lógica com Spring MVC");
        return "portal/login";
    }

    @RequestMapping("/logar")
    public String logar(Usuario usuario,HttpServletRequest request, HttpSession session) {
        usuario = usuarioDao.busqueUsuarioPorLoginESenha(usuario);

        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            return "portal/index";
        }

        request.setAttribute("error","usuario_nao_encontrado");
        return "forward:login";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "forward:login";
    }

}
