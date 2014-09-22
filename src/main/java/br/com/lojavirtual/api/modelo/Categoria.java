package br.com.lojavirtual.api.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 */
@Entity
@Table(name = "Categoria")
public class Categoria extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Version
    @Column(name = "ultimaModificacao")
    private Timestamp ultimaModificacao;


    @OneToMany(mappedBy = "categoria")
    private List<Subcategoria> subcategorias;

    public Categoria() {
    }


    @PrePersist
    public void prePersist() {
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return this.id;
    }

    public void setIdCategoria(Long idCategoria) {
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

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Subcategoria> getSubcategorias() {
        return this.subcategorias;
    }

    public void setSubcategorias(List<Subcategoria> subcategorias) {
        this.subcategorias = subcategorias;
    }

    public Subcategoria addSubcategoria(Subcategoria subcategoria) {
        getSubcategorias().add(subcategoria);
        subcategoria.setCategoria(this);

        return subcategoria;
    }

    public Subcategoria removeSubcategoria(Subcategoria subcategoria) {
        getSubcategorias().remove(subcategoria);
        subcategoria.setCategoria(null);

        return subcategoria;
    }


}