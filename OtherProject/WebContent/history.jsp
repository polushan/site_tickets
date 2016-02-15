<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="tables.User, tables.Request, java.util.ArrayList, dao.impl.Factory"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>History</title>
</head>
<body>
	<table border="1">
		<caption>Последние завопросы</caption>
		<tr>
			<th>Откуда</th>
			<th>Куда</th>
			<th>Когда</th>
			<th>Тип транспорта</th>
		</tr>
		<%
		User user = (User)request.getSession().getAttribute("user");
		Request req = null;
		if (user != null) {
			ArrayList<Request> history = Factory.getUserDAO().getHistory(user);
			 for (int i = 0; i < history.size(); i++) {
				 req = history.get(i);
				 out.println("<tr>");
				 out.println("<td>" + req.getFromStation() + "</td>");
				 out.println("<td>" + req.getToStation() + "</td>");
				 out.println("<td>" + req.getDate() + "</td>");
				 out.println("<td>" + req.getTransportType() + "</td>");
				 out.println("</tr>");
		 	}
		} else {
			req = (Request)request.getSession(true).getAttribute("lastRequest");
			if (req != null) {
				 out.println("<tr>");
				 out.println("<td>" + req.getFromStation() + "</td>");
				 out.println("<td>" + req.getToStation() + "</td>");
				 out.println("<td>" + req.getDate() + "</td>");
				 out.println("<td>" + req.getTransportType() + "</td>");
				 out.println("</tr>");
			 }
		}
	%>
	</table>
	<a href="index.jsp"> Перейти к поиску</a>
</body>
</html>