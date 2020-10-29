/**
 * Exception when the password has no special character
 */

public class NoSpecialCharacterException extends Exception{
	public NoSpecialCharacterException() {
		
		super("The password must contain at least one special character");
	}

}