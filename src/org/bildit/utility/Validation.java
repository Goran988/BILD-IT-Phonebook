package org.bildit.utility;

import java.util.List;

import org.bildit.beans.RegisteredUser;
import org.bildit.dao.RegisteredUserDao;
import org.bildit.data.RegisteredUserData;

public class Validation {
	public static boolean validateFirstName(String firstName) {
		if (firstName != null & firstName.length() >= 4
				&& firstName.length() <= 15) {
			if(firstName.matches("[A-Za-z]+"))
			return true;
		}
		return false;
	}

	public static boolean validateLastName(String lastName) {
		if (lastName != null & lastName.length() >= 4
				&& lastName.length() <= 15) {
			return true;
		}
		return false;
	}

	public static boolean validateUsername(String username) {
		if (username != null & username.length() >= 4
				&& username.length() <= 10) {
			return true;
		} else
			return false;
	}

	public static boolean usernameFree(String username) {
		RegisteredUserDao regUser = new RegisteredUserData();
		List<RegisteredUser> list = regUser.getUsers();
		for (RegisteredUser user : list) {
			if (user.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}

	public static boolean validatePassword(String password) {
		if (password != null & password.length() >= 6
				&& password.length() <= 10) {
			return true;

		} else
			return false;
	}

	public static boolean validateEmail(String email) {
		if (email != null
				& email.matches("[A-Za-z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")) {
			return true;
		} else
			return false;
	}

	public static boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber != null && phoneNumber.length() >= 6
				& phoneNumber.length() <= 12) {
			if (phoneNumber.matches("[0-9]+")) {
				return true;
			}
		}
		return false;
	}

	public static boolean validateDateOfBirth(String dateOfBirth) {
		if (dateOfBirth != null & dateOfBirth.length() == 0
				|| dateOfBirth == null) {
			return false;
		}
		return true;

	}

	public static boolean validateAddress(String address) {
		if (address != null & address.length() >= 4 && address.length() <= 25) {
			return true;
		}
		return false;
	}

	public static boolean validateAll(String firstName, String lastName,
			String phoneNumber, String address, String email, String dateOfBirth) {
		if (validateFirstName(firstName) && validateLastName(lastName)
				&& validatePhoneNumber(phoneNumber) && validateAddress(address)
				&& validateEmail(email) && validateDateOfBirth(dateOfBirth)) {
			return true;

		}
		return false;
	}
}
