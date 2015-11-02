package org.bildit.dao;

import java.util.List;

import org.bildit.beans.RegisteredUser;

public interface RegisteredUserDao {

	void addUserToDb(RegisteredUser registeredUser);

	List<RegisteredUser> getUsers();

	RegisteredUser findUser(String username, String password);

}
