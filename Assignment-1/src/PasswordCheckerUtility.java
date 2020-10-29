/**
 * @author Kabindra Raj Suwal 
 */

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//Class to check validity of passwords based on certain criteria

public final class PasswordCheckerUtility {
	
	/**
	 * Method to check if typed passwords are same 
	 * @param pswrd
	 * @param secondPswrd
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(java.lang.String pswrd, java.lang.String secondPswrd) throws UnmatchedException {
		if 
		(!pswrd.equals(secondPswrd)) throw new UnmatchedException();
	}
	
	
	
	/**
	 * Method to check if typed passwords are same
	 * @param pswrd
	 * @param secondPswrd
	 * @return
	 */
	public static boolean comparePasswordsWithReturn(java.lang.String pswrd, java.lang.String secondPswrd) {
		if (pswrd.equals(secondPswrd)) 
			return true;
		else 
			return false;
	}
	
	

	
	/**
	 * Method to check length of the password
	 * @param pswrd
	 * @return
	 * @throws LengthException
	 */
	public static boolean isValidLength(String pswrd) throws LengthException
	{
		if (pswrd.length()<6) 
			throw new LengthException();
		else
			return true;
	}
	
	
	
	/**
	 * Method to check upper cased alphabets in the password
	 * @param pswrd
	 * @return
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String pswrd) throws NoUpperAlphaException
	{
		if(pswrd.equals(pswrd.toLowerCase())) 
			throw new NoUpperAlphaException();
		else
			return true;		
	}
	
	
	
	/**
	 * Method to check lower cased alphabets in the password
	 * @param pswrd
	 * @return
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String pswrd) throws NoLowerAlphaException
	{

		if(pswrd.equals(pswrd.toUpperCase())) 
			throw new NoLowerAlphaException();
		else
			return true;
	}
	
	
	
	/**
	 * Method to check numerical digits in the password
	 * @param pswrd
	 * @return
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String pswrd) throws NoDigitException
	{
		boolean hasDigit = false;

		for (int i = 0 ; i < pswrd.length() ; i++) {
			if (Character.isDigit(pswrd.charAt(i)))
				hasDigit = true;
		}

		if (hasDigit==true)
			return hasDigit;
		else 
			throw new NoDigitException();
	}
	
	
	
	/**
	 * Method to check special characters in the password
	 * @param pswrd
	 * @return
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String pswrd) throws NoSpecialCharacterException
	{
		String reg="[a-zA-Z0-9]*";
		Pattern pattern=Pattern.compile(reg);
		Matcher matcher=pattern.matcher(pswrd);
		
		if(matcher.matches()) {
			throw new NoSpecialCharacterException();
		}
		else {
			return true;
		}
	}
	
	
	
	/**
	 * Method to check repeated characters in the passwords
	 * @param pswrd
	 * @return
	 * @throws InvalidSequenceException
	 */
	public static boolean hasSameCharInSequence(String pswrd) throws InvalidSequenceException
	{
		boolean isValid=true;
		for (int i=0;i<=pswrd.length()-2;i++) { 
			if(pswrd.charAt(i)==pswrd.charAt(i+1)) {
				if (pswrd.charAt(i)==pswrd.charAt(i+2)) {
					isValid=false;
					throw new InvalidSequenceException();
				}
				
			}
		}
		return isValid;
	}
	
	
	
	/**
	 * Method to check validity of passwords based on above methods
	 * @param pswrd
	 * @return
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String pswrd) 
			throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException 
	{
		if (isValidLength(pswrd)==true && hasUpperAlpha(pswrd)==true && hasLowerAlpha(pswrd)==true && hasDigit(pswrd)==true 
				&& hasSpecialChar(pswrd)==true && hasSameCharInSequence(pswrd)==true) {
			return true;
			}
			else 
				return false;
			
	}
		
	
	
	
	/**
	 * Method to check if the password length is between 6 and 9
	 * @param pswrd
	 * @return
	 */
	public static boolean hasBetweenSixAndNineChars(String pswrd)
	{
		
		if (pswrd.length()>=6 && pswrd.length()<=9) 
			return true;
		else
			return false;			
	}
	
	
	/**
	 * Method to check weakness of password
	 * @param pswrd
	 * @return
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String pswrd) throws WeakPasswordException{
		if(pswrd.length()>=6 && pswrd.length()<=9) {
			return true;
		}
		else
			return false;
	}
	
	
	
	/**
	 * Method to check for invalid passwords from file
	 * @param pswrd
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> pswrd){
		ArrayList<String>invdPswrd=new ArrayList<String>();
		String invald=null;
		for (int i=0;i<pswrd.size();i++) {	
			try {
				invald=pswrd.get(i);
				if(!isValidPassword(invald)) {
					invald=invald+"";
				}
			}
			catch(Exception e) {
				invdPswrd.add(invald+" -> "+e.getMessage());
			}
		}
		
		return invdPswrd;		
	}
	
}