package br.com.lojavirtual.api.modelo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
        @SerializedName("Frete calculado pelos Correiros")
        CORREIOS("Frete calculado pelos Correiros"),

        @SerializedName("Frete Grátis")
        GRATIS("Frete Grátis"),

        @SerializedName("Frete Fixo")
        FIXO("Frete Fixo");

        @Getter
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

        @SerializedName("Disponível")
        DISPONIVEL("Disponível"),

        @SerializedName("Indiponível")
        INDISPONIVEL("Indiponível");

        @Getter
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
    @Getter
    @Setter
    private Long id;

    @Column(name = "descricao")
    @Getter
    @Setter
    private String descricao;

    @Column(name = "lucro")
    @Getter
    @Setter
    private Integer lucro;

    @Column(name = "nome")
    @Getter
    @Setter
    private String nome;

    @Column(name = "parcelamento")
    @Getter
    @Setter
    private String parcelamento;

    @Column(name = "quantidade")
    @Getter
    @Setter
    private Integer quantidade;

    @Column(name = "quantidade_acesso")
    @Getter
    @Setter
    private Integer quantidadeAcesso;

    @Column(name = "valor_liquido")
    @Getter
    @Setter
    private Float valorLiquido;

    @Column(name = "valor_venda")
    @Getter
    @Setter
    private Float valorVenda;

    @Column(name = "valor_frete_fixo")
    @Getter
    @Setter
    private Float valorFreteFixo;

    @Column(name = "exibir_pagina_inicial")
    @Getter
    @Setter
    private Boolean paginaInicial = true;

    @Column(name = "exibir_banner")
    @Getter
    @Setter
    private Boolean banner = false;

    @Column(name = "exibir_lancamento")
    @Getter
    @Setter
    private Boolean lancamento = false;

    @Getter
    @Setter
    private Integer peso;

    @Getter
    @Setter
    private Integer altura;

    @Getter
    @Setter
    private Integer largura;

    @Getter
    @Setter
    private Integer profundidade;

    @Getter
    @Setter
    private Situacao situacao = Situacao.DISPONIVEL;

    @Getter
    @Setter
    @Column(name = "tipo_de_frete")
    private TipoDeFrete tipoDeFrete = TipoDeFrete.CORREIOS;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<ItemVenda> itemVendas;

    @Transient
    private List<LimiteEstoque> limiteEstoques;

    @ManyToOne
    @JoinColumn(name = "id_promocao")
    @Getter
    @Setter
    private Promocao promocao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @Getter
    @Setter
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_destaque")
    @Getter
    @Setter
    private Destaque destaque;

    //bi-directional many-to-one association to Produto
    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Imagem> imagens = new ArrayList<Imagem>();

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    @Getter
    @Setter
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataCadastro;

    @Getter
    @Setter
    private Timestamp ultimaModificacao = new Timestamp(System.currentTimeMillis());

    public Produto() {
    }

    @PrePersist
    public void prePersist() {
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }

}