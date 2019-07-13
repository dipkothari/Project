<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.cart.model.cartModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style/cart.css">
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
	<form class="form-inline"> <button class="btn btn-secondary ml-3 my-2 my-sm-0" type="submit" formaction="Product" formmethod="post">Back</button>
	</form>
  <h4 class="navbar-brand form-text pl-3"><%=session.getAttribute("username")%>&nbsp; Your Cart contains the Following list &nbsp;</h4>
  <form class="form-inline">
 <button class="btn btn-outline-danger ml-3 my-2 my-sm-0" type="submit" formaction="Logout">Logout</button>
  </form>
</nav>

	
		</form>
	</div>

	<div >
		<table class="table table-dark">
			<tr>
				<th scope="col">No.</th>
				<th scope="col">Product Name</th>
				<th scope="col">Quantity</th>
				<th scope="col">Price (in $)</th>
				<th scope="col"> Remove </th>
			</tr>
			
			<c:set var="total" value="${0}"/>
			<c:forEach items="${cart}" var="a">
				<tr>
								<td>${a.productid}</td>
								<td>${a.productname}</td>
								<td>${a.productquantity}</td>
								<td>${a.productprice}</td>
				
					<c:set var="total" value="${total + a.productprice}" />	
					
				<td><form method="post">
				<input type="hidden" name="productid" value="${a.productid}">
				<button type="submit" formaction="delete" class="btn btn-danger"">Delete</button>
				</form>
				</td>	
				</tr>
				
			</c:forEach>
		</table>
	</div>
	<br>
	<div class="container ml-3 my-2 my-sm-0"><div class="row">
	<div class="col"><h4>Your total is $ ${total} &nbsp;</h4> </div>
	<div class="col"><form method="post">
	<button type="submit" formaction="checkout" class="btn btn-success" >Checkout</button>
	</form>
	</div>
	
	</div>
	</div>
	<div>
<h3 class="h4">	${insufficient}</h3>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>