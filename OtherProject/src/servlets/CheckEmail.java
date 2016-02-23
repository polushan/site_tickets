package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Factory;
import tables.User;


@WebServlet("/CheckEmail")
public class CheckEmail extends Dispetcher {
	private static final long serialVersionUID = 1L;
       
    public CheckEmail() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String code = session.getAttribute("secretCode").toString();
		if (code.equals(request.getParameter("code").toString())) {
			User user = (User)session.getAttribute("maybeuser");
			try {
				Factory.getUserDAO().addUser(user);
				session.removeAttribute("maybeuser");
				session.setAttribute("user", user);
				forward("/success.jsp", request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<b>Wrong cod</b></br>");
			out.print("<a href=\"index.jsp\"> Перейти к поиску</a>");
			out.close();
			
		}
	}

}
