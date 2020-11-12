import java.io.IOException;
import java.util.LinkedList;

/**
 * 
 * @author Kabindra Raj Suwal
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	private int size;
	LinkedList<CourseDBElement>[] hTable;
	
	
	/** 
	 * constructor to set up hash table
	 *  @param number of course (size of the hash table)
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int numberofcourses) {
		size = numberofcourses;
		hTable = new LinkedList[size];
	}

	
	/** 
	 *  constructor for temporary test
	 *  @param check 
	 *  @param numberofcourses 
	 */
	public CourseDBStructure(String check, int numberofcourses) {
		this(numberofcourses);
	}
	
	
	/**
	 * to get the size of the table
	 *  @return size
	 */
	@Override
	public int getTableSize() {
		return size;
	}

	
	/**
	 *  to add element in the structure
	 *  @param dbe 
	 */
	@Override
	public void add(CourseDBElement dbe) {
		 int hCode = dbe.hashCode();
	        int index = hCode%hTable.length;

	        if (hTable[index] == null)
	        {
	            hTable[index] = new LinkedList<CourseDBElement>();
	            hTable[index].add(dbe);
	        }

	        else if (hTable[index] != null)
	        {
	            hTable[index].add(dbe);
	        }
	}

	
	/** 
	 *  to get an element of a CRN number
	 *  @param crnNo 
	 *  @return The element with the crnNo
	 */
	@Override
	public CourseDBElement get(int crnNo) throws IOException {
		CourseDBElement e = null;
		
		for (LinkedList<CourseDBElement> list : hTable)
			if (list != null)
				for (CourseDBElement listElement : list)
					if (listElement.compareTo(new CourseDBElement("", crnNo, 0, "", "")) == 0)
						e = listElement;
		
		if (e == null)
			throw new IOException("Couldn't find " + crnNo);
		
		return e;
	}

	

}
