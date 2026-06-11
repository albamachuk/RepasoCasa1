package es.iescamas.programacion.ej3;

public interface Gestionable<T> {

	public void agregar(T elemento);
	public boolean eliminar(T elemento);
	public T buscarPorTitulo(String titulo);
	public void mostrarTodos();

}
