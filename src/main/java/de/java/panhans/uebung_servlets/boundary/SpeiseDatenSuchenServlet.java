package de.java.panhans.uebung_servlets.boundary;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.java.panhans.uebung_servlets.control.Speisekarte;
import de.java.panhans.uebung_servlets.entity.Speise;

@WebServlet("/gerichtesuche")
public class SpeiseDatenSuchenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String suchtext = request.getParameter("suchtext");
		// Validierung?
		if (null == suchtext) {

			// response.sendRedirect("suche.html");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter suchtext must not be null!");

		} else {

			// Logik, z.B. DB-Zugriff o.Ä.

			Collection<Speise> speisen = Speisekarte.getInstance().getSpeisen();
			Collection<Speise> suchErgebnisse = speisen.stream()
					.filter(sp -> sp.getName().toLowerCase().contains(suchtext.toLowerCase()))
					.collect(Collectors.toList());

			// Antwort generieren in JSP, kein PrintWriter!
			request.setAttribute("sp", suchErgebnisse);
			request.getRequestDispatcher("/displaySpeise.jsp").forward(request, response);
		}

	}

}