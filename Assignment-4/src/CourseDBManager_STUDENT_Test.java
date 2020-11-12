

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author Kabindra Raj Suwal
 *
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("Test_1",1111,3,"ROOM100","Ramacharan");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("Math182",12345,4,"SC203","Helen Salzberg");
		dataMgr.add("CMSC204",12346,4,"SC301","Khandan Monshi");
		dataMgr.add("SPAN101",12347,2,"HM222","Milvia Hernandez");
		ArrayList<String> list = dataMgr.showAll();
		
		assertEquals(list.get(0),"\nCourse:Math182 CRN:12345 Credits:4 Instructor:Helen Salzberg Room:SC203");
		assertEquals(list.get(1),"\nCourse:CMSC204 CRN:12346 Credits:4 Instructor:Khandan Monshi Room:SC301");
		assertEquals(list.get(2),"\nCourse:SPAN101 CRN:12347 Credits:2 Instructor:Milvia Hernandez Room:HM222");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("tester.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("GEOG101 12348 3 SC105 Alison Tanya");
			inFile.print("TestRead 12348 3 SC105 Alison Tanya");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			//System.out.println(dataMgr.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}