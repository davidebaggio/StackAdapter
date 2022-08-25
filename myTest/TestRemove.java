package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * <strong>Class TestRemove</strong>
 * <p>
 * <br>
 * <br>
 * <strong>Summary</strong>: La classe TestRemove controlla con i suoi test il
 * funzionamento dei
 * metodi che rimuovono oggetti da una lista.
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: Questa classe contiene 5 test cases che
 * testano 5 differenti
 * metodi della classe StackAdapter(), ciascuno dei quali rimuove uno o più
 * elementi secondo diversi criteri.
 * <br>
 * <br>
 * <strong>Pre-Condition</strong>: Prima di ogni test deve essere inizializzata
 * almeno una lista e
 * in questa devono essere sempre presenti degli elementi.
 * <br>
 * <br>
 * <strong>Post-Condition</strong>: Dopo ogni test deve essere stata fatta
 * almeno una rimozione
 * da almeno una lista.
 * <br>
 * <br>
 * <strong>Test Cases</strong>: I test cases di questa classe sono 5 e sono:
 * testRemoveObj(),
 * testRemoveAtIndex(), testRemoveAll(), testClear() e testRetainAll(). Ciascuno
 * di essi serve a testare un
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
public class TestRemove {

    private StackAdapter l1 = null, l2 = null;
    Object[] arr = new Object[] { "Pippo", "Pluto", "Paperino", "Topolino", "Pippo" };

    /**
     * Questo metodo viene eseguito una sola volta prima di iniziare a eseguire i
     * test della classe
     * <strong>TestRemove</strong> e stampa una stringa che segnala l'inizio dei
     * test di questa classe.
     */
    @BeforeClass
    public static void beforeTestRemoveClass() {
        System.out.println("Inizio test della classe TestRemove");
    }

    /**
     * Questo metodo viene eseguito una sola volta dopo che sono stati eseguiti
     * tutti i test della classe
     * <strong>TestRemove</strong> e stampa una stringa che segnala la fine dei test
     * di questa classe.
     */
    @AfterClass
    public static void afterTestRemoveClass() {
        System.out.println("Fine test della classe TestRemove");
    }

    /**
     * Questo metodo viene eseguito una volta prima di ogni test della classe
     * <strong>TestRemove</strong>,
     * stampa una stringa e inizializza e aggiunge elementi in una lista.
     */
    @Before
    public void setup() {
        System.out.println("Inizializza e aggiunge elementi alla lista l1");
        l1 = new StackAdapter();
        for (int i = 0; i < 5; i++) {
            l1.add(arr[i]);
        }

    }

    /**
     * Questo metodo viene eseguito una volta dopo ogni test della classe
     * <strong>TestRemove</strong>,
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
     * <strong>Test di {@link myAdapter.StackAdapter#remove(Object obj)}</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionmento del metodo
     * remove(Object obj).
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Vengono rimossi diversi elementi da una
     * lista per controllare il corretto
     * funzionamento della rimozione.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Il test prova a rimuovere dalla l1
     * precedentemente inizializzata e
     * riempita un elemento null non presente nella lista e poi un elemento presente
     * nella lista con il
     * metodo remove(). Viene aggiunto un elemento null alla lista con il metodo
     * add() per provare la
     * rimozione di un elemento null con il metodo remove. Con l'ausilio di una
     * variabile boolean e una
     * variabile int si controlla attraverso i metodi assertTrue(), assertFalse() e
     * assertEquals()
     * che le varie rimozioni abbiano avuto successo e la dimensione della lista sia
     * cambiata correttamente.
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: La lista l1 deve contenere tutti gli
     * elementi iniziali tranne uno che
     * è stato rimosso e nessun nuovo elemento. La sua dimensione deve essere
     * diminuita di 1.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Se il test ha successo non viene stampata
     * nessuna stringa perché tutte
     * legate agli errori di assertTrue(), assertFalse() e assertEquals().
     */
    @Test
    public void testRemoveObj() {
        boolean removed = l1.remove(null);
        int dim = l1.size();
        assertFalse("Errore nella rimozione di un oggetto non presente nella lista", removed);
        removed = l1.remove("Paperino");
        assertTrue("L'elemento non è stato rimosso correttamente", removed);
        l1.add(null);
        removed = l1.remove(null);
        assertTrue("L'elemento non è stato rimosso correttamente", removed);
        assertEquals("La dimensione della lista non è cambiata correttamente", dim - 1, l1.size());
    }

    /**
     * <strong>Test di {@link myAdapter.StackAdapter#remove(int index)}</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
     * remove(int index).
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Viene testata la rimozione di oggetti in
     * posizioni di indici diversi, tra
     * cui indici non validi per testare il lancio di eccezioni.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Viene testata la rimozione di elementi in
     * posizioni di indici validi e
     * non validi, ad esempio indici minori di 0 e indici maggiori della dimensione
     * della l1. Vengono
     * catturate le eccezioni lanciate dal metodo remove(int index) con parametri
     * non validi e vengono
     * stampati dei messaggi di avviso di cattura. Vengono confrontati gli elementi
     * rimossi con gli elementi
     * che dovevano essere rimossi attraverso l'utilizzo degli assertEquals() e
     * viene controllato il corretto
     * cambiamento della dimensione della lista con l'ausilio di una variabile int e
     * del metodo size().
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: La dimensione della l1 deve essere diminuita
     * di 2 e la l1 non deve
     * contenere nuovi elementi.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Se il test viene superato devono essere
     * state stampate due stringhe alla
     * cattura delle eccezioni ma nessun messaggio di errore legato agli
     * assertEquals().
     */
    @Test
    public void testRemoveAtIndex() {
        int dim = l1.size();
        Object removed = null;
        try {
            removed = l1.remove(-1);
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Non è possibile rimuovere un elemento da una posizione di indice minore di 0");
        }
        try {
            removed = l1.remove(6);
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println(
                    "Non è possibile rimuovere un elemento da una posizione di indice uguale o maggiore alla dimensione della lista");
        }
        removed = l1.remove(3);
        assertEquals("L'elemento in posizione di indice 3 non è stato rimosso correttamente", "Topolino", removed);
        removed = l1.remove(0);
        assertEquals("L'elemento in posizione di indice 0 non è stato rimosso correttamente", "Pippo", removed);
        assertEquals("Un elemento non è stato rimosso correttamente", dim - 2, l1.size());
    }

    /**
     * <strong>Test di
     * {@link myAdapter.StackAdapter#removeAll(HCollection coll)}</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
     * removeAll(HCollection).
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Il metodo viene testato applicandolo su
     * una lista passando come parametro
     * un'altra lista.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Viene usato il metodo sulla lista l1
     * passando come parametro la lista l2
     * prima uguale a null, poi inizializzata con il metodo StackAdapter() ma vuota
     * e infine dopo aver
     * inserito alcuni elementi con add(). Viene controllato il lancio
     * dell'eccezione quando viene passata
     * la lista l2 uguale a null. Vengono testati con assertTrue(), assertFalse() e
     * assertEquals(), con
     * l'ausilio di una variabile boolean, una int e il metodo size(), gli
     * inserimenti riusciti e la
     * corretta modifica della dimensione della lista l1.
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1, istanziata e posta
     * uguale a null una lista l2 e inizializzato un array arr con almeno due
     * elementi nelle prime due
     * posizioni.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: La lista l1 deve contenere 3 elementi in
     * meno rispetto all'inizio del test
     * e non deve contenere nessun elemento nuovo o appartenente alla lista l2.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Il test viene superato se viene stampata
     * una stringa alla cattura
     * dell'eccezione e nessuna stringa legata agli errori dei metodi
     * assertEquals(), assertTrue() e
     * assertFalse().
     */
    @Test
    public void testRemoveAll() {
        boolean removed = false;
        try {
            removed = l1.removeAll(l2);
        } catch (NullPointerException npe) {
            System.out.println("Impossibile rimuovere da una lista uguale a null");
        }
        l2 = new StackAdapter();
        removed = l1.removeAll(l2);
        assertFalse("Sono stati rimossi degli elementi dalla lista 1 nonostante la lista 2 sia vuota", removed);
        l2.add(arr[0]);
        l2.add(arr[1]);
        int dim = l1.size();
        removed = l1.removeAll(l2);
        assertTrue("La rimozione degli elementi della lista 2 dalla lista 1 non è andata a buon fine", removed);
        assertEquals("La rimozione di qualche elemento non è andata a buon fine", dim - 3, l1.size());
    }

    /**
     * <strong>Test di {@link myAdapter.StackAdapter#clear()}</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
     * clear().
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Viene testato il metodo applicandolo più
     * volte alla stessa lista.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Il metodo clear() da testare viene
     * applicato due volte
     * alla stessa lista l1, la prima volta mentre contiene elementi e la seconda
     * dopo averli eliminati con
     * il primo utilizzo del metodo. Con l'ausilio del metodo isEmpty(), si
     * controlla che la lista l1 non sia
     * inizialmente vuota e lo sia successivamente all'utilizzo del metodo clear()
     * attraverso i metodi
     * assertFalse() e assertTrue().
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: La lista l1 deve essere stata inizializzata e
     * riempita.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: La lista l1 deve essere vuota.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Il test viene superato se non viene
     * stampata alcuna stringa
     * di errore legata ai metodi assertFalse() e assertTrue().
     */
    @Test
    public void testClear() {
        assertFalse("La lista 1 è vuota", l1.isEmpty());
        l1.clear();
        assertTrue("La lista non è vuota", l1.isEmpty());
        l1.clear();
        assertTrue("La lista non è vuota", l1.isEmpty());
    }

    /**
     * <strong>Test di
     * {@link myAdapter.StackAdapter#retainAll(HCollection coll)}</strong>
     * <p>
     * <br>
     * <br>
     * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
     * retainAll(HCollection coll).
     * <br>
     * <br>
     * <strong>Test Case Design</strong>: Viene modificata più volte una lista l2
     * che viene passata
     * come parametro del metodo retainAll() applicato alla lista l1.
     * <br>
     * <br>
     * <strong>Test Description</strong>: Viene inizializzata e riempita con degli
     * oggetti una lista
     * l2, che viene passata come parametro più volte al metodo retainAll()
     * applicato alla lista l1. Vengono
     * rimossi un po' alla volta degli elementi dalla lista l2 e si ripete
     * l'operazione di retainAll(). Il
     * corretto funzionamento del metodo viene testato con degli assertEquals() e un
     * assertTrue() che
     * con l'ausilio di alcune variabili di tipo int controllano la corretta
     * modifica delle dimensioni
     * delle liste dopo le rimozioni.
     * <br>
     * <br>
     * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
     * una lista l1
     * e deve essere stata istanziata e posta uguale a null una lista l2.
     * <br>
     * <br>
     * <strong>Post-Condition</strong>: La lista l1 e la lista l2 devono essere
     * entrambe vuote.
     * <br>
     * <br>
     * <strong>Expected results</strong>: Se il test viene superato non viene
     * stampata alcuna
     * stringa perche' legate agli arrori dei metodi assertEquals() e assertTrue().
     */
    @Test
    public void testRetainAll() {
        l2 = new StackAdapter();
        for (int i = 0; i < l1.size(); i++) {
            l2.add(l1.get(i));
        }
        assertEquals("La lista 2 non è uguale alla lista 1", l1, l2);
        l1.retainAll(l2);
        assertEquals(
                "Non sono stati rimossi correttamente dalla lista 1 gli elementi che non appartengono alla lista 2", l2,
                l1);
        l2.remove("Pippo");
        l1.retainAll(l2);
        int dim1 = l1.size();
        int dim2 = l2.size();
        assertEquals("La dimensione della lista 1 è uguale da quella della lista 2", dim2 + 1, dim1);
        l2.remove("Pippo");
        l1.retainAll(l2);
        dim1 = l1.size();
        dim2 = l2.size();
        assertEquals("La dimensione della lista 1 è diversa da quella della lista 2", dim2, dim1);
        l2.clear();
        l1.retainAll(l2);
        assertTrue("La lista 1 non è vuota", l1.isEmpty());
    }
}
