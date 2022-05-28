// Mona

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class trainingsplan_erstellen
 */
@WebServlet("/trainingsplan_erstellen")
public class trainingsplan_erstellen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		trainingsplan plan = new trainingsplan();
		plan.setTrainingsplanName(request.getParameter("trainingsplanName"));
		plan.setUebung1(Integer.valueOf(request.getParameter("uebung1")));
		plan.setUebung2(Integer.valueOf(request.getParameter("uebung2")));
		plan.setUebung3(Integer.valueOf(request.getParameter("uebung3")));
		plan.setUebung4(Integer.valueOf(request.getParameter("uebung4")));
		plan.setUebung5(Integer.valueOf(request.getParameter("uebung5")));
		plan.setUebung6(Integer.valueOf(request.getParameter("uebung6")));
		plan.setUebung7(Integer.valueOf(request.getParameter("uebung7")));
		plan.setUebung8(Integer.valueOf(request.getParameter("uebung8")));
		plan.setUebung9(Integer.valueOf(request.getParameter("uebung9")));
		plan.setUebung10(Integer.valueOf(request.getParameter("uebung10")));
		plan.setUebung11(Integer.valueOf(request.getParameter("uebung11")));
		plan.setUebung12(Integer.valueOf(request.getParameter("uebung12")));
		plan.setUebung13(Integer.valueOf(request.getParameter("uebung13")));
		plan.setUebung14(Integer.valueOf(request.getParameter("uebung14")));
		plan.setUebung15(Integer.valueOf(request.getParameter("uebung15")));
		
	
		HttpSession session = request.getSession();
		session.setAttribute("meinTrainingsplan", plan);
		response.sendRedirect("welche JSP?");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

// Mona