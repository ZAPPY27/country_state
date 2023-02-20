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
<table border="1px">
<h:forEach items="${sessionScope.data}" var="i1">
<tr>
<td>${i1.id }</td>
<td>${i1.statename }</td>
<td>${i1.v.countryname }</td>
<td><a href="CsController?id=${i1.id}&statename=${i1.statename }&countryname=${i1.v.countryname }&countryid=${i1.v.id }&flag=searchc2"><input type="button" value="edit"></a></td>

</tr>
</h:forEach>
</table>

</body>
</html>