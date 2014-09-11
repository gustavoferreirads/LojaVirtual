package br.com.lojavirtual.api.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuario database table.
 * 
 */
@Embeddable
public class UsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_usuario")
	private int idUsuario;

	private String login;

	public UsuarioPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPK)) {
			return false;
		}
		UsuarioPK castOther = (UsuarioPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& this.login.equals(castOther.login);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.login.hashCode();
		
		return hash;
	}
}