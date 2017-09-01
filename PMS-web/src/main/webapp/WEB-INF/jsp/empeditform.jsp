<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
<fieldset>
	<legend>Project Status Form</legend>
	<center>
	<form:form method="POST" action="empeditform.do" name="ProjectStatusForm" modelAttribute="empeditform">
		<table width="60%" border="0" cellpadding="2" cellspacing="2" bgcolor="pink" align="center">
			<tr>
			<td colspan=2>
			<center><font size=4><b>Project Details</b></font></center>
			</td>
			</tr>
			<tr>
				<td>Project Id:</td>
				<td><form:input path="id" id="id"  size="30" readonly="true" /> <form:errors
						path="id" cssClass="error"></form:errors>
				</td>
			
			
			<tr>
				<td>Project Name:</td>
				<td><form:input path="pro_name" id="pro_name"  size="30" /> <form:errors
						path="pro_name" cssClass="error"></form:errors>
				</td>

			</tr>
			<tr>
			<td>Client Name:</td>
				<td><form:input path="client_name" id="client_name" size="30" />
				 <form:errors path="client_name" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
			<td>Start Date:</td>
				<td> <form:input path="start_date" id="start_date" size="30" /> <form:errors
						path="start_date" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
			<td>End Date:</td>
				<td><form:input path="end_date" id="end_date" size="30"  />
				 <form:errors path="end_date" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td colspan="2"><center><input type="submit" value="Submit"></center></td>
			</tr>
			
		</table>
		
	</form:form>
	</center>
	</fieldset>

</body>
</html>