package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Factory;
import tables.User;
import util.Ñryptographer;


@WebServlet("/CheckUser")
public class CheckUser extends Dispetcher {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login").trim();
		String password = request.getParameter("password").trim();
		if ("".equals(login.trim()) || "".equals(password.trim()) || login == null || password == null) {
			forward("/login.jsp", request, response);
		}
		try {
			User user = Factory.getUserDAO().getUserByLogin(login);
			if (user != null && user.getPassword().trim().equals(Ñryptographer.md5Custom(password))) {
				request.getSession(true).setAttribute("user", user);
				forward("/success.jsp", request, response);
			} else {
				forward("/login.jsp", request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			forward("/error.jsp", request, response);
		}
	}
	
	public CheckUser() {
        super();
    }
}
