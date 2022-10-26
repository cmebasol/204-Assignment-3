


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



public class SortedDoubleLinkedListTestStudent {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Student> sortedLinkedStudent;
	StringComparator comparator;
	DoubleComparator comparatorD;
	StudentComparator comparatorStudent;
	
	public Student a=new Student("Hanna", "Ashman", 2005);
	public Student b=new Student("Kevin", "Richard", 2005);
	public Student c=new Student("Honda", "Martez", 2005);
	public Student d=new Student("Randy", "Bareda", 2005);
	public Student e=new Student("Aiment", "Hadas", 2005);
	public Student f=new Student("Bladen", "Ahmed", 2005);
	//alphabetic order: e f a c b d
	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorStudent = new StudentComparator();
		sortedLinkedStudent = new SortedDoubleLinkedList<Student>(comparatorStudent);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorStudent = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedStudent = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hola");
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
			sortedLinkedString.addToFront("Hola");
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
		sortedLinkedStudent.add(a);
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(c);
		sortedLinkedStudent.add(d);
		ListIterator<Student> iterator = sortedLinkedStudent.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Hola");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		System.out.println(sortedLinkedString.toArrayList());
		assertEquals("Hola", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hola", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulStudentPrevious() {
		sortedLinkedStudent.add(e);
		sortedLinkedStudent.add(c);
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(d);
		//ArrayList<Student> carList = sortedLinkedStudent.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Student> iterator = sortedLinkedStudent.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(d, iterator.previous());
		assertEquals(b, iterator.previous());
		assertEquals(c, iterator.previous());
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
		System.out.println(sortedLinkedDouble.toArrayList());
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
		sortedLinkedStudent.add(e);
		sortedLinkedStudent.add(c);
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(d);
		//ArrayList<Student> carList = sortedLinkedStudent.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Student> iterator = sortedLinkedStudent.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
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
		sortedLinkedStudent.add(e);
		sortedLinkedStudent.add(c);
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(d);
		//ArrayList<Student> carList = sortedLinkedStudent.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Student> iterator = sortedLinkedStudent.iterator();
		
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
	public void testAddStudent() {
		//alphabetic order: e f a c b d
		sortedLinkedStudent.add(a);
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(c);
		assertEquals(a, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		sortedLinkedStudent.add(d);
		sortedLinkedStudent.add(e);
		assertEquals(e, sortedLinkedStudent.getFirst());
		assertEquals(d, sortedLinkedStudent.getLast());
		//deletes Elephant from linked list
		assertEquals(d,sortedLinkedStudent.retrieveLastElement());
		assertEquals(b, sortedLinkedStudent.getLast());
	}

	@Test
	public void testRemoveFirstStudent() {
		//alphabetic order: e f a c b d
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(c);
		assertEquals(c, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		sortedLinkedStudent.add(a);
		assertEquals(a, sortedLinkedStudent.getFirst());
		// remove the first
		sortedLinkedStudent.remove(a, comparatorStudent);
		assertEquals(c, sortedLinkedStudent.getFirst());
	}
	
	@Test
	public void testRemoveEndStudent() {
		//alphabetic order: e f a c b d
		sortedLinkedStudent.add(b);
		sortedLinkedStudent.add(f);
		assertEquals(f, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		sortedLinkedStudent.add(d);
		assertEquals(d, sortedLinkedStudent.getLast());
		//remove from the end of the list
		sortedLinkedStudent.remove(d, comparatorStudent);
		assertEquals(b, sortedLinkedStudent.getLast());
	}

	@Test
	public void testRemoveMiddleStudent() {
		//alphabetic order: e f a c b d
		sortedLinkedStudent.add(a);
		sortedLinkedStudent.add(b);
		assertEquals(a, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		sortedLinkedStudent.add(f);
		assertEquals(f, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		assertEquals(3,sortedLinkedStudent.getSize());
		//remove from middle of list
		sortedLinkedStudent.remove(a, comparatorStudent);
		assertEquals(f, sortedLinkedStudent.getFirst());
		assertEquals(b, sortedLinkedStudent.getLast());
		assertEquals(2,sortedLinkedStudent.getSize());
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
	
	private class StudentComparator implements Comparator<Student>
	{

		@Override
		public int compare(Student arg0, Student arg1) {
			// Just put cars in alphabetic order by make
			return arg0.getMake().compareTo(arg1.getMake());
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
