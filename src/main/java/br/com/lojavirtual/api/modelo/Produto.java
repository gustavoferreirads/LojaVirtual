package br.com.lojavirtual.api.modelo;

import br.com.lojavirtual.util.Utils;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Produto")
public class Produto extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum TipoDeFrete {
        CORREIOS("Frete calculado pelos Correiros"), GRATIS("Frete Grátis"), FIXO("Frete Fixo");

        private String nome;

        TipoDeFrete(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString() {
            return nome;
        }
    }

    public enum Situacao {
        DISPONIVEL("Disponível"), INDISPONIVEL("Indiponível");

        private String nome;

        Situacao(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString() {
            return nome;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "lucro")
    private Integer lucro;

    @Column(name = "nome")
    private String nome;

    @Column(name = "parcelamento")
    private String parcelamento;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "quantidade_acesso")
    private Integer quantidadeAcesso;

    @Column(name = "valor_liquido")
    private Float valorLiquido;

    @Column(name = "valor_venda")
    private Float valorVenda;

    @Column(name = "valor_frete_fixo")
    private Float valorFreteFixo;

    @Column(name = "exibir_pagina_inicial")
    private Boolean paginaInicial = false;

    @Column(name = "exibir_banner")
    private Boolean banner = false;

    @Column(name = "exibir_lancamento")
    private Boolean lancamento = false;

    private Integer peso;

    private Integer altura;

    private Integer largura;

    private Integer profundidade;

    private Situacao situacao = Situacao.DISPONIVEL;

    private TipoDeFrete tipoDeFrete = TipoDeFrete.CORREIOS;

    @OneToMany(mappedBy = "produto")
    private List<ItemVenda> itemVendas;

    @OneToMany(mappedBy = "produto")
    private List<LimiteEstoque> limiteEstoques;

    @ManyToOne
    @JoinColumn(name = "id_promocao")
    private Promocao promocao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "id_destaque")
    private Destaque destaque;

    //bi-directional many-to-one association to Produto
    @OneToMany(mappedBy = "produto")
    private List<Imagem> imagens = new ArrayList<Imagem>();

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    private Timestamp ultimaModificacao;

    public Produto() {
    }

    public Long getId() {
        return this.id;
    }

    public void setIdProduto(Long id) {
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

    public int getLucro() {
        return this.lucro;
    }

    public void setLucro(Integer lucro) {
        this.lucro = lucro;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParcelamento() {
        return this.parcelamento;
    }

    public void setParcelamento(String parcelamento) {
        this.parcelamento = parcelamento;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeAcesso() {
        return this.quantidadeAcesso;
    }

    public void setQuantidadeAcesso(int quantidadeAcesso) {
        this.quantidadeAcesso = quantidadeAcesso;
    }

    public Timestamp getUltimaModificacao() {
        return this.ultimaModificacao;
    }

    public void setUltimaModificacao(Timestamp ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public float getValorLiquido() {
        return this.valorLiquido;
    }

    public void setValorLiquido(Float valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public float getValorVenda() {
        return this.valorVenda;
    }

    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public List<ItemVenda> getItemVendas() {
        return this.itemVendas;
    }

    public void setItemVendas(List<ItemVenda> itemVendas) {
        this.itemVendas = itemVendas;
    }

    public ItemVenda addItemVenda(ItemVenda itemVenda) {
        getItemVendas().add(itemVenda);
        itemVenda.setProduto(this);

        return itemVenda;
    }

    public ItemVenda removeItemVenda(ItemVenda itemVenda) {
        getItemVendas().remove(itemVenda);
        itemVenda.setProduto(null);

        return itemVenda;
    }

    public List<LimiteEstoque> getLimiteEstoques() {
        return this.limiteEstoques;
    }

    public void setLimiteEstoques(List<LimiteEstoque> limiteEstoques) {
        this.limiteEstoques = limiteEstoques;
    }

    public LimiteEstoque addLimiteEstoque(LimiteEstoque limiteEstoque) {
        getLimiteEstoques().add(limiteEstoque);
        limiteEstoque.setProduto(this);

        return limiteEstoque;
    }

    public LimiteEstoque removeLimiteEstoque(LimiteEstoque limiteEstoque) {
        getLimiteEstoques().remove(limiteEstoque);
        limiteEstoque.setProduto(null);

        return limiteEstoque;
    }

    public Promocao getPromocao() {
        return this.promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Grupo getGrupo() {
        return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Destaque getDestaque() {
        return this.destaque;
    }

    public void setDestaque(Destaque destaque) {
        this.destaque = destaque;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public Integer getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Integer profundidade) {
        this.profundidade = profundidade;
    }

    public Float getValorFreteFixo() {
        return valorFreteFixo;
    }

    public void setValorFreteFixo(Float valorFreteFixo) {
        this.valorFreteFixo = valorFreteFixo;
    }


    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public TipoDeFrete getTipoDeFrete() {
        return tipoDeFrete;
    }

    public void setTipoDeFrete(TipoDeFrete tipoDeFrete) {
        this.tipoDeFrete = tipoDeFrete;
    }

    public Boolean getPaginaInicial() {
        return paginaInicial;
    }

    public void setPaginaInicial(Boolean paginaInicial) {
        this.paginaInicial = paginaInicial;
    }

    public Boolean getBanner() {
        return banner;
    }

    public void setBanner(Boolean banner) {
        this.banner = banner;
    }

    public Boolean getLancamento() {
        return lancamento;
    }

    public void setLancamento(Boolean lancamento) {
        this.lancamento = lancamento;
    }


}