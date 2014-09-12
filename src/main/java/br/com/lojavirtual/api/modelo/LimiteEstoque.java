package br.com.lojavirtual.api.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the limite_estoque database table.
 * 
 */
@Entity
@Table(name="limite_estoque")
public class LimiteEstoque extends Entidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_limite_estoque")
	private Long id;

	private String descricao;

	@Column(name="quantiade_minima")
	private int quantiadeMinima;

	@ManyToOne
	@JoinColumn(name="id_produto")
	private Produto produto;
	

	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro")
	private Date dataCadastro;
	
	@Version
	@Column(name="ultimaModificacao")
	private Timestamp ultimaModificacao;

	public LimiteEstoque() {
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

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantiadeMinima() {
		return this.quantiadeMinima;
	}

	public void setQuantiadeMinima(int quantiadeMinima) {
		this.quantiadeMinima = quantiadeMinima;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	@PrePersist
	public void prePersist() {
		this.dataCadastro = new Timestamp(System.currentTimeMillis());
	}

	public Timestamp getUltimaModificacao() {
		return ultimaModificacao;
	}

}