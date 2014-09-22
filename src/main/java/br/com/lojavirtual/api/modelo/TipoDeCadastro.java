package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_de_cadastro database table.
 */
@Entity
@Table(name = "tipo_de_cadastro")
@NamedQuery(name = "TipoDeCadastro.findAll", query = "SELECT t FROM TipoDeCadastro t")
public class TipoDeCadastro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_tipo_de_cadastro")
    private int idTipoDeCadastro;

    private String classe;

    @Column(name = "fg_funcionalidade")
    private short fgFuncionalidade;

    @Column(name = "ni_nivel_acesso")
    private short niNivelAcesso;

    private String nome;

    //bi-directional many-to-one association to Funcionalidade
    @OneToMany(mappedBy = "tipoDeCadastro")
    private List<Funcionalidade> funcionalidades;

    //bi-directional many-to-one association to FuncionalidadeOperacao
    @OneToMany(mappedBy = "tipoDeCadastro")
    private List<FuncionalidadeOperacao> funcionalidadeOperacaos;

    //bi-directional many-to-one association to Permissao
    @OneToMany(mappedBy = "tipoDeCadastro")
    private List<Permissao> permissaos;

    public TipoDeCadastro() {
    }

    public int getIdTipoDeCadastro() {
        return this.idTipoDeCadastro;
    }

    public void setIdTipoDeCadastro(int idTipoDeCadastro) {
        this.idTipoDeCadastro = idTipoDeCadastro;
    }

    public String getClasse() {
        return this.classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public short getFgFuncionalidade() {
        return this.fgFuncionalidade;
    }

    public void setFgFuncionalidade(short fgFuncionalidade) {
        this.fgFuncionalidade = fgFuncionalidade;
    }

    public short getNiNivelAcesso() {
        return this.niNivelAcesso;
    }

    public void setNiNivelAcesso(short niNivelAcesso) {
        this.niNivelAcesso = niNivelAcesso;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionalidade> getFuncionalidades() {
        return this.funcionalidades;
    }

    public void setFuncionalidades(List<Funcionalidade> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

    public Funcionalidade addFuncionalidade(Funcionalidade funcionalidade) {
        getFuncionalidades().add(funcionalidade);
        funcionalidade.setTipoDeCadastro(this);

        return funcionalidade;
    }

    public Funcionalidade removeFuncionalidade(Funcionalidade funcionalidade) {
        getFuncionalidades().remove(funcionalidade);
        funcionalidade.setTipoDeCadastro(null);

        return funcionalidade;
    }

    public List<FuncionalidadeOperacao> getFuncionalidadeOperacaos() {
        return this.funcionalidadeOperacaos;
    }

    public void setFuncionalidadeOperacaos(List<FuncionalidadeOperacao> funcionalidadeOperacaos) {
        this.funcionalidadeOperacaos = funcionalidadeOperacaos;
    }

    public FuncionalidadeOperacao addFuncionalidadeOperacao(FuncionalidadeOperacao funcionalidadeOperacao) {
        getFuncionalidadeOperacaos().add(funcionalidadeOperacao);
        funcionalidadeOperacao.setTipoDeCadastro(this);

        return funcionalidadeOperacao;
    }

    public FuncionalidadeOperacao removeFuncionalidadeOperacao(FuncionalidadeOperacao funcionalidadeOperacao) {
        getFuncionalidadeOperacaos().remove(funcionalidadeOperacao);
        funcionalidadeOperacao.setTipoDeCadastro(null);

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
        permissao.setTipoDeCadastro(this);

        return permissao;
    }

    public Permissao removePermissao(Permissao permissao) {
        getPermissaos().remove(permissao);
        permissao.setTipoDeCadastro(null);

        return permissao;
    }

}