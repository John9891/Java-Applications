package Bookshelf;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AgregarLibro extends SeleccionarAccion{
	
	protected JTextField titulo;
	protected JTextField autor;
	protected JSlider calif;
	protected JTextField precio;
	protected JTextArea descripcion;
	protected JButton botonAgregar;
	protected JButton botonBorrar;
	protected JButton botonAtras;
	
	public AgregarLibro(){
		
		super();	
		setTitle("Agregar un nuevo libro");		
		
		Box cajaH = Box.createHorizontalBox();
		Box cajaV1 = Box.createVerticalBox();
		Box cajaV2 = Box.createVerticalBox();
		
		
		JLabel et_titulo = new JLabel("Título del libro");		
		et_titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel et_nombreAutor = new JLabel("Nombre del autor");
		et_nombreAutor.setAlignmentX(CENTER_ALIGNMENT);
		JLabel et_califica = new JLabel("Calificación");
		et_califica.setAlignmentX(CENTER_ALIGNMENT);
		JLabel et_precio = new JLabel("Precio");
		et_precio.setAlignmentX(CENTER_ALIGNMENT);
		JLabel et_descr = new JLabel("Descripción");
		et_descr.setAlignmentX(CENTER_ALIGNMENT);
		
		titulo = new JTextField(10);
		titulo.setMaximumSize(titulo.getPreferredSize());
		titulo.getDocument().putProperty("clave", titulo);
		autor = new JTextField(10);
		autor.setMaximumSize(autor.getPreferredSize());
		autor.getDocument().putProperty("clave", autor);
		calif = new JSlider(0, 5);
		calif.setMajorTickSpacing(1);
		calif.setMinorTickSpacing(0);
		calif.setPaintLabels(true);		//Show the number on the JSlider
		calif.setPaintTicks(true);
		calif.setFont(new Font("Serif", Font.BOLD, 10));		
		calif.setMaximumSize(calif.getPreferredSize());		
		precio = new JTextField(10);		
		precio.setMaximumSize(precio.getPreferredSize());
		descripcion = new JTextArea(5,20);
		descripcion.setPreferredSize(new Dimension (5,5));
		descripcion.setMaximumSize(descripcion.getPreferredSize());			
		
		cajaV1.add(et_titulo);
		cajaV1.add(Box.createVerticalStrut(30));
		cajaV1.add(et_nombreAutor);
		cajaV1.add(Box.createVerticalStrut(40));
		cajaV1.add(et_califica);
		cajaV1.add(Box.createVerticalStrut(30));
		cajaV1.add(et_precio);
		cajaV1.add(Box.createVerticalStrut(50));
		cajaV1.add(et_descr);
		cajaV1.add(Box.createVerticalStrut(50));		
		cajaV2.add(titulo);
		cajaV2.add(Box.createVerticalStrut(20));
		cajaV2.add(autor);
		cajaV2.add(Box.createVerticalStrut(20));
		cajaV2.add(calif);
		cajaV2.add(Box.createVerticalStrut(20));
		cajaV2.add(precio);
		cajaV2.add(Box.createVerticalStrut(20));
		cajaV2.add(descripcion);		
		cajaH.add(cajaV1);
		cajaH.add(cajaV2);		
		lamina.add(cajaH, BorderLayout.CENTER);	
		
		Box cajaH2 =  Box.createHorizontalBox();
		botonAgregar = new JButton("Agregar");			
		botonBorrar = new JButton("Borrar todo");		
		botonAtras = new JButton("Regresar");		
		
		cajaH2.add(Box.createHorizontalStrut(130));
		cajaH2.add(botonAgregar);
		cajaH2.add(Box.createHorizontalStrut(20));
		cajaH2.add(botonBorrar);
		cajaH2.add(Box.createHorizontalStrut(20));
		cajaH2.add(botonAtras);
		cajaH2.add(Box.createVerticalStrut(40));
		cajaH2.setAlignmentX(0);		
		lamina.add(cajaH2, BorderLayout.SOUTH);
		
		//Eventos de los componentes
		EventosBotones eventoBot = new EventosBotones();
		botonAgregar.addActionListener(eventoBot);
		EventosTexto eventoTex = new EventosTexto();
		titulo.getDocument().addDocumentListener(eventoTex);
		autor.getDocument().addDocumentListener(eventoTex);
	}	
	
	class EventosBotones implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			switch(e.getActionCommand()){
			case "Agregar":				
				System.out.println("Ha agregado el libro");				
				break;
			default:
				break;			
			}			
			
		}		
		
	}
	
	class EventosTexto implements DocumentListener{
		
		public void changedUpdate(DocumentEvent e) {}
		
		public void insertUpdate(DocumentEvent e) {				
			
			String tituloTexto = " ";
			
			if(e.getDocument()==titulo.getDocument()){
				tituloTexto = titulo.getText();
			}
			else if(e.getDocument()==autor.getDocument()){
				tituloTexto = autor.getText();
			}			
						
			boolean alfa = esAlfaNumerico(tituloTexto);
			if (alfa && tituloTexto.length()>=5){
				botonAgregar.setEnabled(true);	
			}else{botonAgregar.setEnabled(false);}	
			
		}
		
		public void removeUpdate(DocumentEvent e) {
			String tituloTexto = titulo.getText();			
			boolean alfa = esAlfaNumerico(tituloTexto);
			if (alfa && tituloTexto.length()>=5){
				botonAgregar.setEnabled(true);	
			}else{botonAgregar.setEnabled(false);}		
			
		}
		//retorna true si la cadena contiene al menos una letra
		public boolean esAlfaNumerico (String cadena){
			for(int i=0; i<cadena.length();i++){
				char caracter = cadena.charAt(i);
				if(Character.isLetter(caracter)){
					return true;					
				}
			}
			return false;
			
		}
		
		
	}
	

}



