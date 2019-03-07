package com.practica11JDBC.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practica11JDBC.model.Empleado;


@WebServlet("/CreateEmployee2Servlet")
public class CreateEmployee2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html charset=\"UTF-8\"");
	PrintWriter salida= response.getWriter();
	
	Empleado miEmpleado = new Empleado();
	
	miEmpleado.setIdEmpleado(Integer.parseInt(request.getParameter("txtIdEmpleado")));
	miEmpleado.setNombreEmpleado(request.getParameter("txtNombreEmpleado"));
	miEmpleado.setApellidoEmpleado(request.getParameter("txtApellidoEmpleado"));
	miEmpleado.setFechaNacimientoEmpleado(request.getParameter("txtFechaNacimiento"));
	miEmpleado.setSalario(Double.parseDouble(request.getParameter("txtSalario")));

	salida.println("Valores del objeto: " + miEmpleado.toString());
	
	// Paso 1 declarar credenciales
	String miUrl = "jdbc:mysql://localhost:3306/practica1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String miUsuario = "root";
	String miPassword = "root";
	int nRegistros=0;
	
	//Paso 2. Declarar objetos de conexion
	Connection conn= null;
	PreparedStatement pstmnt=null;
	String sentenciaSQL="insert into empleados (idEmpleado, nombreEmpleado, apellidoEmpleado, fechaNacimiento, salario)"
			+ "values (?, ?, ?, ?, ?)";
	
	try
	{
	//Paso 3. Instanciar la clase del connector 
	//Paso 4. Abrir la conexion 
	//Paso 5 . Crear el statement  
	//Paso 6. Ejecutar el Query
	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
	conn = DriverManager.getConnection(miUrl, miUsuario, miPassword);
	pstmnt = conn.prepareStatement(sentenciaSQL);
	
	pstmnt.setInt(1, miEmpleado.getIdEmpleado());
	pstmnt.setString(2, miEmpleado.getNombreEmpleado());
	pstmnt.setString(3, miEmpleado.getApellidoEmpleado());
	pstmnt.setString(4, miEmpleado.getFechaNacimientoEmpleado());
	pstmnt.setDouble(5, miEmpleado.getSalario());
	
	nRegistros= pstmnt.executeUpdate();
	
	if (nRegistros > 0)
	{
		salida.println("Registro anadido con exito");
	}
	
	// Paso 7. Mostrar la informacion
	}
	catch (Exception ex)
	{
	//El error es un overflow de pila, NO de cola.
	ex.printStackTrace();
	}
	finally
	{
	try
	{
		pstmnt.close();
		conn.close();
	}
	catch (Exception ex2)
	{
		ex2.printStackTrace();
	}
	}
	salida.println("<a href='read.jsp'> Regresar</a>");
	salida.close();
	
		}
	}
