package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * <strong>Class TestDiControllo</strong>
 * <p>
 * <br>
 * <br>
 * <strong>Summary</strong>: The Testicontrollo class controls with its tests
 * The operation
 * Of the methods that inspect the objects of a list without changing it.
 * <br>
 * <br>
 * <strong> Test Suite Design </strong>: this class contains 9 Test Cases who
 * Tesse 9 different
 * Methods of the Stackadapter class (), each of which inspect one or more
 * elements or a feature
 * of the list.
 * <br>
 * <br>
 * <strong> pre-control </strong>: before each test it must be initialized
 * at least one list e
 * In this elements must always be present.
 * <br>
 * <br>
 * <strong> post-condition </strong>: after each test it must have been
 * inspected
 * at least one element
 * or a feature of the list.
 * <br>
 * <br>
 * <strong> Test Cases </strong>: the tests of this class are 9 and are:
 * testsize (),
 * Testisempty (), Testget (), Testindexof (), Testlastindexof (), Testcontains
 * (),
 * testcontinsall (),
 * Testequals () and Testhashcode (). Each of them serves to test a method
 * Different of the Stackadapter class.
 * <br>
 * <br>
 * <strong> Execution Variables </strong>: the variables used are two
 * Stackadapter L1 and L2, the
 * first used in all tests and the second only where necessary, and a
 * Object Array Arrival used
 * To insert elements on the lists. In some tests others are then used
 * variables when necessary.
 * 
 * @author Davide Baggio
 */
public class TestDiControllo {

	StackAdapter l1 = null, l2 = null;
	Object[] arr = new Object[] { "Pippo", "Pluto", "Paperino", "Topolino", "Pippo", null };

	/**
	 * This method is performed once before each class test
	 * <strong> TestDiControllo </strong>,
	 * Print a string and initializes and adds elements to a list.
	 */
	@Before
	public void setup() {
		l1 = new StackAdapter();
		for (int i = 0; i < 6; i++) {
			l1.add(arr[i]);
		}

	}

	/**
	 * This method is performed once after each class test
	 * <strong> TestDiControllo </strong>,
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
	 * <strong>Test of {@link myAdapter.StackAdapter#size()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * size ()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method is tested by applying it on
	 * different lists
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the Size () method is used first on
	 * list l1 that
	 * contains multiple elements, then on the L2 list initially empty and then with
	 * a
	 * element inserted with
	 * the Add () method. It is checked that the returns are those that are
	 * Wait with the method
	 * Assertequals ().
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: it must have been initialized and filled
	 * An L1 list
	 * And an L2 list must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the L1 list must remain unchanged and the
	 * L2 list must
	 * contain only one element.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: the test is passed if it does not come
	 * any printed
	 * string because all linked to the errors of the Assertequals method ().
	 */
	@Test
	public void testSize() {
		assertEquals("The size of list 1 is not 6", 6, l1.size());
		l2 = new StackAdapter();
		assertEquals("List 2 is not empty", 0, l2.size());
		l2.add(null);
		assertEquals("List 2 does not contain an element", 1, l2.size());
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#isEmpty()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * ISEMPTY ().
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method on two lists is used
	 * different for
	 * Check that it works correctly.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the ISEMPTY () method is used before
	 * On the L1 list that
	 * contains elements and then on an initialized L2 list with the method
	 * Stackadapter () but empty e
	 * Then it contains a single Null element inserted with the Add () method. Yup
	 * Check that the Boolean
	 * returned by the ISEMPTY () method is correct through the use of methods
	 * ASSERTRUE () E
	 * assertfalse ().
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: it must have been initialized and filled
	 * A L1 list e
	 * instantiated an L2 list.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the L1 list must remain unchanged while
	 * the
	 * L2 list must
	 * contain only one element equal to Null.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: the test is passed if it does not come
	 * any printed
	 * string because all linked to the errors of the assertTrue () and assertfalse
	 * ().
	 */
	@Test
	public void testIsEmpty() {
		assertFalse("List 1 is empty", l1.isEmpty());
		l2 = new StackAdapter();
		assertTrue("List 2 is not empty", l2.isEmpty());
		l2.add(null);
		assertFalse("List 2 is empty", l2.isEmpty());
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#get(int index)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Get (int index)
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the functioning of the
	 * method by applying it
	 * to the L1 list by passing valid and not valid indices.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the functioning of the
	 * GET Method ()
	 * Using it on the L1 list and passing an index of 0 as parameters,
	 * a greater one of the index
	 * of the position of the last element of the list and a valid index. They come
	 * captured the exceptions
	 * launched by the method and printed of the warning strings, then
	 * controlled the element
	 * Returned by Get () with a Assertequals ().
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: it must have been initialized and filled
	 * with less than
	 * 7 Elements an L1 list.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the L1 list must remain unchanged.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed they are printed
	 * Two strings
	 * of the notice of capture of the exceptions but not the string linked to the
	 * error of the
	 * Assertequals method ().
	 */
	@Test
	public void testGet() {
		try {
			l1.get(-1);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
		try {
			l1.get(7);
			throw new Exception();
		} catch (Exception e) {
			assertEquals(IndexOutOfBoundsException.class, e.getClass());
		}
		Object obj = l1.get(3);
		assertEquals("The inspected element is not Topolino", "Topolino", obj);
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#indexOf(Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Indexof (Object Obj)
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method is tested using it on one
	 * List several times
	 * with different parameters.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the Indexof () method is used on
	 * list l1 several times
	 * passing as parameters first two objects on the list, then one not
	 * present and finally a
	 * Null element on the list. It is controlled with assertionquals () e
	 * with the help of
	 * A variable int which the index returned by the method is the one waited.
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: it must have been initialized and filled
	 * An L1 list.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the L1 list must have remained unchanged.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed it does not come
	 * any printed
	 * string because all related to the errors of the Assertequals method ().
	 */
	@Test
	public void testIndexOf() {
		int index = l1.indexOf("Paperino");
		assertEquals("The Index of the object \"Paperino\" is not 2", 2, index);
		index = l1.indexOf("Pippo");
		assertEquals("The Index of the object \"Pippo\" is not 0", 0, index);
		index = l1.indexOf("Davide");
		assertEquals("The element \"Davide\" It is present in the list", -1, index);
		index = l1.indexOf(null);
		assertEquals("The Null element is not present", 5, index);
	}

	/**
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#lastIndexOf(Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Lastindexof (Object Obj)
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method is tested using it on one
	 * List several times
	 * with different parameters.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the Lastindexof method () is used on
	 * L1 list plus
	 * times passing as parameters first two objects on the list, then one
	 * not present and finally
	 * a null element on the list. It is controlled with assertionquals ()
	 * and with the help of
	 * A variable int which the index returned by the method is the one waited.
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: it must have been initialized and filled
	 * An L1 list.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the L1 list must have remained unchanged.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed it does not come
	 * any printed
	 * string because all linked to the errors of the Assertequals method ().
	 */
	@Test
	public void testLastIndexOf() {
		int index = l1.lastIndexOf("Paperino");
		assertEquals("The Index of the object \"Paperino\" is not 2", 2, index);
		index = l1.lastIndexOf("Pippo");
		assertEquals("The Index of the object \"Pippo\" is not 0", 4, index);
		index = l1.lastIndexOf("Davide");
		assertEquals("The element \"Davide\" It is present in the list", -1, index);
		index = l1.lastIndexOf(null);
		assertEquals("The Null element is not present", 5, index);
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#contains(Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Contains (Object Obj)
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method on a more list is used
	 * times passing
	 * different parameters.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the Contains method () on the L1 list is
	 * used
	 * passing like
	 * Parameters different objects contained and not contained. A list is
	 * initialized
	 * L2 with the method
	 * Stackadapter (), elements are added with the Add () method and yes
	 * adds the L2 list to
	 * L1 list. It is controlled with Contains if the L2 list is contained in the
	 * list
	 * L1. Through the use of
	 * of the assertTrue methods () and assertfalse (), with the help of a variable
	 * Boolean, check that
	 * the elements passed as parameters are contained in the L1 list or not.
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: it must have been initialized and filled
	 * A L1 list e
	 * instantiated an L2 list.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the L2 list must contain 2 elements and
	 * the
	 * L1 list must
	 * contain all the initial elements to which the L2 list is added.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed it must not be
	 * any printed
	 * string because all linked to the errors of the assertTrue methods () e
	 * assertfalse ().
	 */
	@Test
	public void testContains() {
		boolean contenuto = l1.contains("Peppino");
		assertFalse(contenuto);
		contenuto = l1.contains(null);
		assertTrue(contenuto);
		contenuto = l1.contains("Paperino");
		assertTrue(contenuto);
		l2 = new StackAdapter();
		l2.add("Davide");
		l2.add("Baggio");
		l1.add(l2);
		contenuto = l1.contains(l2);
		assertTrue(contenuto);
	}

	/**
	 * <strong>Test of
	 * {@link myAdapter.StackAdapter#containsAll(HCollection coll)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Containinsall (Hcollection Coll)
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method is used several times on one
	 * list passing
	 * as a parameter another list that is modified between the various invocations
	 * of the method.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the method is used several times on
	 * L1 list passing
	 * as a parameter an L2 list initially the same as Null, then initialized with
	 * The Stackadapter method ()
	 * But empty, with only objects belonging to the L1 list inserted on the L2 list
	 * with the Add () method
	 * And finally also with objects not belonging to the L1 list. Is captured
	 * An exception launched by
	 * Containinsall Method () to which the L2 list is passed as a parameter equal
	 * to Null
	 * And one is printed
	 * Notice string of the capture of the exception. Through the use of methods
	 * ASSERTRUE () E
	 * assertfalse () and the aid of a Boolean variable is controlled that the
	 * Boolean returned from the method
	 * Containsall () is correct in the various uses.
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: it must have been initialized and filled
	 * A L1 list e
	 * An L2 list must have been instantiated and placed equal to Null.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the L1 list must have remained unchanged e
	 * The L2 list must
	 * have been initialized and contain elements on the L1 and a
	 * element not present
	 * In the L1 list.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed it is printed
	 * Just a string
	 * to the capture of the exception launched by the Containinsall () method and
	 * none of the
	 * strings related to
	 * errors of the assertTrue methods () and assertfalse ().
	 */
	@Test
	public void testContainsAll() {
		boolean contenuto = false;
		try {
			contenuto = l1.containsAll(l2);
		} catch (NullPointerException npe) {
			System.out.println("La lista 2 è uguale a null");
		}
		l2 = new StackAdapter();
		contenuto = l1.containsAll(l2);
		assertTrue("Non tutti gli elementi della lista 2 sono presenti nella lista 1", contenuto);
		l2.add("Paperino");
		l2.add("Pippo");
		contenuto = l1.containsAll(l2);
		assertTrue("Non tutti gli elementi della lista 2 sono presenti nella lista 1", contenuto);
		l2.add("Paperino");
		l2.add("Paperino");
		contenuto = l1.containsAll(l2);
		assertTrue("Non tutti gli elementi della lista 2 sono presenti nella lista 1", contenuto);
		l2.add("Ciccio");
		contenuto = l1.containsAll(l2);
		assertFalse("La lista 1 contiene tutti gli elementi della lista 2", contenuto);
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#equals(Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * Equals (Object Obj)
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method is used on a list and the
	 * is passed
	 * as a parameter another list that is modified in the test between the various
	 * Invocations of the method.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the method is used on the L1 list
	 * Equals () with the list
	 * L2 passed as a parameter. The comparison with this method is made with the
	 * L2 list initially
	 * equal to Null, then initialized with the Stackadapter () but empty, with
	 * of the elements and finally
	 * with all the elements equal to the L1 list. Both are canceled
	 * lists with the method
	 * Clear () and are compared again with the Equals () method. The correct
	 * operation of the method
	 * It is controlled through the use of assertTrue methods () e
	 * ASSERTRUE () and a variable
	 * Boolean.
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: the L1 list must have been initialized e
	 * filled and the
	 * L2 list must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the L2 list must have been initialized
	 * and both the
	 * L1 list that the L2 list must be empty.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: the test is passed if it does not come
	 * any printed
	 * string because all linked to the error messages of the assertTrue methods ()
	 * e
	 * assertfalse ().
	 */
	@Test
	public void testEquals() {
		boolean uguali = l1.equals(l2);
		assertFalse("La lista 1 è uguale alla lista 2", uguali);
		l2 = new StackAdapter();
		uguali = l1.equals(l2);
		assertFalse("La lista 1 è uguale alla lista 2", uguali);
		l2.addAll(l1);
		l2.remove(l1.size() - 1);
		uguali = l1.equals(l2);
		assertFalse("La lista 1 è uguale alla lista 2", uguali);
		l2.add(l1.get(l1.size() - 1));
		uguali = l1.equals(l2);
		assertTrue("La lista 1 è diversa dalla lista 2", uguali);
		l1.clear();
		l2.clear();
		uguali = l1.equals(l2);
		assertTrue("La lista 1 è diversa dalla lista 2", uguali);
	}

	/**
	 * <strong>Test of {@link myAdapter.StackAdapter#hashCode()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of the method
	 * hashcode ()
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: the method on two lists is used and
	 * they come
	 * Compare the returned INS.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: an L2 list is initialized and come
	 * Initialized
	 * Two INT -type variables equal to the IND returned by the hashcode method ()
	 * used on the two lists.
	 * The two lists are modified in the test, the Int variables are updated
	 * with the new hashcode ()
	 * and controls with the Assertequals () and assertnotequals () methods that the
	 * two
	 * hashcode are the same only
	 * When the two lists are the same.
	 * <br>
	 * <br>
	 * <strong> pre-control </strong>: the L1 list must have been initialized e
	 * filled and the
	 * L2 list must have been instantiated.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the L1 list must have remained unchanged e
	 * The L2 list must
	 * having been initialized and contain elements other than the L1 list.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed it must not be
	 * was printed
	 * no string because all linked to the errors of assertTrue methods () e
	 * assertnotequals ().
	 */
	@Test
	public void testHashCode() {
		int hashCode1 = l1.hashCode();
		l2 = new StackAdapter();
		int hashCode2 = l2.hashCode();
		assertNotEquals("Gli hashCode delle due liste diverse sono uguali", hashCode1, hashCode2);
		l2.addAll(l1);
		hashCode2 = l2.hashCode();
		assertEquals("Gli hashCode delle due liste uguali sono diversi", hashCode1, hashCode2);
		l2.remove(null);
		hashCode2 = l2.hashCode();
		assertNotEquals("Gli hashCode delle due liste diverse sono uguali", hashCode1, hashCode2);
		l2.add("Ciccio");
		hashCode2 = l2.hashCode();
		assertNotEquals("Gli hashCode delle due liste diverse sono uguali", hashCode1, hashCode2);
	}
}
