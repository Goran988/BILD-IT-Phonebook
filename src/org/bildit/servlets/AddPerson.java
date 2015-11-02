package org.bildit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.beans.Person;
import org.bildit.dao.PersonDao;
import org.bildit.data.PersonData;
import org.bildit.utility.Validation;

/**
 * Servlet implementation class AddPerson
 */
@WebServlet("/AddPerson")
public class AddPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PersonDao personDao = new PersonData();
		Person person = new Person();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String gender = request.getParameter("gender");
		if(Validation.validateAll(firstName, lastName, phoneNumber, address, email, dateOfBirth)){
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setPhoneNumber(phoneNumber);
		person.setAddress(address);
		person.setEmail(email);
		person.setDateOfBirth(dateOfBirth);
		person.setGender(gender);
		personDao.addPersonToDB(person);
		response.getWriter().println("Success");
		response.sendRedirect("wellcomeScreen.html");
		}
		else{
			response.getWriter().println("<h3>Validation failed, try again</h3>");
			response.sendRedirect("addPerson.jsp");
		}
	}

}
