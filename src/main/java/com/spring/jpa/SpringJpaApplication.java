package com.spring.jpa;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.jpa.data.PersonRepository;
import com.spring.jpa.data.PersonSpringDataRepository;
import com.spring.jpa.entities.Person;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonSpringDataRepository personSpringDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/////////////////////// using JPA (EntityManager) ///////////////////// 
		
		Person person = personRepository.findById(10001L);
		logger.info("Person: {}", person);

		Person insertedPerson = personRepository.insertPerson(new Person("Safaa", "Riyadh", new Date()));
		logger.info("inserted Person: {}", insertedPerson);

		Person updatedPerson = personRepository.updatePerson(new Person(10003L, "Rokaya", "Riyadh KSA", 
				new Date()));
		logger.info("updated Person: {}", updatedPerson);
		
		personRepository.deletePerson(10002L);
		logger.info("10002L Person: {}", personRepository.findById(10002L));
		
		logger.info("\nall persons {}", personRepository.findAll());
		
		
		//////////////////// using spring data jpa ///////////////////////////
		
		Optional<Person> personOptional = personSpringDataRepository.findById(10001L);
		logger.info("Person: {}", personOptional.get());

		insertedPerson = personSpringDataRepository.save(new Person("Spring Data Safaa", "Riyadh", new Date()));
		logger.info("inserted Person: {}", insertedPerson);

		updatedPerson = personSpringDataRepository.save(new Person(10003L, "Spring Data Rokaya", "Riyadh KSA", 
				new Date()));
		logger.info("updated Person: {}", updatedPerson);
		
		personSpringDataRepository.deleteById(10003L);
		
		logger.info("\nall persons {}", personSpringDataRepository.findAll());

	}
}
