package com.curso.java_avanzado_pruebas.stream;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOpeartionsTest {

	public static void main(String[] args) {
		//Operaciones Intermedias
		//FILTER
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo" , "mono");
		s.filter(x -> { 
				System.out.println("in filter 1: " + x);
				return x.startsWith("m");
			})
			.filter(x -> { 
				System.out.println("in filter 2: " + x);
				return x.endsWith("o");
			})
		   .forEach( c -> {
			   System.out.println("in foreach: " + c);
			  // System.out.println(c);
		   });  
		
		//DISTINCT
		Stream<String> s2 = Stream.of("duck", "duck", "duck", "goose");
		s2.distinct()
		   .forEach(System.out::println); // duckgoose
		
		//LIMIT 
		Stream<Integer> s3 = Stream.iterate(1, n -> n + 1);
		s3.skip(5)
		   .limit(5)
		   .forEach(System.out::println);  

		//STREAM
		System.out.println("imprime longitudes de las candenas del flujo:");
		Stream<String> stream4 = Stream.of("monkey", "gorilla", "bonobo");
		stream4.map( cadena -> cadena.length() )
			.map( entero -> "*"+entero+"*")
		   .forEach(System.out::println);  

	}
}



