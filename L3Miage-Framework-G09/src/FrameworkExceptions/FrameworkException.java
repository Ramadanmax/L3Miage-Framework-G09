package FrameworkExceptions;

public class FrameworkException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur d'une FrameworkException.
	 * 
	 * @param message
	 */
	public FrameworkException(String message) {
		super(message);
	}
}
