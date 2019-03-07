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

<h2> Update Employee </h2>

<form  action="ObtainRecordServlet" method="post">

<label for="txtBuscarEmpleado"> Buscar empleado</label>
<input type="text" name="txtBuscarEmpleado" id="txtBuscarEmpleado" >
<input type="submit" value="Search">
</form>

<ul>
	<li><a href="index.jsp">Regresar</a></li>
	
</ul>

<script src="script/script.js"></script>
<script src="script/jquery-3.3.1.min.js"></script>
<script src="script/bootstrap.min.js"></script>
</body>
</html>