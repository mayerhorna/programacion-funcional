package com.curso.java_avanzado_pruebas;

class Popcorn {
	public void pop() {
		System.out.println("popcorn");
	}
}
/* 
class CustomPopcorn extends Popcorn{
	public void pop() {
		System.out.println("custom popcorn");
	}
}
*/

public class ClaseAnonimaPruebas {

	public static void main(String[] args) {
		Popcorn popcorn = new Popcorn() {
			private String patronPopcorn = "*";
			public void pop() {
				System.out.println("custom popcorn: " + patronPopcorn);
			}
		};
		popcorn.pop();
	}

}
