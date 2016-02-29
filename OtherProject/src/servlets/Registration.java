package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Factory;
import dao.UserDAO;
import tables.User;
import util.MailSender;
import util.—ryptographer;


@WebServlet("/Registration")
public class Registration extends Dispetcher {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		User user = null;
		UserDAO userDAO = Factory.getUserDAO();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try {
			user = userDAO.getUserByEmail(email);
			if (user == null) {
				user = userDAO.getUserByLogin(login);
				if (user == null) {
					password = —ryptographer.md5Custom(password);
					user = new User(email, login, password);
					request.getSession(true).setAttribute("maybeuser", user);
					Random rand = new Random();
					String secretCode = —ryptographer.md5Custom("" + rand.nextLong());
					new MailSender().send("œÓ‚ÂÍ‡ ‚‡¯Â„Ó email'‡", secretCode, email);
					request.getSession().setAttribute("secretCode", secretCode);
					forward("/checkEmail.jsp", request, response);
				} else {
					out.print("<b>" + "Login busy" + "</b><br/>");
					out.close();
					forward("/registration.jsp", request, response);
				}
			} else {
				out.print("<b>" + "Email busy" + "</b><br/>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			forward("/error.jsp", request, response);
		}
	}

}
