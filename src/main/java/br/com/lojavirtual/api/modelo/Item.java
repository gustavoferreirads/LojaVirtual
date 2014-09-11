package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_item")
	private int idItem;

	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	private String nome;

	private String path;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaModificacao;

	//bi-directional many-to-one association to Subcategoria
	@ManyToOne
	@JoinColumn(name="id_subcategoria")
	private Subcategoria subcategoria;

	public Item() {
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getUltimaModificacao() {
		return this.ultimaModificacao;
	}

	public void setUltimaModificacao(Date ultimaModificacao) {
		this.ultimaModificacao = ultimaModificacao;
	}

	public Subcategoria getSubcategoria() {
		return this.subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

}