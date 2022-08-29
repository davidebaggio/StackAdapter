package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.EmptyStackException;

/**
 * <strong> Summary: Class TestDeletion </strong> checks the
 * operation of
 * Methods that remove objects from a stack.
 * <br>
 * <br>
 * <strong> Test Suite Design </strong>: this class contains 6 test Cases that
 * tests 6 different
 * Methods of the {@link myAdapter.StackAdapter} class, each of which removes
 * one or more
 * Elements according to different criteria.
 * <br>
 * <br>
 * <strong> pre-condition </strong>: before each test it must be initialized
 * at least one stack e
 * In this elements must always be present.
 * <br>
 * <br>
 * <strong> post-condition </strong>: after each test it must have been done
 * At least a removal
 * from at least one stack.
 * <br>
 * <br>
 * <strong> Test Cases </strong>: {@link #testClear()}, {@link #testPop()},
 * {@link #testRemoveAll()}, {@link #testRemoveAtIndex()},
 * {@link #testRemoveObj()}, {@link #testRetainAll()}.
 * <br>
 * <br>
 * <strong>Test Suite Execution Records</strong>: Records are exaclty what this
 * test suite provides as result of {@link myTest.TestRunner} class.
 * <br>
 * <br>
 * <strong> Execution Variables </strong>: the variables used are two
 * Stackadapter s1 and s2, the
 * first used in all tests and the second only where necessary, and a
 * Object Array used
 * To insert elements on the lists. In some tests other variables are then used
 * when necessary.
 * 
 * @author Davide Baggio
 */
public class TestDeletion {

    private StackAdapter s1 = null, s2 = null;
    Object[] arr = new Object[] { "Pippo", "Pluto", "Paperino", "Topolino", "Pippo" };

    /**
     * setup before each test.
     */
    @Before
    public void setup() {
        s1 = new StackAdapter();
        for (int i = 0; i < 5; i++) {
            s1.add(arr[i]);
        }

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
     * <strong> Summary </strong>: Test of {@link myAdapter.StackAdapter#pop()}
     * <br>
     * <br>
     * <strong> test case design </strong>: the functioning of the
     * Method in basic cases, just popping items from the stack. And throwing
     * exception when needed.
     * <br>
     * <br>
     * <strong> test description </strong>: in this test some elements that are
     * already
     * into the stack are popped from it verifing that the size is correct. Pop() is
     * checked also for sublists.
     * <br>
     * <br>
     * <strong> pre-condition </strong>: a s1 must have been initialized and must
     * having been instantiated with elements inside. s2 has no elements instead
     * empty(), pop()
     * Stackadapter () must work correctly.
     * <br>
     * <br>
     * <strong> post-condition </strong>: s1 has to contain no elements, s2 is empty
     * too.
     * <br>
     * <br>
     * <strong> Expected results </strong>: Every item is popped from s1.
     */
    @Test
    public void testPop() {
        s2 = new StackAdapter();
        try {
            s2.pop();
            throw new Exception();
        } catch (Exception e) {
            assertEquals(EmptyStackException.class, e.getClass());
        }

        assertEquals("Pippo", s1.pop());

        StackAdapter temp = (StackAdapter) s1.subList(1, 3);
        temp.pop();
        temp.pop();
        assertEquals(2, s1.size());

        while (!s1.empty()) {
            s1.pop();
        }
        assertTrue(s1.empty());
    }

    /**
     * <strong>Summary</strong>: Test of
     * {@link myAdapter.StackAdapter#remove(Object)}
     * <br>
     * <br>
     * <strong> test case design </strong>: different elements are removed from one
     * List to check the correct
     * operation of the removal.
     * <br>
     * <br>
     * <strong> test description </strong>: the test tries to remove from the s1
     * previously initialized e
     * filled a null element not present in the list and then a present element
     * In the list with the
     * Remove () method. A NULL element is added to the list with the method
     * Add () to try the
     * Removal of a Null element with the Remove method. With the help of a
     * Boolean variable and one
     * Int variable is controlled through the assertive methods (), assertfalse () e
     * Assertequals ()
     * that the various removals have been successful and the size of the list is
     * changed correctly.
     * <br>
     * <br>
     * <strong> pre-condition </strong>: it must have been initialized and filled
     * An s1 list.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the s1 list must contain all
     * initial elements except one that
     * has been removed and no new element. Its size must be
     * decreased by 1.
     * <br>
     * <br>
     * <strong> Expected Results </strong>: if the test is successful it is not
     * printed
     * No string because all
     * linked to the errors of assertive (), assertfalse () and assertquals ().
     */
    @Test
    public void testRemoveObj() {
        boolean removed = s1.remove(null);
        int dim = s1.size();
        assertFalse(removed);
        removed = s1.remove("Paperino");
        assertTrue(removed);
        s1.add(null);
        removed = s1.remove(null);
        assertTrue(removed);
        assertEquals(dim - 1, s1.size());
    }

    /**
     * <strong> Summary </strong>: Test of
     * {@link myAdapter.StackAdapter#remove(int)}
     * <br>
     * <br>
     * <strong> test case design </strong>: the removal of objects is tested
     * positions of different indices, between
     * to which indices not valid to test the launch of exceptions.
     * <br>
     * <br>
     * <strong> test description </strong>: the removal of elements is tested in
     * positions of valid indices e
     * not valid, for example minor indices of 0 and greater indices of the size
     * of the s1. They come
     * captured the exceptions launched by the Remove (Int Index) method with
     * parameters
     * not valid and come
     * Printed of the trial notice messages. The elements are compared
     * removed with the elements
     * which had to be removed through the use of assertionquals () e
     * the correct is checked
     * change of the size of the list with the help of a variable int e
     * of the Size method ().
     * <br>
     * <br>
     * <strong> pre-condition </strong>: it must have been initialized and filled
     * An s1 list.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the size of the s1 must be decreased
     * of 2 and the s1 must not
     * contain new elements.
     * <br>
     * <br>
     * <strong> Expected results </strong>: if the test is passed they must be
     * two strings were printed at the
     * capturing exceptions but no error message linked to
     * Assertequals ().
     */
    @Test
    public void testRemoveAtIndex() {
        int dim = s1.size();
        Object removed = null;
        try {
            removed = s1.remove(-1);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
        try {
            removed = s1.remove(6);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
        removed = s1.remove(3);
        assertEquals("Topolino", removed);
        removed = s1.remove(0);
        assertEquals("Pippo", removed);
        assertEquals(dim - 2, s1.size());
    }

    /**
     * <strong> Summary </strong>:
     * {@link myAdapter.StackAdapter#removeAll(HCollection)}
     * <br>
     * <br>
     * <strong> test case design </strong>: the method is tested by applying it on
     * a list passing as a parameter
     * Another list.
     * <br>
     * <br>
     * <strong> test description </strong>: the s1 list method is used
     * passing the s2 list as a parameter
     * first equal to Null, then initialized with the Stackadapter () but empty
     * method
     * And finally after having
     * inserted some elements with Add (). The launch is checked
     * of the exception when it is passed
     * The s2 list equal to Null. They are tested with assertive (), assertfalse ()
     * e
     * Assertequals (), with
     * the help of a Boolean variable, an int and the size () method, the
     * successful insertions and the
     * Correct modification of the size of the s1 list.
     * <br>
     * <br>
     * <strong> pre-condition </strong>: it must have been initialized and filled
     * An s1 list, instantiated and mail
     * Equal to Null an s2 list is initialized an ARCY ACC with at least two
     * Elements in the first two
     * positions.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the s1 list must contain 3 elements in
     * less than the start of the test
     * And it must not contain any new element or belonging to the s2 list.
     * <br>
     * <br>
     * <strong> Expected Results </strong>: the test is passed if it is printed
     * A string with capture
     * of the exception and no string linked to the errors of the methods
     * Assertequals (), ASSERTRUE () e
     * assertfalse ().
     */
    @Test
    public void testRemoveAll() {
        boolean removed = false;
        try {
            removed = s1.removeAll(s2);
            throw new Exception();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
        s2 = new StackAdapter();
        removed = s1.removeAll(s2);
        assertFalse(removed);
        s2.add(arr[0]);
        s2.add(arr[1]);
        int dim = s1.size();
        removed = s1.removeAll(s2);
        assertTrue(removed);
        assertEquals(dim - 3, s1.size());
    }

    /**
     * <strong> Summary </strong>: Test of {@link myAdapter.StackAdapter#clear()}
     * <br>
     * <br>
     * <strong> test case design </strong>: the method is tested by applying it more
     * times to the same list.
     * <br>
     * <br>
     * <strong> test description </strong>: the Clear () method to be test comes
     * Applied twice
     * to the same s1 list, the first time while it contains elements and the second
     * After eliminating them with
     * The first use of the method. With the help of the ISEMPTY () method, yes
     * Check that the s1 list is not
     * Initially empty and subsequently to the use of the Clear method ()
     * through methods
     * assertfalse () and assertive ().
     * <br>
     * <br>
     * <strong> pre-condition </strong>: the s1 list must have been initialized e
     * filled.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the s1 list must be empty.
     * <br>
     * <br>
     * <strong> Expected results </strong>: the test is passed if it does not come
     * no string printed
     * of error linked to assertive () and assertive () methods.
     */
    @Test
    public void testClear() {
        assertFalse(s1.isEmpty());
        s1.clear();
        assertTrue(s1.isEmpty());
        s1.clear();
        assertTrue(s1.isEmpty());
    }

    /**
     * <strong> Summary </strong>:
     * {@link myAdapter.StackAdapter#retainAll(HCollection)}
     * <br>
     * <br>
     * <strong> test case design </strong>: an s2 list is changed several times
     * which is passed
     * as a parameter of the retainal method () applied to the s1 list.
     * <br>
     * <br>
     * <strong> test description </strong>: it is initialized and filled with
     * Objects a list
     * s2, which is passed as a parameter several times to the retainal method ()
     * Applied to the s1 list. They come
     * removed a little at the time of the elements from the s2 list and repeat
     * itself
     * The Retainall operation (). The
     * correct functioning of the method is tested with assertionquals () and a
     * ASSERTRUE () that
     * with the help of some intra variables they control the correct
     * Edit size
     * of the lists after the removals.
     * <br>
     * <br>
     * <strong> pre-condition </strong>: it must have been initialized and filled
     * An s1 list
     * And an s2 list must have been instantiated and placed equal to Null.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the s1 list and the s2 list must be
     * Both empty.
     * <br>
     * <br>
     * <strong> Expected results </strong>: if the test is passed it does not come
     * any printed
     * string because linked to the percori of assertive () and assertive ()
     * methods.
     */
    @Test
    public void testRetainAll() {
        s2 = new StackAdapter();
        for (int i = 0; i < s1.size(); i++) {
            s2.add(s1.get(i));
        }
        assertEquals(s1, s2);

        s1.retainAll(s2);
        assertEquals(s2, s1);

        s2.remove("Pippo");
        s1.retainAll(s2);
        int dim1 = s1.size();
        int dim2 = s2.size();
        assertEquals(dim2 + 1, dim1);

        s2.remove("Pippo");
        s1.retainAll(s2);
        dim1 = s1.size();
        dim2 = s2.size();
        assertEquals(dim2, dim1);

        s2.clear();
        s1.retainAll(s2);
        assertTrue(s1.isEmpty());
    }
}
