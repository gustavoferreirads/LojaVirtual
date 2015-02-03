package br.com.lojavirtual.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gustavo Ferreira on 02/02/2015.
 */
public abstract class ControllerAction {
    public final String ERROR = "error";
    public final String SUCESS = "sucess";
    public final String KEY_ERRO_DEFAULT = "msg_operacao_erro";
    public final String KEY_SUCESS_DEFAULT = "msg_operacao_erro";

    public void addErrorMessage(HttpServletRequest request, String key) {
        request.setAttribute(ERROR, key);
    }

    public void addErrorMessage(HttpServletRequest request) {
        request.setAttribute(ERROR, KEY_ERRO_DEFAULT);
    }

    public void addSucessMessage(HttpServletRequest request, String key) {
        request.setAttribute(SUCESS, key);
    }

    public void addSucessMessage(HttpServletRequest request) {
        request.setAttribute(SUCESS, KEY_SUCESS_DEFAULT);
    }


}
