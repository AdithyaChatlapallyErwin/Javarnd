package com.javarnd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int language_Id;
	private String language_Name;
	@OneToMany(mappedBy = "language")
	private List<Country> countries;
	
	public int getLanguage_Id() {
		return language_Id;
	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public void setLanguage_Id(int language_Id) {
		this.language_Id = language_Id;
	}
	public String getLanguage_Name() {
		return language_Name;
	}
	public void setLanguage_Name(String language_Name) {
		this.language_Name = language_Name;
	}
	public Language(String language_Name) {
		super();
		this.language_Name = language_Name;
	}
	public Language(String language_Name, List<Country> countries) {
		super();
		this.language_Name = language_Name;
		this.countries = countries;
	}
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public String toString() {
//		return "Language [language_Id=" + language_Id + ", language_Name=" + language_Name + ", countries=" + countries
//				+ "]";
//	}
	

}
