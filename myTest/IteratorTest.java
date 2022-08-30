package myTest;

import myAdapter.*;
import static org.junit.Assert.*;
import org.junit.*;

import java.util.NoSuchElementException;

/**
 * <strong>Summary</strong>: This test suite provides tests for the
 * {@link myAdapter.StackAdapter.StackIterator}
 * class methods
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: The design of this thest suite is all
 * about
 * testing each
 * method of the StackIterator class. The reason is to isolate every type of
 * operation
 * in order to validate each functionality.
 * <br>
 * <br>
 * <strong>Pre-conditions</strong>:A
 * new empty object of type StackAdapter must always be instantiated before
 * each test. All execution variables are never in an uninitialized state (i.e.
 * stack = null) unless explicitly desired. Methods that take as parameters
 * classes that implement HCollection are passed
 * suitable objects for this interface, therefore they do not throw the
 * exception ClassCastException.
 * All the elements contained in the stack are known a priori in order to allow
 * the verification after the invocation of the tested methods
 * <br>
 * <br>
 * <strong>Post-Conditions</strong>: the methods implemented must always modify
 * the stacks
 * so that
 * the elements contained are exactly those expected starting from their manual
 * insertion and have to provide a positive outcome.
 * <br>
 * <br>
 * <strong>Test Cases</strong>:
 * {@link #testHasNext()}, {@link #testAdd()},
 * {@link #testHasPrevious()}, {@link #testNext()}, {@link #testNextIndex()},
 * {@link #testPrevious()}, {@link #testPreviousIndex()}, {@link #testRemove()},
 * {@link #testSet()}.
 * <br>
 * <br>
 * <strong>Test Suite Execution Records</strong>: Records are exaclty what this
 * test suite provides as result of {@link myTest.TestRunner} class.
 * <br>
 * <br>
 * <strong>Execution Variables</strong>: StackAdapter stack (supports optional
 * operations), iter
 * (the iterator).
 * <br>
 * <br>
 * 
 * @author Davide Baggio
 * @see myAdapter.HIterator
 * @see myAdapter.HListIterator
 */
public class IteratorTest {

	StackAdapter stack;
	HListIterator iter;

	/**
	 * setup before each test.
	 */
	@Before
	public void setup() {
		stack = new StackAdapter();
		iter = stack.listIterator();
	}

	/**
	 * cleanup after each test
	 */
	@After
	public void clean() {
		stack = null;
		iter = null;
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter.StackIterator#hasNext()}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: The test provides informations about the
	 * presence of
	 * another element in the next position of the iterator index.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Two elements are added in the stack and
	 * the iterator
	 * through
	 * the method check if it has more elements in the stack.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: stack is initialize as Empty and has to
	 * initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Iterator should find itself in the last
	 * position of the
	 * stack.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: IteratorAdapter.hasNext() == true until
	 * last element
	 * included;
	 */
	@Test
	public void testHasNext() {

		stack.add(2);
		stack.add(8);
		assertTrue(iter.hasNext());
		iter.next();
		assertTrue(iter.hasNext());
		iter.next();
		assertFalse(iter.hasNext());

	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter.StackIterator#next()} method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: The test should return each element in the
	 * iterator
	 * position and an Exception if there are no elements at the end.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Some elements are added in the stack. Then
	 * the next()
	 * method
	 * is call in a for loop until last element. Each loop is returning the object
	 * in the iterator position. At the end the next() method is called again in
	 * order to throw NoSuchElementException.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: stack is initialize as Empty and has to
	 * initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Iterator should find itself in the last
	 * position of the
	 * stack.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: next() == stack.get(index) each loop;
	 */
	@Test
	public void testNext() {

		stack.add(2);
		stack.add(8);
		stack.add(2);
		stack.add(4);
		stack.add(5);

		int index = 0;
		while (iter.hasNext()) {
			assertEquals(stack.get(index), iter.next());
			index++;
		}

		try {
			iter.next();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NoSuchElementException.class, e.getClass());
		}

	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter.StackIterator#remove()}
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: This test provides informations about all
	 * the possible iterator state that throw IllegalStateException. Then it
	 * tries to remove elements in the stack.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: In the first place we look for exceptions
	 * to be thrown then if the states are correct the remove
	 * method is called after 5 elements have been added to the stack;
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: stack is initialize as Empty and has to
	 * initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Only three elements should be present in
	 * the
	 * stack.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: Elements in the stack: 2,4,5.
	 */
	@Test
	public void testRemove() {
		try {
			iter.remove();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}

		stack.add(2);
		stack.add(8);
		stack.add(2);
		stack.add(4);
		stack.add(5);
		iter.next();
		iter.remove();

		try {
			iter.remove();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}

		iter.next();
		iter.previous();
		iter.remove();

		assertEquals(3, stack.size());
		assertArrayEquals(new Object[] { 2, 4, 5 }, stack.toArray());

	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter.StackIterator#add(Object)}
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: This test tries to add elements in the
	 * stack if that is a
	 * supported operation.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: In the first place we look for exceptions
	 * to be thrown then the add method is called;
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: stack is initialize as Empty and has to
	 * initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Three elements should be present in the
	 * stack.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: Elements in the stack: 2,4,5.
	 */
	@Test
	public void testAdd() {
		iter.add(2);
		iter.add(4);
		iter.add(5);

		assertArrayEquals(new Object[] { 2, 4, 5 }, stack.toArray());
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter.StackIterator#hasPrevious()}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: The test provides informations about the
	 * presence of
	 * another element in the previous position of the iterator index.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Two elements are added in the stack and
	 * the iterator
	 * through
	 * the method check if it has more elements before him in the stack.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: stack is initialize as Empty and has to
	 * initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Iterator should find itself in the first
	 * position of the
	 * stack.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: IteratorAdapter.hasprevious() == true
	 * until first element
	 * included;
	 */
	@Test
	public void testHasPrevious() {
		stack.add(2);
		stack.add(8);
		iter.next();
		iter.next();

		assertTrue(iter.hasPrevious());
		iter.previous();
		assertTrue(iter.hasPrevious());
		iter.previous();
		assertFalse(iter.hasPrevious());
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter.StackIterator#nextIndex()}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: This test provides information about
	 * nextIndex() calls. No
	 * exceptions are thrown.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Two elements are added to the stack and
	 * the nextIndex()
	 * method is called.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: stack is initialize as Empty and has to
	 * initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Two elements are correctly added to the
	 * stack and the
	 * iterator
	 * should return correct indexes.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: nextIndex() == 0, nextIndex() == 1;
	 */
	@Test
	public void testNextIndex() {
		stack.add(2);
		stack.add(8);

		assertEquals(0, iter.nextIndex());
		iter.next();
		assertEquals(1, iter.nextIndex());
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter.StackIterator#previous()}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: The test should return each element in the
	 * iterator
	 * position and an Exception if there are no elements before index 0.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Some elements are added in the stack. Then
	 * the previous()
	 * method
	 * is call in a for loop until first element. Each loop is returning the object
	 * in the iterator position. At the end the previous() method is called again in
	 * order to throw NoSuchElementException.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: stack is initialize as Empty and has to
	 * initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Iterator should find itself in the first
	 * position of the
	 * stack.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: previous() == stack.get(index) each loop;
	 */
	@Test
	public void testPrevious() {
		stack.add(2);
		stack.add(8);
		stack.add(2);
		stack.add(4);
		stack.add(5);
		iter = stack.listIterator(stack.size());

		int index = stack.size() - 1;
		while (iter.hasPrevious()) {
			assertEquals(stack.get(index), iter.previous());
			index--;
		}
		try {
			iter.previous();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NoSuchElementException.class, e.getClass());
		}
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter.StackIterator#previousIndex()} method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: This test provides information about
	 * previousIndex() calls.
	 * No
	 * exceptions are thrown.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Two elements are added to the stack and
	 * the previousIndex()
	 * method is called.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: stack is initialize as Empty and has to
	 * initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Two elements are correctly added to the
	 * stack and the
	 * iterator
	 * should return correct indexes.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: previousIndex() == 1, previousIndex() ==
	 * 0;
	 */
	@Test
	public void testPreviousIndex() {
		stack.add(2);
		stack.add(8);

		iter = stack.listIterator(stack.size());
		assertEquals(1, iter.previousIndex());
		iter.previous();
		assertEquals(0, iter.previousIndex());
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter.StackIterator#set(Object)}
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: This test tries to set elements in the
	 * stack if that is a
	 * supported operation.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: In the first place we look for exceptions
	 * to be thrown then the set method is called;
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: stack is initialize as Empty and has to
	 * initialize its own
	 * iterator.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Three elements should be present in the
	 * stack.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: Elements in the stack: 2,4,5.
	 */
	@Test
	public void testSet() {
		try {
			iter.set(5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}

		stack.add(2);
		try {
			iter.set(5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}
		stack.add(7);
		stack.add(6);
		stack.add(8);

		iter.next();
		iter.next();
		iter.remove();
		try {
			iter.set(5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}

		iter.next();
		iter.set(4);

		iter = stack.listIterator(stack.size());
		iter.previous();
		iter.set(5);

		assertArrayEquals(new Object[] { 2, 4, 5 }, stack.toArray());

	}

}
