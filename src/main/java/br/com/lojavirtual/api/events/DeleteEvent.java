package br.com.lojavirtual.api.events;

import br.com.lojavirtual.api.modelo.Entidade;

public class DeleteEvent extends DMLEvent {

	public DeleteEvent(Entidade entidade, FieldState[] fieldStates) {
		super(entidade, fieldStates);
	}
}
