package com.practica11JDBC.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practica11JDBC.model.Empleado;


@WebServlet("/ObtainRecordServlet")
public class ObtainRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html charset=\"UTF-8\"");
		PrintWriter salida= response.getWriter();
		
		int IdEmpleado=Integer.parseInt(request.getParameter("txtBuscarEmpleado"));
		
		// salida.println("Hola");
		Properties props = new Properties();
		InputStream input = null;
		
		input=getClass().getClassLoader().getResourceAsStream("config.properties");
		
		props.load(input);
		
		String miDriver = props.getProperty("miControlador");
		String miUrlServidor = props.getProperty("urlServidor");
		String miUsuario = props.getProperty("miUsusario_");
		String miPassword = props.getProperty("miPassword_");
		
		//Abrimos archivo sql.properites
		
		input=getClass().getClassLoader().getResourceAsStream("sql.properties");
		props.load(input);
		
		//obtenemos sentencias del archivo sql.properties
		String sentenciaSQL = props.getProperty("SQLBuscarEmpleado");
		
		//verificamos que las salidas sean correctas
		
		// salida.println(miDriver +miUrlServidor +miUsuario + miPassword + sentenciaSQL);
		System.out.println(miUsuario);
		
		
		Connection conn=null;
		PreparedStatement pstmnt = null;
		// ResultSet es una hoja de calculo (vacia)
		ResultSet datos= null;
		
		
		try 
		{	
			Class.forName(miDriver).getDeclaredConstructor().newInstance();
			conn= DriverManager.getConnection(miUrlServidor, miUsuario, miPassword);
			pstmnt= conn.prepareStatement(sentenciaSQL);
			
			pstmnt.setInt(1, IdEmpleado);
			datos = pstmnt.executeQuery();
			Empleado miEmpleado = new Empleado();
			boolean isEncontrado = false; 
			while (datos.next())
			{
				miEmpleado.setIdEmpleado(datos.getInt("idEmpleado"));
				miEmpleado.setNombreEmpleado(datos.getString("nombreEmpleado"));
				miEmpleado.setApellidoEmpleado(datos.getString("apellidoEmpleado"));
				miEmpleado.setFechaNacimientoEmpleado(datos.getString("fechaNacimiento"));
				miEmpleado.setSalario(datos.getDouble("salario"));
				
				//salida.println(miEmpleado.toString());
				isEncontrado = true;
			}
			if(isEncontrado==false)
			{
				salida.println("Registro no encontrado");
				RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
				rd.include(request, response);
			}
			else 
			{
				request.setAttribute("miEmpleaditu", miEmpleado);
				RequestDispatcher rd = request.getRequestDispatcher("/updateEmployee.jsp");
				rd.forward(request, response);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			try
			{
				conn.close();
				pstmnt.close();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		salida.println("<a href= 'index.jsp'> Inicio </a>");
		salida.close();
		
	}

}
