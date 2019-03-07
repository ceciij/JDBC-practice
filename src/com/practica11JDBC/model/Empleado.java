package com.practica11JDBC.model;

import java.util.Date;

public class Empleado {
	
	private int idEmpleado;
	private String NombreEmpleado;
	private String ApellidoEmpleado;
	private String FechaNacimientoEmpleado;
	private double salario;
	
	public Empleado()
	{
		
	}
	
	public Empleado(int idEmpleado, String NombreEmpleado, String ApellidoEmpleado, String FechaNacimientoEmpleado, double salario)
	{
		setIdEmpleado(idEmpleado);
		setNombreEmpleado(NombreEmpleado);
		setApellidoEmpleado(ApellidoEmpleado);
		setFechaNacimientoEmpleado(FechaNacimientoEmpleado);
		setSalario(salario);
	}
	
	public int getIdEmpleado()
	{
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado)
	{
		this.idEmpleado=idEmpleado;
	}
	public String getNombreEmpleado()
	{
		return NombreEmpleado;
	}
	public void setNombreEmpleado(String NombreEmpleado)
	{
		this.NombreEmpleado = NombreEmpleado;
	}
	public String getApellidoEmpleado()
	{
		return ApellidoEmpleado;
	}
	public void setApellidoEmpleado(String ApellidoEmpleado)
	{
		this.ApellidoEmpleado = ApellidoEmpleado;
	}
	public String getFechaNacimientoEmpleado()
	{
		return FechaNacimientoEmpleado;
	}
	public void setFechaNacimientoEmpleado(String FechaNacimientoEmpleado)
	{
		this.FechaNacimientoEmpleado = FechaNacimientoEmpleado;
	}
	public double getSalario()
	{
		return salario;
	}
	public void setSalario(double salario)
	{
		this.salario = salario;
	}
	
	public String toString()
	{
		return "idEmpleado: " + getIdEmpleado()+"Nombre Empleado: "+getNombreEmpleado()+"Apellido Empleado: "+ getApellidoEmpleado() + "Fecha de Nacimiento: " + getFechaNacimientoEmpleado() + "Salario Empleado: "+ getSalario();
	}

}
