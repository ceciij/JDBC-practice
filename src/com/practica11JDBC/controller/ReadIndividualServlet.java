package com.practica11JDBC.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReadIndividualServlet")
public class ReadIndividualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
  
    public ReadIndividualServlet() 
    {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int idEmpleado = Integer.parseInt(request.getParameter("txtidEmpleado"));
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		
		// Paso 1 declarar credenciales
		String miUrl = "jdbc:mysql://localhost:3306/practica1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String miUsuario = "root";
		String miPassword = "root";
		boolean isEncontrado= false;
		
		
		//Paso 2. Declarar onjetos de conexion
		Connection conn= null;
		Statement stmnt=null;
		ResultSet datos = null;
		String sentencialSQL = " select * from empleados where idEmpleado="+ idEmpleado;
		
		try
		{
			// Paso 3. Instancial la clase del connector
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			
			// Paso 4. Abrir la coneccion
			conn = DriverManager.getConnection(miUrl, miUsuario, miPassword);
						
			// Paso 5 . Crear el statement
			stmnt = conn.createStatement();
						
			// Paso 6. Ejecutar el Query
			datos= stmnt.executeQuery(sentencialSQL);
			
			// Paso 7. Mostrar la informacion
			while (datos.next())
			{
				isEncontrado=true;
				salida.println("ID Empleado: "+ datos.getInt("idEmpleado"));
				salida.println("<br/>");
				salida.println("Nombre Empleado: "+ datos.getString("nombreEmpleado"));
				salida.println("<br/>");
				salida.println("Apellido Empleado: "+ datos.getString("apellidoEmpleado"));
				salida.println("<br/>");
				salida.println("Fecha Nacimiento: "+ datos.getDate("fechaNacimiento"));
				salida.println("<br/>");
				salida.println("Salario: "+ datos.getDouble("salario"));
				
				salida.println("<br/>");
				salida.println("<br/>");
			}
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
				datos.close();
				stmnt.close();
				conn.close();
			}
			catch (Exception ex2)
			{
				ex2.printStackTrace();
			}
		}
		if (isEncontrado==false)
		{
			salida.println("Registro no encontrado");
		}
		
		salida.println("<a href='read.jsp'> Regresar</a>");
		salida.close();	
	}
}
