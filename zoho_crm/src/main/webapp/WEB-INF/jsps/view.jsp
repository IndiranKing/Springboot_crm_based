<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %> 
   
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h2{color:#69C10C}
h3{color:#2E65DA}
</style>
<meta charset="ISO-8859-1">
<title>Lead view</title>
</head>
<body >
<center>
<h2>Zoho Lead Form</h2>
<form action = "savelead" method="post">
<hr>
<pre>

<h3>First Name : <input type="text" name="fname" /> </h3>
<h3>Last Name  : <input type="text" name="lname" /></h3>
<h3>Email      : <input type="text" name="email" /></h3>
<h3>Mobile     : <input type="text" name="mobile" /></h3>

	<input type="submit" value="SAVE">
</pre>
</form>
</center>
</body>
</html>
