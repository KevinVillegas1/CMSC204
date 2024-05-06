import java.util.ArrayList;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Town class that implements the Comparable interface.
 * Due: 05/05/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class Town implements Comparable<Town>{
	private String name;
	private ArrayList<Town> listOfAdjacentTowns;
	/**
	 * Constructor. Requires town's name.
	 * @param name - town's name
	 */
	public Town(String name)
	{
		this.name = name;
		this.listOfAdjacentTowns = new ArrayList<Town>();
	}
	/**
	 * Copy constructor.
	 * @param templateTown - an instance of Town
	 */
	public Town(Town templateTown)
	{
		this.name = templateTown.getName();
		this.listOfAdjacentTowns = new ArrayList<Town>();
		for(int i = 0; i < templateTown.getListOfAdjacentTowns().size(); i++)
		{
			this.listOfAdjacentTowns.set(i, templateTown.getListOfAdjacentTowns().get(i));
		}
	}
	/**
	 * Returns the town's name
	 * @return name - town's name
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * adds a town to the list of adjacent towns
	 * @param town - a town that is to be added to the list of adjacent towns
	 */
	public void addToListOfAdjacentTowns(Town town)
	{
		this.listOfAdjacentTowns.add(town);
	}
	/**
	 * removes a town from the list of adjacent towns
	 * @param town - a town that is to be removed from the list of adjacent towns
	 */
	public void removeFromListOfAdjacentTowns(Town town)
	{
		this.listOfAdjacentTowns.remove(town);
	}
	/**
	 * Returns the list of adjacent towns
	 * @return the list of adjacent towns
	 */
	public ArrayList<Town> getListOfAdjacentTowns()
	{
		return this.listOfAdjacentTowns;
	}
	/**
	 * Compare to method
	 * @param o - other Town object to compare name with
	 * @return 0 if names are equal, a positive or negative number if the names are not equal
	 */
	@Override
	public int compareTo(Town o)
	{
		return this.name.compareTo(o.name);
	}
	/**
	 * To string method
	 * @return the town name
	 */
	@Override
	public String toString()
	{
		return this.name;
	}
	/**
	 * Returns the hash code of the town's name
	 * @return the hashcode for the name of the town
	 */
	@Override
	public int hashCode()
	{
		return this.name.hashCode();
	}
	/**
	 * equals method
	 * @param obj - town object to compare it to
	 * @return true if the town names are equal, false if not
	 */
	@Override
	public boolean equals(Object obj)
	{
		Town temp = (Town) obj;
		if (this.name.equals(temp.name))
			return true;
		return false;
	}
}
