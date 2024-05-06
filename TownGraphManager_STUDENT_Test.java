import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Junit test class that tests the methods of the TownGraphManager class.
 * Due: 05/05/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;

	@BeforeEach
	void setUp() throws Exception {
		graph = new TownGraphManager();
		  town = new String[16];
		  
		  for (int i = 1; i < 16; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[3], 7, "Road_1");
		  graph.addRoad(town[3], town[11], 13, "Road_2");
		  graph.addRoad(town[6], town[8], 2, "Road_3");
		  graph.addRoad(town[4], town[11], 1, "Road_4");
		  graph.addRoad(town[14], town[15], 3, "Road_5");
		  graph.addRoad(town[9], town[10], 4, "Road_6");
		  graph.addRoad(town[8], town[9], 3, "Road_7");
		  graph.addRoad(town[13], town[15], 10, "Road_8");
		  graph.addRoad(town[10], town[11], 15, "Road_9");
		  graph.addRoad(town[2], town[12], 8, "Road_10");
		  graph.addRoad(town[5], town[11], 2, "Road_11");
		  graph.addRoad(town[3], town[12], 4, "Road_12");
		  graph.addRoad(town[11], town[12], 5, "Road_13");
		  graph.addRoad(town[5], town[9], 10, "Road_14");
		  graph.addRoad(town[12], town[13], 7, "Road_15");
		  graph.addRoad(town[13], town[14], 6, "Road_16");
		  graph.addRoad(town[10], town[15], 2, "Road_17");
		  graph.addRoad(town[10], town[12], 3, "Road_18");
		  graph.addRoad(town[6], town[7], 5, "Road_19");
		  graph.addRoad(town[4], town[5], 2, "Road_20");
		  graph.addRoad(town[5], town[6], 1, "Road_21");
		  graph.addRoad(town[2], town[13], 1, "Road_22");
		  graph.addRoad(town[5], town[10], 1, "Road_23");
		  graph.addRoad(town[1], town[2], 8, "Road_24");
		  graph.addRoad(town[1], town[14], 9, "Road_25");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	@Test
	void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_2", roads.get(11));
		assertEquals("Road_20", roads.get(12));
		assertEquals("Road_21", roads.get(13));
		assertEquals("Road_22", roads.get(14));
		assertEquals("Road_23", roads.get(15));
		assertEquals("Road_24", roads.get(16));
		assertEquals("Road_25", roads.get(17));
		graph.addRoad(town[1], town[15], 7,"Road_26");
		roads = graph.allRoads();
		assertEquals("Road_2", roads.get(11));
		assertEquals("Road_20", roads.get(12));
		assertEquals("Road_21", roads.get(13));
		assertEquals("Road_22", roads.get(14));
		assertEquals("Road_23", roads.get(15));
		assertEquals("Road_24", roads.get(16));
		assertEquals("Road_25", roads.get(17));
		assertEquals("Road_26", roads.get(18));
	}

	@Test
	void testGetRoad() {
		assertEquals("Road_1", graph.getRoad(town[1], town[3]));
		assertEquals("Road_2", graph.getRoad(town[3], town[11]));
		assertEquals("Road_3", graph.getRoad(town[6], town[8]));
		assertEquals("Road_4", graph.getRoad(town[4], town[11]));
		assertEquals("Road_5", graph.getRoad(town[14], town[15]));
		assertEquals("Road_6", graph.getRoad(town[9], town[10]));
		assertEquals("Road_7", graph.getRoad(town[8], town[9]));
		assertEquals("Road_8", graph.getRoad(town[13], town[15]));
		assertEquals("Road_9", graph.getRoad(town[10], town[11]));
		assertEquals("Road_10", graph.getRoad(town[2], town[12]));
		assertEquals("Road_11", graph.getRoad(town[5], town[11]));
		assertEquals("Road_12", graph.getRoad(town[3], town[12]));
		assertEquals("Road_13", graph.getRoad(town[11], town[12]));
		assertEquals("Road_14", graph.getRoad(town[5], town[9]));
		assertEquals("Road_15", graph.getRoad(town[12], town[13]));
		assertEquals("Road_16", graph.getRoad(town[13], town[14]));
		assertEquals("Road_17", graph.getRoad(town[10], town[15]));
		assertEquals("Road_18", graph.getRoad(town[10], town[12]));
		assertEquals("Road_19", graph.getRoad(town[6], town[7]));
		assertEquals("Road_20", graph.getRoad(town[4], town[5]));
		assertEquals("Road_21", graph.getRoad(town[5], town[6]));
		assertEquals("Road_22", graph.getRoad(town[2], town[13]));
		assertEquals("Road_23", graph.getRoad(town[5], town[10]));
		assertEquals("Road_24", graph.getRoad(town[1], town[2]));
		assertEquals("Road_25", graph.getRoad(town[1], town[14]));
	}

	@Test
	void testAddTown() {
		assertEquals(false, graph.containsTown("Town_16"));
		graph.addTown("Town_16");
		assertEquals(true, graph.containsTown("Town_16"));
		assertEquals(false, graph.containsTown("Town_17"));
		graph.addTown("Town_17");
		assertEquals(true, graph.containsTown("Town_17"));
		assertEquals(false, graph.containsTown("Town_18"));
		graph.addTown("Town_18");
		assertEquals(true, graph.containsTown("Town_18"));
		assertEquals(false, graph.containsTown("Town_19"));
		graph.addTown("Town_19");
		assertEquals(true, graph.containsTown("Town_19"));
		assertEquals(false, graph.containsTown("Town_20"));
		graph.addTown("Town_20");
		assertEquals(true, graph.containsTown("Town_20"));
	}

	@Test
	void testGetTown() {
		assertEquals("Town_1", graph.getTown("Town_1").getName());
		assertEquals("Town_2", graph.getTown("Town_2").getName());
		assertEquals("Town_3", graph.getTown("Town_3").getName());
		assertEquals("Town_4", graph.getTown("Town_4").getName());
		assertEquals("Town_5", graph.getTown("Town_5").getName());
		assertEquals("Town_6", graph.getTown("Town_6").getName());
		assertEquals("Town_7", graph.getTown("Town_7").getName());
		assertEquals("Town_8", graph.getTown("Town_8").getName());
		assertEquals("Town_9", graph.getTown("Town_9").getName());
		assertEquals("Town_10", graph.getTown("Town_10").getName());
		assertEquals("Town_11", graph.getTown("Town_11").getName());
		assertEquals("Town_12", graph.getTown("Town_12").getName());
		assertEquals("Town_13", graph.getTown("Town_13").getName());
		assertEquals("Town_14", graph.getTown("Town_14").getName());
		assertEquals("Town_15", graph.getTown("Town_15").getName());
	}

	@Test
	void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_1"));
		assertEquals(false, graph.containsTown("Town_16"));
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_17"));
		assertEquals(true, graph.containsTown("Town_3"));
		assertEquals(false, graph.containsTown("Town_18"));
		assertEquals(true, graph.containsTown("Town_4"));
		assertEquals(false, graph.containsTown("Town_19"));
		assertEquals(true, graph.containsTown("Town_5"));
		assertEquals(false, graph.containsTown("Town_20"));
		assertEquals(true, graph.containsTown("Town_6"));
		assertEquals(false, graph.containsTown("Town_21"));
		assertEquals(true, graph.containsTown("Town_7"));
		assertEquals(false, graph.containsTown("Town_22"));
		assertEquals(true, graph.containsTown("Town_8"));
		assertEquals(false, graph.containsTown("Town_23"));
		assertEquals(true, graph.containsTown("Town_9"));
		assertEquals(false, graph.containsTown("Town_24"));
		assertEquals(true, graph.containsTown("Town_10"));
		assertEquals(false, graph.containsTown("Town_25"));
	}

	@Test
	void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[1], town[3]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[4]));
		assertEquals(true, graph.containsRoadConnection(town[5], town[6]));
		assertEquals(false, graph.containsRoadConnection(town[7], town[8]));
		assertEquals(true, graph.containsRoadConnection(town[9], town[10]));
		assertEquals(false, graph.containsRoadConnection(town[10], town[13]));
		assertEquals(true, graph.containsRoadConnection(town[2], town[13]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[5]));
		assertEquals(true, graph.containsRoadConnection(town[1], town[2]));
		assertEquals(false, graph.containsRoadConnection(town[8], town[11]));
		assertEquals(true, graph.containsRoadConnection(town[14], town[15]));
		assertEquals(false, graph.containsRoadConnection(town[5], town[12]));
		assertEquals(true, graph.containsRoadConnection(town[2], town[12]));
		assertEquals(false, graph.containsRoadConnection(town[2], town[14]));
		assertEquals(true, graph.containsRoadConnection(town[10], town[11]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[10]));
		assertEquals(true, graph.containsRoadConnection(town[8], town[9]));
		assertEquals(false, graph.containsRoadConnection(town[2], town[3]));
	}

	@Test
	void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_12", roads.get(3));
		assertEquals("Road_13", roads.get(4));
		assertEquals("Road_14", roads.get(5));
		assertEquals("Road_15", roads.get(6));
		assertEquals("Road_16", roads.get(7));
		assertEquals("Road_17", roads.get(8));
		assertEquals("Road_18", roads.get(9));
		assertEquals("Road_19", roads.get(10));
		assertEquals("Road_2", roads.get(11));
		assertEquals("Road_20", roads.get(12));
		assertEquals("Road_21", roads.get(13));
		assertEquals("Road_22", roads.get(14));
		assertEquals("Road_23", roads.get(15));
		assertEquals("Road_24", roads.get(16));
		assertEquals("Road_25", roads.get(17));
		assertEquals("Road_3", roads.get(18));
		assertEquals("Road_4", roads.get(19));
		assertEquals("Road_5", roads.get(20));
		assertEquals("Road_6", roads.get(21));
		assertEquals("Road_7", roads.get(22));
		assertEquals("Road_8", roads.get(23));
		assertEquals("Road_9", roads.get(24));
	}

	@Test
	void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[1], town[14]));
		graph.deleteRoadConnection(town[1], town[14], "Road_25");
		assertEquals(false, graph.containsRoadConnection(town[1], town[14]));
		assertEquals(true, graph.containsRoadConnection(town[3], town[12]));
		graph.deleteRoadConnection(town[3], town[12], "Road_12");
		assertEquals(false, graph.containsRoadConnection(town[3], town[12]));
		assertEquals(true, graph.containsRoadConnection(town[4], town[5]));
		graph.deleteRoadConnection(town[4], town[5], "Road_20");
		assertEquals(false, graph.containsRoadConnection(town[4], town[5]));
		assertEquals(true, graph.containsRoadConnection(town[8], town[9]));
		graph.deleteRoadConnection(town[8], town[9], "Road_7");
		assertEquals(false, graph.containsRoadConnection(town[8], town[9]));
		assertEquals(true, graph.containsRoadConnection(town[10], town[15]));
		graph.deleteRoadConnection(town[10], town[15], "Road_17");
		assertEquals(false, graph.containsRoadConnection(town[10], town[15]));
	}

	@Test
	void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_15"));
		graph.deleteTown(town[15]);
		assertEquals(false, graph.containsTown("Town_15"));
		assertEquals(true, graph.containsTown("Town_7"));
		graph.deleteTown(town[7]);
		assertEquals(false, graph.containsTown("Town_7"));
		assertEquals(true, graph.containsTown("Town_11"));
		graph.deleteTown(town[11]);
		assertEquals(false, graph.containsTown("Town_11"));
		assertEquals(true, graph.containsTown("Town_8"));
		graph.deleteTown(town[8]);
		assertEquals(false, graph.containsTown("Town_8"));
		assertEquals(true, graph.containsTown("Town_2"));
		graph.deleteTown(town[2]);
		assertEquals(false, graph.containsTown("Town_2"));
	}

	@Test
	void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_10", roads.get(1));
		assertEquals("Town_11", roads.get(2));
		assertEquals("Town_12", roads.get(3));
		assertEquals("Town_13", roads.get(4));
		assertEquals("Town_14", roads.get(5));
		assertEquals("Town_15", roads.get(6));
		assertEquals("Town_2", roads.get(7));
		assertEquals("Town_3", roads.get(8));
		assertEquals("Town_4", roads.get(9));
		assertEquals("Town_5", roads.get(10));
		assertEquals("Town_6", roads.get(11));
		assertEquals("Town_7", roads.get(12));
		assertEquals("Town_8", roads.get(13));
		assertEquals("Town_9", roads.get(14));
	}

	@Test
	void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[7]);
		assertNotNull(path);
		assertTrue(path.size() > 0);
		assertEquals("Town_1 via Road_1 to Town_3 7 mi",path.get(0).trim());
		assertEquals("Town_3 via Road_12 to Town_12 4 mi",path.get(1).trim());
		assertEquals("Town_12 via Road_18 to Town_10 3 mi",path.get(2).trim());
		assertEquals("Town_10 via Road_23 to Town_5 1 mi",path.get(3).trim());
		assertEquals("Town_5 via Road_21 to Town_6 1 mi",path.get(4).trim());
		assertEquals("Town_6 via Road_19 to Town_7 5 mi",path.get(5).trim());
	}

}
