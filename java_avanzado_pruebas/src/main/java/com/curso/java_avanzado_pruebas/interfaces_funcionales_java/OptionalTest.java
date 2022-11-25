package com.curso.java_avanzado_pruebas.interfaces_funcionales_java;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		Optional<Double> average1 = average(90, 100);
		Optional<Double> average2 = average();
		
		average1.ifPresent(System.out::println);
		
		average2.orElseGet(()->new Double(3));

	}

	public static Optional<Double> average(int... scores) {
		if (scores.length == 0)
			return Optional.empty();
		int sum = 0;
		for (int score : scores)
			sum += score;
		return Optional.of((double) sum / scores.length);
	}

}
