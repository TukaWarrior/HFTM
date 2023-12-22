package ch.hftm.taas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Spieler {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "SPIELER_ID")
	private int id;

	@Column(length = 50, nullable=false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	
	private int salaer;

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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getSalaer() {
		return salaer;
	}

	public void setSalaer(int salaer) {
		this.salaer = salaer;
	}
}
