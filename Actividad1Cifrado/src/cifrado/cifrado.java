package cifrado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class cifrado {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nombre del archivo donde se almacenará la contraseña
        String nombreArchivo = "contraseña.txt";

        // Pide al usuario que ingrese una contraseña
        System.out.print("Introduce una contraseña: ");
        String nuevaContraseña = scanner.nextLine();

        // Guarda la contraseña en el archivo
        guardarContraseña(nombreArchivo, nuevaContraseña);

        // Pide al usuario que ingrese la contraseña nuevamente
        System.out.print("Introduce la contraseña para acceder al archivo: ");
        String contraseñaIngresada = scanner.nextLine();
//
        // Comprueba si la contraseña ingresada es correcta
        boolean contraseñaCorrecta = verificarContraseña(nombreArchivo, contraseñaIngresada);

        if (contraseñaCorrecta) {
            System.out.println("Contraseña correcta. Acceso permitido al archivo.");
        } else {
            System.out.println("Contraseña incorrecta. Acceso denegado.");
        }

        scanner.close();
    }

    // Método para guardar la contraseña en un archivo
    private static void guardarContraseña(String nombreArchivo, String contraseña) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(contraseña);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para verificar si la contraseña ingresada coincide con la almacenada en el archivo
    private static boolean verificarContraseña(String nombreArchivo, String contraseñaIngresada) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String contraseñaAlmacenada = reader.readLine();
            return contraseñaIngresada.equals(contraseñaAlmacenada);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
