package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the promocao database table.
 * 
 */
@Entity
@NamedQuery(name="Promocao.findAll", query="SELECT p FROM Promocao p")
public class Promocao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_promocao")
	private int idPromocao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="data_promocao")
	private Date dataPromocao;

	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaModificacao;

	public Promocao() {
	}

	public int getIdPromocao() {
		return this.idPromocao;
	}

	public void setIdPromocao(int idPromocao) {
		this.idPromocao = idPromocao;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataPromocao() {
		return this.dataPromocao;
	}

	public void setDataPromocao(Date dataPromocao) {
		this.dataPromocao = dataPromocao;
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