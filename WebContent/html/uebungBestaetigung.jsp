<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Einfügung einer Übung</title>
		<base href="${pageContext.request.requestURI}" />
	</head>
	<body>
		<h2>Hier ist deine Übung</h2>
		
		<br><b>Übungsnummer: </b>${form.uebungsId}
		<br><b>Übungsname: </b>${form.uebungsName}
		<br><b>Beschreibung: </b>${form.beschreibung}
		<br><b>Dauer: </b>${form.dauer}
		<br><b>Sätze: </b>${form.saetze}
		<br><b>Wiederholungen: </b>${form.wiederholungen}
		<button>
		<a href="../html/uebungSuchen.html">Zrück zu Plan erstellen </a>

	</button> 
		
	</body>
</html>