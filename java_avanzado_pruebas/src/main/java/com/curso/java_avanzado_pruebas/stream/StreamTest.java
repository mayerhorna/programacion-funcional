package com.curso.java_avanzado_pruebas.stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		//SOURCE
		Stream<String> stream = Stream.of("a", "b", "c", "d");
		
		//INTERMEDIATE OPERATIONS
		Stream<String> streamIntermediate = stream.map( cadena -> cadena.concat("*") )
													.map( cadena -> "*".concat(cadena))
													;
		//TERMINAL OPERATIONS
		streamIntermediate.forEach(cadena -> System.out.println(cadena));
		
		
		Stream<String> empty = Stream.empty();          // count = 0
		Stream<Integer> singleElement = Stream.of(1);   // count = 1
		Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3
		
		
		var list = List.of("a", "b", "c");
		Stream<String> fromList = list.stream();

		Stream<Double> randoms = Stream.generate(Math::random);
		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
		
		//randoms.forEach(System.out::println);
		//oddNumbers.forEach(System.out::println);
		
		Stream<Integer> oddNumberUnder100 = Stream.iterate(
							1,             // inicio
				   			n -> n < 100,  // Predicate para especificar cuando termina
				   			n -> n + 2);   // UnaryOperator para obetner el siguiente	
		oddNumberUnder100.forEach(System.out::println);
		
		
		var list2 = List.of("a", "b", "c");
		Stream<String> fromListParallel = list2.parallelStream();
		fromListParallel
		            .map( cadena -> cadena.concat("*") )
					.map( cadena -> "*".concat(cadena)) 
					.forEach(System.out::println);
	}

}
