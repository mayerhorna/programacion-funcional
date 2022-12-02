package com.curso.java_avanzado_pruebas.stream;

import java.util.Comparator;
import java.util.List;
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
		stream4
			.map( cadena -> cadena.length() )
			.map( entero -> "*"+entero+"*")
			.filter(string -> string.contains("6"))
		   .forEach(System.out::println);  
		
		
		
		//flatMap
		List<String> zero = List.of();
		var one = List.of("Bonobo");
		var two = List.of("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		//animals.map(lista -> lista.remove(0)  )
		animals.flatMap(m -> m.stream())
			.filter(str -> str.startsWith("M"))
			.forEach(System.out::println);
		
		//SORTED:
		Stream<String> s15 = Stream.of("brown-", "bear-");
		s15.sorted()
		   .forEach(System.out::println); // bear-brown-
		
		Stream<String> s16 = Stream.of("brown bear-", "grizzly-");
		s16.sorted(Comparator.reverseOrder())
		   .forEach(System.out::println); // grizzly-brown bear
		
		//PEEK
		var stream = Stream.of("black bear", "brown bear", "grizzly");
		long count = stream
						.peek(str -> System.out.println("before: " + str))
						.filter(str -> str.startsWith("g"))
						.peek(str -> System.out.println("after: " + str))
						.count();              
		System.out.println(count);                          
		
	}
}



