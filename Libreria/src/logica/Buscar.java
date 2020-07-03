package logica;

import java.util.ArrayList;

public abstract class Buscar {
	//Atributos
	public Object[][] datosFilasBus;
	public ArrayList<Usuario> listaEncontrados = new ArrayList<Usuario>();
	public ArrayList<Libro> ListaEncontradosLib = new ArrayList<Libro>();
	public ArrayList<Integer> posiciones = new ArrayList<Integer>();
	
	//Constructor
	public Buscar(){
	}
	
	//Metodo abdtracto de busqueda
	public void realizarBusqueda(){
		
	}

}
