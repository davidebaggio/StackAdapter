package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * <strong>Class TestAdd</strong>
 * <p>
 * <br>
 * <br>
 * <strong>Summary</strong>: The Testadd class checks with its tests the
 * operation of
 * Methods that insert objects on a list.
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: This class contains 4 tests cases who
 * tests 4 different
 * Methods of the Stackadapter class (), each of which inserts one or more
 * Elements in different positions.
 * <br>
 * <br>
 * <strong>Pre-Condition</strong>: Before each test it must be initialized
 * at least one list,
 * even if empty.
 * <br>
 * <br>
 * <strong>Post-Condition</strong>: After each test it must have been done
 * At least an insertion
 * In at least one list.
 * <br>
 * <br>
 * <strong>Test Cases</strong>: There are 4 tests of this class and are:
 * testadd (),
 * Testaddatindex (), Testadall (), Testadadallatindex ().Each of them serves
 * test a
 * different method of the Stackadapter class.
 * <br>
 * <br>
 * <strong>Execution Variables</strong>: The variables used are two
 * Stackadapter L1 and L2, the
 * first used in all tests and the second only where necessary.In some
 * tests are then used
 * Other variables when necessary.
 * 
 * @author Davide Baggio
 */
public class TestAddPush {

	private StackAdapter l1 = null, l2 = null;

	/**
	 * This method is performed once before each class test
	 * <strong>TestAdd</strong>,
	 * Print a string and initializes an empty list.
	 */
	@Before
	public void setup() {
		l1 = new StackAdapter();
	}

	/**
	 * This method is performed once after each class test
	 * <strong>TestAdd</strong>,
	 * Print a string, removes all the elements from the L1 list and places the same
	 * as
	 * null the L2 list.
	 */
	@After
	public void cleanup() {
		l1.clear();
		l2 = null;
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#add(Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: The test controls the functioning of the method
	 * Add (Object Obj).
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: The test controls the functioning of the
	 * method through the use of
	 * method with different objects.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>:An int and a null element are added
	 * to list 1 and control it
	 * with an assertquals () and an assertnull () that the elements have been added
	 * correctly in the queue of the list.
	 * A new list is assigned to list 2 and a string is added to
	 * the latter, who
	 * It is controlled with a Assertequals ().List 2 is added in the queue
	 * to list 1 e
	 * controlled with a Assertequals ().The size of the
	 * List 1 to see if
	 * all objects have been correctly inserted.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: A list 1 and
	 * must have been instantiated
	 * a list 2. The Add (Object OBJ) method and the Size () method must be
	 * working
	 * to pass the test.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: List 1 has 3 elements and the last of
	 * These are list 2 that contains
	 * a null element.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: If the test is passed it does not come
	 * launched no exceptional neither
	 * Printed no message.
	 */
	@Test
	public void testAdd() {
		l1.add(1);
		assertEquals("The element" + 1 + "has not been correctly added to list 1", 1, l1.get(0));
		l1.add(null);
		assertNull("The element \" + null + \"has not been correctly added to list 1", l1.get(1));
		l2 = new StackAdapter();
		l2.add("Ciao");
		assertEquals("The \"Ciao\" element has not been correctly added to list 2", "Ciao", l2.get(0));
		l1.add(l2);
		assertEquals("The" + l2 + "element has not been correctly added to list 1", l2, l1.get(2));
		int lenght = l1.size();
		assertEquals("One or more insertions were not successful", 3, lenght);
	}

	/**
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#add(int Index, Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: The test controls the functioning of the method
	 * Add (int index, Object OBJ).
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: The test is carried out adding
	 * different objects in
	 * different positions.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Int are added, a string e
	 * a null element to list 1 e
	 * is controlled with assertionquals () and an assertnull () that the elements
	 * have been added
	 * correctly and the chosen position.The insertion of an int
	 * In a position not
	 * correct to verify that the exception is correctly launched.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: A list 1 e
	 * the method
	 * Add (int Index, Object OBJ) and the Size () method must be functional for
	 * the passing of the test.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: List 1 has 5 elements, 3 of which int, one
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
		l1.add(0, 3);
		assertEquals("The 1st element is not 3", 3, l1.get(0));
		l1.add(0, 2);
		assertEquals("The 1st element is not 2", 2, l1.get(0));
		l1.add(0, 1);
		assertEquals("The 1st element is not 1", 1, l1.get(0));
		l1.add(1, "ciao");
		assertEquals("The 2nd element is not \"ciao\"", "ciao", l1.get(1));
		l1.add(3, null);
		assertNull("The 4th element is not" + null, l1.get(3));
		try {
			l1.add(7, 10);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("It is not possible to add elements in addition to the size of the list");
			;
		}
		assertEquals("One or more insertions were not successful", 5, l1.size());
	}

	/**
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#addAll(HCollection coll)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: The test controls the functioning of the method
	 * addAll(HCollection coll).
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: The functioning of the
	 * Method in basic cases, limit and in
	 * launch of exceptions.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the functioning of the
	 * method addAll(HCollection coll)
	 * trying to use it on a L1 passing as a parameter a L2 first equal to
	 * Null, then
	 * Initialized with the Stackadapter () but empty and finally with gods
	 * Elements added with the method
	 * Add () in a for cycle.The correct modification of the L1 before is controlled
	 * with methods
	 * ASSERTRUE () and ISEMPTY () When the empty L2 is passed as a parameter, then
	 * With Assertequals ()
	 * and Get () in a for cycle to compare the elements inserted in the L1 by
	 * L2 with those who
	 * should have been inserted.
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: a L1 must have been initialized and must
	 * having been instantiated
	 * and placed equal to Null a L2.I Methods Add (), Addall (), ISEMPTY (), SIZE
	 * (),
	 * Get () e
	 * Stackadapter () must work correctly.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: L2 must have been initialized e
	 * contain elements.There
	 * L1 must contain all the elements of the L2 plus another added element
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
			l1.addAll(l2);
		} catch (NullPointerException npe) {
			System.out.println("Unable to add the elements of a Null list");
		}
		l2 = new StackAdapter();
		l1.addAll(l2);
		assertTrue("List 1 is not empty, error in adding list 2", l1.isEmpty());
		for (int i = 1; i < 4; i++) {
			l2.add(i);
		}
		l1.add(0);
		l1.addAll(l2);
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("List 2 was not correctly added to list 1", i, l1.get(i));
		}
	}

	/**
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#addAll(int index, HCollection coll)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Addall (int Index, Hcollection Coll).
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the functioning of the
	 * Method in basic cases, limit and in
	 * launch of exceptions.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the functioning of the
	 * Addall method (Int Index, Hcollection Coll)
	 * trying to use it on a L1 passing as a parameter a L2 first equal to
	 * Null, then
	 * Initialized with the Stackadapter () but empty and finally with gods
	 * Elements added with the method
	 * Add () in a for cycle. The method is also tried by passing as a parameter
	 * of index first one
	 * not valid location because less than 0, then one not valid because
	 * higher than size
	 * of the list and finally a valid one. The correct modification of the
	 * L1 first with the methods
	 * ASSERTRUE () and ISEMPTY () When the empty L2 is passed as a parameter, then
	 * With Assertequals ()
	 * and Get () in a for cycle to compare the elements inserted in the L1 by
	 * L2 with those who
	 * should have been inserted.
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: a L1 must have been initialized and must
	 * having been instantiated
	 * and placed equal to Null a L2. I Methods Add (), Addall (), ISEMPTY (), SIZE
	 * (),
	 * Get () e
	 * Stackadapter () must work correctly.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: L2 must have been initialized e
	 * contain elements. There
	 * L1 must contain all the elements of the L2 plus two added elements
	 * separately.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed they are printed
	 * Only the strings to capture
	 * of the exceptions launched by the Addall () method to which they were passed
	 * as
	 * parameter a collection
	 * Equal to Null or non -valid indexes. None of the strings related to
	 * errors of
	 * Assertequals () must have been printed.
	 */
	@Test
	public void testAddAllAtIndex() {
		try {
			l1.addAll(0, l2);
		} catch (NullPointerException npe) {
			System.out.println("Impossible to add a Null list to list 1");
		}
		l2 = new StackAdapter();
		l1.addAll(0, l2);
		assertTrue("List 1 is not empty, error in adding list 2", l1.isEmpty());
		for (int i = 1; i < 4; i++) {
			l2.add(i);
		}
		l1.add(0);
		l1.add(4);
		try {
			l1.addAll(-1, l2);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("Impossible to add a list in an index position less than 0");
		}
		try {
			l1.addAll(3, l2);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println(
					"Unable to add a list in a higher index position to the number of elements");
		}
		l1.addAll(1, l2);
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("List 2 was not correctly added to list 1", i, l1.get(i));
		}
	}

	/**
	 * 
	 */
	@Test
	public void testPush() {

	}
}
