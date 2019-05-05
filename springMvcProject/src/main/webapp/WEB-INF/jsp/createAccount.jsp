<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
	.error{
	color:red;
	font-size: 15px
	}
</style>
<title>Create an Account</title>
</head>
<body>
	<h1>Enter Account Details</h1>
	<form:form modelAttribute="aNewAccount">
		<table>
			<tr>
				<td>First Name: <form:input type="text" name="firstName"
						path="firstName" />
				<form:errors path="firstName" cssClass="error"/>		
				</td>
			</tr>
			<tr>
				<td>Last Name: <form:input type="text" name="lastName"
						path="lastName" />
				<form:errors path="lastName" cssClass="error"/>		
						</td>
			</tr>
			<tr>
				<td>Address: <form:input type="text" name="address"
						path="address" />
							<form:errors path="address" cssClass="error"/>		
						</td>
			</tr>
			<tr>
				<td>Email: <form:input type="text" name="email" path="email" />
				<form:errors path="email" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="Create"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>