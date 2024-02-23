import java.util.ArrayList;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a generic queue class called MyQueue that implements QueueInterface.
 * Due: 02/22/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class MyQueue <T> implements QueueInterface<T> {
	private ArrayList<T> queue;
	private  int size;
	private int frontIndex;
	private static final int DEFAULT_CAPACITY = 50;
	/**
	 * default Constructor Initializes a MyQueue Object - uses a default as the size of the queue
	 */
	public MyQueue()
	{
		this(DEFAULT_CAPACITY);
		frontIndex = 0;
	}
	/**
	 * default Constructor Initializes a MyQueue Object - takes an int as the size of the queue
	 */
	public MyQueue(int size)
	{
		this.queue = new ArrayList<T>(size);
		this.size = size;
		frontIndex = 0;
	}
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty()
	{
		if(queue.isEmpty() == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Determines if the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull()
	{
		if(queue.size() >= this.size)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	public T dequeue() throws QueueUnderflowException
	{
		if(isEmpty() == true)
		{
			throw new QueueUnderflowException();
		}
		else
		{
			return queue.remove(frontIndex);
		}
	}
	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size()
	{
		return queue.size();
	}
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	public boolean enqueue(T e) throws QueueOverflowException
	{
		if(isFull() == true)
		{
			throw new QueueOverflowException();
		}
		else
		{
			queue.add(e);
			return true;
		}
	}
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString()
	{
		String string = "";
		for(int i = 0; i < size(); i++)
		{
			string += String.valueOf(queue.get(i));
		}
		return string;
	}
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter)
	{
		String string = "";
		for(int i = 0; i < size(); i++)
		{
			if (i == size() - 1)
			{
				string += String.valueOf(queue.get(i));
			}
			else
			{
				string += String.valueOf(queue.get(i)) + delimiter;
			}
		}
		return string;
	}
	/**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	  */
	public void fill(ArrayList<T> list) throws QueueOverflowException
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
				throw new QueueOverflowException();
			}
			else
			{
				queue.add(e);
			}
		}
	}
}
