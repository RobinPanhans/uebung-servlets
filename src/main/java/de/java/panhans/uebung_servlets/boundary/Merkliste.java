package de.java.panhans.uebung_servlets.boundary;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import javax.enterprise.context.SessionScoped;

import de.java.panhans.uebung_servlets.control.GerichteHandling;
import de.java.panhans.uebung_servlets.entity.Speise;

@SessionScoped
@GerichteHandling
public class Merkliste implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Collection<Speise> speise = new TreeSet<>(Comparator.comparing(Speise::getId));

	public Collection<Speise> getSpeisen() {
		return speise;
	}
	
	public boolean add(Speise e) {
		return speise.add(e);
	}

	public boolean remove(Speise o) {
		return speise.remove(o);
	}
}