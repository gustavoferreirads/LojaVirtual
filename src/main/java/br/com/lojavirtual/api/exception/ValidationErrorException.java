package br.com.lojavirtual.api.exception;

public class ValidationErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ValidationErrorException(String message) {
		super(message);
	}

}
