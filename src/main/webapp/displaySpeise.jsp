<%@page import="de.java.panhans.uebung_servlets.entity.Speise"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Speisen</title>
</head>
<body>
<ul>
<% Collection<Speise> speisen = (Collection<Speise>) request.getAttribute("sp"); 
	for(Speise s : speisen) {
		%><li><%=s.getName() %>, <%=s.getSpeiseID() %></li><%	
	}
 %>
</ul>
</body>
</html>