package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * <strong>Summary: Class TestInsertion</strong> checks with its tests the
 * operation of
 * Methods that insert objects on a Stack.
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: This class contains 4 tests cases who
 * tests 5 different
 * Methods of the Stackadapter class (), each of which inserts one or more
 * Elements in different positions.
 * <br>
 * <br>
 * <strong>Pre-Conditions</strong>: Before each test it must be initialized
 * at least one Stack,
 * even if empty.
 * <br>
 * <br>
 * <strong>Post-Conditions</strong>: After each test it must have been done
 * At least an insertion
 * In at least one Stack.
 * <br>
 * <br>
 * <strong>Test Cases</strong>: There are 4 tests of this class and are:
 * {@link #testPush()}, {@link #testAdd()}, {@link #testAddAll()},
 * {@link #testAddAtIndex()}
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
public class TestInsertion {

	private StackAdapter s1 = null, s2 = null;

	/**
	 * setup before each test.
	 */
	@Before
	public void setup() {
		s1 = new StackAdapter();
	}

	/**
	 * cleanup after each test
	 */
	@After
	public void cleanup() {
		s1.clear();
		s2 = null;
	}

	/**
	 * <strong> Summary </strong>: Test of
	 * {@link myAdapter.StackAdapter#push(Object)}
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
	 * <strong> pre-conditions </strong>: a s1 must have been initialized and must
	 * having been instantiated
	 * Get () and empty()
	 * Stackadapter () must work correctly.
	 * <br>
	 * <br>
	 * <strong> post-conditions </strong>: s1 has to contain 3 elements.
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
	 * <strong>Summary</strong>: Test of {@link myAdapter.StackAdapter#add(Object)}
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
	 * <strong>Pre-Conditions</strong>: A Stack 1 must have been instantiated. The
	 * Add
	 * (Object OBJ) method and the Size () method must be working to pass the test.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Stack 1 has 3 elements and the last of
	 * These are Stack 2 that contains
	 * a null element.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: If the test is passed no errors are
	 * printed and some elements are added to both stack s1 and s2.
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
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter#addAll(HCollection)} and
	 * {@link myAdapter.StackAdapter#addAll(int, HCollection)} methods
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: initially all the exception are thrown for
	 * both HCollection and
	 * HList implementation. Then a non-null collection is
	 * created in which elements are inserted. This collection is used as a
	 * parameter of the tested method invoked on a collection that already contains
	 * data to verify that the elements of the collection (parameter) are added but
	 * not removed from the main collection. Checked if an exception was thrown
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: to verify that the tested method works
	 * correctly, elements are
	 * added both to the stack used as a parameter and to the stack in which the
	 * method will be invoked (in which the elements will be inserted). These
	 * operations are carried out to verify that after the invocation of the tested
	 * method the only changes that occurred in the main collection were only the
	 * addition of the values ​​contained in the parameter collection and that no
	 * elements already present in the main collection were deleted (verified with
	 * the of the final size of the main collection which must assume a size equal
	 * to the previous one + size of the parameter collection)
	 * <br>
	 * <br>
	 * <strong>Pre-Conditions</strong>: HCollection has to be initialize as Empty
	 * and HList with
	 * data has to have data stored inside.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: all the elements contained in the
	 * collection passed as a
	 * parameter must also belong to the main collection, not considering the
	 * elements already belonging to the main collection
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: s1.containsAll(testColl) == true && stack
	 * has to contain
	 * the added HCollection
	 */
	@Test
	public void testAddAll() {
		// for the HCollections
		HCollection testColl = null;

		try {
			s1.addAll(testColl);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

		testColl = new StackAdapter();
		testColl.add(1);
		testColl.add(2);
		testColl.add(3);

		int collDim = s1.size();
		s1.addAll(testColl);
		assertTrue(s1.containsAll(testColl));
		assertEquals(collDim + testColl.size(), s1.size());

		// for the HLists
		HCollection coll;
		s2 = new StackAdapter();
		try {
			s2.addAll(0, null);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
		coll = new StackAdapter();
		try {
			s2.addAll(s2.size() + 1, coll);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}

		coll.add(8);
		coll.add(9);

		s2.add(1);
		s2.add(2);
		s2.add(3);

		s2.addAll(0, coll);
		assertArrayEquals(new Object[] { 8, 9, 1, 2, 3 }, s2.toArray());

		s2.addAll(3, coll);
		assertArrayEquals(new Object[] { 8, 9, 1, 8, 9, 2, 3 }, s2.toArray());

		s2.addAll(s2.size(), coll);
		assertArrayEquals(new Object[] { 8, 9, 1, 8, 9, 2, 3, 8, 9 }, s2.toArray());
	}

	/**
	 * <strong>Summary</strong>: Test of
	 * {@link myAdapter.StackAdapter#add(int, Object)}
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
	 * <strong>Pre-Conditions</strong>: A Stack 1 must have been instantiated. the
	 * method Add (int Index, Object OBJ) and the Size () method must be functional
	 * for the passing of the test.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Stack 1 has 5 elements, 3 of which int, one
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
