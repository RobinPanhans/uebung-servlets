package de.java.panhans.uebung_servlets.entity;

public class Speise {

	private String name;
	private int speiseID;
	
	public Speise() {
		super();
	}
	
	public Speise(String name,int speiseID) {
		super();
		this.name = name;
		this.speiseID = speiseID;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeiseID() {
		return speiseID;
	}
	public void setSpeiseID(int speiseId) {
		this.speiseID = speiseId;
	}
	
	
}
