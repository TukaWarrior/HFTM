package ch.hftm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "FUNKTION")
public class Funktion {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "FUNKID")
	private Long id;

	private String bezeichner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBezeichner() {
		return this.bezeichner;
	}

	public void setBezeichner(String bezeichner) {
		this.bezeichner = bezeichner;
	}

}