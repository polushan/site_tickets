<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page errorPage="error.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>"Wellcome"</title>
</head>
<body>
	<% 
		if (request.getSession(true).getAttribute("user") == null) {
			out.print("<a href=\"registration.jsp\"> Пройти регистрацию</a><br/>");
			out.print("<a href=\"login.jsp\"> Представиться</a>");
		} else {
			out.print("<a href=\"Logout\"> Logout</a>");
		}	
	%>
	<br/>
		<a href="history.jsp"> История запросов</a>
	<br/>
	<br/>
	<form action="Index" method="get">
		Откуда(Город): <input name="from" type="text" maxlength=30 /><br />
		Куда(Город): <input name="to" type="text" maxlength=30 /><br />
		<p><select size="4" multiple name="transport_type">
    		<option value="plane">Самолёт</option>
   			<option value="train">Поезд</option>
   			<option value="bus">Автобус</option>
   			<option selected value="all">Все</option>
   		</select></p>
		<input type="date" name="date" />
		<input type="submit" name="enter" value="enter" />
	</form>
	
</body>
</html>