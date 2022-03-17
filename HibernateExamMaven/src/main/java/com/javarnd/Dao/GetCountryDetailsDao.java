package com.javarnd.Dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.javarnd.model.City;
import com.javarnd.model.Country;
import com.javarnd.model.Language;
import com.javarnd.model.Sport;

public class GetCountryDetailsDao {
	public  ArrayList<String> getCountryDetailsDao(String countryName) {
	Configuration cfg = new Configuration().configure("com/javarnd/resources/hibernate.cfg.xml")
			.addAnnotatedClass(Country.class)
			.addAnnotatedClass(City.class)
			.addAnnotatedClass(Language.class)
			.addAnnotatedClass(Sport.class);
	
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	ArrayList<String> countryDetails = new ArrayList<String>();
	try {
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Country.class);
		Criterion id = Restrictions.eq("country_Name", countryName);
		criteria.add(id);
		List<Country> couns = criteria.list();
		for(Country coun : couns) {
			countryDetails.add(coun.getLanguage().getLanguage_Name());
			countryDetails.add(coun.getCapital().getCity_Name());
			System.out.println(coun.getLanguage().getLanguage_Name() +"\n"+ coun.getCapital().getCity_Name());
			for (Sport sport : coun.getSports()) {
				countryDetails.add(sport.getSport_Name());
				System.out.println(sport.getSport_Name());
			}
		}
		System.out.println(countryDetails);
		session.getTransaction().commit();
		
	}
	
	finally {
		session.close();
		factory.close();
	}
	
return countryDetails;
}
}

