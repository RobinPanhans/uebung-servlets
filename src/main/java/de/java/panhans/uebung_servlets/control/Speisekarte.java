package de.java.panhans.uebung_servlets.control;

import java.util.Collection;
import java.util.LinkedList;

import de.java.panhans.uebung_servlets.entity.Speise;

public class Speisekarte {

	private static final Speisekarte theInstance = new Speisekarte();

	private final Collection<Speise> gerichte = new LinkedList<>();

	// nur 1 Bestand in der Anwendung -> Singleton

	private Speisekarte() {
		gerichte.add(new Speise("Pizza", 1));
		gerichte.add(new Speise("Salat", 2));
	}

	public Collection<Speise> getSpeisen() {
		return gerichte;
	}

	public boolean add(Speise e) {
		return gerichte.add(e);
	}

	public boolean remove(Speise o) {
		return gerichte.remove(o);
	}

	public static Speisekarte getInstance() {
		return theInstance;
	}

}