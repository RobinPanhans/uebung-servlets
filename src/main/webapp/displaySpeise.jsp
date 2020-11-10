<%@page import="de.java.panhans.uebung_servlets.entity.Speise"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c:out" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Speisen</title>
</head>
<body>
<ul>

	<c:forEach items="${sp}" var="s">
		<li><c:out value="${s.name}, ${s.speiseID}"/></li>
	</c:forEach>

</ul>
</body>
</html>