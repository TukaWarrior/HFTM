package ch.hftm.db2.vereinsverwaltung.persistence.repositories;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import ch.hftm.db2.vereinsverwaltung.entities.Status;

public class StatusRepository {
	EntityManager entityManager;
	
	public StatusRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Status status) {
		this.entityManager.persist(status);
	}

	public Status findById(long id) {
		return this.entityManager.find(Status.class, id);
	}

	public void delete(long id) {
		Status status = findById(id);
		if (status != null) {
			this.entityManager.remove(status);
		}
	}
	
	public List<Status> getAll() {
		TypedQuery<Status> query = this.entityManager
				.createQuery("select s from Status s", Status.class);
		return query.getResultList();
	}

	public List<Status> findByNameAndMinimumAmount(String name, double amount) {
		String searchString = "%" + name + "%";
		TypedQuery<Status> query = this.entityManager
				.createQuery("select f from Status f where f.bezeichner like :name and f.beitrag >= :amount",
						Status.class);
		query.setParameter("name", searchString);
		query.setParameter("amount", amount);
		return query.getResultList();
	}
	
}
