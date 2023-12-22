package ch.hftm.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "PERSID")
	private Long id;

	private LocalDate austritt;

	private String bemerkungen;

	private boolean bezahlt;

	private LocalDate eintritt;

	private String name;

	private String ort;

	private String plz;

	@Column(name = "STRASSE_NR")
	private String strasseNr;

	private String vorname;

	@ManyToOne
	@JoinColumn(name = "STATID")
	private Status status;

	public Person() {
	}

	/**
	 * Constructor without ID and nullable Fields
	 */
	public Person(String name, String vorname, String strasseNr, String plz, String ort,
			boolean bezahlt, Status status) {
		this.name = name;
		this.vorname = vorname;
		this.strasseNr = strasseNr;
		this.plz = plz;
		this.ort = ort;
		this.bezahlt = bezahlt;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long persid) {
		this.id = persid;
	}

	public LocalDate getAustritt() {
		return this.austritt;
	}

	public void setAustritt(LocalDate austritt) {
		this.austritt = austritt;
	}

	public String getBemerkungen() {
		return this.bemerkungen;
	}

	public void setBemerkungen(String bemerkungen) {
		this.bemerkungen = bemerkungen;
	}

	public boolean isBezahlt() {
		return bezahlt;
	}

	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}

	public LocalDate getEintritt() {
		return this.eintritt;
	}

	public void setEintritt(LocalDate eintritt) {
		this.eintritt = eintritt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrt() {
		return this.ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return this.plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStrasseNr() {
		return this.strasseNr;
	}

	public void setStrasseNr(String strasseNr) {
		this.strasseNr = strasseNr;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String toString() {
		String p = "Person: " + this.getId() + "\n";
		p += "--------------\n";

		p += "Name: " + this.getVorname() + " " + this.getName() + "\n";
		p += "Adresse: " + this.getStrasseNr() + ", " + this.getPlz() + " "
				+ this.getOrt() + "\n";
		p += "Bezahlt: " + this.isBezahlt() + "\n";
		if (this.getBemerkungen() != null) {
			p += "Bemerkungen: " + this.getBemerkungen() + "\n";
		}
		if (this.getEintritt() != null) {
			p += "Eintritt: " + this.getEintritt() + "\n";
		}
		if (this.getAustritt() != null) {
			p += "Austritt: " + this.getAustritt() + "\n";
		}
		if (this.getStatus() != null) {
			p += this.getStatus() + "\n";
		}

		return p;
	}

}