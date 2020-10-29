
public class QueueUnderflowException extends RuntimeException {
    
    /**
     * Exception when a dequeue method is called on an empty queue.
     */
    public QueueUnderflowException() {
        super("The Queue is empty");
    }
}