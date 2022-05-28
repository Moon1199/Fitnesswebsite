
import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/searchServlet")
//@WebServlet(urlPatterns= {"/searchServlet","/search"}, loadOnStartup = 1)
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String uebung = request.getParameter("search");
		List<uebungen> uebungen = search(uebung);
		request.setAttribute("uebungen", uebungen);

//		HttpSession session = request.getSession();
//		uebungen uebungSession = new uebungen();
//		uebungSession.setUebungsid(Integer.valueOf(request.getParameter("uebungsid")));
//		uebungSession.setUebungsName(request.getParameter("uebungsName"));
//		uebungSession.setBeschreibung(request.getParameter("beschreibung"));
//		uebungSession.setDauer(Integer.valueOf(request.getParameter("dauer")));
//		uebungSession.setSaetze(Integer.valueOf(request.getParameter("saetze")));
//		uebungSession.setSaetze(Integer.valueOf(request.getParameter("wiederholungen")));
//		
//		session.setAttribute("uebungSession", uebungSession);

		final RequestDispatcher dispatcher = request.getRequestDispatcher("./jsp/suchergebnis.jsp");
		dispatcher.forward(request, response);
	}

	private List<uebungen> search(String uebung1) throws ServletException {
		uebung1 = (uebung1 == null || uebung1 == "") ? "%" : "%" + uebung1 + "%";
		List<uebungen> uebungen = new ArrayList<uebungen>();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM uebungen WHERE uebungsName LIKE ?")) {

			pstmt.setString(1, uebung1);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {

					uebungen uebung = new uebungen();

					Integer uebungsid = rs.getInt("uebungsId");
					uebung.setUebungsId(uebungsid);

					String uebungsName = rs.getString("uebungsName");
					uebung.setUebungsName(uebungsName);

					String beschreibung = rs.getString("beschreibung");
					uebung.setBeschreibung(beschreibung);
					;

					Integer dauer = rs.getInt("dauer");
					uebung.setDauer(dauer);

					Integer saetze = rs.getInt("saetze");
					uebung.setSaetze(saetze);

					Integer wiederholungen = rs.getInt("wiederholungen");
					uebung.setWiederholungen(wiederholungen);

					uebungen.add(uebung);

				}
			}
		} catch (Exception ex) {

			throw new ServletException(ex.getMessage());
		}

		return uebungen;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}
}
