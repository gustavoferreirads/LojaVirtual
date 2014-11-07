package br.com.lojavirtual.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gustavo Ferreira on 30/09/2014.
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
        String uri = request.getRequestURI();

        if (uri.endsWith("login") ||
                uri.endsWith("logar") ||
                uri.contains("resources")||
                uri.contains("loja")) {

            return true;
        }

        if (request.getSession().getAttribute("usuarioLogado") != null) {
            return true;
        }

        response.sendRedirect("login");
        return false;
    }


}
