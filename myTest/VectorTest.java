package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * <strong>Summary</strong>: This test suite provides information about the
 * correct working of
 * the class {@link myAdapter.Vector}, which works as the adaptee of the
 * {@link myAdapter.StackAdapter} class
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: The design of this thest suite is all
 * about testing each
 * method of the Vector class. The reason is to isolate every type of operation
 * in order to validate each functionality.
 * <br>
 * <br>
 * 
 * <strong>Pre-conditions</strong>: J2RE 1.4.2 and JUnit 4.13.1 installed and
 * added to the path. A
 * new empty object of type ListAdapter must always be instantiated before
 * each test. All execution variables are never in an uninitialized state (i.e.
 * list = null) unless explicitly desired
 * Methods that take as parameters classes that implement HCollection are passed
 * suitable objects for this interface, therefore they do not throw the
 * exception ClassCastException.
 * All the elements contained in the list are known a priori in order to allow
 * the verification after the invocation of the tested methods
 * <br>
 * <br>
 * 
 * <strong>Post-Conditions</strong>: All the test have to provide a positive
 * outcome given true
 * logical expression
 * <br>
 * <br>
 * 
 * <strong>Test Cases</strong>:
 * {@link #testAddElement()}, {@link #testCapacity()}, {@link #testContains()},
 * {@link #testCopyInto()}, {@link #testElementAt()},
 * {@link #testEnsureCapacity()}, {@link #testFirstElement()},
 * {@link #testIndexOf()}, {@link #testInsertElementAt()},
 * {@link #testIsEmpty()}, {@link #testLastElement()},
 * {@link #testLastIndexOf()}, {@link #testRemoveElementAt()},
 * {@link #testSetElementAt()}
 * <br>
 * <br>
 * 
 * <strong>Test Suite Execution Records</strong>: Records are exaclty what this
 * test suite provides as result of {@link myTest.TestRunner} class.
 * <br>
 * <br>
 * 
 * <strong>Execution Variables</strong>: - Vector vec is the empty vector from
 * the adaptee class.
 * 
 * @author Davide Baggio
 * @see myAdapter.Vector
 */
public class VectorTest {
	Vector vec;

	/**
	 * setup before each test.
	 */
	@Before
	public void setup() {
		vec = new Vector();
	}

	/**
	 * cleanup after each test
	 */
	@After
	public void clean() {
		this.vec = null;
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.Vector#addElement(Object)} method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if elements are added
	 * to
	 * the Vector
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements have been added to the
	 * vector sequentially,
	 * then we check if the vector size and element at index 1 are present. If so
	 * the add
	 * methods works correctly
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The vector has to be initialize as empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the Vector.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: Vector.size() == 3 and Vector.elementAt(1)
	 * == 4;
	 */
	@Test
	public void testAddElement() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		assertEquals(3, vec.size());
		assertEquals(4, vec.elementAt(1));
	}

	/**
	 * <strong>Summary</strong>: Tests the {@link myAdapter.Vector#capacity()}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the capacity is
	 * grater
	 * than the size of the vector so it can store more elements.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements have been added to the
	 * vector sequentially,
	 * then the Vector.size() and Vector.capacity() are called.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The Vector has to be initialized as Empty
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the vector and more
	 * elements can be stored.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: Vector.size() < Vector.capacity()
	 */
	@Test
	public void testCapacity() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		assertTrue(vec.size() < vec.capacity());
	}

	/**
	 * <strong>Summary</strong>: Tests the {@link myAdapter.Vector#contains(Object)}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the given element
	 * is present in the Vector.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements have been added to the
	 * vector sequentially,
	 * then the Vector.contains(Object) method is called twice in order to prove
	 * that the element that has been passed is present.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the Vector
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: Vector.contains(1) == true and
	 * vector.contains(10) == false;
	 */
	@Test
	public void testContains() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		assertTrue("Element 1 is not present in the Vector", vec.contains(1));
		assertFalse("Element 10 is present in the Vector", vec.contains(10));
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.Vector#copyInto(Object[])} method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the elements are
	 * correctly copied in the given array.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements have been added to the
	 * Vector. Than a new
	 * array is created and it will be the parameter for the copyInto method. It
	 * checks if the array length is big enough to store all the elements and will
	 * print the results.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the vector and a
	 * new array with all the element is created.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: The array arr contains elements 1,4,1.
	 */
	@Test
	public void testCopyInto() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		Object[] arr = new Object[2];
		try {
			vec.copyInto(arr);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}

		Object[] arr2 = null;
		try {
			vec.copyInto(arr2);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

		arr = new Object[3];
		vec.copyInto(arr);
		for (int i = 0; i < arr.length; i++) {
			assertEquals(vec.elementAt(i), arr[i]);
		}
	}

	/**
	 * <strong>Summary</strong>: Tests the {@link myAdapter.Vector#elementAt(int)}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It returns the element at a
	 * specific index considering the fact that the index has to be less than the
	 * Vector.size().
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements are added in the Vector
	 * sequentially, then
	 * two indexes are given in order to prove that the
	 * ArrayIndexoutOfBoundException is thrown and the other index can return an
	 * element.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the vector and an
	 * element has to be returned as the result of the call to this function.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: Vector.elementAt(8) throws an Exception
	 * and
	 * Vector.elementAt(1) == 4;
	 */
	@Test
	public void testElementAt() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);
		try {
			vec.elementAt(8);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}
		assertEquals(4, vec.elementAt(1));
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.Vector#ensureCapacity(int)} method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the capacity of the
	 * vector has been increased in order to
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements have been added to the
	 * Vector sequentially.
	 * Then the capacity is checked and we increase the minCapacity by the amount we
	 * need.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the Vector and the
	 * min capacity is increased.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: n less than vec.capacity() and
	 * vec.capacity() == 100;
	 */
	@Test
	public void testEnsureCapacity() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		int n = vec.capacity();
		vec.ensureCapacity(100);

		assertTrue(n < vec.capacity());
		assertEquals(100, vec.capacity());
	}

	/**
	 * <strong>Summary</strong>: Tests the {@link myAdapter.Vector#firstElement()}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the first element
	 * is correctly returned by the call to this function. If the vec is empty
	 * NoSuchElementException is thrown.
	 * br>
	 * <br>
	 * <strong>Test Description</strong>: First the method is called to prove that
	 * the exception is
	 * thrown then we add three elements to the vector sequentially and the method
	 * is called again.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the vector and the
	 * first element is returned;
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: Vector.firstElement() == 1;
	 */
	@Test
	public void testFirstElement() {
		try {
			vec.firstElement();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NoSuchElementException.class, e.getClass());
		}

		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		assertEquals(1, vec.firstElement());
	}

	/**
	 * <strong>Summary</strong>: Tests the {@link myAdapter.Vector#indexOf(Object)},
	 * {@link myAdapter.Vector#indexOf(Object, int)} methods
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. For the first method we just
	 * check if the element is present in the Vector, then for the second method we
	 * also check if the ArrayIndexOutOfBoundException is thrown,
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements are added to the Vector
	 * sequentially. Then
	 * both of the methods are called to prove the claims as the test design
	 * explains.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the Vector and the
	 * methods have to return indexes of the object passed as paramaters.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: vec.indexOf(1) == 0 and vec.indexOf(10) ==
	 * -1 and
	 * vec.indexOf(1,1) == 2 and vec.indexOf(10,1) == -1;
	 */
	@Test
	public void testIndexOf() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		assertEquals(0, vec.indexOf(1));
		assertEquals(-1, vec.indexOf(10));
		assertEquals(2, vec.indexOf(1, 1));
		assertEquals(-1, vec.indexOf(10, 1));

		try {
			vec.indexOf(3, -1);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.Vector#insertElementAt(Object, int)}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the element is
	 * inserted in the correct position and if the ArrayIndexOutOfBoundException is
	 * thrown.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements are added to the Vector
	 * sequentially, then
	 * an element is inserted in the position of index = 2;
	 * Then another element is inserted at index = 5;
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Four elements should be present in the
	 * Vector at the end of
	 * the test.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: vec.elementAt(2) == 3 and vec.size() == 4;
	 */
	@Test
	public void testInsertElementAt() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		vec.insertElementAt(3, 2);
		assertEquals(3, vec.elementAt(2));

		try {
			vec.insertElementAt(10, 5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}

		assertEquals(4, vec.size());
	}

	/**
	 * <strong>Summary</strong>: Tests the {@link myAdapter.Vector#isEmpty()} method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if there are no
	 * elements
	 * in the Vector.
	 * br>
	 * <br>
	 * <strong>Test Description</strong>: First the method is called to prove that
	 * the Vector is
	 * Empty and then three elements are added to the Vector in order to prove that
	 * it is not empty anymore.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the vector and the
	 * Vector is not Empty;
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: Vector.isEmpty() == true and (at the end)
	 * Vector.isEmpty ==
	 * false;
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(vec.isEmpty());

		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		assertFalse(vec.isEmpty());
	}

	/**
	 * <strong>Summary</strong>: Tests the {@link myAdapter.Vector#lastElement()}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the last element
	 * is correctly returned by the call to this function. If the vec is empty
	 * NoSuchElementException is thrown.
	 * br>
	 * <br>
	 * <strong>Test Description</strong>: First the method is called to prove that
	 * the exception is
	 * thrown then we add three elements to the vector sequentially and the method
	 * is called again.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the vector and the
	 * last element is returned;
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: Vector.lastElement() == 1;
	 */
	@Test
	public void testLastElement() {
		try {
			vec.lastElement();
			throw new Exception();
		} catch (Exception e) {
			assertEquals(NoSuchElementException.class, e.getClass());
		}

		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		assertEquals(1, vec.lastElement());
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.Vector#lastIndexOf(Object)},
	 * {@link myAdapter.Vector#lastIndexOf(Object, int)} methods
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. For the first method we just
	 * check if the element is present in the Vector and return the last index of
	 * the occurance, then for the second method we also check if the
	 * IndexOutOfBoundException is thrown
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements are added to the Vector
	 * sequentially. Then
	 * both of the methods are called to prove the claims as the test design
	 * explains.
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: The three elements are correctly added to
	 * the Vector and the
	 * methods have to return the last indexes of the object passed as paramaters.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: vec.lastIndexOf(1) == 2 and
	 * vec.lastIndexOf(10) == -1 and
	 * vec.lastIndexOf(1,1) == 0 and vec.indexOf(10,1) == -1;
	 */
	@Test
	public void testLastIndexOf() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		assertEquals(2, vec.lastIndexOf(1));
		assertEquals(-1, vec.lastIndexOf(10));
		assertEquals(0, vec.lastIndexOf(1, 1));
		assertEquals(-1, vec.lastIndexOf(10, 1));

		try {
			vec.lastIndexOf(3, 10);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.Vector#removeElementAt(int)}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the element is
	 * removed from the given position and if the ArrayIndexOutOfBoundException is
	 * thrown.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements are added to the Vector
	 * sequentially, then
	 * an element is removed from the position of index = 1;
	 * Then another element is removed at index = 5;
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Two elements should be present in the
	 * Vector
	 * at the end of
	 * the test.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: vec.elementAt(1) == 1 and vec.size() == 2;
	 */
	@Test
	public void testRemoveElementAt() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		vec.removeElementAt(1);

		try {
			vec.removeElementAt(5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}

		assertEquals(1, vec.elementAt(1));
		assertEquals(2, vec.size());
	}

	/**
	 * <strong>Summary</strong>: Tests the
	 * {@link myAdapter.Vector#setElementAt(Object, int)}
	 * method
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: the design is very simple as it is related
	 * to the J2RE
	 * 1.4.2 which is an already working framework. It checks if the element is
	 * set at a given position and if the ArrayIndexOutOfBoundException is
	 * thrown.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Three elements are added to the Vector
	 * sequentially, then
	 * an element is set at position of index = 1;
	 * Then another element is set at index = 5;
	 * <br>
	 * <br>
	 * <strong>Pre-conditions</strong>: The Vector has to be initialize as Empty.
	 * <br>
	 * <br>
	 * <strong>Post-Conditions</strong>: Three elements should be present in the
	 * Vector at the end of
	 * the test.
	 * <br>
	 * <br>
	 * <strong>Expected Results</strong>: vec.elementAt(1) == 5 and vec.size() == 3;
	 */
	@Test
	public void testSetElementAt() {
		vec.addElement(1);
		vec.addElement(4);
		vec.addElement(1);

		vec.setElementAt(5, 1);

		try {
			vec.setElementAt(6, 5);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
		}

		assertEquals(5, vec.elementAt(1));
		assertEquals(3, vec.size());
	}
}
