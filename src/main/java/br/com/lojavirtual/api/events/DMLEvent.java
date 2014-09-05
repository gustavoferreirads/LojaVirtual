package br.com.lojavirtual.api.events;

import br.com.lojavirtual.api.modelo.Entidade;

public abstract class DMLEvent {

	private final Entidade entidade;
	private final FieldState[] fieldStates;

	public DMLEvent(Entidade entidade, FieldState[] fieldStates) {
		this.entidade = entidade;
		this.fieldStates = fieldStates;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public FieldState[] getFieldStates() {
		return fieldStates;
	}
}
