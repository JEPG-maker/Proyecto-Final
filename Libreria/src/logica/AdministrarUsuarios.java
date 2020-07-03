package logica;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class AdministrarUsuarios{
	
	private String directorioArchivo = "src/bd/Usuarios.txt";
	public Object defaultData[][] = { {"", "", "", ""} };
	public Object[][] datosFilas;
	public Object[] nombresCol = { "NOMBRE", "CEDULA", "TELEFONO", "DIRECCION","EDAD","NIVEL ACCESO","USUARIO","CONTRASEÑA"};
	public ArrayList<Usuario> listaUser = new ArrayList<Usuario>();

	// Atributos para metodo guardarUsuario

	// Constructor
	public AdministrarUsuarios() {
		
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
		        listaUser.add(new Usuario(String.valueOf(datos.next()).replace("_", " "),
		        						  String.valueOf(datos.next()),
		        						  String.valueOf(datos.next()),
		        						  String.valueOf(datos.next().replace("_", " ")),
		        						  Integer.parseInt(String.valueOf(datos.next())),
		        						  Integer.parseInt(String.valueOf(datos.next())),
		        					      String.valueOf(datos.next()),
		        					      String.valueOf(datos.next())));
	        }
	        //Cierra el archivo
	        datos.close();
	        
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "ERROR: Ocurrio un problema cargar datos de los Usuarios! " + e.getMessage());
		}
		

		
	}
	
	// Metodo que agrega un usuario al arrayList y luego guarda el archivo
	public void agregarUsuario(Usuario user) throws IOException {
		
		//Se agrega el usuario al arrayList
		listaUser.add(user);
		//Se guarda el array list al archivo
		guardarArrayList();
		JOptionPane.showMessageDialog(null, "Usuario registrado correctamente!");

	}

	//Metodo que guarda el arrayLists en el archivo
	public void guardarArrayList() throws IOException{
		
		try {
			BufferedWriter escribirArc = new BufferedWriter(new FileWriter(directorioArchivo));
			
			for(int i=0; i<listaUser.size(); i++){

				// Se esciben los datos uno a uno en el archivo
				escribirArc.write(listaUser.get(i).getNombre().replace(" ", "_") + " ");
				escribirArc.write(listaUser.get(i).getCedula() + " ");
				escribirArc.write(listaUser.get(i).getTelefono() + " ");
				escribirArc.write(listaUser.get(i).getDireccion().replace(" ", "_") + " ");
				escribirArc.write(listaUser.get(i).getEdad() + " ");
				escribirArc.write(listaUser.get(i).getNivel() + " ");
				escribirArc.write(listaUser.get(i).getUsername() + " ");
				escribirArc.write(listaUser.get(i).getPassword() + " ");
				escribirArc.newLine(); // inserta nueva linea.	
			}
			
			escribirArc.close(); // cierra archivo

		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR: Ocurrio un problema al salvar el archivo de Usuarios! " + e.getMessage());
		}

		
	}
	
	//Metodo que carga los datos del ArrayList a al objeto datosFilas para la tabla
	public void cargarDatos(){
				
		datosFilas = new Object[listaUser.size()][8];
		
		for(int i=0; i<listaUser.size(); i++){
			for(int j=0; j<8; j++){
				datosFilas[i][j] = listaUser.get(i).getNombre();
				datosFilas[i][j+1] = listaUser.get(i).getCedula();
				datosFilas[i][j+2] = listaUser.get(i).getTelefono();
				datosFilas[i][j+3] = listaUser.get(i).getDireccion();
				datosFilas[i][j+4] = listaUser.get(i).getEdad();
				datosFilas[i][j+5] = listaUser.get(i).getNivel();
				datosFilas[i][j+6] = listaUser.get(i).getUsername();
				datosFilas[i][j+7] = listaUser.get(i).getPassword();
				j=7;
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
				//listaUser.set(posBus.get(i), busq.get(i));
				listaUser.get(posBus.get(i)).setNombre(String.valueOf(table.getValueAt(i,0)).replace(" ", "_"));
				listaUser.get(posBus.get(i)).setCedula(String.valueOf(Long.parseLong((String) table.getValueAt(i,1))));
				listaUser.get(posBus.get(i)).setTelefono(String.valueOf(Long.parseLong((String) table.getValueAt(i,2))));
				listaUser.get(posBus.get(i)).setDireccion(String.valueOf(table.getValueAt(i,3)));
				listaUser.get(posBus.get(i)).setEdad(Integer.parseInt((String.valueOf(table.getValueAt(i,4)))));
				listaUser.get(posBus.get(i)).setNivel(Integer.parseInt((String.valueOf(table.getValueAt(i,5)))));
				listaUser.get(posBus.get(i)).setUsername(String.valueOf(table.getValueAt(i,6)));
				listaUser.get(posBus.get(i)).setPassword(String.valueOf(table.getValueAt(i,7)));
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Los datos modificados no son validos!");
			}
			
			
		}
		
	}

}
