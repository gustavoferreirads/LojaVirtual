package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_grupo")
	private int idGrupo;

	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaModificacao;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="grupo")
	private List<Usuario> usuarios;

	public Grupo() {
	}

	public int getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getUltimaModificacao() {
		return this.ultimaModificacao;
	}

	public void setUltimaModificacao(Date ultimaModificacao) {
		this.ultimaModificacao = ultimaModificacao;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setGrupo(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setGrupo(null);

		return usuario;
	}

}