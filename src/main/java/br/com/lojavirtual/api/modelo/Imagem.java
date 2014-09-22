package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the imagem database table.
 */
@Entity
public class Imagem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_imagem")
    private int idImagem;

    private String caminho;

    private String descricao;

    //bi-directional many-to-one association to Produto
    @OneToMany(mappedBy = "imagem")
    private List<Produto> produtos;

    public Imagem() {
    }

    public int getIdImagem() {
        return this.idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public String getCaminho() {
        return this.caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto addProduto(Produto produto) {
        getProdutos().add(produto);
        produto.setImagem(this);

        return produto;
    }

    public Produto removeProduto(Produto produto) {
        getProdutos().remove(produto);
        produto.setImagem(null);

        return produto;
    }

}