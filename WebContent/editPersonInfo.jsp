<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit info</title>
<link href="bootstrap/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
<body>
<p id="loged">
			Loged in as:
			<c:out value="${user.username }" />
		</p>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<form id="editForm" method="post" action="EditPerson">
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
						<tr class="specialTR">
							<td><input name="idNumber" value="${person.idNumber }"  /></td>
							<td><input name="firstName" value="${person.firstName }" />
							</td>
							<td><input name="lastName" value="${person.lastName }" /></td>
							<td><input name="phoneNumber" value="${person.phoneNumber }" /></td>
							<td><input name="address" value="${person.address }" /></td>
							<td><input name="email" value="${person.email }" /></td>
							<td><input name="dateOfBirth" value="${person.dateOfBirth }" /></td>
							<td><input name="gender" value="${person.gender }" /></td>
						</tr>

					</table>
					<button type="submit" class="btn btn-primary" name="action">Edit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>