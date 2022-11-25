package com.curso.java_avanzado_pruebas.interfaces_funcionales_java;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Metodos{
	public void print(String cadena) {
		System.out.println(cadena);
	}
}

@FunctionalInterface
interface MiFunction{
	boolean test(String cadena);
}

public class MetodoReferenciaTest {

	public static void main(String[] args) {
		Consumer<String> comsumer = cadena -> System.out.println(cadena);
		Consumer<String> comsumer2 = System.out::println;
		Consumer<String> comsumer3 = MetodoReferenciaTest::imprimir;
		
		Metodos metodos = new Metodos();
		Consumer<String> comsumer4 = metodos::print;
		MiFunction miFn = x -> x.startsWith("M");
		
		comsumer4.accept("Hola");
		comsumer4.accept("Mundo");
		
		Predicate<String> testEmpty = String::isEmpty;
		
		boolean test = miFn.test("Mama");
		System.out.println(test);
		 
		System.out.println(testEmpty.test("A"));
		System.out.println(testEmpty.test(""));
		
		BiPredicate<String, String> lambda = (s, p) -> s.startsWith(p);
		BiPredicate<String, String> lambda2 = String::startsWith;
		
		boolean empiezaConH = lambda2.test("Hola", "H");
		System.out.println(empiezaConH);
		
		Metodos metodos2 = new Metodos();
		Supplier<StringBuilder> supplierFn = () -> new StringBuilder();
		Supplier<StringBuilder> supplierFn2 = StringBuilder::new;
		
		StringBuilder sb1 = supplierFn.get();
		StringBuilder sb2 = supplierFn.get();
		StringBuilder sb3 = supplierFn.get();
		StringBuilder sb4 = supplierFn2.get();
		
	}
	
	public static void imprimir(String cadena) {
		System.out.println(cadena);
	}

}
