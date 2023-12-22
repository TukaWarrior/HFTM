package ch.hftm.personenverwaltung.model;


public class Status {
	
	private int id;
	private Integer beitrag;
	private String bezeichner;
	
	public Status() {
	}
	
	/**
	 * Constructor without ID and nullable Fields
	 */
	public Status(String bezeichner) {
		this.bezeichner = bezeichner;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int statid) {
		this.id = statid;
	}
	public Integer getBeitrag() {
		return beitrag;
	}
	public void setBeitrag(Integer beitrag) {
		this.beitrag = beitrag;
	}
	public String getBezeichner() {
		return bezeichner;
	}
	public void setBezeichner(String bezeichner) {
		this.bezeichner = bezeichner;
	}
	
	public String toString() {
		String output = "Status: " + this.getId() + "-" + this.getBezeichner();
		if (this.getBeitrag() != null) {
			output += " Beitrag: " + this.getBeitrag();
		}
		
		return output;
	}
}