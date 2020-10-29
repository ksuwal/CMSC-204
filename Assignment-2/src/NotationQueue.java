/**
 * @author Kabindra Raj Suwal
 */
import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface{

	private int maximum;
	private ArrayList<T> queue;

	public NotationQueue(){
		maximum = 100;
		queue= new ArrayList<T>();
	}

	public NotationQueue(int size){
		maximum = size;
		queue= new ArrayList<T>();
	}

	public NotationQueue(ArrayList<T> array){
		maximum = 100;
		queue= new ArrayList<T>();

		for(T o:array) {
			queue.add(o);
		}
	}



	/**
	 * @return true if Queue is empty
	 */
	public boolean isEmpty() {
		if(queue.size()==0)
			return true;
		return false;
	}

	/**
	 * @return true if Queue is full
	 */
	public boolean isFull() {
		if(queue.size()==maximum)
			return true;
		return false;
	}

	/**
	 * removes the element at front
	 * @return element at front of Queue
	 */
	public T dequeue() throws QueueUnderflowException {
		if(queue.size()==0)
			throw new QueueUnderflowException();
		T toReturn = queue.remove(0);
		return toReturn;
	}

	/**
	 * @return number of elements in Queue
	 */
	public int size() {
		return queue.size();
	}

	/**
	 * add element to the end
	 * @param a 
	 * @return true if add was successful
	 */
	public boolean enqueue(Object a) throws QueueOverflowException {
		if(queue.size()==maximum)
			throw new QueueOverflowException();
		queue.add(queue.size(), (T) a);
		return true;
	}



	/**
	 * @return string of elements of Queue 
	 */
	public String toString() {
		String string = "";
		for(T s: queue)
			string+=s+"";

		return string;
	}

	/**
	 * @return string of elements of Queue separated with delimiter
	 */
	public String toString(String delimiter) {
		String string = "";
		for(T s: queue)
		string+=s+""+delimiter;
		string = string.substring(0,string.length()-1);
		return string;
	}

	@Override
	public void fill(ArrayList list) {
		// TODO Auto-generated method stub
		
	}

}