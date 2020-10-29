/**
 * Exception when the password has same characters more than twice in a row
 */

public class InvalidSequenceException extends Exception{
	public InvalidSequenceException() {
		
		super("The password cannot contain more than two of the same character in sequence");
	}

}