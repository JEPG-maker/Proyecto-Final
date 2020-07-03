package logica;

import java.io.IOException;
import java.util.ArrayList;

public class BuscarUsuario extends Buscar {

	// Metodo que realiza la busqueda
	public void realizarBusqueda(ArrayList<Usuario> arrayBase, int critBusqueda, String busqueda)throws IOException{

		switch (critBusqueda) {
		// Si criterio de busqueda es el Nombre
		case 0:
			for (int i = 0; i < arrayBase.size(); i++) {
				// Si no encuentra una coincidencia devuelve un -1
				if (arrayBase.get(i).getNombre().indexOf(busqueda) != -1) {
					// Se asigna el registro que coincide al arrayList de encontrados
					listaEncontrados.add(arrayBase.get(i));
					// Se guarda esta posicion
					posiciones.add(i);
				}
			}
			break;
		// Si criterio de busqueda es cedula
		case 1:
			for (int i = 0; i < arrayBase.size(); i++) {
				// Si no encuentra una coincidencia devuelve un -1
				if (arrayBase.get(i).getCedula() == busqueda) {
					// Se asigna el registro que coincide al arrayList de encontrados
					listaEncontrados.add(arrayBase.get(i));
					// Se guarda esta posicion
					posiciones.add(i);
				}
			}
			break;
			
		//Si criterio de busqueda es nivel
		case 2:
			for (int i = 0; i < arrayBase.size(); i++) {
				// Si no encuentra una coincidencia devuelve un -1
				if (arrayBase.get(i).getNivel() == Integer.parseInt(busqueda)) {
					// Se asigna el registro que coincide al arrayList de encontrados
					listaEncontrados.add(arrayBase.get(i));
					// Se guarda esta posicion
					posiciones.add(i);
				}
			}
			break;
		// Si criterio de busqueda es el Username
		case 3:
			for (int i = 0; i < arrayBase.size(); i++) {
				// Si no encuentra una coincidencia devuelve un -1
				if (arrayBase.get(i).getUsername().indexOf(busqueda) != -1) {
					// Se asigna el registro que coincide al arrayList de encontrados
					listaEncontrados.add(arrayBase.get(i));
					// Se guarda esta posicion
					posiciones.add(i);
				}
			}
			break;
		//Si criterio de busqueda es edad
		case 4:
			for (int i = 0; i < arrayBase.size(); i++) {
				// Si no encuentra una coincidencia devuelve un -1
				if (arrayBase.get(i).getEdad() == Integer.parseInt(busqueda)) {
					// Se asigna el registro que coincide al arrayList de encontrados
					listaEncontrados.add(arrayBase.get(i));
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

		datosFilasBus = new Object[listaEncontrados.size()][8];

		for (int i = 0; i < listaEncontrados.size(); i++) {
			for (int j = 0; j < 8; j++) {
				datosFilasBus[i][j] = listaEncontrados.get(i).getNombre();
				datosFilasBus[i][j + 1] = listaEncontrados.get(i).getCedula();
				datosFilasBus[i][j + 2] = listaEncontrados.get(i).getTelefono();
				datosFilasBus[i][j + 3] = listaEncontrados.get(i).getDireccion();
				datosFilasBus[i][j + 4] = listaEncontrados.get(i).getEdad();
				datosFilasBus[i][j + 5] = listaEncontrados.get(i).getNivel();
				datosFilasBus[i][j + 6] = listaEncontrados.get(i).getUsername();
				datosFilasBus[i][j + 7] = listaEncontrados.get(i).getPassword();
				j = 7;
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
