package cifrado;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class cifrado2 {
	  public static void main(String[] args) throws NoSuchAlgorithmException {
	        Scanner scanner = new Scanner(System.in);

	        // Nombre del archivo donde se almacenará el hash de la contraseña
	        String nombreArchivo = "hash_contraseña.txt";

	        // Pide al usuario que ingrese una contraseña
	        System.out.print("Introduce una contraseña: ");
	        String contraseña = scanner.nextLine();

	        // Hasheamos la contraseña antes de guardarla
	        String hashContraseña = hashContraseña(contraseña);

	        // Guarda el hash de la contraseña en el archivo
	        guardarHashContraseña(nombreArchivo, hashContraseña);

	        // Pide al usuario que ingrese la contraseña nuevamente
	        System.out.print("Introduce la contraseña para acceder al archivo: ");
	        String contraseñaIngresada = scanner.nextLine();

	        // Hasheamos la contraseña ingresada y la comparamos con el hash almacenado
	        String hashContraseñaIngresada = hashContraseña(contraseñaIngresada);
	        boolean contraseñaCorrecta = verificarHashContraseña(nombreArchivo, hashContraseñaIngresada);

	        if (contraseñaCorrecta) {
	            System.out.println("Contraseña correcta. Acceso permitido al archivo.");
	        } else {
	            System.out.println("Contraseña incorrecta. Acceso denegado.");
	        }

	        scanner.close();
	    }

	    // Método para hashear la contraseña usando SHA-256
	    private static String hashContraseña(String contraseña) throws NoSuchAlgorithmException {
	        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	        byte[] hashBytes = messageDigest.digest(contraseña.getBytes());
	        return Base64.getEncoder().encodeToString(hashBytes);
	    }

	    // Método para guardar el hash de la contraseña en un archivo
	    private static void guardarHashContraseña(String nombreArchivo, String hashContraseña) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
	            writer.write(hashContraseña);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Método para verificar si el hash de la contraseña ingresada coincide con el hash almacenado
	    private static boolean verificarHashContraseña(String nombreArchivo, String hashContraseñaIngresada) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
	            String hashContraseñaAlmacenada = reader.readLine();
	            return hashContraseñaIngresada.equals(hashContraseñaAlmacenada);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
