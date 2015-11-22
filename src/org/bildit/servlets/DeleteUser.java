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
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PersonDao personDao = new PersonData();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idNumber = request.getParameter("idNumber");
		personDao.deleteById(idNumber);
		request.getSession().setAttribute("deletion", null);
		response.sendRedirect("wellcomeScreen.jsp");
	}

}
