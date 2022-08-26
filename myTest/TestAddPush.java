package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * <strong>Class TestAddPush</strong>
 * <p>
 * <br>
 * <br>
 * <strong>Summary</strong>: The TestAddPush class checks with its tests the
 * operation of
 * Methods that insert objects on a Stack.
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: This class contains 5 tests cases who
 * tests 5 different
 * Methods of the Stackadapter class (), each of which inserts one or more
 * Elements in different positions.
 * <br>
 * <br>
 * <strong>Pre-Condition</strong>: Before each test it must be initialized
 * at least one Stack,
 * even if empty.
 * <br>
 * <br>
 * <strong>Post-Condition</strong>: After each test it must have been done
 * At least an insertion
 * In at least one Stack.
 * <br>
 * <br>
 * <strong>Test Cases</strong>: There are 5 tests of this class and are:
 * {@link #testPush()}, {@link #testAdd()}, {@link #testAddAll()},
 * {@link #testAddAllAtIndex()}, {@link #testAddAtIndex()}
 * Each of them serves test a different method of the Stackadapter class.
 * <br>
 * <br>
 * <strong>Test Suite Execution Records</strong>: Records are exaclty what this
 * test suite provides as result of {@link myTest.TestRunner} class.
 * <br>
 * <br>
 * <strong>Execution Variables</strong>: The variables used are two
 * Stackadapter s1 and s2, the
 * first used in all tests and the second only where necessary.In some
 * tests are then used
 * Other variables when necessary.
 * 
 * @author Davide Baggio
 * @see myAdapter.StackAdapter
 */
public class TestAddPush {

	private StackAdapter s1 = null, s2 = null;

	/**
	 * This method is performed once before each test
	 * <strong>TestAdd</strong>,
	 * Initializes an empty Stack.
	 */
	@Before
	public void setup() {
		s1 = new StackAdapter();
	}

	/**
	 * This method is performed once after each test
	 * <strong>TestAdd</strong>,
	 * Removes all the elements from the s1 Stack and places the same
	 * as null the s2 Stack.
	 */
	@After
	public void cleanup() {
		s1.clear();
		s2 = null;
	}

	/**
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#push(Object)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test conditions the functioning of the method
	 * push ().
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the functioning of the
	 * Method in basic cases, just pushing items on the stack.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: in this test some elemtns are pushed
	 * into the stack and it is verified that those are correctly added in order.
	 * Push() is checked also for subStacks.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: a s1 must have been initialized and must
	 * having been instantiated
	 * Get () and empty()
	 * Stackadapter () must work correctly.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: s1 has to contain 3 elements.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: at index 0 = "Davide", at index 1 =
	 * "DOG", at index 2 = null
	 */
	@Test
	public void testPush() {
		assertTrue(s1.empty());
		s1.push("Davide");
		assertEquals("Davide", s1.get(0));

		s1.push("DOG");
		assertEquals("DOG", s1.get(1));

		s1.push(null);
		assertNull(s1.get(2));

		s1.push("Hello");
		StackAdapter temp = (StackAdapter) s1.subList(1, 3);
		temp.push("Hello");

		assertEquals("Hello", s1.get(s1.size() - 2));
		assertEquals("Hello", s1.get(s1.size() - 1));
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#add(Object)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: The test conditions the functioning of the method
	 * add().
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: The test conditions the functioning of the
	 * method through the use of method with different objects.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>:An int and a null element are added
	 * to Stack 1 and condition it with an assertquals() and an assertnull() that
	 * the
	 * elements have been added correctly in the queue of the Stack.
	 * A new Stack is assigned to Stack 2 and a string is added to
	 * the latter, who It is conditioned with a Assertequals ().Stack 2 is added in
	 * the queue to Stack 1 and conditioned with a Assertequals(). The size of the
	 * Stack 1 to see if all objects have been correctly inserted.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: A Stack 1 must have been instantiated. The
	 * Add
	 * (Object OBJ) method and the Size () method must be working to pass the test.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: Stack 1 has 3 elements and the last of
	 * These are Stack 2 that contains
	 * a null element.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: If the test is passed it does not come
	 * launched no exceptional neither
	 * Printed no message.
	 */
	@Test
	public void testAdd() {
		s1.add(1);
		assertEquals(1, s1.get(0));

		s1.add(null);
		assertNull(s1.get(1));

		s2 = new StackAdapter();
		s2.add("Hello");
		assertEquals("Hello", s2.get(0));

		s1.add(s2);
		assertEquals(s2, s1.get(2));
		int lenght = s1.size();
		assertEquals(3, lenght);
	}

	/**
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#addAll(HCollection)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: The test conditions the functioning of the method
	 * addAll().
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: The functioning of the
	 * Method in basic cases, limit and in
	 * launch of exceptions.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the functioning of the
	 * method addAll(HCollection coll) trying to use it on a s1 passing as a
	 * parameter a s2 first equal to Null, then Initialized with the Stackadapter ()
	 * but empty and finally with some Elements added with the method
	 * Add () in a for cycle.The correct modification of the s1 before is
	 * conditioned with methods
	 * assertTrue () and isempty () When the empty s2 is passed as a parameter, then
	 * With Assertequals ()
	 * and Get () in a for cycle to compare the elements inserted in the s1 by s2
	 * with those who should have been inserted.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: a s1 must have been initialized and must
	 * having been instantiated
	 * and placed equal to Null a s2. I Methods Add (), Addall (), isEmpty (), size
	 * (),
	 * Get () e
	 * Stackadapter () must work correctly.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: s2 must have been initialized e
	 * contain elements.There
	 * s1 must contain all the elements of the s2 plus another added element
	 * separately.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed it is printed
	 * one string to capture
	 * of the exception launched by the Addall () method to which it was passed as
	 * parameter a collection
	 * Equal to Null.None of the strings related to the errors of assertive ()
	 * must have been printed.
	 */
	@Test
	public void testAddAll() {
		try {
			s1.addAll(s2);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

		s2 = new StackAdapter();
		s1.addAll(s2);
		assertTrue(s1.isEmpty());

		for (int i = 1; i < 4; i++) {
			s2.add(i);
		}
		s1.add(0);
		s1.addAll(s2);

		for (int i = 0; i < s1.size(); i++) {
			assertEquals(i, s1.get(i));
		}
	}

	/**
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#addAll(int, HCollection)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test conditions the functioning of the method
	 * Addall ().
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the functioning of the
	 * Method in basic cases, limit and in
	 * launch of exceptions.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the functioning of the
	 * Addall method (Int Index, Hcollection Coll)
	 * trying to use it on a s1 passing as a parameter a s2 first equal to
	 * Null, then
	 * Initialized with the Stackadapter () but empty and finally with gods
	 * Elements added with the method
	 * Add () in a for cycle. The method is also tried by passing as a parameter
	 * of index first one
	 * not valid location because less than 0, then one not valid because
	 * higher than size
	 * of the Stack and finally a valid one. The correct modification of the
	 * s1 first with the methods
	 * ASSERTRUE () and ISEMPTY () When the empty s2 is passed as a parameter, then
	 * With Assertequals ()
	 * and Get () in a for cycle to compare the elements inserted in the s1 by
	 * s2 with those who
	 * should have been inserted.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: a s1 must have been initialized and must
	 * having been instantiated
	 * and placed equal to Null a s2. I Methods Add (), Addall (), ISEMPTY (), SIZE
	 * (),
	 * Get () e
	 * Stackadapter () must work correctly.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: s2 must have been initialized e
	 * contain elements. There
	 * s1 must contain all the elements of the s2 plus two added elements
	 * separately.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed they are printed
	 * Only the strings to capture
	 * of the exceptions launched by the Addall () method to which they were passed
	 * as
	 * parameter a collection
	 * Equal to Null or non-valid indexes. None of the strings related to
	 * errors of
	 * Assertequals () must have been printed.
	 */
	@Test
	public void testAddAllAtIndex() {
		try {
			s1.addAll(0, s2);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

		s2 = new StackAdapter();
		s1.addAll(0, s2);
		assertTrue(s1.isEmpty());

		for (int i = 1; i < 4; i++) {
			s2.add(i);
		}
		s1.add(0);
		s1.add(4);

		try {
			s1.addAll(-1, s2);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}

		try {
			s1.addAll(3, s2);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}

		s1.addAll(1, s2);
		for (int i = 0; i < s1.size(); i++) {
			assertEquals(i, s1.get(i));
		}
	}

	/**
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#add(int, Object)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: The test conditions the functioning of the method
	 * add ().
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: The test is carried out adding
	 * different objects in different positions.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Int are added, a string and a null element
	 * to Stack 1 and
	 * is conditioned with assertequals () and an assertnull () that the elements
	 * have been added correctly and the chosen position. The insertion of an int In
	 * a position not correct to verify that the exception is correctly launched.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: A Stack 1 must have been instantiated. the
	 * method Add (int Index, Object OBJ) and the Size () method must be functional
	 * for the passing of the test.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: Stack 1 has 5 elements, 3 of which int, one
	 * string and a null.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: If the test is passed it does not come
	 * launched no exceptions and comes
	 * only one message to the capture of the exception of the Add (int
	 * Index, Object Obj)
	 * When called with an invalid index.
	 */
	@Test
	public void testAddAtIndex() {
		s1.add(0, 3);
		assertEquals(3, s1.get(0));

		s1.add(0, 2);
		assertEquals(2, s1.get(0));

		s1.add(0, 1);
		assertEquals(1, s1.get(0));

		s1.add(1, "Hello");
		assertEquals("Hello", s1.get(1));

		s1.add(3, null);
		assertNull(s1.get(3));

		try {
			s1.add(7, 10);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
		assertEquals(5, s1.size());
	}

}
