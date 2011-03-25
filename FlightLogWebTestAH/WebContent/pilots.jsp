<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="flightLog.entities.Pilot"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="flightlog" class="flightLog.FlightLog"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pilots List</title>
</head>
<body>

<h1>Pilots List</h1>

<table border="1">
	<thead>
		<th>id</th><th>surename</th><th>forename</th><th>Flights</th>
	</thead>
<%
	List<Pilot> list = flightlog.getPilots(null);
	for(Pilot pilot:list){
%>	
	<tr>
		<td><a href="PilotDetail.jsp?id=<%= pilot.getId() %>"><%= pilot.getId() %></a></td>
		<td><%= pilot.getSurname() %></td>
		<td><%= pilot.getForename() %></td>
		<td><a href="flights.jsp?id=<%= pilot.getId() %>">Flights</a></td>
	</tr>
<%
	}
%>	
</table>
</body>
</html>