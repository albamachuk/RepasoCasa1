package es.iescamas.programacion.ej1;

public class Pelicula {
private String titulo;
private String director;
private int anyoEstreno;
private int duracionMinutos;

public Pelicula (String titulo,String director,int anyoEstreno, int duracionMinutos) {
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
}
