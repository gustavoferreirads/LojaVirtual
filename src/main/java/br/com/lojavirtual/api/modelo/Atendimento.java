package br.com.lojavirtual.api.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the atendimento database table.
 */
@Entity
@Table(name = "Atendimento")
public class Atendimento extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_chamado")
    private Chamado chamado;

    @OneToMany(mappedBy = "atendimento")
    private List<Comentario> comentarios;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Version
    @Column(name = "ultimaModificacao")
    private Timestamp ultimaModificacao;

    public Atendimento() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chamado getChamado() {
        return this.chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public List<Comentario> getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Comentario addComentario(Comentario comentario) {
        getComentarios().add(comentario);
        comentario.setAtendimento(this);
        return comentario;
    }

    public Comentario removeComentario(Comentario comentario) {
        getComentarios().remove(comentario);
        comentario.setAtendimento(null);
        return comentario;
    }

    public Timestamp getUltimaModificacao() {
        return this.ultimaModificacao;
    }

    public void setUltimaModificacao(Timestamp ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }


    @PrePersist
    public void prePersist() {
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }

}