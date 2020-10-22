import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Kabindra Raj Suwal
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

    protected Node head;
    protected Node tail;
    int size; 

    public BasicDoubleLinkedList() {

        head = null;
        tail = null;
        size = 0;
    }


    /**
     * 
     * @return size 
     */
    public int getSize() {
        return size;
    }


    /**
     * Adds an element to the end of the list
     * @param element - element for node in the list
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToEnd(T element) {
    	if (tail == null) {
        	
            tail = new Node(element);
            head = tail;
        } else {
        	
            Node newNode = new Node(element);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return this;
    }

    /**
     * Adds element to the front of the list
     * @param element - element for node in the list
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToFront(T element) {
    	 if (head == null) {
             head = new Node(element);
             tail = head;
         } else {
         	
             Node newNode = new Node(element);
             head.prev = newNode;
             newNode.next = head;
             head = newNode;
         }
         size++;
         return this;
    }

    
    
    /**
     * Returns but does not remove the first element from the list.
     * @return the data element or null
     */
    public T getFirst() {

        return head.element;
    }

    
    
    /**
     * Returns but does not remove the last element from the list.
     * @return the data element or null
     */
    public T getLast() {

        return tail.element;
    }
    


    /**
     * @param rData - the data element to be removed
     * @param c - the comparator to determine equality of data elements
     * @return data element or null
     */
    public BasicDoubleLinkedList<T> remove(T rData, java.util.Comparator<T> c) {
    	Node tNode = head;
        while(tNode != null) {
            if (c.compare(tNode.element, rData) == 0) {
            	
                if (tNode == head) {
                    if (head.next != null) {
                    	
                        head = head.next;
                        head.prev = null;
                    } else {
                    	
                        head = tail = null;
                    }
                } else if (tNode == tail) {
                	
                    if (tail.prev != null) {
                    	
                        tail = tail.prev;
                        tail.next = null;
                    } else {
                    	
                        head = tail = null;
                    }
                } else {
                	
                    tNode.prev.next = tNode.next;
                    tNode.next.prev = tNode.prev;
                }
                break;
            }
            tNode = tNode.next;
        }
        size--;
        return this;
    }

    /**
     * Removes and returns the first element from the list.
     * @return data element or null
     */
    public T retrieveFirstElement() {
    	if (head != null) {
        	
            Node first = head;
            if (head.next != null) {
            	
                head = head.next;
                head.prev = null;
            } else {
            	
                head = tail = null;
            }
            return first.element;
        } else {
        	
            return null;
        }
        
    }


    /**
     * Removes and returns the last element from the list
     * @return data element or null
     */
    public T retrieveLastElement() {
    	if (tail != null) {
        	
            Node end = tail;
            if (tail.prev != null) {
            	
                tail = tail.prev;
                tail.next = null;
            } else {
            	
                head = tail = null;
            }
            return end.element;
        } else {
        	
            return null;
        }
    }

    /**
     * @return an arraylist of the items in the list
     */
    public ArrayList<T> toArrayList() {
    	
        ArrayList<T> list = new ArrayList<>();
        Node n = head;
        
        while(n != null) {
        	
            list.add(n.element);
            n = n.next;
        }
        return list;    
    }

    
    
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        return new Iterrator();
    }

    /**
     * Node inner class
     */
    protected class Node {

        T element;
        Node next;
        Node prev;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node nextNode, Node prevNode) {
            this.element = data;
            this.next = nextNode;
            this.prev = prevNode;
        }
    }


    private class Iterrator implements ListIterator<T> {

        private Node next;
        private Node prev;

        public Iterrator() {
            this.next = head;
            this.prev = null;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
            	prev = next;
                next = prev.next;
                return prev.element;
            } else
                throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return prev != null;
        }

        @Override
        public T previous() {
            if (hasPrevious()) {
            	next = prev;
                prev = next.prev;
                return next.element; 
            } else
                throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }
    }

}