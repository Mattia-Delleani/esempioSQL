package it.polito.tdp.esempioSQL.model;

public class Station {

	private int id;
	private String name;
	private int dockCount;
	private String landmark;
	/**
	 * @param id
	 * @param name
	 * @param dockCount
	 * @param landmark
	 */
	public Station(int id, String name, int dockCount, String landmark) {
		super();
		this.id = id;
		this.name = name;
		this.dockCount = dockCount;
		this.landmark = landmark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDockCount() {
		return dockCount;
	}
	public void setDockCount(int dockCount) {
		this.dockCount = dockCount;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	
	
	
	
	
}
