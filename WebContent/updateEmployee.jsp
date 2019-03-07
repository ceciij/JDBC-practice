<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.practica11JDBC.model.Empleado" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">

<body>

<h2> Update Employee Data </h2>
<div>
<%! Empleado miEmpleado = new Empleado(); %>
<% miEmpleado = (Empleado) request.getAttribute("miEmpleaditu"); %>

		<form action="UpdateEmployeeServlet" method="POST">
			<div  class="form-group row">
			<label for="txtIdEmpleado" class="col-sm-3 col-form-label" >Id de empleado: </label>
			
			<div class="col-sm-4">
				<input type="text" class="form-control" id="txtIdEmpleado" name="txtIdEmpleado" value="<%=miEmpleado.getIdEmpleado()%>">
			</div>
			</div>
			
			<div  class="form-group row">
			<label class="col-sm-3 col-form-label" for="txtNombreEmpleado">Nombre de empleado: </label>
			
			<div class="col-sm-4">
				<input type="text" id="txtNombreEmpleado" name="txtNombreEmpleado" class="form-control" value="<%=miEmpleado.getNombreEmpleado()%>">
			</div>
			</div>
			
		 	<div  class="form-group row">
			<label class="col-sm-3 col-form-label" for="txtApellidoEmpleado">Apellido de empleado: </label>
			<div class="col-sm-4">
				<input type="text" id="txtApellidoEmpleado" name="txtApellidoEmpleado" class="form-control" value="<%=miEmpleado.getApellidoEmpleado()%>">
			</div>
			</div>
			
			<div  class="form-group row">
			<label class="col-sm-3 col-form-label" for="txtFechaNacimiento">Fecha de Nacimiento: </label>
			<div class="col-sm-4">
				<input type="text" id="txtFechaNacimiento" name="txtFechaNacimiento" class="form-control" value="<%=miEmpleado.getFechaNacimientoEmpleado()%>" >
			</div>
			</div>
			
			<div  class="form-group row">
			<label class="col-sm-3 col-form-label" for="txtSalario">Salario: </label>
			<div class="col-sm-4">
				<input type="text" id="txtSalario" name="txtSalario" class="form-control" value="<%=miEmpleado.getSalario()%>" >
			</div>
			</div>
			
			<div class="col-sm-7">
			<p>
				<input type="submit" value="Update Employee">
			</p>
			</div>
		</form>
	</div>

	<ul>
	<li><a href="index.jsp">Regresar</a></li>
	</ul>

<script src="script/script.js"></script>
<script src="script/jquery-3.3.1.min.js"></script>
<script src="script/bootstrap.min.js"></script>

</body>
</html>