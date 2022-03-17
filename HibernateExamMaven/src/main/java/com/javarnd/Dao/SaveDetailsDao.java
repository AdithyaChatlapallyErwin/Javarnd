package com.javarnd.Dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.javarnd.model.City;
import com.javarnd.model.Country;
import com.javarnd.model.Language;
import com.javarnd.model.Sport;

public class SaveDetailsDao {
	public boolean saveDetails(List<Object> details) {
		boolean flag = false;
	Configuration cfg = new Configuration().configure("com/javarnd/resources/hibernate.cfg.xml")
			.addAnnotatedClass(Country.class)
			.addAnnotatedClass(City.class)
			.addAnnotatedClass(Language.class)
			.addAnnotatedClass(Sport.class);
	
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	try {
		session.beginTransaction();
		Language	lang = new Language();;
		List<Sport> sports = new ArrayList<Sport>();
		City	capital = new City();
		Country	country = new Country();
		Sport sport = new Sport() ;
		for (Object object : details) {
			if (object instanceof Language) {
				lang = (Language) object;
			}
			if (object instanceof Sport) {
				sport = (Sport)object;
				sports = new ArrayList<Sport>();
				sports.add((Sport)object);
			}
			if (object instanceof City) {
				capital = (City) object;
			}
			if (object instanceof Country) {
					country = (Country) object;
			}
		}
		
		Country country1 = new Country(country.getCountry_Name(), lang, capital, sports );
		
		
		session.save(country1);
		session.save(lang);
		session.save(capital);
		session.save(sport);
		session.getTransaction().commit();
		flag = true;
		
	}
	
	finally {
		session.close();
		factory.close();
	}
	
return flag;
}
}

