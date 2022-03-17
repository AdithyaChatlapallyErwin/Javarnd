package com.javarnd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarnd.Helper.SaveDetailsHelper;
import com.javarnd.model.City;
import com.javarnd.model.Country;
import com.javarnd.model.Language;
import com.javarnd.model.Sport;

/**
 * Servlet implementation class SaveDetailsServlet
 */
@WebServlet("/SaveDetailsServlet")
public class SaveDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String countryName = request.getParameter("country");
		String languageName = request.getParameter("language");
		String cityName = request.getParameter("city");
		String sportName = request.getParameter("sport");
		
		Country country = new Country();
		Language language = new Language();
		City city = new City();
		Sport sport = new Sport();
		
		country.setCountry_Name(countryName);
		language.setLanguage_Name(languageName);
		city.setCity_Name(cityName);
		sport.setSport_Name(sportName);
		
		ArrayList<Object> details = new ArrayList<Object>();
		 details.add(country);
		 details.add(language);
		 details.add(city);
		 details.add(sport);
		 
		 SaveDetailsHelper saveDetails = new SaveDetailsHelper();
		 boolean flag = saveDetails.saveDetails(details);
		 if (flag) {
			 RequestDispatcher rd=request.getRequestDispatcher("/ResponsePage.jsp");
			 request.setAttribute("flag", flag);
			 request.setAttribute("responseString", "object saved successfully");
			 rd.forward(request, response);
		 }else {
			 RequestDispatcher rd1=request.getRequestDispatcher("/ResponsePage.jsp");
			 request.setAttribute("flag", flag);
			 request.setAttribute("responseString", "Error in saving object");
			 rd1.forward(request, response);
		 }
		 
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
