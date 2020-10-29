import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Kabindra Raj Suwal
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String>pswrd;

	@Before
	public void setUp() throws Exception {
		pswrd=new ArrayList<String>();
		String [] passwords= {"He1!o12456","He1!o","HE!LO1@345","he!lo1@345","He!loWorld","He11oWorld","Helll0Wor!d"};
		pswrd.addAll(Arrays.asList(passwords));
		
	}

	@After
	public void tearDown() throws Exception {
		pswrd=null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("He!1o"));
			assertTrue(PasswordCheckerUtility.isValidPassword("He1!o12456"));
			assertTrue("No length exception",false);
		}
		catch(LengthException e) {
			assertTrue("Threw Length exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
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
			assertTrue(PasswordCheckerUtility.isValidPassword("he!l01234"));
			assertTrue(PasswordCheckerUtility.isValidPassword("He1!o12456"));
			assertTrue("Did not throw NoUpperAlpha exception",false);
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw NoUpperAlpha exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",false);
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
			assertTrue(PasswordCheckerUtility.isValidPassword("HE!1O123"));
			assertTrue(PasswordCheckerUtility.isValidPassword("He1!o12456"));
			assertTrue("Did not throw NoLowerApha exception",false);
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Threw NoLowerAlpha exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",true);
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
			assertTrue(PasswordCheckerUtility.isWeakPassword("Hel0@12"));
			}
			catch(WeakPasswordException c) {
			assertTrue("Threw weakPassword exception",true);
			}
			catch (Exception e) {
			assertTrue("Threw other exception",false);
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
			assertTrue(PasswordCheckerUtility.isValidPassword("He1!000"));
			assertTrue(PasswordCheckerUtility.isValidPassword("He1!o12456"));
			assertTrue("did not Throw InvalidSequence exception",false);
		}
		catch(InvalidSequenceException e) {
			assertTrue("Threw InvalidSequence exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",false);
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
			assertTrue(PasswordCheckerUtility.isValidPassword("He!loo"));
			assertTrue(PasswordCheckerUtility.isValidPassword("He1!o12456"));
			assertTrue("did not throw HasDigit exception",false);
		}
		catch(NoDigitException e) {
			assertTrue("Threw NoDigit exception",true);
		}
		catch (Exception e) {
			assertTrue("Threw other exception",false);
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
			PasswordCheckerUtility.isValidPassword("He!1oW0rld");
			assertTrue("did not throw an exception",true);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalids;
		invalids = PasswordCheckerUtility.getInvalidPasswords(pswrd);
		assertEquals(invalids.get(0), "He1!o -> The password must be at least 6 characters long");
		assertEquals(invalids.get(1), "HE!LO1@345 -> The password must contain at least one lower case alphabetic character");
		assertEquals(invalids.get(2), "he!lo1@345 -> The password must contain at least one uppercase alphabetic character");
		assertEquals(invalids.get(3), "He!loWorld -> The password must contain at least one digit"); 
		assertEquals(invalids.get(4), "He11oWorld -> The password must contain at least one special character"); 
		assertEquals(invalids.get(5), "Helll0Wor!d -> The password cannot contain more than two of the same character in sequence"); 
	}
	
}
