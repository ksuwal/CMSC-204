/**
 * Exception when the password has no lower case alphabet
 */

public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException() {
		
		super("The password must contain at least one lower case alphabetic character");
	}

}