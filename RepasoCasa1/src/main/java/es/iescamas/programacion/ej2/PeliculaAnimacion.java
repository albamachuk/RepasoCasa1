package es.iescamas.programacion.ej2;

public class PeliculaAnimacion extends Pelicula{

	private String estudio;
	
	public PeliculaAnimacion(String titulo, String director, int anyoEstreno, int duracionMinutos, String estudio) {
		super(titulo, director, anyoEstreno, duracionMinutos);
		this.estudio = estudio ;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public void mostrarEnCatalogo() {
		System.out.println(mostrarFicha() + "[" + getCodigo() + "] " + estudio);
	}
	
}
