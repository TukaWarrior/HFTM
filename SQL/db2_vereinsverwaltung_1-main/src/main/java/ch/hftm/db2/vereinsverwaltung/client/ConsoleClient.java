package ch.hftm.db2.vereinsverwaltung.client;

import java.util.List;
import jakarta.persistence.EntityManager;
import ch.hftm.db2.vereinsverwaltung.entities.Funktion;
import ch.hftm.db2.vereinsverwaltung.entities.Status;
import ch.hftm.db2.vereinsverwaltung.persistence.JPAUtil;
import ch.hftm.db2.vereinsverwaltung.persistence.repositories.FunktionRepository;
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

	
}
