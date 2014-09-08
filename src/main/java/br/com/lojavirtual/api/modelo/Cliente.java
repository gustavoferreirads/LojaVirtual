package br.com.lojavirtual.api.modelo;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;
import br.com.lojavirtual.api.annotations.Auditoria;
import br.com.lojavirtual.util.Strings;
import br.com.lojavirtual.validacao.CNPJ;
import br.com.lojavirtual.validacao.Email;
import br.com.lojavirtual.validacao.ValidaCPF;

@SuppressWarnings("unchecked")
//@Entity
//@Table(name="CLIENTE_LOJA")
//@Auditoria
public class Cliente extends Entidade implements Serializable {


    public enum Categoria {
        TRIAL, PROFISSIONAL, ESTUDANTE;

        public String toString() {
            return Strings.capitalize(name());
        }
    }

    public enum TipoDeServico {
        ESCRITORIO("Escritório"), CORPORATIVO("Corporativo");
        private String name;

        private TipoDeServico(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    public enum Situacao {
        ATIVO, BLOQUEADO, CANCELADO;

        public String toString() {
            return Strings.capitalize(name());
        }
    }

    public Cliente(){
        uuid = UUID.randomUUID().toString();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CLIENTE_LAAS")
    private Long id;

    @JoinColumn(name = "ID_MUNICIPIO_COMARCA")
    @ManyToOne
    private Municipio municipioComarca;


    @Enumerated(EnumType.ORDINAL)
    @Column(name="NI_CATEGORIA_CLIENTE")
    private Categoria categoriaCliente;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="NI_TIPO_SERVICO")
    private TipoDeServico tipoServico;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="NI_SITUACAO_CLIENTE")
    private Situacao situacaoCliente;

    @Column(name="TX_NOME_CLIENTE")
    private String nomeCliente;

    @Column(name="NI_TIPO_PESSOA")
    private Integer tipoPessoa = 1;

    @Column(name="TX_CPF")
    @ValidaCPF
    private String cpf;

    @Column(name="TX_CNPJ")
    @CNPJ
    private String cnpj;

    @Column(name="TX_TELEFONE")
    private String telefone;

    @Column(name="TX_CELULAR")
    private String celular;

    @Column(name="TX_NUMERO_IMOVEL")
    private String numeroImovel;

    @Column(name="TX_LOGRADOURO")
    private String logradouro;

    @Column(name="TX_BAIRRO")
    private String bairro;

    @Column(name="TX_COMPLEMENTO_ENDERECO")
    private String complementoEndereco;

    @Column(name="TX_EMAIL")
    @Email
    private String email;

    @Column(name="TX_ENDERECO_PAGINA")
    private String enderecoPagina;

    @Lob
    @Column(name="BL_LOGO_CLIENTE_LAAS")
    private byte[] logoCliente;

    @Getter
    @Setter
    @Column(name="TX_NOME_ARQUIVO")
    private String nomeDoArquivo;

    @Column(name="TX_ANOTACOES_CLIENTE_LAAS")
    private String anotacoes;
    
    @Column(name="TS_CADASTRO_CLIENTE_LAAS")
    private Timestamp cadastroCliente;

    @Version
    @Column(name = "TS_ULT_MODIFICACAO")
    private Timestamp ultimaModificacao;

    @Column(name = "TX_UUID")
    @Getter
    private String uuid;

	@Transient
	private static final Long ID_LOJA = 1l;


	@Column(name = "TX_FUSO_HORARIO")
	private String TimezoneId = "America/Sao_Paulo";
	
    public Municipio getMunicipioComarca() {
        return municipioComarca;
    }

    public void setMunicipioComarca(Municipio municipioComarca) {
        this.municipioComarca = municipioComarca;
    }

    public Categoria getCategoriaCliente() {
        return categoriaCliente;
    }

    public void setCategoriaCliente(Categoria categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }

    public TipoDeServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoDeServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Situacao getSituacaoCliente() {
        return situacaoCliente;
    }

    public void setSituacaoCliente(Situacao situacaoCliente) {
        this.situacaoCliente = situacaoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Integer getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(Integer tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumeroImovel() {
        return numeroImovel;
    }

    public void setNumeroImovel(String numeroImovel) {
        this.numeroImovel = numeroImovel;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplementoEndereco() {
        return complementoEndereco == null ? "" : complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnderecoPagina() {
        return enderecoPagina;
    }

    public void setEnderecoPagina(String enderecoPagina) {
        this.enderecoPagina = enderecoPagina;
    }

    public byte[] getLogoCliente() {
        return logoCliente;
    }

    public void setLogoCliente(byte[] logoCliente) {
        this.logoCliente = logoCliente;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public Timestamp getCadastroCliente() {
        return cadastroCliente;
    }

    public void setCadastroCliente(Timestamp cadastroCliente) {
        this.cadastroCliente = cadastroCliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUltimaModificacao(Timestamp ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

	@Override
    public Long getId() {
        return id;
    }

    @Override
    public Timestamp getUltimaModificacao() {
        return ultimaModificacao;
    }

	public Boolean isLojaCliente() {
		return ID_LOJA.equals(id);
	}

    @PrePersist
    protected void prePersist() {
        cadastroCliente = new Timestamp(new Date().getTime());
    }
}
