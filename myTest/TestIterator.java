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
 * <strong> Summary </strong>: this testSuite class controls with its tests
 * the functioning of
 * Methods that build iterators and methods of the iterators themselves.
 * <br>
 * <br>
 * <strong> Test Suite Design </strong>: this class contains 3 TEST CASES that
 * tests 3 different
 * Methods of the Stackadapter class (), each of which builds a
 * iterator for a collection or for
 * A stack. If it is an iterator of a stack, it can be built in
 * a different position.
 * <br>
 * <br>
 * <strong> pre-condition </strong>: before each test it must be initialized
 * at least one stack and elements must always be present.
 * <br>
 * <br>
 * <strong> post-condition </strong>: after each test it must have been created
 * at least one iterator for
 * At least one stack and his methods must have been tried.
 * <br>
 * <br>
 * <strong> Test Cases </strong>: The tests of this class are 3 and are:
 * {@link #testIterator()}, {@link #teststackIterator()},
 * {@link #teststackIteratorAtIndex()}.
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
public class TestIterator {

    StackAdapter s1 = null, s2 = null;
    Object[] arr = new Object[] { "Dog", "Cat", "World", "Hello", "Dog", null };

    /**
     * This method is performed once before each test
     * <strong> TestIterator </strong>,
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
     * <strong> TestIterator </strong>,
     * Removes all the elements from the s1 stack and places the
     * same as null the s2 stack.
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
     * iterator ()
     * <br>
     * <br>
     * <strong> test case design </strong>: an iterator is created on a stack and
     * are used
     * the methods to test its operation.
     * <br>
     * <br>
     * <strong> test description </strong>: a iterator process is created with the
     * Iterator method ()
     * And the Hasnext (), Next () and Remove () methods are tested on this in the
     * various
     * valid and not valid cases.
     * The various exceptions launched by the methods are captured. The functioning
     * of the methods on the iterator is
     * controlled with methods
     * assertnotequals () and assertfalse ().
     * <br>
     * <br>
     * <strong> pre-condition </strong>: it must have been initialized and filled
     * an s1 stack and
     * instantiated an s2 stack.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the s1 stack must have been changed
     * it must be
     * An empty s2 stack was initialized. There must be a iterator on the stack
     * Empty s2.
     * <br>
     * <br>
     * <strong> Expected results </strong>: if the test is passed no errors are
     * printed.
     */
    @Test
    public void testIterator() {
        HIterator iter = s1.iterator();
        while (iter.hasNext()) {
            iter.next();
        }
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
     * of the iterator of a stack </strong>
     * <p>
     * <br>
     * <br>
     * <strong> Summary </strong>: the test controls the functioning of the method
     * listIterator () e
     * of the methods of the iterator of a stack
     * <br>
     * <br>
     * <strong> test case design </strong>: an iterator is created on a stack e
     * are used
     * the methods of the iterator on this to test its operation.
     * <br>
     * <br>
     * <strong> test description </strong>: a iterator process is created with the
     * stackERATOR METHOD ()
     * And the Hasnext (), Next (), Nextindex (), Hasprevious (),) methods are
     * tested
     * Previous (), Previousindex (),
     * Add (), Remove () and Set () on this in the various valid
     * cases.
     * The various exceptions launched by the methods are captured. The functioning
     * of the methods on the iterator is
     * controlled with methods
     * Assertequals (), AssertNotequals () and assertfalse ().
     * <br>
     * <br>
     * <strong> pre-condition </strong>: it must have been initialized and filled
     * An s1 stack.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the s1 stack must have been modified and
     * the iterator process
     * must have been created and find itself at the beginning of the s1 stack.
     * <br>
     * <br>
     * <strong> Expected results </strong>: if the test is passed no errors are
     * printed.
     */
    @Test
    public void teststackIterator() {
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
            iter.set("Ocean");
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IllegalStateException.class, e.getClass());
        }

        assertEquals("Dog", iter.next());
        assertEquals(1, iter.nextIndex());

        iter.add("Ocean");
        iter.add("Horrible");
        while (iter.hasNext()) {
            iter.next();
        }
        iter.remove();
        assertEquals(6, iter.previousIndex());
        assertEquals("Dog", iter.previous());

        while (iter.hasPrevious()) {
            iter.previous();
        }
        iter.set("Davide");
    }

    /**
     * <strong>Test of {@link myAdapter.StackAdapter#listIterator(int index)} And
     * Methods of the the entire stack </strong>
     * <p>
     * <br>
     * <br>
     * <strong> Summary </strong>: the test controls the functioning of the method
     * listIterator ()
     * and the methods of the entire stack.
     * <br>
     * <br>
     * <strong> test case design </strong>: an iterator is created on a stack e
     * are used
     * the methods of the iterator on this to test its operation.
     * <br>
     * <br>
     * <strong> test description </strong>: the empty s2 stack is initialized and
     * is tried to
     * Create a iterator on this in an unrealized position. A
     * iterator on
     * s1 stack with the listIterator method and the methods are tested
     * Hasnext (), Next (),
     * Nextindex (), Hasprevious (), Previous (), Previusindex (), Add (), Remove ()
     * and
     * set () on this in the various
     * valid and not valid cases. The various exceptions launched by the
     * methods and are catch The functioning of
     * Methods on iterator
     * It is controlled with the Assertequals () and assertive () methods.
     * <br>
     * <br>
     * <strong> pre-condition </strong>: it must have been initialized and filled
     * An s1 stack and must
     * An s2 stack has been instantiated.
     * <br>
     * <br>
     * <strong> post-condition </strong>: stack 1 must have been modified and the
     * stack 2 must
     * Having been initialize but must be empty. The iterator ITER must be
     * has been created and must
     * Be at the end of the s1 stack.
     * <br>
     * <br>
     * <strong> Expected results </strong>: if the test is passed no errors are
     * printed.
     */
    @Test
    public void teststackIteratorAtIndex() {
        s2 = new StackAdapter();
        HListIterator iter = null;
        try {
            iter = s2.listIterator(1);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }

        iter = s1.listIterator(3);
        assertEquals("World", iter.previous());

        assertEquals("World", iter.next());

        int dim = s1.size();
        iter.set("Ocean");
        assertEquals("Ocean", iter.previous());

        iter.remove();

        assertEquals("Dog", iter.next());
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
