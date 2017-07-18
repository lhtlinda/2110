package edu.cornell.sneha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.cornell.sneha.exceptions.InvalidInfixException;
import edu.cornell.sneha.exceptions.InvalidRPNException;

/**
 * An object of class Calculator represents a calculator that finds the value of
 * an inputed string. Author: Sneha Kumar and Linda Lu. Date of last
 * modification: 18 July 2017
 */
public class Calculator {

	private static String input;
	private String operators = "+-/*";
	private String parentheses = "()";
	private MyStack<String> operatorsStack = new MyStack<String>();

	public static void main(String[] args) throws IOException {
		System.out.println(
				"Enter an expression in either Reverse Polish or Infix notation:");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		input = br.readLine();
		Calculator calc = new Calculator();
		calc.determineInfixOrRPN(input);

	}

	/**
	 * Determine whether the inputed string is in Infix or Reverse Polish
	 * notation, and convert to the opposite notation, finally calling on the
	 * calculate method based on the result.
	 */
	public void determineInfixOrRPN(String input) {
		try {
			if (validateRPN(input)) {
				System.out.println(
						"You entered an expression in Reverse Polish notation. Here it is converted to Infix notation: \n\t"
								+ convertRPNtoInfix(input));
				System.out.println("Here is the calculated answer: "
						+ calculateInfix(convertRPNtoInfix(input)));
			}
		} catch (InvalidRPNException e) {
			System.out.println(e.getMessage());
			try {
				if (validateInfix(input)) {
					System.out.println(
							"You entered an expression in Infix notation. Here it is converted to Reverse Polish notation: \n\t"
									+ convertInfixtoRPN(input));
					System.out.println("Here is the calculated answer: "
							+ calculateRPN(convertInfixtoRPN(input)));
				}
			} catch (InvalidInfixException b) {
				System.out.println(b.getMessage());
			}
		}

	}

	/** Return true if the inputed string is in valid Infix notation. */
	public boolean validateInfix(String input) throws InvalidInfixException {
		// invalid if uneven parentheses
		// invalid if two operands in a row
		// invalid if not numbers
		// invalid if two numbers in a row separated by spaces
		// invalid if two operates in a row separated by spaces

		int currentlyOpenParentheses = 0;
		ExpressionParser parser = new ExpressionParser(input);
		String token = parser.nextToken();

		while (!token.isEmpty()) {
			if (token.equals("("))
				currentlyOpenParentheses++;
			else if (token.equals(")"))
				currentlyOpenParentheses--;
			if (currentlyOpenParentheses < 0)
				throw new InvalidInfixException();
			String next = parser.nextToken();
			if (token.matches("-?\\d+(\\.\\d+)?")
					&& next.matches(("-?\\d+(\\.\\d+)?")))
				throw new InvalidInfixException(input);
			if (operators.contains(token) && operators.contains(next))
				throw new InvalidInfixException(input);
			if (!token.matches("-?\\d+(\\.\\d+)?")
					&& !parentheses.contains(token)
					&& !operators.contains(token)) {
				throw new InvalidInfixException(input);
			}
			token = next;
		} // end of while loop

		if (currentlyOpenParentheses != 0)
			throw new InvalidInfixException(input);
		return true;

	}

	/**
	 * Return true if the inputed string is in valid Reverse Polish notation.
	 */
	public boolean validateRPN(String input) throws InvalidRPNException {
		ExpressionParser parser = new ExpressionParser(input);
		int counter = 0;
		String token = parser.nextToken();
		while (!token.isEmpty()) {
			if (operators.contains(token)) {
				counter -= 2;
				if (counter < 0) {
					throw new InvalidRPNException(input);
				}
				counter++;
			} else if (token.matches("-?\\d+(\\.\\d+)?")) { // it's numeric
				counter++;
			} else {
				throw new InvalidRPNException(input);
			}
			token = parser.nextToken();
		}

		if (counter == 1)
			return true;
		else
			throw new InvalidRPNException(input);
	}

	/**
	 * Return a string converted from Infix notation to Reverse Polish notation.
	 */
	public String convertInfixtoRPN(String input) {
		// createTokenList(input);
		StringBuilder output = new StringBuilder();
		ExpressionParser parser = new ExpressionParser(input);
		String token = parser.nextToken();
		token = useEachToken(output, parser, token);

		while (!operatorsStack.isEmpty()) {
			output.append(operatorsStack.pop() + " ");
		}

		return output.toString();
	}

	/** Return a string token until the input string runs out of tokens. */
	public String useEachToken(StringBuilder output, ExpressionParser parser,
			String token) {
		while (!token.isEmpty()) {
			if (token.matches("-?\\d+(\\.\\d+)?"))
				output.append(token + " ");
			else if (token.equals("("))
				operatorsStack.push(token);
			else if (token.equals(")")) {
				String savedOperator = operatorsStack.pop();
				while (!savedOperator.equals("(")) {
					output.append(savedOperator + " ");
					savedOperator = operatorsStack.pop();
				}
			} else if (operators.contains(token)) {
				while (!operatorsStack.isEmpty() && (getPrecedence(
						token) <= getPrecedence(operatorsStack.peek()))) {
					output.append(operatorsStack.pop() + " ");
				}
				operatorsStack.push(token);
			}
			token = parser.nextToken();
		}
		return token;
	}

	/**
	 * Return precedence of each token. '*' and '/' have a higher precedence
	 * than '+' and '-'.
	 */
	private int getPrecedence(String token) {
		int precedence = 0;
		if ("*/".contains(token))
			precedence = 2;
		else if ("+-".contains(token))
			precedence = 1;

		return precedence;
	}

	/**
	 * Return a string converted from Reverse Polish notation to Infix notation.
	 */
	public String convertRPNtoInfix(String input) {
		MyStack<String> numberStack = new MyStack<String>();
		ExpressionParser parser = new ExpressionParser(input);
		String token = parser.nextToken();
		while (!token.isEmpty()) {
			if (token.matches("-?\\d+(\\.\\d+)?"))
				numberStack.push(token);
			else if (operators.contains(token)) {
				String numberTwo = numberStack.pop();
				String numberOne = numberStack.pop();
				String tempExpression = numberOne + token + numberTwo;
				if (token.equals("+") || token.equals("-"))
					numberStack.push("(" + tempExpression + ")");
				else {
					numberStack.push(tempExpression);
				}
			}
			token = parser.nextToken();
		}
		return numberStack.pop();
	}

	/** Return the calculated value of an input in Reverse Polish notation. */
	public double calculateRPN(String input) {
		MyStack<Double> numberStack = new MyStack<Double>();
		ExpressionParser parser = new ExpressionParser(input);
		String token = parser.nextToken();
		double calculation = 0;
		if (!input.contains("+") && !input.contains("-") && !input.contains("*")
				&& !input.contains("/")) {
			calculation = Double.parseDouble(token);
			return calculation;
		}
		while (!token.isEmpty()) {
			if (token.matches("-?\\d+(\\.\\d+)?"))
				numberStack.push(Double.parseDouble(token));
			else if (operators.contains(token)) {
				double numberTwo = numberStack.pop();
				double numberOne = numberStack.pop();
				calculation = evaluate(token, numberOne, numberTwo);
				numberStack.push(calculation);
			}
			token = parser.nextToken();
		}
		return calculation;
	}

	/**
	 * Return the calculation of two numbers based on which operator the token
	 * is.
	 */
	public double evaluate(String operator, double numberOne,
			double numberTwo) {
		double calculation = 0;
		switch (operator) {
		case "+":
			calculation = numberOne + numberTwo;
			break;
		case "-":
			calculation = numberOne - numberTwo;
			break;
		case "*":
			calculation = numberOne * numberTwo;
			break;
		case "/":
			calculation = numberOne / numberTwo;
		default:
			break;
		}
		return calculation;
	}

	/** Return the calculated value of an input in Infix notation. */
	public double calculateInfix(String input) {
		return calculateRPN(convertInfixtoRPN(input));
	}
}
