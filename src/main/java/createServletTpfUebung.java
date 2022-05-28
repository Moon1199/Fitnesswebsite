

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createServletTpfUebung
 */
@WebServlet("/createServletTpfUebung")
public class createServletTpfUebung extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		uebungen form = new uebungen();
		form.setUebungsName(request.getParameter("uebungsName"));
		form.setBeschreibung(request.getParameter("beschreibung"));
		form.setDauer(Integer.valueOf(request.getParameter("dauer")));
		form.setSaetze(Integer.valueOf(request.getParameter("saetze")));
		form.setWiederholungen(Integer.valueOf(request.getParameter("wiederholungen")));
		
		// DB-Zugriff
		persist(form);

		// Scope "Request"
		request.setAttribute("form", form);

		// Test
		// response.sendRedirect("./html/uebungBestaetigung.jsp");
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./html/uebungBestaetigung.jsp");
		dispatcher.forward(request, response);

	}

	private void persist(uebungen form) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] { "uebungsId" }; // Name der Spalte(n), die automatisch generiert wird(werden)

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO uebungen (uebungsName, beschreibung, dauer, saetze, wiederholungen) VALUES (?,?,?,?,?)",
						generatedKeys)) {

			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, form.getUebungsName());
			pstmt.setString(2, form.getBeschreibung());
			pstmt.setInt(3, form.getDauer());
			pstmt.setInt(4, form.getSaetze());
			pstmt.setInt(5, form.getWiederholungen());

			pstmt.executeUpdate();

			// Generierten Schlüssel auslesen
			ResultSet rs = pstmt.getGeneratedKeys();
			while (rs.next()) {
				form.setUebungsId(rs.getInt(1));
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
