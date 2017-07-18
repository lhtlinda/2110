package edu.cornell.sneha.exceptions;

@SuppressWarnings("serial")
public class InvalidInfixException extends Exception {

	public InvalidInfixException() {
		super("This is not in Infix notation.");
	}

	public InvalidInfixException(String message) {
		super("This is not in Infix notation: " + message + ".");
	}
}
