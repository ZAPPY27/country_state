<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                <%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CsController" method="post">

<select name="countryId">
<option value="${sessionScope.countryid}" selected>${sessionScope.countryname}</option>
<h:forEach items="${sessionScope.data}" var="i1">
<h:if test="${sessionScope.countryid != i1.id}">
<option value="${i1.id}">${i1.countryname}</option>
</h:if>
</h:forEach>
</select>
<br>
New State name<input type="text" value="${sessionScope.statename}" name="stateName">
<input type="hidden" name="flag" value="update">
<input type="hidden" name="stateid" value="${sessionScope.stateid}">
<input type="submit">


</form>
</body>
</html>