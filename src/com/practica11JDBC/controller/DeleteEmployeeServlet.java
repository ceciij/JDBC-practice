package com.practica11JDBC.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter salida= response.getWriter();
	String idEmpleado= request.getParameter("txtIdEmpleado");
	String miUrl = "jdbc:mysql://localhost:3306/practica1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String miUsuario = "root";
	String miPassword = "root";
	
	Connection conn=null;
	Statement stmnt=null;
	String sentenciaSQL="delete from empleados where idEmpleado=" + idEmpleado;
	int nRegistros=0;
	
	
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		conn = DriverManager.getConnection(miUrl, miUsuario, miPassword);
		stmnt = conn.createStatement();
		nRegistros=stmnt.executeUpdate(sentenciaSQL);
		
		
		if(nRegistros>0)
		{
			salida.println("Registro borrado con exito!!");
		}
		
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try {
			stmnt.close();
			conn.close();
			
		}
		catch (Exception ex)
		{
			ex.getStackTrace();
		}
	}
	
	salida.println("<a href='delete.jsp'> Regresar</a>");
	
	salida.close();
	}

}
