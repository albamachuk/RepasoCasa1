package es.iescamas.programacion.ej2;

public class Main {
	public static void main (String[]args) {

		PeliculaAnimacion p1 = new PeliculaAnimacion ("PingÜino", "Alba",2004, 60, "Disney");
		Pelicula p2 = new Pelicula ("Orca", "Pedro",2007, 80);
		Catalogable[] pelis = {p1, p2};
		
		for (Catalogable p : pelis) {
			p.mostrarEnCatalogo();
		}
		
	}
	/* * OOP
	 * Este apartado demuestra el concepto de POLIMORFISMO (específicamente 
	 * a través de interfaces). 
	 * Permite almacenar objetos de clases distintas ('Pelicula' y 'PeliculaAnimacion') 
	 * dentro de un mismo contenedor común ('Catalogable[]'). 
	 * Al recorrer el array, Java sabe dinámicamente qué comportamiento ejecutar 
	 * para 'mostrarEnCatalogo()' dependiendo del tipo de objeto real que esté 
	 * analizando en ese momento, sin necesidad de saber su clase exacta.
	 */
	
}
