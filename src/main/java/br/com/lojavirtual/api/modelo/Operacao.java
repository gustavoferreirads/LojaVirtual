package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the operacao database table.
 */
@Entity
@Table(name = "Operacao")
public class Operacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operacao")
    private String idOperacao;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "operacao")
    private List<FuncionalidadeOperacao> funcionalidadeOperacaos;

    @OneToMany(mappedBy = "operacao")
    private List<Permissao> permissaos;

    public Operacao() {
    }

    public String getIdOperacao() {
        return this.idOperacao;
    }

    public void setIdOperacao(String idOperacao) {
        this.idOperacao = idOperacao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<FuncionalidadeOperacao> getFuncionalidadeOperacaos() {
        return this.funcionalidadeOperacaos;
    }

    public void setFuncionalidadeOperacaos(List<FuncionalidadeOperacao> funcionalidadeOperacaos) {
        this.funcionalidadeOperacaos = funcionalidadeOperacaos;
    }

    public FuncionalidadeOperacao addFuncionalidadeOperacao(FuncionalidadeOperacao funcionalidadeOperacao) {
        getFuncionalidadeOperacaos().add(funcionalidadeOperacao);
        funcionalidadeOperacao.setOperacao(this);

        return funcionalidadeOperacao;
    }

    public FuncionalidadeOperacao removeFuncionalidadeOperacao(FuncionalidadeOperacao funcionalidadeOperacao) {
        getFuncionalidadeOperacaos().remove(funcionalidadeOperacao);
        funcionalidadeOperacao.setOperacao(null);

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
        permissao.setOperacao(this);

        return permissao;
    }

    public Permissao removePermissao(Permissao permissao) {
        getPermissaos().remove(permissao);
        permissao.setOperacao(null);

        return permissao;
    }

}