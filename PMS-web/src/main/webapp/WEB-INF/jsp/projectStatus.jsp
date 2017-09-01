<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProjectStatus</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body>
<fieldset>
	<legend>Project Status Form</legend>
	<center>
	<form:form method="POST" action="projectStatus.do" name="ProjectStatusForm"
		modelAttribute="ProjectStatus">
		<table width="60%" border="0" cellpadding="2" cellspacing="2" bgcolor="pink" align="center">
			<tr>
			<td colspan=2>
			<center><font size=4><b>Project Details</b></font></center>
			</td>
			</tr>
			
			
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
		<div>
		<table width="60%" cellpadding="2"cellspacing="2" bgcolor="black" align="center" border="0" >
		<tr style="background-color: Orange ;">
		
		<th>PROJECTNAME</th>
		<th>CLIENTNAME</th>
		<th>STARTDATE</th>
		<th>ENDDATE</th>
		<th>EDIT</th>
		<th>DELETE</th>
		</tr>
		<c:forEach items="${projects }" var="pro">
		<tr style="background-color: DeepPink  ;" ><%-- <td align="center" ><c:out value="${pro.id}"></c:out></td> --%>
			<td align="center"><c:out value= "${pro.pro_name}"></c:out> </td>
			<td align="center"><c:out value= "${pro.client_name }"></c:out>   </td>
			<td align="center"><c:out value= "${pro.start_date }"></c:out>   </td>
			<td align="center"><c:out value=  "${pro.end_date }"></c:out> </td>
			<td align="center">  <a href="empeditform.do?id=${pro.id}">Edit</a></td>
			<td align="center">  <a href="deleteproj.do?id=${pro.id}">Delete</a></td>
			</tr>
			
		</c:forEach>
		</table>
		</div>
	


</body>
</html>