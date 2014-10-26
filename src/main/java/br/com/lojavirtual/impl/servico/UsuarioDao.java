package br.com.lojavirtual.impl.servico;

import br.com.lojavirtual.api.modelo.Usuario;
import br.com.lojavirtual.api.servico.IUsuarioDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by Gustavo Ferreira on 20/09/2014.
 */
@Repository
public class UsuarioDao extends EntidadeDao<Usuario> implements IUsuarioDao, Serializable {

    public UsuarioDao() {
        super(Usuario.class);
    }

    @Override
    public Usuario busqueUsuarioPorLoginESenha(Usuario usuario) {
        try {
            return createTypedQuery("select usuario from Usuario usuario where usuario.login = :login and usuario.senha = :senha").setParameter("login", usuario.getLogin()).setParameter("senha", usuario.getSenha()).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
