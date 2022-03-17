package com.javarnd.Helper;

import java.util.ArrayList;
import java.util.List;

import com.javarnd.Dao.GetCountryDetailsDao;
import com.javarnd.Dao.SaveDetailsDao;

public class GetCountryDetails {

	public ArrayList<String> getCountryDetailsHelper(String countryName) {
       
		ArrayList<String> countryDetails = new GetCountryDetailsDao().getCountryDetailsDao(countryName);
		return countryDetails;
	}
}
