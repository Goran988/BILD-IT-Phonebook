package org.bildit.dao;

import java.util.List;

import org.bildit.beans.Person;

public interface PersonDao {
	List<Person> getPersons();

	void addPersonToDB(Person person);

	List<Person> searchPerson(String firstName, String lastName);

	List<Person> deletePerson(String firstName, String lastName);

	void deleteById(String id);

}
