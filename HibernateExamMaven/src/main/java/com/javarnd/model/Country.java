package com.javarnd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int country_Id;
private String country_Name;	
@OneToOne
@JoinColumn(name = "language")
private Language language;
@OneToOne
@JoinColumn(name = "capital")
private City capital;
@ManyToMany
private List<Sport> sports;





//@Override
//public String toString() {
//	return "Country [country_Id=" + country_Id + ", country_Name=" + country_Name + ", language=" + language
//			+ ", capital=" + capital + ", sports=" + sports + "]";
//}
public Country(String country_Name, Language language, City capital, List<Sport> sports) {
	super();
	this.country_Name = country_Name;
	this.language = language;
	this.capital = capital;
	this.sports = sports;
}
public Language getLanguage() {
	return language;
}
public void setLanguage(Language language) {
	this.language = language;
}
public List<Sport> getSports() {
	return sports;
}
public void setSports(List<Sport> sports) {
	this.sports = sports;
}
public int getCountry_Id() {
	return country_Id;
}
public void setCountry_Id(int country_Id) {
	this.country_Id = country_Id;
}
public String getCountry_Name() {
	return country_Name;
}
public void setCountry_Name(String country_Name) {
	this.country_Name = country_Name;
}

public City getCapital() {
	return capital;
}
public void setCapital(City capital) {
	this.capital = capital;
}

public Country() {
	super();
	// TODO Auto-generated constructor stub
}



}
