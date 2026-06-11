package es.iescamas.programacion.ej4;

import java.util.ArrayList;
import java.util.List;

public class Videoteca implements Gestionable<Pelicula>{

	ArrayList<Pelicula> Lista;
	
	public Videoteca(ArrayList<Pelicula> Lista) {
		super();
		this.Lista = Lista;
	}
	
	@Override
	public void agregar(Pelicula elemento) {
		for(Pelicula p : Lista) {
			if(p.getTitulo().equalsIgnoreCase(elemento.getTitulo())) {
				//IllegalArgumentException(Throwable cause)
				throw new IllegalArgumentException("Ya esta añadida");
			}
			
		}
		Lista.add(elemento);
	}

	@Override
	public boolean eliminar(Pelicula elemento) {
		for(Pelicula p : Lista) {
			if(p.getTitulo().equalsIgnoreCase(elemento.getTitulo())) {
				Lista.remove(p);
				return true;
			}
		}
		return false;
	}

	@Override
	public Pelicula buscarPorTitulo(String titulo) {
		for(Pelicula p : Lista) {
			if(p.getTitulo().equalsIgnoreCase(titulo)){
				System.out.println(p.mostrarFicha());
				return p;
				
			}
		}
		return null;
	}

	@Override
	public void mostrarTodos() {
		for(Pelicula p : Lista) {
			p.mostrarFicha();
		}
	}
	
	
		public List<Pelicula> filtrarPorDirector(String director){
			ArrayList<Pelicula> filtro = new ArrayList<Pelicula>();
			for(Pelicula p : Lista) {
				if(p.getDirector().equalsIgnoreCase(director)) {
					filtro.add(p);
				}
			}
			for(Pelicula p : filtro) {
				System.out.println(p.mostrarFicha());
			}
			return filtro;
		}	
	

	public	List<Pelicula> getPeliculas(){
		return this.Lista;
		
	}
		
		
}














