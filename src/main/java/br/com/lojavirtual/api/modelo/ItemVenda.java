package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the item_venda database table.
 */
@Entity
@Table(name = "item_venda")
public class ItemVenda implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_venda")
    private Long id;

    private Integer quantidade;

    @Column(name = "valor_total")
    private Float valorTotal;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;

    public ItemVenda() {
    }

    public Long getId() {
        return this.id;
    }

    public void setIdItemVenda(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return this.venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

}