import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Junit test class that tests the methods of the Road class.
 * Due: 05/05/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
class Road_STUDENT_Test {
	Road r1, r2, r3;
	Town t1, t2, t3, t4, t5, t6;

	@BeforeEach
	void setUp() throws Exception {
		t1 = new Town("Town 1");
		t2 = new Town("Town 2");
		t3 = new Town("Town 3");
		t4 = new Town("Town 4");
		t5 = new Town("Town 5");
		t6 = new Town("Town 6");
		r1 = new Road(t1, t2, 3, "Road 1");
		r2 = new Road(t3, t4, 10, "Road 2");
		r3 = new Road(t5, t6, "Road 3");
	}

	@AfterEach
	void tearDown() throws Exception {
		r1 = r2 = r3 = null;
		t1 = t2 = t3 = t4 = t5 = t6 = null;
	}

	@Test
	void testContains() {
		assertEquals(true, r1.contains(t1));
		assertEquals(true, r1.contains(t2));
		assertEquals(false, r1.contains(t3));
		assertEquals(false, r1.contains(t5));
		assertEquals(true, r2.contains(t3));
		assertEquals(true, r2.contains(t4));
		assertEquals(false, r2.contains(t6));
		assertEquals(false, r2.contains(t2));
		assertEquals(true, r3.contains(t5));
		assertEquals(true, r3.contains(t6));
		assertEquals(false, r3.contains(t1));
		assertEquals(false, r3.contains(t4));
	}

	@Test
	void testToString() {
		assertEquals("Road 1", r1.toString());
		assertEquals("Road 2", r2.toString());
		assertEquals("Road 3", r3.toString());
	}

	@Test
	void testGetName() {
		assertEquals("Road 1", r1.getName());
		assertEquals("Road 2", r2.getName());
		assertEquals("Road 3", r3.getName());
	}

	@Test
	void testGetDestination() {
		assertEquals(t2, r1.getDestination());
		assertEquals(t4, r2.getDestination());
		assertEquals(t6, r3.getDestination());
	}

	@Test
	void testGetSource() {
		assertEquals(t1, r1.getSource());
		assertEquals(t3, r2.getSource());
		assertEquals(t5, r3.getSource());
	}

	@Test
	void testCompareTo() {
		assertEquals(-1, r1.compareTo(r2));
		assertEquals(1, r2.compareTo(r1));
		assertEquals(0, r1.compareTo(r1));
		assertEquals(-1, r2.compareTo(r3));
		assertEquals(1, r3.compareTo(r2));
		assertEquals(0, r2.compareTo(r2));
		assertEquals(2, r3.compareTo(r1));
		assertEquals(-2, r1.compareTo(r3));
		assertEquals(0, r3.compareTo(r3));
	}

	@Test
	void testGetWeight() {
		assertEquals(3, r1.getWeight());
		assertEquals(10, r2.getWeight());
		assertEquals(1, r3.getWeight());
	}

	@Test
	void testEqualsObject() {
		assertEquals(false, r1.equals(r2));
		assertEquals(false, r2.equals(r1));
		assertEquals(true, r1.equals(r1));
		assertEquals(false, r2.equals(r3));
		assertEquals(false, r3.equals(r2));
		assertEquals(true, r2.equals(r2));
		assertEquals(false, r3.equals(r1));
		assertEquals(false, r1.equals(r3));
		assertEquals(true, r3.equals(r3));
	}

}
