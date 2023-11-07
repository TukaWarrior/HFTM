import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class StreamsAufgabenTest {

	@Test
	public void beispielAufgabe() {
		List<String> ausgangslage = List.of("Paula", "Roberto", "Mulan", "Fridolin");
		List<String> ziel = List.of("Paula", "Roberto", "Mulan", "Fridolin");

		assertEquals(StreamsAufgaben.beispielAufgabe(ausgangslage), ziel);
	}

	@Test
	public void namenMitMehrAls6ZeichenAusschliessen() {
		List<String> ausgangslage = List.of("Paula", "Roberto", "Mulan", "Fridolin");
		List<String> ziel = List.of("Paula", "Mulan");

		assertEquals(StreamsAufgaben.namenMitMehrAls6ZeichenAusschliessen(ausgangslage), ziel);
	}
	
	@Test
	public void gibDieAeltestePersonZurueck() {
		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		List<Person> personenListe = List.of(sara, eva, viktor);
		assertEquals(StreamsAufgaben.gibDieAeltestePersonZurueck(personenListe).getAlter(), 42);
	}
	
	@Test
	public void erstelleStreamMitIterate() {
		List<Integer> ziel = List.of(1,2,4,8,16,32,64,128,256,512,1024);
		// Erstelle einen Stream mit Stream.iterate() der dem gezeigten Muster entspricht
		// Es soll jeweils der Initialwert mit 2 multipliziert werden ohne den Wert 2000 zu übersteigen
		// Gib die Werte schlussendlich wieder als Liste zurück
		assertEquals(StreamsAufgaben.erstelleStreamMitIterate(), ziel);
	}

	
	@Test
	public void gibDieZweiAeltestenPersonenSortiertZurueck() {
		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		Person anna = new Person("Anna", 5);
		List<Person> personenListe = List.of(sara, eva, viktor, anna);
		assertEquals(StreamsAufgaben.gibDieZweiAeltestenPersonenSortiertZurueck(personenListe), List.of(eva,viktor));
	}

	@Test
	public void namenAlsGrossbuchstaben() {
		List<String> ausgangslage = List.of("Paula", "Roberto", "Mulan", "Fridolin");
		List<String> ziel = List.of("PAULA", "ROBERTO", "MULAN", "FRIDOLIN");

		assertEquals(StreamsAufgaben.namenAlsGrossbuchstaben(ausgangslage), ziel);
	}
	@Test
	public void summeBilden() {
		List<Integer> zahlen = List.of(1, 2, 3, 4, 5);
		assertEquals(StreamsAufgaben.summeBilden(zahlen), 1 + 2 + 3 + 4 + 5);
	}

	@Test
	public void alleVornamenMitPersonenAelterAls35() {
		Person sara = new Person("Sara", 4);
		Person viktor = new Person("Viktor", 40);
		Person eva = new Person("Eva", 42);
		Person anna = new Person("Anna", 5);
		List<Person> personenListe = List.of(sara, eva, viktor, anna);
		assertEquals(StreamsAufgaben.alleVornamenMitPersonenAelterAls35(personenListe), Set.of("Viktor", "Eva"));
	}
	
	@Test
	public void gruppiereNachAnfangsbuchstabe() {
		Person sara = new Person("Sara", 32);
		Person sebastian = new Person("Sebastian", 40);
		Person eva = new Person("Eva", 42);
		Person selma = new Person("Selma", 55);
		List<Person> personenListe = List.of(sara, eva, sebastian, selma);
		Map<String,List<Person>> personenGruppiert = StreamsAufgaben.gruppiereNachAnfangsbuchstabe(personenListe);
		assertEquals(personenGruppiert.get("S").size(), 3);
		assertEquals(personenGruppiert.get("E").size(), 1);
	}

	@Test
	public void verschachtelteListeGlaetten() {
		// Tipp: Schau dich nach einer Stream-Methode um, welche wir in den Lernvideos
		// noch nicht behandelt haben
		List<List<String>> ausgangslage = List.of(List.of("Viktor", "Farcic"), List.of("John", "Doe", "Third"));
		List<String> ziel = List.of("Viktor", "Farcic", "John", "Doe", "Third");

		assertEquals(StreamsAufgaben.verschachtelteListeGlaetten(ausgangslage), ziel);
	}
}
