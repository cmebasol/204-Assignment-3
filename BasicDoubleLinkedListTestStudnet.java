/**
 * @author mebatadesse
 */
import java.util.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedListTestStudnet {
	BasicDoubleLinkedList<String> linkedS;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Student> linkedCar;

	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public Student a=new Student("Eyosyas", "Tesema", 25);
	public Student b=new Student("Meba", "Tadesse", 25);
	public Student c=new Student("Kevin", "Richard", 25);
	public Student d=new Student("Chang", "Lui", 25);
	public Student e=new Student("Hannah", "Last", 25);
	public Student f=new Student("Amanda", "Faread", 25);

	public ArrayList<Student> fill = new ArrayList<Student>();
	

	@Before
	public void setUp() throws Exception {
		linkedS = new BasicDoubleLinkedList<String>();
		linkedS.addToEnd("Hola");
		linkedS.addToEnd("Wonderland");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();
		
		linkedCar= new BasicDoubleLinkedList<Student>();
		linkedCar.addToEnd(b);
		linkedCar.addToEnd(c);
		comparatorCar = new CarComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedS = null;
		linkedDouble = null;
		linkedCar = null;
		comparatorD = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedS.getSize());
		assertEquals(2,linkedDouble.getSize());
		assertEquals(2,linkedCar.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("Wonderland", linkedS.getLast());
		linkedS.addToEnd("End");
		assertEquals("End", linkedS.getLast());
		
		assertEquals(c,linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d,linkedCar.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Hola", linkedS.getFirst());
		linkedS.addToFront("Begin");
		assertEquals("Begin", linkedS.getFirst());
		
		assertEquals(b,linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a,linkedCar.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Hola", linkedS.getFirst());
		linkedS.addToFront("Norman");
		assertEquals("Norman", linkedS.getFirst());
		
		assertEquals(b,linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a,linkedCar.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("Wonderland", linkedS.getLast());
		linkedS.addToEnd("Norman");
		assertEquals("Norman", linkedS.getLast());
		
		assertEquals(c,linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d,linkedCar.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Student> list;
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		list = linkedCar.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(d,list.get(3));
		
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Student> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Student> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//no more elements in list
			iteratorCar.next();
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
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Student> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		
		try{
			//no more elements in list
			iteratorCar.previous();
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
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Student> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
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
		assertEquals(b, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());
		linkedCar.remove(a, comparatorCar);
		assertEquals(b, linkedCar.getFirst());
		//remove from the end of the list
		linkedCar.addToEnd(d);
		assertEquals(d, linkedCar.getLast());
		linkedCar.remove(d, comparatorCar);
		assertEquals(c, linkedCar.getLast());
		//remove from middle of list
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		linkedCar.remove(b, comparatorCar);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(b, linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(a, linkedCar.retrieveFirstElement());
		assertEquals(b,linkedCar.getFirst());
		assertEquals(b, linkedCar.retrieveFirstElement());
		assertEquals(c,linkedCar.getFirst());
		
		assertEquals("Hola", linkedS.getFirst());
		linkedS.addToFront("Norman");
		assertEquals("Norman", linkedS.getFirst());
		assertEquals("Norman", linkedS.retrieveFirstElement());
		assertEquals("Hola",linkedS.getFirst());
		assertEquals("Hola", linkedS.retrieveFirstElement());
		assertEquals("Wonderland",linkedS.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d, linkedCar.getLast());
		assertEquals(d, linkedCar.retrieveLastElement());
		assertEquals(c,linkedCar.getLast());
		
		assertEquals("Wonderland", linkedS.getLast());
		linkedS.addToEnd("Norman");
		assertEquals("Norman", linkedS.getLast());
		assertEquals("Norman", linkedS.retrieveLastElement());
		assertEquals("Wonderland",linkedS.getLast());
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
	
	private class CarComparator implements Comparator<Student>
	{

		@Override
		public int compare(Student arg0, Student arg1) {
			// Just put cars in alphabetic order by firstName
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Student{
		String firstName;
		String lastName;
		int age;
		
		public Student(String firstName, String lastName, int age){
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}
		
		public String getMake(){
			return firstName;
		}
		public String getFiirstName(){
			return lastName;
		}
		public int getAge(){
			return age;
		}
		
		public String toString() {
			return (getMake()+" "+getFiirstName()+" "+getAge());
		}
	}
}
