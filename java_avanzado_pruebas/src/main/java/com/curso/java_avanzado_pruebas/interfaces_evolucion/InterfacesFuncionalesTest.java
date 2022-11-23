package com.curso.java_avanzado_pruebas.interfaces_evolucion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Animal {
	   private String species;
	   private boolean canHop;
	   private boolean canSwim;
	   public Animal(String speciesName, boolean hopper, boolean swimmer) {
	      species = speciesName;
	      canHop = hopper;
	      canSwim = swimmer;
	   }
	   public boolean canHop()  { return canHop; }
	   public boolean canSwim() { return canSwim; }
	   public String toString() { return species; }
	}


public class InterfacesFuncionalesTest {
	public static void main(String[] args) {
	}
}

class TraditionalSearch {
    public static void main(String[] args) {
      // list of animals
      var animals = new ArrayList<Animal>();  
      animals.add(new Animal("fish",     false, true));
      animals.add(new Animal("kangaroo", true,  true));
      animals.add(new Animal("rabbit",   true,  false));
      animals.add(new Animal("turtle",   false, true));
      String palabra = "JUAN";
      Predicate<String> predicado = null;
      
      // Pass lambda that does check
      boolean test = true;
      //test = false;
      print(animals, a -> test);
   }
   private static void print(List<Animal> animals,  Predicate<Animal> checker) {
      for (Animal animal : animals) {
        if (checker.test(animal)) 
            System.out.print(animal + " ");
      }
   }
}
