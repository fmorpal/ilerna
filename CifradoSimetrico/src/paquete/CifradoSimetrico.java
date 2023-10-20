package paquete;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;
import java.util.Scanner;

public class CifradoSimetrico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Tiene una clave secreta? (Sí/No): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        String secretKey;
        if (respuesta.equals("sí") || respuesta.equals("si")) {
            System.out.print("Introduce la clave secreta: ");
            secretKey = scanner.nextLine();
        } else {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(256); // Puedes ajustar la longitud de la clave según tus necesidades
                SecretKey key = keyGenerator.generateKey();
                secretKey = Base64.getEncoder().encodeToString(key.getEncoded());
                System.out.println("Clave generada: " + secretKey);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

        System.out.print("Introduce el texto a cifrar: ");
        String textoSinCifrar = scanner.nextLine();

        String textoCifrado = cifrarSimetrico(secretKey, textoSinCifrar);
        System.out.println("Texto cifrado: " + textoCifrado);

        String textoDescifrado = descifrarSimetrico(secretKey, textoCifrado);
        System.out.println("Texto descifrado: " + textoDescifrado);
    }

    public static String cifrarSimetrico(String secretKey, String textoSinCifrar) {
        try {
            SecretKey key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(textoSinCifrar.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String descifrarSimetrico(String secretKey, String textoCifrado) {
        try {
            SecretKey key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
