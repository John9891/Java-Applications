package Bookshelf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SeleccionarAccion extends JFrame{
	
	protected JPanel lamina;
	protected JMenuBar barraMenu;
	JMenu menuArchivo;
	JMenu menuEdicion;
	JMenuItem itemInicio;
	JMenuItem itemSalir;
	JMenuItem itemAgregar;
	JMenuItem itemModificar;
	JMenuItem itemMostrar;
	JMenuItem itemEliminar;
	ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	
	public SeleccionarAccion(){			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,150,600,400);
		setTitle("Mi marco principal");
		lamina = new JPanel();		
		lamina.setLayout(new BorderLayout());
		JMenuBar barraMenu = new JMenuBar();		
		JMenu menuArchivo = new JMenu("Archivo");
		JMenu menuEdicion = new JMenu("Edición");
		JMenuItem itemInicio = new JMenuItem("Inicio");
		JMenuItem itemSalir = new JMenuItem("Salir");
		JMenuItem itemAgregar = new JMenuItem("Agregar libro");
		JMenuItem itemModificar = new JMenuItem("Modificar libro");
		JMenuItem itemMostrar = new JMenuItem("Mostrar libro");
		JMenuItem itemEliminar = new JMenuItem("Eliminar libro");
		
		menuArchivo.add(itemInicio);
		menuArchivo.add(itemSalir);
		menuEdicion.add(itemAgregar);
		menuEdicion.add(itemModificar);
		menuEdicion.add(itemMostrar);
		menuEdicion.add(itemEliminar);
		barraMenu.add(menuArchivo);
		barraMenu.add(menuEdicion);		
		lamina.add(barraMenu,BorderLayout.NORTH);
		add(lamina);
		
		eventosMenu evento = new eventosMenu();
		itemAgregar.addActionListener(evento);
		itemInicio.addActionListener(evento);
		itemSalir.addActionListener(evento);
		itemModificar.addActionListener(evento);
		itemMostrar.addActionListener(evento);
		itemEliminar.addActionListener(evento);
		
	}
	
	class eventosMenu implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {				
			
			switch (e.getActionCommand()) {
			case "Inicio":
				SeleccionarAccion.this.dispose();
				//SeleccionarAccion.this.setVisible(false);
				SeleccionarAccion marcoPrincipal = new SeleccionarAccion();
				marcoPrincipal.setVisible(true);
				break;		
			case "Salir":				
				System.exit(0);
				break;				
			case "Agregar libro":
				SeleccionarAccion.this.setVisible(false);
				//SeleccionarAccion.this.dispose();	
				AgregarLibro marcoAgregar = new AgregarLibro(listaLibros);
				marcoAgregar.setVisible(true);							
				break;
			case "Modificar libro":
				System.out.println("Quieres modificar un libro");
				break;
			case "Mostrar libro":
				SeleccionarAccion.this.setVisible(false);
				//SeleccionarAccion.this.dispose();
				MostrarLibro marcoMostrar = new MostrarLibro(listaLibros);
				marcoMostrar.setVisible(true);				
				break;
			case "Eliminar libro":
				System.out.println("Quieres eliminar un libro");
				break;
			default:
				break;
			}
			
			
		}
		
		
	}
	

}
	



