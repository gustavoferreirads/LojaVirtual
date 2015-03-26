package br.com.lojavirtual.api.modelo;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


/**
 * The persistent class for the imagem database table.
 */
@Entity
public class Imagem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagem")
    @Getter
    private Long idImagem;

    private String uuid;

    private String caminho;

    @Lob
    private byte[] bytes;

    @Transient
    private String type;

    @Transient
    private Integer length;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Imagem() {
        uuid = UUID.randomUUID().toString();
    }


    public String getCaminho() {
        return this.caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}