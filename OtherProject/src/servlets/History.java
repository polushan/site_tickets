package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.Factory;
import tables.Request;
import tables.User;

//Нужность этой сервлеты пока под сомнением, ей пока не пользуемся
@Deprecated
@WebServlet("/History")
public class History extends Dispetcher {
	private static final long serialVersionUID = 1L;

   
    public History() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if (user != null) {
			ArrayList<Request> history;
			try {
				history = Factory.getUserDAO().getHistory(user);
				request.setAttribute("history", history);
			} catch (SQLException e) {
				e.printStackTrace();
				//forward("/error.jsp", request, response);
			}
			forward("/history.jsp", request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
