package de.java.panhans.uebung_servlets.boundary;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/merkliste")
public class MerklisteAnzeigenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private Merkliste merkliste;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Logik, z.B. DB-Zugriff o.Ä.


		request.setAttribute("sp", merkliste.getSpeisen()); // null ist okay
		request.setAttribute("pageTitle", "Merkliste");
		request.setAttribute("merkenFormDisabled", true);
		request.getRequestDispatcher("/WEB-INF/displaySpeise.jsp").forward(request, response);

	}

}