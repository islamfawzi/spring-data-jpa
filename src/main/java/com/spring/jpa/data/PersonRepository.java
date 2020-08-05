package com.spring.jpa.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.jpa.entities.Person;

@Repository
@Transactional
public class PersonRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("Person.findAll", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(long id) {
		return entityManager.find(Person.class, id); 
	}
	
	public Person insertPerson(Person person) {
		return entityManager.merge(person);   // if the id exist will update, else will insert
	}
	
	public Person updatePerson(Person person) {
		return entityManager.merge(person);   // if the id exist will update, else will insert
	}
	
	public void deletePerson(long id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
}
