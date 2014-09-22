package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the funcionalidade_operacao database table.
 */
@Entity
@Table(name = "funcionalidade_operacao")
public class FuncionalidadeOperacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_funcionalidade")
    private Funcionalidade funcionalidade;

    @ManyToOne
    @JoinColumn(name = "id_tipo_de_cadastro")
    private TipoDeCadastro tipoDeCadastro;

    @ManyToOne
    @JoinColumn(name = "id_operacao")
    private Operacao operacao;

    public FuncionalidadeOperacao() {
    }

    public Funcionalidade getFuncionalidade() {
        return this.funcionalidade;
    }

    public void setFuncionalidade(Funcionalidade funcionalidade) {
        this.funcionalidade = funcionalidade;
    }

    public TipoDeCadastro getTipoDeCadastro() {
        return this.tipoDeCadastro;
    }

    public void setTipoDeCadastro(TipoDeCadastro tipoDeCadastro) {
        this.tipoDeCadastro = tipoDeCadastro;
    }

    public Operacao getOperacao() {
        return this.operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}