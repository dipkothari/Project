<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style/login.css">

</head>
<body>
	
	
	<div class="transparent">
	<form action="Login" method="post">
	
		<table >
		<tr>
		<th><h6><font size="4">Name : </font></h6></th>
		<td><h6><input type="text" placeholder="Enter your name" name="uname" value=""/></h6></td>
		</tr>
		<tr>
		
		<th><h6><font size="4">Password : </font></h6></th>
		<td><h6><input type="password" placeholder="Enter your password" name="pass" value=""/></h6></td>
		</tr>
		
		<tr>
		
		<td colspan="2" align="center"><input type="submit" value="Submit" ></td>
		
		</tr>
		<tr></tr>
		</table>
	
	</form>
	</div>
	
</body>
</html>