package com.spring.jpa.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.entities.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Long> {

}
