package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * <strong>Class TestDiControllo</strong>
 * <p>
 * <br>
 * <br>
 * <strong>Summary</strong>: La classe TestDiControllo controlla con i suoi test
 * il funzionamento
 * dei metodi che ispezionano gli oggetti di una lista senza modificarla.
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: Questa classe contiene 9 test cases che
 * testano 9 differenti
 * metodi della classe StackAdapter(), ciascuno dei quali ispeziona uno o più
 * elementi o una caratteristica
 * della lista.
 * <br>
 * <br>
 * <strong>Pre-Condition</strong>: Prima di ogni test deve essere inizializzata
 * almeno una lista e
 * in questa devono essere sempre presenti degli elementi.
 * <br>
 * <br>
 * <strong>Post-Condition</strong>: Dopo ogni test deve essere stato ispezionato
 * almeno un elemento
 * o una caratteristica della lista.
 * <br>
 * <br>
 * <strong>Test Cases</strong>: I test cases di questa classe sono 9 e sono:
 * testSize(),
 * testIsEmpty(), testGet(), testIndexOf(), testLastIndexOf(), testContains(),
 * testContainsAll(),
 * testEquals() e testHashCode(). Ciascuno di essi serve a testare un metodo
 * diverso della classe StackAdapter.
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
public class TestDiControllo {

	StackAdapter l1 = null, l2 = null;
	Object[] arr = new Object[] { "Pippo", "Pluto", "Paperino", "Topolino", "Pippo", null };

	/**
	 * Questo metodo viene eseguito una sola volta prima di iniziare a eseguire i
	 * test della classe
	 * <strong>TestDiControllo</strong> e stampa una stringa che segnala l'inizio
	 * dei test di questa classe.
	 */
	@BeforeClass
	public static void beforeTestDiControlloClass() {
		System.out.println("Inizio test della classe TestDiControllo");
	}

	/**
	 * Questo metodo viene eseguito una sola volta dopo che sono stati eseguiti
	 * tutti i test della classe
	 * <strong>TestDiControllo</strong> e stampa una stringa che segnala la fine dei
	 * test di questa classe.
	 */
	@AfterClass
	public static void afterTestDiControlloClass() {
		System.out.println("Fine test della classe TestDiControllo");
	}

	/**
	 * Questo metodo viene eseguito una volta prima di ogni test della classe
	 * <strong>TestDiControllo</strong>,
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
	 * <strong>TestDiControllo</strong>,
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
	 * <strong>Test di {@link myAdapter.StackAdapter#size()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
	 * size()
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene testato il metodo applicandolo su
	 * liste diverse
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Viene usato il metodo size() prima sulla
	 * lista l1 che
	 * contiene più elementi, poi sulla lista l2 inizialmente vuota e poi con un
	 * elemento inserito con
	 * il metodo add(). Si controlla che gli int restituiti siano quelli che ci si
	 * aspetta con il metodo
	 * assertEquals().
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
	 * una lista l1
	 * e deve essere stata istanziata una lista l2.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve restare invariata e la
	 * lista l2 deve
	 * contenere un solo elemento.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Il test viene superato se non viene
	 * stampata alcuna
	 * stringa perche' tutte legate agli errori del metodo assertEquals().
	 */
	@Test
	public void testSize() {
		assertEquals("La dimensione della lista 1 non è 6", 6, l1.size());
		l2 = new StackAdapter();
		assertEquals("La lista 2 non è vuota", 0, l2.size());
		l2.add(null);
		assertEquals("La lista 2 non contiene un elemento", 1, l2.size());
	}

	/**
	 * <strong>Test di {@link myAdapter.StackAdapter#isEmpty()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
	 * isEmpty().
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene usato il metodo su due liste
	 * differenti per
	 * verificare che funzioni correttamente.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Il metodo isEmpty() viene usato prima
	 * sulla lista l1 che
	 * contiene degli elementi e poi su una lista l2 inizializzata con il metodo
	 * StackAdapter() ma vuota e
	 * poi che contiene un solo elemento null inserito con il metodo add(). Si
	 * verifica che il boolean
	 * restituito dal metodo isEmpty() sia corretto attraverso l'utilizzo dei metodi
	 * assertTrue() e
	 * assertFalse().
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
	 * una lista l1 e
	 * istanziata una lista l2.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve restare immutata mentre la
	 * lista l2 deve
	 * contenere un solo elemento uguale a null.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Il test viene superato se non viene
	 * stampata alcuna
	 * stringa perche' tutte legate agli errori degli assertTrue() e assertFalse().
	 */
	@Test
	public void testIsEmpty() {
		assertFalse("La lista 1 è vuota", l1.isEmpty());
		l2 = new StackAdapter();
		assertTrue("La lista 2 non è vuota", l2.isEmpty());
		l2.add(null);
		assertFalse("La lista 2 è vuota", l2.isEmpty());
	}

	/**
	 * <strong>Test di {@link myAdapter.StackAdapter#get(int index)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
	 * get(int index)
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene controllato il funzionamento del
	 * metodo applicandolo
	 * alla lista l1 passando indici validi e non validi.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Viene controllato il funzionamento del
	 * metodo get()
	 * usandolo sulla lista l1 e passandogli come parametri un indice minore di 0,
	 * uno maggiore dell'indice
	 * della posizione dell'ultimo elemento della lista e un indice valido. Vengono
	 * catturate le eccezioni
	 * lanciate dal metodo e stampate delle stringhe di avviso di cattura, poi
	 * controllato l'elemento
	 * restituito dal get() con un assertEquals().
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
	 * con meno di
	 * 7 elementi una lista l1.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve rimanere immutata.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato vengono stampate
	 * due stringhe
	 * di avviso di cattura delle eccezioni ma non la stringa legata all'errore del
	 * metodo assertEquals().
	 */
	@Test
	public void testGet() {
		try {
			l1.get(-1);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("Non è possibile restituire un elemento in una posizione di indice minore di 0");
		}
		try {
			l1.get(7);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println(
					"Non è possibile restituire un elemento in una posizione di indice maggiore della dimensione della lista");
		}
		Object obj = l1.get(3);
		assertEquals("L'elemento ispezionato non è Topolino", "Topolino", obj);
	}

	/**
	 * <strong>Test di {@link myAdapter.StackAdapter#indexOf(Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
	 * indexOf(Object obj)
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene testato il metodo usandolo su una
	 * lista piu' volte
	 * con diversi parametri.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Viene usato il metodo indexOf() sulla
	 * lista l1 piu' volte
	 * passando come parametri prima due oggetti presenti nella lista, poi uno non
	 * presente e infine un
	 * elemento null presente nella lista. Si controlla con degli assertEquals() e
	 * con l'ausilio di
	 * una variabile int che l'indice restituito dal metodo sia quello aspettato.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
	 * una lista l1.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve essere rimasta immutata.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato non viene
	 * stampata alcuna
	 * stringa perche' legate tutte agli errori del metodo assertEquals().
	 */
	@Test
	public void testIndexOf() {
		int index = l1.indexOf("Paperino");
		assertEquals("L'indice dell'oggetto \"Paperino\" non è 2", 2, index);
		index = l1.indexOf("Pippo");
		assertEquals("L'indice dell'oggetto \"Pippo\" non è 0", 0, index);
		index = l1.indexOf("Toretto");
		assertEquals("L'elemento \"Toretto\" è presente nella lista", -1, index);
		index = l1.indexOf(null);
		assertEquals("L'elemento null non è presente", 5, index);
	}

	/**
	 * <strong>Test di
	 * {@link myAdapter.StackAdapter#lastIndexOf(Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
	 * lastIndexOf(Object obj)
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene testato il metodo usandolo su una
	 * lista piu' volte
	 * con diversi parametri.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Viene usato il metodo lastIndexOf() sulla
	 * lista l1 piu'
	 * volte passando come parametri prima due oggetti presenti nella lista, poi uno
	 * non presente e infine
	 * un elemento null presente nella lista. Si controlla con degli assertEquals()
	 * e con l'ausilio di
	 * una variabile int che l'indice restituito dal metodo sia quello aspettato.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
	 * una lista l1.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve essere rimasta immutata.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato non viene
	 * stampata alcuna
	 * stringa perche' tutte legate agli errori del metodo assertEquals().
	 */
	@Test
	public void testLastIndexOf() {
		int index = l1.lastIndexOf("Paperino");
		assertEquals("L'indice dell'oggetto \"Paperino\" non è 2", 2, index);
		index = l1.lastIndexOf("Pippo");
		assertEquals("L'indice dell'oggetto \"Pippo\" non è 0", 4, index);
		index = l1.lastIndexOf("Toretto");
		assertEquals("L'elemento \"Toretto\" è presente nella lista", -1, index);
		index = l1.lastIndexOf(null);
		assertEquals("L'elemento null non è presente", 5, index);
	}

	/**
	 * <strong>Test di {@link myAdapter.StackAdapter#contains(Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
	 * contains(Object obj)
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene usato il metodo su una lista più
	 * volte passando
	 * diversi parametri.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Si usa il metodo contains() sulla lista l1
	 * passando come
	 * parametri diversi oggetti contenuti e non contenuti. Si inizializza una lista
	 * l2 con il metodo
	 * StackAdapter(), si aggiungono degli elementi con il metodo add() e si
	 * aggiunge la lista l2 alla
	 * lista l1. Si controlla con contains se la lista l2 è contenuta nella lista
	 * l1. Attraverso l'utilizzo
	 * dei metodi assertTrue() e assertFalse(), con l'ausilio di una variabile
	 * boolean, si controlla che
	 * gli elementi passati come parametri siano o meno contenuti nella lista l1.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
	 * una lista l1 e
	 * istanziata una lista l2.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l2 deve contenere 2 elementi e la
	 * lista l1 deve
	 * contenere tutti gli elementi iniziali a cui si aggiunge la lista l2.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato non deve essere
	 * stampata alcuna
	 * stringa perche' tutte legate agli errori dei metodi assertTrue() e
	 * assertFalse().
	 */
	@Test
	public void testContains() {
		boolean contenuto = l1.contains("Peppino");
		assertFalse("L'elemento \"Peppino\" è contenuto nella lista", contenuto);
		contenuto = l1.contains(null);
		assertTrue("L'elemento null non è contenuto nella lista", contenuto);
		contenuto = l1.contains("Paperino");
		assertTrue("L'elemento \"Paperino\" non è contenuto nella lista", contenuto);
		l2 = new StackAdapter();
		l2.add("Goku");
		l2.add("Vegeta");
		l1.add(l2);
		contenuto = l1.contains(l2);
		assertTrue("La lista 2 non è contenuta nella lista 1", contenuto);
	}

	/**
	 * <strong>Test di
	 * {@link myAdapter.StackAdapter#containsAll(HCollection coll)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
	 * containsAll(HCollection coll)
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene usato il metodo più volte su una
	 * lista passando
	 * come parametro un'altra lista che viene modificata tra le varie invocazioni
	 * del metodo.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Il metodo viene usato piu' volte sulla
	 * lista l1 passando
	 * come parametro una lista l2 inizialmente uguale a null, poi inizializzata con
	 * il metodo StackAdapter()
	 * ma vuota, con soli oggetti appartenenti alla lista l1 inseriti nella lista l2
	 * con il metodo add()
	 * e infine anche con oggetti non appartenenti alla lista l1. Viene catturata
	 * un'eccezione lanciata dal
	 * metodo containsAll() a cui si passa come parametro la lista l2 uguale a null
	 * e viene stampata una
	 * stringa di avviso di cattura dell'eccezione. Attraverso l'utilizzo dei metodi
	 * assertTrue() e
	 * assertFalse() e l'ausilio di una variabile boolean si controlla che il
	 * boolean restituito dal metodo
	 * containsAll() sia corretto nei vari utilizzi.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata e riempita
	 * una lista l1 e
	 * deve essere stata istanziata e posta uguale a null una lista l2.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve essere rimasta immutata e
	 * la lista l2 deve
	 * essere stata inizializzata e contenere elementi presenti nella lista l1 e un
	 * elemento non presente
	 * nella lista l1.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato viene stampata
	 * solo una stringa
	 * alla cattura dell'eccezione lanciata dal metodo containsAll() e nessuna delle
	 * stringhe legate agli
	 * errori dei metodi assertTrue() e assertFalse().
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
	 * <strong>Test di {@link myAdapter.StackAdapter#equals(Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
	 * equals(Object obj)
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Il metodo viene usato su una lista e gli
	 * viene passato
	 * come parametro un'altra lista che viene modificata nel test tra le varie
	 * invocazioni del metodo.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Viene usato sulla lista l1 il metodo
	 * equals() con la lista
	 * l2 passata come parametro. Il confronto con questo metodo viene fatto con la
	 * lista l2 inizialmente
	 * uguale a null, poi inizializzata con il metodo StackAdapter() ma vuota, con
	 * degli elementi e infine
	 * con tutti gli elementi uguali alla lista l1. Vengono cancellate entrambe le
	 * liste con il metodo
	 * clear() e vengono confrontate nuovamente con il metodo equals(). Il corretto
	 * funzionamento del metodo
	 * viene controllato attraverso l'utilizzo dei metodi assertFalse() e
	 * assertTrue() e una variabile
	 * boolean.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: La lista l1 deve essere stata inizializzata e
	 * riempita e la
	 * lista l2 deve essere stata istanziata.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l2 deve essere stata inizializzata
	 * e sia la
	 * lista l1 che la lista l2 devono essere vuote.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Il test viene superato se non viene
	 * stampata alcuna
	 * stringa perche' tutte legate ai messaggi di errore dei metodi assertTrue() e
	 * assertFalse().
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
	 * <strong>Test di {@link myAdapter.StackAdapter#hashCode()}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionamento del metodo
	 * hashCode()
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene utilizzato il metodo su due liste e
	 * vengono
	 * confrontati gli int restituiti.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Viene inizializzata una lista l2 e vengono
	 * inizializzate
	 * due variabili di tipo int uguali agli int restituiti dal metodo hashCode()
	 * usato sulle due liste.
	 * Le due liste vengono modificate nel test, vengono aggiornate le variabili int
	 * con i nuovi hashCode()
	 * e si controlla con i metodi assertEquals() e assertNotEquals() che i due
	 * hashCode siano uguali solo
	 * quando le due liste sono uguali.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: La lista l1 deve essere stata inizializzata e
	 * riempita e la
	 * lista l2 deve essere stata istanziata.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista l1 deve essere rimasta immutata e
	 * la lista l2 deve
	 * essere stata inizializzata e contenere degli elementi diversi dalla lista l1.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato non deve essere
	 * stata stampata
	 * alcuna stringa perche' tutte legate agli errori dei metodi assertEquals() e
	 * assertNotEquals().
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
