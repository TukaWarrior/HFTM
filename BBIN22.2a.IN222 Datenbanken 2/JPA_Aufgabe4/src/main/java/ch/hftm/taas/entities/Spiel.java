package ch.hftm.taas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Spiel {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "SPIEL_ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "TEAM1_ID")
	private Team team1;
	
	@ManyToOne
	@JoinColumn(name = "TEAM2_ID")
	private Team team2;
	
	@Column(name = "TORE_TEAM1")
	private int toreTeam1;
	
	@Column(name = "TORE_TEAM2")
	private int toreTeam2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public int getToreTeam1() {
		return toreTeam1;
	}

	public void setToreTeam1(int toreTeam1) {
		this.toreTeam1 = toreTeam1;
	}

	public int getToreTeam2() {
		return toreTeam2;
	}

	public void setToreTeam2(int toreTeam2) {
		this.toreTeam2 = toreTeam2;
	}
	
	
}
