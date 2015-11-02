package org.bildit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.beans.RegisteredUser;
import org.bildit.dao.RegisteredUserDao;
import org.bildit.data.RegisteredUserData;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RegisteredUserDao registeredUserDao = new RegisteredUserData();
		if (request.getParameter("submit") != null) {
			String submit = request.getParameter("submit");
			if (submit.equals("login")) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				if (registeredUserDao.findUser(username, password) != null) {
					RegisteredUser registeredUser = registeredUserDao.findUser(
							username, password);
					request.getSession().setAttribute("user", registeredUser);
					response.sendRedirect("wellcomeScreen.html");
				} else {
					response.sendRedirect("loginPage.jsp");
				}

			} else if (submit.equals("guest")) {
				RegisteredUser registeredUser = new RegisteredUser("Guest",
						"Guest");
				request.getSession().setAttribute("user", registeredUser);
				response.sendRedirect("wellcomeScreen.html");

			} else if (submit.equals("register")) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				if ((username.length() != 0 && password.length() != 0)
						|| (username != null && password != null)) {
					RegisteredUser registeredUser = new RegisteredUser(
							username, password);
					registeredUserDao.addUserToDb(registeredUser);
					response.sendRedirect("loginPage.jsp");
				} else {
					response.sendRedirect("loginPage.jsp");
				}
			}
		}
	}
}