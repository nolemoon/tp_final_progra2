package Productos;


import Enum.Genero;
import Enum.Suscripcion;

/**
 * Clase final que representa una serie, extiende de la clase abstracta
 * {@code Producto}. Agrega como atributos específicos temporadas y capitulos.
 * Es decir, contiene toda la info. general heredada de Producto, sumando datos propios.
 * @author Agustino
 */
public final class Serie extends Producto{


    private int temporadas;
    private int capitulos;

    /**
     * Constructor que llama al super() vacío.
     */
    public Serie() {
        super();
    }

    /**
     * Constructor que inicializa una serie con todos sus atributos.
     *
     * @param nombre nombre de la serie
     * @param genero género al que pertenece
     * @param precio precio de compra o alquiler
     * @param anioPublicado año en el que comenzó a emitir
     * @param creador creador de la serie
     * @param descripcion sinopsis de la serie
     * @param tipoSuscripcion suscripción para acceder
     * @param temporadas cantidad total de temporadas
     * @param capitulos cantidad total de capítulos
     */
    public Serie(String nombre, Genero genero, double precio, int anioPublicado, String creador, String descripcion,
                  Suscripcion tipoSuscripcion, int temporadas, int capitulos) {
        super(nombre, genero, precio, anioPublicado, creador, descripcion, tipoSuscripcion);
        this.temporadas = temporadas;
        this.capitulos = capitulos;
    }

    // Getter y Setter
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    // To String
    @Override
    public String toString() {
        return "Series{" +
                "temporadas=" + temporadas +
                ", capitulos=" + capitulos + super.toString() +
                '}';
    }

}
