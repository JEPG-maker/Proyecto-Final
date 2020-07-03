package logica;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class AdministrarLibros {

	private String directorioArchivo = "src/bd/Libros.txt";
	public Object defaultData[][] = { {"", "", "", ""} };
	public Object[][] datosFilas;
	public Object[] nombresCol = { "TITULO", "AUTOR", "FECHA PUBLICACION", "PAGINAS", "EDITORIAL", "DISPONIBLES", "ID", "IMAGEN", "PRESTAMOS"};
	public ArrayList<Libro> listaLibros = new ArrayList<Libro>();

	// Atributos para metodo guardarUsuario

	// Constructor
	public AdministrarLibros() {
		
		leerDatos();
		cargarDatos();
		
	}

	//Metodo que lee el archivo y lo carga al ArrayList
	public void leerDatos(){
		try{
			//String palabra;
	        Scanner datos= new Scanner (new FileReader(directorioArchivo));
	        
	        //Mientras existan datos que leer
	        while(datos.hasNext()){
		        //palabra = datos.next();
		        listaLibros.add(new Libro(String.valueOf(datos.next()).replace("_", " "),
	        						    String.valueOf(datos.next()).replace("_", " "),
	        						    String.valueOf(datos.next()),
	        						    Integer.parseInt(String.valueOf(datos.next())),
		        					    String.valueOf(datos.next()).replace("_", " "),
	        						    Integer.parseInt(String.valueOf(datos.next())),
	        						    Integer.parseInt(String.valueOf(datos.next())),
	        						    String.valueOf(datos.next()),
	        						    Integer.parseInt(String.valueOf(datos.next()))));
	        }
	        //Cierra el archivo
	        datos.close();
	        
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "ERROR: Ocurrio un problema cargar datos de los Usuarios! " + e.getMessage());
		}
		

		
	}
	
	// Metodo que agrega un libro al arrayList y luego guarda el archivo
	public void agregarLibro(Libro lib) throws IOException {
		
		//Se agrega el usuario al arrayList
		listaLibros.add(lib);
		//Se guarda el array list al archivo
		guardarArrayList();
		JOptionPane.showMessageDialog(null, "Libro registrado correctamente!");

	}

	//Metodo que guarda el arrayLists en el archivo
	public void guardarArrayList() throws IOException{
		
		try {
			BufferedWriter escribirArc = new BufferedWriter(new FileWriter(directorioArchivo));
			
			for(int i=0; i<listaLibros.size(); i++){

				// Se esciben los datos uno a uno en el archivo
				escribirArc.write(listaLibros.get(i).getTitulo().replace(" ", "_") + " ");
				escribirArc.write(listaLibros.get(i).getAutor().replace(" ", "_") + " ");
				escribirArc.write(listaLibros.get(i).getFecha() + " ");
				escribirArc.write(listaLibros.get(i).getPaginas() + " ");
				escribirArc.write(listaLibros.get(i).getEditorial().replace(" ", "_") + " ");
				escribirArc.write(listaLibros.get(i).getDisponibles() + " ");
				escribirArc.write(listaLibros.get(i).getId() + " ");
				escribirArc.write(listaLibros.get(i).getImagen() + " ");
				escribirArc.write(listaLibros.get(i).getPrestamos() + " ");
				escribirArc.newLine(); // inserta nueva linea.	
			}
			
			escribirArc.close(); // cierra archivo

		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR: Ocurrio un problema al salvar el archivo de Libros! " + e.getMessage());
		}
	
	}
	
	//Metodo que carga los datos del ArrayList a al objeto datosFilas para la tabla
	public void cargarDatos(){
				
		datosFilas = new Object[listaLibros.size()][9];
		
		for(int i=0; i<listaLibros.size(); i++){
			for(int j=0; j<8; j++){
				datosFilas[i][j] = listaLibros.get(i).getTitulo();
				datosFilas[i][j+1] = listaLibros.get(i).getAutor();
				datosFilas[i][j+2] = listaLibros.get(i).getFecha();
				datosFilas[i][j+3] = listaLibros.get(i).getPaginas();
				datosFilas[i][j+4] = listaLibros.get(i).getEditorial();
				datosFilas[i][j+5] = listaLibros.get(i).getDisponibles();
				datosFilas[i][j+6] = listaLibros.get(i).getId();
				datosFilas[i][j+7] = listaLibros.get(i).getImagen();
				datosFilas[i][j+8] = listaLibros.get(i).getPrestamos();
				j=8;
			}
		}
			
			//table = new JTable(datosFilas, nombresCol);
			//scrollPaneJTable.setViewportView(table);	
	}
	
	//Metodo que guarda la tabla en el archivo
	public void guardarTabla(JTable table){
        try {

            BufferedWriter escribirArc = new BufferedWriter(new FileWriter(directorioArchivo));

            for (int i = 0 ; i < table.getRowCount(); i++) //realiza un barrido por filas.
            {
                for(int j = 0 ; j < table.getColumnCount();j++) //realiza un barrido por columnas.
                {
                	escribirArc.write(String.valueOf((table.getValueAt(i,j))).replace(" ", "_"));
                    if (j < table.getColumnCount() -1) { //agrega separador un espacio " " si no es el ultimo elemento de la fila.
                    	escribirArc.write(" ");
                    }
                }
                escribirArc.newLine(); //inserta nueva linea.
            }

            escribirArc.close(); //cierra archivo!
            
            JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente!");
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null, "ERROR: Ocurrio un problema al salvar el archivo! " + e.getMessage());
        }
    }

	//Metodo que modifica el arrayList basado en los elementos del ArayList de la busqueda
	public void guardarConBusqueda(JTable table, ArrayList<Integer> posBus){
		
		for (int i=0; i<posBus.size(); i++){
			
			try{
				//listaLibros.set(posBus.get(i), busq.get(i));
				listaLibros.get(posBus.get(i)).setTitulo(String.valueOf(table.getValueAt(i,0)).replace(" ", "_"));
				listaLibros.get(posBus.get(i)).setAutor(String.valueOf(table.getValueAt(i,1)).replace(" ", "_"));
				listaLibros.get(posBus.get(i)).setFecha(String.valueOf(table.getValueAt(i,2)));
				listaLibros.get(posBus.get(i)).setPaginas(Integer.parseInt(String.valueOf(table.getValueAt(i,3))));
				listaLibros.get(posBus.get(i)).setEditorial(String.valueOf(table.getValueAt(i,4)).replace(" ", "_"));
				listaLibros.get(posBus.get(i)).setDisponibles(Integer.parseInt((String.valueOf(table.getValueAt(i,5)))));
				listaLibros.get(posBus.get(i)).setId(Integer.parseInt(String.valueOf(table.getValueAt(i,6))));
				listaLibros.get(posBus.get(i)).setImagen(String.valueOf(table.getValueAt(i,7)));
				listaLibros.get(posBus.get(i)).setPrestamos(Integer.parseInt((String.valueOf(table.getValueAt(i,8)))));
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Los datos modificados no son validos!");
			}
			
			
		}
		
	}

}
