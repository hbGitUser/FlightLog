<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="flightlog" class="flightLog.FlightLog"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="flightLog.entities.Pilot"%>
<%@page import="java.util.List"%>
<%@page import="flightLog.entities.Flight"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flights List</title>
</head>
<body>

<h1>Flights List</h1>
<%
	try{
		Long id = new Long(request.getParameter("id"));
		Pilot pilot = flightlog.getPilot(id);
%>
<h2>Pilot: <%= pilot.getSurname() %>, <%= pilot.getForename() %></h2>

<table border="1">
	<thead>
		<th>id</th><th>nr</th><th>Date</th><th>takeOff</th><th>SailplaneModel</th>
	</thead>
<%
	if(pilot != null){
		for(Flight f : flightlog.getFlightsForPilotId(id)){
%>	
	<tr>
		<td><%= f.getId() %></td>
		<td><%= f.getNumber() %></td>
		<td><%= f.getDateTof() %></td>
		<td><%= f.getLocationTof() %></td>
		<td><%= f.getSailplaneModel() %></td>
	</tr>
<%
		}
	}
%>
</table>
<%
	} catch(Exception e){
		out.println("<h1>" + e + "</h1>");
	}
%>
</body>
</html>