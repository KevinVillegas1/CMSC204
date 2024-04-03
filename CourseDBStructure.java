import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a CourseDBStructure class that implements the CourseDBStructureInterface.
 * Due: 04/03/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class CourseDBStructure implements CourseDBStructureInterface{
	private int tableSize;
	private final double loadingFactor = 1.5;
	private LinkedList<CourseDBElement>[] hashTable;
	/**
	 * Constructor for CourseDBElement, takes in an integer n which represents the estimated number of courses
	 * and determines the size of the hash table by finding a 4K+3 prime just greater than n/loading factor
	 * @param n - estimated number of courses
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int n)
	{
		boolean fkp3 = false;
		boolean aPrime = false;
		int prime, highDivisor, d;
		prime = (int)(n/this.loadingFactor);
		if(prime % 2 == 0)// if even make odd
		{
			prime = prime +1;
		}
		while(fkp3 == false)// not a 4k+3 prime
		{
			while(aPrime == false)//not a prime
			{
				highDivisor = (int)(Math.sqrt(prime) + 0.5);
				for(d = highDivisor; d > 1; d--)
				{
					if(prime % d == 0)
					{
						break;
					}
				}
				if(d != 1)//prime not found
				{
					prime = prime + 2;
				}
				else
				{
					aPrime = true;
				}
			}// end of the prime search loop
			if((prime - 3) % 4 == 0)
			{
				fkp3 = true;
			}
			else
			{
				prime = prime + 2;
				aPrime = false;
			}
		}// end of 4k+3 prime search loop
		this.tableSize = prime;
		this.hashTable = new LinkedList[this.tableSize];
	}
	/**
	 * Constructor for CourseDBElement, for testing purposes
	 * @param testing - String "Testing" for testing purposes
	 * @param size - the size of the hash table
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int size)
	{
		this.tableSize = size;
		this.hashTable = new LinkedList[size];
	}
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElement object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element)
	{
		int hashCodeIndex = (Math.abs(element.hashCode()) % this.tableSize);
		if (this.hashTable[hashCodeIndex] == null)
		{
			this.hashTable[hashCodeIndex] = new LinkedList<CourseDBElement>();
			this.hashTable[hashCodeIndex].addFirst(element);
		}
		else if(this.hashTable[hashCodeIndex].contains(element))
		{
			return;
		}
		else if(this.hashTable[hashCodeIndex] != null)
		{
			for(int linkedListIndex = 0; linkedListIndex < this.hashTable[hashCodeIndex].size(); linkedListIndex++)
			{
				if(element.compareTo(this.hashTable[hashCodeIndex].get(linkedListIndex)) == 0)
				{
					this.hashTable[hashCodeIndex].set(linkedListIndex, element);
				}
			}
		}
		else
		{
			this.hashTable[hashCodeIndex].addLast(element);
		}
	}
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException
	{
		String parsedCrn = String.valueOf(crn);
		int hashCodeIndex = (Math.abs(parsedCrn.hashCode()) % this.tableSize);
		if(this.hashTable[hashCodeIndex] == null)
		{
			throw new IOException();
		}
		else
		{
			if (this.hashTable[hashCodeIndex] != null)
			{
				for(int linkedListIndex = 0; linkedListIndex < this.hashTable[hashCodeIndex].size(); linkedListIndex++)
				{
					if(crn == this.hashTable[hashCodeIndex].get(linkedListIndex).getCRN())
					{
						return this.hashTable[hashCodeIndex].get(linkedListIndex);
					}
				}
			}
			throw new IOException();
		}
	}
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll()
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		for(int arrayIndex = 0; arrayIndex < this.tableSize; arrayIndex++)
		{
			if (this.hashTable[arrayIndex] != null)
			{
				for(int linkedListIndex = 0; linkedListIndex < this.hashTable[arrayIndex].size(); linkedListIndex++)
				{
					arrayList.add("\n" + "Course:" + this.hashTable[arrayIndex].get(linkedListIndex).getID() + " CRN:" + this.hashTable[arrayIndex].get(linkedListIndex).getCRN() + 
							" Credits:" + this.hashTable[arrayIndex].get(linkedListIndex).getCredits() + " Instructor:" + this.hashTable[arrayIndex].get(linkedListIndex).getInstructor() + 
							" Room:" + this.hashTable[arrayIndex].get(linkedListIndex).getRoomNum());
				}
			}
		}
		return arrayList;
	}
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize()
	{
		return this.tableSize;
	}
}
