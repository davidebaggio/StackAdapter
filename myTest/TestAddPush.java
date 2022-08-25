package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * <strong>Class TestAdd</strong>
 * <p>
 * <br>
 * <br>
 * <strong>Summary</strong>: La classe TestAdd controlla con i suoi test il
 * funzionamento dei
 * metodi che inseriscono oggetti in una lista.
 * <br>
 * <br>
 * <strong>Test Suite Design</strong>: Questa classe contiene 4 test cases che
 * testano 4 differenti
 * metodi della classe StackAdapter(), ciascuno dei quali inserisce uno o più
 * elementi in diverse posizioni.
 * <br>
 * <br>
 * <strong>Pre-Condition</strong>: Prima di ogni test deve essere inizializzata
 * almeno una lista,
 * anche se vuota.
 * <br>
 * <br>
 * <strong>Post-Condition</strong>: Dopo ogni test deve essere stato fatto
 * almeno un inserimento
 * in almeno una lista.
 * <br>
 * <br>
 * <strong>Test Cases</strong>: I test cases di questa classe sono 4 e sono:
 * testAdd(),
 * testAddAtIndex(), testAddAll(), testAddAllAtIndex(). Ciascuno di essi serve a
 * testare un
 * metodo diverso della classe StackAdapter.
 * <br>
 * <br>
 * <strong>Execution Variables</strong>: Le variabili utilizzate sono due
 * StackAdapter l1 e l2, la
 * prima utilizzata in tutti i test e la seconda solo dove necessario. In alcuni
 * test sono poi utilizzate
 * altre variabili quando necessarie.
 * 
 * @author Marco Zennaro
 */
public class TestAddPush {

	private StackAdapter l1 = null, l2 = null;

	/**
	 * Questo metodo viene eseguito una sola volta prima di iniziare a eseguire i
	 * test della classe
	 * <strong>TestAdd</strong> e stampa una stringa che segnala l'inizio dei test
	 * di questa classe.
	 */
	@BeforeClass
	public static void beforeTestAddClass() {
		System.out.println("Inizio test della classe TestAdd");
	}

	/**
	 * Questo metodo viene eseguito una sola volta dopo che sono stati eseguiti
	 * tutti i test della classe
	 * <strong>TestAdd</strong> e stampa una stringa che segnala la fine dei test di
	 * questa classe.
	 */
	@AfterClass
	public static void afterTestAddClass() {
		System.out.println("Fine test della classe TestAdd");
	}

	/**
	 * Questo metodo viene eseguito una volta prima di ogni test della classe
	 * <strong>TestAdd</strong>,
	 * stampa una stringa e inizializza una lista vuota.
	 */
	@Before
	public void setup() {
		System.out.println("Inizializza una lista vuota");
		l1 = new StackAdapter();
	}

	/**
	 * Questo metodo viene eseguito una volta dopo ogni test della classe
	 * <strong>TestAdd</strong>,
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
	 * <strong>Test di {@link myAdapter.StackAdapter#add(Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionmento del metodo
	 * add(Object obj).
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Il test controlla il funzionamento del
	 * metodo attraverso l'uso del
	 * metodo con oggetti diversi.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Vengono aggiunti un int e un elemento null
	 * alla lista 1 e si controlla
	 * con un assertEquals() e un assertNull() che gli elementi siano stati aggiunti
	 * correttamente in coda alla lista.
	 * Viene assegnata una nuova lista alla lista 2 e viene aggiunta una stringa a
	 * quest'ultima, che
	 * viene controllata con un assertEquals(). La lista 2 viene aggiunta in coda
	 * alla lista 1 e
	 * controllata con un assertEquals(). Viene controllata la dimensione della
	 * lista 1 per vedere se
	 * sono stati inseriti correttamente tutti gli oggetti.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata una lista 1 e
	 * deve essere stata istanziata
	 * una lista 2. Il metodo add(Object obj) e il metodo size() devono essere
	 * funzionanti
	 * per il superamento del test.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista 1 ha 3 elementi e l'ultimo di
	 * questi è la lista 2 che contiene
	 * un elemento null.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato non viene
	 * lanciata nessuna eccezione né
	 * stampato alcun messaggio.
	 */
	@Test
	public void testAdd() {
		l1.add(1);
		assertEquals("L'elemento " + 1 + " non è stato aggiunto correttamente alla lista 1", 1, l1.get(0));
		l1.add(null);
		assertNull("L'elemento \" + null + \" non è stato aggiunto correttamente alla lista 1", l1.get(1));
		l2 = new StackAdapter();
		l2.add("Ciao");
		assertEquals("L'elemento \"Ciao\" non è stato aggiunto correttamente alla lista 2", "Ciao", l2.get(0));
		l1.add(l2);
		assertEquals("L'elemento " + l2 + " non è stato aggiunto correttamente alla lista 1", l2, l1.get(2));
		int lenght = l1.size();
		assertEquals("Uno o più inserimenti non sono andati a buon fine", 3, lenght);
	}

	/**
	 * <strong>Test di
	 * {@link myAdapter.StackAdapter#add(int Index, Object obj)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionmento del metodo
	 * add(int index, Object obj).
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Il test viene effettuato aggiungendo
	 * oggetti diversi in
	 * posizioni diverse.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Vengono aggiunti degli int, una stringa e
	 * un elemento null alla lista 1 e
	 * si controlla con degli assertEquals() e un assertNull() che gli elementi
	 * siano stati aggiunti
	 * correttamente e alla posizione scelta. Viene provato l'inserimento di un int
	 * in una posizione non
	 * corretta per verificare che venga lanciata correttamente l'eccezione.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata una lista 1 e
	 * il metodo
	 * add(int Index, Object obj) e il metodo size() devono essere funzionanti per
	 * il superamento del test.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La lista 1 ha 5 elementi di cui 3 int, una
	 * stringa e un null.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato non viene
	 * lanciata nessuna eccezione e viene
	 * stampato un solo messaggio alla cattura dell'eccezione del metodo add(int
	 * Index, Object obj)
	 * quando chiamato con un indice non valido.
	 */
	@Test
	public void testAddAtIndex() {
		l1.add(0, 3);
		assertEquals("Il 1° elemento non è 3", 3, l1.get(0));
		l1.add(0, 2);
		assertEquals("Il 1° elemento non è 2", 2, l1.get(0));
		l1.add(0, 1);
		assertEquals("Il 1° elemento non è 1", 1, l1.get(0));
		l1.add(1, "ciao");
		assertEquals("Il 2° elemento non è \"ciao\"", "ciao", l1.get(1));
		l1.add(3, null);
		assertNull("Il 4° elemento non è " + null, l1.get(3));
		try {
			l1.add(7, 10);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("Non è possibile aggiungere elementi oltre alla dimensione della lista");
			;
		}
		assertEquals("Uno o più inserimenti non sono andati a buon fine", 5, l1.size());
	}

	/**
	 * <strong>Test di
	 * {@link myAdapter.StackAdapter#addAll(HCollection coll)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionmento del metodo
	 * addAll(HCollection coll).
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene controllato il funzionamento del
	 * metodo nei casi base, limite e nel
	 * lancio di eccezioni.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Viene controllato il funzionamento del
	 * metodo addAll(HCollection coll)
	 * provando ad usarlo su una l1 passando come parametro una l2 prima uguale a
	 * null, poi
	 * inizializzata con il metodo StackAdapter() ma vuota e infine con degli
	 * elementi aggiunti con il metodo
	 * add() in un ciclo for. Viene controllata la corretta modifica della l1 prima
	 * con i metodi
	 * assertTrue() e isEmpty() quando viene passata come parametro la l2 vuota, poi
	 * con assertEquals()
	 * e get() in un ciclo for per confrontare gli elementi inseriti nella l1 dalla
	 * l2 con quelli che
	 * avrebbero dovuto essere inseriti.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata una l1 e deve
	 * essere stata istanziata
	 * e posta uguale a null una l2. I metodi add(), addAll(), isEmpty(), size(),
	 * get() e
	 * StackAdapter() devono funzionare correttamente.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La l2 deve essere stata inizializzata e
	 * contenere degli elementi. La
	 * l1 deve contenere tutti gli elementi della l2 più un altro elemento aggiunto
	 * separatamente.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato viene stampata
	 * una sola stringa alla cattura
	 * dell'eccezione lanciata dal metodo addAll() a cui è stata passata come
	 * parametro una collezione
	 * uguale a null. Nessuna delle stringhe legate agli errori degli assertEquals()
	 * deve essere stata stampata.
	 */
	@Test
	public void testAddAll() {
		try {
			l1.addAll(l2);
		} catch (NullPointerException npe) {
			System.out.println("Impossibile aggiungere gli elementi di una lista null");
		}
		l2 = new StackAdapter();
		l1.addAll(l2);
		assertTrue("La Lista 1 non è vuota, errore nell'aggiungere la lista 2", l1.isEmpty());
		for (int i = 1; i < 4; i++) {
			l2.add(i);
		}
		l1.add(0);
		l1.addAll(l2);
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("La lista 2 non è stata aggiunta correttamente alla lista 1", i, l1.get(i));
		}
	}

	/**
	 * <strong>Test di
	 * {@link myAdapter.StackAdapter#addAll(int index, HCollection coll)}</strong>
	 * <p>
	 * <br>
	 * <br>
	 * <strong>Summary</strong>: Il test controlla il funzionmento del metodo
	 * addAll(int index, HCollection coll).
	 * <br>
	 * <br>
	 * <strong>Test Case Design</strong>: Viene controllato il funzionamento del
	 * metodo nei casi base, limite e nel
	 * lancio di eccezioni.
	 * <br>
	 * <br>
	 * <strong>Test Description</strong>: Viene controllato il funzionamento del
	 * metodo addAll(int index, HCollection coll)
	 * provando ad usarlo su una l1 passando come parametro una l2 prima uguale a
	 * null, poi
	 * inizializzata con il metodo StackAdapter() ma vuota e infine con degli
	 * elementi aggiunti con il metodo
	 * add() in un ciclo for. Viene provato il metodo anche passando come parametro
	 * di indice prima una
	 * posizione non valida prima perché inferiore a 0, poi una non valida perché
	 * superiore alla dimensione
	 * della lista e infine una valida. Viene controllata la corretta modifica della
	 * l1 prima con i metodi
	 * assertTrue() e isEmpty() quando viene passata come parametro la l2 vuota, poi
	 * con assertEquals()
	 * e get() in un ciclo for per confrontare gli elementi inseriti nella l1 dalla
	 * l2 con quelli che
	 * avrebbero dovuto essere inseriti.
	 * <br>
	 * <br>
	 * <strong>Pre-Condition</strong>: Deve essere stata inizializzata una l1 e deve
	 * essere stata istanziata
	 * e posta uguale a null una l2. I metodi add(), addAll(), isEmpty(), size(),
	 * get() e
	 * StackAdapter() devono funzionare correttamente.
	 * <br>
	 * <br>
	 * <strong>Post-Condition</strong>: La l2 deve essere stata inizializzata e
	 * contenere degli elementi. La
	 * l1 deve contenere tutti gli elementi della l2 più due elementi aggiunti
	 * separatamente.
	 * <br>
	 * <br>
	 * <strong>Expected results</strong>: Se il test viene superato vengono stampate
	 * solo le stringhe alla cattura
	 * delle eccezioni lanciate dal metodo addAll() a cui sono stati passati come
	 * parametro una collezione
	 * uguale a null o degli indici non validi. Nessuna delle stringhe legate agli
	 * errori degli
	 * assertEquals() deve essere stata stampata.
	 */
	@Test
	public void testAddAllAtIndex() {
		try {
			l1.addAll(0, l2);
		} catch (NullPointerException npe) {
			System.out.println("Impossibile aggiungere alla lista 1 una lista null");
		}
		l2 = new StackAdapter();
		l1.addAll(0, l2);
		assertTrue("La Lista 1 non è vuota, errore nell'aggiungere la lista 2", l1.isEmpty());
		for (int i = 1; i < 4; i++) {
			l2.add(i);
		}
		l1.add(0);
		l1.add(4);
		try {
			l1.addAll(-1, l2);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("Impossibile aggiungere una lista in una posizione di indice minore di 0");
		}
		try {
			l1.addAll(3, l2);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println(
					"Impossibile aggiungere una lista in una posizione di indice maggiore al numero di elementi");
		}
		l1.addAll(1, l2);
		for (int i = 0; i < l1.size(); i++) {
			assertEquals("La lista 2 non è stata aggiunta correttamente alla lista 1", i, l1.get(i));
		}
	}

	/**
	 * 
	 */
	@Test
	public void testPush() {

	}
}
