package com.curso.java_avanzado_pruebas.stream;

import java.util.stream.Stream;

public class StreamIntroTest {

	public static void main(String[] args) {
		//SOURCE
		Stream<String> stream = Stream.of("a", "b", "c", "d");
		
		//INTERMEDIATE OPERATIONS
		Stream<String> streamIntermediate = stream.map( cadena -> cadena.concat("*") )
													.peek(c -> { 
														System.out.println("en peek: " + c);
													})
													.map( cadena -> "*".concat(cadena))
													;
		//TERMINAL OPERATIONS
		streamIntermediate.forEach(cadena -> { 
			System.out.println("en forEach: " + cadena);
		});
		 
	}

}
