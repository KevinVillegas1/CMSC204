import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a generic Double Linked List class called BasicDoubleLinkedList that implements the Iterable Interface.
 * Due: 03/11/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{
	protected Node<T> head, tail;
	protected int size;
	/**
	 * Constructor to set to initialize head, tail and size to null, null and 0
	 */
	public BasicDoubleLinkedList()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	/**
	 * Returns the number of nodes in the list.
	 * @return the size of the linked list
	 */
	public int getSize()
	{
		return this.size;
	}
	/**
	 * Adds an element to the end of the list and updated the size of the list
	 * @param data - the data to be added to the list
	 */
	public void addToEnd(T data)
	{
		Node<T> newNode = new Node<T>(data);
		if (getSize() == 0)
		{
			this.head = newNode;
			this.tail = newNode;
			this.size++;
		}
		else
		{
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
			this.size++;
		}
	}
	/**
	 * Adds element to the front of the list and updated the size of the list
	 * @param data - the data to be added to the list
	 */
	public void addToFront(T data)
	{
		Node<T> newNode = new Node<T>(data);
		if (getSize() == 0)
		{
			this.head = newNode;
			this.tail = newNode;
			this.size++;
		}
		else
		{
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
			this.size++;
		}
	}
	/**
	 * Returns but does not remove the first element from the list.
	 * If there are no elements the method returns null.
	 * @return the data element or null
	 */
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
	public T getLast()
	{
		if (getSize() == 0)
		{
			return null;
		}
		return this.tail.getData();
	}
	/**
	 * This method returns an object of the DoubleLinkedListIterator.
	 * (the inner class that implements java's ListIterator interface)
	 * @return a ListIterator object
	 */
	@Override
	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator<T>();
	}
	/**
	 * Removes the first instance of the targetData from the list. 
	 * @param targetData - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return a node containing the targetData or null
	 */
	public Node<T> remove(T targetData, Comparator<T> comparator)
	{
		Node<T> currentIndex = this.head;
		while (currentIndex != null)
		{
			if (comparator.compare(currentIndex.getData(), targetData) == 0)
			{
				if (currentIndex == this.head && currentIndex == this.tail)
				{
					this.head = null;
					this.tail = null;
				}
				else if (currentIndex == this.head)
				{
					this.head = this.head.next;
					this.head.prev = null;
				}
				else if (currentIndex == this.tail)
				{
					this.tail = this.tail.prev;
					this.tail.next = null;
				}
				else
				{
					currentIndex.prev.next = currentIndex.next;
					currentIndex.next.prev = currentIndex.prev;
				}
				this.size--;
				return currentIndex;
			}
			currentIndex = currentIndex.next;
		}
		return null;
	}
	/**
	 * Removes and returns the first element from the list.
	 * If there are no elements the method returns null.
	 * @return data element or null
	 */
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
	/**
	 * A generic inner class Node
	 * @param <E>
	 */
	public class Node<E>
	{
		protected E data;
		protected Node<E> prev, next;
		/**
		 * Constructor for Node class
		 * @param data - data of the node
		 */
		public Node(E data)
		{
			this.data = data;
			this.prev = null;
			this.next = null;
		}
		public void setData(E data)
		{
			this.data = data;
		}
		public E getData()
		{
			return this.data;
		}
		public void setPrev(Node<E> prev)
		{
			this.prev = prev;
		}
		public Node<E> getPrev()
		{
			return this.prev;
		}
		public void setNext(Node<E> next)
		{
			this.next = next;
		}
		public Node<E> getNext()
		{
			return this.next;
		}
	}
	/**
	 * A generic inner class named DoubleLinkedListIterator that implements java’s ListIterator interface (for the iterator method).
	 * @param <E>
	 */
	private class DoubleLinkedListIterator<E> implements ListIterator<E>
	{
		protected Node<T> currentNode;
		protected int index;
		/**
		 * Constructor to initialize the current pointer to the head of the BasicDoubleLinkedList.
		 */
		public DoubleLinkedListIterator()
		{
			this.currentNode = head;
			this.index = 0;
		}
		@Override
		public boolean hasNext()
		{
			if (this.index < size)
			{
				return true;
			}
			return false;
		}
		@Override
		public E next() throws NoSuchElementException
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			@SuppressWarnings("unchecked")
			E data = (E) this.currentNode.getData();
			this.currentNode = this.currentNode.next;
			this.index++;
			return data;
		}
		@Override
		public boolean hasPrevious()
		{
			if (this.index > 0)
			{
				return true;
			}
			return false;
		}
		@SuppressWarnings("unchecked")
		@Override
		public E previous() throws NoSuchElementException
		{
			if (!hasPrevious())
			{
				throw new NoSuchElementException();
			}
			else if (this.currentNode == null)
			{
				this.currentNode = tail;
			}
			else
			{
				this.currentNode = this.currentNode.prev;
			}
			this.index--;
			return (E) this.currentNode.getData();
		}
		@Override
		public int nextIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public void set(E e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public void add(E e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	}
}
