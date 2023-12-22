package ch.hftm.db2.vereinsverwaltung.persistence.repositories;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import ch.hftm.db2.vereinsverwaltung.entities.Anlass;

public class AnlassRepository {
	EntityManager entityManager;

	public AnlassRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Anlass anlass) {
		this.entityManager.persist(anlass);
	}

	public Anlass findById(long id) {
		return this.entityManager.find(Anlass.class, id);
	}

	public void delete(long id) {
		Anlass anlass = findById(id);
		if (anlass != null) {
			this.entityManager.remove(anlass);
		}
	}
	
	public List<Anlass> getAll() {
		TypedQuery<Anlass> query = this.entityManager
				.createQuery("select f from Anlass f", Anlass.class);
		return query.getResultList();
	}
}