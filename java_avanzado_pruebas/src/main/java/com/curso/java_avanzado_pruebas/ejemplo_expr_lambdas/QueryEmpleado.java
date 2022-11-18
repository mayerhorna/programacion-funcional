package com.curso.java_avanzado_pruebas.ejemplo_expr_lambdas;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

/*
interface Predicado {
	boolean test(Empleado valorAEvaluar);
}
*/
public class QueryEmpleado {
	public static void main(String[] args) {
		ArrayList<Empleado> empleados = new ArrayList<>();
		empleados.add(new Empleado("Hugo", 1000, 2));
		empleados.add(new Empleado("Maria", 1300, 3));
		empleados.add(new Empleado("Miguel", 1200, 4));
		empleados.add(new Empleado("Karen", 1800, 6));
		System.out.println("Todos los empleados: " + empleados);
		/*
		Predicado predicadoGananMasDe1500 = new Predicado() {
			@Override
			public boolean test(Empleado emplado) {
				return emplado.getSueldo() > 1500;
			}
		};
		*/
		/*
		System.out.println("Ganan mas de 1500: " + gananMasDe(empleados, new Predicado() {
			public boolean test(Empleado emplado) {
				return emplado.getSueldo() > 1500;
			}
		}));
		*/
		System.out.println("Ganan mas de 1500: " + query(empleados, empleado -> empleado.getSueldo() > 1500));
		System.out.println("Tienen menos de 5 años de experiencia: " + query(empleados, empleado -> empleado.getAniosDeTrabajo() < 5));
		System.out.println("Tienen mas de 5 años de experiencia: " + query(empleados, 
				(Empleado empleado) -> { 
						System.out.println("en evaluacion");
						return empleado.getAniosDeTrabajo() > 5; 
				    }
				
			)
		);
	}


	private static ArrayList<Empleado> query(ArrayList<Empleado> empleados, Predicate<Empleado> predicado) {
		ArrayList<Empleado> resultado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			if (predicado.test(empleado)) {
				resultado.add(empleado);
			}
		}
		return resultado;
	}
 
	 
	
	/*//VERSION SIN EXPRESIONES LAMBDAS
	
	private static ArrayList<Empleado> gananMasDe(ArrayList<Empleado> empleados, double valorAEvaluar) {
		ArrayList<Empleado> resultado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			if (empleado.getSueldo() > valorAEvaluar) {
				resultado.add(empleado);
			}
		}
		return resultado;
	}

	private static ArrayList<Empleado> menosExperienciaDe(ArrayList<Empleado> empleados, int valorAEvaluar) {
		ArrayList<Empleado> resultado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			if (empleado.getAniosDeTrabajo() < valorAEvaluar) {
				resultado.add(empleado);
			}
		}
		return resultado;
	}
	
	private static ArrayList<Empleado> masExperienciaDe(ArrayList<Empleado> empleados, int valorAEvaluar) {
		ArrayList<Empleado> resultado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			if (empleado.getAniosDeTrabajo() > valorAEvaluar) {
				resultado.add(empleado);
			}
		}
		return resultado;
	}
*/
}
