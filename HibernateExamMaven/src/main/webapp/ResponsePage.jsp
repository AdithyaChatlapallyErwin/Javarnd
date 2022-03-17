<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@page import="com.javarnd.controller.SaveDetailsServlet"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ page isELIgnored="false"%>

<c:out value="${flag}"></c:out>
<c:out value="${responseString}"></c:out>

<a href="index.html">back</a>
