package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.AdministrarUsuarios;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**@SuppressWarnings("serial")**/
public class JFrameIngreso extends JFrame implements ActionListener {
	
	public AdministrarUsuarios ingresoUser;
	public int panelActivo = 0;

	private JPanel panelPrincipalIngreso;
	private JPanel panelSeleccion;
	private JPanel panelIngreso;
	private JButton btnIngresoAdmin;
	private JButton btnIngresoUsuario;
	private JButton btnSalir;
	private JLabel lblLogo;
	
	/**Componentes Panel Admin**/
	
	private JLabel lblImagen;
	private JLabel labelTituloIngreso;
	private JTextField textFieldIngresoUser;
	private JPasswordField pwdIngresoPassword;
	private JLabel lblUsername;
	private JLabel lblContrasea;
	private JButton btnIngresar;
	private JLabel lblBienvenido;

	/**
	 * Create the frame.
	 */
	public JFrameIngreso() {
		ingresoUser = new AdministrarUsuarios();
		
		ImageIcon ImageIcon = new ImageIcon(getClass().getResource("/imagenes/icon.ico"));
		Image Image = ImageIcon.getImage();
        this.setIconImage(Image);
        setVisible(true);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameIngreso.class.getResource("/imagenes/icon3.ico")));
		setTitle("BooKTIC - Ingreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 360);
		panelPrincipalIngreso = new JPanel();
		panelPrincipalIngreso.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipalIngreso);
		panelPrincipalIngreso.setLayout(null);
		
		panelSeleccion = new JPanel();
		panelSeleccion.setBounds(10, 11, 155, 289);
		panelPrincipalIngreso.add(panelSeleccion);
		panelSeleccion.setLayout(null);
		
		btnIngresoAdmin = new JButton("Administrador");
		btnIngresoAdmin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIngresoAdmin.setBounds(15, 52, 126, 40);
		btnIngresoAdmin.addActionListener(this);
		panelSeleccion.add(btnIngresoAdmin);
		
		btnIngresoUsuario = new JButton("Usuario");
		btnIngresoUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIngresoUsuario.setBounds(15, 138, 126, 40);
		btnIngresoUsuario.addActionListener(this);
		panelSeleccion.add(btnIngresoUsuario);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalir.setBounds(15, 223, 126, 30);
		btnSalir.addActionListener(this);
		panelSeleccion.add(btnSalir);
		
		panelIngreso = new JPanel();
		panelIngreso.setBounds(179, 11, 345, 289);
		panelPrincipalIngreso.add(panelIngreso);
		panelIngreso.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(JFrameIngreso.class.getResource("/imagenes/logo.png")));
		lblLogo.setBounds(0, 0, 345, 289);
		panelIngreso.add(lblLogo);
		
		lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setForeground(Color.GRAY);
		lblBienvenido.setFont(new Font("Berlin Sans FB", Font.BOLD, 27));
		lblBienvenido.setBounds(0, 0, 172, 25);
		panelIngreso.add(lblBienvenido);
		
		
		//cargarPanelAdmin();
		
	}

	//Manejo de eventos
	public void actionPerformed(ActionEvent event) {
		//Evento boton ingreso admin
		if(event.getSource() == btnIngresoAdmin){
			panelIngreso.removeAll();
			cargarPanelAdmin();
			panelIngreso.repaint();
		}
		//Evento boton ingreso usuario
		if(event.getSource() == btnIngresoUsuario){
			panelIngreso.removeAll();
			cargarPanelUser();
			panelIngreso.repaint();
		}
		if(event.getSource() == btnSalir){
			System.exit(0);
		}
		//Evento boton Ingresar
		if(event.getSource() == btnIngresar){
			
			if(validarUsuario()){
				if(panelActivo ==1){
					
					abrirFrameAdmin();
					
				}else if(panelActivo == 2){
					
					abrirFrameUsuario();
				}
			}
		}
	
		
	}
	
	/**Metodo Cargar panel Ingreso Admin**/
	public void cargarPanelAdmin(){
		panelActivo = 1;
		
		labelTituloIngreso = new JLabel("ADMIN");
		labelTituloIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloIngreso.setFont(new Font("Berlin Sans FB", Font.BOLD, 27));
		labelTituloIngreso.setBounds(144, 62, 139, 23);
		panelIngreso.add(labelTituloIngreso);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(JFrameIngreso.class.getResource("/imagenes/admin.png")));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(53, 13, 100, 100);
		panelIngreso.add(lblImagen);
		
		textFieldIngresoUser = new JTextField();
		textFieldIngresoUser.setBounds(144, 148, 139, 20);
		panelIngreso.add(textFieldIngresoUser);
		textFieldIngresoUser.setColumns(10);
		
		pwdIngresoPassword = new JPasswordField();
		pwdIngresoPassword.setBounds(144, 188, 139, 20);
		panelIngreso.add(pwdIngresoPassword);
		
		lblUsername = new JLabel("Usuario:");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(53, 148, 70, 20);
		panelIngreso.add(lblUsername);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setBounds(53, 188, 70, 20);
		panelIngreso.add(lblContrasea);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(116, 234, 89, 23);
		panelIngreso.add(btnIngresar);
		btnIngresar.addActionListener(this);
	}
	
	/**Metodo Cargar Panel Ingreso User**/
	public void cargarPanelUser(){
		panelActivo = 2;
		
		labelTituloIngreso = new JLabel("USUARIO");
		labelTituloIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloIngreso.setFont(new Font("Berlin Sans FB", Font.BOLD, 27));
		labelTituloIngreso.setBounds(144, 62, 139, 23);
		panelIngreso.add(labelTituloIngreso);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(JFrameIngreso.class.getResource("/imagenes/usuario.png")));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(53, 13, 100, 100);
		panelIngreso.add(lblImagen);
		
		textFieldIngresoUser = new JTextField();
		textFieldIngresoUser.setBounds(144, 148, 139, 20);
		panelIngreso.add(textFieldIngresoUser);
		textFieldIngresoUser.setColumns(10);
		
		pwdIngresoPassword = new JPasswordField();
		pwdIngresoPassword.setBounds(144, 188, 139, 20);
		panelIngreso.add(pwdIngresoPassword);
		
		lblUsername = new JLabel("Usuario:");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(53, 148, 70, 20);
		panelIngreso.add(lblUsername);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setBounds(53, 188, 70, 20);
		panelIngreso.add(lblContrasea);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(116, 234, 89, 23);
		btnIngresar.addActionListener(this);
		panelIngreso.add(btnIngresar);
	}
	
	/**Metodo que carga el panel Admin**/
	public void abrirFrameAdmin(){
		
		dispose();
		
		try {
			JFrameAdmin frame = new JFrameAdmin();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**Metodo que carga el panel Admin**/
	public void abrirFrameUsuario(){
		
		dispose();
		
		try {
			JFrameUsuario frame = new JFrameUsuario();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//valida el usuario
	public boolean validarUsuario(){
		
		String valorPass = new String(pwdIngresoPassword.getPassword());
		String valorUserN = textFieldIngresoUser.getText();
		
		//Se busca el usuario en los prestamos
		for (int i=0; i<ingresoUser.listaUser.size(); i++){
			
			//Se verifica Username
			if(ingresoUser.listaUser.get(i).getUsername().equals(valorUserN)){
				
				System.out.print(ingresoUser.listaUser.get(i).getUsername() + " = " + valorUserN);
				
				//Se valida password
				if(ingresoUser.listaUser.get(i).getPassword().equals(valorPass)){
					
					//Se valida que un usuario no ingrese como admin
					if(panelActivo == 1 && ingresoUser.listaUser.get(i).getNivel() == 1){
						JOptionPane.showMessageDialog(null, "Permisos no validos, ingrese como usuario!");
						return false;
					}
					
					//Se valida que un usuario no ingrese como admin
					if(panelActivo == 2 && ingresoUser.listaUser.get(i).getNivel() == 0){
						JOptionPane.showMessageDialog(null, "Permisos de Admin, ingrese como Administrador!");
						return false;
					}
					return true;
					
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Datos no escontrados!");
		return false;
		
	}
	
}