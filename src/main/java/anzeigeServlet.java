

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class anzeigeServlet
 */
@WebServlet("/anzeigeServlet")
public class anzeigeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource (lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uebung = request.getParameter("id");
		uebungen uebungen = search(uebung);
		request.setAttribute("uebungen", uebungen);
		
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/show‹bung.jsp");
		dispatcher.forward(request, response);
	}


	private uebungen search(String id) throws ServletException {
		uebungen uebungAnzeigen = new uebungen();
//		uebungAnzeigen.setUebungsid(id);
//		uebungAnzeigen.setUebungsName(id);
		try (Connection con = ds.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM uebungen WHERE uebungsid = ?")){
//		pstmt.setLong(1, id);
				PreparedStatement pstmt = con.prepareStatement("SELECT uebungsname,beschreibung,dauer,saetze,wiederholungen FROM uebungen WHERE uebungsid = ?")){
			pstmt.setString(1, id);
		try (ResultSet rs = pstmt.executeQuery()) {
			if (rs != null && rs.next()) {
//				uebungAnzeigen.setUebungsName("uebungsname");
//				uebungAnzeigen.setBeschreibung("beschreibung");
//				uebungAnzeigen.setDauer(Integer.valueOf("dauer"));
//				uebungAnzeigen.setWiederholungen(Integer.valueOf("wiederholungen"));
//				uebungAnzeigen.setSaetze(Integer.valueOf("saetze"));
				
//				Integer uebungsid = rs.getInt("uebungsId");
//				uebungAnzeigen.setUebungsid(uebungsid);
				
				String uebungsName = rs.getString("uebungsName");
				uebungAnzeigen.setUebungsName(uebungsName);
				
				String beschreibung = rs.getString("beschreibung");
				uebungAnzeigen.setBeschreibung(beschreibung);;
				
				Integer dauer = rs.getInt("dauer");
				uebungAnzeigen.setDauer(dauer);
				
				Integer saetze = rs.getInt("saetze");
				uebungAnzeigen.setSaetze(saetze);
				
				Integer wiederholungen = rs.getInt("wiederholungen");
				uebungAnzeigen.setWiederholungen(wiederholungen);
		
			}
		}
	}catch (Exception ex) {
		throw new ServletException(ex.getMessage());
	}
		return uebungAnzeigen;
	}

}
