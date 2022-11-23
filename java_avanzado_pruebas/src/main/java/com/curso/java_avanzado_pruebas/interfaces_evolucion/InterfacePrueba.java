package com.curso.java_avanzado_pruebas.interfaces_evolucion;

import java.util.function.Predicate;

import com.curso.java_avanzado_pruebas.ejemplo_expr_lambdas.Empleado;

@FunctionalInterface
interface Predicado {
	String TITULO_SISTEMA = "Sistema XYZ";
	boolean test(Empleado valorAEvaluar);
	 
	default int calculo(int x) {
		return x + 1;
	}
	static int calculo2(int x) {
		return x + 1;
	}
	private int calculo3(int x) {
		return x + 1;
	}
	private static int calculo4(int x) {
		return x + 1;
	}
}

class MiPredicado implements Predicado{
	public boolean test(Empleado valorAEvaluar) {
		return false;
	}
}

public class InterfacePrueba {

	public static void main(String[] args) {
		String titulo = Predicado.TITULO_SISTEMA;
		int calculo = Predicado.calculo2(2);
		MiPredicado miPredicado = new MiPredicado();
		int calculo2 = miPredicado.calculo(3);
		
		Predicate<String> empiezaConLetraX = cadena -> cadena.startsWith("X")  ;  
		Predicate<String> empiezaConLetraY = cadena -> cadena.startsWith("Y");  
		
		Predicate<String> empiezaConLetraXeY = empiezaConLetraX.or(empiezaConLetraY);
		
		Comparable<String> comprarable = cadena -> 3; 
		//boolean test = empiezaConLetraXeY.test("AMABLE");
		//empiezaConLetraXeY.negate().test("");
		//System.out.println(test);
	}

}
