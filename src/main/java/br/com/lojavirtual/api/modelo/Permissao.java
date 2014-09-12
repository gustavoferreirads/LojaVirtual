package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permissao database table.
 * 
 */
@Entity
@Table(name="Permissao")
public class Permissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name="id_operacao")
	private Operacao operacao;

	@ManyToOne
	@JoinColumn(name="id_funcionalidade")
	private Funcionalidade funcionalidade;

	@ManyToOne
	@JoinColumn(name="id_tipo_de_cadastro")
	private TipoDeCadastro tipoDeCadastro;

	public Permissao() {
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Operacao getOperacao() {
		return this.operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
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

}