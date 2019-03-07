package com.practica11JDBC.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateEmployee3Servlet")
public class CreateEmployee3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html charset=\"UTF-8\"");
		PrintWriter salida= response.getWriter();
		
		//Declarar variables
		String urlServidor="jdbc:mysql://localhost:3306/practica1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String miUsuario="root";
		String miPassword = "root";
		
		//Decalarar objetos
		Connection conn=null;
		PreparedStatement pstmnt=null;
		String sentenciaSQL= "insert into empleados (idEmpleado, nombreEmpleado, apellidoEmpleado, fechaNacimiento, salario) values(?,?,?,?,?)";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			conn= DriverManager.getConnection(urlServidor, miUsuario, miPassword);
			pstmnt= conn.prepareStatement(sentenciaSQL);
			
			conn.setAutoCommit(false);
			
			pstmnt.setInt(1, 226);
			pstmnt.setString(2, "nombre4");
			pstmnt.setString(3, "apellido4");
			pstmnt.setString(4, "1999-10-05");
			pstmnt.setDouble(5, 1000);
			
			pstmnt.executeUpdate();
			
			pstmnt.setInt(1, 227);
			pstmnt.setString(2, "nombre5");
			pstmnt.setString(3, "apellido5");
			pstmnt.setString(4, "2000-11-05");
			pstmnt.setDouble(5, 1000);
			
			pstmnt.executeUpdate();
			
			pstmnt.setInt(1, 111);
			pstmnt.setString(2, "nombre3");
			pstmnt.setString(3, "apellido3");
			pstmnt.setString(4, "1956-02-04");
			pstmnt.setDouble(5, 1000);
			
			pstmnt.executeUpdate();
			
			conn.commit();
			
		}
		catch (Exception e)
		{
				try 
				{
					conn.rollback();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmnt.close();
				conn.close();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		salida.close();
	}

}
