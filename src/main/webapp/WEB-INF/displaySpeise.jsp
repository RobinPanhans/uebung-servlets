<%@page import="de.java.panhans.uebung_servlets.entity.Speise"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Speisen</title>
</head>
<body>

	<h1>
		<c:out
			value="${empty pageTitle ? 'Anzeige von Speisen' : pageTitle}" />
	</h1>
	
	<form action="merken" method="post">
		<ul>
			<c:forEach items="${sp}" var="s">
				<li>
					<c:if test="${!merkenFormDisabled}">
						<input type="checkbox" name="id" value="${s.id}">
					</c:if>
					<c:out value="${s.name} , ${s.speiseID}" />
				</li>
			</c:forEach>
		</ul>
		<c:if test="${!merkenFormDisabled}">
			<input type="submit" value="Markierte Speisen auf Merkliste setzen">
		</c:if>
	</form>

</body>
</html>