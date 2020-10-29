/**
 * Exception when the password is valid but has less than 10 characters.
 */

public class WeakPasswordException extends Exception{
	public WeakPasswordException() {
		
		super("The password is OK but weak - it contains fewer than 10 characters. Please try again.");
	}

}