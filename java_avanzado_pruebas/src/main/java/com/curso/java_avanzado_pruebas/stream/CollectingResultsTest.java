package com.curso.java_avanzado_pruebas.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResultsTest {

	public static void main(String[] args) {
		var cats = new ArrayList<String>();
		cats.add("Annie");
		cats.add("Ripley");
		var stream = cats.stream();
		cats.add("KC");
		System.out.println(stream.count());
		
		
		//JOINING
		var ohMy = Stream.of("lions", "tigers", "bears");
		String result = ohMy.collect(Collectors.joining("|"));
		System.out.println(result); // lions, tigers, bears
		
		//AVERAGE
		var ohMy2 = Stream.of("lions", "tigers", "bears");
		Double result2 = ohMy2.collect(Collectors.averagingInt(String::length));
		System.out.println(result2); // 5.333333333333333
		
		//TO MAP
		var ohMy3 = Stream.of("lions", "tigers", "bears");
		Map<String, Integer> map2 = ohMy3.collect(
		   Collectors.toMap(s -> s, String::length));
		System.out.println(map2); // {lions=5, bears=5, tigers=6}
		
		//groupingBy
		var ohMy5 = Stream.of("lions", "tigers", "bears");
		Map<Integer, List<String>> map5 = ohMy5.collect(
		 Collectors.groupingBy(String::length));
		System.out.println(map5);    // {5=[lions, bears], 6=[tigers]}
		System.out.println(map5.get(5));

		//partitioningBy
		var ohMy6 = Stream.of("lions", "tigers", "bears");
		Map<Boolean, List<String>> map6 = ohMy6.collect(
		   Collectors.partitioningBy(s -> s.length() <= 5));
		System.out.println(map6); //{false=[tigers], true=[lions, bears]}

		
		var ohMy7 = Stream.of("lions", "tigers", "bears");
		Map<Integer, Long> map7 = ohMy7.collect(
		   Collectors.groupingBy(
		      String::length, 
		      Collectors.counting()));
		System.out.println(map7);    // {5=2, 6=1}
		
		
		var ohMy8 = Stream.of("lions", "tigers", "bears");
		Map<Integer, Optional<Character>> map8 = ohMy8.collect(
		   Collectors.groupingBy(
		      String::length,
		      Collectors.mapping(
		         s -> s.charAt(0), 
		         Collectors.minBy((a, b) -> a -b))));
		System.out.println(map8);    // {5=Optional[b], 6=Optional[t]}

	}

	private static void threeDigit(Optional<Integer> optional) {
		if (optional.isPresent()) { // outer if
			var num = optional.get();
			var string = "" + num;
			if (string.length() == 3) // inner if
				System.out.println(string);
		}
	}
	
	private static void threeDigit2(Optional<Integer> optional){
		optional.map(n -> "" + n)            
		      .filter(s -> s.length() == 3)     
		      .ifPresent(System.out::println);  
	}

}
