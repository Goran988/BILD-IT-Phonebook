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
 * Servlet implementation class PhonebookServlet
 */
@WebServlet("/PhonebookServlet")
public class PhonebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if (action.equals("Add")) {
				response.sendRedirect("addPerson.jsp");
				return;
			} else if (action.equals("Search")) {
				response.sendRedirect("searchPerson.jsp");
				return;

			} else if (action.equals("Delete")) {
				PersonDao personDao = new PersonData();
				List<Person> list = personDao.getPersons();
				request.getSession().setAttribute("allUsers", list);
				response.sendRedirect("userDeleted.jsp");
			}
		}
	}

}
