package de.java.panhans.uebung_servlets.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Speise{

	/**
	 * 
	 */
	@Min(1)
	private int id;
	@Size(min=2)
	@NotNull
	@Pattern(regexp = "[A-Z].*")
	private String name;
	@Max(100)
	private int speiseID;
	
	public Speise() {
		super();
	}
	
	public Speise(int id, String name,int speiseID) {
		super();
		this.setId(id);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
