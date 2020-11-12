package de.java.panhans.uebung_servlets.boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import de.java.panhans.uebung_servlets.control.Speisekarte;
import de.java.panhans.uebung_servlets.entity.Speise;

@WebServlet("/gerichtAnlegen")
public class SpeisekarteAnlegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String speiseIDParam = request.getParameter("speiseID");

		// Konvertierung / Validierung
		if (null == name || null == speiseIDParam || name.isEmpty() || speiseIDParam.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		int speiseID;
		try {
			speiseID = Integer.valueOf(speiseIDParam);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		Speisekarte bestand = (Speisekarte) getServletContext().getAttribute("speisen");
		// neue ID finden
		Optional<Integer> max = bestand.getSpeisen().stream().map(Speise::getId).max(Comparator.naturalOrder());

		Speise speise = new Speise(max.orElse(0) + 1, name, speiseID);

		// JSR 303 Bean Validation
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Speise>> violations = validator.validate(speise);
		if (!violations.isEmpty()) {
			// fachlicher Fehler, kein technischer Fehler
			response.setContentType("text/plain");
			try (PrintWriter out = response.getWriter()) {
				out.println("Objekt ist fehlerhaft, konnte nicht eingefügt werden");
				violations.forEach(v -> out.printf(" - %s %s%n", v.getPropertyPath(), v.getMessage()));
			}
			return;
		}

		// Fahrzeug einfügen
		bestand.add(new Speise(max.orElse(0) + 1, name, speiseID));

		// Anzeige der Fahrzeugdaten
		response.sendRedirect("speisen");

	}

}