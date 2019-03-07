<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">


</head>
<body>

<h2> Create Employee with Props (config.properties)</h2>

		<form action="CreateEmployee4Servlet" method="POST">
			<div  class="form-group row">
			<label class="col-sm-3 col-form-label" for="txtIdEmpleado">Id de empleado: </label>
			<div class="col-sm-4">
		
				<input type="text" class="form-control" id="txtIdEmpleado" name="txtIdEmpleado">
			</div>
			</div>
			
			<div  class="form-group row">
			<label class="col-sm-3 col-form-label" for="txtNombreEmpleado">Nombre de empleado: </label>
			
			<div class="col-sm-4">
				<input type="text" id="txtNombreEmpleado" name="txtNombreEmpleado" class="form-control">
			</div>
			</div>
			
		 	<div  class="form-group row">
			<label class="col-sm-3 col-form-label" for="txtApellidoEmpleado">Apellido de empleado: </label>
			<div class="col-sm-4">
				<input type="text" id="txtApellidoEmpleado" name="txtApellidoEmpleado" class="form-control">
			</div>
			</div>
			
			<div  class="form-group row">
			<label class="col-sm-3 col-form-label" for="txtFechaNacimiento">Fecha de Nacimiento: </label>
			<div class="col-sm-4">
				<input type="text" id="txtFechaNacimiento" name="txtFechaNacimiento" class="form-control" placeholder="yyyy-mm-dd">
			</div>
			</div>
			
			<div  class="form-group row">
			<label class="col-sm-3 col-form-label" for="txtSalario">Salario: </label>
			<div class="col-sm-4">
				<input type="text" id="txtSalario" name="txtSalario" class="form-control">
			</div>
			</div>
			
			<div class="col-sm-7">
			<p>
				<input type="submit" value="Create Employee">
			</p>
			</div>
		</form>

	<ul>
	<li><a href="index.jsp">Regresar</a></li>
	</ul>

<script src="script/script.js"></script>
<script src="script/jquery-3.3.1.min.js"></script>
<script src="script/bootstrap.min.js"></script>

</body>
</html>