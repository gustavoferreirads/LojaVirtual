package br.com.lojavirtual.api.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the funcionalidade database table.
 */
@Entity
@Table(name = "Funcionalidade")
public class Funcionalidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionalidade")
    private Long id;

    @Column(name = "classe")
    private String classe;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_tipo_de_cadastro")
    private TipoDeCadastro tipoDeCadastro;

    @OneToMany(mappedBy = "funcionalidade")
    private List<FuncionalidadeOperacao> funcionalidadeOperacaos;

    @OneToMany(mappedBy = "funcionalidade")
    private List<Permissao> permissaos;

    public Funcionalidade() {
    }

    public Long getIdFuncionalidade() {
        return this.id;
    }

    public void setIdFuncionalidade(Long id) {
        this.id = id;
    }

    public String getClasse() {
        return this.classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoDeCadastro getTipoDeCadastro() {
        return this.tipoDeCadastro;
    }

    public void setTipoDeCadastro(TipoDeCadastro tipoDeCadastro) {
        this.tipoDeCadastro = tipoDeCadastro;
    }

    public List<FuncionalidadeOperacao> getFuncionalidadeOperacaos() {
        return this.funcionalidadeOperacaos;
    }

    public void setFuncionalidadeOperacaos(List<FuncionalidadeOperacao> funcionalidadeOperacaos) {
        this.funcionalidadeOperacaos = funcionalidadeOperacaos;
    }

    public FuncionalidadeOperacao addFuncionalidadeOperacao(FuncionalidadeOperacao funcionalidadeOperacao) {
        getFuncionalidadeOperacaos().add(funcionalidadeOperacao);
        funcionalidadeOperacao.setFuncionalidade(this);

        return funcionalidadeOperacao;
    }

    public FuncionalidadeOperacao removeFuncionalidadeOperacao(FuncionalidadeOperacao funcionalidadeOperacao) {
        getFuncionalidadeOperacaos().remove(funcionalidadeOperacao);
        funcionalidadeOperacao.setFuncionalidade(null);

        return funcionalidadeOperacao;
    }

    public List<Permissao> getPermissaos() {
        return this.permissaos;
    }

    public void setPermissaos(List<Permissao> permissaos) {
        this.permissaos = permissaos;
    }

    public Permissao addPermissao(Permissao permissao) {
        getPermissaos().add(permissao);
        permissao.setFuncionalidade(this);

        return permissao;
    }

    public Permissao removePermissao(Permissao permissao) {
        getPermissaos().remove(permissao);
        permissao.setFuncionalidade(null);

        return permissao;
    }

}