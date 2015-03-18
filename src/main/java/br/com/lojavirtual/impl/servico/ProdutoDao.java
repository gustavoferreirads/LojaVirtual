package br.com.lojavirtual.impl.servico;

import br.com.lojavirtual.api.modelo.Produto;
import br.com.lojavirtual.api.servico.IProdutoDao;
import org.springframework.stereotype.Repository;

import javax.enterprise.context.Dependent;
import java.io.Serializable;

/**
 * Created by Gustavo Ferreira on 20/09/2014.
 */

@Repository
@Dependent
public class ProdutoDao extends EntidadeDao<Produto> implements IProdutoDao, Serializable {

    public ProdutoDao() {
        super(Produto.class);
    }
}
