import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{

	protected Node first;
	protected Node last;
	protected int size;
	/**
	 * creates BasicDoubleLinkedList object (constructor)
	 * 
	 */
	public BasicDoubleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	/**
	 * gets the  object in the first node
	 * @return the object in the first node
	 */
	public T getFirst() {
		
		return first.item;
	}

	/**
	 * sets the object in the first node
	 * @param first the object to be set as the first node
	 */
	public void setFirst(Node first) {
		this.first = first;
	}
	/**
	 * gets the  object in the last node
	 * @return the object in the last node
	 */

	public T getLast() {
		return last.item;
	}

	/**
	 * sets the object in the last node
	 * @param last the object to be set as the last node
	 */
	public void setLast(Node last) {
		this.last = last;
	}

/**
 * returns the size	
 * @return size of the list
 */
	public int getSize() {
		return size;
	}

	/**
	 * sets the size
	 * @param size SIZE OF THE LIST
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * adds new node with the data in the parameter to the end of the double linked list
	 * @param data the new data to be added to the end of the list
	 */
	public void addToEnd(T data) {
		if (last == null) {
			last = new Node(data, null, null);
			first = last;
		}
		else {	
		Node n = new Node (data, last,null);
		
		last.next = n;
		last = n;
		}
		size ++;
	}
	/**
	 * adds new node with the data in the parameter to the front of the double linked list
	 * @param data the new data to be added to the front of the list
	 */
	public void addToFront(T data) {
		
		if (size == 0) {
			first = new Node (data, null , first) ;
			last = first;
		}
		else {
			Node n = new Node(data, null , first) ;
			first.prev = n;
			first = n;
		}
		
		size ++;
	}
	
	


	/**
	 * node class
	 * @author mebatadesse
	 *
	 */
	public class Node  {
		 protected T item;
		 protected Node prev;
		 protected Node next;
		 /**
		  * constructor
		  * @param data object stored
		  * @param prev pointer to the previous node
		  * @param next pointer to the next node
		  */
		 public Node (T data, Node prev, Node next) {
			 this.item = data;
			 this.prev = prev;
			 this.next = next;
		 }
		 
		 

	 }

	/*
	 * double linked iterator
	 */
		protected class BasicDoubleLinkedListIterator implements ListIterator<T>{
		Node ele;
		Node pre;
		
		/**
		 *  BasicDoubleLinkedListIterator constructor
		 */
		public BasicDoubleLinkedListIterator() {
		
			this.ele = first;
			this.pre = null;
			
			
		}
		
	
		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
			
		}
	
		@Override
		public void remove() {
			
			throw new UnsupportedOperationException();
		}
	
		@Override
		public void set(Object e) {
			throw new UnsupportedOperationException();
			
		}
	
		@Override
		public void add(Object e) {
			throw new UnsupportedOperationException();
			
		}


		@Override
		public boolean hasNext() {
			
			
			return ele != null;
		}


		@Override
		public T next()  throws NoSuchElementException{
		
			if(!hasNext()) {
				throw new NoSuchElementException();
				
			}
			else {
				pre=ele;
				ele=ele.next;
				return pre.item;
			}
			
		}


		@Override
		public boolean hasPrevious() {
			
			return pre != null;
		}


		@Override
		public T previous() throws NoSuchElementException{
			if(!hasPrevious()) {
				throw new NoSuchElementException();
				
			}
			else {
				ele=pre;
				pre=pre.prev;
				return ele.item;
			}
		}


		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
			
		}
		 
		 
	 }

	/**
	 * retrieves the first element in the linked list
	 * @return the object in the first node of the list
	 */
	
	public T retrieveFirstElement() {
		if (first == null ) {
			return null;
		}
		else {
			T obj = first.item;
			first = first.next;
			return obj;
		}
		
	}

	/**
	 * retrieves the last element in the linked list
	 * @return the object in the last node of the list
	 */
	public T retrieveLastElement() {
		if (last == null) {
			return null; 
		}
		else {
			T obj = last.item;
			last = last.prev;
			return obj;
		}
	}
	
	/**
	 * returns the an array list of objects in the linked list
	 * @return
	 */
	public ArrayList<T> toArrayList() {
		
		ArrayList<T> ret = new ArrayList<T>(); 
		if(size == 0) {
			return ret;
		}
		BasicDoubleLinkedListIterator dl = new BasicDoubleLinkedListIterator();
		while(dl.hasNext()) {
			ret.add(dl.next());
		}
		return ret;
	}
	

	/**
	 * removes the node containing an object equal to the  targetData
	 * @param targetData ojbect to be compared with to remove a node
	 * @param comparator an object used to compare each item to the target data
	 * @return null if there is no object equal to the target data or the node removed
	 */
	public Node remove (T targetData, Comparator<T >comparator) {
		Node current = first;
		if (size == 0)
			return null;
		else if (size == 1) {
			if (comparator.compare(targetData, first.item) ==0) {
				first = null;
				last = null;
				size--;
				return current;
			}
			 
		}
		else {
			while (current != null) {
				if (comparator.compare(targetData, current.item) == 0) {
					if(current == first) {
						first = current.next;
						current.next.prev = null;
					}
					else if (current == last) {
						last = current.prev;
						current.prev.next = null;
					}
					else {
						current.prev.next = current.next;
					current.next.prev = current.prev;
					}
					size --;
					return current;
					
				}
			current = current.next;
			
			}
		}
		return null;
	}


	@Override
	public ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return  new BasicDoubleLinkedListIterator();
	}
}