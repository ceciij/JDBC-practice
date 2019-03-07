package com.practica11JDBC.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practica11JDBC.model.Empleado;


@WebServlet("/CreateEmployee4Servlet")
public class CreateEmployee4Servlet extends HttpServlet {
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
		
		
		
		//salida.println("Valores del objeto: " + miEmpleado.toString()); 
		
		
		Properties props = new Properties();
		InputStream input = null;
		input= getClass().getClassLoader().getResourceAsStream("config.properties");
		props.load(input);
		
		String propiedadUrlServidor=props.getProperty("urlServidor");
		String propiedadMiUsuario=props.getProperty("miUsusario_");
		String propiedadMiPassword=props.getProperty("miPassword_");
		String propiedadMiDriver=props.getProperty("miControlador");
		String propiedadAltaEmpleado=props.getProperty("SQLInsertarEmpleado");
		
		Connection conn = null;
		PreparedStatement pstmnt = null;
		int nRegistros=0;
		
		
		try
		{
			Class.forName(propiedadMiDriver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(propiedadUrlServidor, propiedadMiUsuario, propiedadMiPassword);
			
			pstmnt= conn.prepareStatement(propiedadAltaEmpleado);
			
			pstmnt.setInt(1, miEmpleado.getIdEmpleado());
			pstmnt.setString(2, miEmpleado.getNombreEmpleado());
			pstmnt.setString(3, miEmpleado.getApellidoEmpleado());
			pstmnt.setString(4, miEmpleado.getFechaNacimientoEmpleado());
			pstmnt.setDouble(5, miEmpleado.getSalario());
			
			nRegistros=pstmnt.executeUpdate();
			if (nRegistros>0)
			{
				salida.println("<br/> Registro Guardado en BD!!");
			}
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmnt.close();
				conn.close();
				
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
			
			
		}
		
		salida.close();
		
	}

}
