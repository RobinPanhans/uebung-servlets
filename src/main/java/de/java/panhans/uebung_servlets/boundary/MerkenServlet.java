package de.java.panhans.uebung_servlets.boundary;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import de.java.panhans.uebung_servlets.control.Speisekarte;

@WebServlet("/merken")
public class MerkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private Speisekarte karte;
	@Inject
	private Merkliste merkliste;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] ids = request.getParameterValues("id");
		if(null != ids && ids.length>0) {
			// ID-Parameter als Integer
			Set<Integer> idSet = Arrays.stream(ids).map(Integer::valueOf).collect(Collectors.toSet());
			// alles aus bestand, dessen ID in idSet (=Parameter) zu finden ist, wird in die Merkliste gepackt.
			karte.getSpeisen().stream().filter(s -> idSet.contains(s.getId())).forEach(merkliste::add);		}
		
		// Anzeige der Merkliste
		response.sendRedirect("merkliste");
		
	}

}