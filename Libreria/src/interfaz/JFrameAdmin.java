package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import logica.AdministrarLibros;
import logica.AdministrarUsuarios;
import logica.BuscarLibro;
import logica.BuscarUsuario;
import logica.Libro;
import logica.Usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class JFrameAdmin extends JFrame implements ActionListener{
	
	/**Atributos**/
	Usuario user;
	AdministrarUsuarios adminUser;
	BuscarUsuario buscarUser;
	public boolean busco = false;
	
	Libro lib;
	AdministrarLibros adminLibros;
	BuscarLibro buscarLibro;
	public boolean buscoLib = false;

	private JPanel panelPrincipalAdmin;
	private JPanel panelOpcionesAdmin;
	private JPanel panelAux;
	
	/**Componentes panel opciones**/
	private JButton btnGestionDeUsuarios;
	private JButton btnGestionDeInventario;
	private JButton btnCerrarSesion;
	
	//Label logo
	private JLabel lblLogo;

	//Panel Gestion Usuarios
	private JTabbedPane tbpGestionUsuarios;
	private JPanel panelAgregarUsuario;
	private JPanel panelVerUsuarios;
	private JLabel lblImgUsuario;
	private JLabel lblAgregarUsuario;
	private JLabel lblNombre;
	private JLabel lblUsername;
	private JLabel lblContrasea;
	private JLabel lblCedula;
	private JLabel lblTelefono;
	private JLabel lblDireccion;
	private JLabel lblEdad;
	private JTextField txtIngNombre;
	private JTextField txtIngUsername;
	private JTextField txtIngPassword;
	private JTextField txtIngCedula;
	private JTextField txtIngTelefono;
	private JTextField txtIngDireccion;
	private JTextField txtIngEdad;
	private JComboBox<String> cbxAcceso;
	private JLabel lblAcceso;
	private JButton btnGuardarUsuario;
	private JButton btnLimpiarDatos;
	
	private JLabel lblImgUsuarios;
	private JLabel lblUsuarios;
	private JScrollPane scrollPaneJTable;
	private JTable table;
	private JButton btnBorrar;
	private JButton btnGuardar;
	private JLabel lblBuscar;
	private JLabel lblBuscarPor;
	private JComboBox<String> cbxBuscarPor;
	private JTextField txtIngresoBusqueda;
	private JButton btnBuscar;
	
	//Panel Gestion Usuarios
	private JTabbedPane tbpGestionInventario;
	private JPanel panelAgregarLibro;
	private JPanel panelVerLibros;
	private JLabel lblImgLibro;
	private JLabel lblAgregarLibro;
	private JLabel lblTitulo;
	private JLabel lblPublicacion;
	private JLabel lblEditorial;
	private JLabel lblId;
	private JLabel lblAutor;
	private JLabel lblPaginas;
	private JLabel lblDisponibles;
	private JLabel lblPrestamos;
	private JTextField txtIngTitulo;
	private JTextField txtIngPublicacion;
	private JTextField txtIngEditorial;
	private JTextField txtIngId;
	private JTextField txtIngAutor;
	private JTextField txtIngPaginas;
	private JTextField txtIngDisponibles;
	private JTextField txtIngImagen;
	private JTextField txtIngPrestamos;
	private JLabel lblImagen;
	private JButton btnGuardarLibro;
	private JButton btnLimpiarDatosLib;
	
	private JLabel lblImgLibros;
	private JLabel lblLibros;
	private JScrollPane scrollPaneJTableLib;
	private JTable tableLib;
	private JButton btnBorrarLib;
	private JButton btnGuardarLib;
	private JLabel lblBuscarLib;
	private JLabel lblBuscarPorLib;
	private JComboBox<String> cbxBuscarPorLib;
	private JTextField txtIngresoBusquedaLib;
	private JButton btnBuscarLib;
	private JLabel lblImgbuscar;




	/**
	 * Create the frame.
	 */
	public JFrameAdmin() {
		
		//Se hace uso la clase AdministrarUsuarios para cargar los datos de los usuario
		adminUser = new AdministrarUsuarios();
		adminLibros = new AdministrarLibros();
		
		setTitle("BooKTIC - Administrador ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		panelPrincipalAdmin = new JPanel();
		panelPrincipalAdmin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipalAdmin);
		panelPrincipalAdmin.setLayout(null);
		
		panelOpcionesAdmin = new JPanel();
		panelOpcionesAdmin.setBounds(12, 13, 201, 527);
		panelPrincipalAdmin.add(panelOpcionesAdmin);
		panelOpcionesAdmin.setLayout(null);
		
		btnGestionDeUsuarios = new JButton("<html><CENTER>Gestion</CENTER><CENTER>De</CENTER><CENTER>Usuario</CENTER></html>");
		btnGestionDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGestionDeUsuarios.setBounds(27, 91, 144, 55);
		btnGestionDeUsuarios.addActionListener(this);
		panelOpcionesAdmin.add(btnGestionDeUsuarios);
		
		btnGestionDeInventario = new JButton("<html><CENTER>Gestion</CENTER><CENTER>De</CENTER><CENTER>Inventario</CENTER></html>");
		btnGestionDeInventario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGestionDeInventario.setBounds(27, 237, 144, 55);
		btnGestionDeInventario.addActionListener(this);
		panelOpcionesAdmin.add(btnGestionDeInventario);
		
		btnCerrarSesion = new JButton("<html><CENTER>Cerrar</CENTER><CENTER>Sesión</CENTER></html>");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesion.setBounds(27, 383, 144, 50);
		panelOpcionesAdmin.add(btnCerrarSesion);
		
		panelAux = new JPanel();
		panelAux.setBounds(225, 13, 545, 527);
		panelPrincipalAdmin.add(panelAux);
		panelAux.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(JFrameAdmin.class.getResource("/imagenes/logo.png")));
		lblLogo.setBounds(12, 13, 521, 501);
		panelAux.add(lblLogo);
		
		//panelGestionUsuarios();
		//panelGestionInventario();
		
	}

	//Manejo de los eventos
	public void actionPerformed(ActionEvent event) {
		
		//Evento boton Gestion de Usuarios
		if(event.getSource() == btnGestionDeUsuarios){
			panelAux.removeAll();
			panelGestionUsuarios();
			panelAux.revalidate();
			panelAux.repaint();
		}
		//Evento boton Guardar Usuario
		if(event.getSource() == btnGuardarUsuario){
			enviarDatos();
			//se cargan de nuevo los datos
			adminUser.listaUser.clear();
			adminUser.leerDatos();
			adminUser.cargarDatos();
			//
			table = new JTable(adminUser.datosFilas, adminUser.nombresCol);
			scrollPaneJTable.setViewportView(table);
			table.setColumnSelectionAllowed(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tamColumnas();
		}
		//Evento boton Limpiar
		if(event.getSource() == btnLimpiarDatos){
			limpiarDatos();
		}
		
		//Evento boton Borrar
		if(event.getSource() == btnBorrar){
			int pos;
			//Se obtiene la fila seleccionada
			pos = table.getSelectedRow();
			
			if(busco){
				//Borra la el usuario en la posicion que retorne el metodo borrarConBusqueda
				adminUser.listaUser.remove(buscarUser.borrarConBusqueda(pos));
				busco=false;
			}else{
				//Se borra la fila seleccionada segun la posicion del ArrayList
				adminUser.listaUser.remove(pos);
			}
			
			adminUser.cargarDatos();
			table = new JTable(adminUser.datosFilas, adminUser.nombresCol);
			scrollPaneJTable.setViewportView(table);
			table.setColumnSelectionAllowed(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tamColumnas();
				
		}
		
		//Evento boton Guardar
		if(event.getSource() == btnGuardar){
			if(busco){
				//Se reinicia booleano buscar
				busco = false;
				adminUser.guardarConBusqueda(table, buscarUser.posiciones);
				try {
					adminUser.guardarArrayList();
					
					JOptionPane.showMessageDialog(null, "Datos guardados correctamente!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}else{
				adminUser.guardarTabla(table);
				adminUser.listaUser.clear();
				adminUser.leerDatos();
			}
			//Cargar datos nuevamente
			adminUser.cargarDatos();
			table = new JTable(adminUser.datosFilas, adminUser.nombresCol);
			scrollPaneJTable.setViewportView(table);
			table.setColumnSelectionAllowed(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tamColumnas();
				
		}
		
		//Evento boton Buscar
		if(event.getSource() == btnBuscar){	
			//Booleano buscar se vuelve true para saber que se hizo una busqueda (esto para luego al guardar hacerlo basado en las busquedas)
			busco = true;
			
			buscarUser = new BuscarUsuario();

				try {
					buscarUser.realizarBusqueda(adminUser.listaUser, cbxBuscarPor.getSelectedIndex(), txtIngresoBusqueda.getText());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Busqueda no valida!");
				}

			//Si no se encuentran coincidencia se arroja mensaje, de lo contrario se carga la tabla con las coincidencias
			if(buscarUser.posiciones.size() == 0){
				JOptionPane.showMessageDialog(null, "No se encontraron coincidencias!");
			}else{
				table = new JTable(buscarUser.datosFilasBus, adminUser.nombresCol);
				scrollPaneJTable.setViewportView(table);
				table.setColumnSelectionAllowed(true);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tamColumnas();
			}
		}
		
		
		//---------------------------------------------------------------
		//Evento boton Gestion de Libros
		if(event.getSource() == btnGestionDeInventario){
			panelAux.removeAll();
			panelGestionInventario();
			panelAux.revalidate();
			panelAux.repaint();
		}
		//Evento boton Guardar Libro
		if(event.getSource() == btnGuardarLibro){
			enviarDatosLib();
			//se cargan de nuevo los datos
			adminLibros.listaLibros.clear();
			adminLibros.leerDatos();
			adminLibros.cargarDatos();
			//
			tableLib = new JTable(adminLibros.datosFilas, adminLibros.nombresCol);
			scrollPaneJTableLib.setViewportView(tableLib);
			tableLib.setColumnSelectionAllowed(true);
			tableLib.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tamColumnasLib();
		}
		//Evento boton Limpiar datos libro
		if(event.getSource() == btnLimpiarDatosLib){
			limpiarDatosLib();
		}
		//Evento boton Borrar Libro
		if(event.getSource() == btnBorrarLib){
			int pos;
			//Se obtiene la fila seleccionada
			pos = tableLib.getSelectedRow();
			
			if(buscoLib){
				//Borra la el libro en la posicion que retorne el metodo borrarConBusqueda
				adminLibros.listaLibros.remove(buscarLibro.borrarConBusqueda(pos));
				buscoLib=false;
			}else{
				//Se borra la fila seleccionada segun la posicion del ArrayList
				adminLibros.listaLibros.remove(pos);
			}
			
			adminLibros.cargarDatos();
			tableLib = new JTable(adminLibros.datosFilas, adminLibros.nombresCol);
			scrollPaneJTableLib.setViewportView(tableLib);
			tableLib.setColumnSelectionAllowed(true);
			tableLib.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tamColumnasLib();
				
		}
		//Evento boton Guardar
		if(event.getSource() == btnGuardarLib){
			if(buscoLib){
				//Se reinicia booleano buscar
				buscoLib = false;
				adminLibros.guardarConBusqueda(tableLib, buscarLibro.posiciones);
				try {
					adminLibros.guardarArrayList();
					
					JOptionPane.showMessageDialog(null, "Datos guardados correctamente!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}else{
				adminLibros.guardarTabla(tableLib);
				adminLibros.listaLibros.clear();
				adminLibros.leerDatos();
			}
			//Cargar datos nuevamente
			adminLibros.cargarDatos();
			tableLib = new JTable(adminLibros.datosFilas, adminLibros.nombresCol);
			scrollPaneJTableLib.setViewportView(tableLib);
			tableLib.setColumnSelectionAllowed(true);
			tableLib.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tamColumnasLib();
				
		}
		
		//Evento boton Buscar
		if(event.getSource() == btnBuscarLib){	
			//Booleano buscar se vuelve true para saber que se hizo una busqueda (esto para luego al guardar hacerlo basado en las busquedas)
			buscoLib = true;
			
			buscarLibro = new BuscarLibro();

				try {
					buscarLibro.realizarBusqueda(adminLibros.listaLibros, cbxBuscarPorLib.getSelectedIndex(), txtIngresoBusquedaLib.getText());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Busqueda no valida!");
				}

			//Si no se encuentran coincidencia se arroja mensaje, de lo contrario se carga la tabla con las coincidencias
			if(buscarLibro.posiciones.size() == 0){
				JOptionPane.showMessageDialog(null, "No se encontraron coincidencias!");
			}else{
				tableLib = new JTable(buscarLibro.datosFilasBus, adminLibros.nombresCol);
				scrollPaneJTableLib.setViewportView(tableLib);
				tableLib.setColumnSelectionAllowed(true);
				tableLib.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tamColumnasLib();
			}
		}
		//boton cerrar sesion
		if(event.getSource() == btnCerrarSesion){
			
			dispose();
			
			try {
				JFrameIngreso frame = new JFrameIngreso();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
		
		
	}

	/**Metodo que contiene los componentes del tabPanel de gestion de usuarios**/
	public void panelGestionUsuarios(){
		
		//Panel Gestion De Usuario
		tbpGestionUsuarios = new JTabbedPane(JTabbedPane.TOP);
		tbpGestionUsuarios.setBounds(0, 0, 545, 527);
		tbpGestionUsuarios.setBorder(null);
		
		panelAux.add(tbpGestionUsuarios);
		
		//Panel Ver Usuarios
		panelVerUsuarios = new JPanel();
		tbpGestionUsuarios.addTab("Ver Usuarios", null, panelVerUsuarios, null);
		panelVerUsuarios.setLayout(null);
		
		lblImgUsuarios = new JLabel("");
		lblImgUsuarios.setIcon(new ImageIcon(JFrameAdmin.class.getResource("/imagenes/usuarios.png")));
		lblImgUsuarios.setBounds(12, 13, 144, 100);
		panelVerUsuarios.add(lblImgUsuarios);
		
		lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblUsuarios.setBounds(218, 41, 120, 34);
		panelVerUsuarios.add(lblUsuarios);
		
		//scrollpanel con Jtable
		scrollPaneJTable = new JScrollPane();
		scrollPaneJTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneJTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPaneJTable.setBounds(0, 126, 540, 148);
		panelVerUsuarios.add(scrollPaneJTable);
		
		//table = new JTable();
		table = new JTable(adminUser.datosFilas, adminUser.nombresCol);
		table.setColumnSelectionAllowed(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tamColumnas();

		scrollPaneJTable.setViewportView(table);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(115, 287, 97, 25);
		btnBorrar.addActionListener(this);
		panelVerUsuarios.add(btnBorrar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(327, 287, 97, 25);
		btnGuardar.addActionListener(this);
		panelVerUsuarios.add(btnGuardar);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblBuscar.setBounds(218, 341, 103, 25);
		panelVerUsuarios.add(lblBuscar);
		
		lblBuscarPor = new JLabel("Buscar Por:");
		lblBuscarPor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuscarPor.setBounds(16, 420, 75, 16);
		panelVerUsuarios.add(lblBuscarPor);
		
		cbxBuscarPor = new JComboBox<String>();
		cbxBuscarPor.setModel(new DefaultComboBoxModel<String>(new String[] {"Nombre", "Cedula", "Nivel", "User", "Edad"}));
		cbxBuscarPor.setBounds(107, 417, 113, 22);
		panelVerUsuarios.add(cbxBuscarPor);
		
		txtIngresoBusqueda = new JTextField();
		txtIngresoBusqueda.setBounds(236, 417, 174, 22);
		panelVerUsuarios.add(txtIngresoBusqueda);
		txtIngresoBusqueda.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(426, 416, 97, 25);
		btnBuscar.addActionListener(this);
		panelVerUsuarios.add(btnBuscar);
		
		lblImgbuscar = new JLabel("");
		lblImgbuscar.setIcon(new ImageIcon(JFrameAdmin.class.getResource("/imagenes/buscar.png")));
		lblImgbuscar.setBounds(142, 325, 70, 70);
		panelVerUsuarios.add(lblImgbuscar);
		
		//Tab Agregar Usuario
		panelAgregarUsuario = new JPanel();
		tbpGestionUsuarios.addTab("Agregar Usuario", null, panelAgregarUsuario, null);
		panelAgregarUsuario.setLayout(null);
		
		lblImgUsuario = new JLabel("");
		lblImgUsuario.setIcon(new ImageIcon(JFrameAdmin.class.getResource("/imagenes/usuario.png")));
		lblImgUsuario.setBounds(12, 13, 100, 100);
		panelAgregarUsuario.add(lblImgUsuario);
		
		lblAgregarUsuario = new JLabel("Agregar Usuario");
		lblAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblAgregarUsuario.setBounds(188, 41, 246, 44);
		panelAgregarUsuario.add(lblAgregarUsuario);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(40, 170, 72, 16);
		panelAgregarUsuario.add(lblNombre);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(40, 233, 72, 16);
		panelAgregarUsuario.add(lblUsername);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(40, 290, 72, 16);
		panelAgregarUsuario.add(lblContrasea);
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(40, 350, 72, 16);
		panelAgregarUsuario.add(lblCedula);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(252, 170, 73, 16);
		panelAgregarUsuario.add(lblTelefono);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(252, 233, 73, 16);
		panelAgregarUsuario.add(lblDireccion);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(252, 290, 73, 16);
		panelAgregarUsuario.add(lblEdad);
		
		txtIngNombre = new JTextField();
		txtIngNombre.setBounds(124, 170, 116, 22);
		panelAgregarUsuario.add(txtIngNombre);
		txtIngNombre.setColumns(10);
		
		txtIngUsername = new JTextField();
		txtIngUsername.setBounds(124, 230, 116, 22);
		panelAgregarUsuario.add(txtIngUsername);
		txtIngUsername.setColumns(10);
		
		txtIngPassword = new JTextField();
		txtIngPassword.setBounds(124, 290, 116, 22);
		panelAgregarUsuario.add(txtIngPassword);
		txtIngPassword.setColumns(10);
		
		txtIngCedula = new JTextField();
		txtIngCedula.setBounds(124, 350, 116, 22);
		panelAgregarUsuario.add(txtIngCedula);
		txtIngCedula.setColumns(10);
		
		txtIngTelefono = new JTextField();
		txtIngTelefono.setBounds(361, 170, 116, 22);
		panelAgregarUsuario.add(txtIngTelefono);
		txtIngTelefono.setColumns(10);
		
		txtIngDireccion = new JTextField();
		txtIngDireccion.setBounds(361, 230, 116, 22);
		panelAgregarUsuario.add(txtIngDireccion);
		txtIngDireccion.setColumns(10);
		
		txtIngEdad = new JTextField();
		txtIngEdad.setBounds(361, 290, 116, 22);
		panelAgregarUsuario.add(txtIngEdad);
		txtIngEdad.setColumns(10);
		
		btnGuardarUsuario = new JButton("Guardar Usuario");
		btnGuardarUsuario.setBounds(143, 429, 130, 25);
		btnGuardarUsuario.addActionListener(this);
		panelAgregarUsuario.add(btnGuardarUsuario);
		
		btnLimpiarDatos = new JButton("Limpiar");
		btnLimpiarDatos.setBounds(337, 429, 97, 25);
		btnLimpiarDatos.addActionListener(this);
		panelAgregarUsuario.add(btnLimpiarDatos);
		
		lblAcceso = new JLabel("Acceso:");
		lblAcceso.setBounds(252, 350, 73, 16);
		panelAgregarUsuario.add(lblAcceso);
		
		cbxAcceso = new JComboBox<String>();
		cbxAcceso.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrador", "Usuario"}));
		cbxAcceso.setBounds(361, 347, 116, 22);
		panelAgregarUsuario.add(cbxAcceso);
		panelAgregarUsuario.setLayout(null);
		
		
	}

	/**Metodo que contiene los componentes del tabPanel de gestion de Lisbros**/
	public void panelGestionInventario(){
		
		//tabPanel Gestion De Inventario
		tbpGestionInventario = new JTabbedPane(JTabbedPane.TOP);
		tbpGestionInventario.setBounds(0, 0, 545, 527);
		tbpGestionInventario.setBorder(null);
		
		panelAux.add(tbpGestionInventario);
		
		//Panel Ver Usuarios
		panelVerLibros = new JPanel();
		tbpGestionInventario.addTab("Ver Libros", null, panelVerLibros, null);
		panelVerLibros.setLayout(null);
		
		lblImgLibros = new JLabel("");
		lblImgLibros.setIcon(new ImageIcon(JFrameAdmin.class.getResource("/imagenes/libros.png")));
		lblImgLibros.setBounds(12, 13, 144, 100);
		panelVerLibros.add(lblImgLibros);
		
		lblLibros = new JLabel("Libros");
		lblLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibros.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblLibros.setBounds(218, 41, 103, 34);
		panelVerLibros.add(lblLibros);
		
		//scrollpanel con Jtable
		scrollPaneJTableLib = new JScrollPane();
		scrollPaneJTableLib.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneJTableLib.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPaneJTableLib.setBounds(0, 126, 540, 148);
		panelVerLibros.add(scrollPaneJTableLib);
		
		//tableLib = new JTable();
		tableLib = new JTable(adminLibros.datosFilas, adminLibros.nombresCol);
		tableLib.setColumnSelectionAllowed(true);
		tableLib.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tamColumnasLib();

		scrollPaneJTableLib.setViewportView(tableLib);
		
		btnBorrarLib = new JButton("Borrar");
		btnBorrarLib.setBounds(115, 287, 97, 25);
		btnBorrarLib.addActionListener(this);
		panelVerLibros.add(btnBorrarLib);
		
		btnGuardarLib = new JButton("Guardar");
		btnGuardarLib.setBounds(327, 287, 97, 25);
		btnGuardarLib.addActionListener(this);
		panelVerLibros.add(btnGuardarLib);
		
		lblBuscarLib = new JLabel("Buscar");
		lblBuscarLib.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarLib.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblBuscarLib.setBounds(218, 341, 103, 25);
		panelVerLibros.add(lblBuscarLib);
		
		lblBuscarPorLib = new JLabel("Buscar Por:");
		lblBuscarPorLib.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuscarPorLib.setBounds(16, 420, 75, 16);
		panelVerLibros.add(lblBuscarPorLib);
		
		cbxBuscarPorLib = new JComboBox<String>();
		cbxBuscarPorLib.setModel(new DefaultComboBoxModel<String>(new String[] {"Titulo", "Autor", "Publicacion"}));
		cbxBuscarPorLib.setBounds(107, 417, 113, 22);
		panelVerLibros.add(cbxBuscarPorLib);
		
		txtIngresoBusquedaLib = new JTextField();
		txtIngresoBusquedaLib.setBounds(236, 417, 174, 22);
		panelVerLibros.add(txtIngresoBusquedaLib);
		txtIngresoBusquedaLib.setColumns(10);
		
		btnBuscarLib = new JButton("Buscar");
		btnBuscarLib.setBounds(426, 416, 97, 25);
		btnBuscarLib.addActionListener(this);
		panelVerLibros.add(btnBuscarLib);
		
		lblImgbuscar = new JLabel("");
		lblImgbuscar.setIcon(new ImageIcon(JFrameAdmin.class.getResource("/imagenes/buscar.png")));
		lblImgbuscar.setBounds(142, 325, 70, 70);
		panelVerLibros.add(lblImgbuscar);
		
		//Tab Agregar Libro
		panelAgregarLibro = new JPanel();
		tbpGestionInventario.addTab("Agregar Libro", null, panelAgregarLibro, null);
		panelAgregarLibro.setLayout(null);
		
		lblImgLibro = new JLabel("");
		lblImgLibro.setIcon(new ImageIcon(JFrameAdmin.class.getResource("/imagenes/libro.png")));
		lblImgLibro.setBounds(12, 13, 100, 100);
		panelAgregarLibro.add(lblImgLibro);
		
		lblAgregarLibro = new JLabel("Agregar Libro");
		lblAgregarLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarLibro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblAgregarLibro.setBounds(188, 41, 246, 44);
		panelAgregarLibro.add(lblAgregarLibro);
		
		lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(40, 170, 72, 16);
		panelAgregarLibro.add(lblTitulo);
		
		lblPublicacion = new JLabel("Publicacion:");
		lblPublicacion.setBounds(40, 233, 72, 16);
		panelAgregarLibro.add(lblPublicacion);
		
		lblEditorial = new JLabel("Editorial:");
		lblEditorial.setBounds(40, 290, 72, 16);
		panelAgregarLibro.add(lblEditorial);
		
		lblId = new JLabel("Id:");
		lblId.setBounds(40, 350, 72, 16);
		panelAgregarLibro.add(lblId);
		
		lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(252, 170, 73, 16);
		panelAgregarLibro.add(lblAutor);
		
		lblPaginas = new JLabel("Paginas:");
		lblPaginas.setBounds(252, 233, 73, 16);
		panelAgregarLibro.add(lblPaginas);
		
		lblDisponibles = new JLabel("Disponibles:");
		lblDisponibles.setBounds(252, 290, 73, 16);
		panelAgregarLibro.add(lblDisponibles);
		
		txtIngTitulo = new JTextField();
		txtIngTitulo.setBounds(124, 170, 116, 22);
		panelAgregarLibro.add(txtIngTitulo);
		txtIngTitulo.setColumns(10);
		
		txtIngPublicacion = new JTextField();
		txtIngPublicacion.setBounds(124, 230, 116, 22);
		panelAgregarLibro.add(txtIngPublicacion);
		txtIngPublicacion.setColumns(10);
		
		txtIngEditorial = new JTextField();
		txtIngEditorial.setBounds(124, 290, 116, 22);
		panelAgregarLibro.add(txtIngEditorial);
		txtIngEditorial.setColumns(10);
		
		txtIngId = new JTextField();
		txtIngId.setBounds(124, 350, 116, 22);
		panelAgregarLibro.add(txtIngId);
		txtIngId.setColumns(10);
		
		txtIngAutor = new JTextField();
		txtIngAutor.setBounds(361, 170, 116, 22);
		panelAgregarLibro.add(txtIngAutor);
		txtIngAutor.setColumns(10);
		
		txtIngPaginas = new JTextField();
		txtIngPaginas.setBounds(361, 230, 116, 22);
		panelAgregarLibro.add(txtIngPaginas);
		txtIngPaginas.setColumns(10);
		
		txtIngDisponibles = new JTextField();
		txtIngDisponibles.setBounds(361, 290, 116, 22);
		panelAgregarLibro.add(txtIngDisponibles);
		txtIngDisponibles.setColumns(10);
		
		btnGuardarLibro = new JButton("Guardar Libro");
		btnGuardarLibro.setBounds(143, 429, 130, 25);
		btnGuardarLibro.addActionListener(this);
		panelAgregarLibro.add(btnGuardarLibro);
		
		btnLimpiarDatosLib = new JButton("Limpiar");
		btnLimpiarDatosLib.setBounds(337, 429, 97, 25);
		btnLimpiarDatosLib.addActionListener(this);
		panelAgregarLibro.add(btnLimpiarDatosLib);
		
		lblImagen = new JLabel("Imagen:");
		lblImagen.setBounds(252, 350, 73, 16);
		panelAgregarLibro.add(lblImagen);
		
		txtIngImagen = new JTextField();
		txtIngImagen.setBounds(361, 290, 116, 22);
		txtIngImagen.setBounds(361, 347, 116, 22);
		panelAgregarLibro.add(txtIngImagen);
		
		panelAgregarLibro.setLayout(null);
		
		lblPrestamos = new JLabel("Prestamos:");
		lblPrestamos.setBounds(188, 400, 72, 16);
		panelAgregarLibro.add(lblPrestamos);
		
		txtIngPrestamos = new JTextField();
		txtIngPrestamos.setBounds(272, 394, 116, 22);
		panelAgregarLibro.add(txtIngPrestamos);
		txtIngPrestamos.setColumns(10);
	}
	
	/**Metodo que valida los datos y los envia al objeto de la clase AdministrarUsuario que luego los guardara**/
	public void enviarDatos(){
		boolean valido = true;
		//Primero validamos los datos que tengan restricciones
		try{
			Long.parseLong(txtIngTelefono.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Numero de telefono no valido!");
			valido = false;
		}
		//Cedula deben ser numeros
		try{
			Long.parseLong(txtIngCedula.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Numero de cedula no valido!");
			valido = false;
		}
		
		try{
			//Si la edad no es un numero arroja excepcion
			if(Integer.parseInt(txtIngEdad.getText()) < 1 || Integer.parseInt(txtIngEdad.getText()) > 109){
				JOptionPane.showMessageDialog(null, "Edad debe ser mayor a 0 y menor a 110!");
				valido = false;
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Edad no valida!");
			valido = false;
		}
		
		//contraseña no permite espacios
		if(txtIngPassword.getText().isEmpty() || txtIngPassword.getText().indexOf(" ") != -1 || txtIngPassword.getText().length()<6){
			JOptionPane.showMessageDialog(null, "Contraseña no validad! \n -Ne se permiten espacios \n -Mas de 5 caracteres");
			valido = false;
		}
		
		//Verificacion de que los demas campos no esten vacios
		if(valido){
			if(txtIngNombre.getText().isEmpty() || txtIngDireccion.getText().isEmpty() || 
					txtIngUsername.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Llene todos los datos por favor");
					valido = false;
				}
		}
		
		//Si las validaciones son superadas.
		if(valido){
			try{
				//Si hay espacios sera diferente de -1
				if(txtIngUsername.getText().indexOf(" ") == -1){
					user = new Usuario(txtIngNombre.getText(), txtIngCedula.getText(), txtIngTelefono.getText(), 
											  txtIngDireccion.getText(), Integer.parseInt(txtIngEdad.getText()), cbxAcceso.getSelectedIndex(), 
											  txtIngUsername.getText(), txtIngPassword.getText());
					
					
					adminUser.agregarUsuario(user);
					
					//JOptionPane.showMessageDialog(null, "Usuario registrado correctamente!");
				}else{
					JOptionPane.showMessageDialog(null, "El nombre de usuario no puede tener espacios");
				}
				

			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR - " + e.getMessage());
			}
		}

		
	}

	/**Metodo que valida los datos y los envia al objeto de la clase AdministrarUsuario que luego los guardara**/
	public void enviarDatosLib(){
		@SuppressWarnings("unused")
		boolean valido = true;
		//Primero validamos los datos que tengan restricciones
		try{
			Integer.parseInt((txtIngPaginas.getText()));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Numero de paginas no valido!");
			valido = false;
		}
		//Disponibles deben ser numeros
		try{
			if(Integer.parseInt(txtIngDisponibles.getText()) < 0){
				JOptionPane.showMessageDialog(null, "Disponibles debe ser mayor o igual a 0");
				valido = false;
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Numero disponibles no valido!");
			valido = false;
		}
		
		//Id deben ser numeros
		try{
			if(Integer.parseInt(txtIngId.getText()) < 0){
				JOptionPane.showMessageDialog(null, "Id debe ser mayor o igual a 0");
				valido = false;
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Numero Id no valido!");
			valido = false;
		}
		
		//Prestamos deben ser numeros
		try{
			if(Integer.parseInt(txtIngPrestamos.getText()) < 0){
				JOptionPane.showMessageDialog(null, "Prestamos debe ser mayor o igual a 0");
				valido = false;
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Numero prestamos no valido!");
			valido = false;
		}

		
		//Si las validaciones son superadas.
		try{

			lib = new Libro(txtIngTitulo.getText(), txtIngAutor.getText(), txtIngPublicacion.getText(), 
							Integer.parseInt(txtIngPaginas.getText()), txtIngEditorial.getText(), Integer.parseInt(txtIngDisponibles.getText()),
							Integer.parseInt(txtIngId.getText()), txtIngImagen.getText(), Integer.parseInt(txtIngPrestamos.getText()));
			
			
			adminLibros.agregarLibro(lib);
				
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR - " + e.getMessage());
		}
		
	}
	
	/**Metodo que deja en blanco los componentes de tabPanel de Agregar Usuatio**/
	public void limpiarDatos(){
		txtIngNombre.setText("");
		txtIngUsername.setText("");
		txtIngPassword.setText("");
		txtIngCedula.setText("");
		txtIngTelefono.setText("");
		txtIngDireccion.setText("");
		txtIngEdad.setText("");
		cbxAcceso.setSelectedIndex(0);
	}
	
	/**Metodo que deja en blanco los componentes de tabPanel de Agregar Usuatio**/
	public void limpiarDatosLib(){
		txtIngTitulo.setText("");
		txtIngAutor.setText("");
		txtIngPublicacion.setText("");
		txtIngPaginas.setText("");
		txtIngEditorial.setText("");
		txtIngDisponibles.setText("");
		txtIngId.setText("");
		txtIngImagen.setText("");
		txtIngPrestamos.setText("");
	}
	
	/**Metodo que define tamaño a las columnnas de la tabla de usuarios**/
	public void tamColumnas(){
		
		TableColumn columna1 = table.getColumn("NOMBRE");
		columna1.setPreferredWidth(120);
		columna1.setMinWidth(100);
		
		TableColumn columna2 = table.getColumn("CEDULA");
		columna2.setPreferredWidth(120);
		columna2.setMinWidth(100);
		
		TableColumn columna3 = table.getColumn("TELEFONO");
		columna3.setPreferredWidth(120);
		columna3.setMinWidth(100);
		
		TableColumn columna4 = table.getColumn("DIRECCION");
		columna4.setPreferredWidth(120);
		columna4.setMinWidth(100);
		
		TableColumn columna5 = table.getColumn("EDAD");
		columna5.setPreferredWidth(43);
		columna5.setMinWidth(43);
		
		TableColumn columna6 = table.getColumn("NIVEL ACCESO");
		columna6.setPreferredWidth(50);
		columna6.setMinWidth(40);
		
		TableColumn columna7 = table.getColumn("USUARIO");
		columna7.setPreferredWidth(80);
		columna7.setMinWidth(60);
		
		TableColumn columna8 = table.getColumn("CONTRASEÑA");
		columna8.setPreferredWidth(90);
		columna8.setMinWidth(60);
		
	}
	
	/**Metodo que define tamaño a las columnnas de la tabla de usuarios**/
	public void tamColumnasLib(){
		
		TableColumn columna1 = tableLib.getColumn("TITULO");
		columna1.setPreferredWidth(100);
		columna1.setMinWidth(90);

		TableColumn columna2 = tableLib.getColumn("AUTOR");
		columna2.setPreferredWidth(120);
		columna2.setMinWidth(100);
		
		TableColumn columna3 = tableLib.getColumn("FECHA PUBLICACION");
		columna3.setPreferredWidth(120);
		columna3.setMinWidth(100);
		
		TableColumn columna4 = tableLib.getColumn("PAGINAS");
		columna4.setPreferredWidth(100);
		columna4.setMinWidth(80);
		
		TableColumn columna5 = tableLib.getColumn("EDITORIAL");
		columna5.setPreferredWidth(120);
		columna5.setMinWidth(120);
		
		TableColumn columna6 = tableLib.getColumn("DISPONIBLES");
		columna6.setPreferredWidth(50);
		columna6.setMinWidth(40);
		
		TableColumn columna7 = tableLib.getColumn("ID");
		columna7.setPreferredWidth(50);
		columna7.setMinWidth(40);
		
		TableColumn columna8 = tableLib.getColumn("IMAGEN");
		columna8.setPreferredWidth(60);
		columna8.setMinWidth(50);
		
		TableColumn columna9 = tableLib.getColumn("PRESTAMOS");
		columna9.setPreferredWidth(80);
		columna9.setMinWidth(60);
		
		
		
	}
}
