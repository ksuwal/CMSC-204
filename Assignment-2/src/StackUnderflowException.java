
public class StackUnderflowException extends RuntimeException {
    
    /**
     * Exception when a pop method is called on an empty stack.
     */
    public StackUnderflowException() {
        super("The Stack is empty");
    }
}