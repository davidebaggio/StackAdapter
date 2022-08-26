package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * <strong>Class TestIterator</strong>
 * <p>
 * <br>
 * <br>
 * <strong> Summary </strong>: the textite -class class controls with its tests
 * the functioning of
 * Methods that build iterators and methods of the iterators themselves.
 * <br>
 * <br>
 * <strong> Test Suite Design </strong>: this class contains 3 TEST CASES that
 * Tesse 3 different
 * Methods of the Stackadapter class (), each of which builds a
 * iterator for a collection or for
 * A list. If it is an iterator of a list, it can be built in
 * a different position.
 * <br>
 * <br>
 * <strong> pre-condition </strong>: before each test it must be initialized
 * at least one list e
 * In this elements must always be present.
 * <br>
 * <br>
 * <strong> post-condition </strong>: after each test it must have been created
 * at least one iterator for
 * At least one list and his methods must have been tried.
 * <br>
 * <br>
 * <strong> Test Cases </strong>: The tests of this class are 3 and are:
 * Testitherator (),
 * Testlistiterator (), Testlistiterataratindex (). Each of them serves
 * test a different method
 * of the Stackadapter class and some of the methods of the iterators.
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
 * To insert elements on the lists. In some tests others are then used
 * variables when necessary.
 * 
 * @author Davide Baggio
 */
public class TestIterator {

    StackAdapter s1 = null, s2 = null;
    Object[] arr = new Object[] { "Pippo", "Pluto", "Paperino", "Topolino", "Pippo", null };

    /**
     * This method is performed once before each class test
     * <strong> TestIterator </strong>,
     * Print a string and initializes and adds elements to a list.
     */
    @Before
    public void setup() {
        s1 = new StackAdapter();
        for (int i = 0; i < 6; i++) {
            s1.add(arr[i]);
        }

    }

    /**
     * This method is performed once after each class test
     * <strong> TestIterator </strong>,
     * Print a string, removes all the elements from the s1 list and places the same
     * as
     * null the s2 list.
     */
    @After
    public void cleanup() {
        s1.clear();
        s2 = null;
    }

    /**
     * <strong>Test of {@link myAdapter.StackAdapter#iterator()} and methods
     * of the iterator</strong>
     * <p>
     * <br>
     * <br>
     * <strong> Summary </strong>: the test controls the functioning of the method
     * iterator () and gods
     * Methods of the Hydrust of a Collection.
     * <br>
     * <br>
     * <strong> test case design </strong>: an iterator is created on a list e
     * are used
     * the methods of the the theter on this to test its operation.
     * <br>
     * <br>
     * <strong> test description </strong>: a iterator process is created with the
     * Iterator method ()
     * And the Hasnext (), Next () and Remove () methods are tested on this in the
     * various
     * valid and not valid cases.
     * The various exceptions launched by the methods are captured and are printed
     * of the warning strings
     * of capture of exceptions. The functioning of the methods on the the theter is
     * controlled with methods
     * assertnotequals () and assertfalse ().
     * <br>
     * <br>
     * <strong> pre-condition </strong>: it must have been initialized and filled
     * A s1 list e
     * instantiated an s2 list.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the s1 list must have been changed
     * it must be
     * An empty s2 list was initialized. There must be a iterator on the list
     * Empty s2.
     * <br>
     * <br>
     * <strong> Expected results </strong>: if the test is passed they must be
     * Printed only the
     * STRENS OF NOTICE OF CANTING OF EXCEPTIONS but not the strings related to
     * Method errors
     * assertfalse () and assertnotequals ().
     */
    @Test
    public void testIterator() {
        HIterator iter = s1.iterator();
        while (iter.hasNext()) {
            iter.next();
        }
        assertFalse(iter.hasNext());
        int dim = s1.size();
        iter.remove();
        assertNotEquals(dim, s1.size());
        try {
            iter.remove();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }
        try {
            iter.next();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
        s2 = new StackAdapter();
        iter = s2.iterator();
        assertFalse(iter.hasNext());
        try {
            iter.next();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
        try {
            iter.remove();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }
    }

    /**
     * <strong>Test of {@link myAdapter.StackAdapter#listIterator()} and methods
     * of the iterator of a list </strong>
     * <p>
     * <br>
     * <br>
     * <strong> Summary </strong>: the test controls the functioning of the method
     * Listyrator () e
     * of the methods of the iterator of a list
     * <br>
     * <br>
     * <strong> test case design </strong>: an iterator is created on a list e
     * are used
     * the methods of the the theter on this to test its operation.
     * <br>
     * <br>
     * <strong> test description </strong>: a iterator process is created with the
     * LISTERATOR METHOD ()
     * And the Hasnext (), Next (), Nextindex (), Hasprevious (),) methods are
     * tested
     * Previous (), Previousindex (),
     * Add (), Remove () and Set () on this in the various valid and unreasive
     * cases.
     * The various exceptions launched by the methods are captured and are printed
     * of the warning strings
     * of capture of exceptions. The functioning of the methods on the the theter is
     * controlled with methods
     * Assertequals (), AssertNotequals () and assertfalse ().
     * <br>
     * <br>
     * <strong> pre-condition </strong>: it must have been initialized and filled
     * An s1 list.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the s1 list must have been modified e
     * the iterator process
     * must have been created and find itself at the beginning of the s1 list.
     * <br>
     * <br>
     * <strong> Expected results </strong>: if the test is passed they must be
     * been printed
     * Only the strings related to the capture of the exceptions launched by the
     * methods but
     * Not the strings tied
     * To the errors of the assertphase methods (), Assertequals () and
     * assertnotequals ().
     */
    @Test
    public void testListIterator() {
        HListIterator iter = s1.listIterator();
        assertFalse(iter.hasPrevious());
        try {
            iter.previous();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
        assertEquals(-1, iter.previousIndex());
        try {
            iter.remove();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }
        try {
            iter.set("Ciccio");
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }
        assertEquals(0, iter.nextIndex());
        assertEquals("Pippo", iter.next());
        assertEquals(1, iter.nextIndex());
        int dim = s1.size();
        iter.add("Ciccio");
        iter.add("Bello");
        assertNotEquals(dim, s1.size());
        while (iter.hasNext()) {
            iter.next();
        }
        iter.remove();
        assertEquals(6, iter.previousIndex());
        assertEquals("Pippo", iter.previous());
        while (iter.hasPrevious()) {
            iter.previous();
        }
        iter.set("Davide");
    }

    /**
     * <strong>Test of {@link myAdapter.StackAdapter#listIterator(int index)} And
     * Methods of the the entire list </strong>
     * <p>
     * <br>
     * <br>
     * <strong> Summary </strong>: the test controls the functioning of the method
     * LISTERATOR (INTDEX)
     * and the methods of the the entire list of a list.
     * <br>
     * <br>
     * <strong> test case design </strong>: an iterator is created on a list e
     * are used
     * the methods of the the theter on this to test its operation.
     * <br>
     * <br>
     * <strong> test description </strong>: the empty s2 list is initialized and
     * is tried to
     * Create a iterator on this in an unrealized position. A
     * ITER ITERTER on
     * s1 list with the Listyterator method (int index) and the methods are tested
     * Hasnext (), Next (),
     * Nextindex (), Hasprevious (), Previous (), Previusindex (), Add (), Remove ()
     * e
     * set () on this in the various
     * valid and not valid cases. The various exceptions launched by the
     * methods and are printed
     * of the warning strings to catch exceptions. The functioning of
     * Methods on the theter
     * It is controlled with the Assertequals () and assertive () methods.
     * <br>
     * <br>
     * <strong> pre-condition </strong>: it must have been initialized and filled
     * An s1 list and must
     * An s2 list has been instantiated.
     * <br>
     * <br>
     * <strong> post-condition </strong>: list 1 must have been modified and the
     * List 2 must
     * Having been initialize but must be empty. The iterator ITER must be
     * has been created and must
     * Be at the end of the s1 list.
     * <br>
     * <br>
     * <strong> Expected results </strong>: if the test is passed they must be
     * been printed
     * Only the strings related to the capture of exceptions and not those related
     * to
     * Method errors
     * ASSERTRUE () and Assertequals ().
     */
    @Test
    public void testListIteratorAtIndex() {
        s2 = new StackAdapter();
        HListIterator iter = null;
        try {
            iter = s2.listIterator(1);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
        iter = s1.listIterator(3);
        assertTrue(iter.hasPrevious());
        assertEquals("Paperino", iter.previous());

        assertTrue(iter.hasNext());
        assertEquals("Paperino", iter.next());
        assertEquals("Topolino", iter.next());
        int dim = s1.size();
        iter.set("Ciccio");
        assertEquals(dim, s1.size());
        assertEquals("Ciccio", iter.previous());
        iter.remove();
        assertEquals(dim - 1, s1.size());
        assertEquals("Pippo", iter.next());
        assertEquals(4, iter.nextIndex());
        assertEquals(3, iter.previousIndex());
        iter.add("Davide");
        assertEquals(dim, s1.size());
        assertEquals(5, iter.nextIndex());
        while (iter.hasPrevious()) {
            iter.previous();
        }
        try {
            iter.previous();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
        while (iter.hasNext()) {
            iter.next();
        }
        try {
            iter.next();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
        iter.remove();
        try {
            iter.remove();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }
        try {
            iter.set("Baggio");
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }
        iter.add("Baggio");
        try {
            iter.remove();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }
    }
}
