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
	boolean isFather;

	/**
	 * Construct an empty stack.
	 */
	public StackAdapter() {
		this.vector = new Vector();
		from = 0;
		to = 0;
		isFather = true;
		father = null;
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
	 * @param obj
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
	 * o occurs as an item in this stack, this method returns the distance from the
	 * top of the stack of the occurrence nearest the top of the stack; the topmost
	 * item on the stack is considered to be at distance 1. The equals method is
	 * used to compare o to the items in this stack.
	 * 
	 * @param o - the desired object.
	 * @return the 1-based position from the top of the stack where the object is
	 *         located; the return value -1 indicates that the object is not on the
	 *         stack.
	 */
	public int search(Object o) {
		int i = this.lastIndexOf(o);

		if (i >= 0) {
			return size() - i;
		}
		return -1;
	}

	@Override
	public int size() {
		return (to - from) >= 0 ? (to - from) : Integer.MAX_VALUE;
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public boolean contains(Object obj) {
		for (int i = from; i < to; i++) {
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
		Object newArr[] = new Object[size()];
		for (int i = 0; i < size(); i++) {
			newArr[i] = get(i);
		}
		return newArr;
	}

	@Override
	public Object[] toArray(Object arrayTarget[]) {
		if (arrayTarget == null) {
			throw new NullPointerException();
		}
		if (arrayTarget.length < size()) {
			arrayTarget = new Object[size()];
		} else {
			for (int i = 0; i < arrayTarget.length; i++) {
				arrayTarget[i] = null;
			}
		}
		for (int i = 0; i < size(); i++) {
			arrayTarget[i] = get(i);
		}
		return arrayTarget;
	}

	@Override
	public boolean add(Object obj) {
		add(size(), obj);
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		if (this.vector.indexOf(obj) >= from && this.vector.indexOf(obj) < to) {
			this.vector.removeElementAt(this.vector.indexOf(obj));
			to--;
			boolean isF = isFather;
			StackAdapter padre = father;
			while (!isF) {
				padre.to--;
				isF = padre.isFather;
				padre = padre.father;
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
			mod = add(iter.next());
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
			while (contains(toRemove)) {
				mod = remove(toRemove);
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
		if (isFather) {
			this.vector.removeAllElements();
			to = from;
		} else {
			for (int i = size() - 1; i >= 0; i--) {
				remove(i);
			}
		}
	}

	@Override
	public Object get(int index) {
		index = from + index;
		if (index < from || index >= to) {
			throw new IndexOutOfBoundsException();
		}
		return this.vector.elementAt(index);
	}

	@Override
	public Object set(int index, Object element) {
		Object obj = get(index);
		index = from + index;
		this.vector.setElementAt(element, index);
		return obj;
	}

	@Override
	public void add(int index, Object obj) {
		index = from + index;
		if (index < from || index > to) {
			throw new IndexOutOfBoundsException();
		}
		this.vector.insertElementAt(obj, index);
		to++;
		boolean isF = isFather;
		StackAdapter padre = father;
		while (!isF) {
			padre.to++;
			isF = padre.isFather;
			padre = padre.father;
		}
	}

	@Override
	public Object remove(int index) {
		Object obj = get(index);
		index = from + index;
		this.vector.removeElementAt(index);
		to--;
		boolean isF = isFather;
		StackAdapter padre = father;
		while (!isF) {
			padre.to--;
			isF = padre.isFather;
			padre = padre.father;
		}
		return obj;
	}

	@Override
	public int indexOf(Object obj) {
		for (int i = 0; i < size(); i++) {
			if (get(i) == null) {
				if (obj == null) {
					return (i);
				}
			} else if ((get(i)).equals(obj)) {
				return (i);
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object obj) {
		for (int i = (size() - 1); i >= 0; i--) {
			if (get(i) == null) {
				if (obj == null) {
					return (i);
				}
			} else if ((get(i)).equals(obj)) {
				return (i);
			}
		}
		return -1;
	}

	@Override
	public boolean addAll(int index, HCollection coll) {
		if (coll == null) {
			throw new NullPointerException();
		}
		if (index < from || index > to) {
			throw new IndexOutOfBoundsException();
		}
		boolean mod = false;
		HIterator iter = coll.iterator();
		while (iter.hasNext()) {
			add(index, iter.next());
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
		index = from + index;
		if (index < from || index > to) {
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
		fromIndex = from + fromIndex;
		toIndex = from + toIndex;
		if (fromIndex < from || toIndex > to || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		StackAdapter LA = new StackAdapter();
		LA.vector = this.vector;
		LA.from = fromIndex;
		LA.to = toIndex;
		LA.isFather = false;
		LA.father = this;
		return LA;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		StackAdapter LAobj = (StackAdapter) obj;
		if (size() != LAobj.size()) {
			return false;
		}
		HIterator TH = this.iterator();
		HIterator LI = LAobj.iterator();
		while (LI.hasNext()) {
			Object n1 = TH.next();
			Object n2 = LI.next();
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
	 */
	public class StackIterator implements HListIterator {

		private int prec, succ, NOP; // precedente, successivo, NextOrPrevious

		/**
		 * Contructor of the StackIterator. Initialize the state of this iterator.
		 */
		public StackIterator() {
			prec = -1;
			succ = 0;
			NOP = 0;
		}

		@Override
		public boolean hasNext() {
			return (succ < size());
		}

		@Override
		public Object next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Object obj = get(succ);
			prec++;
			succ++;
			NOP = 1;
			return obj;
		}

		@Override
		public boolean hasPrevious() {
			return (prec >= 0);
		}

		@Override
		public Object previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			Object obj = get(prec);
			prec--;
			succ--;
			NOP = -1;
			return obj;
		}

		@Override
		public int nextIndex() {
			return succ;
		}

		@Override
		public int previousIndex() {
			return prec;
		}

		@Override
		public void add(Object obj) {
			StackAdapter.this.add(succ, obj);
			prec++;
			succ++;
			NOP = 0;
		}

		@Override
		public void remove() {
			if (NOP == 1) {
				StackAdapter.this.remove(prec);
				prec--;
				succ--;
			} else if (NOP == -1) {
				StackAdapter.this.remove(succ);
			} else {
				throw new IllegalStateException();
			}
			NOP = 0;
		}

		@Override
		public void set(Object obj) {
			if (NOP == 1) {
				StackAdapter.this.set(prec, obj);
			} else if (NOP == -1) {
				StackAdapter.this.set(succ, obj);
			} else {
				throw new IllegalStateException();
			}
		}

	}

}
