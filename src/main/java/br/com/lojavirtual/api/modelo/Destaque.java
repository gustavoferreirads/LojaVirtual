package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the destaque database table.
 * 
 */
@Entity
@NamedQuery(name="Destaque.findAll", query="SELECT d FROM Destaque d")
public class Destaque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_destaque")
	private int idDestaque;

	@Temporal(TemporalType.DATE)
	@Column(name="data_destaque")
	private Date dataDestaque;

	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaModificacao;

	public Destaque() {
	}

	public int getIdDestaque() {
		return this.idDestaque;
	}

	public void setIdDestaque(int idDestaque) {
		this.idDestaque = idDestaque;
	}

	public Date getDataDestaque() {
		return this.dataDestaque;
	}

	public void setDataDestaque(Date dataDestaque) {
		this.dataDestaque = dataDestaque;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getUltimaModificacao() {
		return this.ultimaModificacao;
	}

	public void setUltimaModificacao(Date ultimaModificacao) {
		this.ultimaModificacao = ultimaModificacao;
	}

}