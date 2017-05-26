package Bookshelf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MostrarLibro extends SeleccionarAccion{
	
	JTextField codigo;
	JButton mostrar;
	boolean flagCod = false;
	ArrayList<Libro> lista = new ArrayList<Libro>();
	JLabel etTitle, etAuthor, etPrice, etCalif;	
	JTextArea etDesc;
	
	public MostrarLibro(ArrayList<Libro> lista){
		super();
		this.lista = lista;
		System.out.println(lista.size());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mostrar un libro");
		Box cajaV1 = Box.createVerticalBox();		
		Box cajaH1 = Box.createHorizontalBox();
		Box cajaH2 = Box.createHorizontalBox();
		Box cajaH3 = Box.createHorizontalBox();
		
		JLabel etiquetaCod = new JLabel("Código");
		codigo = new JTextField(4);
		codigo.setMaximumSize(codigo.getPreferredSize());
		mostrar = new JButton("Mostrar");		
		cajaH1.add(etiquetaCod);
		cajaH1.add(Box.createHorizontalStrut(40));
		cajaH1.add(codigo);
		cajaH1.add(Box.createHorizontalStrut(40));
		cajaH1.add(mostrar);		
		
		JLabel etiquetaTitle = new JLabel("Título");
		JLabel etiquetaAuthor = new JLabel("Autor");
		JLabel etiquetaPrice = new JLabel("Precio");
		JLabel etiquetaCalif = new JLabel("Calificación");
		JLabel etiquetaDesc = new JLabel("Descripción");
		etTitle = new JLabel("");
		etAuthor = new JLabel("");
		etPrice = new JLabel("");
		etCalif = new JLabel("");
		etDesc = new JTextArea(5,20);
		etDesc.setPreferredSize(new Dimension (5,5));
		etDesc.setMaximumSize(etDesc.getPreferredSize());
		etDesc.setLineWrap(true);
		
		cajaH2.add(etiquetaTitle);
		cajaH2.add(Box.createHorizontalStrut(40));
		cajaH2.add(etiquetaAuthor);
		cajaH2.add(Box.createHorizontalStrut(40));
		cajaH2.add(etiquetaPrice);
		cajaH2.add(Box.createHorizontalStrut(40));
		cajaH2.add(etiquetaCalif);
		cajaH2.add(Box.createHorizontalStrut(40));
		cajaH2.add(etiquetaDesc);
		cajaH3.add(etTitle);
		cajaH3.add(Box.createHorizontalStrut(40));
		cajaH3.add(etAuthor);
		cajaH3.add(Box.createHorizontalStrut(40));
		cajaH3.add(etCalif);
		cajaH3.add(Box.createHorizontalStrut(40));
		cajaH3.add(etPrice);
		cajaH3.add(Box.createHorizontalStrut(40));		
		cajaH3.add(etDesc);		
		
		cajaV1.add(cajaH1);		
		cajaV1.add(cajaH2);
		cajaV1.add(cajaH3);
		lamina.add(cajaV1, BorderLayout.CENTER);		
		mostrar.setEnabled(false);
		
		EventoCodigo eventoCod = new EventoCodigo();
		codigo.getDocument().addDocumentListener(eventoCod);
		EventoBoton eventoBot = new EventoBoton();
		mostrar.addActionListener(eventoBot);		
		
	}	

	private class EventoCodigo implements DocumentListener{
		
		public void changedUpdate(DocumentEvent e) {}
		
		public void insertUpdate(DocumentEvent e) {			
			
			String cod = codigo.getText();
			boolean esEntero = esEntero(cod);
			if(!esEntero){
				codigo.setBackground(Color.RED);
				flagCod = false;
			}
			else{
				codigo.setBackground(Color.WHITE);
				flagCod = true;
			}			
			
			if(flagCod){
				mostrar.setEnabled(true);
			}else{mostrar.setEnabled(false);}
		}	
		
		public void removeUpdate(DocumentEvent e) {			
			
			String cod = codigo.getText();
			boolean esEntero = esEntero(cod);
			if(!esEntero){
				codigo.setBackground(Color.RED);
				flagCod = false;
			}
			else{
				codigo.setBackground(Color.WHITE);
				flagCod = true;
			}			
			
			if(flagCod){
				mostrar.setEnabled(true);
			}else{mostrar.setEnabled(false);}
		}		
		
		public boolean esEntero(String cad){
			
			try {
				Integer.parseInt(cad);
				return true;
				
			} catch (NumberFormatException e) {
				return false;
			}
		}		
		
	}
	
	private class EventoBoton implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
			
			int cod = Integer.parseInt(codigo.getText());
			int tamLista = lista.size();
			
			if(cod<tamLista){
				System.out.println("Usted quiere ver el libro con cod " + cod);			
				System.out.println(lista.get(cod));				
				etTitle.setText(lista.get(cod).getTitle());
				etAuthor.setText(lista.get(cod).getAuthor());
				etCalif.setText(Integer.toString(lista.get(cod).getRating()));
				etPrice.setText(Double.toString(lista.get(cod).getPrice()));
				etDesc.setText(lista.get(cod).getDesc());				
			}
			else{
				JOptionPane.showMessageDialog(MostrarLibro.this, "El código ingresado no existe", "Informativo", 1);
			}
			
		}
		
		
	}

}
