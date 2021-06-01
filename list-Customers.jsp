<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<center>
				<h2>Customer Details</h2>
			</center>
		</div>
	</div>

	<div id="container">

		<div id="content">



			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>E-Mail</th>
					<th>Action</th>
				</tr>




				<c:forEach var="custDetails" items="${customers}">

					<c:url var="updateLink" value="/customer/showUpdateForm">
						<c:param name="customerId" value="${custDetails.id}"></c:param>

					</c:url>

					<c:url var="deletelink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${custDetails.id}"></c:param>
					</c:url>

					<tr>
						<td>${custDetails.firstName}</td>
						<td>${custDetails.lastName}</td>
						<td>${custDetails.email}</td>
						<td><a href="${updateLink}">update</a>| <a
							href="${deletelink}"
							onclick="if(!(confirm('Are you sure want to delete?')))return false">Delete</a></td>
					</tr>


				</c:forEach>


			</table>


			<input type="button" value="AddCustomer"
				onclick="window.location.href='showAddForm'; return false;" />

		</div>
	</div>
</body>
</html>