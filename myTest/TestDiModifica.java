package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * <strong>Class TestDiModifica</strong>
 * <p>
 * <br>
 * <br>
 * <strong>Summary</strong>: La classe TestDiModifica controlla con i suoi test
 * il funzionamento dei
 * metodi che modificano la lista o la copiano per intero o in parte.
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: Questa classe contiene 4 test cases che
 * testano 4 differenti
 * metodi della classe StackAdapter(), ciascuno dei quali modifica
 * la lista o la copia per intero o in parte.
 * <br>
 * <br>
 * <strong>Pre-Condition</strong>: Prima di ogni test deve essere inizializzata
 * almeno una lista e
 * in questa devono essere sempre presenti degli elementi.
 * <br>
 * <br>
 * <strong>Post-Condition</strong>: Dopo ogni test deve essere stata fatta
 * almeno una modifica o
 * una copia di almeno una lista.
 * <br>
 * <br>
 * <strong>Test Cases</strong>: I test cases di questa classe sono 4 e sono:
 * testSet(),
 * testToArray(), testToArrayInArray() e testSubList(). Ciascuno di essi serve a
 * testare un
 * metodo diverso della classe StackAdapter.
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
public class TestDiModifica {

    StackAdapter l1 = null, l2 = null;
    Object[] arr = new Object[] { "Pippo", "Pluto", "Paperino", "Topolino", "Pippo", null };

    /**
     * Questo metodo viene eseguito una sola volta prima di iniziare a eseguire i
     * test della classe
     * <strong>TestDiModifica</strong> e stampa una stringa che segnala l'inizio dei
     * test di questa classe.
     */
    @BeforeClass
    public static void beforeTestDiModificaClass() {
        System.out.println("Inizio test della classe TestDiModifica");
    }

    /**
     * Questo metodo viene eseguito una sola volta dopo che sono stati eseguiti
     * tutti i test della classe
     * <strong>TestDiModifica</strong> e stampa una stringa che segnala la fine dei
     * test di questa classe.
     */
    @AfterClass
    public static void afterTestDiModificaClass() {
        System.out.println("Fine test della classe TestDiModifica");
    }

    /**
     * Questo metodo viene eseguito una volta prima di ogni test della classe
     * <strong>TestDiModifica</strong>,
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
     * <strong>TestDiModifica</strong>,
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
     * <strong>Test di
     * {@link myAdapter.StackAdapter#set(int index, Object element)}</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
     * set(int index, Object element)
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Viene usato il metodo su una lista piu'
     * volte passando
     * diversi parametri validi e non validi.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Viene usato il metodo set(int index,
     * Object element) piu'
     * volte sulla lista l1 con diversi parametri per modificarne gli elementi.
     * Vengono catturate le
     * eccezioni lanciate dal metodo quando viene passato come parametro un indice
     * di posizione non valido
     * perche' minore di 0 o maggiore o uguale al numero di elementi della lista e
     * vengono stampate delle
     * stringhe di avviso di cattura dell'eccezione. Con il metodo assertEquals() e
     * l'ausilio dei metodi
     * size() e get() si controlla che la dimensione della lista non cambi e che sia
     * inserito l'elemento
     * corretto nella posizione corretta.
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: La dimensione della lista l1 deve restare
     * immutata ma
     * alcuni elementi devono essere stati sostituiti da altri.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Se il test viene superato vengono stampate
     * solo le
     * stringhe che segnalano la cattura delle eccezioni ma nessuna di quelle legate
     * agli errori del metodo
     * assertEquals().
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
     * <strong>Test di {@link myAdapter.StackAdapter#toArray()}</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
     * toArray()
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Viene usato il metodo su due liste
     * differenti per
     * controllarne il funzionamento.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Viene inizializzata una lista l2 vuota e
     * si usa il metodo
     * toArray() su questa per vederne il comportamento su una lista vuota. Viene
     * poi usato il metodo
     * sulla lista l1 che possiede degli elementi e si controlla con l'ausilio del
     * metodo size() che gli
     * array creati siano della stessa dimensione della lista su cui è stato usato
     * il metodo e con
     * l'ausilio del metodo get() che contengano gli stessi elementi.
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1 e
     * istanziata una lista l2.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: La lista l1 deve essere rimasta immutata e
     * la lista l2
     * deve essere stata inizializzata. Deve essere stato creato un array che ha gli
     * stessi elementi della
     * lista l1.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Se il test viene superato non deve essere
     * stata stampata
     * nessuna stringa perche' tutte legate agli errori dei metodi assertEquals().
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
     * <strong>Test di
     * {@link myAdapter.StackAdapter#toArray(Object[] arrayTarget)}</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
     * toarray(Object[] arrayTarget)
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Viene usato il metodo su liste diverse
     * passando come
     * parametri array diverse per testarne il comportamento nei vari casi.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Vengono creati due array di diverse
     * dimensioni. Viene
     * creato poi un terzo array inizializzato con il metodo toArray(Object[]
     * arrayTarget) al quale viene
     * passato come parametro uno dei primi due array creati. Vengono inseriti degli
     * elementi negli array
     * e si controlla che vengano sovrascritti quando tali array vengono passati
     * come parametri al metodo
     * toArray(Object[] arrayTarget) usato su una delle liste. Si controlla con
     * degli assertEquals() che la
     * dimensione degli array creati con il metodo toArray(Object[] arrayTarget) sia
     * corretta e con i metodi
     * assertEquals() e assertNull() che gli elementi dell'array creato
     * corrispondano a quelli della lista
     * o siano uguali a null quando devono.
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1 e
     * deve essere stata istanziata una lista l2.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: Deve essere stata inizializzata la lista l2,
     * la lista l1
     * deve essere rimasta immutata e devono essere stati creati tre array.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Se il test viene superato non viene
     * stampata alcuna
     * stringa perche' tutte legate agli errori dei metodi assertEquals() e
     * assertNull().
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
     * <strong>Test di
     * {@link myAdapter.StackAdapter#subList(int fromIndex, int toIndex)}</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzinamento del metodo
     * subList(int fromIndex, int toIndex)
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Viene creata una sottolista e vengono
     * provati diversi
     * metodi per testare la corretta creazione della sottolista e il funzionamento
     * dei metodi sulla sottolista.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Viene inizializzata una lista l2 vuota e
     * si prova su questa
     * il metodo sublist() con indici non validi per verificare che lanci
     * correttamente l'eccezione.
     * L'eccezione viene catturata e viene stampata una stringa di avviso di
     * cattura. Viene poi creata una
     * sottolista vuota della lista l2 sostituita poi da una lista non vuota della
     * lista l1. Vengono usati
     * vari metodi sulla sottolista per testare che sia stata creata e funzioni
     * correttamente. Il corretto
     * funzionamento dei metodi sulla sottolista e' controllato con i metodi
     * assertTrue(), assertFalse(),
     * assertEquals() e assertNotEquals().
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1 e
     * istanziata una lista l2.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: Devono esserci una lista l1 e una lista l2
     * non vuote e una
     * sottolista sub non vuota e una sottolista sub2 vuota.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Per il superamento del test devono essere
     * stampate solo
     * le stringhe di cattura delle eccezioni ma non le stringhe legate agli errori
     * dei metodi assertTrue(),
     * assertFalse(), assertEquals() e assertNotEquals().
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