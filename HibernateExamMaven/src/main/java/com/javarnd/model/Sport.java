package com.javarnd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Sport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sport_Id;
	private String sport_Name;
	@ManyToMany(mappedBy = "sports")
	private List<Country> countries;

	public int getSport_Id() {
		return sport_Id;
	}

	public Sport(String sport_Name, List<Country> countries) {
		super();
		this.sport_Name = sport_Name;
		this.countries = countries;
	}

	public Sport(String sport_Name) {
		super();
		this.sport_Name = sport_Name;
	}

	public Sport() {
		super();
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public String toString() {
//		return "Sport [sport_Id=" + sport_Id + ", sport_Name=" + sport_Name + ", countries=" + countries + "]";
//	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public void setSport_Id(int sport_Id) {
		this.sport_Id = sport_Id;
	}

	public String getSport_Name() {
		return sport_Name;
	}

	public void setSport_Name(String sport_Name) {
		this.sport_Name = sport_Name;
	}

}
