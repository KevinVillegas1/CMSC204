import java.util.ArrayList;
import java.util.Collections;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a TownGraphManager class that implements the TownGraphManagerInterface.
 * Due: 05/05/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class TownGraphManager implements TownGraphManagerInterface{
	Graph graph;
	/**
	 * Constructor for TownGraphManager
	 */
	public TownGraphManager()
	{
		this.graph = new Graph();
	}
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName)
	{
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		this.graph.addVertex(t1);
		this.graph.addVertex(t2);
		Road result = this.graph.addEdge(t1, t2, weight, roadName);
		if (result != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2)
	{
		if (containsRoadConnection(town1, town2) == true)
		{
			for (Road road : this.graph.edgeSet())
			{
				if ((road.getSource().getName().equals(town1) && road.getDestination().getName().equals(town2)) || (road.getSource().getName().equals(town2) && road.getDestination().getName().equals(town1)))
				{
					return road.getName();
				}
			}
		}
		return null;
	}
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v)
	{
		Town town = new Town(v);
		boolean result = this.graph.addVertex(town);
		if (result == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name)
	{
		if (containsTown(name) == true)
		{
			for (Town town : this.graph.vertexSet())
			{
				if (town.getName().equals(name))
				{
					return town;
				}
			}
		}
		return null;
	}
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v)
	{
		for (Town town : this.graph.vertexSet())
		{
			if (town.getName().equals(v))
			{
				if (this.graph.containsVertex(town))
				{
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2)
	{
		for (Road road : this.graph.edgeSet())
		{
			if ((road.getSource().getName().equals(town1) && road.getDestination().getName().equals(town2)) || (road.getSource().getName().equals(town2) && road.getDestination().getName().equals(town1)))
			{
				if ((this.graph.containsEdge(road.getSource(), road.getDestination())) || (this.graph.containsEdge(road.getDestination(), road.getSource())))
				{
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads()
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		for (Road road : this.graph.edgeSet())
		{
			arrayList.add(road.getName());
		}
		Collections.sort(arrayList);
		return arrayList;
	}
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road)
	{
		if (getRoad(town1, town2) != road)
		{
			return false;
		}
		else if ((getTown(town1).getName() != town1) || (getTown(town2).getName() != town2))
		{
			return false;
		}
		else
		{
			Road r = this.graph.removeEdge(getTown(town1), getTown(town2), this.graph.getEdge(getTown(town1), getTown(town2)).getWeight(), this.graph.getEdge(getTown(town1), getTown(town2)).getName());
			if (r != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v)
	{
		if (getTown(v).getName() != v)
		{
			return false;
		}
		else
		{
			boolean result = this.graph.removeVertex(getTown(v));
			if (result == true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns()
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		for (Town town : this.graph.vertexSet())
		{
			arrayList.add(town.getName());
		}
		Collections.sort(arrayList);
		return arrayList;
	}
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2)
	{
		if (town1 == null || town2 == null)
		{
			return null;
		}
		Town source = new Town(town1);
		Town destination = new Town(town2);
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList = this.graph.shortestPath(source, destination);
		return arrayList;
	}
}
