package br.com.lojavirtual.api.events;

import br.com.lojavirtual.api.modelo.Entidade;

public class CreateEvent extends DMLEvent {

	public CreateEvent(Entidade entidade, FieldState[] fieldStates) {
		super(entidade, fieldStates);
	}
}
