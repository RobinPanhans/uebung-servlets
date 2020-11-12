package de.java.panhans.uebung_servlets.control;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import de.java.panhans.uebung_servlets.entity.Speise;

@ApplicationScoped
public class GerichteKueche {

	@Produces
	@ApplicationScoped
	public Speisekarte createSamples(@New Speisekarte bestand) {
		bestand.add(new Speise(1, "Pizza", 10));
		bestand.add(new Speise(2, "Salat", 11));
		bestand.add(new Speise(3, "Hummer", 12));
		bestand.add(new Speise(4, "Makrele", 13));
		return bestand;
	}

}