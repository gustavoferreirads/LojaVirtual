package br.com.lojavirtual.api.modelo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the item database table.
 */
@Entity

@Table(name = "item")
public class Item extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_item")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "path")
    private String path;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    private Timestamp ultimaModificacao;

    @ManyToOne
    @JoinColumn(name = "id_subcategoria")
    private Subcategoria subcategoria;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "PRODUTO_ITEM",
            joinColumns = @JoinColumn(name = "ID_ITEM"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO"))
    private List<Produto> produtos = new ArrayList<Produto>();

    public Item() {
    }

    public Long getId() {
        return this.id;
    }

    public void setIdItem(Long id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getUltimaModificacao() {
        return this.ultimaModificacao;
    }

    public void setUltimaModificacao(Timestamp ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public Subcategoria getSubcategoria() {
        return this.subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    @PrePersist
    public void prePersist() {
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }

}