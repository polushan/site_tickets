package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.SQLGrammarException;
import org.w3c.dom.Document;

import dao.CityDAO;
import dao.Factory;
import tables.City;
import tables.Request;
import tables.User;
import util.Answer;
import util.RequestSender;
import util.SomethingWrongException;

@WebServlet("/Index")
public class Index extends Dispetcher {
	private static final long serialVersionUID = 1L;

	public Index() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String from = request.getParameter("from").trim();
		String to = request.getParameter("to").trim();

		if ("".equals(from) || "".equals(to) || from == null || to == null) {
			forward("/index.jsp", request, response);
		} else {
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute("user");
			Request userRequest = new Request();
			boolean guest = false;
			if (user == null) {
				userRequest.setUserId(new Long(0));
				guest = true;
			} else {
				userRequest.setUserId(user.getId());
			}
			userRequest.setTransportType(request.getParameter("transport_type"));
			DateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
			String date = request.getParameter("date");
			try {
				if (date != null) {
					userRequest.setDate(dateForm.parse(date));
				} else {
					throw new ParseException(date, 0);
				}
			} catch (ParseException e) {
				date = "";
			}
			CityDAO cityDAO = Factory.getCityDAO();
			City fromCity = null;
			City toCity = null;
			try {
				fromCity = cityDAO.getCityByName(from);
				toCity = cityDAO.getCityByName(to);
				if (fromCity != null && toCity != null) {
					userRequest.setFrom(fromCity);
					userRequest.setTo(toCity);
					Document doc = RequestSender.sendRequest(userRequest, date);
					if (doc != null) {
						request.setAttribute("timetable", new Answer(doc));
					} else {
						throw new IOException();
					}
					if (guest) {
						request.getSession(true).setAttribute("lastRequest", userRequest);
					} else {
						Factory.getRequestDAO().addRequest(userRequest);
					}
					forward("/timetable.jsp", request, response);
				} else {
					response.setContentType("text/html");
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.println("<b>Ничего не найденно</b>");
				}
			} catch (IOException | SQLException e) {
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.println("<b>Ничего не найденно</b>");
			} catch (SomethingWrongException | SQLGrammarException e) {
				forward("/error.jsp", request, response);
			}

		}

	}
}
