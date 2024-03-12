import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Junit test class that tests the methods of the SortedDoubleLinkedList class.
 * Due: 03/11/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedListString;
	SortedDoubleLinkedList<Double> sortedLinkedListDouble;
	SortedDoubleLinkedList<Student> sortedLinkedListStudent;
	StringComparator comparator;
	DoubleComparator comparatorD;
	StudentComparator comparatorStudent;
	
	public Student s1 = new Student("Fred", "Forest", 20);
	public Student s2 = new Student("Jack", "Reid", 20);
	public Student s3 = new Student("Hank", "Cameron", 21);
	public Student s4 = new Student("Sam", "Otto", 21);
	public Student s5 = new Student("Cherry", "Shirley", 22);
	public Student s6 = new Student("Chris", "Cruise", 22);
	//alphabetic order: s5 s6 s1 s3 s2 s4
	
	@BeforeEach
	void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedListString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedListDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorStudent = new StudentComparator();
		sortedLinkedListStudent = new SortedDoubleLinkedList<Student>(comparatorStudent);
	}

	@AfterEach
	void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorStudent = null;
		sortedLinkedListString = null;
		sortedLinkedListDouble = null;
		sortedLinkedListStudent = null;
	}

	@Test
	void testGetSize() {
		sortedLinkedListString.add("New");
		sortedLinkedListStudent.add(s1);
		sortedLinkedListStudent.add(s2);
		assertEquals(1,sortedLinkedListString.getSize());
		assertEquals(0,sortedLinkedListDouble.getSize());
		assertEquals(2,sortedLinkedListStudent.getSize());	}

	@Test
	void testAddToEnd() {
		try {
			sortedLinkedListString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	void testAddToFront() {
		try {
			sortedLinkedListString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	void testGetFirst() {
		sortedLinkedListString.add("New");
		assertEquals("New", sortedLinkedListString.getFirst());
		sortedLinkedListString.add("Hello");
		assertEquals("Hello", sortedLinkedListString.getFirst());

		sortedLinkedListStudent.add(s2);
		assertEquals(s2,sortedLinkedListStudent.getFirst());
		sortedLinkedListStudent.add(s1);
		assertEquals(s1,sortedLinkedListStudent.getFirst());
	}

	@Test
	void testGetLast() {
		sortedLinkedListString.add("New");
		assertEquals("New", sortedLinkedListString.getLast());
		sortedLinkedListString.add("Hello");
		assertEquals("New", sortedLinkedListString.getLast());

		sortedLinkedListStudent.add(s2);
		assertEquals(s2,sortedLinkedListStudent.getLast());
		sortedLinkedListStudent.add(s1);
		assertEquals(s2,sortedLinkedListStudent.getLast());
	}

	@Test
	void testIterator() {
		sortedLinkedListString.add("Begin");
		sortedLinkedListString.add("End");
		ListIterator<String> iterator = sortedLinkedListString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("End", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("End", iterator.previous());
		assertEquals("Begin", iterator.previous());
		
		sortedLinkedListStudent.add(s1);
		sortedLinkedListStudent.add(s2);
		ListIterator<Student> iteratorStudent = sortedLinkedListStudent.iterator();
		assertEquals(true, iteratorStudent.hasNext());
		assertEquals(s1, iteratorStudent.next());
		assertEquals(s2, iteratorStudent.next());
		assertEquals(true, iteratorStudent.hasPrevious());
		assertEquals(s2, iteratorStudent.previous());
		assertEquals(s1, iteratorStudent.previous());
	}

	@Test
	void testRemove() {
		// remove the first
		sortedLinkedListStudent.add(s2);
		sortedLinkedListStudent.add(s3);
		assertEquals(s3, sortedLinkedListStudent.getFirst());
		assertEquals(s2, sortedLinkedListStudent.getLast());
		sortedLinkedListStudent.add(s1);
		assertEquals(s1, sortedLinkedListStudent.getFirst());
		sortedLinkedListStudent.remove(s1, comparatorStudent);
		assertEquals(s3, sortedLinkedListStudent.getFirst());
		//remove from the end of the list
		sortedLinkedListStudent.add(s4);
		assertEquals(s4, sortedLinkedListStudent.getLast());
		sortedLinkedListStudent.remove(s4, comparatorStudent);
		assertEquals(s2, sortedLinkedListStudent.getLast());
		//remove from middle of list
		sortedLinkedListStudent.add(s1);
		assertEquals(s1, sortedLinkedListStudent.getFirst());
		assertEquals(s2, sortedLinkedListStudent.getLast());
		sortedLinkedListStudent.remove(s2, comparatorStudent);
		assertEquals(s1, sortedLinkedListStudent.getFirst());
		assertEquals(s3, sortedLinkedListStudent.getLast());
	}

	@Test
	void testRetrieveFirstElement() {
		sortedLinkedListStudent.add(s2);
		assertEquals(s2, sortedLinkedListStudent.getFirst());
		sortedLinkedListStudent.add(s1);
		assertEquals(s1, sortedLinkedListStudent.getFirst());
		assertEquals(s1, sortedLinkedListStudent.retrieveFirstElement());
		assertEquals(s2,sortedLinkedListStudent.getFirst());
		assertEquals(s2, sortedLinkedListStudent.retrieveFirstElement());
		
		sortedLinkedListString.add("Hello");
		assertEquals("Hello", sortedLinkedListString.getFirst());
		sortedLinkedListString.add("New");
		assertEquals("Hello", sortedLinkedListString.getFirst());
		assertEquals("Hello", sortedLinkedListString.retrieveFirstElement());
		assertEquals("New",sortedLinkedListString.getFirst());
		assertEquals("New", sortedLinkedListString.retrieveFirstElement());
	}

	@Test
	void testRetrieveLastElement() {
		sortedLinkedListStudent.add(s3);
		assertEquals(s3, sortedLinkedListStudent.getLast());
		sortedLinkedListStudent.add(s4);
		assertEquals(s4, sortedLinkedListStudent.getLast());
		assertEquals(s4, sortedLinkedListStudent.retrieveLastElement());
		assertEquals(s3,sortedLinkedListStudent.getLast());
		assertEquals(s3, sortedLinkedListStudent.retrieveLastElement());
		
		sortedLinkedListString.add("World");
		assertEquals("World", sortedLinkedListString.getLast());
		sortedLinkedListString.add("New");
		assertEquals("World", sortedLinkedListString.getLast());
		assertEquals("World", sortedLinkedListString.retrieveLastElement());
		assertEquals("New",sortedLinkedListString.getLast());
		assertEquals("New", sortedLinkedListString.retrieveLastElement());
	}

	@Test
	void testToArrayList() {
		ArrayList<Student> list;
		sortedLinkedListStudent.add(s1);
		sortedLinkedListStudent.add(s2);
		sortedLinkedListStudent.add(s3);
		sortedLinkedListStudent.add(s4);
		sortedLinkedListStudent.add(s5);
		sortedLinkedListStudent.add(s6);
		list = sortedLinkedListStudent.toArrayList();
		assertEquals(s5,list.get(0));
		assertEquals(s6,list.get(1));
		assertEquals(s1,list.get(2));
		assertEquals(s3,list.get(3));
		assertEquals(s2,list.get(4));
		assertEquals(s4,list.get(5));
	}

	@Test
	void testAdd() {
		//alphabetic order: s5 s6 s1 s3 s2 s4
		sortedLinkedListStudent.add(s1);
		sortedLinkedListStudent.add(s2);
		sortedLinkedListStudent.add(s3);
		assertEquals(s1, sortedLinkedListStudent.getFirst());
		assertEquals(s2, sortedLinkedListStudent.getLast());
		sortedLinkedListStudent.add(s4);
		sortedLinkedListStudent.add(s5);
		assertEquals(s5, sortedLinkedListStudent.getFirst());
		assertEquals(s4, sortedLinkedListStudent.getLast());

		assertEquals(s4,sortedLinkedListStudent.retrieveLastElement());
		assertEquals(s2, sortedLinkedListStudent.getLast());
	}
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class StudentComparator implements Comparator<Student>
	{

		@Override
		public int compare(Student arg0, Student arg1) {
			// Just put students in alphabetic order by first name
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Student{
		String firstName;
		String lastName;
		int age;
		
		public Student(String firstName, String lastName, int age){
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}
		
		public String getFirstName(){
			return firstName;
		}
		public String getLastName(){
			return lastName;
		}
		public int getAge(){
			return age;
		}
		
		public String toString() {
			return (getFirstName()+" "+getLastName()+" "+getAge());
		}
	}
}
