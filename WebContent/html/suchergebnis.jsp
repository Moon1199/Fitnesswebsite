<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
	<head>
		<title>Erfolgreiches Suchen von Übungen</title>
		<base href="${pageContext.request.requestURI}" />
		<%@ page errorPage="Error.jsp" %>
		<style>
			table, th, td {
				border: 1px solid; 
				border-collapse: collapse;
				padding: 5px;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<h2>Erfolgreiches Suchen von Übungen</h2>
		<h3>Gefundene Übungen</h3>
		
		<table>
			<tr>
				<th></th>
				<th>Name</th>
				<th>Dauer</th>
				<th>Wiederholungen</th>
				<th>Sätze</th>
				<th>Beschreibung</th>
			</tr>
			<c:forEach var="uebung" items="${uebungen}">
				<tr>
					<td><button type="submit" value="Hinzufügen">Hinzufügen</button></td>
					<td><a href="../anzeigeServlet?id=${uebung.uebungsId}">${uebung.uebungsName}</a></td>
					<td>${uebung.dauer}</td>
					<td>${uebung.wiederholungen}</td>
					<td>${uebung.saetze}</td>
					<td>${uebung.beschreibung}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>