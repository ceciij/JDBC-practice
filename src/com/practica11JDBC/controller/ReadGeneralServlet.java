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


@WebServlet("/ReadGeneralServlet")
public class ReadGeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReadGeneralServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter salida = response.getWriter();
		response.setContentType("text/html");
		
		//Paso 1. Establecer las credenciales de acceso 
		//Connection String
		String miDireccionServidor = "jdbc:mysql://localhost:3306/practica1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String miUsuario = "root";
		String miPassword = "root";
		
		//Paso 2. Crear los objetos de conexion a la base de datos
		Connection conn = null;
		Statement stmnt= null;
		String sentenciaSql = "select * from empleados";
		ResultSet datos = null;
		
		try 
		{
			//Paso 3. Instanciamos el objeto de la clase connector
			//Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  version 8.09
			//version 8.11 en adelante
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(miDireccionServidor, miUsuario, miPassword);
			System.out.println("Conexion establecida!!");
			
			//Paso 4. Crear objeto statement, responsable de enviarle instrucciones al servidor de base de datos.
			stmnt = conn.createStatement();
			datos= stmnt.executeQuery(sentenciaSql);
			
			while (datos.next())
			{
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
		catch (Exception miExcepcioncita)
		{
			//El error es un overflow de pila, NO de cola.
			miExcepcioncita.printStackTrace();
		}
		
		finally
		{
			try
			{
				datos.close();
				stmnt.close();
				conn.close();
			}
			catch (Exception miExcepcioncita2)
			{
				miExcepcioncita2.printStackTrace();
			}
		}
		salida.println("<a href='read.jsp'> Regresar</a>");
		salida.close();
	}
}
