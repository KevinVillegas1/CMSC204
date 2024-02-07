
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Write a Junit test class that has a test method for each public method of the PasswordCheckerUtility class. 
 * It will test to make sure all the methods in the class work properly.
 * Due: 02/06/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Kevin Villegas
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	
	
	@Before
	public void setUp() throws Exception {
		String[] a = {"456375AA@", "robert3EEE#", "5Jim#", "marcus44", "october10", "b3dEj", 
				"BlueberryyyZZxx#", "ff45Cd", "driverObjective", "BBBaa#456"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(a));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength("ABCDEF"));
		} catch (LengthException e) {
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.isValidLength("abcde"));
		} catch (LengthException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("Penguin"));
		} catch (NoUpperAlphaException e) {
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.hasUpperAlpha("eagle"));
		} catch (NoUpperAlphaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("AbCD"));
		} catch (NoLowerAlphaException e) {
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.hasLowerAlpha("ABCD"));
		} catch (NoLowerAlphaException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("A@b1CD"));
		} catch (WeakPasswordException e) {
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword("B@c2DEFGHI"));
		} catch (WeakPasswordException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertFalse(PasswordCheckerUtility.NoSameCharInSequence("AAABCDE"));
		} catch (InvalidSequenceException e) {
			System.out.println(e.getMessage());
		}
		try {
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence("ABCDEFG"));
		} catch (InvalidSequenceException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit("ABC1D"));
		} catch (NoDigitException e) {
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.hasDigit("ABCDE"));
		} catch (NoDigitException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("A@b1CDE"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("cdA&8eFG"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> returnArrayList;
		returnArrayList = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(returnArrayList.size(), 10);
		assertEquals(returnArrayList.get(0), "456375AA@ The password must contain at least one lowercase alphabetic character");
		assertEquals(returnArrayList.get(1), "robert3EEE# The password cannot contain more than two of the same character in sequence.");
		assertEquals(returnArrayList.get(2), "5Jim# The password must be at least 6 characters long");
		assertEquals(returnArrayList.get(3), "marcus44 The password must contain at least one uppercase alphabetic character");
		assertEquals(returnArrayList.get(4), "october10 The password must contain at least one uppercase alphabetic character");
		assertEquals(returnArrayList.get(5), "b3dEj The password must be at least 6 characters long");
		assertEquals(returnArrayList.get(6), "BlueberryyyZZxx# The password must contain at least one digit");
		assertEquals(returnArrayList.get(7), "ff45Cd The password must contain at least one special character");
		assertEquals(returnArrayList.get(8), "driverObjective The password must contain at least one digit");
		assertEquals(returnArrayList.get(9), "BBBaa#456 The password cannot contain more than two of the same character in sequence.");
	}
	
}
