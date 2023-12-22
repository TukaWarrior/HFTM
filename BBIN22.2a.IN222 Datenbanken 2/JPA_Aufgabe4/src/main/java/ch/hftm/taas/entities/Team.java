package ch.hftm.taas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "TEAM_ID")
	private int id;
	
	@Column(length = 50, nullable=false)
	private String name;
	
	@Column(length = 50)
	private String farbe;
	
	private int punkte;
	
	@OneToMany(mappedBy = "team")
	private List<Spieler> spieler;

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

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public List<Spieler> getSpieler() {
		return spieler;
	}

	public void setSpieler(List<Spieler> spieler) {
		this.spieler = spieler;
	}
}
