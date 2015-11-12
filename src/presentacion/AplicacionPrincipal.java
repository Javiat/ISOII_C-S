package presentacion;
import persistencia.LectorFichero;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import dominio.Contacto;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ImageIcon;

public class AplicacionPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnAñadir;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JList list;
	private JPanel cuestionario;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private DefaultListModel modelo = new DefaultListModel();
	
	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public DefaultListModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel modelo) {
		this.modelo = modelo;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionPrincipal frame = new AplicacionPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//LectorFichero lf=new LectorFichero();
		//lf.leerFichero();
		
	}

	/**
	 * Create the frame.
	 */
	public AplicacionPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnAñadir = new JButton("Añadir");
			btnAñadir.setIcon(new ImageIcon(AplicacionPrincipal.class.getResource("/presentacion/anadir-mas-icono-6734-48.png")));
			btnAñadir.addActionListener(new BtnAñadirActionListener());
			btnAñadir.setBounds(374, 70, 129, 29);
			contentPane.add(btnAñadir);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.setIcon(new ImageIcon(AplicacionPrincipal.class.getResource("/presentacion/dibujo-a-lapiz-modificar-escribir-icono-8118-48.png")));
			btnModificar.addActionListener(new BtnModificarActionListener());
			btnModificar.setBounds(374, 134, 129, 29);
			contentPane.add(btnModificar);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.setIcon(new ImageIcon(AplicacionPrincipal.class.getResource("/presentacion/eliminar.png")));
			btnBorrar.addActionListener(new BtnBorrarActionListener());
			btnBorrar.setBounds(374, 206, 129, 29);
			contentPane.add(btnBorrar);
		}
		{
			list = new JList();
			
			list.setBounds(27, 25, 202, 210);
			contentPane.add(list);
		}
		{
			cuestionario = new JPanel();
			cuestionario.setBounds(22, 258, 492, 119);
			contentPane.add(cuestionario);
			cuestionario.setLayout(null);
			{
				lblNombre = new JLabel("Nombre-Telefono:");
				lblNombre.setBounds(83, 33, 122, 14);
				cuestionario.add(lblNombre);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(251, 30, 136, 20);
				cuestionario.add(txtNombre);
				txtNombre.setColumns(10);
			}
		}
		
			//DefaultListModel model = new DefaultListModel();
			try{
				//DefaultListModel dlm=new DefaultListModel();
				// Apertura del fichero y creacion de BufferedReader

				URL is = getClass().getResource("lista.txt");
				File archivo = new File(is.getPath());
				//File archivo = new File("/presentacion/lista.txt");
				FileReader fr = new FileReader (archivo);
				BufferedReader br = new BufferedReader(fr);
				// Lectura del fichero linea a linea
				String linea;
				while((linea=br.readLine())!=null) {
					modelo.addElement(linea);
					list.setModel(modelo);
					
				}
				br.close();
				//System.out.println("Fichero leído : " + file.getName() + ".");
			}
			catch (IOException ioe){
				System.out.println("Problemas mientras se leía el archivo");
			}
		
	
			
			
	
	}
	
	
	private class BtnAñadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
				Contacto contactos=new Contacto(txtNombre.getText());
				modelo.addElement(contactos.getNombre());
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			modelo.remove(index);
			Contacto contactos=new Contacto(txtNombre.getText());
			modelo.add(index,contactos.getNombre());
			list.setModel(modelo);
		}
	}
	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			modelo.remove(index);
			list.setModel(modelo);
		}
	}
	
}
