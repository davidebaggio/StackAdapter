package myTest;

import myAdapter.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * <strong>Class TestList</strong>
 * <p>
 * <br>
 * <br>
 * <strong> Summary </strong>: the testlist class controls the
 * operation of
 * Some methods of the Stackadapter class, in particular some aspects of the
 * sublists and iterators.
 * <br>
 * <br>
 * <strong> Test Suite Design </strong>: this class contains 5 TEST CASES that
 * Tespano dei
 * Methods of the Stackadapter class (). In particular the connection of
 * sublists with their lists
 * 'Fathers' and some methods of the iterators.
 * <br>
 * <br>
 * <strong> pre-condition </strong>: before each test it must be initialized
 * At least one list.
 * <br>
 * <br>
 * <strong> post-condition </strong>: after each test it must have been
 * Initialized an iterator
 * Oned a subtivation.
 * <br>
 * <br>
 * <strong> Test Cases </strong>: The tests of this class are 5 and are:
 * testbacking (),
 * testrecusivesublist (), TestIterator3 (), TestIterator2 () and TestIterator1
 * ().
 * Each of them heads
 * At least one aspect of the iterators or sublists.
 * <br>
 * <br>
 * <strong>Test Suite Execution Records</strong>: Records are exaclty what this
 * test suite provides as result of {@link myTest.TestRunner} class.
 * <br>
 * <br>
 * <strong> Execution Variables </strong>: the variables used are two HLIST
 * s1 and s2, a
 * HListIterator LI E an array of ARGV strings. In some tests they are then
 * Use other variables
 * When necessary.
 */
public class TestList {
	HList s1 = null, s2 = null;
	HListIterator li = null;
	static String[] argv = { "pippo", "qui", "pluto", "paperino", "qui", "ciccio" };

	/**
	 * This method is performed once before each class test
	 * <strong> testlist </strong>,
	 * Print a string and initializes an empty list.
	 */
	@Before
	public void setup() {
		// System.out.println("Instantiate an empty List");
		s1 = new StackAdapter();
	}

	/**
	 * This method is performed once after each class test
	 * <strong> testlist </strong>,
	 * Print a string and remove all the elements from the s1 list.
	 */
	@After
	public void cleanup() {
		// System.out.println("Purge all remaining elements");
		s1.clear();
	}

	/**
	 * <strong>TestBacking</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: The test checks the correct link between a list
	 * And one of his undergroundists.
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: in this test they are added and removed
	 * elements from a list and from one of his
	 * Summary, then check their size and the correct modification of the
	 * Main list when
	 * His undergroundist is modified.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: through the Add () method they come
	 * Added elements to the s1 list
	 * from which an underlist () method is then created s2 with the sublist method.
	 * They come
	 * Check with some
	 * variables the size of the two lists and their correct change when
	 * are added and removed
	 * Elements from the Unconist s2 with the Add (), Remove () and Clear ()
	 * methods. They come
	 * Building of the iterators
	 * and printed the elements of the lists through the iterate method (). All the
	 * controls are carried out
	 * with the Assertequals method ().
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: an s1 list must have been initialized,
	 * instantiate a iterator there
	 * And a Array array created. The Add (), Remove (), iTerator (), iterate ()
	 * methods
	 * Sublist (), Size () and Clear ()
	 * must work correctly.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 list must contain some elements e
	 * His undergroundist s2 must
	 * Be empty. The elements of the lists must have been printed and some
	 * strings.
	 * <br>
	 * <br>
	 * <strong> Expected Results </strong>: the test is passed if they are printed
	 * Only expected and not messages
	 * Messages of printed errors when assertionquals () are not exceeded.
	 */
	@Test
	public void testBacking() {
		// System.out.println("TestBacking");
		for (int i = 0; i < argv.length; i++) {
			s1.add(argv[i]);
		}
		System.out.println("List.toString() ? " + s1);

		int dl0, ds1, dli, dsl0, dss1, dsli;

		iterate(s1.iterator());
		System.out.println(s1 + " " + s1.size());
		dl0 = s1.size();

		s2 = s1.subList(0, argv.length / 2);
		dsl0 = s2.size();
		System.out.println(s2);

		s2.add("pipperissimo");
		dli = s1.size();
		dsli = s2.size();

		assertEquals("\n*** sublist add is NOT backed correctly ***\n", dli, dl0 + 1);
		assertEquals("\n*** sublist add is NOT backed correctly ***\n", dsli, dsl0 + 1);

		s2.remove("pipperissimo");
		assertEquals("\n*** list remove is NOT backed correctly ***\n", s1.size(), dl0);
		assertEquals("\n*** list remove is NOT backed correctly ***\n", s2.size(), dsl0);

		iterate(s2.iterator());
		System.out.println(s2 + " " + s2.size());

		s2.clear();
		ds1 = s1.size();
		dss1 = s2.size();
		System.out.println(s1 + " " + s1.size());
		iterate(s1.iterator());
		System.out.println(s2 + " " + s2.size());
		iterate(s2.iterator());

		System.out.println(dl0 + " " + ds1 + " " + dsl0 + " " + dss1);
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dsl0, (dl0 / 2));
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dss1, 0);
		assertEquals("\n*** sublist is NOT backed correctly ***\n", ds1, (dl0 - dsl0));

	}

	/**
	 * <strong>Test of recursive sublists</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: this test controls the functioning of
	 * sublists, in particular of the
	 * sublists of the sublists.
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: in this test some
	 * elements to the initial list whose
	 * Length is checked after some insertions. They are built
	 * Different sub -lines of the list
	 * initial that replace it for each iteration to control the
	 * Functioning of the sublists
	 * of the sub -lists.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the test uses Add () and size methods ()
	 * To add elements to the
	 * Initial s1 list and check the correct modification of the length of the
	 * list through gods
	 * Assertequals () who compare the size. Are printed with the
	 * Method iterate () the elements
	 * of the list with a iterator created with the iterator method (). s1 list
	 * is then replaced by
	 * a subsidiary of his lower size, created with Sublist (), until s1
	 * has no size
	 * less than 2, in order to control the recursive functioning of the lists.
	 * every time the
	 * s1 list is replaced by one of his unsatisfied ones are printed
	 * Elements with the iterate method ().
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: an s1 list must have been initialized
	 * empty and created an array array
	 * not empty. The Size (), Add (), and Sublist () methods must work
	 * correctly.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 list must have a number of elements
	 * less than 2. must be
	 * The elements of the list and some strings were printed.
	 * <br>
	 * <br>
	 * <strong> Expected Results </strong>: for the success of the test they must be
	 * Printed some strings and several times
	 * The elements of the initial s1 list and sub -senses later
	 * Create but none of the messages
	 * of error of assertionquals ().
	 */
	@Test
	public void testRecursiveSublist() {
		System.out.println("TestRecursive SubListing");
		System.out.println(s1.size());

		assertEquals("List Starts not empty", s1.size(), 0);
		int prev = s1.size();
		for (int i = 0; i < argv.length; i++) {
			s1.add(argv[i]);
		}
		assertEquals("List add not working correctly", s1.size(), (prev + argv.length));
		System.out.println(s1.size());
		prev = s1.size();
		for (int i = 0; i < argv.length; i++) {
			s1.add(argv[i]);
		}
		assertEquals("List add not working correctly", s1.size(), (prev + argv.length));
		System.out.println(s1.size());
		prev = s1.size();
		for (int i = 0; i < argv.length; i++) {
			s1.add(argv[i]);
		}
		assertEquals("List add not working correctly", s1.size(), (prev + argv.length));
		System.out.println(s1.size());
		iterate(s1.iterator());

		int after = 0;
		int count = 0;
		while (s1.size() >= 2) {
			count++;
			prev = s1.size();
			s1 = s1.subList(1, prev - 1);
			after = s1.size();
			System.out.println(after);
			assertEquals("Iterative Sublisting not working at " + count + " iteration", after, (prev - 2));
			iterate(s1.iterator());
		}
	}

	/**
	 * <strong> Test 3 on the Iterator </strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of some methods
	 * of the heterentor
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: they are added to the list of objects
	 * And the list is then traveled.
	 * All the elements of the list are removed one by one, which come
	 * printed several times during the
	 * Test.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: all s1 list are added
	 * Elements of arv ARRAY with the
	 * Add () method. All elements of the list with the method are printed
	 * iterate () on a iterator
	 * Created with the iterator method (). The iterator is initialized with a
	 * Intrar created on the list
	 * s1 with the Listyterate method (). With the iterator we travel with the
	 * methods
	 * Hasnext () and Next () the whole
	 * s1 list which then retraces itself with Hasprevious () and Previous ()
	 * eliminating the last element
	 * one at a time with the Remove () method, printing the list with iterate ()
	 * remaining before each
	 * Removal. They are controlled with the int and assertquals () le
	 * size of the list after
	 * All the additions and removals of the list.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: an s1 list must have been initialized,
	 * instantiate an iterator li e
	 * Created a non -empty array. The Add (), size (), iterate () methods,
	 * iTerator (), Listyterator (), Hasnext (),
	 * Next (), Hasprevious (), Previous () and Remove () must be correctly
	 * functioning.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: list 1 must be empty and the iterator
	 * must have been initialized.
	 * The elements of the list and some strings must have been printed.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed they are printed
	 * several times the elements of the
	 * s1 list but no error message is printed from the methods
	 * Assertequals ().
	 */
	@Test
	public void testIterator3() {
		System.out.println("TestListIterator #3");
		int dl0, ds1, ds2;

		dl0 = s1.size();
		for (int i = 0; i < argv.length; i++) {
			s1.add(argv[i]);
		}
		ds1 = s1.size();
		iterate(s1.iterator());
		li = s1.listIterator();
		while (li.hasNext())
			li.next();
		while (li.hasPrevious()) {
			System.out.print(li.previous() + " ");
			iterate(s1.iterator());
			li.remove();
		}
		ds2 = s1.size();
		iterate(s1.iterator());

		assertEquals("\n*** insertion and forward to end and backward removal not working ***\n", ds1,
				(dl0 + argv.length));
		assertEquals("\n*** insertion and forward to end and backward removal not working ***\n", ds2, 0);
	}

	/**
	 * <strong> Test number 2 on the iterator </strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of some methods
	 * of the heterner.
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: they are added to the list of objects
	 * that are removed to the
	 * Time along the list with an iterator.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: objects are added to the s1 list
	 * of ARRV ARRAY through
	 * the use of the Add () method. The iterator is initialized with a
	 * Intrar created on the s1 list
	 * with the Listyterator method (). The whole s1 list is traveled with the
	 * methods
	 * Hasnext () and Next (), e
	 * All the elements of the list are removed in order with the method
	 * Remove (). They are printed
	 * the elements of the s1 list with the iterate method () after adding everyone
	 * the elements of array,
	 * before each removal and after all the removals. The
	 * correct changes to the list
	 * and its size with int and with the size () and assertion () methods.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: an s1 list must have been initialized,
	 * instantiated and the same place for Null
	 * An iterator and a Argu array created them. They must work correctly i
	 * Methods Size (), Add (), iterate (),
	 * Iterator (), Listyterator (), Hasnext (), Next () and Remove ().
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 list must be empty and the iterator
	 * It must have been initialized.
	 * The elements of the list and some strings must have been printed.
	 * <br>
	 * <br>
	 * <strong> Expected results </strong>: if the test is passed they must be
	 * a string has been printed and more
	 * times the elements of the s1 list but no error message of the
	 * Assertequals ().
	 */
	@Test
	public void testIterator2() {
		System.out.println("TestListIterator #2");
		int dl0, ds1, ds2;
		dl0 = s1.size();
		for (int i = 0; i < argv.length; i++) {
			s1.add(argv[i]);
		}
		ds1 = s1.size();
		iterate(s1.iterator());
		li = s1.listIterator();
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
			iterate(s1.iterator());
			li.remove();
		}
		ds2 = s1.size();
		iterate(s1.iterator());

		assertEquals("\n*** insertion and forward removal not working ***\n", ds1, (dl0 + argv.length));
		assertEquals("\n*** insertion and forward removal not working ***\n", ds2, 0);
	}

	/**
	 * <strong>test 1 On The iterator </strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong> Summary </strong>: the test controls the functioning of some methods
	 * of the heterner.
	 * <br>
	 * <br>
	 * <strong> test case design </strong>: a iterator is created at the end of the
	 * list that is traveled to
	 * contrary by removing one element at a time.
	 * <br>
	 * <br>
	 * <strong> test description </strong>: the iterator is initialized with a
	 * Intrar created at the end of the
	 * s1 List with the Listyterator method (Int Index). The list is traveled to
	 * against with the methods
	 * HASPRIVOUS () and Previous (), and the last element of the list with
	 * the remote method () to each
	 * step back of the heterner. The elements of the
	 * s1 list with the method
	 * iterate () with a iterator created with the iterator method (). Is controlled
	 * the size of the
	 * list s1 at the end of the test with the Assertequals () and Size () method.
	 * <br>
	 * <br>
	 * <strong> pre-condition </strong>: an s1 list must have been initialized
	 * and must have been instantiated and
	 * place equal to null a iterator there. The iterated methods (), iterator (),
	 * LISTERATOR (INTDEX),
	 * HASPRIVOUS (), Previous (), Size () and Remove () must work correctly.
	 * <br>
	 * <br>
	 * <strong> post-condition </strong>: the s1 list must be empty and the iterator
	 * It must have been initialized.
	 * The elements of the list and some strings must have been printed.
	 * <br>
	 * <br>
	 * <strong> Expected Results </strong>: the test is passed if it is printed
	 * An initial string and come
	 * printed several times the elements of the s1 list, but no error message
	 * of assertionquals ().
	 */
	@Test
	public void testIterator1() {
		System.out.println("TestListIterator #1");
		iterate(s1.iterator());
		li = s1.listIterator(s1.size());
		while (li.hasPrevious()) {
			System.out.print(li.previous() + " ");
			iterate(s1.iterator());
			li.remove();
		}
		iterate(s1.iterator());

		assertEquals("\n*** listiterator from end not working ***\n", s1.size(), 0);
	}

	public static void iterate(HIterator iter) {
		System.out.print("{");
		while (iter.hasNext()) {
			System.out.print(iter.next() + "; ");
		}
		System.out.println("}");
	}
}
