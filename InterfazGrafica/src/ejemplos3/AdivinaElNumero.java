package ejemplos3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AdivinaElNumero extends JFrame {
    private int numeroObjetivo;
    private int intentosRestantes;
    private JTextField campoSuposicion;
    private JLabel etiquetaResultado;
    private JButton botonReiniciar;
    private JButton botonSuposicion;

    public AdivinaElNumero() {
        setTitle("Adivina el número");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        etiquetaResultado = new JLabel("Adivina un número entre 1 y 100.");
        add(etiquetaResultado, BorderLayout.NORTH);

        campoSuposicion = new JTextField(10);
        botonSuposicion = new JButton("Adivinar");
        botonSuposicion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprobarSuposicion();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Tu suposición: "));
        panel.add(campoSuposicion);
        panel.add(botonSuposicion);

        add(panel, BorderLayout.CENTER);
        
        botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego(); 
            }
        });
        
        JPanel panelBoton = new JPanel();
        panelBoton.add(botonReiniciar);
        add(panelBoton, BorderLayout.SOUTH);

        iniciarJuego();
    }

    private void iniciarJuego() {
    	botonReiniciar.setEnabled(false);
    	botonReiniciar.setVisible(false);
    	botonSuposicion.setEnabled(true);
        botonSuposicion.setVisible(true);
        Random random = new Random();
        numeroObjetivo = random.nextInt(100) + 1;
        intentosRestantes = 10;
        etiquetaResultado.setText("Adivina un número entre 1 y 100.");
        campoSuposicion.setText("");
    }

    private void comprobarSuposicion() {
        try {
            int suposicion = Integer.parseInt(campoSuposicion.getText());

            if (suposicion == numeroObjetivo) {
                etiquetaResultado.setText("¡Felicidades! Adivinaste el número.");

                botonReiniciar.setEnabled(true);
                botonReiniciar.setVisible(true);
                botonSuposicion.setEnabled(false);
                botonSuposicion.setVisible(false);
            } else {
                intentosRestantes--;

                if (suposicion < numeroObjetivo) {
                    etiquetaResultado.setText("Intenta un número mayor. Intentos restantes: " + intentosRestantes);
                } else {
                    etiquetaResultado.setText("Intenta un número menor. Intentos restantes: " + intentosRestantes);
                }

                if (intentosRestantes == 0) {
                    etiquetaResultado.setText("¡Agotaste tus intentos! El nÃºmero era " + numeroObjetivo);
                    //iniciarJuego(); // Reiniciar el juego
                    botonReiniciar.setEnabled(true);
                    botonReiniciar.setVisible(true);
                    botonSuposicion.setVisible(false);
                    botonSuposicion.setVisible(false);
                }
            }
        } catch (NumberFormatException e) {
            etiquetaResultado.setText("Por favor, ingresa un número valido.");
        }
        campoSuposicion.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdivinaElNumero().setVisible(true);
            }
        });
    }
}
