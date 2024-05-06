import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Junit test class that tests the methods of the Graph class.
 * Due: 05/05/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@BeforeEach
	void setUp() throws Exception {
		graph = new Graph();
		town = new Town[16];
		for (int i = 1; i < 16; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		}
		
		graph.addEdge(town[1], town[3], 7, "Road_1");
		graph.addEdge(town[3], town[11], 13, "Road_2");
		graph.addEdge(town[6], town[8], 2, "Road_3");
		graph.addEdge(town[4], town[11], 1, "Road_4");
		graph.addEdge(town[14], town[15], 3, "Road_5");
		graph.addEdge(town[9], town[10], 4, "Road_6");
		graph.addEdge(town[8], town[9], 3, "Road_7");
		graph.addEdge(town[13], town[15], 10, "Road_8");
		graph.addEdge(town[10], town[11], 15, "Road_9");
		graph.addEdge(town[2], town[12], 8, "Road_10");
		graph.addEdge(town[5], town[11], 2, "Road_11");
		graph.addEdge(town[3], town[12], 4, "Road_12");
		graph.addEdge(town[11], town[12], 5, "Road_13");
		graph.addEdge(town[5], town[9], 10, "Road_14");
		graph.addEdge(town[12], town[13], 7, "Road_15");
		graph.addEdge(town[13], town[14], 6, "Road_16");
		graph.addEdge(town[10], town[15], 2, "Road_17");
		graph.addEdge(town[10], town[12], 3, "Road_18");
		graph.addEdge(town[6], town[7], 5, "Road_19");
		graph.addEdge(town[4], town[5], 2, "Road_20");
		graph.addEdge(town[5], town[6], 1, "Road_21");
		graph.addEdge(town[2], town[13], 1, "Road_22");
		graph.addEdge(town[5], town[10], 1, "Road_23");
		graph.addEdge(town[1], town[2], 8, "Road_24");
		graph.addEdge(town[1], town[14], 9, "Road_25");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	@Test
	void testGetEdge() {
		assertEquals(new Road(town[1], town[3],7, "Road_1"), graph.getEdge(town[1], town[3]));
		assertEquals(new Road(town[3], town[11],13, "Road_2"), graph.getEdge(town[3], town[11]));
		assertEquals(new Road(town[6], town[8],2, "Road_3"), graph.getEdge(town[6], town[8]));
		assertEquals(new Road(town[4], town[11],1, "Road_4"), graph.getEdge(town[4], town[11]));
		assertEquals(new Road(town[14], town[15],3, "Road_5"), graph.getEdge(town[14], town[15]));
		assertEquals(new Road(town[9], town[10],4, "Road_6"), graph.getEdge(town[9], town[10]));
		assertEquals(new Road(town[8], town[9],3, "Road_7"), graph.getEdge(town[8], town[9]));
		assertEquals(new Road(town[13], town[15],10, "Road_8"), graph.getEdge(town[13], town[15]));
		assertEquals(new Road(town[10], town[11],15, "Road_9"), graph.getEdge(town[10], town[11]));
		assertEquals(new Road(town[2], town[12],8, "Road_10"), graph.getEdge(town[2], town[12]));
		assertEquals(new Road(town[5], town[11],2, "Road_11"), graph.getEdge(town[5], town[11]));
		assertEquals(new Road(town[3], town[12],4, "Road_12"), graph.getEdge(town[3], town[12]));
		assertEquals(new Road(town[11], town[12],5, "Road_13"), graph.getEdge(town[11], town[12]));
		assertEquals(new Road(town[5], town[9],10, "Road_14"), graph.getEdge(town[5], town[9]));
		assertEquals(new Road(town[12], town[13],7, "Road_15"), graph.getEdge(town[12], town[13]));
		assertEquals(new Road(town[13], town[14],6, "Road_16"), graph.getEdge(town[13], town[14]));
		assertEquals(new Road(town[10], town[15],2, "Road_17"), graph.getEdge(town[10], town[15]));
		assertEquals(new Road(town[10], town[12],3, "Road_18"), graph.getEdge(town[10], town[12]));
		assertEquals(new Road(town[6], town[7],5, "Road_19"), graph.getEdge(town[6], town[7]));
		assertEquals(new Road(town[4], town[5],2, "Road_20"), graph.getEdge(town[4], town[5]));
		assertEquals(new Road(town[5], town[6],1, "Road_21"), graph.getEdge(town[5], town[6]));
		assertEquals(new Road(town[2], town[13],1, "Road_22"), graph.getEdge(town[2], town[13]));
		assertEquals(new Road(town[5], town[10],1, "Road_23"), graph.getEdge(town[5], town[10]));
		assertEquals(new Road(town[1], town[2],8, "Road_24"), graph.getEdge(town[1], town[2]));
		assertEquals(new Road(town[1], town[14],9, "Road_25"), graph.getEdge(town[1], town[14]));
	}

	@Test
	void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[1], town[15]));
		graph.addEdge(town[1], town[15], 9, "Road_26");
		assertEquals(true, graph.containsEdge(town[1], town[15]));
		assertEquals(false, graph.containsEdge(town[6], town[10]));
		graph.addEdge(town[6], town[10], 4, "Road_27");
		assertEquals(true, graph.containsEdge(town[6], town[10]));
		assertEquals(false, graph.containsEdge(town[4], town[7]));
		graph.addEdge(town[4], town[7], 12, "Road_28");
		assertEquals(true, graph.containsEdge(town[4], town[7]));
		assertEquals(false, graph.containsEdge(town[12], town[15]));
		graph.addEdge(town[12], town[15], 2, "Road_29");
		assertEquals(true, graph.containsEdge(town[12], town[15]));
		assertEquals(false, graph.containsEdge(town[3], town[4]));
		graph.addEdge(town[3], town[4], 8, "Road_30");
		assertEquals(true, graph.containsEdge(town[3], town[4]));
	}

	@Test
	void testAddVertex() {
		Town newTown1 = new Town("Town_16");
		assertEquals(false, graph.containsVertex(newTown1));
		graph.addVertex(newTown1);
		assertEquals(true, graph.containsVertex(newTown1));
		Town newTown2 = new Town("Town_17");
		assertEquals(false, graph.containsVertex(newTown2));
		graph.addVertex(newTown2);
		assertEquals(true, graph.containsVertex(newTown2));
		Town newTown3 = new Town("Town_18");
		assertEquals(false, graph.containsVertex(newTown3));
		graph.addVertex(newTown3);
		assertEquals(true, graph.containsVertex(newTown3));
		Town newTown4 = new Town("Town_19");
		assertEquals(false, graph.containsVertex(newTown4));
		graph.addVertex(newTown4);
		assertEquals(true, graph.containsVertex(newTown4));
		Town newTown5 = new Town("Town_20");
		assertEquals(false, graph.containsVertex(newTown5));
		graph.addVertex(newTown5);
		assertEquals(true, graph.containsVertex(newTown5));
	}

	@Test
	void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[1], town[3]));
		assertEquals(false, graph.containsEdge(town[3], town[4]));
		assertEquals(true, graph.containsEdge(town[5], town[6]));
		assertEquals(false, graph.containsEdge(town[7], town[8]));
		assertEquals(true, graph.containsEdge(town[9], town[10]));
		assertEquals(false, graph.containsEdge(town[10], town[13]));
		assertEquals(true, graph.containsEdge(town[2], town[13]));
		assertEquals(false, graph.containsEdge(town[3], town[5]));
		assertEquals(true, graph.containsEdge(town[1], town[2]));
		assertEquals(false, graph.containsEdge(town[8], town[11]));
		assertEquals(true, graph.containsEdge(town[14], town[15]));
		assertEquals(false, graph.containsEdge(town[5], town[12]));
		assertEquals(true, graph.containsEdge(town[2], town[12]));
		assertEquals(false, graph.containsEdge(town[2], town[14]));
		assertEquals(true, graph.containsEdge(town[10], town[11]));
		assertEquals(false, graph.containsEdge(town[3], town[10]));
		assertEquals(true, graph.containsEdge(town[8], town[9]));
		assertEquals(false, graph.containsEdge(town[2], town[3]));
	}

	@Test
	void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_1")));
		assertEquals(false, graph.containsVertex(new Town("Town_16")));
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(false, graph.containsVertex(new Town("Town_17")));
		assertEquals(true, graph.containsVertex(new Town("Town_3")));
		assertEquals(false, graph.containsVertex(new Town("Town_18")));
		assertEquals(true, graph.containsVertex(new Town("Town_4")));
		assertEquals(false, graph.containsVertex(new Town("Town_19")));
		assertEquals(true, graph.containsVertex(new Town("Town_5")));
		assertEquals(false, graph.containsVertex(new Town("Town_20")));
		assertEquals(true, graph.containsVertex(new Town("Town_6")));
		assertEquals(false, graph.containsVertex(new Town("Town_21")));
		assertEquals(true, graph.containsVertex(new Town("Town_7")));
		assertEquals(false, graph.containsVertex(new Town("Town_22")));
	}

	@Test
	void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_10", roadArrayList.get(1));
		assertEquals("Road_11", roadArrayList.get(2));
		assertEquals("Road_12", roadArrayList.get(3));
		assertEquals("Road_13", roadArrayList.get(4));
		assertEquals("Road_14", roadArrayList.get(5));
		assertEquals("Road_15", roadArrayList.get(6));
		assertEquals("Road_16", roadArrayList.get(7));
		assertEquals("Road_17", roadArrayList.get(8));
		assertEquals("Road_18", roadArrayList.get(9));
		assertEquals("Road_19", roadArrayList.get(10));
		assertEquals("Road_2", roadArrayList.get(11));
		assertEquals("Road_20", roadArrayList.get(12));
		assertEquals("Road_21", roadArrayList.get(13));
		assertEquals("Road_22", roadArrayList.get(14));
		assertEquals("Road_23", roadArrayList.get(15));
		assertEquals("Road_24", roadArrayList.get(16));
		assertEquals("Road_25", roadArrayList.get(17));
		assertEquals("Road_3", roadArrayList.get(18));
		assertEquals("Road_4", roadArrayList.get(19));
		assertEquals("Road_5", roadArrayList.get(20));
		assertEquals("Road_6", roadArrayList.get(21));
		assertEquals("Road_7", roadArrayList.get(22));
		assertEquals("Road_8", roadArrayList.get(23));
		assertEquals("Road_9", roadArrayList.get(24));
	}

	@Test
	void testEdgesOf() {
		Set<Road> roads1 = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList1 = new ArrayList<String>();
		for(Road road : roads1)
			roadArrayList1.add(road.getName());
		Collections.sort(roadArrayList1);
		assertEquals("Road_1", roadArrayList1.get(0));
		assertEquals("Road_24", roadArrayList1.get(1));
		assertEquals("Road_25", roadArrayList1.get(2));
		Set<Road> roads2 = graph.edgesOf(town[11]);
		ArrayList<String> roadArrayList2 = new ArrayList<String>();
		for(Road road : roads2)
			roadArrayList2.add(road.getName());
		Collections.sort(roadArrayList2);
		assertEquals("Road_11", roadArrayList2.get(0));
		assertEquals("Road_13", roadArrayList2.get(1));
		assertEquals("Road_2", roadArrayList2.get(2));
		assertEquals("Road_4", roadArrayList2.get(3));
		assertEquals("Road_9", roadArrayList2.get(4));
		Set<Road> roads3 = graph.edgesOf(town[7]);
		ArrayList<String> roadArrayList3 = new ArrayList<String>();
		for(Road road : roads3)
			roadArrayList3.add(road.getName());
		Collections.sort(roadArrayList3);
		assertEquals("Road_19", roadArrayList3.get(0));
	}

	@Test
	void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[4], town[5]));
		graph.removeEdge(town[4], town[5], 2, "Road_20");
		assertEquals(false, graph.containsEdge(town[4], town[5]));
		assertEquals(true, graph.containsEdge(town[6], town[7]));
		graph.removeEdge(town[6], town[7], 5, "Road_19");
		assertEquals(false, graph.containsEdge(town[6], town[7]));
		assertEquals(true, graph.containsEdge(town[12], town[13]));
		graph.removeEdge(town[12], town[13], 7, "Road_15");
		assertEquals(false, graph.containsEdge(town[12], town[13]));
		assertEquals(true, graph.containsEdge(town[1], town[14]));
		graph.removeEdge(town[1], town[14], 9, "Road_25");
		assertEquals(false, graph.containsEdge(town[1], town[14]));
		assertEquals(true, graph.containsEdge(town[10], town[15]));
		graph.removeEdge(town[10], town[15], 2, "Road_17");
		assertEquals(false, graph.containsEdge(town[10], town[15]));
	}

	@Test
	void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[1]));
		graph.removeVertex(town[1]);
		assertEquals(false, graph.containsVertex(town[1]));
		assertEquals(true, graph.containsVertex(town[7]));
		graph.removeVertex(town[7]);
		assertEquals(false, graph.containsVertex(town[7]));
		assertEquals(true, graph.containsVertex(town[8]));
		graph.removeVertex(town[8]);
		assertEquals(false, graph.containsVertex(town[8]));
		assertEquals(true, graph.containsVertex(town[15]));
		graph.removeVertex(town[15]);
		assertEquals(false, graph.containsVertex(town[15]));
		assertEquals(true, graph.containsVertex(town[12]));
		graph.removeVertex(town[12]);
		assertEquals(false, graph.containsVertex(town[12]));
	}

	@Test
	void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[10]));
		assertEquals(true, roads.contains(town[11]));
		assertEquals(true, roads.contains(town[12]));
		assertEquals(true, roads.contains(town[13]));
		assertEquals(true,roads.contains(town[14]));
		assertEquals(true, roads.contains(town[15]));
		assertEquals(true, roads.contains(town[2]));
		assertEquals(true, roads.contains(town[3]));
		assertEquals(true, roads.contains(town[4]));
		assertEquals(true,roads.contains(town[5]));
		assertEquals(true, roads.contains(town[6]));
		assertEquals(true, roads.contains(town[7]));
		assertEquals(true, roads.contains(town[8]));
		assertEquals(true, roads.contains(town[9]));
	}

	@Test
	void testShortestPath() {
		String beginTown = "Town_1", endTown = "Town_7";
		Town beginIndex=null, endIndex=null;
		Set<Town> towns = graph.vertexSet();
		Iterator<Town> iterator = towns.iterator();
		while(iterator.hasNext())
		{    	
			Town town = iterator.next();
			if(town.getName().equals(beginTown))
				beginIndex = town;
			if(town.getName().equals(endTown))
				endIndex = town;		
		}
		if(beginIndex != null && endIndex != null)
		{
			ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			assertNotNull(path);
			assertTrue(path.size() > 0);
			assertEquals("Town_1 via Road_1 to Town_3 7 mi",path.get(0).trim());
			assertEquals("Town_3 via Road_12 to Town_12 4 mi",path.get(1).trim());
			assertEquals("Town_12 via Road_18 to Town_10 3 mi",path.get(2).trim());
			assertEquals("Town_10 via Road_23 to Town_5 1 mi",path.get(3).trim());
			assertEquals("Town_5 via Road_21 to Town_6 1 mi",path.get(4).trim());
			assertEquals("Town_6 via Road_19 to Town_7 5 mi",path.get(5).trim());
		}
		else
			fail("Town names are not valid");
	}

	@Test
	void testDijkstraShortestPath() {
		String beginTown = "Town_1", endTown = "Town_10";
		Town beginIndex=null, endIndex=null;
		Set<Town> towns = graph.vertexSet();
		Iterator<Town> iterator = towns.iterator();
		while(iterator.hasNext())
		{    	
			Town town = iterator.next();
			if(town.getName().equals(beginTown))
				beginIndex = town;
			if(town.getName().equals(endTown))
				endIndex = town;		
		}
		if(beginIndex != null && endIndex != null)
		{
			ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			assertNotNull(path);
			assertTrue(path.size() > 0);
			assertEquals("Town_1 via Road_1 to Town_3 7 mi",path.get(0).trim());
			assertEquals("Town_3 via Road_12 to Town_12 4 mi",path.get(1).trim());
			assertEquals("Town_12 via Road_18 to Town_10 3 mi",path.get(2).trim());
		}
		else
			fail("Town names are not valid");
	}

}
