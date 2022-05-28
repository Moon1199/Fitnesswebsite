<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Mein Profil</title>
		<base href="${pageContext.request.requestURI}" />
	</head>
	<body>
		<h2>Hier sind Ihre regestierte Daten</h2>
		
		<br><b>Kunden Nummer </b>${form.id}
		<br><b>Name: </b>${form.name}
		<br><b>Vorname </b>${form.vorname}
		<br><b>E-mail: </b>${form.email}
		<br><b>Passwort </b>${form.password}
		<br><b>Gebortsdatum </b>${form.geburtsdatum}
		
	</body>
</html>