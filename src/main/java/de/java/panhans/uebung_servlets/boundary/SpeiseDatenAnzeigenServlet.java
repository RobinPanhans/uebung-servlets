package de.java.panhans.uebung_servlets.boundary;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.java.panhans.uebung_servlets.entity.Speise;

@WebServlet("/speisen")
public class SpeiseDatenAnzeigenServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Logik, z.B. DB-Zugriff o.Ä.
		
		Collection<Speise> speisen = new LinkedList<>();
		speisen.add(new Speise("Pizza", 1));
		speisen.add(new Speise("Salat", 2));
		
		// Antwort generieren in JSP, kein PrintWriter!
		request.setAttribute("sp", speisen);
		request.getRequestDispatcher("/displaySpeise.jsp")
			.forward(request, response);
	
		
	}
	
}
