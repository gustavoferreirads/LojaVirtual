package br.com.lojavirtual.events;

import javax.inject.Inject;

import br.com.lojavirtual.api.events.CreateEvent;
import br.com.lojavirtual.api.events.DeleteEvent;
import br.com.lojavirtual.api.events.UpdateEvent;
import br.com.lojavirtual.api.servico.EventFactory;

public class CDIEventFactory implements EventFactory {

	@Inject
	private javax.enterprise.event.Event<CreateEvent> createEventTriggerer;
	@Inject
	private javax.enterprise.event.Event<UpdateEvent> updateEventTriggerer;
	@Inject
	private javax.enterprise.event.Event<DeleteEvent> deleteEventTriggerer;

	public void fire(CreateEvent createEvent) {
		createEventTriggerer.fire(createEvent);
	}

	public void fire(UpdateEvent updateEvent) {
		updateEventTriggerer.fire(updateEvent);
	}

	public void fire(DeleteEvent deleteEvent) {
		deleteEventTriggerer.fire(deleteEvent);
	}

	void setCreateEventTriggerer(javax.enterprise.event.Event<CreateEvent> createEventTriggerer) {
		this.createEventTriggerer = createEventTriggerer;
	}

	void setUpdateEventTriggerer(javax.enterprise.event.Event<UpdateEvent> updateEventTriggerer) {
		this.updateEventTriggerer = updateEventTriggerer;
	}

	void setDeleteEventTriggerer(javax.enterprise.event.Event<DeleteEvent> deleteEventTriggerer) {
		this.deleteEventTriggerer = deleteEventTriggerer;
	}
}
