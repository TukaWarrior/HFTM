package ch.hftm.db2.vereinsverwaltung.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import ch.hftm.db2.vereinsverwaltung.entities.Anlass;
import ch.hftm.db2.vereinsverwaltung.entities.Funktion;
import ch.hftm.db2.vereinsverwaltung.entities.Person;
import ch.hftm.db2.vereinsverwaltung.entities.Status;
import ch.hftm.db2.vereinsverwaltung.persistence.JPAUtil;
import ch.hftm.db2.vereinsverwaltung.persistence.repositories.AnlassRepository;
import ch.hftm.db2.vereinsverwaltung.persistence.repositories.FunktionRepository;
import ch.hftm.db2.vereinsverwaltung.persistence.repositories.PersonRepository;
import ch.hftm.db2.vereinsverwaltung.persistence.repositories.StatusRepository;

public class ConsoleClient {
	
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManager = JPAUtil.currentEntityManager();
		statusDbZugriffe();
		
		// Schliessen des Entity Managers am Ende der Session
		JPAUtil.closeEntityManager();
		
		// Schliessen der EntityManagerFactory beim Beenden des Programmes
		JPAUtil.closeEntityManagerFactory();
	}
	

	private static void statusDbZugriffe() {
		entityManager.getTransaction().begin();
		StatusRepository statusRepository = new StatusRepository(entityManager);
		
		// Status hinzufügen
		Status neuerStatus = new Status();
		neuerStatus.setBezeichner("Status-Repsitory");
		statusRepository.insert(neuerStatus);
		System.out.println("Neue Status-Id: " + neuerStatus.getId());
		
		// Status entfernen
		statusRepository.delete(neuerStatus.getId());
		System.out.println("Neuer Status entfernt");
		
		// Status
		Status status1 = statusRepository.findById(1);
		if (status1 != null) {
			System.out.println("Status mit ID 1: " + status1.getBezeichner());
		}
		
		// Alle Status auslesen
		List<Status> statusList = statusRepository.getAll();
		System.out.println("Anzahl Status: " + statusList.size());
		for (Status status : statusList) {
			System.out.println("Status " + status.getId() + ": "
					+ status.getBezeichner());
		}
		
		entityManager.getTransaction().commit();
	}


	 private static void funktionDbZugriffe() {
		entityManager.getTransaction().begin();
		FunktionRepository funktionRepository = new FunktionRepository(entityManager);
		
		// Funktion hinzufügen
		Funktion neueFunktion = new Funktion();
		neueFunktion.setBezeichner("Funktion-Repsitory");
		funktionRepository.insert(neueFunktion);
		System.out.println("Neue Funktion-Id: " + neueFunktion.getId());
		
		// Funktion entfernen
		funktionRepository.delete(neueFunktion.getId());
		System.out.println("Neue Funktion entfernt");
		
		// Funktion
		Funktion funktion1 = funktionRepository.findById(1);
		if (funktion1 != null) {
			System.out.println("Funktion mit ID 1: " + funktion1.getBezeichner());
		}
		
		// Alle Funktionen auslesen
		List<Funktion> funktionList = funktionRepository.getAll();
		System.out.println("Anzahl Funktionen: " + funktionList.size());
		for (Funktion funktion : funktionList) {
			System.out.println("Funktion " + funktion.getId() + ": "
					+ funktion.getBezeichner());
		}
		
		// Funktion suchen
		String suche = "si";
		System.out.println("Suche nach Funktionen mit Bezeichnung: " + suche);
		List<Funktion> funktionSearchList = funktionRepository.findByName(suche);
		System.out.println("Anzahl Funktionen: " + funktionSearchList.size());
		for (Funktion funktion : funktionSearchList) {
			System.out.println("Funktion " + funktion.getId() + ": "
					+ funktion.getBezeichner());
		}
		
		entityManager.getTransaction().commit();
	}


	private static void personDbZugriffe() {
		entityManager.getTransaction().begin();
		PersonRepository personRepository = new PersonRepository(entityManager);
		StatusRepository statusRepository = new StatusRepository(entityManager);
		
		// Person hinzufügen
		Status status1 = statusRepository.findById(1);
		Person neuePerson = new Person("Repository","Person","JPA-Str. 2.1","2006", "JSR 220 Expert Group", false, status1);
		neuePerson.setEintritt(LocalDate.now());
		personRepository.insert(neuePerson);
		System.out.println("Neue Person-Id: " + neuePerson.getId());
		
		// Person entfernen
		personRepository.delete(neuePerson.getId());
		System.out.println("Neue Person entfernt");
		
		// Person
		Person person1 = personRepository.findById(1);
		if (person1 != null) {
			System.out.println("Person mit ID 1: " + person1);
		}
		
		// Alle Personen auslesen
		List<Person> personList = personRepository.getAll();
		System.out.println("Anzahl Personen: " + personList.size());
		for (Person person : personList) {
			System.out.println("Person: " + person);
		}
		
		entityManager.getTransaction().commit();
	}


	private static void anlassDbZugriffe() {
		entityManager.getTransaction().begin();
		PersonRepository personRepository = new PersonRepository(entityManager);
		AnlassRepository anlassRepository = new AnlassRepository(entityManager);

		// Anlass hinzufügen
		Person p1 = personRepository.findById(1);
		Anlass neuerAnlass = new Anlass("Repository-Anlass", LocalDate.of(2024, 4, 25), p1);
		neuerAnlass.setTeilnehmer(new ArrayList<Person>());
		neuerAnlass.getTeilnehmer().add(p1);
		anlassRepository.insert(neuerAnlass);
		System.out.println("Neuer Anlass: " + neuerAnlass);

		// Organisator ändern
		Person p2 = personRepository.findById(2);
		neuerAnlass.setOrganisator(p2);
		System.out.println("Pers-Id des Anlass-Organisators: " + neuerAnlass.getOrganisator().getId());
		p2.getOrganisierteAnlaesse().stream().filter(a -> a.getBezeichner().equals("Repository-Anlass")).forEach(a -> System.out.println("Person 2 als Organisator gesetzt!"));

		// Anlass entfernen
		anlassRepository.delete(neuerAnlass.getId());
		System.out.println("Neuer Anlass entfernt");

		// Anlass
		Anlass anlass1 = anlassRepository.findById(1);
		if (anlass1 != null) {
			System.out.println("Anlass mit ID 1: " + anlass1);
		}

		// Alle Anlässe auslesen
		List<Anlass> anlassList = anlassRepository.getAll();
		System.out.println("Anzahl Anlässe: " + anlassList.size());
		for (Anlass anlass : anlassList) {
			System.out.println("Anlass: " + anlass);
		}

		entityManager.getTransaction().commit();
	}
}