package br.com.lojavirtual.business;

import br.com.lojavirtual.api.exception.ValidationException;
import br.com.lojavirtual.api.modelo.Usuario;

/**
 * Created by Gustavo Ferreira on 02/02/2015.
 */
public class UsuarioBusiness {

    public static void validate(Usuario usuario){
            if(!usuario.getSenha().equals(usuario.getConfirmSenha())){
                throw new ValidationException("msg_senha_nao_confere");
            }
        }
    }