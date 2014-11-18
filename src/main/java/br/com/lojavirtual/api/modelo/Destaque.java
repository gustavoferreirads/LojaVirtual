package br.com.lojavirtual.api.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the destaque database table.
 */
@Entity
@Table(name = "Destaque")
public class Destaque extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_destaque")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "destaque")
    private List<Produto> produtos;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_destaque")
    private Date dataDestaque;

    @Version
    private Timestamp ultimaModificacao;

    public Destaque() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDestaque() {
        return this.dataDestaque;
    }

    public void setDataDestaque(Date dataDestaque) {
        this.dataDestaque = dataDestaque;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getUltimaModificacao() {
        return this.ultimaModificacao;
    }

    public void setUltimaModificacao(Timestamp ultimaModificacao) {
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
        produto.setDestaque(this);

        return produto;
    }

    public Produto removeProduto(Produto produto) {
        getProdutos().remove(produto);
        produto.setDestaque(null);

        return produto;
    }

}