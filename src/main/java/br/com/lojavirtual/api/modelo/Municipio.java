package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the MUNICIPIO_COMARCA database table.
 */
@Entity
@Table(name = "MUNICIPIO")
public class Municipio extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MUNICIPIO")
    private Long id;

    private Uf uf;

    @Version
    @Column(name = "ultimaModificacao")
    private Timestamp ultimaModificacao;

    @Column(name = "descricao")
    private String descricao;

    public Municipio() {
    }

    @SuppressWarnings("unchecked")
    public Long getId() {
        return this.id;
    }

    public Timestamp getUltimaModificacao() {
        return this.ultimaModificacao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Municipio other = (Municipio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @PrePersist
    @PreUpdate
    @PreRemove
    protected void lanceErroDeModificacaoDeMunicipio() {
        throw new PersistenceException("nao eh permitido inserir, atualizar ou remover um municipio");
    }
}