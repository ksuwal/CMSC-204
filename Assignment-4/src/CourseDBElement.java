/**
 * 
 * @author Kabindra Raj Suwal
 *
 */
public class CourseDBElement implements Comparable {

	private String courseId;
	private int crnNo;
	private int credits;
	private String roomNo;
	private String instr;
	
	
	public CourseDBElement() {
		this("", 0, 0, "", "");
	}
	
	
	/**
	 *  
	 *  @param id The ID of the course
	 *  @param crnNo the CRN Number of the course
	 *  @param credits The number of credits for the course
	 *  @param roomNo the number of the room
	 *  @param instr the instructor
	 */
	public CourseDBElement(String id, int crnNo, int credits, String roomNo, String instr) {
		this.courseId = id;
		this.crnNo = crnNo;
		this.credits = credits;
		this.roomNo = roomNo;
		this.instr = instr;
	}
	
	
	/** 
	 * to get course id
	 * @return courseId
	 */
	public String getCourseID() {
		return courseId;
	}
	
	
	/** 
	 * to set course id
	 * @param courseId
	 */
	public void setCourseID(String courseId) {
		this.courseId = courseId;
	}

	
	/** 
	 * to get crn number
	 * @return crnNo
	 */
	public int getCRN() {
		return crnNo;
	}

	
	/** 
	 * to set crn number
	 * @param crnNo
	 */
	public void setCRN(int crnNo) {
		this.crnNo = crnNo;
	}

	
	/** 
	 * to get number of credits
	 * @return credits
	 */
	public int getNumberOfCredits() {
		return credits;
	}

	
	/** 
	 * to set number of credits
	 * @param credits
	 */
	public void setNumberOfCredits(int credits) {
		this.credits = credits;
	}

	
	/** 
	 * to get room number
	 * @return roomNo
	 */
	public String getRoomNumber() {
		return roomNo;
	}

	
	/** 
	 * to set room number
	 * @param roomNo
	 */
	public void setRoomNumber(String roomNo) {
		this.roomNo = roomNo;
	}

	
	/** 
	 * to get the instructor
	 * @return instr
	 */
	public String getInstructor() {
		return instr;
	}

	
	/** 
	 * to set instructor
	 * @param instr
	 */
	public void setInstructor(String instr) {
		this.instr = instr;
	}
	
	/** 
	 * to get hash code of crn in string
	 *  @return hash code of crn
	 */
	public int hashCode() {
		String crn = Integer.toString(crnNo);
        int hashCode = crn.hashCode();
        return hashCode;
	}

	
	/**
	 * 
	 */
	@Override
	public int compareTo(CourseDBElement e) {
		return hashCode() - e.hashCode();
	}

	
	/** 
	 * 
	 * @return 
	 */
	@Override
	public String toString() {
		return "Course:" + courseId + " CRN:" + crnNo + " Credits:" + credits + " Instructor:" + instr + " Room:" + roomNo;
	}
}
