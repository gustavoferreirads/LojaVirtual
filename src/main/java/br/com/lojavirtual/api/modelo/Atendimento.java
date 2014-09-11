package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atendimento database table.
 * 
 */
@Entity
@NamedQuery(name="Atendimento.findAll", query="SELECT a FROM Atendimento a")
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_atendimento")
	private int idAtendimento;

	//bi-directional many-to-one association to Chamado
	@ManyToOne
	@JoinColumn(name="id_chamado")
	private Chamado chamado;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="atendimento")
	private List<Comentario> comentarios;

	public Atendimento() {
	}

	public int getIdAtendimento() {
		return this.idAtendimento;
	}

	public void setIdAtendimento(int idAtendimento) {
		this.idAtendimento = idAtendimento;
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

}