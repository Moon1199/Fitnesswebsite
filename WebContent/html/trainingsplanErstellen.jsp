<!-- Mona -->


<%@ page language="java" contentType="text/html, charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="Error.jsp" %>
<%@ page isErrorPage = "true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Individuellen Trainingsplan erstellen</title>
		<base href="${pageContext.request.requestURI}" />
		
</head>
<body>
		<h2>Übungen auswählen</h2>

		
		<% 
		final String uebungsName = request.getParameter("uebungsName");
		%>
		
		<c:forEach var="uebungen" item="${uebungen}"> 
		
			<!-- <input type="checkbox" name="uebung" id="${uebungen.uebungsID}" value="breakf">
				<label for="${uebungen.uebungsID}">${uebungen.uebungsName}</label>  -->
		
		</c:forEach>
		
		<br><button type="submit" name="action" value="neu">Erstellen</button>

</body>
</html>

<!-- Mona -->