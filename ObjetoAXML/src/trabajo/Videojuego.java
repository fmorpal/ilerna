package trabajo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Videojuego {
    private final int ID;
    private String titulo;
    private String desarrollador;
    private String director;
    private String productor;
    private Genero genero;
    private Subgenero subgenero;
    private int pegi;
    private int anno;
    private static int contador;
    private String plataforma;
    private Jugadores jugadores;

    public Videojuego(String titulo, String desarrollador, String director, String productor, Genero genero,
                      Subgenero subgenero, int pegi, int anno, String plataforma, Jugadores jugadores) {
        super();
        this.ID = contador++;
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.director = director;
        this.productor = productor;
        this.genero = genero;
        this.subgenero = subgenero;
        this.pegi = pegi;
        this.anno = anno;
        this.plataforma = plataforma;
        this.jugadores = jugadores;
    }

    public Videojuego() {
        this.ID = -1;
    }

    @XmlElement
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlElement
    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    @XmlElement
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @XmlElement
    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    @XmlElement
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @XmlElement
    public Subgenero getSubgenero() {
        return subgenero;
    }

    public void setSubgenero(Subgenero subgenero) {
        this.subgenero = subgenero;
    }

    @XmlElement
    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    @XmlElement
    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @XmlElement
    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @XmlElement
    public Jugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugadores jugadores) {
        this.jugadores = jugadores;
    }

    @XmlElement
    public int getID() {
        return ID;
    }

    public static void resetearContador() {
        contador = 0;
    }

    @Override
    public String toString() {
        return "Videojuego [ID=" + ID + ", titulo=" + titulo + ", desarrollador=" + desarrollador + ", director=" + director
                + ", productor=" + productor + ", genero=" + genero + ", subgenero=" + subgenero + ", pegi=" + pegi
                + ", anno=" + anno + ", plataforma=" + plataforma + ", jugadores=" + jugadores.toString() + "]";
    }
}
