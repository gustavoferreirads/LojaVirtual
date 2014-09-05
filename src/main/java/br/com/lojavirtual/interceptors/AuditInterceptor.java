package br.com.lojavirtual.interceptors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import br.com.lojavirtual.api.annotations.Auditoria;
import br.com.lojavirtual.api.events.CreateEvent;
import br.com.lojavirtual.api.events.DeleteEvent;
import br.com.lojavirtual.api.events.FieldState;
import br.com.lojavirtual.api.events.UpdateEvent;
import br.com.lojavirtual.api.modelo.Entidade;
import br.com.lojavirtual.api.servico.EventFactory;
import br.com.lojavirtual.producers.ServiceLocatorCDIImpl;

public class AuditInterceptor extends EmptyInterceptor  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EventFactory eventFactory;

	private List<CreateEvent> creations = new ArrayList<CreateEvent>();
	private List<DeleteEvent> deletes = new ArrayList<DeleteEvent>();
	private List<UpdateEvent> updates = new ArrayList<UpdateEvent>();
	//private IFieldProvider fieldProvider;

	public AuditInterceptor() {
		eventFactory = new ServiceLocatorCDIImpl().getInstanceFor(EventFactory.class);
		//fieldProvider = new ServiceLocatorCDIImpl().getInstanceFor(IFieldProvider.class);
	}

	@Inject
	public AuditInterceptor(EventFactory eventFactory){//, IFieldProvider fieldProvider) {
		this.eventFactory = eventFactory;
	//	this.fieldProvider = fieldProvider;
	}

	public void onDelete(Object entity,
						 Serializable id,
						 Object[] state,
						 String[] propertyNames,
						 Type[] types) {

		if (isAudition(entity.getClass())) {
			FieldState[] fieldStates = createFieldStates(entity, state, propertyNames, types);
			if (fieldStates.length > 0) // por enquanto pule campos extras..
				deletes.add(new DeleteEvent((Entidade) entity, fieldStates));
		}
	}

	@Override
	public boolean onFlushDirty(Object entity,
								Serializable id,
								Object[] currentState,
								Object[] previousState,
								String[] propertyNames,
								Type[] types) {

		if (isAudition(entity.getClass())) {
			FieldState[] fieldStates = createFieldStates(entity, currentState, previousState, propertyNames, types);
			if (fieldStates.length > 0) {// por enquanto pule campos extras...
				updates.add(new UpdateEvent((Entidade) entity, fieldStates));
			}
		}
		return true;
	}

	@Override
	public void afterTransactionCompletion(Transaction tx) {
		if(tx.wasRolledBack()) {
			deletes.clear();
			updates.clear();
			creations.clear();
		}
	}

	@Override
	public void afterTransactionBegin(Transaction tx) {

		super.afterTransactionBegin(tx);    //To change body of overridden methods use File | Settings | File Templates.
	}

	@Override
	public boolean onSave(Object entity,
						  Serializable id,
						  Object[] state,
						  String[] propertyNames,
						  Type[] types) {

		if (isAudition(entity.getClass())) {
			FieldState[] fieldStates = createFieldStates(entity, state, propertyNames, types);
			if (fieldStates.length > 0)
			creations.add(new CreateEvent((Entidade) entity, fieldStates));
		}
		return true;
	}

	private boolean isAudition(Class<?> entityClass) {
		return entityClass.isAnnotationPresent(Auditoria.class) || entityClass.getSuperclass() != null && isAudition(entityClass.getSuperclass());
	}

	private FieldState[] createFieldStates(Object entity, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		FieldState[] fieldStates = new FieldState[currentState.length];
		boolean emptyArray = true;
		for (int i = 0; i < propertyNames.length; i++) {
			//Field field = fieldProvider.evaluateById(new Expression(entity.getClass(), propertyNames[i]));
			boolean shouldAuditField =true;//= currentState[i] != null && !currentState[i].equals(previousState[i])&& field != null && field.getAuditable();
			if (shouldAuditField) {
				fieldStates[i] = new FieldState(previousState[i], currentState[i], propertyNames[i], types[i].getReturnedClass());
				emptyArray = false;
			}
		}
		return emptyArray ? new FieldState[0] : fieldStates;//para poder pular relacionamento....futuramente talvez não seja necessario
	}
	private FieldState[] createFieldStates(Object entity, Object[] currentState, String[] propertyNames, Type[] types) {
		return createFieldStates(entity, currentState, new Object[currentState.length], propertyNames, types);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void postFlush(Iterator entities) {
		fireCreationEvents();
		fireUpdateEvents();
		fireDeleteEvents();
	}

	private void fireCreationEvents() {
		for (CreateEvent createEvent : creations) {
			eventFactory.fire(createEvent);
		}
		creations.clear();
	}

	private void fireUpdateEvents() {
		for (UpdateEvent updateEvent : updates) {
			eventFactory.fire(updateEvent);
		}
		updates.clear();
	}

	private void fireDeleteEvents() {
		for (DeleteEvent deleteEvent : deletes) {
			eventFactory.fire(deleteEvent);
		}
		deletes.clear();
	}
}
