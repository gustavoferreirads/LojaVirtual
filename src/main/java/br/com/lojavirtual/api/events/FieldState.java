package br.com.lojavirtual.api.events;

public class FieldState {

	private final Object previousState;
	private final Object currentState;
	private final String name;
	private final Class<?> type;

	public FieldState(Object previousState, Object currentState, String name, Class<?> type) {
		this.previousState = previousState;
		this.currentState = currentState;
		this.name = name;
		this.type = type;
	}

	public Class<?> getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public Object getCurrentState() {
		return currentState;
	}

	public Object getPreviousState() {
		return previousState;
	}
}
