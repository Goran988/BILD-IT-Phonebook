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
 * Servlet implementation class EditPerson
 */
@WebServlet("/EditPerson")
public class EditPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	PersonDao personDao = new PersonData();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idNumber = request.getParameter("idNumber");
		Person person = personDao.findById(idNumber);
		if (person != null) {
			request.getSession().setAttribute("person", person);
			response.sendRedirect("editPersonInfo.jsp");
		}else{
			response.sendRedirect("editPersonInfo.jsp");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idNumber = request.getParameter("idNumber");
		Person person = new Person();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String gender = request.getParameter("gender");
		System.out.println(firstName);

		
			person.setFirstName(firstName);
			person.setLastName(lastName);
			person.setPhoneNumber(phoneNumber);
			person.setAddress(address);
			person.setEmail(email);
			person.setDateOfBirth(dateOfBirth);
			person.setGender(gender);
			personDao.editPerson(person, idNumber);
			response.sendRedirect("wellcomeScreen.jsp");

	
	}

}
