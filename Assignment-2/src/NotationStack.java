/**
 * @author Kabindra Raj Suwal
 */
import java.util.ArrayList;


public class NotationStack<T> implements StackInterface{


	private ArrayList<T> stack;
	private int maximum;

	public NotationStack(){
		maximum = 100;
		stack = new ArrayList<T>();
	}


	public NotationStack(int s){
		maximum = s;
		stack = new ArrayList<T>();
	}

	public NotationStack(ArrayList<T> array){
		maximum = 100;
		stack= new ArrayList<T>();

		for(int i = array.size()-1; i>=0;i--) {
			stack.add(array.get(i));
		}
	}

	/**
	 * 
	 * @return true if Stack is empty 
	 */
	public boolean isEmpty() {
		if(stack.size()==0)
			return true;
		return false;
	}

	/**
	 * @return true if Stack is full
	 */
	public boolean isFull() {
		if(stack.size()==maximum)
			return true;
		return false;
	}

	/**
	 * removes the top element
	 * @return element at top of Stack
	 */
	public T pop() throws StackUnderflowException {
		if(stack.size()==0)
			throw new StackUnderflowException();
		T toReturn = stack.remove(0);
		return toReturn;
	}

	/**
	 * gets the top element
	 * @return element at top of Stack
	 */
	public T top() throws StackUnderflowException {
		if(stack.size()==0)
			throw new StackUnderflowException();
		return stack.get(0);
	}

	/**
	 * @return number of elements in Stack
	 */
	public int size() {

		return stack.size();
	}

	/**
	 * add element on top of stack
	 * @return true if add successful
	 */
	public boolean push(Object o) throws StackOverflowException {
		if(stack.size()==maximum)
			throw new StackOverflowException();
		stack.add(0, (T) o);
		return true;
	}

	/**
	 * 
	 * @return string of elements in stack from bottom to top
	 */
	public String toString() {
		String toReturn = "";
		for(int i = stack.size()-1; i>=0;i--) 
			toReturn+=stack.get(i)+"";

		return toReturn;
	}


	/**
	 * @return string of elements in stack from bottom to top separated with delimiter
	 */
	public String toString(String delimiter) {
		String toReturn = "";
		for(int i = stack.size()-1; i>=0;i--) 
			toReturn+=stack.get(i)+""+delimiter;
		toReturn = toReturn.substring(0,toReturn.length()-1);
		return toReturn;


	}
}