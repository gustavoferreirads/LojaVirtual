package br.com.lojavirtual.api.modelo;

import br.com.lojavirtual.util.Strings;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 */
@Entity
public class Usuario extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usuario")
    private Long id;

    private String login;

    private String nome;

    private String senha;

    //bi-directional many-to-one association to Categoria
    @OneToMany(mappedBy = "usuario")
    private List<Categoria> categorias;

    //bi-directional many-to-one association to Chamado
    @OneToMany(mappedBy = "usuario")
    private List<Chamado> chamados;

    //bi-directional many-to-one association to Permissao
    @OneToMany(mappedBy = "usuario")
    private List<Permissao> permissaos;

    //bi-directional many-to-one association to Produto
    @OneToMany(mappedBy = "usuario")
    private List<Produto> produtos;

    //bi-directional many-to-one association to Grupo
    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    @Version
    private Timestamp ultimaModificacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro = new Date();

    public Usuario() {
    }


    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = Strings.hashMD5(senha);
    }

    public Timestamp getUltimaModificacao() {
        return this.ultimaModificacao;
    }

    public void setUltimaModificacao(Timestamp ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public List<Categoria> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria addCategoria(Categoria categoria) {
        getCategorias().add(categoria);
        categoria.setUsuario(this);

        return categoria;
    }

    public Categoria removeCategoria(Categoria categoria) {
        getCategorias().remove(categoria);
        categoria.setUsuario(null);

        return categoria;
    }

    public List<Chamado> getChamados() {
        return this.chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Chamado addChamado(Chamado chamado) {
        getChamados().add(chamado);
        chamado.setUsuario(this);

        return chamado;
    }

    public Chamado removeChamado(Chamado chamado) {
        getChamados().remove(chamado);
        chamado.setUsuario(null);

        return chamado;
    }

    public List<Permissao> getPermissaos() {
        return this.permissaos;
    }

    public void setPermissaos(List<Permissao> permissaos) {
        this.permissaos = permissaos;
    }

    public Permissao addPermissao(Permissao permissao) {
        getPermissaos().add(permissao);

        return permissao;
    }

    public Permissao removePermissao(Permissao permissao) {
        getPermissaos().remove(permissao);

        return permissao;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto addProduto(Produto produto) {
        getProdutos().add(produto);
        produto.setUsuario(this);

        return produto;
    }

    public Produto removeProduto(Produto produto) {
        getProdutos().remove(produto);
        produto.setUsuario(null);

        return produto;
    }

    public Grupo getGrupo() {
        return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}