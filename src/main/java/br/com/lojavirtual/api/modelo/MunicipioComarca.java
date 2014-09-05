package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the MUNICIPIO_COMARCA database table.
 * 
 */
@Entity
@Table(name="MUNICIPIO_COMARCA")
public class MunicipioComarca extends Entidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MUNICIPIO_COMARCA")
	private Long id;

	@Column(name="FG_COMARCA")
	private Boolean comarca;
	
	@ManyToOne()
	@JoinColumn(name="ID_UF")
	private Uf uf;

	@Version
	@Column(name="TS_ULT_MODIFICACAO")
	private Timestamp ultimaModificacao;

	@Column(name="TX_MUNICIPIO_COMARCA")
	private String descricao;

    public MunicipioComarca() {
    }

	@SuppressWarnings("unchecked")
	public Long getId() {
		return this.id;
	}

	public Boolean getComarca() {
		return this.comarca;
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
		MunicipioComarca other = (MunicipioComarca) obj;
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