/**
 * Exception when password has less than 6 characters
 */

public class LengthException extends Exception{
	public LengthException() {
		
		super("The password must be at least 6 characters long");
	}

}