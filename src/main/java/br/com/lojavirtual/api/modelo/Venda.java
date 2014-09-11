package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the venda database table.
 * 
 */
@Entity
@NamedQuery(name="Venda.findAll", query="SELECT v FROM Venda v")
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_venda")
	private int idVenda;

	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	private float desconto;

	@Column(name="tipo_operacao")
	private short tipoOperacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaModificacao;

	@Column(name="valor_total")
	private float valorTotal;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	@JoinColumn(name="id_entrega")
	private Endereco endereco;

	public Venda() {
	}

	public int getIdVenda() {
		return this.idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public float getDesconto() {
		return this.desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public short getTipoOperacao() {
		return this.tipoOperacao;
	}

	public void setTipoOperacao(short tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Date getUltimaModificacao() {
		return this.ultimaModificacao;
	}

	public void setUltimaModificacao(Date ultimaModificacao) {
		this.ultimaModificacao = ultimaModificacao;
	}

	public float getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}