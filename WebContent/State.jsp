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
	<select name="countryname">
<h:forEach items="${sessionScope.data}" var="i1">


    <option value="${i1.id }">${i1.countryname}</option>

  
  </h:forEach>
  	</select>
  	<br>
  	State name:<input type="text" name="sn">
  	<input type="hidden" name="flag" value="adds">
  	<input type="submit" value="Add">
</form>
</body>
</html>