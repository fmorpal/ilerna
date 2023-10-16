package paquete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppTroll {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana Troll");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Desactivar el cierre

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Aumentar el tamaño de la ventana
                Dimension currentSize = frame.getSize();
                int newWidth = currentSize.width + 100; // Aumentar el ancho en 100 píxeles
                int newHeight = currentSize.height + 100; // Aumentar el alto en 100 píxeles
                frame.setSize(newWidth, newHeight);
            }
        });

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
