package com.gk.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Application
{
	final static List<String> operators = Arrays.asList("+", "-", "*");

	public static void main(String[] args)
	{
		final Scanner in = new Scanner(System.in);
		System.out.println("Insert postfix expression");

		final String expression = in.nextLine();

		System.out.println(compute(expression));
	}

	public static String compute(final String expression)
	{
		if (!expression.equals(""))
		{
			final Stack<Double> arguments = new Stack<>();
			final List<String> splittedExpression = Arrays.asList(expression.trim().replaceAll(" +", " ").split(" "));

			for (final String singleArgument : splittedExpression)
			{
				if (singleArgument.matches("^\\d+$") || singleArgument.matches("^-\\d+$"))
				{
					arguments.push(Double.valueOf(singleArgument));
				}
				else if (operators.contains(singleArgument))
				{
					final double rightArg = arguments.pop();
					final double leftArg = arguments.pop();
					double value = 0.0;

					if (singleArgument.equals("+"))
					{
						value = leftArg + rightArg;
					}
					else if (singleArgument.equals("-"))
					{
						value = leftArg - rightArg;
					}
					else if (singleArgument.equals("*"))
					{
						value = leftArg * rightArg;
					}
					arguments.push(value);
				}
				else
				{
					throw new NumberFormatException("Not supported character: " + singleArgument);
				}
			}
			if (arguments.size() == 1)
			{
				return expression + " = " + arguments.pop();
			}
			else
			{
				throw new NumberFormatException("Invalid expression");
			}
		}
		throw new NumberFormatException("Empty string! Please provide some value");
	}
}


