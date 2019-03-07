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

<h2> Delete Employee </h2>

	<form action="DeleteEmployeeServlet" method="POST">
		<div class="form-group row">
			<label class="col-sm-3 col-form-label" for="txtIdEmpleado">
				Id Empleado</label>
			<div class="col-sm-4">
				<input type="text" id="txtIdEmpleado" name="txtIdEmpleado" class="form-control">
			</div>
		</div>

		<p>
			<input type="submit" value="Delete Employee">
		</p>
	</form>


	<ul>
	<li><a href="index.jsp">Regresar</a></li>
	
</ul>

<script src="script/script.js"></script>
<script src="script/jquery-3.3.1.min.js"></script>
<script src="script/bootstrap.min.js"></script>
</body>
</html>