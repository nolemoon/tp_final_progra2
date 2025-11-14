package Productos;


import Enum.Genero;
import Enum.Suscripcion;

/**
 * Clase final que representa una película, extiende de la clase abstracta
 * {@code Producto}. Agrega como atributos específicos duración y clasificación.
 * Es decir, contiene toda la info. general heredada de Producto, sumando datos propios.
 * @author Agustino
 */
public final class Pelicula extends Producto{

    private double duracion;
    private String clasificacion;

    /**
     * Constructor que invoca al super() vacío.
     */
    public Pelicula() {
        super();
    }

    /**
     * Constructor que inicializa una Pelicula con todos sus atributos.
     * @param nombre nombre de la película
     * @param genero género al que pertenece
     * @param precio precio de compra o alquiler
     * @param anioPublicado año en que fue publicada
     * @param creador director de la película
     * @param descripcion sinopsis de la pelicula
     * @param tipoSuscripcion suscripción para acceder
     * @param duracion duración total en minutos
     * @param clasificacion clasificacion por edad
     */
    public Pelicula(String nombre, Genero genero, double precio, int anioPublicado, String creador, String descripcion,
                    Suscripcion tipoSuscripcion, double duracion, String clasificacion) {
        super(nombre, genero, precio, anioPublicado, creador, descripcion, tipoSuscripcion);
        this.duracion = duracion;
        this.clasificacion = clasificacion;
    }

    // Getter y Setter
    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    // To String
    @Override
    public String toString() {
        return "Pelicula{" +
                "duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' + super.toString() +
                '}';
    }
}
