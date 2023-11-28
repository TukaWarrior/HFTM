package ch.hftm;

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
        

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
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