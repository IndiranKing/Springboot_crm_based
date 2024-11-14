<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %> 
   
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h2{color:#69C10C}
h3{color:#2E65DA}
label {
  color: black;
  padding: 8px;
  font-family: Arial;
}
.warning {background-color: #ff9800;} /* Orange */
</style>
<meta charset="ISO-8859-1">
<title>Update Lead </title>
</head>
<body >
<center>
<h2>Update Lead</h2>
<hr>
<form action = "updateonelead" method="post">

<pre>
 <input type="hidden" name="id"  value="${lead.id}"/>
<label>First Name : </label><input type="text" name="fname"  value="${lead.fname}"/>

<label>Last Name  : </label><input type="text" name="lname" value="${lead.lname}"/>

<label>Email      :  </label><input type="text" name="email" value="${lead.email}"/>

<label>Mobile     : </label><input type="text" name="mobile" value="${lead.mobile}"/>

     <input type="submit" value="UPDATE" >
</pre>
</form>
</center>
</body>
</html>
