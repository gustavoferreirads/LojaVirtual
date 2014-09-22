package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the subcategoria database table.
 */
@Entity
@NamedQuery(name = "Subcategoria.findAll", query = "SELECT s FROM Subcategoria s")
public class Subcategoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_subcategoria")
    private int idSubcategoria;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    private String nome;

    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaModificacao;

    //bi-directional many-to-one association to Item
    @OneToMany(mappedBy = "subcategoria")
    private List<Item> items;

    //bi-directional many-to-one association to Categoria
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Subcategoria() {
    }

    public int getIdSubcategoria() {
        return this.idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
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

    public Date getUltimaModificacao() {
        return this.ultimaModificacao;
    }

    public void setUltimaModificacao(Date ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item addItem(Item item) {
        getItems().add(item);
        item.setSubcategoria(this);

        return item;
    }

    public Item removeItem(Item item) {
        getItems().remove(item);
        item.setSubcategoria(null);

        return item;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}