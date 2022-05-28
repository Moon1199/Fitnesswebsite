


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
 * Servlet implementation class anmeldeServlet
 */
@WebServlet("/anmeldeServlet")
public class anmeldeServlet extends HttpServlet {
	private String passwortEingabe;
	boolean anmeldungErfolgreich;
	private static final long serialVersionUID = 1L;
    
	@Resource (lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		passwortEingabe = request.getParameter("passwort");
		String benutzername = request.getParameter("benutzername");
		anmelden(benutzername);
		request.setAttribute("benutzer", benutzername);	
		
		
	
		if(anmeldungErfolgreich==true) {
		final RequestDispatcher dispatcher = request.getRequestDispatcher("startseite.jsp");
		dispatcher.forward(request, response);
		
		}
		else {
		final RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
		}

	}
	private boolean anmelden(String benutzername) throws ServletException {
		String passwort ="";
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT passwort FROM benutzer WHERE benutzername = ?")){
			pstmt.setString(1, benutzername);
		try (ResultSet rs = pstmt.executeQuery()) {
			if (rs != null && rs.next()) {
				
				 passwort = rs.getString("passwort");
			}
		}
	}catch (Exception ex) {
		throw new ServletException(ex.getMessage());
	}
		if(passwortEingabe==passwort) {
		return anmeldungErfolgreich=true;
		}
		else {
		return anmeldungErfolgreich=false;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}


