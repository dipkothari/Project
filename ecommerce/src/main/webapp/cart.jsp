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

	<div>
		<form>
			<div>
				<ul style="padding-inline-start: 0;">
				<li class="left"><input
						type="submit" value="Back" formaction="Product" formmethod="post"></li>
					<li class="left" id="center"><%=session.getAttribute("username")%>
						&nbsp; Your Cart contains the Following list &nbsp;</li>
					
					<li style="float: right; border-left: 1px solid #bbb;"><input
						type="submit" value="Logout" formaction="Logout"></li>
				</ul>
			</div>
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
				<input type="submit" formaction="delete" value="Delete" style="border: 1px solid #aaa; border-radius: 20px; background: red;">
				</form>
				</td>	
				</tr>
				
			</c:forEach>
		</table>
	</div>
	<br>
	<div>
	<h4>Your total is $ ${total} &nbsp;
	<form method="post">
	<input type="submit" value="Checkout" formaction="checkout" style="border: 1px solid #aaa; border-radius: 20px; background: red;">
	</form>
	</h4>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>