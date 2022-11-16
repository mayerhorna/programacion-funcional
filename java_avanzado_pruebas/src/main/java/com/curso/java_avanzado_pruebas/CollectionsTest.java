package com.curso.java_avanzado_pruebas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

class Empleado extends Entidad{
	private Long empleado_id;
	private String nombre;
	
	public Empleado(Long empleado_id, String nombre) {
		this.empleado_id = empleado_id;
		this.nombre = nombre;
	}
	public Long getEmpleado_id() {
		return empleado_id;
	}
	public void setEmpleado_id(Long empleado_id) {
		this.empleado_id = empleado_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Empleado == false) {
			return false;
		}
		if(this.getEmpleado_id().equals(  ((Empleado)obj).getEmpleado_id()  )) {
			return true;
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return this.empleado_id.intValue();
	}
}

public class CollectionsTest {

	public static void main(String[] args) {
		
		List<String> cadenas = new ArrayList<>();
		cadenas.add("A");
		cadenas.add("C");
		cadenas.add("D");
		cadenas.add("B");
		cadenas.add("C");
		cadenas.add("A");
		
		System.out.println("recorrido con for each - ArrayList");
		for(String cadena : cadenas) {
			System.out.println(cadena);
		}
		cadenas.get(1);
		
		HashSet<String> setDeCadenas = new HashSet<String>();
		setDeCadenas.add("Z");
		setDeCadenas.add("A");
		setDeCadenas.add("C");
		setDeCadenas.add("D");
		setDeCadenas.add("B");
		setDeCadenas.add("C");
		setDeCadenas.add("A");
		
		System.out.println("recorrido con for each - HashSet");
		for(String cadena : setDeCadenas) {
			System.out.println(cadena);
		}
		
		TreeSet<String> treeSetDeCadenas = new TreeSet<String>();
		treeSetDeCadenas.add("Z");
		treeSetDeCadenas.add("A");
		treeSetDeCadenas.add("C");
		treeSetDeCadenas.add("D");
		treeSetDeCadenas.add("B");
		treeSetDeCadenas.add("C");
		treeSetDeCadenas.add("A");
		
		System.out.println("recorrido con for each - TreeSet");
		for(String cadena : treeSetDeCadenas) {
			System.out.println(cadena);
		}
		
		
		Empleado e1 = new Empleado(1L, "Juan");
		Empleado e2 = new Empleado(2L, "Maria");
		Empleado e3 = new Empleado(3L, "Hugo");
		Empleado e4 = new Empleado(1L, "Juan");
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(e3);
		empleados.add(e1);
		empleados.add(e2);
		empleados.add(e4);
		
		for(Empleado empleado : empleados) {
			System.out.println(empleado.getEmpleado_id() + ": " + empleado.getNombre());
		}
		
		HashSet<Empleado> setEmpleados = new HashSet<Empleado>();
		setEmpleados.add(e1);
		setEmpleados.add(e2);
		setEmpleados.add(e3);
		setEmpleados.add(e4);
		System.out.println("Set de empleados: ");
		for(Empleado empleado : setEmpleados) {
			System.out.println(empleado.getEmpleado_id() + ": " + empleado.getNombre());
		}
		
		String s1 = "a";
		String s2 = new String("a");
		
		System.out.println(s1 == s2);  // false
		System.out.println(s1.equals(s2)); // true
		
		//System.out.println(e1.equals(e1));
		System.out.println(e1.equals(e4));
		
		
		HashMap<Integer, String> mapCadenas = new HashMap<Integer, String>(); 
		mapCadenas.put(1, "Juan");
		mapCadenas.put(3, "Maria");
		mapCadenas.put(20, "Marco");
		
		System.out.println(mapCadenas.get(3));
		
		HashMap<String, String> mapParametros = new HashMap<String, String>(); 
		mapParametros.put("url_prod", "http://prod");
		mapParametros.put("url_desa", "http://desa");
		mapParametros.put("app_name", "Sistema XYZ");
		
		System.out.println(mapParametros.get("app_name")); 
		
		HashMap<Long, Empleado> empleadosMap = new HashMap<>();
		empleadosMap.put(e1.getEmpleado_id(), e1);
		empleadosMap.put(e2.getEmpleado_id(), e2);
		empleadosMap.put(e3.getEmpleado_id(), e3);
		Vector<String> s = null;
		System.out.println(empleadosMap.get(1L).getNombre());
		
		
		boolean contieneEmpleado = empleados.contains(new Empleado(1L, "..."));
		System.out.println(contieneEmpleado);
	}

}
