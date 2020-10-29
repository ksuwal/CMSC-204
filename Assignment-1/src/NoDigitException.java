/**
 * Exception when the password has no numeric digit
 */

public class NoDigitException extends Exception {
	public NoDigitException() {
		
		super("The password must contain at least one digit");
	}

}