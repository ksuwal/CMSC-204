//package _solution;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Motorbike> sortedLinkedMotorbike;
	StringComparator comparator;
	DoubleComparator comparatorD;
	MotorbikeComparator comparatorMotorbike;
	
	public Motorbike a=new Motorbike("ducati", "monster", 2015);
	public Motorbike b=new Motorbike("BMW", "S1000RR", 2017);
	public Motorbike c=new Motorbike("Honda", "CB1000R", 2018);
	public Motorbike d=new Motorbike("Harley Davidson", "Live Wire", 2020);
	public Motorbike e=new Motorbike("KTM", "Duke", 2016);
	public Motorbike f=new Motorbike("Yamaha", "MT07", 2019);
	//alphabetic order: e f a c b d
	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorMotorbike = new MotorbikeComparator();
		sortedLinkedMotorbike = new SortedDoubleLinkedList<Motorbike>(comparatorMotorbike);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorMotorbike = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedMotorbike = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedMotorbike.add(a);
		sortedLinkedMotorbike.add(b);
		sortedLinkedMotorbike.add(c);
		sortedLinkedMotorbike.add(d);
		ListIterator<Motorbike> iterator = sortedLinkedMotorbike.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulMotorbikePrevious() {
		sortedLinkedMotorbike.add(e);
		sortedLinkedMotorbike.add(c);
		sortedLinkedMotorbike.add(b);
		sortedLinkedMotorbike.add(d);
		//ArrayList<Motorbike> motorbikeList = sortedLinkedMotorbike.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Motorbike> iterator = sortedLinkedMotorbike.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(e, iterator.previous());
		assertEquals(c, iterator.previous());
		assertEquals(d, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(6));
		sortedLinkedDouble.add(new Double(1));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(1), iterator.next());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(6), iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(10));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		//assertEquals(new Double(10), iterator.previous());
		assertEquals(new Double(8), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedMotorbike.add(e);
		sortedLinkedMotorbike.add(c);
		sortedLinkedMotorbike.add(b);
		sortedLinkedMotorbike.add(d);
		//ArrayList<Motorbike> motorbikeList = sortedLinkedMotorbike.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Motorbike> iterator = sortedLinkedMotorbike.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		try{
			//no more elements in list
			iterator.next();
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
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedMotorbike.add(e);
		sortedLinkedMotorbike.add(c);
		sortedLinkedMotorbike.add(b);
		sortedLinkedMotorbike.add(d);
		//ArrayList<Motorbike> motorbikeList = sortedLinkedMotorbike.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Motorbike> iterator = sortedLinkedMotorbike.iterator();
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
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
	public void testAddMotorbike() {
		//alphabetic order: e f a c b d
		sortedLinkedMotorbike.add(a);
		sortedLinkedMotorbike.add(b);
		sortedLinkedMotorbike.add(c);
		assertEquals(b, sortedLinkedMotorbike.getFirst());
		assertEquals(a, sortedLinkedMotorbike.getLast());
		sortedLinkedMotorbike.add(d);
		sortedLinkedMotorbike.add(e);
		assertEquals(b, sortedLinkedMotorbike.getFirst());
		assertEquals(a, sortedLinkedMotorbike.getLast());
		//deletes Elephant from linked list
		assertEquals(a,sortedLinkedMotorbike.retrieveLastElement());
		assertEquals(e, sortedLinkedMotorbike.getLast());
	}

	@Test
	public void testRemoveFirstMotorbike() {
		//alphabetic order: e f a c b d
		sortedLinkedMotorbike.add(b);
		sortedLinkedMotorbike.add(c);
		assertEquals(b, sortedLinkedMotorbike.getFirst());
		assertEquals(c, sortedLinkedMotorbike.getLast());
		sortedLinkedMotorbike.add(a);
		assertEquals(b, sortedLinkedMotorbike.getFirst());
		// remove the first
		sortedLinkedMotorbike.remove(a, comparatorMotorbike);
		assertEquals(b, sortedLinkedMotorbike.getFirst());
	}
	
	@Test
	public void testRemoveEndMotorbike() {
		//alphabetic order: e f a c b d
		sortedLinkedMotorbike.add(b);
		sortedLinkedMotorbike.add(f);
		assertEquals(b, sortedLinkedMotorbike.getFirst());
		assertEquals(f, sortedLinkedMotorbike.getLast());
		sortedLinkedMotorbike.add(d);
		assertEquals(f, sortedLinkedMotorbike.getLast());
		//remove from the end of the list
		sortedLinkedMotorbike.remove(d, comparatorMotorbike);
		assertEquals(f, sortedLinkedMotorbike.getLast());
	}

	@Test
	public void testRemoveMiddleMotorbike() {
		//alphabetic order: e f a c b d
		sortedLinkedMotorbike.add(a);
		sortedLinkedMotorbike.add(b);
		assertEquals(b, sortedLinkedMotorbike.getFirst());
		assertEquals(a, sortedLinkedMotorbike.getLast());
		sortedLinkedMotorbike.add(f);
		assertEquals(b, sortedLinkedMotorbike.getFirst());
		assertEquals(a, sortedLinkedMotorbike.getLast());
		assertEquals(3,sortedLinkedMotorbike.getSize());
		//remove from middle of list
		sortedLinkedMotorbike.remove(a, comparatorMotorbike);
		assertEquals(b, sortedLinkedMotorbike.getFirst());
		assertEquals(f, sortedLinkedMotorbike.getLast());
		assertEquals(2,sortedLinkedMotorbike.getSize());
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
			// Just put cars in alphabetic order by make
			return arg0.getMake().compareTo(arg1.getMake());
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