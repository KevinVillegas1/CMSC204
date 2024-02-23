/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: A utility class that converts an infix expression to a postfix expression, a postfix expression to an infix expression, and evaluates a postfix expression.
 * Due: 02/22/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class Notation {
	/**
	 * default Constructor Initializes a Notation Object
	 */
	public Notation()
	{
		
	}
	/**
	 * Convert an infix expression into a postfix expression
	 * @param infix - the infix expression in string format
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFormatException - if the infix expression format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
	{
		MyQueue<Character> postfixSolution = new MyQueue<Character>();
		MyStack<Character> stack = new MyStack<Character>();
		int leftCount = 0;
		int rightCount = 0;
		for(int i = 0; i < infix.length(); i++)
		{
			switch(infix.charAt(i))
			{
				case '(':
				{
					leftCount++;
					break;
				}
				case ')':
				{
					rightCount++;
					break;
				}
			}
		}
		if(leftCount > rightCount || leftCount < rightCount)
		{
			throw new InvalidNotationFormatException();
		}
		for(int i = 0; i < infix.length(); i++)
		{
			switch(infix.charAt(i))
			{
				case ' ':
				{
					break;
				}
				case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
				{
					try {
						char copy = infix.charAt(i);
						postfixSolution.enqueue(copy);
					}
					catch (QueueOverflowException e){
						e.getMessage();;
					}
					break;
				}
				case '(':
				{
					try {
						stack.push(infix.charAt(i));
					}
					catch (StackOverflowException e){
						e.getMessage();
					}
					break;
				}
				case '+': case '-': case '*': case '/':
				{
					try {
						while(!stack.isEmpty() && infix.charAt(i) <= stack.top())
						{
							postfixSolution.enqueue(stack.pop());
						}
						stack.push(infix.charAt(i));
					}
					catch (StackOverflowException e){
						e.getMessage();
					}
					catch (StackUnderflowException e){
						e.getMessage();
					}
					catch (QueueOverflowException e){
						e.getMessage();
					}
					break;
				}
				case ')':
				{
					try {
						char topOperator = stack.pop();
						while(topOperator != '(')
						{
							postfixSolution.enqueue(topOperator);
							topOperator = stack.pop();
							if(stack.isEmpty() && topOperator != '(')
							{
								throw new InvalidNotationFormatException();
							}
						}
					}
					catch (StackUnderflowException e){
						e.getMessage();
					}
					catch (QueueOverflowException e){
						e.getMessage();
					}
					break;
				}
				default:
				{
					break;
				}
			}
		}
		try {
			while(!stack.isEmpty())
			{
				postfixSolution.enqueue(stack.pop());
			}
		}
		catch (QueueOverflowException e){
			e.getMessage();
		}
		catch (StackUnderflowException e){
			e.getMessage();
		}
		return postfixSolution.toString();
	}
	/**
	 * Convert the Postfix expression to the Infix expression
	 * @param postfix - the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException - if the postfix expression format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException
	{
		MyStack<String> stack = new MyStack<String>();
		String infix = "";
		int operator = 0;
		int operand = 0;
		for(int i = 0; i < postfix.length(); i++)
		{
			switch(postfix.charAt(i))
			{
				case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
				{
					operand++;
					break;
				}
				case '+': case '-': case '*': case '/':
				{
					operator++;
					break;
				}
			}
		}
		if (operand != operator + 1)
		{
			throw new InvalidNotationFormatException();
		}
		for(int i = 0; i < postfix.length();i++)
		{
			switch(postfix.charAt(i))
			{
				case ' ':
				{
					break;
				}
				case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
				{
					try {
						stack.push(String.valueOf((postfix.charAt(i))));
					}
					catch (StackOverflowException e){
						e.getMessage();
					}
					break;
				}
				case '+': case '-': case '*': case '/':
				{
					try {
						if(!stack.isEmpty() && stack.size() >= 2)
						{
							String rightValue = stack.pop();
							String leftValue = stack.pop();
							String result = leftValue + postfix.charAt(i) + rightValue;
							String finalResult = "(" + result + ")";
							stack.push(finalResult);
						}
						else
						{
							throw new StackUnderflowException();
						}
					}
					catch (StackOverflowException e){
						e.getMessage();
					}
					catch (StackUnderflowException e){
						e.getMessage();
					}
					break;
				}
				default:
				{
					break;
				}
			}
		}
		try {
			if(stack.size() > 1)
			{
				throw new InvalidNotationFormatException();
			}
			else
			{
				infix = stack.top();
			}
		}
		catch (StackUnderflowException e){
			e.getMessage();
		}
		return infix;
	}
	/**
	 * Evaluates a postfix expression from a string to a double
	 * @param postfixExpr - the postfix expression in String format
	 * @return the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException - if the postfix expression format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{
		MyStack<Double> stack = new MyStack<Double>();
		double evaluation = 0.0;
		int operator = 0;
		int operand = 0;
		for(int i = 0; i < postfixExpr.length(); i++)
		{
			switch(postfixExpr.charAt(i))
			{
				case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
				{
					operand++;
					break;
				}
				case '+': case '-': case '*': case '/':
				{
					operator++;
					break;
				}
			}
		}
		if (operand != operator + 1)
		{
			throw new InvalidNotationFormatException();
		}
		for(int i = 0; i < postfixExpr.length();i++)
		{
			switch(postfixExpr.charAt(i))
			{
				case ' ':
				{
					break;
				}
				case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
				{
					try {
						stack.push(Double.parseDouble(String.valueOf((postfixExpr.charAt(i)))));
					}
					catch (StackOverflowException e){
						e.getMessage();
					}
					break;
				}
				case '+': case '-': case '*': case '/':
				{
					try {
						if(!stack.isEmpty() && stack.size() >= 2)
						{
							double result = 0.0;
							double rightValue = stack.pop();
							double leftValue = stack.pop();
							switch(postfixExpr.charAt(i))
							{
								case '+':
								{
									result = leftValue + rightValue;
									break;
								}
								case '-':
								{
									result = leftValue - rightValue;
									break;
								}
								case '*':
								{
									result = leftValue * rightValue;
									break;
								}
								case '/':
								{
									result = leftValue / rightValue;
									break;
								}
							}
							stack.push(result);
						}
						else
						{
							throw new StackUnderflowException();
						}
					}
					catch (StackOverflowException e){
						e.getMessage();
					}
					catch (StackUnderflowException e){
						e.getMessage();
					}
					break;
				}
				default:
				{
					break;
				}
			}
		}
		try {
			if(stack.size() > 1)
			{
				throw new InvalidNotationFormatException();
			}
			else
			{
				evaluation = stack.top();
			}
		}
		catch (StackUnderflowException e){
			e.getMessage();
		}
		return evaluation;
	}
}
