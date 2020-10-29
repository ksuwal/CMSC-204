
public class StackOverflowException extends RuntimeException {
    
    /**
     * Exception when a push method is called on a full stack.
     */
    public StackOverflowException() {
        super("The Stack is full");
    }
}