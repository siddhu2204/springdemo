<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer-Master</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer Master Details</h2>
		</div>
	</div>

	<div id="container">

		<form:form action="saveCustomer" modelAttribute="AddCustomer"
			method="POST">

			<form:hidden path="id"/>
			<table>

				<tbody>

					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>

					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>

					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="Submit" value="SAVE"></td>
					</tr>
				</tbody>

			</table>


		</form:form>

		<a href="${pageContext.request.contextPath}/customer/list" />
		<h6>Back</h6>
		
	</div>
</body>
</html>