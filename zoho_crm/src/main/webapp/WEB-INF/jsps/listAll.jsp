<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listAll</title>
</head>
<body>
<center>
<h2>ListAll Lead Data </h2>
<hr>
<br>
<table border="1">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Delete</th>
<th>Update</th>
</tr>
<c:forEach var="leads" items="${leads}">
<tr>
<td>${leads.fname}</td>
<td>${leads.lname}</td>
<td>${leads.email}</td>
<td>${leads.mobile}</td>
<td> <a href="deletelead?id=${leads.id}">delete</a>
<td> <a href="updatelead?id=${leads.id}">update</a>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>