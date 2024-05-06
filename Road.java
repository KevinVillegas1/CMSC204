/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Road class that implements the Comparable interface.
 * Due: 05/05/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class Road implements Comparable<Road>{
	private String name;
	private Town source, destination;
	private int distance;
	/**
	 * Constructor
	 * @param source - One town on the road
	 * @param destination - Another town on the road
	 * @param i - Weight of the edge, i.e., distance from one town to the other
	 * @param roadName - Name of the road
	 */
	public Road(Town source, Town destination, int degrees, String name)
	{
		this.source = source;
		this.destination = destination;
		this.distance = degrees;
		this.name = name;
	}
	/**
	 * Constructor with weight preset at 1
	 * @param source - One town on the road
	 * @param destination - Another town on the road
	 * @param name - Name of the road
	 */
	public Road(Town source, Town destination, String name)
	{
		this.source = source;
		this.destination = destination;
		this.distance = 1;
		this.name = name;
	}
	/**
	 * Returns true only if the edge contains the given town
	 * @param town - a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town)
	{
		if (this.source.equals(town) || this.destination.equals(town))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * To string method.
	 * @return the road name
	 */
	@Override
	public String toString()
	{
		return this.name;
	}
	/**
	 * Returns the road name
	 * @return name - The name of the road
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * Returns the second town on the road
	 * @return destination - A town on the road
	 */
	public Town getDestination()
	{
		return this.destination;
	}
	/**
	 * Returns the first town on the road
	 * @return source - A town on the road
	 */
	public Town getSource()
	{
		return this.source;
	}
	/**
	 * Compare to method
	 * @param o - other Road object to compare name with
	 * @return 0 if the road names are the same, a positive or negative number if the road names are not the same
	 */
	@Override
	public int compareTo(Road o)
	{
		return this.name.compareTo(o.name);
	}
	/**
	 * Returns the distance of the road
	 * @return distance - the distance of the road
	 */
	public int getWeight()
	{
		return this.distance;
	}
	/**
	 * equals method
	 * Returns true if each of the ends of the road r is the same as the ends of this road.
	 * @param r - road object to compare it to
	 * @return true if each of the ends of the road r is the same as the ends of this road.
	 */
	@Override
	public boolean equals(Object r)
	{
		Road temp = (Road) r;
		if (this.source.equals(temp.source) && this.destination.equals(temp.destination) || this.source.equals(temp.destination) && this.destination.equals(temp.source))
			return true;
		return false;
	}
	
}
