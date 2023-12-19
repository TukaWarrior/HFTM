package ch.hftm.db2.vereinsverwaltung.persistence.repositories;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import ch.hftm.db2.vereinsverwaltung.entities.Funktion;

public class FunktionRepository {
	EntityManager entityManager;
	public FunktionRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Funktion funktion) {
		this.entityManager.persist(funktion);
	}

	public Funktion findById(long id) {
		return this.entityManager.find(Funktion.class, id);
	}

	public void delete(long id) {
		Funktion funktion = findById(id);
		if (funktion != null) {
			this.entityManager.remove(funktion);
		}
	}
	
	public List<Funktion> getAll() {
		TypedQuery<Funktion> query = this.entityManager
				.createQuery("select f from Funktion f", Funktion.class);
		return query.getResultList();
	}
	
	public List<Funktion> findByName(String name) {
		String searchString = "%" + name +"%";
		TypedQuery<Funktion> query = this.entityManager
				.createQuery("select f from Funktion f where f.bezeichner like :name", Funktion.class);
		query.setParameter("name", searchString);
		return query.getResultList();
	}

    // public List <Funktion> getAll(){
    //     TypedQuery<Funktion> query = this.entityManager.createQuery("select f from Funktion order by f.bezeichner", Funktion.class);
    //     return query.getResult();
    // }