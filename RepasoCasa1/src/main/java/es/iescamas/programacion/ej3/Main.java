package es.iescamas.programacion.ej3;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main (String[]args) {
		Pelicula p1 = new Pelicula ("pelo", "Alba",2006, 90);
		Pelicula p2 = new Pelicula ("uña", "Pedro",2007, 120);
		Pelicula p3 = new Pelicula ("pestaña", "Pedro", 1953, 60);
		Pelicula p4 = new Pelicula ("ojo", "Javi",1975, 130);
		Pelicula p5 = new Pelicula ("boca", "Bella yoli", 1976, 90);
	
		ArrayList<Pelicula> Lista  = new ArrayList<Pelicula>();
		Lista.add(p1);
		Lista.add(p2);
		Lista.add(p3);
		Lista.add(p4);
		Lista.add(p5);
	
		Videoteca vid = new Videoteca (Lista);
		
		// 2. Intenta añadir una película duplicada y captura la excepción
		try {
			// Intentamos añadir 'p1' que ya está en la lista
			vid.agregar(p1); 
		} catch (Exception e) {
			// Imprime el mensaje de error si salta la excepción
			System.out.println("Error al añadir duplicado: " + e.getMessage());
		}
		
		// 3. Busca una película por título parcial e imprime su ficha si se encuentra
		Pelicula encontrada = vid.buscarPorTitulo("OjO");
		if (encontrada != null) {
			System.out.println(encontrada.mostrarFicha());
		}
		
		// 4. Filtra por director e imprime las películas resultantes
		List<Pelicula> filtradas = vid.filtrarPorDirector("Alba");
		for (Pelicula p : filtradas) {
			System.out.println(p.mostrarFicha());
		}
	}
}