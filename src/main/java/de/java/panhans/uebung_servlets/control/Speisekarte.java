package de.java.panhans.uebung_servlets.control;

import java.util.Collection;

import java.util.LinkedList;

import javax.annotation.PostConstruct;

import de.java.panhans.uebung_servlets.entity.Speise;

@GerichteHandling
public class Speisekarte {

	
	private final Collection<Speise> gerichte = new LinkedList<>();

	// nur 1 Bestand in der Anwendung -> Singleton

	@PostConstruct
	public void init() {
		gerichte.add(new Speise(1, "Pizza", 1));
		gerichte.add(new Speise(2, "Salat", 2));
		gerichte.add(new Speise(3, "Hummer", 3));
		gerichte.add(new Speise(4, "Makrele", 4));
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


}