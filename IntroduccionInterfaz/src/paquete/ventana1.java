package paquete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



	public class ventana1 extends JFrame implements ActionListener{

		  private JButton boton1;
		  private JLabel label1;

		  public ventana1() {

		    setLayout(null);
		   
		    
		    
		    setBounds(10,10,410,210);

		    
		    setTitle("Ejemplo: Varias Ventanas");

		    
		    setResizable(false);

		   
		    setDefaultCloseOperation(EXIT_ON_CLOSE);

		    
		    label1 = new JLabel("Esta es la ventana principal");
		    label1.setBounds(115,60,200,30);
		    add(label1);

		    
		    boton1 = new JButton("Haz clic aquí");
		    boton1.setBounds(105,110,200,40);
		    add(boton1);

		    
		    boton1.addActionListener(this);

		    
		    setVisible(true);

		  }

		
		  public void actionPerformed(ActionEvent e) {
		    if (e.getSource() == boton1) {
		     
		      ventana2 secundaria = new ventana2(this,true);
		      secundaria.setVisible(true);
		    }
		  }

		  
		  public static void main(String[] args) {

		    new ventana1();

		  }
		}