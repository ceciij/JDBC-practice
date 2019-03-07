<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">

<body>

	<h2>Read Employee</h2>

	<form id="frmReadGeneral" action="ReadGeneralServlet" method="POST">
		<p>
		<input type="submit" value="Full Search">
		</p>
	</form>


	<form id="frmReadIndividual" action="ReadIndividualServlet"
		method="POST">
		<p>
			<label for="txtidEmpleado">Write the employee ID: </label> 
			<input type="text" id="txtidEmpleado" name="txtidEmpleado" required oninvalid="this.setCustomValidity('Llena el campo, no seas flojooo!!')">
		</p>
		<p>
			<input type="submit" value="Search Employee">
		</p>
	</form>


		<a href="index.jsp">Regresar</a>


	<script src="script/script.js"></script>
<script src="script/jquery-3.3.1.min.js"></script>
<script src="script/bootstrap.min.js"></script>
</body>
</html>