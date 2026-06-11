package es.iescamas.programacion.ej4;

import java.util.ArrayList;
import java.util.Comparator; 
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble; 
import java.util.stream.Collectors; 

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
	//4. a)	
		
		List<Pelicula> pelis = vid.getPeliculas();
		for (int i = 0; i < pelis.size(); i++) {
			System.out.println(pelis.get(i).getTitulo());
		}
		
		for (Pelicula p : pelis) {
			System.out.println(p.getTitulo());
		}
		
		Iterator<Pelicula> it = pelis.iterator();
	/**it.hasNext(), devuelve true si todavia quedan pelis por leer 
	 * o false si lega al final y no quedan mas para leer
	 */
		while (it.hasNext()) {
			Pelicula p = it.next();
			System.out.println(p.getTitulo());
		}
		
		/* * COMENTARIO:
		 * Es preferible usar 'Iterator' frente a un 'for-each' cuando necesitamos 
		 * MODIFICAR la lista mientras la recorremos (por ejemplo, eliminar elementos 
		 * usando 'it.remove()'). 
		 * Si intentamos borrar un elemento dentro de un 'for-each', Java lanzará un 
		 * error de ejecución llamado 'ConcurrentModificationException'. El Iterator 
		 * evita este problema de forma segura.
		 */
		
		//4. b)	
		
		System.out.println("Elimino peliculas de menos de 90 min-");

		Iterator<Pelicula> itEliminar = pelis.iterator();
		while (itEliminar.hasNext()) {
			Pelicula p = itEliminar.next();
			if (p.getDuracionMinutos() < 90) {
				itEliminar.remove(); 
				System.out.println("Eliminada: " + p.getTitulo());
			}
		}

		System.out.println("Lista final");
		for (Pelicula p : pelis) {
			System.out.println(p.mostrarFicha());
		}
		//4. c)	
		
		// 1. Filtrar las películas estrenadas a partir del año 2000 e imprimir sus títulos
		System.out.println("Pelis estrenadas a partir del 2000");
		pelis.stream()
			 .filter(p -> p.getAnyoEstreno() >= 2000) 
			 .forEach(p -> System.out.println(p.getTitulo()));

		// 2. Obtener un List<String> con los títulos en mayúsculas e imprimirlo
		System.out.println("Listas de titulos en mayusculas");
		List<String> titulosMayusculas = pelis.stream()
											  .map(p -> p.getTitulo().toUpperCase())
											  .collect(Collectors.toList());
		System.out.println(titulosMayusculas);

		// 3. Calcular la duración media de todas las películas e imprimirla
		System.out.println("Duracion media de todas las peliculas");
		OptionalDouble media = pelis.stream()
									.mapToInt(p -> p.getDuracionMinutos())
									.average();
		if (media.isPresent()) {
			System.out.println("La duración media es: " + media.getAsDouble() + " minutos");
		} else {
			System.out.println("No hay películas para calcular la media");
		}

		// 4. Ordenar las películas por año de mayor a menor, recogerlas en una nueva lista e imprimir fichas
		System.out.println("Orden por año (de mayor a menor) ");
		List<Pelicula> ordenadasPorAnio = pelis.stream()
											   .sorted(Comparator.comparingInt(Pelicula::getAnyoEstreno).reversed())
											   .collect(Collectors.toList());
		
		ordenadasPorAnio.forEach(p -> System.out.println(p.mostrarFicha()));
	
		//4. d)	
		
		System.out.println("Compruebo películas largas (> 120 min)");
		
		// Evaluo directamente el stream en el if
		if (pelis.stream().anyMatch(p -> p.getDuracionMinutos() > 120)) {
			System.out.println("Hay películas largas");
		} else {
			System.out.println("No hay películas largas");
		}		
	} 
}