package org.bildit.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bildit.beans.RegisteredUser;
import org.bildit.dao.RegisteredUserDao;
import org.bildit.utility.DBConnection;

public class RegisteredUserData implements RegisteredUserDao {

	@Override
	public void addUserToDb(RegisteredUser registeredUser) {
		String sqlAdd = "INSERT INTO user (username, password) VALUES(?,?)";
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection.prepareStatement(sqlAdd);) {
			stmnt.setString(1, registeredUser.getUsername());
			stmnt.setString(2, registeredUser.getPassword());

			stmnt.executeUpdate();
		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<RegisteredUser> getUsers() {
		List<RegisteredUser> list = new ArrayList<>();
		String sellectAll = "SELECT * FROM user";
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection
						.prepareStatement(sellectAll);
				ResultSet rs = stmnt.executeQuery()) {
			while (rs.next()) {
				RegisteredUser registeredUser = new RegisteredUser();
				registeredUser.setUsername(rs.getString(1));
				registeredUser.setPassword(rs.getString(2));

				list.add(registeredUser);
			}
		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public RegisteredUser findUser(String username, String password) {
		List<RegisteredUser> list = getUsers();
		for (RegisteredUser registeredUser : list) {
			if (registeredUser.getUsername().equals(username)
					&& registeredUser.getPassword().equals(password)) {
				return registeredUser;
			}

		}
		return null;

	}

	public List<String> listOfUsernames() {
		List<String> list = new ArrayList<>();
		String selectUsernames = "SELECT username FROM user";
		try (Connection connection = DBConnection.connect();
				PreparedStatement stmnt = connection
						.prepareStatement(selectUsernames);
				ResultSet rs = stmnt.executeQuery()) {
			while (rs.next()) {
				list.add(rs.getString(1));
			}

		} catch (SQLException | NullPointerException ex) {
			ex.printStackTrace();

		}
		return list;

	}
}
