package logica;

import java.io.IOException;
import java.util.ArrayList;

public class BuscarLibro extends Buscar {

	// Metodo que realiza la busqueda
	public void realizarBusqueda(ArrayList<Libro> arrayBase, int critBusqueda, String busqueda)throws IOException{

		switch (critBusqueda) {
		// Si criterio de busqueda es el Titulo
		case 0:
			for (int i = 0; i < arrayBase.size(); i++) {
				// Si no encuentra una coincidencia devuelve un -1
				if (arrayBase.get(i).getTitulo().indexOf(busqueda) != -1) {
					// Se asigna el registro que coincide al arrayList de encontrados
					ListaEncontradosLib.add(arrayBase.get(i));
					// Se guarda esta posicion
					posiciones.add(i);
				}
			}
			break;
		// Si criterio de busqueda es Autor
		case 1:
			for (int i = 0; i < arrayBase.size(); i++) {
				// Si no encuentra una coincidencia devuelve un -1
				if (arrayBase.get(i).getAutor().indexOf(busqueda) != -1) {
					// Se asigna el registro que coincide al arrayList de encontrados
					ListaEncontradosLib.add(arrayBase.get(i));
					// Se guarda esta posicion
					posiciones.add(i);
				}
			}
			break;
			
		//Si criterio de busqueda es Publicacion
		case 2:
			for (int i = 0; i < arrayBase.size(); i++) {
				// Si no encuentra una coincidencia devuelve un -1
				if (arrayBase.get(i).getFecha().indexOf(busqueda) != -1) {
					// Se asigna el registro que coincide al arrayList de encontrados
					ListaEncontradosLib.add(arrayBase.get(i));
					// Se guarda esta posicion
					posiciones.add(i);
				}
			}
			break;
		}

		if (posiciones.size() == 0) {
			// JOptionPane.showMessageDialog(null, "No se encontraron
			// coincidencias!");
		} else {
			cargarDatosBus();
		}

	}

	// Metodo que carga los datos del ArrayList a al objeto datosFilasBus para
	// la tabla
	public void cargarDatosBus() {

		datosFilasBus = new Object[ListaEncontradosLib.size()][9];

		for (int i = 0; i < ListaEncontradosLib.size(); i++) {
			for (int j = 0; j < 8; j++) {
				datosFilasBus[i][j] = ListaEncontradosLib.get(i).getTitulo();
				datosFilasBus[i][j + 1] = ListaEncontradosLib.get(i).getAutor();
				datosFilasBus[i][j + 2] = ListaEncontradosLib.get(i).getFecha();
				datosFilasBus[i][j + 3] = ListaEncontradosLib.get(i).getPaginas();
				datosFilasBus[i][j + 4] = ListaEncontradosLib.get(i).getEditorial();
				datosFilasBus[i][j + 5] = ListaEncontradosLib.get(i).getDisponibles();
				datosFilasBus[i][j + 6] = ListaEncontradosLib.get(i).getId();
				datosFilasBus[i][j + 7] = ListaEncontradosLib.get(i).getImagen();
				datosFilasBus[i][j + 8] = ListaEncontradosLib.get(i).getPrestamos();
				j = 8;
			}
		}

		// table = new JTable(datosFilas, nombresCol);
		// scrollPaneJTable.setViewportView(table);
	}

	// Metodo que retorna un entero que representa la posicion del usuario a
	// borrar en el arrayList principal (Es decir ArrayList que contiene todos
	// los usuarios)
	public int borrarConBusqueda(int posBorrada) {

		return posiciones.get(posBorrada);

	}

}
