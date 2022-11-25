package com.curso.java_avanzado_pruebas.interfaces_funcionales_java;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class InterfacesFuncionalesDeJava {

	public static void main(String[] args) {
		Supplier<StringBuilder> supplierSb = () -> new StringBuilder();
		List<String> cadenas = List.of("a" , "b", "c");
		cadenas.forEach( cadena -> {  
			System.out.println(cadena);
		}  );
		BiConsumer<String, String> biConsumerConcat = (s1, s2) -> {
			System.out.println(s1 + s2);
		};
		biConsumerConcat.accept("A", "B");
		biConsumerConcat.accept("C", "D");
		biConsumerConcat.accept("A", "X");
		
		BiPredicate<String, String> biPredicateExtractChar = (cadena, charInicial) -> {
			return cadena.startsWith(charInicial);
		};
		boolean empiezaConLetra = biPredicateExtractChar.test("Amable", "A");
		System.out.println(empiezaConLetra);
		
		
		Function<String, Integer> contarLetrasFn = cadena -> cadena.length();
		
		System.out.println(contarLetrasFn.apply("Hola"));
		System.out.println(contarLetrasFn.apply("Sol"));
		System.out.println(contarLetrasFn.apply("Playa"));
		
		BiFunction<String, String, Integer> contarCharDeConcatenacion = (cadena1, cadena2) ->{
			return cadena1.concat(cadena2).length();
		};
		
		System.out.println(contarCharDeConcatenacion.apply("Hola", "Mundo"));
		
		UnaryOperator<String> obtenerCadenaDesdePosicion1 = cadena -> cadena.substring(1);
		BinaryOperator<String> obtenerCadenaDesdePosicion2 = (cadena1, cadena2) -> cadena2.substring(1);
		BiFunction<String,String,String> obtenerCadenaDesdePosicion3 = (cadena1, cadena2) -> cadena2.substring(1);
		System.out.println(obtenerCadenaDesdePosicion1.apply("Hola"));
		
		//Practica
		Predicate<List> ex1 = x -> "".equals(x.get(0));
		Consumer<Long> ex2 = (Long l) -> System.out.println(l);
		BiPredicate<String, String> ex3 = (s1, s2) -> false;
		
		TriFunction<String, Boolean, Integer, StringBuilder> triFn = (cadena, bool, integer) -> {
				return 
				new StringBuilder("")
				.append(cadena)
				.append(bool)
				.append(integer);
		};
		
		System.out.println(triFn.apply("a", true, 2));
	}
}

interface TriFunction<T,U,V,R> {
	R apply(T t, U u, V v);
}
