package edu.cornell.sneha;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmpty() {
		//given a simple number
		String input = "";
		ExpressionParser parser = new ExpressionParser(input);
		
		assertEquals("", parser.nextToken());
	}
	
	@Test
	public void testInfix() {
		//given a simple number
		String input = " 30 *5+24     51 2/ 60";
		ExpressionParser parser = new ExpressionParser(input);
		
		assertEquals("30", parser.nextToken());
		assertEquals("*", parser.nextToken());
		assertEquals("5", parser.nextToken());
		assertEquals("+", parser.nextToken());
		assertEquals("24", parser.nextToken());
		assertEquals("51", parser.nextToken());
		assertEquals("2", parser.nextToken());
		assertEquals("/", parser.nextToken());
		assertEquals("60", parser.nextToken());
		assertEquals("", parser.nextToken());

	}
	

	@Test
	public void testRPN() {
		//given a simple number
		String input = "5 2 3+*";
		ExpressionParser parser = new ExpressionParser(input);
		
		assertEquals("5", parser.nextToken());
		assertEquals("2", parser.nextToken());
		assertEquals("3", parser.nextToken());
		assertEquals("+", parser.nextToken());
		assertEquals("*", parser.nextToken());
	}
}
