package repositories;

import java.util.List;

import es.ascender.biblioteca.negocio.Direccion;

public interface DireccionRepositories {
	
	List<Direccion> buscartodos();
	void insertar(Direccion direccion);
	void borrar(Direccion direccion);
	List<Direccion> buscarTodosOrdenados(String orden);
}


