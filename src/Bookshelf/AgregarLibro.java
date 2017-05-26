package Bookshelf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AgregarLibro extends SeleccionarAccion{
	
	protected JTextField titulo, autor, precio;	
	protected JSlider calif;	
	protected JTextArea descripcion;
	protected JScrollPane laminaArea;
	protected JButton botonAgregar, botonBorrar, botonAtras;	
	protected boolean flagName, flagAuthor, flagPri;
	ArrayList<Libro> lista = new ArrayList<Libro>();
	
	public AgregarLibro(ArrayList<Libro> lista){
		
		super();
		this.lista = lista;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		descripcion.setLineWrap(true);			
		laminaArea = new JScrollPane(descripcion);
		laminaArea.setPreferredSize(new Dimension (5,5));
		laminaArea.setMaximumSize(descripcion.getPreferredSize());	
		
		
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
		cajaV2.add(laminaArea);		
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
		botonAgregar.setEnabled(false);		
		
		//Eventos de los componentes
		EventosBotones eventoBot = new EventosBotones();
		botonAgregar.addActionListener(eventoBot);
		botonBorrar.addActionListener(eventoBot);
		botonAtras.addActionListener(eventoBot);
		NameEvent eventoTit = new NameEvent();
		AuthorEvent eventoAut = new AuthorEvent();
		PriceEvent eventoPri = new PriceEvent();		
		
		titulo.getDocument().addDocumentListener(eventoTit);
		autor.getDocument().addDocumentListener(eventoAut);
		precio.getDocument().addDocumentListener(eventoPri);
	}	
	
	class EventosBotones implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			switch(e.getActionCommand()){
			case "Agregar":					
				botonAgregar.setEnabled(false);				
				String capTitulo = titulo.getText();
				String capAutor = autor.getText();
				int capCalif = calif.getValue();				
				double capPrice = Double.parseDouble(precio.getText());
				String capReview = descripcion.getText();				
				
				listaLibros.add(new Libro(capTitulo, capAutor, capCalif, capPrice, capReview));	
				for(Libro elem: listaLibros){
					System.out.println(elem.toString());
				}								
				JOptionPane.showMessageDialog(AgregarLibro.this, "Se ha ingresado un libro", "Informativo", 1);				
				titulo.setText("");
				titulo.setBackground(Color.WHITE);
				autor.setText("");
				autor.setBackground(Color.WHITE);
				precio.setText("");
				precio.setBackground(Color.WHITE);
				descripcion.setText("");				
				break;
			case "Borrar todo":
				titulo.setText("");
				titulo.setBackground(Color.WHITE);
				autor.setText("");
				autor.setBackground(Color.WHITE);
				precio.setText("");
				precio.setBackground(Color.WHITE);
				descripcion.setText("");
				break;	
			case "Regresar":
				AgregarLibro.this.dispose();	
				SeleccionarAccion marcoPrincipal = new SeleccionarAccion();
				marcoPrincipal.setVisible(true);
				break;
			default:
				break;			
			}				
			
		}		
		
	}	
	
	
	class PriceEvent implements DocumentListener{		
		
		
		public void changedUpdate(DocumentEvent e) {}
		
		public void insertUpdate(DocumentEvent e) {
			
			if(flagName==true && flagAuthor==true && flagPri==true){
				botonAgregar.setEnabled(true);}
			else{botonAgregar.setEnabled(false);}
			
			String price = precio.getText();			
			boolean valDecimal = esDecimal(price);
			if(!valDecimal){
				precio.setBackground(Color.RED);
				flagPri = false;
			}
			else{
				precio.setBackground(Color.WHITE);
				flagPri = true;
			}
			//System.out.println("flagPri =" + flagPri);
			
		}
		
		public void removeUpdate(DocumentEvent e) {
			
			if(flagName==true && flagAuthor==true && flagPri==true){
				botonAgregar.setEnabled(true);}
			else{botonAgregar.setEnabled(false);}
			
			String price = precio.getText();			
			boolean valDecimal = esDecimal(price);
			if(!valDecimal){
				precio.setBackground(Color.RED);				
			}
			else{
				precio.setBackground(Color.WHITE);
				flagPri = true;
			}
			//System.out.println("flagPri =" + flagPri);
			
		}
		
		public boolean esDecimal (String cadena){
			
			try {
				Double.parseDouble(cadena);
				return true;
				
			} catch (NumberFormatException e) {
				return false;
			}
		}		
		
	}
	
	class NameEvent implements DocumentListener{
		
		public void changedUpdate(DocumentEvent e) {}
		
		public void insertUpdate(DocumentEvent e) {	
			
			if(flagName==true && flagAuthor==true && flagPri==true){
				botonAgregar.setEnabled(true);}
			else{botonAgregar.setEnabled(false);}
			
			String texto = " ";			
			texto = titulo.getText();					
						
			boolean alfa = esAlfaNumerico(texto);
			if (alfa && texto.length()>=5){				
				titulo.setBackground(Color.WHITE);
				flagName = true;
			}else{
				titulo.setBackground(Color.RED);
				flagName = false;			
			}			
			//System.out.println("flagName =" + flagName);
			
		}
		
		public void removeUpdate(DocumentEvent e) {
			
			if(flagName==true && flagAuthor==true && flagPri==true){
				botonAgregar.setEnabled(true);}
			else{botonAgregar.setEnabled(false);}
			
			String texto = " ";			
			texto = titulo.getText();					
						
			boolean alfa = esAlfaNumerico(texto);
			if (alfa && texto.length()>=5){				
				titulo.setBackground(Color.WHITE);
				flagName = true;
			}else{
				titulo.setBackground(Color.RED);
				flagName = false;			
			}
			
			//System.out.println("flagName =" + flagName);
			
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
	
	class AuthorEvent implements DocumentListener{
		
		public void changedUpdate(DocumentEvent e) {}
		
		public void insertUpdate(DocumentEvent e) {	
			
			if(flagName==true && flagAuthor==true && flagPri==true){
				botonAgregar.setEnabled(true);}
			else{botonAgregar.setEnabled(false);}
			
			String texto = " ";			
			texto = autor.getText();					
			System.out.println(texto);			
			boolean alfa = esAlfaNumerico(texto);
			if (alfa && texto.length()>=5){				
				autor.setBackground(Color.WHITE);
				flagAuthor = true;
			}else{
				autor.setBackground(Color.RED);
				flagAuthor = false;			
			}
			
			//System.out.println("flagAuthor =" + flagAuthor);			
		}
		
		public void removeUpdate(DocumentEvent e) {
			
			if(flagName==true && flagAuthor==true && flagPri==true){
				botonAgregar.setEnabled(true);}
			else{botonAgregar.setEnabled(false);}	
			
			String texto = " ";			
			texto = autor.getText();					
						
			boolean alfa = esAlfaNumerico(texto);
			if (alfa && texto.length()>=5){				
				autor.setBackground(Color.WHITE);
				flagAuthor = true;
			}else{
				autor.setBackground(Color.RED);
				flagAuthor = false;			
			}
			
			//System.out.println("flagAuthor =" + flagAuthor);
			
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



