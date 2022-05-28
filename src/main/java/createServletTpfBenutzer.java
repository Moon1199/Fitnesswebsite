import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServletTpf
 */
@WebServlet("/CreateServletTpf")
public class createServletTpfBenutzer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		benutzer form = new benutzer();
		form.setAnrede(request.getParameter("anrede"));
		form.setNachname(request.getParameter("nachname"));
		form.setVorname(request.getParameter("vorname"));
		form.setEmail(request.getParameter("email"));
		form.setBenutzername(request.getParameter("benutzername"));
		form.setPasswort(request.getParameter("passwort"));

		form.setGeburtsdatum(request.getParameter("geburtsdatum"));
		form.setGewicht(Integer.valueOf(request.getParameter("gewicht")));
		form.setGroesse(Integer.valueOf(request.getParameter("größe")));
		

		// DB-Zugriff
		persist(form);

		// Scope "Request"
		request.setAttribute("form", form);

		// Test
		response.sendRedirect("./html/startSeite.jsp");
		// Weiterleiten an JSP
		// final RequestDispatcher dispatcher =
		// request.getRequestDispatcher("TrainingNachanmeldung.java");
		// dispatcher.forward(request, response);
	}

	private void persist(benutzer form) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] { "benuzerId" }; // Name der Spalte(n), die automatisch generiert
																// wird(werden)

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO benutzer (anrede, nachname, vorname, email, benutzername, passwort, Geburtsdatum, groesse, gewicht) VALUES (?,?,?,?,?,?,?,?,?)",
						generatedKeys)) {

			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, form.getAnrede());
			pstmt.setString(2, form.getNachname());
			pstmt.setString(3, form.getVorname());
			pstmt.setString(4, form.getEmail());
			pstmt.setString(5, form.getBenutzername());

			pstmt.setString(6, form.getPasswort());

			pstmt.setString(7, form.getGeburtsdatum());
			pstmt.setInt(8, form.getGroesse());
			pstmt.setInt(9, form.getGewicht());

			pstmt.executeUpdate();

			// Generierten Schlüssel auslesen
			ResultSet rs = pstmt.getGeneratedKeys();
			while (rs.next()) {
				form.setId(rs.getLong(1));
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
/* Hussam */