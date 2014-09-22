package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the comentario database table.
 */
@Entity
@Table(name = "Comentario")
public class Comentario extends Entidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_comentario")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "comentario")
    private String comentario;


    @ManyToOne
    @JoinColumn(name = "id_atendimento")
    private Atendimento atendimento;


    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;


    public Comentario() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long idComentario) {
        this.id = idComentario;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Atendimento getAtendimento() {
        return this.atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    @PrePersist
    public void prePersist() {
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public Timestamp getUltimaModificacao() {
        return null;
    }
}