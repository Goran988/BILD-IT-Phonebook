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
import org.bildit.utility.Validation;	

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegisteredUserDao registeredUserDao = new RegisteredUserData();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("submit") != null) {
			String submit = request.getParameter("submit");
			if (submit.equals("login")) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				if (registeredUserDao.findUser(username, password) != null) {
					RegisteredUser registeredUser = registeredUserDao.findUser(
							username, password);
					request.getSession().setAttribute("user", registeredUser);
					request.getSession().setAttribute("message", "");
					response.sendRedirect("wellcomeScreen.jsp");
				} else {
					request.getSession().setAttribute("message",
							"No user found!");
					response.sendRedirect("loginPage.jsp");
				}

			} else if (submit.equals("cancel")) {
				RegisteredUser registeredUser = new RegisteredUser("Guest",
						"Guest");

				request.getSession().setAttribute("user", registeredUser);
				response.sendRedirect("wellcomeScreen.jsp");

			} else if (submit.equals("register")) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				if (Validation.validateUsername(username)
						&& Validation.validatePassword(password)
						&& Validation.usernameFree(username)) {
					RegisteredUser registeredUser = new RegisteredUser(
							username, password);
					registeredUserDao.addUserToDb(registeredUser);
					request.getSession().setAttribute("user", registeredUser);
					response.sendRedirect("loginPage.jsp");
				} else {
					String message = "";
					if (!Validation.usernameFree(username)) {
						message = "Username taken, try something else:";

					} else {
						message = "Username or password invalid, try again:";
					}
					request.getSession().setAttribute("message", message);
					response.sendRedirect("loginPage.jsp");
				}
			}
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String reply = "";
		if (username!=null) {
			if (Validation.usernameFree(username)) {
				reply = "<class=\"error\">Username does not exists in database.</p>";
				response.setContentType("text/html");
				response.getWriter().write(reply);
			} else if (!Validation.usernameFree(username)) {
				reply = "<p class=\"success\">Username exists in database.</p>";
				response.setContentType("text/html");
				response.getWriter().write(reply);
			}
		}
	}
}
