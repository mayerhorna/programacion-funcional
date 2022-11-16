package com.curso.java_avanzado_pruebas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
class Entidad{
}
class Cliente extends Entidad{}

interface CrudRepository<P,T extends Entidad>{
	public void save(T t);
	public void update(T t);
	public void delete(P p);
	public List<T> getAll();
	public T get(P id);
}

class ClienteCrudRepository implements CrudRepository<Long, Cliente>{
	public void save(Cliente t) {
	}
	public void update(Cliente t) {
	}
	public void delete(Long t) {
	}
	public List<Cliente> getAll() {
		return null;
	}
	public Cliente get(Long id) {
		return null;
	}
}

class EmpleadoCrudRepository implements CrudRepository<String, Empleado>{
	public void save(Empleado t) {
	}

	public void update(Empleado t) {
	}

	public void delete(String p) {
	}

	public List<Empleado> getAll() {
		return null;
	}

	public Empleado get(String id) {
		return null;
	}
}


interface DAO{
	public String consultarRuc();
	public void actualizar();
}

class DAOHibernate implements DAO{
	public void grabar() {
	}
	public void actualizar() {
		
	}
	public String consultarRuc() {
		return null;
	}
}
class ClienteDaoHibernate extends DAOHibernate{
	//@Autowired
	private DAO daoCliente;
	public void grabar() {
	}
	public String consultarRuc() {
		return "20323132123";
	}
}

class MyList<T>{
	private ArrayList<T> elementos = new ArrayList<>();
	private T[] elementosArray = null;
	public void agregar(T element) {
		elementos.add(element);
	}
	
	public T obtener(int indice) {
		return elementos.get(indice);
	}
}

class GenericMetodos{
	public <T> List<T> generarListaGenerica(T ... elementos){
		List<T> lista = new ArrayList<>();
		for(T t : elementos) {
			lista.add(t); 
		}
		return lista;
	}
	
	public <E> List<E> generarListaGenericaV2(E ... elementos){
		List<E> lista = new ArrayList<>();
		for(E t : elementos) {
			lista.add(t); 
		}
		return lista;
	}
}


public class GenericTest {
	public static void main(String[] args) {
		Empleado e1 = new Empleado(1L, "Juan");
		Empleado e2 = new Empleado(2L, "Maria");
		Empleado e3 = new Empleado(3L, "Hugo");
		Empleado e4 = new Empleado(1L, "Juan");
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(e3);
		empleados.add(e1);
		empleados.add(e2);
		empleados.add(e4);
		
		Object str = new String("Hola");
		System.out.println(str);
		
		DAOHibernate daoHibernate = new ClienteDaoHibernate();
		
		DAO daoCliente = new ClienteDaoHibernate();
		String ruc = daoCliente.consultarRuc();
		System.out.println(ruc);
		
		MyList<String> myList = new MyList<String>();
		myList.agregar("a");
		
		MyList<Integer> myList2 = new MyList<Integer>();
		myList2.agregar(4);
		
		GenericMetodos genericMetodos = new GenericMetodos();
		List<String> cadenas = genericMetodos.generarListaGenerica("a" , "b", "c");
		List<Integer> numeros = genericMetodos.generarListaGenerica(1 , 2, 3, 4);
		List<String> cadenas2 = genericMetodos.generarListaGenericaV2("a", "b","d");
		
		for (Integer integer : numeros) {
			System.out.println(integer);
		}
		
		for (String cadena : cadenas) {
			System.out.println(cadena);
		}
		
		for (String cadena : cadenas2) {
			System.out.println(cadena);
		}
		Empleado e5 = new Empleado(1L, "Juan");
		Empleado e6 = new Empleado(2L, "Maria");
		Empleado e7 = new Empleado(3L, "Hugo");
		
		List<Empleado> empleados2 = new ArrayList<Empleado>();
		empleados2.add(e3);
		empleados2.add(e1);
		empleados2.add(e2);
		empleados2.add(e4);
		
		recorrerLista(empleados2);
	}
	
	public static void recorrerLista(List<? extends Empleado> empleados) {
		//empleados.add(new Empleado(1L,""));
		for (Object object : empleados) {
			System.out.println(object);
		}
	}
}
