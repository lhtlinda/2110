package edu.cornell.sneha;

/**
 * An object of class ExpressionParser represents a parser that finds the next
 * token in an inputed string. 
 * Author: Sneha Kumar and Linda Lu. 
 * Date of last modification: 18 July 2017
 */
public class ExpressionParser {

	private String input;
	private String separator = " ";
	private String operator = "+-/*()";
	private int cursor = 0;
	private String literals = "1234567890";

	public ExpressionParser(String input) {
		this.input = input;

	}

	/** Returns the next token in a string. */
	public String nextToken() {
		if (input.trim().length() == 0 || cursor >= input.length())
			return "";
		String currentToken = "";
		boolean isLiteral = literals
				.contains(input.substring(cursor, cursor + 1));
		for (int i = cursor; i < input.length(); i++, cursor++) {
			String currentChar = input.substring(i, i + 1);
			if (isLiteral) {
				if (literals.contains(currentChar))
					currentToken += currentChar;
				else {
					cursor = currentChar.equals(separator) ? ++i : i;
					break;
				} // end else
			} // end if statement

			else {
				if (operator.contains(currentChar)) {
					currentToken += currentChar;
					cursor = ++i;
					break;
				} // end if
				else if (literals.contains(currentChar)) {
					currentToken += currentChar;
					isLiteral = true;

				} // end else if
			} // end else statement
		} // end for loop
		return currentToken;
	}// end nextToken method
}// end class
