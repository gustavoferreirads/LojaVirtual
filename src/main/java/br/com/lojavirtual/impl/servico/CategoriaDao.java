package br.com.lojavirtual.impl.servico;

import br.com.lojavirtual.api.modelo.Categoria;
import br.com.lojavirtual.api.modelo.Produto;
import br.com.lojavirtual.api.servico.ICategoriaDao;
import br.com.lojavirtual.api.servico.IProdutoDao;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Gustavo Ferreira on 20/09/2014.
 */

@Repository
public class CategoriaDao extends EntidadeDao<Categoria> implements ICategoriaDao, Serializable {

    public CategoriaDao() {
        super(Categoria.class);
    }
}
