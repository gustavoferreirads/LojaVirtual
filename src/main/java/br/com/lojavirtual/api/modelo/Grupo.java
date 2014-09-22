package br.com.lojavirtual.api.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 */
@Entity
@Table(name = "Grupo")
public class Grupo extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_grupo")
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "grupo")
    private List<Produto> produtos;

    @OneToMany(mappedBy = "grupo")
    private List<Usuario> usuarios;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Version
    private Timestamp ultimaModificacao;

    public Grupo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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
        produto.setGrupo(this);

        return produto;
    }

    public Produto removeProduto(Produto produto) {
        getProdutos().remove(produto);
        produto.setGrupo(null);

        return produto;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario addUsuario(Usuario usuario) {
        getUsuarios().add(usuario);
        usuario.setGrupo(this);

        return usuario;
    }

    public Usuario removeUsuario(Usuario usuario) {
        getUsuarios().remove(usuario);
        usuario.setGrupo(null);

        return usuario;
    }

    @PrePersist
    public void prePersist() {
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }


}