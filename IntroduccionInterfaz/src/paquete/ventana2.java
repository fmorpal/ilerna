package paquete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ventana2 extends JDialog implements ActionListener{

	  private JButton boton2;
	  private JLabel label1;
	  
	  public ventana2(ventana1 parent, boolean modal) {
	    
	    super(parent, modal);

	    setLayout(null);
	    setBounds(440,10,410,210);

	    label1 = new JLabel("Esta es la ventana secundaria");
	    label1.setBounds(115,60,200,30);
	    add(label1);

	    boton2 = new JButton("Volver");
	    boton2.setBounds(105,110,200,40);
	    add(boton2);

	   
	    boton2.addActionListener(this);

	  }

	  public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == boton2) {
	      
	      setVisible(false);
	    }
	  }

	}