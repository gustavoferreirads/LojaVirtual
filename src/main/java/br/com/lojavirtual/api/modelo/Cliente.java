package br.com.lojavirtual.api.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the cliente database table.
 */
@Entity
@Table(name = "Cliente")
public class Cliente extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    private String nome;

    @Column(name = "telefone_celular")
    private String telefoneCelular;

    @Column(name = "telefone_comercial")
    private String telefoneComercial;

    @Column(name = "telefone_residencial")
    private String telefoneResidencial;

    private Timestamp ultimaModificacao;

    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;

    public Cliente() {
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

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefoneCelular() {
        return this.telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneComercial() {
        return this.telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getTelefoneResidencial() {
        return this.telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public Timestamp getUltimaModificacao() {
        return this.ultimaModificacao;
    }

    public void setUltimaModificacao(Timestamp ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public List<Chamado> getChamados() {
        return this.chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Chamado addChamado(Chamado chamado) {
        getChamados().add(chamado);
        chamado.setCliente(this);

        return chamado;
    }

    public Chamado removeChamado(Chamado chamado) {
        getChamados().remove(chamado);
        chamado.setCliente(null);

        return chamado;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Venda> getVendas() {
        return this.vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Venda addVenda(Venda venda) {
        getVendas().add(venda);
        venda.setCliente(this);
        return venda;
    }

    public Venda removeVenda(Venda venda) {
        getVendas().remove(venda);
        venda.setCliente(null);
        return venda;
    }

    public Boolean isLojaCliente() {
        return true;
    }

    @PrePersist
    public void prePersist() {
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }


}