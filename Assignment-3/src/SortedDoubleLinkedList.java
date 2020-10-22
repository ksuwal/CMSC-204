import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Kabindra Raj Suwal
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
   
    protected Comparator<T> c = null;
        
    public SortedDoubleLinkedList(Comparator<T> c) {
       this.c = c;
    }
    
    /**
     * 
     * @param element
     * @return
     */
    public SortedDoubleLinkedList<T> add(T element) {
        Node n = new Node(element);
        
        if (size == 0) {
        	
            head = tail = n;
        } else if (c.compare(head.element, element) > 0) {
        	
            head.prev = n;
            n.next = head;
            head = n;
        } else if (c.compare(tail.element, element) < 0) {
        	
            tail.next = n;
            n.prev = tail;
            tail = n;
        } else {
        	
            Node search = head;
            while (search != null) {
            	
                if (c.compare(search.element, element) <= 0) {
                	
                    Node before = search;
                    Node after = search.next;
                    after.prev = before.next = n;
                    n.next = after;
                    n.prev = before;   
                }
                search = search.next;
            }
        }
        
        size++;
        return this;
    }
      
    @Override
    public BasicDoubleLinkedList<T> addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list"); 
    }
    
    @Override
    public BasicDoubleLinkedList<T> addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        return super.iterator();
    }

    @Override
    public SortedDoubleLinkedList<T> remove(T rdata, Comparator<T> c) {
        super.remove(rdata, c);
        return this;
    }
    
}