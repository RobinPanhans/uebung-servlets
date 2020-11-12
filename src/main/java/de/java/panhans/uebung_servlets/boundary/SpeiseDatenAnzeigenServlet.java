package de.java.panhans.uebung_servlets.boundary;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.java.panhans.uebung_servlets.control.Speisekarte;
import de.java.panhans.uebung_servlets.entity.Speise;

@WebServlet("/speisen")
public class SpeiseDatenAnzeigenServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	@Inject
	private Speisekarte karte;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Logik, z.B. DB-Zugriff o.Ä.
		
		Collection<Speise> speisen = karte.getSpeisen();
		
		// Antwort generieren in JSP, kein PrintWriter!
		request.setAttribute("sp", speisen);
		request.setAttribute("pageTitle", "Anzeige aller Speisen");
		request.getRequestDispatcher("/WEB-INF/displaySpeise.jsp")
			.forward(request, response);
	
		
	}
	
}