package edu.cornell.sneha;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.cornell.sneha.exceptions.InvalidInfixException;
import edu.cornell.sneha.exceptions.InvalidRPNException;

public class CalculatorTest {
	private static final double DELTA = .00000000001;
	Calculator calc;

	@Before
	public void setUp() throws Exception {
		calc = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidRPN() throws InvalidRPNException {
		String input = "15 2 3+/ 4+";
		assertTrue(calc.validateRPN(input));
		
	}
	
	@Test (expected = InvalidRPNException.class)
	public void testInvalidRPN() throws InvalidRPNException {
		String input = "15 3+/ 4+";
		calc.validateRPN(input);
	}
	
	@Test
	public void testValidInfix_Simple() throws InvalidInfixException {
		String input = "3 + 4";
		assertTrue(calc.validateInfix(input));
	}
	
	@Test
	public void testValidInfix_Complex() throws InvalidInfixException {
		String input = "((15+3 ) / 3 ) - 4";
		assertTrue(calc.validateInfix(input));
	}
	
	@Test (expected = InvalidInfixException.class)
	public void testInvalidInfix_TwoNumbersWithoutOperator() throws InvalidInfixException {
		String input = "((15+3 ) / 3 3) - 4";
		calc.validateInfix(input);
	}
	
	@Test (expected = InvalidInfixException.class)
	public void testInvalidInfix_CloseParenthesisThenOpenParenthesis() throws InvalidInfixException {
		String input = ")(";
		calc.validateInfix(input);
	}
	
	@Test 
	public void testInvalidInfix_JustOneNumber() throws InvalidInfixException {
		String input = "3";
		assertTrue(calc.validateInfix(input));
	}
	
	@Test
	public void testConvertInfixToRPN(){
		assertEquals("3 4 + ", calc.convertInfixtoRPN("3 + 4"));
		assertEquals("33 4 + ", calc.convertInfixtoRPN("33 + 4"));
		assertEquals("33 4 2 * 64 / 3 4 + * + ", calc.convertInfixtoRPN("33 + 4 * 2 / 64 * (3 + 4)"));
		assertEquals("3 4 + 7 8 + * 10 11 + / ", calc.convertInfixtoRPN("(3 + 4) * (7 + 8) / (10 + 11)"));
	}
	
	@Test
	public void testConvertRPNtoInfix(){
		assertEquals("(3+4)", calc.convertRPNtoInfix("3 4 + "));
		assertEquals("(33+4)", calc.convertRPNtoInfix("33 4 + "));
		assertEquals("(33+4*2/64*(3+4))", calc.convertRPNtoInfix("33 4 2 * 64 / 3 4 + * + "));
		assertEquals("(3+4)*(7+8)/(10+11)", calc.convertRPNtoInfix("3 4 + 7 8 + * 10 11 + / "));

	}
	
	@Test
	public void testCalculateRPN(){
		assertEquals(33.0, calc.calculateRPN("33 "), DELTA);
		assertEquals(7.0, calc.calculateRPN("3 4 + "), DELTA);
		assertEquals(5.0, calc.calculateRPN("3 4 + 7 8 + * 10 11 + / "), DELTA);
		assertEquals(33.875, calc.calculateRPN("33 4 2 * 64 / 3 4 + * + "), DELTA);
	}
	
	@Test
	public void testCalculateInfix(){
		assertEquals(33.0, calc.calculateInfix("33 "), DELTA);
		assertEquals(7.0, calc.calculateInfix("(3+4)"), DELTA);
		assertEquals(5.0, calc.calculateInfix("(3+4)*(7+8)/(10+11)"), DELTA);
		assertEquals(33.875, calc.calculateInfix("(33+4*2/64*(3+4))"), DELTA);
	}

}
