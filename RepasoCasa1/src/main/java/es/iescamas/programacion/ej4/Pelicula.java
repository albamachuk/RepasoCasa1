package es.iescamas.programacion.ej4;

import es.iescamas.programacion.ej2.Catalogable;

public class Pelicula implements Catalogable {
	private String titulo;
	private String director;
	private int anyoEstreno;
	private int duracionMinutos;

	public Pelicula(String titulo, String director, int anyoEstreno, int duracionMinutos) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.anyoEstreno = anyoEstreno;
		this.duracionMinutos = duracionMinutos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	public int getAnyoEstreno() {
		return anyoEstreno;
	}

	public void setAnyoEstreno(int anyoEstreno) {
		this.anyoEstreno = anyoEstreno;
	}

	public String mostrarFicha() {
		return "[" + anyoEstreno + "]" + titulo + "—" + director + "(" + duracionMinutos + "min)";

	}

	@Override
	public String getCodigo() {
		getTitulo();
		/**
		 * substring (int beginIndex, int endIndex) para asi poder obtener las tres
		 * primeras letras indicando (donde empieza.el numero de caracteres q quieres q
		 * coja)
		 */
		String letras = getTitulo().substring(0, 3);
		return "PEL-" + anyoEstreno + " " + letras.toUpperCase();
	}

	@Override
	public void mostrarEnCatalogo() {
		System.out.println(mostrarFicha() + "[" + getCodigo() + "]");
	}
}
