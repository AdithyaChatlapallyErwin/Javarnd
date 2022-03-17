package com.javarnd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int city_Id;
	private String city_Name;
	@OneToOne
	private Country country;
	

	public City(String city_Name, Country country) {
		super();
		this.city_Name = city_Name;
		this.country = country;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		country = country;
	}
	public int getCity_Id() {
		return city_Id;
	}
	public void setCity_Id(int city_Id) {
		this.city_Id = city_Id;
	}
	public String getCity_Name() {
		return city_Name;
	}
	public void setCity_Name(String city_Name) {
		this.city_Name = city_Name;
	}
	public City(String city_Name) {
		super();
		this.city_Name = city_Name;
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public String toString() {
//		return "City [city_Id=" + city_Id + ", city_Name=" + city_Name + ", Country=" + country + "]";
//	}
	
	

}
