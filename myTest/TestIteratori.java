package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

/**
 * <strong>Class TestIteratori</strong>
 * <p>
 * <br>
 * <br>
 * <strong>Summary</strong>: La classe TestIteratori controlla con i suoi test
 * il funzionamento dei
 * metodi che costruiscono degli iteratori e dei metodi degli iteratori stessi.
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: Questa classe contiene 3 test cases che
 * testano 3 differenti
 * metodi della classe StackAdapter(), ciascuno dei quali costruisce un
 * iteratore per una collezione o per
 * una lista. Nel caso sia un iteratore di una lista, può essere costruito in
 * una differente posizione.
 * <br>
 * <br>
 * <strong>Pre-Condition</strong>: Prima di ogni test deve essere inizializzata
 * almeno una lista e
 * in questa devono essere sempre presenti degli elementi.
 * <br>
 * <br>
 * <strong>Post-Condition</strong>: Dopo ogni test deve essere stato creato
 * almeno un iteratore per
 * almeno una lista e devono essere stati provati i suoi metodi.
 * <br>
 * <br>
 * <strong>Test Cases</strong>: I test cases di questa classe sono 3 e sono:
 * testIterator(),
 * testListIterator(), testListIteratorAtIndex(). Ciascuno di essi serve a
 * testare un metodo diverso
 * della classe StackAdapter e alcuni dei metodi degli iteratori.
 * <br>
 * <br>
 * <strong>Execution Variables</strong>: Le variabili utilizzate sono due
 * StackAdapter l1 e l2, la
 * prima utilizzata in tutti i test e la seconda solo dove necessario, e un
 * array di Object arr utilizzato
 * per inserire elementi nelle liste. In alcuni test sono poi utilizzate altre
 * variabili quando necessarie.
 * 
 * @author Marco Zennaro
 */
public class TestIteratori {

    StackAdapter l1 = null, l2 = null;
    Object[] arr = new Object[] { "Pippo", "Pluto", "Paperino", "Topolino", "Pippo", null };

    /**
     * Questo metodo viene eseguito una volta prima di ogni test della classe
     * <strong>TestIteratori</strong>,
     * stampa una stringa e inizializza e aggiunge elementi in una lista.
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
     * Questo metodo viene eseguito una volta dopo ogni test della classe
     * <strong>TestIteratori</strong>,
     * stampa una stringa, rimuove tutti gli elementi dalla lista l1 e pone uguale a
     * null la lista l2.
     */
    @After
    public void cleanup() {
        System.out.println("Rimuove tutti gli elementi dalla lista l1 e pone uguale a null la lista l2");
        l1.clear();
        l2 = null;
    }

    /**
     * <strong>Test di {@link myAdapter.StackAdapter#iterator()} e dei metodi
     * dell'iteratore</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
     * iterator() e dei
     * metodi dell'iteratore di una collezione.
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Viene creato un iteratore su una lista e
     * vengono usati
     * i metodi dell'iteratore su questo per testarne il funzionamento.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Viene creato un iteratore iter con il
     * metodo iterator()
     * e vengono testati i metodi hasNext(), next() e remove() su questo nei vari
     * casi validi e non validi.
     * Vengono catturate le varie eccezioni lanciate dai metodi e vengono stampate
     * delle stringhe di avviso
     * di cattura delle eccezioni. Il funzionamento dei metodi sull'iteratore viene
     * controllato con i metodi
     * assertNotEquals() e assertFalse().
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1 e
     * istanziata una lista l2.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: Deve essere stata modificata la lista l1 e
     * deve essere
     * stata inizializzata una lista l2 vuota. Deve esserci un iteratore sulla lista
     * vuota l2.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Se il test viene superato devono essere
     * stampate solo le
     * stringhe di avviso di cattura delle eccezioni ma non le stringhe legate agli
     * errori dei metodi
     * assertFalse() e assertNotEquals().
     */
    @Test
    public void testIterator() {
        HIterator iter = l1.iterator();
        while (iter.hasNext()) {
            iter.next();
        }
        assertFalse("L'iteratore non è giunto alla fine della lista", iter.hasNext());
        int dim = l1.size();
        iter.remove();
        assertNotEquals("La dimensione della lista non è cambiata", dim, l1.size());
        try {
            iter.remove();
        } catch (IllegalStateException ise) {
            System.out.println("Non è possibile chiamare il metodo remove due volte di seguito");
        }
        try {
            iter.next();
        } catch (NoSuchElementException nsee) {
            System.out.println("Non è possibile chiamare il metodo next se l'iteratore è giunto alla fine della lista");
        }
        l2 = new StackAdapter();
        iter = l2.iterator();
        assertFalse("La lista non è vuota", iter.hasNext());
        try {
            iter.next();
        } catch (NoSuchElementException nsee) {
            System.out.println("Non è possibile chiamare il metodo next se la lista è vuota");
        }
        try {
            iter.remove();
        } catch (IllegalStateException ise) {
            System.out.println("Non è possibile chiamare il metodo remove se la lista è vuota");
        }
    }

    /**
     * <strong>Test di {@link myAdapter.StackAdapter#listIterator()} e dei metodi
     * dell'iteratore di una lista</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
     * listIterator() e
     * dei metodi dell'iteratore di una lista
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Viene creato un iteratore su una lista e
     * vengono usati
     * i metodi dell'iteratore su questo per testarne il funzionamento.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Viene creato un iteratore iter con il
     * metodo listIterator()
     * e vengono testati i metodi hasNext(), next(), nextIndex(), hasPrevious(),
     * previous(), previousIndex(),
     * add(), remove() e set() su questo nei vari casi validi e non validi.
     * Vengono catturate le varie eccezioni lanciate dai metodi e vengono stampate
     * delle stringhe di avviso
     * di cattura delle eccezioni. Il funzionamento dei metodi sull'iteratore viene
     * controllato con i metodi
     * assertEquals(), assertNotEquals() e assertFalse().
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: La lista l1 deve essere stata modificata e
     * l'iteratore iter
     * deve essere stato creato e trovarsi all'inizio della lista l1.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Se il test viene superato devono essere
     * state stampate
     * solo le stringhe legate alla cattura delle eccezioni lanciate dai metodi ma
     * non le stringhe legate
     * agli errori dei metodi assertFalse(), assertEquals() e assertNotEquals().
     */
    @Test
    public void testListIterator() {
        HListIterator iter = l1.listIterator();
        assertFalse("L'iteratore è nella posizione sbagliata", iter.hasPrevious());
        try {
            iter.previous();
        } catch (NoSuchElementException nsee) {
            System.out.println("Il metodo previous non può essere chiamato se l'iteratore è all'inizio della lista");
        }
        assertEquals("L'iteratore è nella posizione sbagliata", -1, iter.previousIndex());
        try {
            iter.remove();
        } catch (IllegalStateException ise) {
            System.out.println("Non può essere chiamato il metodo remove all'inizio della lista");
        }
        try {
            iter.set("Ciccio");
        } catch (IllegalStateException ise) {
            System.out.println("Non può essere chiamato il metodo set senza una chiamata precedente a next o previous");
        }
        assertEquals("L'indice successivo è sbagliato", 0, iter.nextIndex());
        assertEquals("L'elemento restituito è errato", "Pippo", iter.next());
        assertEquals("L'indice successivo è sbagliato", 1, iter.nextIndex());
        int dim = l1.size();
        iter.add("Ciccio");
        iter.add("Bello");
        assertNotEquals("La dimensione della lista non è cambiata", dim, l1.size());
        while (iter.hasNext()) {
            iter.next();
        }
        iter.remove();
        assertEquals("L'indice restituito è errato", 6, iter.previousIndex());
        assertEquals("L'elemento restituito è sbagliato", "Pippo", iter.previous());
        while (iter.hasPrevious()) {
            iter.previous();
        }
        iter.set("Goku");
    }

    /**
     * <strong>Test di {@link myAdapter.StackAdapter#listIterator(int index)} e dei
     * metodi dell'iteratore di una lista</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
     * listIterator(int index)
     * e dei metodi dell'iteratore di una lista.
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Viene creato un iteratore su una lista e
     * vengono usati
     * i metodi dell'iteratore su questo per testarne il funzionamento.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Viene inizializzata la lista l2 vuota e
     * viene provato a
     * creare su questa un iteratore in una posizione non valida. Viene creato un
     * iteratore iter sulla
     * lista l1 con il metodo listIterator(int index) e vengono testati i metodi
     * hasNext(), next(),
     * nextIndex(), hasPrevious(), previous(), previousIndex(), add(), remove() e
     * set() su questo nei vari
     * casi validi e non validi. Vengono catturate le varie eccezioni lanciate dai
     * metodi e vengono stampate
     * delle stringhe di avviso di cattura delle eccezioni. Il funzionamento dei
     * metodi sull'iteratore
     * viene controllato con i metodi assertEquals() e assertTrue().
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1 e deve
     * essere stata istanziata una lista l2.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: La lista 1 deve essere stata modificata e la
     * lista 2 deve
     * essere stata inizializza ma deve essere vuota. L'iteratore iter deve essere
     * stato creato e deve
     * trovarsi alla fine della lista l1.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Se il test viene superato devono essere
     * state stampate
     * solo le stringhe legate alla cattura delle eccezioni e non quelle legate agli
     * errori dei metodi
     * assertTrue() e assertEquals().
     */
    @Test
    public void testListIteratorAtIndex() {
        l2 = new StackAdapter();
        HListIterator iter = null;
        try {
            iter = l2.listIterator(1);
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println(
                    "Impossibile creare un iteratore in una posizione di indice maggiore alla dimensione della lista");
        }
        iter = l1.listIterator(3);
        assertTrue("La posizione dell'iteratore è sbagliata", iter.hasPrevious());
        assertEquals("L'elemento restituito non è corretto", "Paperino", iter.previous());

        assertTrue("La posizione dell'iteratore è sbagliata", iter.hasNext());
        assertEquals("L'elemento restituito non è corretto", "Paperino", iter.next());
        assertEquals("L'elemento restituito non è corretto", "Topolino", iter.next());
        int dim = l1.size();
        iter.set("Ciccio");
        assertEquals("La dimensione della lista non deve cambiare", dim, l1.size());
        assertEquals("L'elemento non è stato modificato correttamente", "Ciccio", iter.previous());
        iter.remove();
        assertEquals("La dimensione della lista non è cambiata correttamente", dim - 1, l1.size());
        assertEquals("L'elemento non è stato rimosso correttamente", "Pippo", iter.next());
        assertEquals("L'indice restituito non è corretto", 4, iter.nextIndex());
        assertEquals("L'indice restituito non è corretto", 3, iter.previousIndex());
        iter.add("Goku");
        assertEquals("La dimensione della lista non è cambiata correttamente", dim, l1.size());
        assertEquals("L'indice restituito non è corretto", 5, iter.nextIndex());
        while (iter.hasPrevious()) {
            iter.previous();
        }
        try {
            iter.previous();
        } catch (NoSuchElementException nsee) {
            System.out.println("Non è possibile chiamare previous all'inizio della lista");
        }
        while (iter.hasNext()) {
            iter.next();
        }
        try {
            iter.next();
        } catch (NoSuchElementException nsee) {
            System.out.println("Non è possibile chiamare next alla fine della lista");
        }
        iter.remove();
        try {
            iter.remove();
        } catch (IllegalStateException ise) {
            System.out.println("Non è possibile chiamare remove due volte consecutive");
        }
        try {
            iter.set("Vegeta");
        } catch (IllegalStateException ise) {
            System.out.println("Non è possibile chiamare set dopo aver chiamato remove");
        }
        iter.add("Vegeta");
        try {
            iter.remove();
        } catch (IllegalStateException ise) {
            System.out.println("Non è possibile chiamare remove dopo un add");
        }
    }
}
