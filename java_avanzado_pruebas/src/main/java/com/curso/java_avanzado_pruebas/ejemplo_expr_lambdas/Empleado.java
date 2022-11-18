package com.curso.java_avanzado_pruebas.ejemplo_expr_lambdas;

public class Empleado {	
	private String nombre;
	private double sueldo;
	private int aniosDeTrabajo;
	public Empleado(String nombre, double sueldo, int aniosDeTrabajo) {
        	this.nombre = nombre;
        	this.sueldo = sueldo;
        	this.aniosDeTrabajo = aniosDeTrabajo;
	}
	public String getNombre() {	return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public double getSueldo() {return sueldo;}
	public void setSueldo(double sueldo) {this.sueldo = sueldo;}
	public int getAniosDeTrabajo() {return aniosDeTrabajo;}
	public void setAniosDeTrabajo(int aniosDeTrabajo) {this.aniosDeTrabajo = aniosDeTrabajo;}
	public String toString(){
        	return nombre;
	}
}
