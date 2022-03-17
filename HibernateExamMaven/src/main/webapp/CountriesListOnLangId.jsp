<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="counter" value="1"/>
<c:forEach var="country" items="${countriesList}">
    <c:out value="${country}"/><br>
    <c:set var="counter" value="${counter+1}"/>
    </c:forEach>

</body>
</html>