package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.EmptyStackException;

/**
 * <strong>Class TestControlsModify</strong>
 * <p>
 * <br>
 * <br>
 * <strong>Summary</strong>: The TestControlsModify class controls with its
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
 * <strong> pre-condition </strong>: before each test it must be initialized
 * at least one stack e
 * In this elements must always be present.
 * <br>
 * <br>
 * <strong> post-condition </strong>: after each test it must have been
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
 * Stackadapter s1 and s2, the
 * first used in all tests and the second only where necessary, and a
 * Object Array Arrival used
 * To insert elements on the stacks. In some tests others are then used
 * variables when necessary.
 * 
 * @author Davide Baggio
 */
public class TestControlsModify {

	StackAdapter s1 = null, s2 = null;
	Object[] arr = new Object[] { "Dog", "Cat", "Hello", "World", "Dog", null };

	/**
	 * This method is performed once before each test
	 * <strong> TestControlsModify </strong>,
	 * Initializes and adds elements to a stack.
	 */
	@Before
	public void setup() {
		s1 = new StackAdapter();
		for (int i = 0; i < 6; i++) {
			s1.add(arr[i]);
		}

	}

	/**
	 * This method is performed once after each test
	 * <strong> TestControlsModify </strong>,
	 * Removes all the elements from the s1 stack and places the
	 * same as null the s2 stack.
	 */
	@After
	public void cleanup() {
		s1.clear();
		s2 = null;
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#contains(Object)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Contains ()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method on a more stack is used
	 * times passing different parameters.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the Contains method on the s1 stack
	 * is used passing like Parameters different objects contained and not
	 * contained. A stack is
	 * initialized s2 with the method Stackadapter (), elements are added with the
	 * Add () method and yes
	 * adds the s2 stack to s1 stack. It is controlled with Contains if the s2 stack
	 * is contained in the
	 * stack s1. Through the use of of the assertTrue methods () and assertfalse (),
	 * with the help of a variable
	 * Boolean, check that the elements passed as parameters are contained in the s1
	 * stack or not.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * A s1 stack e
	 * instantiated an s2 stack.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s2 stack must contain 2 elements and
	 * the s1 stack must contain all the initial elements to which the s2 stack is
	 * added.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed there are no
	 * errors. Elements in s2 are present in s1.
	 */
	@Test
	public void testContains() {
		boolean content = s1.contains("Horse");
		assertFalse(content);

		content = s1.contains(null);
		assertTrue(content);

		content = s1.contains("Hello");
		assertTrue(content);

		s2 = new StackAdapter();
		s2.add("Davide");
		s2.add("Baggio");
		s1.add(s2);
		content = s1.contains(s2);
		assertTrue(content);
	}

	/**
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#containsAll(HCollection)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * ContainsAll ()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method is used several times on one
	 * stack passing as a parameter another stack that is modified between the
	 * various invocations of the method.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the method is used several times on s1
	 * stack passing as a parameter an s2 stack initially the same as Null, then
	 * initialized with The Stackadapter method () But empty, with only objects
	 * belonging to the s1 stack inserted on the s2 stack with the Add () method And
	 * finally also with objects not belonging to the s1 stack. Is captured An
	 * exception launched by Containinsall Method () to which the s2 stack is passed
	 * as a parameter equal to Null And one is printed Notice string of the capture
	 * of the exception. Through the use of methods asserttrue () E assertfalse ()
	 * and the aid of a Boolean variable is controlled that the Boolean returned
	 * from the method ContainsAll () is correct in the various uses.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * A s1 stack and
	 * An s2 stack must have been instantiated and placed equal to Null.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 stack must have remained unchanged
	 * and
	 * The s2 stack must
	 * have been initialized and contain elements on the s1 and a
	 * element not present
	 * In the s1 stack.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed nothing is
	 * printed. s1 contains all elements in s2 until element "House" is added.
	 */
	@Test
	public void testContainsAll() {
		boolean content = false;
		try {
			content = s1.containsAll(s2);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

		s2 = new StackAdapter();
		content = s1.containsAll(s2);
		assertTrue(content);

		s2.add("Hello");
		s2.add("Dog");
		content = s1.containsAll(s2);
		assertTrue(content);

		s2.add("Hello");
		s2.add("Hello");
		content = s1.containsAll(s2);
		assertTrue(content);

		s2.add("House");
		content = s1.containsAll(s2);
		assertFalse(content);
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#equals(Object)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Equals ()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method is used on a stack and the
	 * is passed
	 * as a parameter another stack that is modified in the test between the various
	 * Invocations of the method.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the method is used on the s1 stack
	 * Equals () with the stack s2 passed as a parameter. The comparison with this
	 * method is made with the s2 stack initially equal to Null, then initialized
	 * with the Stackadapter () but empty, with the elements and finally with all
	 * the elements equal to the s1 stack. Both stacks are canceled with the method
	 * Clear () and are compared again with the Equals () method. The correct
	 * operation of the method It is controlled through the use of assertTrue
	 * methods and a variable Boolean.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: the s1 stack must have been initialized e
	 * filled and the
	 * s2 stack must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>:both the s1 stack that the s2 stack must be
	 * empty.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: the test is passed if it does not come
	 * any error.
	 */
	@Test
	public void testEquals() {
		boolean uguali = s1.equals(s2);
		assertFalse(uguali);

		s2 = new StackAdapter();
		uguali = s1.equals(s2);
		assertFalse(uguali);

		s2.addAll(s1);
		s2.remove(s1.size() - 1);
		uguali = s1.equals(s2);
		assertFalse(uguali);

		s2.add(s1.get(s1.size() - 1));
		uguali = s1.equals(s2);
		assertTrue(uguali);

		s1.clear();
		s2.clear();
		uguali = s1.equals(s2);
		assertTrue(uguali);
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#get(int)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Get ()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the functioning of the method by
	 * applying it to the s1 stack by passing valid and not valid indices.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the functioning of the get Method
	 * Using it on the s1 stack and passing an index of 0 as parameters, a greater
	 * one of the index of the position of the last element of the stack and a valid
	 * index. They come captured the exceptions launched by the method, then
	 * controlled the element Returned by Get () with a
	 * Assertequals ().
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * with less than 7 Elements an s1 stack.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 stack must remain unchanged.
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
	 * <strong>Test of {@link myAdapter.StackAdapter#hashCode()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * hashcode()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method on two stacks is used and
	 * then
	 * Compare the returned hashcode.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: an s2 stack is initialized. Two int-type
	 * variables equal to the hash returned by the hashcode
	 * method () used on the two stacks. The two stacks are modified in the test,
	 * the Int variables are updated with the new hashcode () and controls with the
	 * Assertequals () and assertnotequals () methods that the
	 * two hashcode are the same only When the two stacks are the same.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: the s1 stack must have been initialized e
	 * filled and the
	 * s2 stack must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 stack must have remained unchanged
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
	 * <strong>Test of {@link myAdapter.StackAdapter#indexOf(Object)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Indexof ()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method is tested using it on one
	 * stack several times with different parameters.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the Indexof () method is used on stack
	 * s1 several times passing as parameters first two objects on the stack, then
	 * one not present and finally a Null element on the stack. It is controlled
	 * with assertEquals () e with the help of
	 * A variable int which the index returned by the method is the one waited.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * An s1 stack.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 stack must have remained unchanged.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed no errors are
	 * printed.
	 * indexOf("Hello") = 2, indexOf("Dog") = 0, indexOf("Davide") = -1,
	 * indexOf(null) = 5
	 */
	@Test
	public void testIndexOf() {
		int index = s1.indexOf("Hello");
		assertEquals(2, index);

		index = s1.indexOf("Dog");
		assertEquals(0, index);

		index = s1.indexOf("Davide");
		assertEquals(-1, index);

		index = s1.indexOf(null);
		assertEquals(5, index);
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#isEmpty()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * isEmpty().
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method on two stacks is used
	 * different to Check that it works correctly.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the isEmpty() method is used before On
	 * the s1 stack that contains elements and then on an initialized s2 stack with
	 * the method Stackadapter () but empty and Then it contains a single Null
	 * element
	 * inserted with the Add () method. It Check that the Boolean returned by the
	 * isEmpty () method is correct through the use of methods assertTrue () E
	 * assertfalse ().
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * the s1 stack and instantiated an s2 stack.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 stack must remain unchanged while
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
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#lastIndexOf(Object)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Lastindexof ()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method is tested using it on one
	 * stack several times with different parameters.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the Lastindexof method () is used on s1
	 * stack multiple times passing as parameters first two objects on the stack,
	 * then one not present and finally a null element on the stack. It is
	 * controlled with assertEquals () and with the help of A variable int which
	 * the index returned by the method is the one waited.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * An s1 stack.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 stack must have remained unchanged.
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
	 * <strong>Test of {@link myAdapter.StackAdapter#peek()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: this test conditions the functioning of the
	 * method
	 * peek ().
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the functioning of the
	 * Method in basic cases, just popping items from the stack. And throwing
	 * exception when needed.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: in this test some elements are
	 * already into the stack. Then the stack is peeked at, to verify that the
	 * correct elements are present on top.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: a s1 must have been initialized and must
	 * having been instantiated with elements inside. s2 has no elements instead
	 * pop(), peek(), push(), Stackadapter () must work correctly.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: s1 has to contain 6 elements, s2 is empty.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: The item peeked are "Dog" and
	 * "Davide".
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
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#search(Object)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: this test conditions the functioning of the
	 * method
	 * search ().
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the functioning of the
	 * Method in basic cases, just searching items from the top of stack.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: in this test some elements that are
	 * already
	 * into the stack are pushed or popped from it verifing that the item we search
	 * is in correct distance from the top of the stack. subList are also checked.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: a s1 must have been initialized and must
	 * having been instantiated with elements inside. s2 has no elements instead
	 * empty(), pop(), push(), Stackadapter () must work correctly.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: s1 has to contain 7 elements, s2 is empty.
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
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#set(int, Object)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * set()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method on a more stack is used
	 * times passing different parameters valid and not valid.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the set method is used more
	 * times on the s1 stack with different parameters to change the elements.
	 * The exceptions launched by the method when passing an index as a parameter
	 * of non -valid position Because less than 0 or greater or equal to the number
	 * of elements of the stack. With the
	 * Assertequals () e method the help of methods size () and Get () is checking
	 * that the size of the stack does not change and that it is inserted the
	 * element correct in the correct position.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * An s1 stack.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the size of the s1 stack must remain
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
	 * <strong>Test of {@link myAdapter.StackAdapter#size()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * size ()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method is tested by applying it on
	 * different stacks
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the Size () method is used first on
	 * stack s1 that contains multiple elements, then on the s2 stack initially
	 * empty and then with a element inserted with the Add () method. It is checked
	 * that the returns are those that are Wait with the method Assertequals ().
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * An s1 stack
	 * And an s2 stack must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 stack must remain unchanged and the
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
		s2.add(null);
		assertEquals(1, s2.size());
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#toArray()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Toarray ()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method on two stacks is used
	 * different for
	 * check its operation.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: an empty s2 stack is initialized and
	 * The method is used
	 * Toarray () On this to see its behavior on an empty stack. He comes
	 * Then used the method
	 * On the s1 stack that has elements and controls with the help of the
	 * Size method () that the
	 * Array created are of the same size as the stack on which it was used
	 * the method and with
	 * the help of the GET () method that contain the same elements.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * A s1 stack e
	 * instantiated an s2 stack.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 stack must have remained unchanged
	 * e
	 * The s2 stack
	 * must have been initialized. An array that has the
	 * same elements of the
	 * s1 stack.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed it must not be
	 * was printed
	 * No string because all linked to the errors of assertive methods ().
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
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#toArray(Object[] arrayTarget)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Toarray (Object [] Arraytarget)
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method on different stacks is used
	 * passing like
	 * different array parameters to test their behavior in the various cases.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: two array of different are created
	 * dimensions. He comes
	 * Created a third initialized array with the Toarray method (Object []
	 * arrays) to which it comes
	 * passed as a parameter one of the first two arrays created. Are inserted
	 * Elements in Array
	 * and check that they are overwritten when these arrays are passed
	 * as parameters to the method
	 * TOARRAY (OBJECT [] Arrayarget) used on one of the stacks. It is controlled
	 * with
	 * of the assertquals () that the
	 * Axor size created with the Toarray method (Object [] Arraytarget) and
	 * correct and with methods
	 * Assertequals () and assertnull () that the elements of array created
	 * correspond to those of the stack
	 * or are the same as Null when they have to.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * A s1 stack e
	 * An s2 stack must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s2 stack must have been initialized,
	 * The s1 stack
	 * It must have remained unchanged and three array must have been created.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed it does not come
	 * any printed
	 * string because all linked to the errors of assertive methods () e
	 * assertnull ().
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
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#subList(int fromIndex, int toIndex)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the function of the method
	 * subList (Int Fromindex, Int Tindex)
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: a undergroundist is created and come
	 * Test several
	 * methods for testing the correct creation of the undergroundist and operation
	 * of the methods on the undergroundist.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: an empty s2 stack is initialized and
	 * You feel on this
	 * the subList () method with unrealized indices to verify that launch
	 * correctly the exception.
	 * The exception is captured and a notice string is printed
	 * capture. One is then created
	 * Empty Summary of the s2 stack then replaced by a non -empty stack of the
	 * s1 stack. Are used
	 * Various methods about the subtivation to test that it has been created and
	 * functions
	 * correctly. The correct
	 * functioning of the methods on the undergroundist is controlled with the
	 * methods
	 * ASSERTRUE (), ASSERTFALSE (),
	 * Assertequals () and assertnotequals ().
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: it must have been initialized and filled
	 * A s1 stack e
	 * instantiated an s2 stack.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: there must be an s1 stack and an s2 stack
	 * not empty and one
	 * Sub -non -empty subtate and an empty sub2 Sub2.
	 * <br>
	 * <br>
	 * <strong> Expected Results </strong>: for passing the test they must be
	 * Printed only
	 * the strings of capture of exceptions but not the strings related to errors
	 * of the assertive methods (),
	 * Assertfalse (), Assertequals () and assertnotequals ().
	 */
	@Test
	public void testsubList() {
		s2 = new StackAdapter();
		HList sub = null;
		try {
			sub = s2.subList(1, 3);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
		sub = s2.subList(0, 0);
		assertEquals(s2, sub);
		int dim2 = s2.size();
		int dimsub = sub.size();
		// System.out.println(dim2 + " " + dimsub);
		sub.add("Dog");
		assertEquals(dimsub + 1, sub.size());
		assertEquals(dim2 + 1, s2.size());
		sub = s1.subList(2, 5);
		// System.out.println(sub);
		assertTrue(s1.containsAll(sub));
		assertFalse(sub.containsAll(s1));
		assertEquals("Hello", sub.get(0));
		int dim = s1.size();
		dimsub = sub.size();
		assertFalse(sub.remove("Cat"));
		assertEquals(dim, s1.size());
		assertEquals(dimsub, sub.size());
		try {
			sub.remove(3);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
		assertTrue(sub.contains("Hello"));
		assertTrue(sub.remove("Hello"));
		assertEquals(dim - 1, s1.size());
		assertEquals(dimsub - 1, sub.size());
		assertFalse(s1.contains("Hello"));
		sub.add(1, "Hello");
		assertTrue(s1.contains("Hello"));
		sub.set(0, "Cat");
		assertFalse(s1.contains("World"));
		assertNotEquals(s1, sub);
		HListIterator iter = sub.listIterator();
		assertFalse(iter.hasPrevious());
		assertEquals("Cat", iter.next());
		dim = s1.size();
		dimsub = sub.size();
		iter.add("House");
		assertEquals(dim + 1, s1.size());
		assertEquals(dimsub + 1, sub.size());
		HList sub2 = sub.subList(1, 3);
		int dimsub2 = sub2.size();
		dimsub = sub.size();
		dim = s1.size();
		sub2.clear();
		assertTrue(sub2.isEmpty());
		assertFalse(sub.isEmpty());
		assertEquals(dimsub - dimsub2, sub.size());
		assertEquals(dim - dimsub2, s1.size());
	}

}