<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Student</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Student</h1>
		<form:form action="saveStudent" method="post" modelAttribute="student">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:input path="gender" /></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><form:input path="contact" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>