package logica;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Prestamo {
	
	//Atributos
	public ArrayList<Prestamo> controlPres = new ArrayList<Prestamo>();
	public AdministrarLibros infoLibros = new AdministrarLibros();
	private String directorioArchivo = "src/bd/Prestamos.txt";
	
	private String cedula;
	private String idLib;
	
	public Prestamo(String cedula, String idLib) {
		super();
		this.cedula = cedula;
		this.idLib = idLib;

	}
	
	//Metodos set y get
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getIdLib() {
		return idLib;
	}

	public void setIdLib(String idLib1) {
		this.idLib = idLib1;
	}
	
	//metodo que valida disponibilidad y realiza el prestamo si es posible
	public void disponibilidad(String cedula, String idLibro) throws IOException{
		
		//Si el retorno es verdadero se presta el libro
		if(controlPrestamos(cedula, idLibro)){
			//Obtiene la cantidad disponible
			int disponibles = infoLibros.listaLibros.get(Integer.parseInt(idLibro)).getDisponibles();
			
			//Si es mayor a 0 prestara el libro
			if(disponibles > 0){
				//Descontara un diponible
				infoLibros.listaLibros.get(Integer.parseInt(idLibro)).setDisponibles(disponibles-1);
				
				//Registrara el pretamo
				int prestamos = infoLibros.listaLibros.get(Integer.parseInt(idLibro)).getPrestamos();
				infoLibros.listaLibros.get(Integer.parseInt(idLibro)).setPrestamos(prestamos+1);
				
				//Guarda el el array (prestamo)
				infoLibros.guardarArrayList();
				
			}else{
				JOptionPane.showMessageDialog(null, "Lo sentimos, no hay copias disponibles!");
			}
		}
		
	}
	
	//Permitira almacenar y cargar prestamos
	public boolean controlPrestamos(String cedula, String idLib){
		
		int pos = -1;
		cargarDatosPres();
		
		//Se busca el usuario en los prestamos
		for (int i=0; i<controlPres.size(); i++){
			if(controlPres.get(i).cedula.indexOf(cedula) != -1){
				pos = i;
			}
		}
		
		//Si no se encontro se agrega a arraylist
		if(pos != -1){
			controlPres.add(new Prestamo(cedula, idLib));
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "Lo sentimos, Usted tiene un prestamo actualmente!");
			return false;
		}
		
	}
	
	//Metodo carga los datos al arrayList
	public void cargarDatosPres(){
		
		try{
			//String palabra;
	        Scanner datos= new Scanner (new FileReader(directorioArchivo));
	        
	        //Mientras existan datos que leer
	        while(datos.hasNext()){
		        //palabra = datos.next();
		        controlPres.add(new Prestamo(String.valueOf(datos.next()),
	        						    String.valueOf(datos.next())));
	        }
	        //Cierra el archivo
	        datos.close();
	        
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "ERROR: Ocurrio un problema cargar datos de los Usuarios! " + e.getMessage());
		}
	}
	
}
