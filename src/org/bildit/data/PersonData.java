package org.bildit.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bildit.beans.Person;
import org.bildit.dao.PersonDao;
import org.bildit.utility.DBConnection;

public class PersonData implements PersonDao {
	/**
	 * method used to get the list of all persons added to DB
	 */
	@Override
	public List<Person> getPersons() {
		List<Person> list = new ArrayList<>();
		String sellectAll = "SELECT * FROM person";
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection.prepareStatement(sellectAll);
				ResultSet rs = stmnt.executeQuery()) {
			while (rs.next()) {
				Person person = new Person();
				person.setIdNumber(rs.getString(1));
				person.setFirstName(rs.getString(2));
				person.setLastName(rs.getString(3));
				person.setPhoneNumber(rs.getString(4));
				person.setAddress(rs.getString(5));
				person.setEmail(rs.getString(6));
				person.setDateOfBirth(rs.getString(7));
				person.setGender(rs.getString(8));
				list.add(person);
			}
		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	/**
	 * method used to add new person to DB
	 */
	@Override
	public void addPersonToDB(Person person) {
		String sqlAdd = "INSERT INTO person (first_name, last_name, phone_number,  address, email, date_of_birth, gender) VALUES(?,?,?,?,?,?,?)";
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection.prepareStatement(sqlAdd);) {
			stmnt.setString(1, person.getFirstName());
			stmnt.setString(2, person.getLastName());
			stmnt.setString(3, person.getPhoneNumber());
			stmnt.setString(4, person.getAddress());
			stmnt.setString(5, person.getEmail());
			stmnt.setString(6, person.getDateOfBirth());
			stmnt.setString(7, person.getGender());
			stmnt.executeUpdate();
		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * method used to find user in the database - not used in this version
	 */
	@Override
	public List<Person> searchPerson(String firstName, String lastName) {
		List<Person> listOfPersons = getPersons();
		List<Person> matches = new ArrayList<>();
		for (Person person : listOfPersons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				matches.add(person);
			}
		}
		return matches;
	}

	/**
	 * method that finds a person and delets if there is only one occurence,
	 * otherwise it returns the list of users with given firstName and lastName
	 */
	public List<Person> deletePerson(String firstName, String lastName) {
		String select = "SELECT * FROM person WHERE first_name='" + firstName + "' AND last_name='" + lastName + "'";
		String delete = "DELETE FROM person WHERE first_name='" + firstName + "' AND last_name='" + lastName + "'";
		List<Person> listOfPersons = getPersons();
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection.prepareStatement(select);
				ResultSet rs = stmnt.executeQuery();
				PreparedStatement stmnt2 = connection.prepareStatement(delete)) {
			while (rs.next()) {
				Person person = new Person();
				person.setIdNumber(rs.getString(1));
				person.setFirstName(rs.getString(2));
				person.setLastName(rs.getString(3));
				person.setPhoneNumber(rs.getString(4));
				person.setAddress(rs.getString(5));
				person.setEmail(rs.getString(6));
				person.setDateOfBirth(rs.getString(7));
				person.setDateOfBirth(rs.getString(8));
				listOfPersons.add(person);

			}
			if (listOfPersons.size() == 1) {

				stmnt2.executeUpdate();
			}
		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();
		}
		return listOfPersons;

	}
	/**
	 * method used to delete user by Id
	 */
	public void deleteById(String id) {
		String delete = "DELETE FROM person WHERE id_num='" + id + "'";
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection.prepareStatement(delete)) {
			stmnt.executeUpdate();
		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();
		}

	}
	/**
	 * method used to edit person in DB
	 */
	@Override
	public void editPerson(Person person, String id) {
		String edit = "UPDATE  person SET first_name=?, last_name=?, phone_number=?,  address=?, email=?, date_of_birth=?, gender=? WHERE id_num='"
				+ id + "'";
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection.prepareStatement(edit);) {
			stmnt.setString(1, person.getFirstName());
			stmnt.setString(2, person.getLastName());
			stmnt.setString(3, person.getPhoneNumber());
			stmnt.setString(4, person.getAddress());
			stmnt.setString(5, person.getEmail());
			stmnt.setString(6, person.getDateOfBirth());
			stmnt.setString(7, person.getGender());
			stmnt.executeUpdate();
		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();
		}

	}
	/**
	 * method used to find user by ID
	 */
	@Override
	public Person findById(String id) {
		String select = "SELECT * FROM person WHERE id_num='" + id + "'";
		Person person = new Person();
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection.prepareStatement(select);
				ResultSet rs = stmnt.executeQuery()) {
			if (rs.next()) {
				person.setIdNumber(rs.getString(1));
				person.setFirstName(rs.getString(2));
				person.setLastName(rs.getString(3));
				person.setPhoneNumber(rs.getString(4));
				person.setAddress(rs.getString(5));
				person.setEmail(rs.getString(6));
				person.setDateOfBirth(rs.getString(7));
				person.setGender(rs.getString(8));
			}
		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();
		}
		System.out.println(person.getFirstName());
		return person;
	}
/**
 * method used to search DB by using one keyword and searching in three columns
 */
	public List<Person> findAnyMatch(String searchTerm) {
		List<Person> list = new ArrayList<>();
		String select = "SELECT * FROM person WHERE first_name='" + searchTerm + "' OR last_name='" + searchTerm
				+ "' OR gender='" + searchTerm + "'";
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection.prepareStatement(select);
				ResultSet rs = stmnt.executeQuery();) {
			while (rs.next()) {
				Person person = new Person();
				person.setIdNumber(rs.getString(1));
				person.setFirstName(rs.getString(2));
				person.setLastName(rs.getString(3));
				person.setPhoneNumber(rs.getString(4));
				person.setAddress(rs.getString(5));
				person.setEmail(rs.getString(6));
				person.setDateOfBirth(rs.getString(7));
				person.setGender(rs.getString(8));
				list.add(person);

			}

		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();

		}
		return list;

	}
}
