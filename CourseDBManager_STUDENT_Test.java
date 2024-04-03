import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Junit test class that tests the methods of the CourseDBManager class.
 * Due: 04/03/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataManager = new CourseDBManager();
	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dataManager = new CourseDBManager();
	}
	/**
	 * Set dataManager reference to null
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		dataManager = null;
	}
	/**
	 * Test for the add method
	 */
	@Test
	void testAdd() {
		try {
			dataManager.add("CMSC100",12345,3,"SW150","James Smith");
			dataManager.add("CMSC200",67890,4,"SC400","Steven Jones");
			dataManager.add("CMSC300",18423,3,"SW210","Melissa McClain");
			dataManager.add("CMSC400",31415,4,"SC440","Amy Smith");
			dataManager.add("CMSC500",46790,3,"Distance-Learning","Aaron Rogers");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	/**
	 * Test for the get method
	 */
	@Test
	void testGet() {
		try {
			dataManager.add("CMSC100",12345,3,"SW150","James Smith");
			dataManager.add("CMSC200",67890,4,"SC400","Steven Jones");
			dataManager.add("CMSC300",18423,3,"SW210","Melissa McClain");
			dataManager.add("CMSC400",31415,4,"SC440","Amy Smith");
			dataManager.add("CMSC500",46790,3,"Distance-Learning","Aaron Rogers");
			assertEquals("CMSC100",dataManager.get(12345).getID());
			assertEquals("CMSC200",dataManager.get(67890).getID());
			assertEquals("CMSC300",dataManager.get(18423).getID());
			assertEquals("CMSC400",dataManager.get(31415).getID());
			assertEquals("CMSC500",dataManager.get(46790).getID());
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
		try {
			assertEquals(12345, dataManager.get(12345).getCRN());
			CourseDBElement test = new CourseDBElement("CMSC550", 23432, 3, "SW350", "Anthony Williams");
			dataManager.get(test.getCRN()).getCRN();
		}
		catch(Exception e) {
			assertTrue("threw Exception successfuly for the course not found", true);
		}
	}
	/**
	 * Test for the read method
	 */
	@Test
	void testReadFile() {
		try {
			File inputFile = new File("courses.txt");
			dataManager.readFile(inputFile);
			assertEquals("CMSC100",dataManager.get(21556).getID());
			assertEquals(21556,dataManager.get(21556).getCRN());
			assertEquals(2,dataManager.get(21556).getCredits());
			assertEquals("Distance-Learning",dataManager.get(21556).getRoomNum());
			assertEquals("Janet E. Joy",dataManager.get(21556).getInstructor());
			
			assertEquals("CMSC100",dataManager.get(22344).getID());
			assertEquals(22344,dataManager.get(22344).getCRN());
			assertEquals(2,dataManager.get(22344).getCredits());
			assertEquals("SW217",dataManager.get(22344).getRoomNum());
			assertEquals("Gloria E. Barron",dataManager.get(22344).getInstructor());
			
			assertEquals("CMSC100",dataManager.get(22974).getID());
			assertEquals(22974,dataManager.get(22974).getCRN());
			assertEquals(2,dataManager.get(22974).getCredits());
			assertEquals("Distance-Learning",dataManager.get(22974).getRoomNum());
			assertEquals("Janet E. Joy",dataManager.get(22974).getInstructor());
			
			assertEquals("CMSC110",dataManager.get(21561).getID());
			assertEquals(21561,dataManager.get(21561).getCRN());
			assertEquals(3,dataManager.get(21561).getCredits());
			assertEquals("SC451",dataManager.get(21561).getRoomNum());
			assertEquals("Rabiha J. Kayed",dataManager.get(21561).getInstructor());
			
			assertEquals("CMSC110",dataManager.get(20484).getID());
			assertEquals(20484,dataManager.get(20484).getCRN());
			assertEquals(3,dataManager.get(20484).getCredits());
			assertEquals("HT300",dataManager.get(20484).getRoomNum());
			assertEquals("Madhvi A. Shah",dataManager.get(20484).getInstructor());
			
			assertEquals("CMSC110",dataManager.get(23363).getID());
			assertEquals(23363,dataManager.get(23363).getCRN());
			assertEquals(3,dataManager.get(23363).getCredits());
			assertEquals("SC451",dataManager.get(23363).getRoomNum());
			assertEquals("Sascha Simkanich",dataManager.get(23363).getInstructor());
			
			assertEquals("CMSC110",dataManager.get(21565).getID());
			assertEquals(21565,dataManager.get(21565).getCRN());
			assertEquals(3,dataManager.get(21565).getCredits());
			assertEquals("Distance Learning",dataManager.get(21565).getRoomNum());
			assertEquals("Janet E. Joy",dataManager.get(21565).getInstructor());
			
			assertEquals("CMSC110",dataManager.get(21564).getID());
			assertEquals(21564,dataManager.get(21564).getCRN());
			assertEquals(3,dataManager.get(21564).getCredits());
			assertEquals("SC451",dataManager.get(21564).getRoomNum());
			assertEquals("Behzad Maghami",dataManager.get(21564).getInstructor());
			
			assertEquals("CMSC110",dataManager.get(21560).getID());
			assertEquals(21560,dataManager.get(21560).getCRN());
			assertEquals(3,dataManager.get(21560).getCredits());
			assertEquals("SC450",dataManager.get(21560).getRoomNum());
			assertEquals("Behzad Maghami",dataManager.get(21560).getInstructor());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	/**
	 * Test for the showAll method
	 */
	@Test
	void testShowAll() {
		try {
			dataManager.add("CMSC100",12345,3,"SW150","James Smith");
			dataManager.add("CMSC200",67890,4,"SC400","Steven Jones");
			dataManager.add("CMSC300",18423,3,"SW210","Melissa McClain");
			dataManager.add("CMSC400",31415,4,"SC440","Amy Smith");
			dataManager.add("CMSC500",46790,3,"Distance-Learning","Aaron Rogers");
			ArrayList<String> list = dataManager.showAll();
			assertEquals(list.get(0),"\nCourse:CMSC300 CRN:18423 Credits:3 Instructor:Melissa McClain Room:SW210");
			assertEquals(list.get(1),"\nCourse:CMSC200 CRN:67890 Credits:4 Instructor:Steven Jones Room:SC400");
			assertEquals(list.get(2),"\nCourse:CMSC100 CRN:12345 Credits:3 Instructor:James Smith Room:SW150");
			assertEquals(list.get(3),"\nCourse:CMSC500 CRN:46790 Credits:3 Instructor:Aaron Rogers Room:Distance-Learning");
			assertEquals(list.get(4),"\nCourse:CMSC400 CRN:31415 Credits:4 Instructor:Amy Smith Room:SC440");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

}
