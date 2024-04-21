import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Junit test class that tests the methods of the MorseCodeConverter class.
 * Due: 04/20/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
class MorseCodeConverter_STUDENT_Test {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPrintTree() {
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}

	@Test
	void testConvertToEnglishString() {
		String converter0 = MorseCodeConverter.convertToEnglish("");
		assertEquals("",converter0);
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / . ...- . .-. -.-- --- -. .");
		assertEquals("hello everyone",converter1);
		String converter2 = MorseCodeConverter.convertToEnglish("-- -.-- / ..-. .- ...- --- .-. .. - . / -.-. --- .-.. --- .-. / .. ... / .-. . -..");
		assertEquals("my favorite color is red", converter2);
		String converter3 = MorseCodeConverter.convertToEnglish("-.-. --- -- .--. ..- - . .-. / ... -.-. .. . -. -.-. . / .. ... / -.-. --- --- .-..");
		assertEquals("computer science is cool", converter3);
		String converter4 = MorseCodeConverter.convertToEnglish("- .... .. ... / -- . ... ... .- --. . / .. ... / .. -. / -- --- .-. ... . / -.-. --- -.. .");
		assertEquals("this message is in morse code", converter4);
		String converter5 = MorseCodeConverter.convertToEnglish("-- .- .-. -.-- / .... .- -.. / .- / .-.. .. - - .-.. . / .-.. .- -- -... / .... .. ... / ..-. .-.. . . -.-. . / .-- .- ... / .-- .... .. - . / .- ... / ... -. --- .--");
		assertEquals("mary had a little lamb his fleece was white as snow", converter5);
		String converter6 = MorseCodeConverter.convertToEnglish("- .... . / .. - ... -.-- / -... .. - ... -.-- / ... .--. .. -.. . .-. / .-- . -. - / ..- .--. / - .... . / .-- .- - . .-. / ... .--. --- ..- - / -.. --- .-- -. / -.-. .- -- . / - .... . / .-. .- .. -. / .- -. -.. / .-- .- ... .... . -.. / - .... . / ... .--. .. -.. . .-. / --- ..- -");
		assertEquals("the itsy bitsy spider went up the water spout down came the rain and washed the spider out", converter6);
		String converter7 = MorseCodeConverter.convertToEnglish("- .-- .. -. -.- .-.. . / - .-- .. -. -.- .-.. . / .-.. .. - - .-.. . / ... - .- .-.");
		assertEquals("twinkle twinkle little star", converter7);
	}

	@Test
	void testConvertToEnglishFile() {
		File file1 = new File("howDoILoveThee.txt"); 
		try {
			assertEquals("how do i love thee let me count the ways", MorseCodeConverter.convertToEnglish(file1));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		File file2 = new File("Daisy.txt"); 
		try {
			assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(file2));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		File file3 = new File("DaisyDaisy.txt"); 
		try {
			assertEquals("im half crazy all for the love of you", MorseCodeConverter.convertToEnglish(file3));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		File file4 = new File("LoveLooksNot.txt"); 
		try {
			assertEquals("love looks not with the eyes but with the mind", MorseCodeConverter.convertToEnglish(file4));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		File file5 = new File("TestLine.txt"); 
		try {
			assertEquals("this is the first line\nthis is the second line\nthis is the third line", MorseCodeConverter.convertToEnglish(file5));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		File file6 = new File("TestNormal.txt"); 
		try {
			assertEquals("this is a normal test", MorseCodeConverter.convertToEnglish(file6));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}

}
