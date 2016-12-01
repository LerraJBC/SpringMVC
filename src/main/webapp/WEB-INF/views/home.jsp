<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Manager Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Student List</h1>
	        <h3><a href="newStudent">New Student</a></h3>
	        <h1>Search Student by Name:</h1>
	        <form action="searchStudentbyName" method="post">
            <input type="text" name="searchValue" />
            <input type="submit" value="Search" />
        </form>
        <br /><br />
        <form action="sortStudentList" method="post">
            Sort by:
            <select name="sortValue">
                <option value="id">ID</option>
                <option value="firstname">First Name</option>
            </select>
            <input type="submit" value="Submit" />
        </form>
        
	        <table border="1">
	        	<th>ID</th>
	        	<th>First Name</th>
	        	<th>Last Name</th>
	        	<th>Age</th>
	        	<th>Gender</th>
	        	<th>Contact</th>
	        	<th>Address</th>
	        	<th>Action</th>
	        	
				<c:forEach var="Students" items="${listStudents}" varStatus="status">
	        	<tr>
	        		<td>${Students.id}</td>
					<td>${Students.firstname}</td>
					<td>${Students.lastname}</td>
					<td>${Students.age}</td>
					<td>${Students.gender}</td>
					<td>${Students.contact}</td>
					<td>${Students.address}</td>
					<td>
						<a href="editStudent?id=${Students.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteStudent?id=${Students.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	       	
			</table>
			
			<h3></h3><a href="./">View All Student List</a></h3>
    	</div>
    </body>
</html>
