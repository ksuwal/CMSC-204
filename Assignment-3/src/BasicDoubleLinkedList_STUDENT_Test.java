//package _solution;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Motorbike> linkedMotorbike;
	StringComparator comparator;
	DoubleComparator comparatorD;
	MotorbikeComparator comparatorMotorbike;
	
	public Motorbike a=new Motorbike("ducati", "monster", 2015);
	public Motorbike b=new Motorbike("BMW", "S1000RR", 2017);
	public Motorbike c=new Motorbike("Honda", "CB1000R", 2018);
	public Motorbike d=new Motorbike("Harley Davidson", "Live Wire", 2020);
	public Motorbike e=new Motorbike("KTM", "Duke", 2016);
	public Motorbike f=new Motorbike("Yamaha", "MT07", 2019);

	public ArrayList<Motorbike> fill = new ArrayList<Motorbike>();
	

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Two");
		linkedString.addToEnd("Wheels");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();
		
		linkedMotorbike= new BasicDoubleLinkedList<Motorbike>();
		linkedMotorbike.addToEnd(b);
		linkedMotorbike.addToEnd(c);
		comparatorMotorbike = new MotorbikeComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedMotorbike = null;
		comparatorD = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
		assertEquals(2,linkedMotorbike.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("Wheels", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		
		assertEquals(c,linkedMotorbike.getLast());
		linkedMotorbike.addToEnd(d);
		assertEquals(d,linkedMotorbike.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Two", linkedString.getFirst());
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
		
		assertEquals(b,linkedMotorbike.getFirst());
		linkedMotorbike.addToFront(a);
		assertEquals(a,linkedMotorbike.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Two", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		
		assertEquals(b,linkedMotorbike.getFirst());
		linkedMotorbike.addToFront(a);
		assertEquals(a,linkedMotorbike.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("Wheels", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		
		assertEquals(c,linkedMotorbike.getLast());
		linkedMotorbike.addToEnd(d);
		assertEquals(d,linkedMotorbike.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Motorbike> list;
		linkedMotorbike.addToFront(a);
		linkedMotorbike.addToEnd(d);
		list = linkedMotorbike.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(d,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Two", iterator.next());
		assertEquals("Wheels", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
		linkedMotorbike.addToFront(a);
		linkedMotorbike.addToEnd(d);
		ListIterator<Motorbike> iteratorMotorbike = linkedMotorbike.iterator();
		assertEquals(true, iteratorMotorbike.hasNext());
		assertEquals(a, iteratorMotorbike.next());
		assertEquals(b, iteratorMotorbike.next());
		assertEquals(c, iteratorMotorbike.next());
		assertEquals(true, iteratorMotorbike.hasNext());
		assertEquals(d, iteratorMotorbike.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedMotorbike.addToFront(a);
		linkedMotorbike.addToEnd(d);
		ListIterator<Motorbike> iteratorMotorbike = linkedMotorbike.iterator();
		assertEquals(true, iteratorMotorbike.hasNext());
		assertEquals(a, iteratorMotorbike.next());
		assertEquals(b, iteratorMotorbike.next());
		assertEquals(c, iteratorMotorbike.next());
		assertEquals(d, iteratorMotorbike.next());
		assertEquals(true, iteratorMotorbike.hasPrevious());
		assertEquals(d, iteratorMotorbike.previous());
		assertEquals(c, iteratorMotorbike.previous());
		assertEquals(b, iteratorMotorbike.previous());
		assertEquals(a, iteratorMotorbike.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedMotorbike.addToFront(a);
		linkedMotorbike.addToEnd(d);
		ListIterator<Motorbike> iteratorMotorbike = linkedMotorbike.iterator();		
		assertEquals(true, iteratorMotorbike.hasNext());
		assertEquals(a, iteratorMotorbike.next());
		assertEquals(b, iteratorMotorbike.next());
		assertEquals(c, iteratorMotorbike.next());
		assertEquals(true, iteratorMotorbike.hasNext());
		assertEquals(d, iteratorMotorbike.next());
		
		try{
			//no more elements in list
			iteratorMotorbike.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedMotorbike.addToFront(a);
		linkedMotorbike.addToEnd(d);
		ListIterator<Motorbike> iteratorMotorbike = linkedMotorbike.iterator();		
		assertEquals(true, iteratorMotorbike.hasNext());
		assertEquals(a, iteratorMotorbike.next());
		assertEquals(b, iteratorMotorbike.next());
		assertEquals(c, iteratorMotorbike.next());
		assertEquals(d, iteratorMotorbike.next());
		assertEquals(true, iteratorMotorbike.hasPrevious());
		assertEquals(d, iteratorMotorbike.previous());
		assertEquals(c, iteratorMotorbike.previous());
		assertEquals(b, iteratorMotorbike.previous());
		assertEquals(a, iteratorMotorbike.previous());
		
		try{
			//no more elements in list
			iteratorMotorbike.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedMotorbike.addToFront(a);
		linkedMotorbike.addToEnd(d);
		ListIterator<Motorbike> iteratorMotorbike = linkedMotorbike.iterator();		
		assertEquals(true, iteratorMotorbike.hasNext());
		assertEquals(a, iteratorMotorbike.next());
		assertEquals(b, iteratorMotorbike.next());
		assertEquals(c, iteratorMotorbike.next());
		assertEquals(true, iteratorMotorbike.hasNext());
		assertEquals(d, iteratorMotorbike.next());
		
		try{
			//remove is not supported for the iterator
			iteratorMotorbike.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(b, linkedMotorbike.getFirst());
		assertEquals(c, linkedMotorbike.getLast());
		linkedMotorbike.addToFront(a);
		assertEquals(a, linkedMotorbike.getFirst());
		linkedMotorbike.remove(a, comparatorMotorbike);
		assertEquals(b, linkedMotorbike.getFirst());
		//remove from the end of the list
		linkedMotorbike.addToEnd(d);
		assertEquals(d, linkedMotorbike.getLast());
		linkedMotorbike.remove(d, comparatorMotorbike);
		assertEquals(c, linkedMotorbike.getLast());
		//remove from middle of list
		linkedMotorbike.addToFront(a);
		assertEquals(a, linkedMotorbike.getFirst());
		assertEquals(c, linkedMotorbike.getLast());
		linkedMotorbike.remove(b, comparatorMotorbike);
		assertEquals(a, linkedMotorbike.getFirst());
		assertEquals(c, linkedMotorbike.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(b, linkedMotorbike.getFirst());
		linkedMotorbike.addToFront(a);
		assertEquals(a, linkedMotorbike.getFirst());
		assertEquals(a, linkedMotorbike.retrieveFirstElement());
		assertEquals(b,linkedMotorbike.getFirst());
		assertEquals(b, linkedMotorbike.retrieveFirstElement());
		assertEquals(c,linkedMotorbike.getFirst());
		
		assertEquals("Two", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Two",linkedString.getFirst());
		assertEquals("Two", linkedString.retrieveFirstElement());
		assertEquals("Wheels",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linkedMotorbike.getLast());
		linkedMotorbike.addToEnd(d);
		assertEquals(d, linkedMotorbike.getLast());
		assertEquals(d, linkedMotorbike.retrieveLastElement());
		assertEquals(c,linkedMotorbike.getLast());
		
		assertEquals("Wheels", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("Wheels",linkedString.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class MotorbikeComparator implements Comparator<Motorbike>
	{

		@Override
		public int compare(Motorbike arg0, Motorbike arg1) {
			// Just put motorbikes in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Motorbike{
		String make;
		String model;
		int year;
		
		public Motorbike(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}