package com.curso.java_avanzado_pruebas.interfaces_funcionales_java;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MetodoDeConvenienciaTest {

	public static void main(String[] args) {
		Predicate<String> egg = s -> s.contains("egg");
		Predicate<String> brown = s -> s.contains("brown");
		
		Predicate<String> brownEggs =  s -> s.contains("egg") && 
											s.contains("brown");
		Predicate<String> otherEggs =  s -> s.contains("egg") && ! 
												s.contains("brown");

		Predicate<String> brownEggs2 = egg.and(brown);
		Predicate<String> otherEggs2 = egg.and(brown.negate());
		System.out.println(otherEggs2.test("egg yellow"));
		
		Consumer<String> c1 = x -> System.out.println("1: " + x);
		Consumer<String> c2 = x -> System.out.println(",2: " + x);

		Consumer<String> combined = c1.andThen(c2);
		combined.accept("Annie");              // 1: Annie,2: Annie
		
		
		Function<Integer, Integer> before = x -> x + 1;
		Function<Integer, Integer> after = x -> x * 2;

		Function<Integer, Integer> combined2 = after.compose(before);
		System.out.println(combined2.apply(3));   

		String str = null; //new String(); //[]
		if(str != null) {
			str.equals("");
		}
		
		Optional<String> opString = Optional.of("Hola");	//[3]
		
	}

}
