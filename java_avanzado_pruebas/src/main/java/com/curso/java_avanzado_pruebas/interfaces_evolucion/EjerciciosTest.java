package com.curso.java_avanzado_pruebas.interfaces_evolucion;

import java.util.function.Predicate;

//Crea una expresión lambda apoyándote de un Predicate<String> que verifique si una palabra empieza con la letra P mayúscula
public class EjerciciosTest {
	public static void main(String[] args) {
		boolean bool = empiezaConPMayuscula("Juan");
		System.out.println(bool == false);
		bool = empiezaConPMayuscula("Peruano");
		System.out.println(bool == true);
		
	}

	public static boolean empiezaConPMayuscula(String palabra) {
		Predicate<String> predicate = (String cadena) -> cadena.startsWith("P");
		return predicate.test(palabra);
	}
}
