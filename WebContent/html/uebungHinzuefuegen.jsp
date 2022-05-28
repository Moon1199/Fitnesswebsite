<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Eigene Übung hinzufügen</h1>
	<main>
	<form method="post" action="../createServletTpfUebung">
	<p>

		Übungsname: <input type="text" name="uebungsName" size="20" maxlength="40" required>
		<br> <br>
	</p>

	<p>

		<label for="beschreibung"  >Beschreibung</label>
		<textarea id="beschreibung" name="beschreibung" cols="35" rows="4" placeholder="Hier kannst du dein Übung beschreiben"></textarea>
	<br> <br>
	</p>
	<p>

		<label for="dauer">Dauer in Sekunde</label> <input type="number"
			id="dauer" name="dauer">
			<br> <br>
	</p>
	<p>

		<label for="saetze">sätze</label> <input type="number" id="saetze"
			name="saetze">
			<br> <br>
	</p>
	
	<p>

		<label for="wiederholen">Wiederholungen</label> <input type="number" id="wiederholungen"
			name="wiederholungen">
			<br> <br>
	</p>


	<!-- <p>
		<label for="myfile">Lade ein Bild hoch:</label> <input type="file"
			id="myfile" name="myfile"> <br> <br>
	</p>  -->
	<p>
		<button type="submit" name="action" value="neu" size="80">Übung
			einfügen</button>
			<br> <br>
	</p>

	</main>
	</form>

</body>
</html>
<!-- Hussam -->