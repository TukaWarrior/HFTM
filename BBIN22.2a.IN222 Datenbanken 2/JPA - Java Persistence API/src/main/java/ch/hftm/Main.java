package ch.hftm;

import java.time.LocalDate;
import java.util.List;

import ch.hftm.entities.Funktion;
import ch.hftm.entities.Person;
import ch.hftm.persistence.repositories.FunktionRepository;
import ch.hftm.persistence.repositories.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ch.hftm.db2.orajpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       
        entityManager.getTransaction().begin();

        // In diesem Block kannst du den entityManager verwenden :-)
		funktionDbZugriffe(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    

    private static void funktionDbZugriffe(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		PersonRepository personRepository = new PersonRepository(entityManager);
		FunktionRepository funktionRepository = new FunktionRepository(entityManager);
		StatusRepository statusRepository = new StatusRepository(entityManager);
		
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
}