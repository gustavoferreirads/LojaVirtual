package br.com.lojavirtual.api.events;

import br.com.lojavirtual.api.modelo.Entidade;

public class UpdateEvent extends DMLEvent {
	public UpdateEvent(Entidade entidade, FieldState[] fieldStates) {
		super(entidade, fieldStates);
	}
}
