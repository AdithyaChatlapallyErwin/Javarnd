package com.javarnd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarnd.Helper.GetCountryDetails;
import com.javarnd.Helper.SaveDetailsHelper;
import com.javarnd.model.City;
import com.javarnd.model.Country;
import com.javarnd.model.Language;
import com.javarnd.model.Sport;

/**
 * Servlet implementation class SaveDetailsServlet
 */
@WebServlet("/GetCountryDetailsServlet")
public class GetCountryDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String countryName = request.getParameter("country");
		 ArrayList<String> countryDetails = new GetCountryDetails().getCountryDetailsHelper(countryName);
		request.setAttribute("countryDetailsList", countryDetails);
		RequestDispatcher rd = request.getRequestDispatcher("/FetchCountryDetails.jsp");
		rd.forward(request, response);
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
