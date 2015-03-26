package br.com.lojavirtual.api.modelo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the destaque database table.
 */
@Entity
@Table(name = "Destaque")
public class Destaque extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_destaque")
    @Getter
    @Setter
    private Long id;

    @Column(name = "descricao")
    @Getter
    @Setter
    private String descricao;

    @OneToMany(mappedBy = "destaque")
    @Getter
    @Setter
    private List<Produto> produtos;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_destaque")
    @Getter
    @Setter
    private Date dataDestaque;

    @Version
    @Getter
    private Timestamp ultimaModificacao;

    public Destaque() {
    }

}