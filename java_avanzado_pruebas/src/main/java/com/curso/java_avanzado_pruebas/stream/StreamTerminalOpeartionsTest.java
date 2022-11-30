package com.curso.java_avanzado_pruebas.stream;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalOpeartionsTest {

	public static void main(String[] args) {
		//Operaciones terminales
		//COUNT
		Stream stream = Stream.of("a", "b","e");
		
		long cantidadElementos = stream.count();
		System.out.println("cantidad de elementos: " + cantidadElementos);
		
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		System.out.println(s.count());   // 3
		
		//MIN								//ape   monkey  bonobo
		Stream<String> stream2 = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = stream2.min((s1, s2) -> s1.length() - s2.length());
		min.ifPresent(System.out::println);
		/*
		Optional<String> max = stream2.max((s1, s2) -> s1.length() - s2.length());
		max.ifPresent(System.out::println);
		*/

		
		Stream<String> stream3 = Stream.of("monkey", "gorilla", "bonobo");
		//stream3.findAny().ifPresent(System.out::println);  // monkey (usually)
		stream3.findFirst().ifPresent(System.out::println); // monkey
		
		//ANY MATCH
		var list = List.of("monkey", "2", "chimp");
		Stream<String> infinite = Stream.generate(() -> "chimp");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		 
		System.out.println(list.stream().anyMatch(pred));  // true
		System.out.println(list.stream().allMatch(pred));  // false
		System.out.println(list.stream().noneMatch(pred)); // false
		System.out.println(infinite.anyMatch(pred));       // true

		System.out.println("FIN");
		
		
		//FOR EACH
		
		Stream<String> stream4 = Stream.of("Monkey", "Gorilla", "Bonobo");
		stream4.forEach(element -> {
			System.out.println(element);
		}); // MonkeyGorillaBonobo
		/*
		Stream<Integer> stream5 = Stream.of(1);
		for (Integer i  : stream5) {} // NO COMPILA
		*/
		
		/******************************REDUCCIONES *****/
		//REDUCE::::::
		//CONCATENACION IMPERATIVA
		var array = new String[] { "w", "o", "l", "f" };
		var result = "";
		for (var str: array) {
			result = result + str;
		}
		System.out.println(result); // wolf
		
		//FORMA 1
		Stream<String> stream5 = Stream.of("w", "o", "l", "f");
		String word = stream5.reduce("", (c1, c2) -> c1 + c2);
		System.out.println(word); // wolf

		//Usando referencia de métodos:
		Stream<String> stream6 = Stream.of("h", "o", "l", "a");
		String word2 = stream6.reduce("", String::concat);
		System.out.println(word2); // wolf
		
		Stream<Integer> stream7 = Stream.of(3, 5, 6);
		System.out.println(stream7.reduce(1, (a, b) -> a*b));  // 90

		//FORMA 2:
		
		BinaryOperator<Integer> op = (a, b) -> a * b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(3);
		Stream<Integer> threeElements = Stream.of(3, 5, 6);
		 
		empty.reduce(op).ifPresent(System.out::println);   // no output
		oneElement.reduce(op).ifPresent(System.out::println);    // 3
		threeElements.reduce(op).ifPresent(System.out::println); // 90
		
		//FORMA 3:
	    Stream<String> stream8 = Stream.of("w", "o", "l", "f!");
	    int length = stream8.reduce(0, (lng, str) -> { 
	    	System.out.println("***************");
	    	return lng + str.length();
	    }, (acumulador1, acumulador2) -> { 
	    	System.out.println("----------------");
	    	return acumulador1 + acumulador2;
	    });
	    System.out.println(length); // 5
	    
	    
	    //COLLECT
	    //FORMA 1
	    Stream<String> stream9 = Stream.of("w", "o", "l", "f");
		StringBuilder word3 = stream9.collect(
										() -> new StringBuilder(),
										(strBl, cadena ) -> strBl.append(cadena) , 
										(strBl1, strBl2) -> strBl1.append(strBl2) 
								);
		System.out.println(word3); // wolf 
		
		Stream<String> stream10 = Stream.of("w", "o", "l", "f");
		TreeSet<String> set = stream10.collect(
		   TreeSet::new, 
		   TreeSet::add,
		   TreeSet::addAll);
		System.out.println(set); // [f, l, o, w]

		//FORMA 2
		Stream<String> stream11 = Stream.of("w", "o", "l", "f");
		List<String> strings = stream11.collect(Collectors.toList());
		strings.forEach(System.out::println);
		
		Stream<String> stream12 = Stream.of("w", "o", "l", "f");
		TreeSet<String> set12 = stream12.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set12); // [f, l, o, w]
		
		Stream<String> stream13 = Stream.of("w", "o", "l", "f");
		Set<String> set13 = stream13.collect(Collectors.toSet());
		System.out.println(set13); // [f, w, l, o]
		System.out.println("Pregunta 12: ");
		int cantidad1 =	cuantosEmpiezanConA("alonso","maria","alan");
		System.out.println(cantidad1);
	}
	
	//pregunta 12
	public static int cuantosEmpiezanConA(String ... names) {
	  return List.of(names).stream().reduce(
				0,  
				(cantidad , name )  -> {
					return cantidad + (name.startsWith("a") ? 1 : 0);	
				},
				(acumulador1 , acumulador2) -> acumulador1  + acumulador2			 
		);
	}
}



