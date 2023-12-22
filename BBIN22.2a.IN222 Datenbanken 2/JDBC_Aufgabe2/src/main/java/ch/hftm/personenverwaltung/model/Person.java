package ch.hftm.personenverwaltung.model;

import java.util.*;

public class Person {
	
	private int id;
	private String name;
	private String vorname;
	private String strasseNr;
	private String plz;
	private String ort;
	private boolean bezahlt;
	private String bemerkungen;
	private Date eintritt;
	private Date austritt;
	
	private Status status;
	
	private Person mentor;
	
	private List<Person> mentees = new ArrayList<Person>();
	
	public Person() {
	}
	
	/**
	 * Constructor without ID and nullable Fields
	 */
	public Person(String name, String vorname, String strasseNr, String plz, String ort, boolean bezahlt,
			Status status) {
		this.name = name;
		this.vorname = vorname;
		this.strasseNr = strasseNr;
		this.plz = plz;
		this.ort = ort;
		this.bezahlt = bezahlt;
		this.status = status;
	}
	
	public void addMentee(Person mentee) {
		mentees.add(mentee);
	}
	
	public void removeMentee(Person mentee) {
		mentees.remove(mentee);
	}

	public int getId() {
		return id;
	}

	public void setId(int persid) {
		this.id = persid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getStrasseNr() {
		return strasseNr;
	}

	public void setStrasseNr(String strasseNr) {
		this.strasseNr = strasseNr;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public boolean isBezahlt() {
		return bezahlt;
	}

	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}

	public String getBemerkungen() {
		return bemerkungen;
	}

	public void setBemerkungen(String bemerkungen) {
		this.bemerkungen = bemerkungen;
	}

	public Date getEintritt() {
		return eintritt;
	}

	public void setEintritt(Date eintritt) {
		this.eintritt = eintritt;
	}

	public Date getAustritt() {
		return austritt;
	}

	public void setAustritt(Date austritt) {
		this.austritt = austritt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Person getMentor() {
		return mentor;
	}

	public void setMentor(Person mentor) {
		this.mentor = mentor;
	}

	public List<Person> getMentees() {
		return mentees;
	}
	
	public String toString() {
		String p = "Person: "  + this.getId() + "\n";
		p +=       "--------------\n";
		
		p += "Name: " + this.getVorname() + " " + this.getName() + "\n";
		p += "Adresse: " + this.getStrasseNr() + ", " + this.getPlz() + " " + this.getOrt() + "\n";
		p += "Bezahlt: " + this.isBezahlt() + "\n";
		if (this.getBemerkungen() != null) {
			p += "Bemerkungen: " + this.getBemerkungen()+ "\n";
		}
		if (this.getEintritt() != null) {
			p += "Eintritt: " + this.getEintritt()+ "\n";
		}
		if (this.getAustritt() != null) {
			p += "Austritt: " + this.getAustritt()+ "\n";
		}
		if (this.getStatus() != null) {
			p += this.getStatus()+ "\n";
		}
		
		return p;
	}
}
