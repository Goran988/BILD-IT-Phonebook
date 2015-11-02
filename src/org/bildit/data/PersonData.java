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

	@Override
	public List<Person> getPersons() {
		List<Person> list = new ArrayList<>();
		String sellectAll = "SELECT * FROM person";
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection
						.prepareStatement(sellectAll);
				ResultSet rs = stmnt.executeQuery()) {
			while (rs.next()) {
				Person person = new Person();
				person.setFirstName(rs.getString(1));
				person.setLastName(rs.getString(2));
				person.setPhoneNumber(rs.getString(3));
				person.setAddress(rs.getString(4));
				person.setEmail(rs.getString(5));
				person.setDateOfBirth(rs.getString(6));
				person.setGender(rs.getString(7));
				list.add(person);
			}
		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();
		}
		return list;
	}

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

	@Override
	public List<Person> searchPerson(String firstName, String lastName) {
		List<Person> listOfPersons = getPersons();
		List<Person> matches = new ArrayList<>();
		for (Person person : listOfPersons) {
			if (person.getFirstName().equals(firstName)
					&& person.getLastName().equals(lastName)) {
				matches.add(person);
			}
		}
		return matches;
	}

}
