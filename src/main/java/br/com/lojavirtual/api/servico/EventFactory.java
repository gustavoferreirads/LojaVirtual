package br.com.lojavirtual.api.servico;


import br.com.lojavirtual.api.events.*;

public interface EventFactory {

	public void fire(CreateEvent createEvent);

	public void fire(UpdateEvent updateEvent);

	public void fire(DeleteEvent deleteEvent);
}
