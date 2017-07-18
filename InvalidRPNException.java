package edu.cornell.sneha.exceptions;

@SuppressWarnings("serial")
public class InvalidRPNException extends Exception {
	public InvalidRPNException(){
		super("This is not in Reverse Polish notation.");
	}
	
	public InvalidRPNException(String message){
		super("This is not in Reverse Polish notation: " + message + ".");
	}

}
