<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Einf�gung einer �bung</title>
		<base href="${pageContext.request.requestURI}" />
	</head>
	<body>
		<h2>Hier ist deine �bung</h2>
		
		<br><b>�bungsnummer: </b>${form.uebungsId}
		<br><b>�bungsname: </b>${form.uebungsName}
		<br><b>Beschreibung: </b>${form.beschreibung}
		<br><b>Dauer: </b>${form.dauer}
		<br><b>S�tze: </b>${form.saetze}
		<br><b>Wiederholungen: </b>${form.wiederholungen}
		<button>
		<a href="../html/uebungSuchen.html">Zr�ck zu Plan erstellen </a>

	</button> 
		
	</body>
</html>