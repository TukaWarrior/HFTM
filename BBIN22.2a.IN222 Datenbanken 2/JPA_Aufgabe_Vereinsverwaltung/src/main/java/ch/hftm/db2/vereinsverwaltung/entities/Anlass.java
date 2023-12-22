package ch.hftm.db2.vereinsverwaltung.entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANLASS")
public class Anlass {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ANLAID")
	private Long id;

	private String bezeichner;

	private String ort;

	private LocalDate datum;

	private Double kosten;

	@ManyToOne
	@JoinColumn(name = "ORGID")
	private Person organisator;

	@ManyToMany
	@JoinTable(name = "TEILNEHMER",
	 joinColumns = @JoinColumn(name = "ANLAID"),
	 inverseJoinColumns = @JoinColumn(name = "PERSID"))
	private List<Person> teilnehmer;
	
	public Anlass() {
	}

	public Anlass(String bezeichner, LocalDate datum, Person organisator) {
		this.bezeichner = bezeichner;
		this.datum = datum;
		this.organisator = organisator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBezeichner() {
		return bezeichner;
	}

	public void setBezeichner(String bezeichner) {
		this.bezeichner = bezeichner;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public Double getKosten() {
		return kosten;
	}

	public void setKosten(Double kosten) {
		this.kosten = kosten;
	}

	public Person getOrganisator() {
		return organisator;
	}

	// Helper-Methode für bi-direktionale Beziehung. Referenz auch auf der anderen Seite setzen, da aktuelle Seite die Besitzerseite ist.
	public void setOrganisator(Person organisator) {
		// allfällige alte Beziehung auflösen
		if(this.organisator != null) {
			this.organisator.getOrganisierteAnlaesse().remove(this);
		}

		// neue Beziehung setzen
		if(!organisator.getOrganisierteAnlaesse().contains(this) && organisator != null) {
			organisator.getOrganisierteAnlaesse().add(this);
		}
		this.organisator = organisator;
	}

	public List<Person> getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(List<Person> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	@Override
	public String toString() {
		String a = "Anlass " + id + ": " + bezeichner + ", Datum=" + datum + ", Organisator=" + organisator.getName();
		if (ort != null) {
			a += ", Ort=" + ort;
		}
		if (kosten != null) {
			a += ", Kosten=" + kosten;
		}
		
		if (teilnehmer != null && teilnehmer.size() > 0) {
			a += ", Teilnehmer: " + teilnehmer.size();
		} else {
			a += ", Keine Teilnehmer.";
		}
		

		return a;
	}
}