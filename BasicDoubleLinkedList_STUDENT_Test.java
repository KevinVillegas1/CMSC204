import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Junit test class that tests the methods of the BasicDoubleLinkedList class.
 * Due: 03/11/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> linkedListString;
	BasicDoubleLinkedList<Double> linkedListDouble;
	BasicDoubleLinkedList<Student> linkedListStudent;
	StringComparator comparator;
	DoubleComparator comparatorD;
	StudentComparator comparatorStudent;
	
	public Student s1 = new Student("Fred", "Forest", 20);
	public Student s2 = new Student("Jack", "Reid", 20);
	public Student s3 = new Student("Hank", "Cameron", 21);
	public Student s4 = new Student("Sam", "Otto", 21);
	public Student s5 = new Student("Cherry", "Shirley", 22);
	public Student s6 = new Student("Chris", "Cruise", 22);
	
	public ArrayList<Student> fill = new ArrayList<Student>();
	
	@BeforeEach
	void setUp() throws Exception {
		linkedListString = new BasicDoubleLinkedList<String>();
		linkedListString.addToEnd("Hello");
		linkedListString.addToEnd("World");
		comparator = new StringComparator();
		
		linkedListDouble = new BasicDoubleLinkedList<Double>();
		linkedListDouble.addToEnd(15.0);
		linkedListDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();
		
		linkedListStudent = new BasicDoubleLinkedList<Student>();
		linkedListStudent.addToEnd(s2);
		linkedListStudent.addToEnd(s3);
		comparatorStudent = new StudentComparator();
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedListString = null;
		linkedListDouble = null;
		linkedListStudent = null;
		comparatorD = null;
		comparator = null;
	}

	@Test
	void testGetSize() {
		assertEquals(2,linkedListString.getSize());
		assertEquals(2,linkedListDouble.getSize());
		assertEquals(2,linkedListStudent.getSize());
	}

	@Test
	void testAddToEnd() {
		assertEquals("World", linkedListString.getLast());
		linkedListString.addToEnd("End");
		assertEquals("End", linkedListString.getLast());
		
		assertEquals(s3,linkedListStudent.getLast());
		linkedListStudent.addToEnd(s4);
		assertEquals(s4,linkedListStudent.getLast());
	}

	@Test
	void testAddToFront() {
		assertEquals("Hello", linkedListString.getFirst());
		linkedListString.addToFront("Begin");
		assertEquals("Begin", linkedListString.getFirst());
		
		assertEquals(s2,linkedListStudent.getFirst());
		linkedListStudent.addToFront(s1);
		assertEquals(s1,linkedListStudent.getFirst());
	}

	@Test
	void testGetFirst() {
		assertEquals("Hello", linkedListString.getFirst());
		linkedListString.addToFront("New");
		assertEquals("New", linkedListString.getFirst());
		
		assertEquals(s2,linkedListStudent.getFirst());
		linkedListStudent.addToFront(s1);
		assertEquals(s1,linkedListStudent.getFirst());
	}

	@Test
	void testGetLast() {
		assertEquals("World", linkedListString.getLast());
		linkedListString.addToEnd("New");
		assertEquals("New", linkedListString.getLast());
		
		assertEquals(s3,linkedListStudent.getLast());
		linkedListStudent.addToEnd(s4);
		assertEquals(s4,linkedListStudent.getLast());
	}

	@Test
	void testIterator() {
		linkedListString.addToFront("Begin");
		linkedListString.addToEnd("End");
		ListIterator<String> iterator = linkedListString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("End", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("End", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
		assertEquals("Begin", iterator.previous());
		
		linkedListStudent.addToFront(s1);
		linkedListStudent.addToEnd(s4);
		ListIterator<Student> iteratorStudent = linkedListStudent.iterator();
		assertEquals(true, iteratorStudent.hasNext());
		assertEquals(s1, iteratorStudent.next());
		assertEquals(s2, iteratorStudent.next());
		assertEquals(s3, iteratorStudent.next());
		assertEquals(s4, iteratorStudent.next());
		assertEquals(true, iteratorStudent.hasPrevious());
		assertEquals(s4, iteratorStudent.previous());
		assertEquals(s3, iteratorStudent.previous());
		assertEquals(s2, iteratorStudent.previous());
		assertEquals(s1, iteratorStudent.previous());
	}

	@Test
	void testRemove() {
		// remove the first
		assertEquals(s2, linkedListStudent.getFirst());
		assertEquals(s3, linkedListStudent.getLast());
		linkedListStudent.addToFront(s1);
		assertEquals(s1, linkedListStudent.getFirst());
		linkedListStudent.remove(s1, comparatorStudent);
		assertEquals(s2, linkedListStudent.getFirst());
		//remove from the end of the list
		linkedListStudent.addToEnd(s4);
		assertEquals(s4, linkedListStudent.getLast());
		linkedListStudent.remove(s4, comparatorStudent);
		assertEquals(s3, linkedListStudent.getLast());
		//remove from middle of list
		linkedListStudent.addToFront(s1);
		assertEquals(s1, linkedListStudent.getFirst());
		assertEquals(s3, linkedListStudent.getLast());
		linkedListStudent.remove(s2, comparatorStudent);
		assertEquals(s1, linkedListStudent.getFirst());
		assertEquals(s3, linkedListStudent.getLast());
	}

	@Test
	void testRetrieveFirstElement() {
		assertEquals(s2, linkedListStudent.getFirst());
		linkedListStudent.addToFront(s1);
		assertEquals(s1, linkedListStudent.getFirst());
		assertEquals(s1, linkedListStudent.retrieveFirstElement());
		assertEquals(s2,linkedListStudent.getFirst());
		assertEquals(s2, linkedListStudent.retrieveFirstElement());
		assertEquals(s3,linkedListStudent.getFirst());
		assertEquals(s3, linkedListStudent.retrieveFirstElement());
		
		assertEquals("Hello", linkedListString.getFirst());
		linkedListString.addToFront("New");
		assertEquals("New", linkedListString.getFirst());
		assertEquals("New", linkedListString.retrieveFirstElement());
		assertEquals("Hello",linkedListString.getFirst());
		assertEquals("Hello", linkedListString.retrieveFirstElement());
		assertEquals("World",linkedListString.getFirst());
		assertEquals("World", linkedListString.retrieveFirstElement());
	}

	@Test
	void testRetrieveLastElement() {
		assertEquals(s3, linkedListStudent.getLast());
		linkedListStudent.addToEnd(s4);
		assertEquals(s4, linkedListStudent.getLast());
		assertEquals(s4, linkedListStudent.retrieveLastElement());
		assertEquals(s3,linkedListStudent.getLast());
		assertEquals(s3, linkedListStudent.retrieveLastElement());
		
		assertEquals("World", linkedListString.getLast());
		linkedListString.addToEnd("New");
		assertEquals("New", linkedListString.getLast());
		assertEquals("New", linkedListString.retrieveLastElement());
		assertEquals("World",linkedListString.getLast());
		assertEquals("World", linkedListString.retrieveLastElement());
	}

	@Test
	void testToArrayList() {
		ArrayList<Student> list;
		linkedListStudent.addToFront(s1);
		linkedListStudent.addToEnd(s4);
		list = linkedListStudent.toArrayList();
		assertEquals(s1,list.get(0));
		assertEquals(s2,list.get(1));
		assertEquals(s3,list.get(2));
		assertEquals(s4,list.get(3));
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
			// Just put cars in alphabetic order by make
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
