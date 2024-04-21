import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a MorseCodeConverter class.
 * Due: 04/20/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class MorseCodeConverter {
	static MorseCodeTree<String> tree = new MorseCodeTree<String>();
	/**
	 * Constructor for MorseCodeConverter
	 */
	public MorseCodeConverter()
	{
		
	}
	/**
	 * Returns a string with all the data in the tree in LNR order with an space in between them.
	 * Uses the toArrayList method in MorseCodeTree
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree()
	{
		ArrayList<String> arrayList = tree.toArrayList();
		StringBuilder string = new StringBuilder();
		for (int index = 0; index < arrayList.size(); index++)
		{
			string.append(arrayList.get(index));
			if (index < arrayList.size() - 1)
			{
				string.append(" ");
			}
		}
		return string.toString();
	}
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param code - the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code)
	{
		if (code == null || code.equals(""))
		{
			return "";
		}
		StringBuilder string = new StringBuilder();
		String[] words = code.split(" / ");
		for (String w : words)
		{
			String[] letters = w.split(" ");
			for (String s : letters)
			{
				String newLetter = tree.fetch(s);
				string.append(newLetter);
			}
			string.append(" ");
		}
		return string.toString().trim();
	}
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param codeFile - name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		String line, output = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(codeFile));
			int lineCounter = 0;
			while((line = reader.readLine()) != null)
			{
				lineCounter++;
				if(lineCounter > 1)
				{
					output += "\n" + convertToEnglish(line);
				}
				else
				{
					output = convertToEnglish(line);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
}
