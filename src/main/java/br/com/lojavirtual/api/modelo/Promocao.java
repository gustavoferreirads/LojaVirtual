package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the promocao database table.
 */
@Entity
@NamedQuery(name = "Promocao.findAll", query = "SELECT p FROM Promocao p")
public class Promocao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promocao")
    private int idPromocao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_promocao")
    private Date dataPromocao;

    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaModificacao;

    //bi-directional many-to-one association to Produto
    @OneToMany(mappedBy = "promocao")
    private List<Produto> produtos;

    public Promocao() {
    }

    public int getIdPromocao() {
        return this.idPromocao;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataPromocao() {
        return this.dataPromocao;
    }

    public void setDataPromocao(Date dataPromocao) {
        this.dataPromocao = dataPromocao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getUltimaModificacao() {
        return this.ultimaModificacao;
    }

    public void setUltimaModificacao(Date ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto addProduto(Produto produto) {
        getProdutos().add(produto);
        produto.setPromocao(this);

        return produto;
    }

    public Produto removeProduto(Produto produto) {
        getProdutos().remove(produto);
        produto.setPromocao(null);

        return produto;
    }

}