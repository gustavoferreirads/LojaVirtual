package br.com.lojavirtual.api.servico;

import br.com.lojavirtual.api.modelo.Usuario;

/**
 * Created by Gustavo Ferreira on 20/09/2014.
 */

public interface IUsuarioDao extends IEntidadeDao<Usuario> {

    public Usuario busqueUsuarioPorLoginESenha(Usuario usuario);
}
