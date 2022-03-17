package com.javarnd.Helper;

import java.util.ArrayList;
import java.util.List;

import com.javarnd.Dao.GetCountriesOnLangDao;
import com.javarnd.Dao.SaveDetailsDao;

public class GetCountriesOnLang {

	public ArrayList<String> getCountriesOnLang(String  langName) {
       
		ArrayList<String> countriesH = new GetCountriesOnLangDao().getCountriesOnLang(langName);
		return countriesH;
	}
}
