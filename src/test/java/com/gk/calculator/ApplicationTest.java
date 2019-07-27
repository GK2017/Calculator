package com.gk.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ApplicationTest extends Application
{
	@Test
	public void emptyString()
	{
		assertThrows(NumberFormatException.class, () -> compute(""));
	}

	@Test
	public void invalidExpression()
	{
		assertThrows(NumberFormatException.class, () -> compute(" 3 4 5    + "));
	}

	@Test
	public void invalidCharacter()
	{
		assertThrows(NumberFormatException.class, () -> compute(" 3 !j 5 +"));
	}

	@Test
	public void validExpression()
	{
		final String expression = " 3  4 5 * +";
		assertEquals(expression + " = " + 23.0, compute(expression));
	}

	@Test
	public void validExpression2()
	{
		final String expression = "2 5 - 8 * 7 + ";
		assertEquals(expression + " = " + -17.0, compute(expression));
	}

	@Test
	public void validExpression3()
	{
		final String expression = "9 -1 * -4 +";
		assertEquals(expression + " = " + -13.0, compute(expression));
	}

}
