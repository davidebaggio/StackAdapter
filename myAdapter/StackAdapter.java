package myAdapter;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Class StackAdapter that adapts class {@link myAdapter.Vector}. It implements
 * {@link myAdapter.HCollection} and {@link myAdapter.HList} interfaces and
 * works as Stack data structure.
 * 
 * @author Davide Baggio
 * @see myAdapter.Vector
 * @see myAdapter.HList
 * @see myAdapter.HCollection
 */
public class StackAdapter extends Vector implements HList {

	private int from, to;
	private Vector vector;
	private StackAdapter father;
	boolean root;

	/**
	 * Construct an empty stack.
	 */
	public StackAdapter() {
		this.vector = new Vector();
		this.from = 0;
		this.to = 0;
		this.root = true;
		this.father = null;
	}

	/**
	 * Method that checks if the stack is empty.
	 * 
	 * @return True if it is empty, false otherwise.
	 */
	public boolean empty() {
		return this.isEmpty();
	}

	/**
	 * Method that push an element on top of the stack.
	 * 
	 * @param obj element to push.
	 * @return the element given as parameter.
	 */
	public Object push(Object obj) {
		this.add(this.size(), obj);
		return obj;
	}

	/**
	 * Method that peeks into the top of the stack, without removing the element.
	 * 
	 * @return the element on top of the stack.
	 * @throws EmptyStackException if no element is present in the stack
	 */
	public Object peek() {
		if (this.empty())
			throw new EmptyStackException();
		return this.get(this.size() - 1);
	}

	/**
	 * Method that removes the element on top of the stack.
	 * 
	 * @return the element on top of the stack.
	 * @throws EmptyStackException if no element is present in the stack
	 */
	public Object pop() {
		Object el = this.peek();
		this.remove(this.size() - 1);
		return el;
	}

	/**
	 * Returns the 1-based position where an object is on this stack. If the object
	 * o occurs as an item in this stack, this method returns the distance this.from
	 * the
	 * top of the stack of the occurrence nearest the top of the stack; the topmost
	 * item on the stack is considered to be at distance 1. The equals method is
	 * used to compare o to the items in this stack.
	 * 
	 * @param o - the desired object.
	 * @return the 1-based position this.from the top of the stack where the object
	 *         is
	 *         located; the return value -1 indicates that the object is not on the
	 *         stack.
	 */
	public int search(Object o) {
		int i = this.lastIndexOf(o);

		if (i >= 0) {
			return this.size() - i;
		}
		return -1;
	}

	@Override
	public int size() {
		int s = this.to - this.from;
		if (s >= 0)
			return s;
		else
			return Integer.MAX_VALUE;
	}

	@Override
	public boolean isEmpty() {
		return (this.size() == 0);
	}

	@Override
	public boolean contains(Object obj) {
		for (int i = this.from; i < this.to; i++) {
			if (this.vector.elementAt(i) == null) {
				if (obj == null) {
					return true;
				}
			} else if ((this.vector.elementAt(i)).equals(obj)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public HIterator iterator() {
		StackIterator iter = new StackIterator();
		return iter;
	}

	@Override
	public Object[] toArray() {
		Object arr[] = new Object[this.size()];
		for (int i = 0; i < this.size(); i++) {
			arr[i] = this.get(i);
		}
		return arr;
	}

	@Override
	public Object[] toArray(Object target[]) {
		if (target == null)
			throw new NullPointerException();

		if (target.length < this.size()) {
			target = new Object[this.size()];
		} else {
			for (int i = 0; i < target.length; i++) {
				target[i] = null;
			}
		}
		for (int i = 0; i < this.size(); i++) {
			target[i] = this.get(i);
		}
		return target;
	}

	@Override
	public boolean add(Object obj) {
		add(this.size(), obj);
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		int index = this.vector.indexOf(obj);
		if (index >= this.from && index < this.to) {
			this.vector.removeElementAt(index);
			this.to--;
			boolean isF = this.root;
			StackAdapter f = this.father;
			while (!isF) {
				f.to--;
				isF = f.root;
				f = f.father;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(HCollection coll) {
		if (coll == null) {
			throw new NullPointerException();
		}
		HIterator iter = coll.iterator();
		while (iter.hasNext()) {
			if (!contains(iter.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(HCollection coll) {
		if (coll == null) {
			throw new NullPointerException();
		}
		HIterator iter = coll.iterator();
		boolean mod = false;
		while (iter.hasNext()) {
			mod = this.add(iter.next());
		}
		return mod;
	}

	@Override
	public boolean removeAll(HCollection coll) {
		if (coll == null) {
			throw new NullPointerException();
		}
		HIterator iter = coll.iterator();
		boolean mod = false;
		Object toRemove;
		while (iter.hasNext()) {
			toRemove = iter.next();
			while (this.contains(toRemove)) {
				mod = this.remove(toRemove);
			}
		}
		return mod;
	}

	@Override
	public boolean retainAll(HCollection coll) {
		if (coll == null) {
			throw new NullPointerException();
		}
		boolean mod = false;
		HIterator iter = iterator();
		while (iter.hasNext()) {
			if (!(coll.contains(iter.next()))) {
				iter.remove();
				mod = true;
			}
		}
		return mod;
	}

	@Override
	public void clear() {
		if (root) {
			this.vector.removeAllElements();
			to = this.from;
		} else {
			for (int i = this.size() - 1; i >= 0; i--) {
				this.remove(i);
			}
		}
	}

	@Override
	public Object get(int index) {
		index = this.from + index;
		if (index < this.from || index >= to) {
			throw new IndexOutOfBoundsException();
		}
		return this.vector.elementAt(index);
	}

	@Override
	public Object set(int index, Object element) {
		Object obj = this.get(index);
		index = this.from + index;
		this.vector.setElementAt(element, index);
		return obj;
	}

	@Override
	public void add(int index, Object obj) {
		index = this.from + index;
		if (index < this.from || index > this.to) {
			throw new IndexOutOfBoundsException();
		}
		this.vector.insertElementAt(obj, index);
		this.to++;
		boolean isF = this.root;
		StackAdapter f = this.father;
		while (!isF) {
			f.to++;
			isF = f.root;
			f = f.father;
		}
	}

	@Override
	public Object remove(int index) {
		Object obj = this.get(index);
		index = this.from + index;
		this.vector.removeElementAt(index);
		this.to--;
		boolean isF = this.root;
		StackAdapter f = this.father;
		while (!isF) {
			f.to--;
			isF = f.root;
			f = f.father;
		}
		return obj;
	}

	@Override
	public int indexOf(Object obj) {
		return this.vector.indexOf(obj);
	}

	@Override
	public int lastIndexOf(Object obj) {
		return this.vector.lastIndexOf(obj);
	}

	@Override
	public boolean addAll(int index, HCollection coll) {
		if (coll == null) {
			throw new NullPointerException();
		}
		if (index < this.from || index > to) {
			throw new IndexOutOfBoundsException();
		}
		boolean mod = false;
		HIterator iter = coll.iterator();
		while (iter.hasNext()) {
			this.add(index, iter.next());
			index++;
			mod = true;
		}
		return mod;
	}

	@Override
	public HListIterator listIterator() {
		return new StackIterator();
	}

	@Override
	public HListIterator listIterator(int index) {
		index = this.from + index;
		if (index < this.from || index > this.to) {
			throw new IndexOutOfBoundsException();
		}
		StackIterator iter = new StackIterator();
		for (int i = 0; i < index; i++) {
			iter.next();
		}
		return iter;
	}

	@Override
	public HList subList(int fromIndex, int toIndex) {
		fromIndex = this.from + fromIndex;
		toIndex = this.from + toIndex;
		if (fromIndex < this.from || toIndex > this.to || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		StackAdapter temp = new StackAdapter();
		temp.vector = this.vector;
		temp.from = fromIndex;
		temp.to = toIndex;
		temp.root = false;
		temp.father = this;
		return temp;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		StackAdapter temp = (StackAdapter) obj;
		if (size() != temp.size()) {
			return false;
		}
		HIterator iter = this.iterator();
		HIterator tempIter = temp.iterator();
		while (tempIter.hasNext()) {
			Object n1 = iter.next();
			Object n2 = tempIter.next();
			if (n1 != null && n2 != null) {
				if (!n1.equals(n2))
					return false;
			}
			if ((n1 == null && n2 != null) || (n1 != null && n2 == null))
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return this.vector.hashCode();
	}

	/**
	 * Iterator class for the {@link myAdapter.StackAdapter} class. Implements
	 * {@link myAdapter.HIterator} and {@link myAdapter.HListIterator} interfaces,
	 * and works as an Iterator for a stack.
	 * 
	 * @author Davide Baggio
	 * @see myAdapter.StackAdapter
	 * @see myAdapter.HIterator
	 * @see myAdapter.HListIterator
	 * @see myAdapter.HIteratorState
	 */
	public class StackIterator implements HListIterator {

		private int index;
		private HIteratorState state;

		/**
		 * Contructor of the StackIterator. Initialize the state of this iterator.
		 */
		public StackIterator() {
			this.index = 0;
			this.state = HIteratorState.IDLE;
		}

		@Override
		public boolean hasNext() {
			return (this.index < StackAdapter.this.size());
		}

		@Override
		public Object next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Object obj = get(this.index);
			this.index++;
			this.state = HIteratorState.HAS_GONE_NEXT;
			return obj;
		}

		@Override
		public boolean hasPrevious() {
			return (this.index > 0);
		}

		@Override
		public Object previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			Object obj = get(this.index - 1);
			this.index--;
			this.state = HIteratorState.HAS_GONE_PREV;
			return obj;
		}

		@Override
		public int nextIndex() {
			return this.index;
		}

		@Override
		public int previousIndex() {
			if (this.index > 0)
				return this.index - 1;
			return -1;
		}

		@Override
		public void add(Object obj) {
			StackAdapter.this.add(this.index, obj);
			this.index++;
			this.state = HIteratorState.HAS_ADDED;
		}

		@Override
		public void remove() {
			if (this.state == HIteratorState.HAS_GONE_NEXT) {
				this.previous();
				StackAdapter.this.remove(this.index);
				this.state = HIteratorState.HAS_REMOVED;
			} else if (this.state == HIteratorState.HAS_GONE_PREV) {
				StackAdapter.this.remove(this.index);
				this.state = HIteratorState.HAS_REMOVED;
			} else {
				throw new IllegalStateException();
			}
		}

		@Override
		public void set(Object obj) {
			if (this.state == HIteratorState.HAS_GONE_NEXT) {
				StackAdapter.this.set(this.index - 1, obj);
				this.state = HIteratorState.IDLE;
			} else if (this.state == HIteratorState.HAS_GONE_PREV) {
				StackAdapter.this.set(this.index, obj);
				this.state = HIteratorState.IDLE;
			} else {
				throw new IllegalStateException();
			}
		}

	}

}
