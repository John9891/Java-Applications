package CuadrosBotones;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Pizza {

	public static void main(String[] args) {
		
		MarcoPizza marco = new MarcoPizza();
		marco.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		marco.setVisible(true);
		JOptionPane.showMessageDialog(null, "Bienvenido a nuestra Pizzeria. Pulse Aceptar para iniciar");		

	}
}

class MarcoPizza extends JFrame{
	
	public MarcoPizza(){
		
		setBounds(250,150,600,400);
		setTitle("Campo de texto");
		LaminaPizza lamina = new LaminaPizza();
		add(lamina);
		addWindowListener(new eventoVentana());
	}
	
	public void cerrar(){
		Object [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(rootPane,"En realidad desea realizar cerrar la aplicacion","Mensaje de Confirmacion",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION){
			System.exit(0);
			}
		}	

	class eventoVentana extends WindowAdapter{
		
		public void windowClosing(WindowEvent e){		
			Object [] opciones ={"Aceptar","Cancelar"};
			int eleccion = JOptionPane.showOptionDialog(rootPane,"En realidad desea realizar cerrar la aplicacion","Mensaje de Confirmacion",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
			if (eleccion == JOptionPane.YES_OPTION){
				System.exit(0);
				}
			}
		}	
}

class LaminaPizza extends JPanel{
	
	public LaminaPizza(){
		
		setLayout(new BorderLayout());
		JPanel laminaSup = new JPanel();
		laminaSup.setLayout(new GridLayout(1,2,10,10));
		add(laminaSup, BorderLayout.CENTER);
		JPanel laminaIngred = new JPanel();	
		laminaSup.add(laminaIngred);
		JPanel laminaTam = new JPanel();		
		laminaSup.add(laminaTam);
		JPanel laminaRes = new JPanel();				
		add(laminaRes, BorderLayout.SOUTH);		
		
		CheckBacon = new JCheckBox("Bacon");		
		CheckAnchoas = new JCheckBox("Anchoas");	
		CheckCebolla = new JCheckBox("Cebolla");		
		CheckPimiento = new JCheckBox("Pimiento");		
		
		ButtonGroup grupoTamano = new ButtonGroup();
		Pequeno = new JRadioButton("Pequeña", true);		
		Mediano = new JRadioButton("Mediana", false);		
		Familiar = new JRadioButton("Familiar", false);				
		total = new JButton("Total");
		total.setHorizontalAlignment(SwingConstants.LEFT);
		ingredientes = new JLabel("Ingredientes");
		tamano = new JLabel("Tamaño");		
		res = new JTextField("");		
		res.setFont(new Font("Serif", Font.PLAIN, 24));
		res.setEditable(false);
		grupoTamano.add(Pequeno);
		grupoTamano.add(Mediano);
		grupoTamano.add(Familiar);
		
		//Elements disposition		
		Box cajaVer1 = Box.createVerticalBox();
		cajaVer1.add(Box.createVerticalStrut(50));		
		cajaVer1.add(ingredientes);
		cajaVer1.add(Box.createVerticalStrut(20));
		cajaVer1.add(CheckBacon);
		cajaVer1.add(Box.createVerticalStrut(10));
		cajaVer1.add(CheckAnchoas);
		cajaVer1.add(Box.createVerticalStrut(10));
		cajaVer1.add(CheckCebolla);
		cajaVer1.add(Box.createVerticalStrut(10));
		cajaVer1.add(CheckPimiento);
		cajaVer1.add(Box.createVerticalStrut(10));
		laminaIngred.add(cajaVer1);
		
		Box cajaVer2 = Box.createVerticalBox();
		cajaVer2.add(Box.createVerticalStrut(50));
		cajaVer2.add(tamano);
		cajaVer2.add(Box.createVerticalStrut(20));
		cajaVer2.add(Pequeno);
		cajaVer2.add(Box.createVerticalStrut(15));
		cajaVer2.add(Mediano);
		cajaVer2.add(Box.createVerticalStrut(15));
		cajaVer2.add(Familiar);
		laminaTam.add(cajaVer2);
		
		Box cajaVer3 = Box.createVerticalBox();			
		cajaVer3.add(total);
		cajaVer3.add(Box.createHorizontalStrut(50));
		cajaVer3.add(res);		
		laminaRes.add(cajaVer3);				
			
		
		gestionaEventos evento = new gestionaEventos();
		CheckBacon.addActionListener(evento);
		CheckAnchoas.addActionListener(evento);
		CheckCebolla.addActionListener(evento);
		CheckPimiento.addActionListener(evento);
		Pequeno.addActionListener(evento);
		Mediano.addActionListener(evento);
		Familiar.addActionListener(evento);
		total.addActionListener(evento);
	}
	
	private class gestionaEventos implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			double valor = 0;
			String resultado;
			if(CheckBacon.isSelected()){
				valor +=1.5;}
			if(CheckAnchoas.isSelected()){
				valor += 1.8;}
			if(CheckCebolla.isSelected()){
				valor += 1;}
			if(CheckPimiento.isSelected()){
				valor += 1.2;}
			
			if(Pequeno.isSelected()){
				valor +=7;}
			if(Mediano.isSelected()){
				valor+=9;}
			if(Familiar.isSelected()){
				valor+=11;}
			
			if(total.hasFocus()){
				resultado = Double.toString(valor);
				res.setText(resultado);
			}
						
		}		
		
	}
	
	private JCheckBox CheckBacon;
	private JCheckBox CheckAnchoas;
	private JCheckBox CheckCebolla;
	private JCheckBox CheckPimiento;
	private JRadioButton Pequeno, Mediano, Familiar;
	private JButton total;
	private JLabel ingredientes, tamano;
	private JTextField res;
}

