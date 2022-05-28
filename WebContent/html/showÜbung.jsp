<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page errorPage="uebungNichtVorhanden.jsp" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.requestURI}" />
<title>Übung Anzeigen</title>
</head>
<body>
<h1>Übung Anzeigen</h1>

	<h2>${uebungen.uebungsName}</h2>
	<br><b>Dauer: </b> ${uebungen.dauer} <em>(in Sekunden)</em>
	<br><b>Wiederholungen: </b>${uebungen.wiederholungen}
	<br><b>Sätze: </b>${uebungen.saetze}
	<br><p>${uebungen.beschreibung}</p>
	<br><br><b><button type="submit" value="Hinzufügen">zu Trainingsplan hinzufügen</button></b>
	</body>
</html>