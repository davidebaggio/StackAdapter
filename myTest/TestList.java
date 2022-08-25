package myTest;

import myAdapter.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

//import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * <strong>Class TestList</strong>
 * <p>
 * <br>
 * <br>
 * <strong>Summary</strong>: La classe TestList controlla con i suoi test il
 * funzionamento di
 * alcuni metodi della classe StackAdapter, in particolare alcuni aspetti delle
 * sottoliste e degli iteratori.
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: Questa classe contiene 5 test cases che
 * testano dei
 * metodi della classe StackAdapter(). In particolare il collegamento delle
 * sottoliste con le loro liste
 * 'padri' e alcuni metodi degli iteratori.
 * <br>
 * <br>
 * <strong>Pre-Condition</strong>: Prima di ogni test deve essere inizializzata
 * almeno una lista.
 * <br>
 * <br>
 * <strong>Post-Condition</strong>: Dopo ogni test deve essere stato
 * inizializzato un iteratore
 * o creata una sottolista.
 * <br>
 * <br>
 * <strong>Test Cases</strong>: I test cases di questa classe sono 5 e sono:
 * testBacking(),
 * testRecursiveSublist(), testIterator3(), testIterator2() e testIterator1().
 * Ciascuno di essi testa
 * almeno un aspetto degli iteratori o delle sottoliste.
 * <br>
 * <br>
 * <strong>Execution Variables</strong>: Le variabili utilizzate sono due HList
 * l1 e l2, un
 * HListIterator li e un array di stringhe argv. In alcuni test sono poi
 * utilizzate altre variabili
 * quando necessarie.
 */
public class TestList {
	HList l1 = null, l2 = null;
	HListIterator li = null;
	static String[] argv = { "pippo", "qui", "pluto", "paperino", "qui", "ciccio" };

	/**
	 * Questo metodo viene eseguito una volta prima di ogni test della classe
	 * <strong>TestList</strong>,
	 * stampa una stringa e inizializza una lista vuota.
	 */
	@Before
	public void setup() {
		System.out.println("Instantiate an empty List");
		l1 = new StackAdapter();
	}

	/**
	 * Questo metodo viene eseguito una volta dopo ogni test della classe
	 * <strong>TestList</strong>,
	 * stampa una stringa e rimuove tutti gli elementi dalla lista l1.
	 */
	@After
	public void cleanup() {
		System.out.println("Purge all remaining elements");
		l1.clear();
	}

	/**
	 * <strong>TestBacking</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il corretto legame tra una lista
	 * e una sua sottolista.
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: In questo test vengono aggiunti e tolti
	 * elementi da una lista e da una sua
	 * sottolista, poi controllate le loro dimensioni e la corretta modifica della
	 * lista principale quando
	 * viene modificata la sua sottolista.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Attraverso il metodo add() vengono
	 * aggiunti degli elementi alla lista l1
	 * da cui viene poi creata una sottolista l2 con il metodo subList(). Vengono
	 * controllate con delle
	 * variabili le dimensioni delle due liste e la loro corretta modifica quando
	 * vengono aggiunti e tolti
	 * elementi dalla sottolista l2 con i metodi add(), remove() e clear(). Vengono
	 * costruiti degli iteratori
	 * e stampati gli elementi delle liste attraverso il metodo iterate(). Tutti i
	 * controlli vengono effettuati
	 * con il metodo assertEquals().
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata una lista l1,
	 * istanziato un iteratore li
	 * e creato un array argv. I metodi add(), remove(), iterator(), iterate(),
	 * sublist(), size() e clear()
	 * devono funzionare correttamente.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve contenere alcuni elementi e
	 * la sua sottolista l2 deve
	 * essere vuota. Devono essere stati stampati gli elementi delle liste e alcune
	 * stringhe.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Il test viene superato se vengono stampati
	 * solo i messaggi attesi e non
	 * i messaggi di errori stampati quando non vengono superati gli assertEquals().
	 */
	@Test
	public void testBacking() {
		System.out.println("TestBacking");
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		System.out.println("List.toString() ? " + l1);

		int dl0, dl1, dli, dsl0, dsl1, dsli;

		iterate(l1.iterator());
		System.out.println(l1 + " " + l1.size());
		dl0 = l1.size();

		l2 = l1.subList(0, argv.length / 2);
		dsl0 = l2.size();

		l2.add("pipperissimo");
		dli = l1.size();
		dsli = l2.size();

		assertEquals("\n*** sublist add is NOT backed correctly ***\n", dli, dl0 + 1);
		assertEquals("\n*** sublist add is NOT backed correctly ***\n", dsli, dsl0 + 1);

		l2.remove("pipperissimo");
		assertEquals("\n*** list remove is NOT backed correctly ***\n", l1.size(), dl0);
		assertEquals("\n*** list remove is NOT backed correctly ***\n", l2.size(), dsl0);

		iterate(l2.iterator());
		System.out.println(l2 + " " + l2.size());

		l2.clear();
		dl1 = l1.size();
		dsl1 = l2.size();
		System.out.println(l1 + " " + l1.size());
		iterate(l1.iterator());
		System.out.println(l2 + " " + l2.size());
		iterate(l2.iterator());

		System.out.println(dl0 + " " + dl1 + " " + dsl0 + " " + dsl1);
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dsl0, (dl0 / 2));
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dsl1, 0);
		assertEquals("\n*** sublist is NOT backed correctly ***\n", dl1, (dl0 - dsl0));

	}

	/**
	 * <strong>Test delle sottoliste ricorsive</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Questo test controlla il funzionamento delle
	 * sottoliste, in particolare delle
	 * sottoliste delle sottoliste.
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: In questo test vengono aggiunti degli
	 * elementi alla lista iniziale la cui
	 * lunghezza viene controllata dopo alcuni inserimenti. Vengono costruite
	 * diverse sottoliste della lista
	 * iniziale che la sostituiscono ad ogni iterazione per controllare il
	 * funzionamento delle sottoliste
	 * delle sottoliste.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Il test utilizza i metodi add() e size()
	 * per aggiungere elementi alla
	 * lista l1 iniziale e controllare la corretta modifica della lunghezza della
	 * lista attraverso degli
	 * assertEquals() che ne confrontano la dimensione. Vengono stampati con il
	 * metodo iterate() gli elementi
	 * della lista con un iteratore creato con il metodo iterator(). La lista l1
	 * viene sostituita poi da
	 * una sua sottolista di dimensione inferiore, creata con subList(), finché l1
	 * non ha dimensione
	 * inferiore a 2, in modo da controllare il funzionamento ricorsivo delle liste.
	 * ogni volta che la
	 * lista l1 viene sostituita da una sua sottolista ne vengono stampati gli
	 * elementi con il metodo iterate().
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata una lista l1
	 * vuota e creato un array argv
	 * non vuoto. I metodi size(), add(), e subList() devono funzionare
	 * correttamente.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve avere un numero di elementi
	 * minore di 2. Devono essere
	 * stati stampati gli elementi della lista e alcune stringhe.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Per il successo del test devono essere
	 * stampati alcune stringhe e più volte
	 * gli elementi della lista l1 iniziale e delle sottoliste successivamente
	 * create ma nessuno dei messaggi
	 * di errore degli assertEquals().
	 */
	@Test
	public void testRecursiveSublist() {
		System.out.println("TestRecursive SubListing");
		System.out.println(l1.size());

		assertEquals("List Starts not empty", l1.size(), 0);
		int prev = l1.size();
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		assertEquals("List add not working correctly", l1.size(), (prev + argv.length));
		System.out.println(l1.size());
		prev = l1.size();
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		assertEquals("List add not working correctly", l1.size(), (prev + argv.length));
		System.out.println(l1.size());
		prev = l1.size();
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		assertEquals("List add not working correctly", l1.size(), (prev + argv.length));
		System.out.println(l1.size());
		iterate(l1.iterator());

		int after = 0;
		int count = 0;
		while (l1.size() >= 2) {
			count++;
			prev = l1.size();
			l1 = l1.subList(1, prev - 1);
			after = l1.size();
			System.out.println(after);
			assertEquals("Iterative Sublisting not working at " + count + " iteration", after, (prev - 2));
			iterate(l1.iterator());
		}
	}

	/**
	 * <strong>Test numero 3 sull'iteratore</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento di alcuni metodi
	 * dell'iteratore
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Vengono aggiunti alla lista degli oggetti
	 * e viene poi percorsa la lista.
	 * Vengono rimossi uno a uno tutti gli elementi della lista, che vengono
	 * stampati più volte durante il
	 * test.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Vengono aggiunti alla lista l1 tutti gli
	 * elementi dell'array argv con il
	 * metodo add(). Vengono stampati tutti gli elementi della lista con il metodo
	 * iterate() su un iteratore
	 * creato con il metodo iterator(). Viene inizializzato l'iteratore li con un
	 * iteratore creato sulla lista
	 * l1 con il metodo listIterate(). Con l'iteratore li si percorre con i metodi
	 * hasNext() e next() tutta la
	 * lista l1 che poi si ripercorre al contrario con hasPrevious() e previous()
	 * eliminando l'ultimo elemento
	 * uno alla volta con il metodo remove(), stampando con iterate() la lista
	 * rimanente prima di ogni
	 * rimozione. Vengono controllate con degli int e degli assertEquals() le
	 * dimensioni della lista dopo
	 * tutte le addizioni e le rimozioni della lista.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata una lista l1,
	 * istanziato un iteratore li e
	 * creato un array argv non vuoto. I metodi add(), size(), iterate(),
	 * iterator(), listIterator(), hasNext(),
	 * next(), hasPrevious(), previous() e remove() devono essere correttamente
	 * funzionanti.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista 1 deve essere vuota e l'iteratore
	 * deve essere stato inizializzato.
	 * Devono essere stati stampati gli elementi della lista e alcune stringhe.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato vengono stampati
	 * varie volte gli elementi della
	 * lista l1 ma non viene stampato alcun messaggio di errore dai metodi
	 * assertEquals().
	 */
	@Test
	public void testIterator3() {
		System.out.println("TestListIterator #3");
		int dl0, dl1, dl2;

		dl0 = l1.size();
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		dl1 = l1.size();
		iterate(l1.iterator());
		li = l1.listIterator();
		while (li.hasNext())
			li.next();
		while (li.hasPrevious()) {
			System.out.print(li.previous() + " ");
			iterate(l1.iterator());
			li.remove();
		}
		dl2 = l1.size();
		iterate(l1.iterator());

		assertEquals("\n*** insertion and forward to end and backward removal not working ***\n", dl1,
				(dl0 + argv.length));
		assertEquals("\n*** insertion and forward to end and backward removal not working ***\n", dl2, 0);
	}

	/**
	 * <strong>Test numero 2 sull'iteratore</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento di alcuni metodi
	 * dell'iteratore.
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Vengono aggiunti alla lista degli oggetti
	 * che vengono tolti uno alla
	 * volta percorrendo la lista con un iteratore.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Vengono aggiunti alla lista l1 gli oggetti
	 * dell'array argv attraverso
	 * l'utilizzo del metodo add(). L'iteratore li viene inizializzato con un
	 * iteratore creato sulla lista l1
	 * con il metodo listIterator(). Viene percorsa tutta la lista l1 con i metodi
	 * hasNext() e next(), e
	 * vengono rimossi tutti gli elementi della lista in ordine con il metodo
	 * remove(). Vengono stampati
	 * gli elementi della lista l1 con il metodo iterate() dopo aver aggiunto tutti
	 * gli elementi dell'array,
	 * prima di ogni rimozione e dopo tutte le rimozioni. Vengono controllate le
	 * corrette modifiche alla lista
	 * e alla sua dimensione con degli int e con i metodi size() e assertEquals().
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata una lista l1,
	 * istanziato e posto uguale a null
	 * un iteratore li e creato un array argv. Devono funzionare correttamente i
	 * metodi size(), add(), iterate(),
	 * iterator(), listIterator(), hasNext(), next() e remove().
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve essere vuota e l'iteratore
	 * li deve essere stato inizializzato.
	 * Devono essere stati stampati gli elementi della lista e alcune stringhe.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato devono essere
	 * stati stampati una stringa e più
	 * volte gli elementi della lista l1 ma nessun messaggio di errore degli
	 * assertEquals().
	 */
	@Test
	public void testIterator2() {
		System.out.println("TestListIterator #2");
		int dl0, dl1, dl2;
		dl0 = l1.size();
		for (int i = 0; i < argv.length; i++) {
			l1.add(argv[i]);
		}
		dl1 = l1.size();
		iterate(l1.iterator());
		li = l1.listIterator();
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
			iterate(l1.iterator());
			li.remove();
		}
		dl2 = l1.size();
		iterate(l1.iterator());

		assertEquals("\n*** insertion and forward removal not working ***\n", dl1, (dl0 + argv.length));
		assertEquals("\n*** insertion and forward removal not working ***\n", dl2, 0);
	}

	/**
	 * <strong>Test numero 1 sull'iteratore</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento di alcuni metodi
	 * dell'iteratore.
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene creato un iteratore alla fine della
	 * lista che viene percorsa al
	 * contrario rimuovendo un elemento alla volta.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Viene inizializzato l'iteratore li con un
	 * iteratore creato alla fine della
	 * lista l1 con il metodo listIterator(int index). La lista viene percorsa al
	 * contrario con i metodi
	 * hasPrevious() e previous(), e viene rimosso l'ultimo elemento della lista con
	 * il metodo remove() ad ogni
	 * passo indietro dell'iteratore. Vengono stampati più volte gli elementi della
	 * lista l1 con il metodo
	 * iterate() con un iteratore creato con il metodo iterator(). Viene controllata
	 * la dimensione della
	 * lista l1 alla fine del test con il metodo assertEquals() e size().
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata una lista l1
	 * e deve essere stato istanziato e
	 * posto uguale a null un iteratore li. I metodi iterate(), iterator(),
	 * listIterator(int index),
	 * hasPrevious(), previous(), size() e remove() devono funzionare correttamente.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve essere vuota e l'iteratore
	 * li deve essere stato inizializzato.
	 * Devono essere stati stampati gli elementi della lista e alcune stringhe.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Il test viene superato se viene stampata
	 * una stringa iniziale e vengono
	 * stampati più volte gli elementi della lista l1, ma nessun messaggio di errore
	 * degli assertEquals().
	 */
	@Test
	public void testIterator1() {
		System.out.println("TestListIterator #1");
		iterate(l1.iterator());
		li = l1.listIterator(l1.size());
		while (li.hasPrevious()) {
			System.out.print(li.previous() + " ");
			iterate(l1.iterator());
			li.remove();
		}
		iterate(l1.iterator());

		assertEquals("\n*** listiterator from end not working ***\n", l1.size(), 0);
	}

	public static void iterate(HIterator iter) {
		System.out.print("{");
		while (iter.hasNext()) {
			System.out.print(iter.next() + "; ");
		}
		System.out.println("}");
	}
}
