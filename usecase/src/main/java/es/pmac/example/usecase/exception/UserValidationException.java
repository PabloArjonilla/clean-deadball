package es.pmac.example.usecase.exception;

public class UserValidationException extends RuntimeException {
	public UserValidationException(final String message) {
		super(message);
	}
}
