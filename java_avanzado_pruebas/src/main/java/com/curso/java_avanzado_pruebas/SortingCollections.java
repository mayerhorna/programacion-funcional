package com.curso.java_avanzado_pruebas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class GenreSort implements Comparator<DVDInfo> {
	public int compare(DVDInfo one, DVDInfo two) {
		return two.getGenre().compareTo(one.getGenre());
	}
}


class DVDInfo implements Comparable<DVDInfo>{
	private String title;
	private String genre;
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getGenre() { return genre; }
	public void setGenre(String genre) { this.genre = genre; }

	public int compareTo(DVDInfo d) {
				//  "Renacer"  "Amanacer"           // 1
		return d.getTitle().compareTo(this.title);
	}
	 
}

public class SortingCollections {

	public static void main(String[] args) {
		List<String> stuff = new ArrayList<String>();
		stuff.add("Denver");
		stuff.add("Boulder");
		stuff.add("Vail");
		stuff.add("Aspen");
		stuff.add("Telluride");
		System.out.println("unsorted " + stuff);
		Collections.sort(stuff); // #2
		System.out.println("sorted " + stuff);
		
		
		List<DVDInfo> dvdList = new ArrayList<DVDInfo>();
		DVDInfo info1 = new DVDInfo();
		info1.setTitle("Titulo Z");
		info1.setGenre("Terror");
		DVDInfo info2 = new DVDInfo();
		info2.setTitle("Titulo A");
		info2.setGenre("Comedia");
		dvdList.add(info2);
		dvdList.add(info1);
		System.out.println("desordenado: ");
		for (DVDInfo dvdInfo : dvdList) {
			System.out.println(dvdInfo.getTitle());
		}
		Collections.sort(dvdList);

		System.out.println("ordenado: ");
		for (DVDInfo dvdInfo : dvdList) {
			System.out.println(dvdInfo.getTitle());
		}
		
		
		Collections.sort(dvdList, new GenreSort());
		
		
		System.out.println("ordenado por Genero Ascendente: ");
		for (DVDInfo dvdInfo : dvdList) {
			System.out.println(dvdInfo.getTitle() + ": " + dvdInfo.getGenre());
		}
		
		Long pk = 3L;
		
		if(pk.equals(3L)) {
			System.out.println("");
		}
	}
}
