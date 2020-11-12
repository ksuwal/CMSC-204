import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author Kabindra Raj Suwal
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure dbs;
	
	
	public CourseDBManager() {
		dbs = new CourseDBStructure(500);
	}
	
	
	/** 
	 * to add element in the structure
	 *  @param courseId 
	 *  @param crnNo 
	 *  @param credits 
	 *  @param roomNo
	 *  @param instr 
	 */
	@Override
	public void add(String courseId, int crnNo, int credits, String roomNo, String instr) {
		dbs.add(new CourseDBElement(courseId, crnNo, credits, roomNo, instr));
	}
	

	/** 
	 *  to get an element from the structure
	 *  @param crnNo of the element 
	 *  @return the element with the crnNo 
	 */
	@Override
	public CourseDBElement get(int crnNo) {
		CourseDBElement dbe = new CourseDBElement("", 0, 0, "", "");
		try {
			dbe = dbs.get(crnNo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dbe;
		
		
	}

	/** 
	 *  adds elements from a file
	 *  @param  file to read
	 */
	@Override
	public void readFile(File entry) throws FileNotFoundException {
		String courseId = "";
		String strCrnNo = "";
		String strCredits = "";
		String instr = "";
		String roomNo = "";
		int crnNo = 0;
		int credits = 0;

		Scanner scan = new Scanner(entry);
		while (scan.hasNext()) {
			if (scan.hasNext()) {
				courseId = scan.next();
			}

			if (scan.hasNext()) {
				strCrnNo = scan.next();
			}
			crnNo = Integer.parseInt(strCrnNo);

			if (scan.hasNext()) {
				strCredits = scan.next();
			}
			credits = Integer.parseInt(strCredits);

			if (scan.hasNext()) {
				roomNo = scan.next();
			}
			if (scan.hasNext()) {
				instr = scan.nextLine();
			}
			add(courseId, crnNo, credits, roomNo, instr);
		}
		scan.close();
	}

	
	/** 
	 * to get element data
	 *  @return array of data of the structure
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> d = new ArrayList<>();
		
		for (LinkedList<CourseDBElement> list : dbs.hTable)
			if (list != null)
				for (CourseDBElement listElement : list)
					d.add("\n" + listElement.toString());
		
		return d;
	}

}
