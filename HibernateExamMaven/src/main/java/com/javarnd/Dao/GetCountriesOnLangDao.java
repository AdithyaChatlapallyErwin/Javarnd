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

public class GetCountriesOnLangDao {
	public ArrayList<String> getCountriesOnLang(String langName) {
	Configuration cfg = new Configuration().configure("com/javarnd/resources/hibernate.cfg.xml")
			.addAnnotatedClass(Country.class)
			.addAnnotatedClass(City.class)
			.addAnnotatedClass(Language.class)
			.addAnnotatedClass(Sport.class);
	
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	ArrayList<String> countriesS = new ArrayList<String>();
	try {
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Language.class);
		Criterion id = Restrictions.eq("language_Name", langName);
		criteria.add(id);
		List<Language> languages = criteria.list();
		
		for(Language language : languages) {
			int val = 0;
			while(language.getCountries().size() > val) {
				countriesS.add(language.getCountries().get(val).getCountry_Name());
				val++;
			}
			System.out.println(countriesS);
		}
		session.getTransaction().commit();
		
	}
	
	finally {
		session.close();
		factory.close();
	}
	return countriesS;
}
}

