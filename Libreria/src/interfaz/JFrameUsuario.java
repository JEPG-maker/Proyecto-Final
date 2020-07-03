package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

import logica.AdministrarLibros;
import logica.BuscarLibro;
import logica.Libro;
import logica.Prestamo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class JFrameUsuario extends JFrame implements ActionListener{

	/**Creacion de objetos**/
	Libro lib;
	AdministrarLibros verLibros;
	BuscarLibro buscarLibro;
	Prestamo pres1;
	
	public boolean buscoLib = false;
	public boolean primera = true;
	
	private JPanel panelPrincipalUsuario;
	private JPanel panelOpciones;
	private JButton btnBooktic;
	private JButton btnInformacionDeUsuario;
	private JButton btnCerrarSesion;
	private JPanel panelAux;
	
	/**Panel verLibros**/
	private JPanel panelVerLibros;
	private JLabel lblImgLibros;
	private JLabel lblLibros;
	private JScrollPane scrollPaneJTableLib;
	private JTable tableLib;
	private JLabel lblBuscarLib;
	private JLabel lblBuscarPorLib;
	private JComboBox<String> cbxBuscarPorLib;
	private JTextField txtIngresoBusquedaLib;
	private JButton btnBuscarLib;
	private JLabel lblImgbuscar;
	
	/**Panel mostrar libro**/
	private JPanel panelMostrarLibro;
	private JLabel lblMostrarTitulo;
	private JLabel lblMostrarAutor;
	private JLabel lblPublicacion;
	private JLabel lblPaginas;
	private JLabel lblEditorial;
	private JLabel lblMostrarImagen;
	private JButton btnSolicitar;
	
	private JLabel lblLogo;

	/**
	 * Create the frame.
	 */
	public JFrameUsuario() {
		
		/**Se hace uso la clase AdministrarLibros para cargar los datos de los libros**/
		verLibros = new AdministrarLibros();
		
		setTitle("BooKTIC - Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		panelPrincipalUsuario = new JPanel();
		panelPrincipalUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipalUsuario);
		panelPrincipalUsuario.setLayout(null);
		
		panelOpciones = new JPanel();
		panelOpciones.setBounds(12, 13, 200, 527);
		panelPrincipalUsuario.add(panelOpciones);
		panelOpciones.setLayout(null);
		
		btnBooktic = new JButton("BooKTIC");
		btnBooktic.setBounds(51, 98, 97, 35);
		btnBooktic.addActionListener(this);
		panelOpciones.add(btnBooktic);
		
		btnInformacionDeUsuario = new JButton("<html><CENTER>Informacion</CENTER><CENTER>De</CENTER><CENTER>Usuario</CENTER></html>");
		btnInformacionDeUsuario.setBounds(51, 231, 97, 55);
		btnInformacionDeUsuario.addActionListener(this);
		panelOpciones.add(btnInformacionDeUsuario);
		
		btnCerrarSesion = new JButton("<html><CENTER>Cerrar</CENTER><CENTER>Sesi\u00F3n</CENTER>");
		btnCerrarSesion.setBounds(51, 384, 97, 45);
		btnCerrarSesion.addActionListener(this);
		panelOpciones.add(btnCerrarSesion);
		
		panelAux = new JPanel();
		panelAux.setBounds(224, 13, 546, 527);
		panelPrincipalUsuario.add(panelAux);
		panelAux.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(JFrameUsuario.class.getResource("/imagenes/logo.png")));
		lblLogo.setBounds(0, 0, 546, 527);
		panelAux.add(lblLogo);
		
		//cargarPanelVerLibros();
		
	}

	/**Metodo que maneja los eventos**/
	public void actionPerformed(ActionEvent evento) {
		//Evento boton booktinc
		if(evento.getSource() == btnBooktic){
			panelAux.removeAll();
			cargarPanelVerLibros();
			panelAux.revalidate();
			panelAux.repaint();
		}
		if(evento.getSource() == btnBuscarLib){
			//Booleano buscar se vuelve true para saber que se hizo una busqueda (esto para luego al guardar hacerlo basado en las busquedas)
			buscoLib = true;
			
			buscarLibro = new BuscarLibro();

				try {
					buscarLibro.realizarBusqueda(verLibros.listaLibros, cbxBuscarPorLib.getSelectedIndex(), txtIngresoBusquedaLib.getText());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Busqueda no valida!");
				}

			//Si no se encuentran coincidencia se arroja mensaje, de lo contrario se carga la tabla con las coincidencias
			if(buscarLibro.posiciones.size() == 0){
				JOptionPane.showMessageDialog(null, "No se encontraron coincidencias!");
			}else{
				tableLib = new JTable(buscarLibro.datosFilasBus, verLibros.nombresCol);
				
				//implementar evento tabla
				implementarEventoTabla();
				
				scrollPaneJTableLib.setViewportView(tableLib);
				tableLib.setColumnSelectionAllowed(true);
				tableLib.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tamColumnasLib();
			}
		}
		//Evento boton Info Usuario
		if(evento.getSource() == btnInformacionDeUsuario){
			
		}
		//Evento boton cerrar sesion
		if(evento.getSource() == btnCerrarSesion){
			
			dispose();
			
			try {
				JFrameIngreso frame = new JFrameIngreso();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		if(evento.getSource() == btnSolicitar){
			///*----------------------------------------*-*-*-*-*-*-*-*-*-
			///pres1.
			
		}
		
		
		
	}
	
	/**Metodo que carga el panel Libros**/
	public void cargarPanelVerLibros(){
		
		panelVerLibros = new JPanel();
		panelVerLibros.setBounds(0, 0, 546, 527);
		panelAux.add(panelVerLibros);
		panelVerLibros.setLayout(null);
		
		lblImgLibros = new JLabel("");
		lblImgLibros.setIcon(new ImageIcon(JFrameAdmin.class.getResource("/imagenes/libros.png")));
		lblImgLibros.setBounds(16, 0, 144, 100);
		panelVerLibros.add(lblImgLibros);
		
		lblLibros = new JLabel("Libros");
		lblLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibros.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblLibros.setBounds(218, 30, 103, 34);
		panelVerLibros.add(lblLibros);
		
		//scrollpanel con Jtable
		scrollPaneJTableLib = new JScrollPane();
		scrollPaneJTableLib.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneJTableLib.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPaneJTableLib.setBounds(0, 95, 540, 148);
		panelVerLibros.add(scrollPaneJTableLib);
		
		//tableLib = new JTable();
		tableLib = new JTable(verLibros.datosFilas, verLibros.nombresCol);
		//tableLib.setEnabled(false);
		tableLib.setColumnSelectionAllowed(true);
		tableLib.setCellSelectionEnabled(false);
		tableLib.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tamColumnasLib();
		
		//Implementar evento tabla
		implementarEventoTabla();
		
		scrollPaneJTableLib.setViewportView(tableLib);
		
		lblBuscarLib = new JLabel("Buscar");
		lblBuscarLib.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarLib.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblBuscarLib.setBounds(235, 266, 103, 25);
		panelVerLibros.add(lblBuscarLib);
		
		lblBuscarPorLib = new JLabel("Buscar Por:");
		lblBuscarPorLib.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuscarPorLib.setBounds(17, 324, 75, 16);
		panelVerLibros.add(lblBuscarPorLib);
		
		cbxBuscarPorLib = new JComboBox<String>();
		cbxBuscarPorLib.setModel(new DefaultComboBoxModel<String>(new String[] {"Titulo", "Autor", "Publicacion"}));
		cbxBuscarPorLib.setBounds(109, 321, 126, 22);
		panelVerLibros.add(cbxBuscarPorLib);
		
		txtIngresoBusquedaLib = new JTextField();
		txtIngresoBusquedaLib.setBounds(247, 321, 166, 22);
		panelVerLibros.add(txtIngresoBusquedaLib);
		txtIngresoBusquedaLib.setColumns(10);
		
		btnBuscarLib = new JButton("Buscar");
		btnBuscarLib.setBounds(430, 320, 97, 25);
		btnBuscarLib.addActionListener(this);
		panelVerLibros.add(btnBuscarLib);
		
		lblImgbuscar = new JLabel("");
		lblImgbuscar.setIcon(new ImageIcon(JFrameAdmin.class.getResource("/imagenes/buscar.png")));
		lblImgbuscar.setBounds(161, 243, 70, 70);
		panelVerLibros.add(lblImgbuscar);

	}
	
	/**Metodo que carga los componentes de Mostrar Libro**/
	public void panelMostrarLibro(int pos){
		try{
			if(primera){
				String ruta = "/imagenes/portada/";
				int id = Integer.parseInt(String.valueOf(tableLib.getValueAt(pos, 6)));

				panelMostrarLibro = new JPanel();
				panelMostrarLibro.setBounds(0, 353, 546, 174);
				panelVerLibros.add(panelMostrarLibro);
				panelMostrarLibro.setLayout(null);
				
				lblMostrarTitulo = new JLabel(verLibros.listaLibros.get(id).getTitulo());
				lblMostrarTitulo.setBounds(12, 13, 200, 16);
				panelMostrarLibro.add(lblMostrarTitulo);
				
				lblMostrarAutor = new JLabel(verLibros.listaLibros.get(id).getAutor());
				lblMostrarAutor.setBounds(12, 42, 120, 16);
				panelMostrarLibro.add(lblMostrarAutor);
				
				lblPublicacion = new JLabel(verLibros.listaLibros.get(id).getFecha());
				lblPublicacion.setBounds(12, 71, 120, 16);
				panelMostrarLibro.add(lblPublicacion);
				
				lblPaginas = new JLabel(String.valueOf(verLibros.listaLibros.get(id).getPaginas()));
				lblPaginas.setBounds(12, 100, 56, 16);
				panelMostrarLibro.add(lblPaginas);
				
				lblEditorial = new JLabel(verLibros.listaLibros.get(id).getEditorial());
				lblEditorial.setBounds(12, 129, 120, 16);
				panelMostrarLibro.add(lblEditorial);
				
				lblMostrarImagen = new JLabel("");
				lblMostrarImagen.setIcon(new ImageIcon(JFrameAdmin.class.getResource(ruta + verLibros.listaLibros.get(id).getImagen())));
				lblMostrarImagen.setBounds(258, 13, 115, 150);
				panelMostrarLibro.add(lblMostrarImagen);
				
				btnSolicitar = new JButton("Solicitar");
				btnSolicitar.setBounds(423, 76, 97, 25);
				btnSolicitar.addActionListener(this);
				panelMostrarLibro.add(btnSolicitar);
			
			}
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Error! " + e.getMessage());
		}	
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
	
	/**Metodo que implementa la acccion cuando se cambia de fila**/ 
	public void implementarEventoTabla(){
		
		//Se implementa Accion cuando se selecciona una fila diferente de la tabla para que actualize el panel de mostrar libro
		ListSelectionModel cellSelectionModel = tableLib.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				//Al cambiar de fila en la tabla se ejecuta dos veces este evento asi que se implementa 
				//if para que solo se ejecute una vez el metodo panelMostrarLibro
				if(primera){
					panelMostrarLibro(tableLib.getSelectedRow());
					panelMostrarLibro.repaint();
					primera = false;
				}else{
					primera = true;
				}
			}
		});
		
	}

	public void verificarDisponibles(int idLibro){
		
		
		
	}
}
