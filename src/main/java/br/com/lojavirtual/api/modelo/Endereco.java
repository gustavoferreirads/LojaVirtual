package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_entrega")
	private int idEntrega;

	private String cep;

	private String complemento;

	private String endereco;

	private String logradouro;

	private String numero;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="endereco")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;

	//bi-directional many-to-one association to Venda
	@OneToMany(mappedBy="endereco")
	private List<Venda> vendas;

	public Endereco() {
	}

	public int getIdEntrega() {
		return this.idEntrega;
	}

	public void setIdEntrega(int idEntrega) {
		this.idEntrega = idEntrega;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setEndereco(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setEndereco(null);

		return cliente;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Venda addVenda(Venda venda) {
		getVendas().add(venda);
		venda.setEndereco(this);

		return venda;
	}

	public Venda removeVenda(Venda venda) {
		getVendas().remove(venda);
		venda.setEndereco(null);

		return venda;
	}

}