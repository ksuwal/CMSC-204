
public class QueueOverflowException extends RuntimeException {
    
    /**
     * Exception when a enqueue method is called on a full queue.
     */
    public QueueOverflowException() {
        super("The Queue is full");
    }
}