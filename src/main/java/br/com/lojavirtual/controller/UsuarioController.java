package br.com.lojavirtual.controller;

import br.com.lojavirtual.api.modelo.Usuario;
import br.com.lojavirtual.api.servico.IUsuarioDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        }finally {
            return "portal/usuario/cadastro";
        }
    }

    @RequestMapping("/consultaUsuarios")
    public String lista(Model model) {
        model.addAttribute("usuarios", usuarioDao.busqueTodos());
        return "portal/usuario/consulta";
    }


    @RequestMapping("/carregaUsuarios")
    public void lista(HttpServletResponse response) {
        try {
            List<Usuario> usuarios = usuarioDao.busqueTodos();
            PrintWriter writer = response.getWriter();
            String jsonList = new Gson().toJson(usuarios);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            StringBuilder builder = new StringBuilder();
            builder.append("{\n" +
                    "  \"current\": 1,\n" +
                    "  \"rowCount\": 10,\n" +
                    "  \"rows\": ").append(jsonList).append(",\n" +
                    "  \"total\": 1123\n" +
                    "}");
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "forward:login";
    }

}
