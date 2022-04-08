package exception;

public class PasswordUnvalidException extends RuntimeException {

	public PasswordUnvalidException() {
		super();
	}

	public PasswordUnvalidException(String message) {
		super(message);
	}

}
