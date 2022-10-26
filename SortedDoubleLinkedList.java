import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
/**
 * 
 * @author mebatadesse
 *
 * data structure class that is double linked list
 * @param <T> the type of object the sorted double linked list
 */
public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList <T> {
	Comparator<T> comparator;
	/**
	 * constructor
	 * @param comparator an object that defines how nodes are going to be sorted
	 */
	public SortedDoubleLinkedList (Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	/**
	 * adds new node with the data given to the list
	 * @param data data to be added to the list
	 */
	public void add(T data) {
		if (super.getSize() == 0) {
			Node n = new Node(data, null , null);
			first = n;
			last = n;
			super.setSize(super.getSize()+1);
		}
		
		else {
			if (comparator.compare(data, last.item) > 0) {
				super.addToEnd(data);
			}
			else if (comparator.compare(data, first.item) < 0) {
				super.addToFront(data);

			}
			else {
				Node current = first;
				
				while(current != null) {
					if (comparator.compare(data, current.item) < 0) {
						Node n = new Node(data, current.prev, current);
						current.prev.next = n;
						current.prev = n;
						super.setSize(super.getSize()+1);
						break;
					}
					current = current.next;
					
				}
			}
			
		}
	}
	
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	@Override
	public Node remove (T data, Comparator <T> comparator) {
		return super.remove(data, comparator);
	}
	
}
