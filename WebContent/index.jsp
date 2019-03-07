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


<h2> CRUD JDBC</h2>
<p>Actions with employees table (MySQL): </p>


<p>What do you want to do? </p>
<ul>
	<li><a href="create.jsp">Create Employee</a></li>
	<li><a href="create2.jsp">Create Employee with prepared Statements</a></li>
	<li><a href="create3.jsp">Create Employee with Transactions</a></li>
	<li><a href="create4.jsp">Create Employee with Props(config.properties)</a></li>
	<li><a href="update.jsp">Update Employee</a></li>
	<li><a href="read.jsp">Read Employee</a></li>
	<li><a href="delete.jsp">Delete Employee</a></li>
	
				

</ul>

<script src="script/script.js"></script>
<script src="script/jquery-3.3.1.min.js"></script>
<script src="script/bootstrap.min.js"></script>

</body>
</html>