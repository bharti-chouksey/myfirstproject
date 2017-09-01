<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
<a href="?lang=en">English</a> | <a href="?lang=hi">Hindi</a>
<h1><label><s:message code="label.title"></s:message></label></h1><br>
 
<form:form method="POST" action="showLogin.do" modelAttribute="Registration">
<table width="40%" border="0" cellpadding="2" cellspacing="2" bgcolor="pink" align="center">
<tr>
			<td colspan=2>
			<center><font size=4><b>Login Form</b></font></center>
			</td>
			</tr>
			
<tr>
<td align="center" colspan="1" style="padding-left: 20%">
Email:<form:input path="email" id="email" size="30" />
<form:errors  path="email" cssClass="error"></form:errors>
</td>
</tr>
<tr>
<td align="center" colspan="1" style="padding-left: 16%">
Password:  <form:password path="password" id="password" size="30"/>
 <form:errors path="password" cssClass="error"></form:errors>
</td>
</tr>
<tr>
<td  colspan="2" align="center" style="padding-left: 15%"><input type="submit" value="Submit">
</td>
<td>
<a href="registration.do">registration</a>
</td>
</tr>
</table>
</form:form>
</body>
</html>