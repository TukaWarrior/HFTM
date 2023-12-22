package ch.hftm.persistence.repositories;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import ch.hftm.entities.Person;

public class PersonRepository {
	EntityManager entityManager;
	public PersonRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Person person) {
		this.entityManager.persist(person);
	}

	public Person findById(long id) {
		return this.entityManager.find(Person.class, id);
	}

	public void delete(long id) {
		Person person = findById(id);
		if (person != null) {
			this.entityManager.remove(person);
		}
	}
	
	public List<Person> getAll() {
		TypedQuery<Person> query = this.entityManager
				.createQuery("select p from Person p", Person.class);
		return query.getResultList();
	}
}