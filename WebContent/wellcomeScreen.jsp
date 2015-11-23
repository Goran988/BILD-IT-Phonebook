<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bootstrap/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<title>Wellcome</title>
</head>
<body>
	<div class="wellcome">
		<p id="loged">
			Loged in as:
			<c:out value="${user.username }" />
		</p>
		<h1>Wellcome to online Phonebook</h1>
		<br />

		<h3>Do you want to:</h3>
	</div>
	<div class="wellcomeForm">

		<c:if test="${user.username!='Guest' }">
			<form method="post" action="PhonebookServlet">
				<button type="submit" class="btn btn-primary" name="action"
					value="Add">Add user</button>
				<button type="submit" class="btn btn-primary" name="action"
					value="Search">Search user</button>
				<button type="submit" class="btn  btn-primary" name="action"
					value="Edit">Edit user</button>
				<button type="submit" class="btn  btn-primary" name="action"
					value="Delete">Delete user</button>
				<button type="submit" class="btn btn-danger" name="action"
					value="Logout">Log out</button>
			</form>
		</c:if>
		<c:if test="${user.username=='Guest'}">
			<form method="post" action="PhonebookServlet">
				<button type="submit" class="btn btn-primary" name="action"
					value="Search">Search user</button>
				<button type="submit" class="btn btn-danger" name="action"
					value="Logout">Log out</button>
			</form>
		</c:if>

	</div>
</body>
</html>