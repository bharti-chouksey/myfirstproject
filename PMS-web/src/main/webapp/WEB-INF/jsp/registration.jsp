<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registraion</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<form:form method="POST" action="registration.do" name="RegistrationForm"
		modelAttribute="Registration">
		<table width="60%" border="0" cellpadding="2" cellspacing="2" bgcolor="pink" align="center">
			<tr>
			<td colspan=2>
			<center><font size=4><b>Registration Form</b></font></center>
			</td>
			</tr>
			
			
			<tr>
				<td  align="center" >First Name:</td>
				<td align="center"><form:input path="fname" id="fname"  /> <form:errors
						path="fname" cssClass="error"></form:errors>
				</td>

			</tr>
			<tr>
			<td  align="center" >Last Name:</td>
				<td align="center" ><form:input path="lname" id="lname" />
				 <form:errors path="lname" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
			<td  align="center" >Email Id:</td>
				<td  align="center"> <form:input path="email" id="email"  /> <form:errors
						path="email" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
			<td  align="center">Password:</td>
				<td  align="center"><form:password path="password" id="password" /> <form:errors
						path="password" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
			<td  align="center">Address:</td>
				<td align="center" > <form:input path="user[0].address" id="address"  /> 
				<form:errors path="user[0].address" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
			<td  align="center" >City:</td>
				<td align="center" > <form:input path="user[0].city" id="city"  /> 
				<form:errors path="user[0].city" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td colspan="2"><center><input type="submit" value="Submit"></center></td>
				<td><a href="login.do">Login</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>