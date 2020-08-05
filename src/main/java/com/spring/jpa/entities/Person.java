package com.spring.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
//@Table(name = "person")  // if table name not match
@NamedQuery(name="Person.findAll", query="select p from Person p")   //jpql
public class Person {

	@Id
	@GeneratedValue  // to create db sequence to auto generate id
	private long id;
	
	//@Column(name = "name")   // if column name not match
	private String name;
	private String location;
	private Date birthDate;

	//no-args contsructor is mandaory
	public Person() {
		super();
	}

	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	
	public Person(long id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("\nPerson [id: %s, name: %s, location: %s, birthDate: %s]", id, name, location, birthDate);
	}

}
