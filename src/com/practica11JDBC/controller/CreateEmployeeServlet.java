package com.practica11JDBC.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practica11JDBC.model.Empleado;


@WebServlet("/CreateEmployeeServlet")
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html charset=\"UTF-8\"");
		
		PrintWriter salida= response.getWriter();
		
		Empleado miEmpleado = new Empleado();
		
		miEmpleado.setIdEmpleado(Integer.parseInt(request.getParameter("txtIdEmpleado")));
		miEmpleado.setNombreEmpleado(request.getParameter("txtNombreEmpleado"));
		miEmpleado.setApellidoEmpleado(request.getParameter("txtApellidoEmpleado"));
		miEmpleado.setSalario(Double.parseDouble(request.getParameter("txtSalario")));
		miEmpleado.setFechaNacimientoEmpleado(request.getParameter("txtFechaNacimiento"));

		/*
		DateFormat formateador= new SimpleDateFormat("yyyy-MM-dd");
		
		String fechaNac=request.getParameter("txtFechaNacimiento");
		String fecha= formateador.format(fechaNac);
		
		try 
		{
			miEmpleado.setFechaNacimientoEmpleado(formateador.parse(fecha));
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		*/
		System.out.println(miEmpleado.toString());

		// Paso 1 declarar credenciales
				String miUrl = "jdbc:mysql://localhost:3306/practica1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String miUsuario = "root";
				String miPassword = "root";
				int nRegistros=0;
				
				
		//Paso 2. Declarar onjetos de conexion
			Connection conn= null;
			Statement stmnt=null;
			String sentenciaSQL="insert into empleados (idEmpleado, nombreEmpleado, apellidoEmpleado, fechaNacimiento, salario) "
					+ "values ("+miEmpleado.getIdEmpleado() + ", '"+ miEmpleado.getNombreEmpleado()+"' , '"+ miEmpleado.getApellidoEmpleado()+"' , '"+ miEmpleado.getFechaNacimientoEmpleado()+"' ,"+miEmpleado.getSalario()+")";
			
			
		try
		{
			// Paso 3. Instancial la clase del connector
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			
			// Paso 4. Abrir la coneccion
			conn = DriverManager.getConnection(miUrl, miUsuario, miPassword);
						
			// Paso 5 . Crear el statement
			stmnt = conn.createStatement();
						
			// Paso 6. Ejecutar el Query
		    nRegistros= stmnt.executeUpdate(sentenciaSQL);
		    
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
				stmnt.close();
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
