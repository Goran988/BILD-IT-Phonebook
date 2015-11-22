<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Deleted user</title>
</head>
<body>
	<p id="loged">
		Loged in as:
		<c:out value="${user.username }" />
	</p>


	<h3>Which user you want to delete(Enter id number):</h3>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<table class="table table-bordered">
					<tr>
						<td>Id number</td>
						<td>First name</td>
						<td>Last name</td>
						<td>Phone number</td>
						<td>Address</td>
						<td>Email</td>
						<td>Date of birth</td>
						<td>Gender</td>


						<c:forEach items="${allUsers }" var="person">
							<tr>
								<td><c:out value="${person.idNumber }" /></td>
								<td><c:out value="${person.firstName }" /></td>
								<td><c:out value="${person.lastName}" /></td>
								<td><c:out value="${person.phoneNumber}" /></td>
								<td><c:out value="${person.address}" /></td>
								<td><c:out value="${person.email}" /></td>
								<td><c:out value="${person.dateOfBirth}" /></td>
								<td><c:out value="${person.gender}" /></td>
							</tr>
						</c:forEach>
				</table>
				<form method="post" action="DeleteUser">
					Id number <br> <input name="idNumber">
					<button type="submit" class="btn btn-primary" name="submit">Delete</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>