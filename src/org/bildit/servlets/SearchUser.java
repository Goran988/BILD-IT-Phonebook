package org.bildit.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.beans.Person;
import org.bildit.dao.PersonDao;
import org.bildit.data.PersonData;

/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PersonDao personDao = new PersonData();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		List<Person> list = personDao.searchPerson(firstName, lastName);
		request.getSession().setAttribute("list", list);
		response.sendRedirect("SearchJSP2.jsp");
	}
}
