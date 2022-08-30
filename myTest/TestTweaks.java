package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.EmptyStackException;

/**
 * <strong>Summary: Class TestTweaks</strong> controls with its
 * tests
 * The operation
 * Of the methods that inspect the objects of a stack without changing it.
 * <br>
 * <br>
 * <strong> Test Suite Design </strong>: this class contains 15 Test Cases who
 * test 15 different
 * Methods of the Stackadapter class (), each of which inspect one or more
 * elements or a feature
 * of the stack.
 * <br>
 * <br>
 * <strong> Pre-conditions </strong>: before each test it must be initialized
 * at least one stack e
 * In this elements must always be present.
 * <br>
 * <br>
 * <strong> Post-condition </strong>: after each test it must have been
 * inspected
 * at least one element
 * or a feature of the stack.
 * <br>
 * <br>
 * <strong> Test Cases </strong>: the tests of this class are:
 * {@link #testContains()}, {@link #testContainsAll()}, {@link #testEquals()},
 * {@link #testGet()}, {@link #testHashCode()}, {@link #testIndexOf()},
 * {@link #testIsEmpty()}, {@link #testLastIndexOf()}, {@link #testPeek()},
 * {@link #testSearch()}, {@link #testSet()}, {@link #testSize()},
 * {@link #testToArray()}, {@link #testToArrayInArray()},
 * {@link #testsubList()}.
 * Each of them serves to test a method different of the Stackadapter class.
 * <br>
 * <br>
 * <strong>Test Suite Execution Records</strong>: Records are exaclty what this
 * test suite provides as result of {@link myTest.TestRunner} class.
 * <br>
 * <br>
 * <strong> Execution Variables </strong>: the variables used are two
 * Stackadapter s1, s2 and sData, the
 * first used in all tests and the second only where necessary. The third has
 * data used as check stack. A
 * Object Array Arrival used
 * To insert elements on the stacks. In some tests others are then used
 * variables when necessary.
 * 
 * @author Davide Baggio
 * @see myAdapter.StackAdapter
 */
public class TestTweaks {

	StackAdapter s1 = null, s2 = null, sData = null;;
	Object[] arr = new Object[] { "Dog", "Cat", "Hello", "World", "Dog", null };

	/**
	 * setup before each test.
	 */
	@Before
	public void setup() {
		s1 = new StackAdapter();
		for (int i = 0; i < 6; i++) {
			s1.add(arr[i]);
		}

		sData = new StackAdapter();
		for (int i = 0; i < 5; i++)
			sData.push(i + 1);
	}

	/**
	 * cleanup after each test
	 */
	@After
	public void cleanup() {
		s1.clear();
		s2 = null;
		sData = null;
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter#contains(Object)} method.
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: addition of two elements, verification of
	 * the
	 * existence of an
	 * element present, verification of the existence of an element not present.
	 * Check with different types belonging to Object
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: after adding two elements, I verify that
	 * the
	 * method
	 * returns true
	 * using one of the two elements as a parameter, false using an element that
	 * does not exist in the collection as a parameter
	 * <br>
	 * <br>
	 * <strong>Pre-conditionss</strong>: HCollection has to be initialize as Empty
	 * and HList
	 * with
	 * data has to have data stored inside.
	 * <br>
	 * <br>
	 * <strong>Post-conditions</strong>: elements have been added correctly in the
	 * HCollection
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: s2.contains(1) == true &&
	 * s2.contains(4.50) == true
	 * &&
	 * s2.contains(2) == false;
	 */
	@Test
	public void testContains() {
		s2 = new StackAdapter();
		s2.add(1);
		s2.add(3);
		s2.add(4.5);

		assertTrue(s2.contains(1));
		assertTrue(s2.contains(4.50));
		assertFalse(s2.contains(2));
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.StackAdapter#containsAll(HCollection)}
	 * method.
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: elements are added to the collection on
	 * which
	 * the method will be
	 * invoked. Subsequently a collection is created that will be passed as a
	 * parameter to the tested method containing only some of the elements present
	 * in the main collection and the tested method is invoked. A value not present
	 * in the main collection is then inserted into the collection passed as a
	 * parameter and the tested method is invoked again, verifying the correctness
	 * of the returned value in both cases. The throwing of the exception in the
	 * event of a null parameter is also tested
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: after the creation and addition of some
	 * values
	 * in the collection
	 * that will be passed as a parameter, I add the same values in the main
	 * collection and verify that a true is returned (returned even in the case of
	 * an empty parameter collection). After adding a new element in the collection
	 * passed as a parameter, I check that the returned value is false
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: HCollection has to be initialize as Empty
	 * and HList with
	 * data has to have data stored inside.
	 * <br>
	 * <br>
	 * <strong>Post-conditions</strong>: Elements have been correctly added to the
	 * HCollection and it
	 * has to contain the given Collections.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: true if s2 contains the given HCollection.
	 */
	@Test
	public void testContainsAll() {
		s2 = new StackAdapter();
		try {
			s2.containsAll(null);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

		s2.add(1);
		s2.add(2);
		s2.add(3);
		s2.add(4);

		HCollection testColl = new StackAdapter();

		assertTrue(s2.containsAll(testColl));

		testColl.add(1);
		testColl.add(2);
		testColl.add(3);
		assertTrue(s2.containsAll(testColl));

		testColl.add(5);
		assertFalse(s2.containsAll(testColl));
	}

	/**
	 * <strong> Summary </strong>: Test of
	 * {@link myAdapter.StackAdapter#equals(Object)}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the method is used on a stack and the
	 * is passed
	 * as a parameter another stack that is modified in the test between the various
	 * Invocations of the method.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: the method is used on the s1 stack
	 * Equals () with the stack s2 passed as a parameter. The comparison with this
	 * method is made with the s2 stack initially equal to Null, then initialized
	 * with the Stackadapter () but empty, with the elements and finally with all
	 * the elements equal to the s1 stack. Both stacks are canceled with the method
	 * Clear () and are compared again with the Equals () method. The correct
	 * operation of the method It is controlled through the use of assertTrue
	 * methods and a variable Boolean.
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: the s1 stack must have been initialized e
	 * filled and the
	 * s2 stack must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>:both the s1 stack that the s2 stack must
	 * be
	 * empty.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: the test is passed if it does not come
	 * any error.
	 */
	@Test
	public void testEquals() {
		boolean same = s1.equals(s2);
		assertFalse(same);

		s2 = new StackAdapter();
		same = s1.equals(s2);
		assertFalse(same);

		s2.addAll(s1);
		s2.remove(s1.size() - 1);
		same = s1.equals(s2);
		assertFalse(same);

		s2.add(s1.get(s1.size() - 1));
		same = s1.equals(s2);
		assertTrue(same);

		s1.clear();
		s2.clear();
		same = s1.equals(s2);
		assertTrue(same);
	}

	/**
	 * <strong> Summary </strong>: Test of {@link myAdapter.StackAdapter#get(int)}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the functioning of the method by
	 * applying it to the s1 stack by passing valid and not valid indices.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: the functioning of the get Method
	 * Using it on the s1 stack and passing an index of 0 as parameters, a greater
	 * one of the index of the position of the last element of the stack and a valid
	 * index. They come captured the exceptions launched by the method, then
	 * controlled the element Returned by Get () with a
	 * Assertequals ().
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: it must have been initialized and filled
	 * with less than 7 Elements an s1 stack.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: the s1 stack must remain unchanged.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: the test is passed if no errors are
	 * printed
	 */
	@Test
	public void testGet() {
		try {
			s1.get(-1);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}

		try {
			s1.get(7);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}

		Object obj = s1.get(3);
		assertEquals("World", obj);
	}

	/**
	 * <strong> Summary </strong>: Test of {@link myAdapter.StackAdapter#hashCode()}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the method on two stacks is used and
	 * then
	 * Compare the returned hashcode.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: an s2 stack is initialized. Two int-type
	 * variables equal to the hash returned by the hashcode
	 * method () used on the two stacks. The two stacks are modified in the test,
	 * the Int variables are updated with the new hashcode () and controls with the
	 * Assertequals () and assertnotequals () methods that the
	 * two hashcode are the same only When the two stacks are the same.
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: the s1 stack must have been initialized e
	 * filled and the
	 * s2 stack must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: the s1 stack must have remained unchanged
	 * and The s2 stack must
	 * having been initialized and contain different elements than the s1 stack.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed no errors are
	 * printed. Hashcodes should be equal between stacks only if they contain the
	 * same elements.
	 */
	@Test
	public void testHashCode() {
		int hashCode1 = s1.hashCode();
		s2 = new StackAdapter();
		int hashCode2 = s2.hashCode();
		assertNotEquals(hashCode1, hashCode2);

		s2.addAll(s1);
		hashCode2 = s2.hashCode();
		assertEquals(hashCode1, hashCode2);

		s2.remove(null);
		hashCode2 = s2.hashCode();
		assertNotEquals(hashCode1, hashCode2);

		s2.add("House");
		hashCode2 = s2.hashCode();
		assertNotEquals(hashCode1, hashCode2);
	}

	/**
	 * <strong> Summary </strong>: Tests the
	 * {@link myAdapter.StackAdapter#indexOf(Object)} method.
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: considering the element insert in the
	 * list previously I perform
	 * three searches for single element, duplicate element, non-existent element.
	 * Search also with empty list. Exception are thrown.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: the first test is performed on an empty
	 * list, thus not returning
	 * the index containing the desired element. The following invocations are made
	 * after the insertion of values, some even repeated, specifically: invocation
	 * to find a non-repeated element, invocation to find a repeated element and
	 * invocation to find an element not contained in the list. For simplicity, the
	 * values entered are Integer
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: HList with data has to have data stored
	 * inside and list with
	 * no data initialized as Empty.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: the index of the first matching element
	 * found is returned,
	 * otherwise -1
	 * <br>
	 * <br>
	 * <strong> expected results </strong>: -1 for empty list and element not found;
	 * index of the
	 * position of the single element, searched; index of the position of the first
	 * element of the list found
	 */
	@Test
	public void testIndexOf() {
		assertEquals(-1, s1.indexOf(5));

		sData.add(2);

		assertEquals(-1, sData.indexOf(9));
		assertEquals(1, sData.indexOf(2));
		assertEquals(0, sData.indexOf(1));
		assertEquals(-1, sData.indexOf(6));
	}

	/**
	 * <strong> Summary </strong>: Test of {@link myAdapter.StackAdapter#isEmpty()}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the method on two stacks is used
	 * different to Check that it works correctly.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: the isEmpty() method is used before On
	 * the s1 stack that contains elements and then on an initialized s2 stack with
	 * the method Stackadapter () but empty and Then it contains a single Null
	 * element
	 * inserted with the Add () method. It Check that the Boolean returned by the
	 * isEmpty () method is correct through the use of methods assertTrue () E
	 * assertfalse ().
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: it must have been initialized and filled
	 * the s1 stack and instantiated an s2 stack.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: the s1 stack must remain unchanged while
	 * the s2 stack must contain only one element equal to Null.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: the test is passed if it does not come
	 * any error.
	 */
	@Test
	public void testIsEmpty() {
		assertFalse(s1.isEmpty());

		s2 = new StackAdapter();
		assertTrue(s2.isEmpty());

		s2.add(null);
		assertFalse(s2.isEmpty());
	}

	/**
	 * <strong> Summary </strong>: Test of
	 * {@link myAdapter.StackAdapter#lastIndexOf(Object)}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the method is tested using it on one
	 * stack several times with different parameters.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: the Lastindexof method () is used on s1
	 * stack multiple times passing as parameters first two objects on the stack,
	 * then one not present and finally a null element on the stack. It is
	 * controlled with assertEquals () and with the help of A variable int which
	 * the index returned by the method is the one waited.
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: it must have been initialized and filled
	 * An s1 stack.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: the s1 stack must have remained
	 * unchanged.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed no errors are
	 * printed.
	 * lastIndexOf("Hello") = 2, lastIndexOf("Dog") = 4, lastIndexOf("Davide") = -1,
	 * lastIndexOf(null) = 5
	 */
	@Test
	public void testLastIndexOf() {
		int index = s1.lastIndexOf("Hello");
		assertEquals(2, index);

		index = s1.lastIndexOf("Dog");
		assertEquals(4, index);

		index = s1.lastIndexOf("Davide");
		assertEquals(-1, index);

		index = s1.lastIndexOf(null);
		assertEquals(5, index);
	}

	/**
	 * <strong> Summary </strong>: Test of {@link myAdapter.StackAdapter#peek()}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the functioning of the
	 * Method in basic cases, just popping items from the stack. And throwing
	 * exception when needed.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: in this test some elements are
	 * already into the stack. Then the stack is peeked at, to verify that the
	 * correct elements are present on top.
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: a s1 must have been initialized and must
	 * having been instantiated with elements inside. s2 has no elements instead
	 * pop(), peek(), push(), Stackadapter () must work correctly.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: s1 has to contain 6 elements, s2 is
	 * empty.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: The item peeked are "Dog" and
	 * "Davide". For the sublist, item "World" is peeked.
	 */
	@Test
	public void testPeek() {
		s2 = new StackAdapter();
		try {
			s2.peek();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(EmptyStackException.class, e.getClass());
		}

		s1.pop();
		assertEquals("Dog", s1.peek());
		s1.push("Davide");
		assertEquals(6, s1.size());
		assertEquals("Davide", s1.peek());

		StackAdapter temp = (StackAdapter) s1.subList(1, 4);
		assertEquals("World", temp.peek());
	}

	/**
	 * <strong> Summary </strong>: Test of
	 * {@link myAdapter.StackAdapter#search(Object)}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the functioning of the
	 * Method in basic cases, just searching items from the top of stack.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: in this test some elements that are
	 * already
	 * into the stack are pushed or popped from it verifing that the item we search
	 * is in correct distance from the top of the stack. subList are also checked.
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: a s1 must have been initialized and must
	 * having been instantiated with elements inside. s2 has no elements instead
	 * empty(), pop(), push(), Stackadapter () must work correctly.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: s1 has to contain 7 elements, s2 is
	 * empty.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: Distances from top of the stack: Null =
	 * 1, World = 3, (after changes) World = 4,
	 * (subList) Hello = 1.
	 */
	@Test
	public void testSearch() {
		s2 = new StackAdapter();
		assertEquals(-1, s2.search(10));

		assertEquals(1, s1.search(null));
		assertEquals(3, s1.search("World"));

		StackAdapter temp = (StackAdapter) s1.subList(0, 3);
		assertEquals(1, temp.search("Hello"));

		s1.push("Davide");
		assertEquals(4, s1.search("World"));
	}

	/**
	 * <strong> Summary </strong>: Test of
	 * {@link myAdapter.StackAdapter#set(int, Object)}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the method on a more stack is used
	 * times passing different parameters valid and not valid.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: the set method is used more
	 * times on the s1 stack with different parameters to change the elements.
	 * The exceptions launched by the method when passing an index as a parameter
	 * of non -valid position Because less than 0 or greater or equal to the number
	 * of elements of the stack. With the
	 * Assertequals () e method the help of methods size () and Get () is checking
	 * that the size of the stack does not change and that it is inserted the
	 * element correct in the correct position.
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: it must have been initialized and filled
	 * An s1 stack.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: the size of the s1 stack must remain
	 * unchanged but
	 * Some elements must have been replaced by others.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed no errors are
	 * printed
	 */
	@Test
	public void testSet() {
		int dim = s1.size();
		Object obj = s1.set(0, null);
		assertEquals(null, s1.get(0));

		assertEquals(dim, s1.size());

		assertEquals("Dog", obj);

		try {
			s1.set(9, "Hello");
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}

		try {
			s1.set(-1, "Hello");
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}

		obj = s1.set(5, "House");
		assertEquals("House", s1.get(5));

		assertEquals(null, obj);

		assertEquals(dim, s1.size());
	}

	/**
	 * <strong> Summary </strong>: Test of {@link myAdapter.StackAdapter#size()}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the method is tested by applying it on
	 * different stacks
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: the Size () method is used first on
	 * stack s1 that contains multiple elements, then on the s2 stack initially
	 * empty and then with a element inserted with the Add () method. It is checked
	 * that the returns are those that are Wait with the method Assertequals ().
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: it must have been initialized and filled
	 * An s1 stack
	 * And an s2 stack must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: the s1 stack must remain unchanged and
	 * the
	 * s2 stack must
	 * contain only one element.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: the test is passed if it does not come
	 * any error.
	 */
	@Test
	public void testSize() {
		assertEquals(6, s1.size());

		s2 = new StackAdapter();
		assertEquals(0, s2.size());

		s2.add("Game");
		assertEquals(1, s2.size());
	}

	/**
	 * <strong> Summary </strong>: Test of {@link myAdapter.StackAdapter#toArray()}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the method on two stacks is used
	 * different for
	 * check its operation.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: an empty s2 stack is initialized and The
	 * method is used Toarray () On this to see its behavior on an empty stack. He
	 * comes Then used the method On the s1 stack that has elements and controls
	 * with the help of the Size method () that the Array created are of the same
	 * size as the stack on which it was used the method and with the help of the
	 * GET () method that contain the same elements.
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: it must have been initialized and filled
	 * an s1 stack and instantiated an s2 stack.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: the s1 stack must have remained unchanged
	 * and
	 * The s2 stack
	 * must have been initialized. An array that has the
	 * same elements of the
	 * s1 stack.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed no errors are
	 * printed. Every element in the stack has to be equal to the element in the
	 * array.
	 */
	@Test
	public void testToArray() {
		s2 = new StackAdapter();
		Object[] array = s2.toArray();
		assertEquals(s2.size(), array.length);

		array = s1.toArray();
		assertEquals(s1.size(), array.length);

		for (int i = 0; i < s1.size(); i++) {
			assertEquals(s1.get(i), array[i]);
		}
	}

	/**
	 * <strong> Summary </strong>: Test of
	 * {@link myAdapter.StackAdapter#toArray(Object[])}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: the method on different stacks is used
	 * passing different array parameters to test their behavior in the various
	 * cases.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: two different array are created. third
	 * initialized array with the Toarray method to which it
	 * comes passed as a parameter one of the first two arrays created. Are inserted
	 * Elements in Array and check that they are overwritten when these arrays are
	 * passed as parameters to the method toArray () used on one
	 * of the stacks. It is controlled with of the assertquals () that the size
	 * created with the Toarray method and correct and with
	 * methods Assertequals () and assertnull () that the elements of array created
	 * correspond to those of the stack or are the same as Null when they have to.
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: it must have been initialized and filled
	 * An s1 stack and
	 * An s2 stack must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: the s2 stack must have been initialized,
	 * The s1 stack
	 * It must have remained unchanged and three array must have been created.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed no errors are
	 * printed.
	 */
	@Test
	public void testToArrayInArray() {
		s2 = new StackAdapter();
		Object[] array1 = new Object[3];
		Object[] array2 = new Object[10];
		Object[] arrayOfStack = s2.toArray(array1);
		for (int i = 0; i < arrayOfStack.length; i++) {
			assertNull(arrayOfStack[i]);
		}
		assertEquals(3, arrayOfStack.length);

		array1[0] = 0;
		array1[1] = 1;
		arrayOfStack = s1.toArray(array1);
		assertEquals(s1.size(), arrayOfStack.length);

		for (int i = 0; i < arrayOfStack.length; i++) {
			assertEquals(s1.get(i), arrayOfStack[i]);
		}
		array2[7] = 7;
		arrayOfStack = s1.toArray(array2);
		assertEquals(array2.length, arrayOfStack.length);

		for (int i = 0; i < arrayOfStack.length; i++) {
			if (i < s1.size()) {
				assertEquals(s1.get(i), arrayOfStack[i]);
			} else {
				assertNull(arrayOfStack[i]);
			}
		}
	}

	/**
	 * <strong> Summary </strong>: Test of
	 * {@link myAdapter.StackAdapter#subList(int, int)}
	 * <br>
	 * <br>
	 * <strong> Test Case Design </strong>: a sublist is created and come
	 * Test several
	 * methods for testing the correct creation of the sublist and operation
	 * of the methods on the sublist.
	 * <br>
	 * <br>
	 * <strong> Test Description </strong>: an empty s2 stack is initialized and
	 * the subList () method with unrealized indices to verify that launch
	 * correctly the exception.
	 * The exception is captured. One is then created
	 * Empty Summary of the s2 stack then replaced by a non -empty stack of the
	 * s1 stack. Are used
	 * Various methods about the sublist to test that it has been created and
	 * functions
	 * correctly.
	 * <br>
	 * <br>
	 * <strong> Pre-conditions </strong>: it must have been initialized and filled
	 * an s1 stack and
	 * instantiated an s2 stack.
	 * <br>
	 * <br>
	 * <strong> Post-conditions </strong>: there must be an s1 stack and an s2 stack
	 * not empty
	 * <br>
	 * <br>
	 * <strong> Expected Results </strong>: The test doesn't print any error.
	 */
	@Test
	public void testsubList() {
		s2 = new StackAdapter();
		HList subStack = null;
		try {
			subStack = s2.subList(1, 3);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
		subStack = s2.subList(0, 0);
		assertEquals(s2, subStack);

		int s2dim = s2.size();
		int subStackdim = subStack.size();

		subStack.add("Dog");
		assertEquals(subStackdim + 1, subStack.size());
		assertEquals(s2dim + 1, s2.size());

		subStack = s1.subList(2, 5);

		assertFalse(subStack.containsAll(s1));
		assertEquals("Hello", subStack.get(0));

		subStackdim = subStack.size();
		assertFalse(subStack.remove("Cat"));

		try {
			subStack.remove(3);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}

		assertTrue(subStack.remove("Hello"));
		assertFalse(s1.contains("Hello"));

		subStack.add(1, "Hello");
		assertTrue(s1.contains("Hello"));
		subStack.set(0, "Cat");
		assertNotEquals(s1, subStack);
	}

}
