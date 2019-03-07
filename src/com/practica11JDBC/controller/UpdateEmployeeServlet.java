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

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html charset=\"UTF-8\"");
		PrintWriter salida = response.getWriter();
		
		int nRegistros=0;
		int idEmpleado = Integer.parseInt(request.getParameter("txtIdEmpleado"));
		String nombreEmpleado = request.getParameter("txtNombreEmpleado");
		String apellidoEmpleado = request.getParameter("txtApellidoEmpleado");
		String fechaNacimientoEmpleado = request.getParameter("txtFechaNacimiento");
		double salarioEmpleado = Double.parseDouble(request.getParameter("txtSalario"));

		
		// Paso 1 declarar credenciales
		String miUrl = "jdbc:mysql://localhost:3306/practica1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String miUsuario = "root";
		String miPassword = "root";
		
		
		//Paso 2. Declarar objetos de conexion
		Connection conn= null;
		Statement stmnt=null;
		String SQLNombre = "update empleados set nombreEmpleado='"+ apellidoEmpleado + "' where idEmpleado=" + idEmpleado;
		String SQLApellido = "update empleados set apellidoEmpleado='"+ apellidoEmpleado + "' where idEmpleado=" + idEmpleado;
		String SQLFechaNacimiento = "update empleados set fechaNacimiento='"+ fechaNacimientoEmpleado + "' where idEmpleado=" + idEmpleado;
		String SQLSalario = "update empleados set salario='"+ salarioEmpleado + "' where idEmpleado=" + idEmpleado;
		
		try
		{
			// Paso 3. Instanciar la clase del connector
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			
			// Paso 4. Abrir la conexion
			conn = DriverManager.getConnection(miUrl, miUsuario, miPassword);
						
			// Paso 5 . Crear el statement
			stmnt = conn.createStatement();
						
			// Paso 6. Ejecutar el Query
			nRegistros=stmnt.executeUpdate(SQLNombre);
			nRegistros=stmnt.executeUpdate(SQLApellido);
			nRegistros=stmnt.executeUpdate(SQLFechaNacimiento);
			nRegistros=stmnt.executeUpdate(SQLSalario);
			
			// Paso 7. Mostrar la informacion
			
			if(nRegistros>0)
			{
				salida.println("Cambios realizados con exito!!");
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
				stmnt.close();
				conn.close();
			}
			catch (Exception ex2)
			{
				ex2.printStackTrace();
			}
		}
		
		salida.println("<a href='update.jsp'> Regresar</a>");
		salida.close();	
	}
	

}
