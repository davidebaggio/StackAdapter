package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * <strong>Class TestDiModifica</strong>
 * <p>
 * <br>
 * <br>
 * <strong> Summary </strong>: the testdimodifica class controls with its tests
 * the functioning of
 * Methods that modify the list or copy it in full or in part.
 * <br>
 * <br>
 * <strong> Test Suite Design </strong>: this class contains 4 TEST CASES that
 * Tesse 4 different
 * Methods of the Stackadapter class (), each of which changes
 * The list or copy in full or in part.
 * <br>
 * <br>
 * <strong> pre-control </strong>: before each test it must be initialized
 * at least one list e
 * In this elements must always be present.
 * <br>
 * <br>
 * <strong> post-condition </strong>: after each test it must have been done
 * at least a change or
 * A copy of at least one list.
 * <br>
 * <br>
 * <strong> Test Cases </strong>: The tests of this class are 4 and are:
 * testset (),
 * Testtoarray (), Testtoarrayinarray () and testsublist (). Each of them serves
 * test a
 * different method of the Stackadapter class.
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
public class TestDiModifica {

    StackAdapter l1 = null, l2 = null;
    Object[] arr = new Object[] { "Pippo", "Pluto", "Paperino", "Topolino", "Pippo", null };

    /**
     * This method is performed once before each class test
     * <strong> testdimodifica </strong>,
     * Print a string and initializes and adds elements to a list.
     */
    @Before
    public void setup() {
        System.out.println("Inizializza e aggiunge elementi alla lista l1");
        l1 = new StackAdapter();
        for (int i = 0; i < 6; i++) {
            l1.add(arr[i]);
        }

    }

    /**
     * This method is performed once after each class test
     * <strong> testdimodifica </strong>,
     * Print a string, removes all the elements from the L1 list and places the same
     * as
     * null the L2 list.
     */
    @After
    public void cleanup() {
        System.out.println("Rimuove tutti gli elementi dalla lista l1 e pone uguale a null la lista l2");
        l1.clear();
        l2 = null;
    }

    /**
     * <strong>Test of
     * {@link myAdapter.StackAdapter#set(int index, Object element)}</strong>
     * <p>
     * <br>
     * <br>
     * <strong> Summary </strong>: the test controls the functioning of the method
     * set (int index, object element)
     * <br>
     * <br>
     * <strong> test case design </strong>: the method on a more list is used
     * times passing
     * Different parameters valid and not valid.
     * <br>
     * <br>
     * <strong> test description </strong>: the set method is used (int index,
     * Object Element) More
     * times on the L1 list with different parameters to change the elements.
     * The
     * exceptions launched by the method when passing an index as a parameter
     * of non -valid position
     * Because less than 0 or greater or equal to the number of elements of the list
     * e
     * are printed some
     * Notice strings to catch the exception. With the Assertequals () e method
     * the help of methods
     * size () and Get () is checking that the size of the list does not change and
     * that it is
     * inserted the element
     * correct in the correct position.
     * <br>
     * <br>
     * <strong> pre-control </strong>: it must have been initialized and filled
     * An L1 list.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the size of the L1 list must remain
     * unchanged but
     * Some elements must have been replaced by others.
     * <br>
     * <br>
     * <strong> Expected results </strong>: if the test is passed they are printed
     * only the
     * strings that signal the capture of exceptions but none of those related
     * To the errors of the method
     * Assertequals ().
     */
    @Test
    public void testSet() {
        int dim = l1.size();
        Object obj = l1.set(0, null);
        assertEquals("L'elemento in posizione di indice 0 non è null", null, l1.get(0));
        assertEquals("La dimensione della lista 1 è cambiata", dim, l1.size());
        assertEquals("L'elemento restituito dal metodo non è corretto", "Pippo", obj);
        try {
            l1.set(-1, "Paperino");
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Non è possibile modificare elementi in posizioni di indice minore di 0");
        }
        try {
            l1.set(9, "Paperino");
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println(
                    "Non è possibile modificare elementi in posizioni di indice maggiore della dimensione della lista");
        }
        obj = l1.set(5, "Ciccio");
        assertEquals("L'elemento in posizione di indice 5 non è Ciccio", "Ciccio", l1.get(5));
        assertEquals("La dimensione della lista 1 è cambiata", dim, l1.size());
        assertEquals("L'elemento restituito dal metodo non è corretto", null, obj);
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
     * <strong> test case design </strong>: the method on two lists is used
     * different for
     * check its operation.
     * <br>
     * <br>
     * <strong> test description </strong>: an empty L2 list is initialized and
     * The method is used
     * Toarray () On this to see its behavior on an empty list. He comes
     * Then used the method
     * On the L1 list that has elements and controls with the help of the
     * Size method () that the
     * Array created are of the same size as the list on which it was used
     * the method and with
     * the help of the GET () method that contain the same elements.
     * <br>
     * <br>
     * <strong> pre-control </strong>: it must have been initialized and filled
     * A L1 list e
     * instantiated an L2 list.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the L1 list must have remained unchanged e
     * The L2 list
     * must have been initialized. An array that has the
     * same elements of the
     * L1 list.
     * <br>
     * <br>
     * <strong> Expected results </strong>: if the test is passed it must not be
     * was printed
     * No string because all linked to the errors of assertive methods ().
     */
    @Test
    public void testToArray() {
        l2 = new StackAdapter();
        Object[] array = l2.toArray();
        assertEquals("La dimensione dell'arrray e' diversa da quella della lista 2", l2.size(), array.length);
        array = l1.toArray();
        assertEquals("La dimensione dell'arrray e' diversa da quella della lista 1", l1.size(), array.length);
        for (int i = 0; i < l1.size(); i++) {
            assertEquals("Gli elementi dell'array sono diversi da quelli della lista 1", l1.get(i), array[i]);
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
     * <strong> test case design </strong>: the method on different lists is used
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
     * TOARRAY (OBJECT [] Arrayarget) used on one of the lists. It is controlled
     * with
     * of the assertquals () that the
     * Axor size created with the Toarray method (Object [] Arraytarget) and
     * correct and with methods
     * Assertequals () and assertnull () that the elements of array created
     * correspond to those of the list
     * or are the same as Null when they have to.
     * <br>
     * <br>
     * <strong> pre-control </strong>: it must have been initialized and filled
     * A L1 list e
     * An L2 list must have been instantiated.
     * <br>
     * <br>
     * <strong> post-condition </strong>: the L2 list must have been initialized,
     * The L1 list
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
        l2 = new StackAdapter();
        Object[] array1 = new Object[3];
        Object[] array2 = new Object[10];
        Object[] arrayOfList = l2.toArray(array1);
        for (int i = 0; i < arrayOfList.length; i++) {
            assertNull("L'elemento non e' null", arrayOfList[i]);
        }
        assertEquals("La dimensione dell'array e' sbagliata", 3, arrayOfList.length);
        array1[0] = 0;
        array1[1] = 1;
        arrayOfList = l1.toArray(array1);
        assertEquals("La dimensione dell'array e' sbagliata", l1.size(), arrayOfList.length);
        for (int i = 0; i < arrayOfList.length; i++) {
            assertEquals("Gli elementi dell'array sono diversi da quelli della lista", l1.get(i), arrayOfList[i]);
        }
        array2[7] = 7;
        arrayOfList = l1.toArray(array2);
        assertEquals("La dimensione dell'array e' sbagliata", array2.length, arrayOfList.length);
        for (int i = 0; i < arrayOfList.length; i++) {
            if (i < l1.size()) {
                assertEquals("Gli elementi dell'array sono diversi da quelli della lista", l1.get(i), arrayOfList[i]);
            } else {
                assertNull("Gli elementi in posizioni di indice maggiore della dimensione della lista non sono null",
                        arrayOfList[i]);
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
     * Sublist (Int Fromindex, Int Tindex)
     * <br>
     * <br>
     * <strong> test case design </strong>: a undergroundist is created and come
     * Test several
     * methods for testing the correct creation of the undergroundist and operation
     * of the methods on the undergroundist.
     * <br>
     * <br>
     * <strong> test description </strong>: an empty L2 list is initialized and
     * You feel on this
     * the sublist () method with unrealized indices to verify that launch
     * correctly the exception.
     * The exception is captured and a notice string is printed
     * capture. One is then created
     * Empty Summary of the L2 list then replaced by a non -empty list of the
     * L1 list. Are used
     * Various methods about the subtivation to test that it has been created and
     * functions
     * correctly. The correct
     * functioning of the methods on the undergroundist is controlled with the
     * methods
     * ASSERTRUE (), ASSERTFALSE (),
     * Assertequals () and assertnotequals ().
     * <br>
     * <br>
     * <strong> pre-control </strong>: it must have been initialized and filled
     * A L1 list e
     * instantiated an L2 list.
     * <br>
     * <br>
     * <strong> post-condition </strong>: there must be an L1 list and an L2 list
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
    public void testSubList() {
        l2 = new StackAdapter();
        HList sub = null;
        try {
            sub = l2.subList(1, 3);
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Non si può creare una sottolista non vuota da una lista vuota");
        }
        sub = l2.subList(0, 0);
        assertEquals("La lista 2 e la sottolista non sono uguali", l2, sub);
        int dim2 = l2.size();
        int dimsub = sub.size();
        System.out.println(dim2 + " " + dimsub);
        sub.add("Pippo");
        assertEquals("La dimensione della sottolista non è cambiata correttamente", dimsub + 1, sub.size());
        assertEquals("La dimensione della lista 2 non è cambiata correttamente", dim2 + 1, l2.size());
        sub = l1.subList(2, 5);
        // System.out.println(sub);
        assertTrue("La lista 1 non contiene tutti gli elementi della sottolista", l1.containsAll(sub));
        assertFalse("La sottolista contiene tutti gli elementi della lista 1", sub.containsAll(l1));
        assertEquals("L'elemento restituito non è quello aspettato", "Paperino", sub.get(0));
        int dim = l1.size();
        dimsub = sub.size();
        assertFalse("L'elemento è stato rimosso", sub.remove("Pluto"));
        assertEquals("La dimensione della lista è cambiata", dim, l1.size());
        assertEquals("La dimensione della sottlista è cambiata", dimsub, sub.size());
        try {
            sub.remove(3);
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println(
                    "Non si può rimuovere un elemento da una posizione di indice maggiore o uguale alla dimensione della lista");
        }
        assertTrue(sub.contains("Paperino"));
        assertTrue("L'elemento non è stato rimosso", sub.remove("Paperino"));
        assertEquals("La dimensione della lista è cambiata", dim - 1, l1.size());
        assertEquals("La dimensione della sottlista è cambiata", dimsub - 1, sub.size());
        assertFalse("L'elemento \"Paperino\" è presente nella lista", l1.contains("Paperino"));
        sub.add(1, "Paperino");
        assertTrue("L'elemento \"Paperino\" non è presente nella lista", l1.contains("Paperino"));
        sub.set(0, "Pluto");
        assertFalse("L'elemento \"Topolino\" è presente nella lista", l1.contains("Topolino"));
        assertNotEquals("La lista 1 e la sublist sono uguali", l1, sub);
        HListIterator iter = sub.listIterator();
        assertFalse("L'iteratore non può avere un elemento precedente se si trova all'inizio della lista",
                iter.hasPrevious());
        assertEquals("Gli elementi non sono uguali", "Pluto", iter.next());
        dim = l1.size();
        dimsub = sub.size();
        iter.add("Ciccio");
        assertEquals("La dimensione della lista 1 non è cambiata correttamente", dim + 1, l1.size());
        assertEquals("La dimensione della sottolista non è cambiata correttamente", dimsub + 1, sub.size());
        HList sub2 = sub.subList(1, 3);
        int dimsub2 = sub2.size();
        dimsub = sub.size();
        dim = l1.size();
        sub2.clear();
        assertTrue("La sottolista 2 non è vuota", sub2.isEmpty());
        assertFalse("La sottolista 1 è vuota", sub.isEmpty());
        assertEquals("La dimensione della sottolista 1 non è cambiata correttamente", dimsub - dimsub2, sub.size());
        assertEquals("La dimensione della lista 1 non è cambiata correttamente", dim - dimsub2, l1.size());
    }

}