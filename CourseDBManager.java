import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a CourseDBManager class that implements the CourseDBManagerInterface.
 * Due: 04/03/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class CourseDBManager implements CourseDBManagerInterface{
	CourseDBStructure courseDBStructure;
	/**
	 * Constructor for CourseDBManager
	 */
	public CourseDBManager()
	{
		this.courseDBStructure = new CourseDBStructure(500);
	}
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor)
	{
		CourseDBElement course = new CourseDBElement(id, crn, credits, roomNum, instructor);
		this.courseDBStructure.add(course);
	}
	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn)
	{
		try {
			return this.courseDBStructure.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException
	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line;
			while((line = reader.readLine()) != null)
			{
				String[] part = line.split("\\s+", 5);
				String id = part[0];
				int crn = Integer.parseInt(part[1]);
				int credits = Integer.parseInt(part[2]);
				String roomNum = part[3];
				String instructor = part[4].trim();
				if(roomNum.equals("Distance"))
				{
					roomNum += " " + instructor.substring(0, instructor.indexOf(" "));
					instructor = instructor.substring(instructor.indexOf(" ") + 1).trim();
				}
				add(id, crn, credits, roomNum, instructor);
			}
		    reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
		return this.courseDBStructure.showAll();
	}
}
