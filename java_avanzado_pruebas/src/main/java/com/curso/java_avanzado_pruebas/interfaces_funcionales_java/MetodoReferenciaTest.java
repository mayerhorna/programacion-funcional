package com.curso.java_avanzado_pruebas.interfaces_funcionales_java;

import java.util.function.Consumer;

class Metodos{
	public void print(String cadena) {
		System.out.println(cadena);
	}
}

public class MetodoReferenciaTest {

	public static void main(String[] args) {
		Consumer<String> comsumer = cadena -> System.out.println(cadena);
		Consumer<String> comsumer2 = System.out::println;
		Consumer<String> comsumer3 = MetodoReferenciaTest::imprimir;
		
		Metodos metodos = new Metodos();
		Consumer<String> comsumer4 = metodos::print;
		
		comsumer4.accept("Hola");
		comsumer4.accept("Mundo");
	}
	
	public static void imprimir(String cadena) {
		System.out.println(cadena);
	}

}
