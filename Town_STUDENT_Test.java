import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Junit test class that tests the methods of the Town class.
 * Due: 05/05/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
class Town_STUDENT_Test {
	Town t1;
	Town t2;
	Town t3;
	
	@BeforeEach
	void setUp() throws Exception {
		t1 = new Town("Town 1");
		t2 = new Town("Town 2");
		t3 = new Town(t2);
	}

	@AfterEach
	void tearDown() throws Exception {
		t1 = t2 = t3 = null;
	}
	
	@Test
	void testAddToListOfAdjacentTowns() {
		assertEquals(0, t1.getListOfAdjacentTowns().size());
		Town t4 = new Town("Town 3");
		Town t5 = new Town("Town 4");
		t1.addToListOfAdjacentTowns(t2);
		assertEquals(1, t1.getListOfAdjacentTowns().size());
		t1.addToListOfAdjacentTowns(t4);
		assertEquals(2, t1.getListOfAdjacentTowns().size());
		t1.addToListOfAdjacentTowns(t5);
		assertEquals(3, t1.getListOfAdjacentTowns().size());
	}
	
	@Test
	void testRemoveFromListOfAdjacentTowns() {
		assertEquals(0, t1.getListOfAdjacentTowns().size());
		Town t4 = new Town("Town 3");
		Town t5 = new Town("Town 4");
		t1.addToListOfAdjacentTowns(t2);
		assertEquals(1, t1.getListOfAdjacentTowns().size());
		t1.addToListOfAdjacentTowns(t4);
		assertEquals(2, t1.getListOfAdjacentTowns().size());
		t1.addToListOfAdjacentTowns(t5);
		assertEquals(3, t1.getListOfAdjacentTowns().size());
		t1.removeFromListOfAdjacentTowns(t5);
		assertEquals(2, t1.getListOfAdjacentTowns().size());
		t1.removeFromListOfAdjacentTowns(t4);
		assertEquals(1, t1.getListOfAdjacentTowns().size());
		t1.removeFromListOfAdjacentTowns(t2);
		assertEquals(0, t1.getListOfAdjacentTowns().size());
	}
	
	@Test
	void testGetListOfAdjacentTowns() {
		ArrayList<Town> arrayList = new ArrayList<Town>();
		assertEquals(arrayList, t1.getListOfAdjacentTowns());
		Town t4 = new Town("Town 3");
		Town t5 = new Town("Town 4");
		arrayList.add(t2);
		arrayList.add(t4);
		arrayList.add(t5);
		t1.addToListOfAdjacentTowns(t2);
		t1.addToListOfAdjacentTowns(t4);
		t1.addToListOfAdjacentTowns(t5);
		assertEquals(arrayList, t1.getListOfAdjacentTowns());
	}

	@Test
	void testHashCode() {
		assertEquals(-1783955901, t1.hashCode());
		assertEquals(-1783955900, t2.hashCode());
		assertEquals(-1783955900, t3.hashCode());
	}

	@Test
	void testGetName() {
		assertEquals("Town 1", t1.getName());
		assertEquals("Town 2", t2.getName());
		assertEquals("Town 2", t3.getName());
	}

	@Test
	void testCompareTo() {
		assertEquals(-1, t1.compareTo(t2));
		assertEquals(1, t2.compareTo(t1));
		assertEquals(-1, t1.compareTo(t3));
		assertEquals(1, t3.compareTo(t1));
		assertEquals(0, t2.compareTo(t3));
		assertEquals(0, t3.compareTo(t2));
	}

	@Test
	void testToString() {
		assertEquals("Town 1", t1.toString());
		assertEquals("Town 2", t2.toString());
		assertEquals("Town 2", t3.toString());
	}

	@Test
	void testEqualsObject() {
		assertEquals(false, t1.equals(t2));
		assertEquals(false, t2.equals(t1));
		assertEquals(false, t1.equals(t3));
		assertEquals(false, t3.equals(t1));
		assertEquals(true, t2.equals(t3));
		assertEquals(true, t3.equals(t2));
	}

}
