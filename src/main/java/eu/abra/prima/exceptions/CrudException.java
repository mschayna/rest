package eu.abra.prima.exceptions;

public class CrudException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public CrudException(String message) {
		super(message);
	}
}
