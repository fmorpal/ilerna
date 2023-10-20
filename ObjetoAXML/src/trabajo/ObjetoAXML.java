package trabajo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

//los nodos salen en orden alfabetico; usa xmltype proporder para ordenarlos como quieras

public class ObjetoAXML {
    public static void main(String[] args) throws JAXBException {
        // Crear un objeto de Videojuego
        Genero genero = Genero.accion; // Reemplaza con el género deseado
        Subgenero subgenero = Subgenero.plataformas; // Reemplaza con el subgénero deseado
        Jugadores jugadores = new Jugadores(1, 4, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12); // Reemplaza con los valores deseados
        Videojuego videojuego = new Videojuego(
                "Ejemplo de Videojuego",
                "Desarrollador Ejemplo",
                "Director Ejemplo",
                "Productor Ejemplo",
                genero,
                subgenero,
                16, // Reemplaza con el valor deseado
                2023, // Reemplaza con el año deseado
                "PS5, Xbox Series X, PC", // Reemplaza con las plataformas deseadas
                jugadores
        );

        // Crear el contexto JAXB para la clase Videojuego
        JAXBContext contextObj = JAXBContext.newInstance(Videojuego.class);

        // Crear un objeto Marshaller
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Convertir el objeto Videojuego a XML y escribirlo en un archivo
        try {
marshallerObj.marshal(videojuego, new FileOutputStream("videojuego.xml"));
} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (JAXBException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

        System.out.println("El objeto Videojuego se ha convertido a XML y se ha guardado en el archivo 'videojuego.xml'.");
    }
}