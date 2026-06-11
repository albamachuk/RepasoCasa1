package es.iescamas.programacion.ej1;

public class Main {
	public static void main(String[] args) {
		Pelicula p1 = new Pelicula("PingÜino", "Alba", 2004, 60);
		Pelicula p2 = new Pelicula("Orca", "Pedro", 2007, 80);

		System.out.println(p1.mostrarFicha());
		System.out.println(p2.mostrarFicha());

		if (p1.getDuracionMinutos() > p2.getDuracionMinutos()) {
			System.out.println(p1.getTitulo() + " es mayor que" + p2.getTitulo());
		} else if (p1.getDuracionMinutos() < p2.getDuracionMinutos()) {
			System.out.println(p2.getTitulo() + " es mayor que " + p1.getTitulo());
		} else {
			System.out.println("misma duracion");
		}
		Pelicula[] peli = { p1, p2 };
		for (Pelicula p : peli) {
			if (p.getDuracionMinutos() < 60) {
				System.out.println(p.getTitulo() + " - Cortometraje");
			} else if (p.getDuracionMinutos() >= 60 && p.getDuracionMinutos() <= 90) {
				System.out.println(p.getTitulo() + " - Película corta");
			} else if (p.getDuracionMinutos() >= 91 && p.getDuracionMinutos() < 120) {
				System.out.println(p.getTitulo() + " - Duracion estandar");
			} else {
				System.out.println(p.getTitulo() + " - Película larga");
			}

		}
	}
}
