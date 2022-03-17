package com.javarnd.Helper;

import java.util.List;

import com.javarnd.Dao.SaveDetailsDao;

public class SaveDetailsHelper {

	public boolean saveDetails(List<Object> details) {
       boolean flag = false;
		flag = new SaveDetailsDao().saveDetails(details);
		return flag;
	}
}
