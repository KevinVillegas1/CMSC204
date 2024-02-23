import java.util.ArrayList;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a generic stack class called MyStack that implements StackInterface.
 * Due: 02/22/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class MyStack <T> implements StackInterface <T> {
	private ArrayList<T> stack;
	private int size;
	private static final int DEFAULT_CAPACITY = 50;
	/**
	 * default Constructor Initializes a MyStack Object - uses default as the size of the stack
	 */
	public MyStack()
	{
		this(DEFAULT_CAPACITY);
	}
	/**
	 * default Constructor Initializes a MyStack Object - takes in an int as the size of the stack
	 */
	public MyStack(int size)
	{
		this.stack = new ArrayList<T>(size);
		this.size = size;
	}
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty()
	{
		if(stack.isEmpty() == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull()
	{
		if(stack.size() >= this.size)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T pop() throws StackUnderflowException
	{
		if(isEmpty() == true)
		{
			throw new StackUnderflowException();
		}
		else
		{
			return stack.remove(size() - 1);
		}
	}
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T top() throws StackUnderflowException
	{
		if(isEmpty() == true)
		{
			throw new StackUnderflowException();
		}
		else
		{
			return stack.get(size() - 1);
		}
	}
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size()
	{
		return stack.size();
	}
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	public boolean push(T e) throws StackOverflowException
	{
		if(isFull() == true)
		{
			throw new StackOverflowException();
		}
		else
		{
			stack.add(e);
			return true;
		}
	}
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString()
	{
		String string = "";
		for(int i = 0; i < size(); i++)
		{
			string += String.valueOf(stack.get(i));
		}
		return string;
	}
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter)
	{
		String string = "";
		for(int i = 0; i < size(); i++)
		{
			if (i == size() - 1)
			{
				string += String.valueOf(stack.get(i));
			}
			else
			{
				string += String.valueOf(stack.get(i)) + delimiter;
			}
		}
		return string;
	}
	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	public void fill(ArrayList<T> list) throws StackOverflowException
	{
		ArrayList<T> temp = new ArrayList<T>();
		for(T e : list)
		{
			temp.add(e);
		}
		for(T e : temp)
		{
			if(isFull() == true)
			{
				throw new StackOverflowException();
			}
			else
			{
				stack.add(e);
			}
		}
	}
}
