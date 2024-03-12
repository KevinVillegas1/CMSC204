import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a generic Double Linked List class called SortedDoubleLinkedList that extends the BasicDoubleLinkedList super class.
 * Due: 03/11/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	protected Comparator<T> comparator;
	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param comparator - Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator)
	{
		super();
		this.comparator = comparator;
	}
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * @param data - the data to be added to the list
	 */
	public void add(T data)
	{
		Node<T> newNode = new Node<T>(data);
		if (this.size == 0)
		{
			this.head = newNode;
			this.tail = newNode;
			this.size++;
		}
		else if (comparator.compare(newNode.data, this.head.data) <= 0)
		{
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
			this.size++;
		}
		else if (comparator.compare(newNode.data, this.tail.data) >= 0)
		{
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
			this.size++;
		}
		else
		{
			Node<T> currentNode = this.head;
			while (currentNode != null && comparator.compare(newNode.data, currentNode.data) > 0)
			{
				currentNode = currentNode.next;
			}
			newNode.prev = currentNode.prev;
			newNode.next = currentNode;
			currentNode.prev.next = newNode;
			currentNode.prev = newNode;
			this.size++;
		}
	}
	/**
	 * This operation is invalid for a sorted list.
	 * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 * @param data - the data for the Node within the linked list
	 * @throws UnsupportedOperationException - if method is called
	 */
	@Override
	public void addToFront(T data)
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * This operation is invalid for a sorted list.
	 * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 * @param data - the data for the Node within the linked list
	 * @throws UnsupportedOperationException - if method is called
	 */
	@Override
	public void addToEnd(T data)
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * @return an iterator positioned at the head of the list
	 */
	@Override
	public ListIterator<T> iterator()
	{
		return super.iterator();
	}
	/**
	 * Returns the number of nodes in the list.
	 * @return the size of the linked list
	 */
	@Override
	public int getSize()
	{
		return this.size;
	}
	/**
	 * Returns but does not remove the first element from the list.
	 * If there are no elements the method returns null.
	 * @return the data element or null
	 */
	@Override
	public T getFirst()
	{
		if (getSize() == 0)
		{
			return null;
		}
		return this.head.getData();
	}
	/**
	 * Returns but does not remove the last element from the list.
	 * If there are no elements the method returns null.
	 * @return the data element or null
	 */
	@Override
	public T getLast()
	{
		if (getSize() == 0)
		{
			return null;
		}
		return this.tail.getData();
	}
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @param data - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return a node containing the data or null
	 */
	@Override
	public Node<T> remove(T targetData, Comparator<T> comparator)
	{
		return super.remove(targetData, comparator);
	}
	/**
	 * Removes and returns the first element from the list.
	 * If there are no elements the method returns null.
	 * @return data element or null
	 */
	@Override
	public T retrieveFirstElement()
	{
		if (getSize() == 0)
		{
			return null;
		}
		Node<T> firstElement = this.head;
		this.head = this.head.next;
		if (this.head == null)
		{
			return firstElement.getData();
		}
		this.head.prev = null;
		return firstElement.getData();
	}
	/**
	 * Removes and returns the last element from the list.
	 * If there are no elements the method returns null.
	 * @return data element or null
	 */
	@Override
	public T retrieveLastElement()
	{
		if (getSize() == 0)
		{
			return null;
		}
		Node<T> lastElement = this.tail;
		this.tail = this.tail.prev;
		if (this.tail == null)
		{
			return lastElement.getData();
		}
		this.tail.next = null;
		return lastElement.getData();
	}
	/**
	 * Returns an arraylist of all the items in the Double Linked list
	 * @return an arraylist of the items in the list
	 */
	@Override
	public ArrayList<T> toArrayList()
	{
		if (getSize() == 0)
		{
			return null;
		}
		ArrayList<T> arrayList = new ArrayList<T>();
		Node<T> currentNode = this.head;
		while (currentNode != null)
		{
			arrayList.add(currentNode.data);
			currentNode = currentNode.next;
		}
		return arrayList;
	}
}
