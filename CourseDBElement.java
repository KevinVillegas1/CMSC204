/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a CourseDBElement class that implements the Comparable Interface.
 * Due: 04/03/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class CourseDBElement implements Comparable<CourseDBElement>{
	private String id, roomNum, instructor;
	private int crn, credits;
	/**
	 * Constructor for CourseDBElement
	 * @param id - id of the course
	 * @param crn - crn of the course
	 * @param credits - number of credits for the course
	 * @param roomNum - room number of the course
	 * @param instructor - instructor of the course
	 */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor)
	{
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	/**
	 * set method for id
	 * @param id - id of the course
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	/**
	 * set method for crn
	 * @param crn - crn of the course
	 */
	public void setCrn(int crn)
	{
		this.crn = crn;
	}
	/**
	 * set method for credits
	 * @param credits - number of credits for the course
	 */
	public void setCredits(int credits)
	{
		this.credits = credits;
	}
	/**
	 * set method for roomNum
	 * @param roomNum - room number of the course
	 */
	public void setRoomNum(String roomNum)
	{
		this.roomNum = roomNum;
	}
	/**
	 * set method for instructor
	 * @param instructor - instructor of the course
	 */
	public void setInstructor(String instructor)
	{
		this.instructor = instructor;
	}
	/**
	 * get method for id
	 * @return the id
	 */
	public String getID()
	{
		return this.id;
	}
	/**
	 * get method for crn
	 * @return the crn
	 */
	public int getCRN()
	{
		return this.crn;
	}
	/**
	 * get method for credits
	 * @return the number of credits
	 */
	public int getCredits()
	{
		return this.credits;
	}
	/**
	 * get method for roomNum
	 * @return the room number
	 */
	public String getRoomNum()
	{
		return this.roomNum;
	}
	/**
	 * get method for instructor
	 * @return the instructor name
	 */
	public String getInstructor()
	{
		return this.instructor;
	}
	/**
	 * Returns the hash code of the crn after parsed to a string
	 * @return the hash code of the parsed crn
	 */
	@Override
	public int hashCode()
	{
		String parsedCrn = String.valueOf(this.crn);
		return parsedCrn.hashCode();
	}
	/**
	 * CompareTo method to compare CourseDBElement objects' crn number
	 * @param other - other CourseDBElement object to compare crn with
	 * @return 0 if the crn of the two CourseDBElement objects are the same, 
	 * 1 if this object's crn is greater than the argument object's crn, 
	 * or -1 if this object's crn is less than the argument object's crn
	 */
	@Override
	public int compareTo(CourseDBElement other) {
		return ((Integer)this.crn).compareTo(other.crn);
	}
}
