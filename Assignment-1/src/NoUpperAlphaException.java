/**
 * Exception when the password has no upper case alphabet
 */

public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		
		super("The password must contain at least one uppercase alphabetic character");
	}

}