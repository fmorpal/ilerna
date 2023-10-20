package paquete;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;
import java.util.Scanner;

public class CifradoAsimetrico {
    private static PublicKey publicKey;
    private static PrivateKey privateKey;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción:");
        System.out.println("1. Cifrar un mensaje");
        System.out.println("2. Descifrar un mensaje");
        System.out.println("3. Regenerar claves pública y privada");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            generarKeysAsimetrica();
            System.out.print("Introduce el mensaje a cifrar: ");
            String mensaje = scanner.nextLine();
            String mensajeCifrado = cifrarAsimetrico(mensaje);
            System.out.println("Mensaje cifrado: " + mensajeCifrado);
        } else if (opcion == 2) {
            System.out.print("Introduce el mensaje cifrado: ");
            String mensajeCifrado = scanner.nextLine();
            String mensajeDescifrado = descifrarAsimetrico(mensajeCifrado);
            System.out.println("Mensaje descifrado: " + mensajeDescifrado);
        } else if (opcion == 3) {
            generarKeysAsimetrica();
            System.out.println("Claves pública y privada regeneradas.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public static void generarKeysAsimetrica() {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048); // Puedes ajustar la longitud de la clave según tus necesidades
            KeyPair keyPair = keyPairGen.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String cifrarAsimetrico(String textoSinCifrar) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = cipher.doFinal(textoSinCifrar.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String descifrarAsimetrico(String textoCifrado) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

