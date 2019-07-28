	<%@page import="com.product.model.productModel"%>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style/product.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-Cache,no-store,must-revalidate");

		if (session.getAttribute("username") == null) {

			response.sendRedirect("login.jsp");

		}
	%>

		
		<nav class="navbar navbar-light bg-light justify-content-between pb-0 pt-0">
  <h4 class="navbar-brand form-text pl-3">WELCOME &nbsp; <%= session.getAttribute("username").toString().toUpperCase() %></h4>
  <form class="form-inline">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="cart" formaction="cart" formmethod="post">cart</button>
 <button class="btn btn-outline-danger ml-3 my-2 my-sm-0" type="submit" formaction="Logout">Logout</button>
  </form>
</nav>
	<div>	
	<table class="table table-dark">
	<tr>
	<th scope="col">No.</th>
	<th scope="col">Product Name</th>
	<th scope="col">Price (in $)</th>
	<th scope="col">Quantity left</th>
	<th scope="col"> Select you quantity</th>
	
	</tr>
	<c:forEach items="${product}" var="a">
	
	<tr>
	
	<td>${a.productid}</td>
	
	<td>${a.productname}</td>
	
	<td>${a.productprice}</td>
	
	<td>${a.productquantity}</td>
	
	<td>
		<form action="addServlet" method="post">
		<input type="hidden" name="productid" value="${a.productid}">
		<input type="hidden" name="productname" value="${a.productname}">
		<input type="hidden" name="productprice" value="${a.productprice}">
		<div class="input-group">
		<input type="number" min="1" max="${a.productquantity}" name="productquantity" class="form-control mr-sm-2">&nbsp;
		<div class="input-group-append">
		<button type="submit" class="btn btn-outline-light"> addcart </button>
		</div>
		</div>
		</form>
	</td>
	
	</tr>
	</c:forEach>
	
	</table>
	</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>