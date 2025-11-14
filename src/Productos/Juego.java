package Productos;


import Enum.Suscripcion;
import Enum.Genero;

/**
 * Clase final que representa un videojuego, extiende de la clase abstracta
 * {@code Producto}. Agrega como atributos específicos requisitos minimos y multiplayer.
 * Es decir, contiene toda la info. general heredada de Producto, sumando datos propios.
 * @author Agustino
 */
public final class Juego extends Producto {

    // Atributos
    private String requisitosMinimos;
    private boolean multiplayer;

    /**
     * Constructor que llama al super() vacío.
     */
    public Juego() {
        super();
    }

    /**
     * Constructor que inicializa un juego con todos sus atributos.
     *
     * @param nombre nombre del juego
     * @param genero género al que pertenece
     * @param precio precio del juego
     * @param anioPublicado año en que fue lanzado
     * @param creador desarrollador o creador principal
     * @param descripcion sinopsis del juego
     * @param tipoSuscripcion suscripción necesaria para acceder
     * @param requisitosMinimos requisitos minimos del sistema para que funcione
     * @param multiplayer indica si el juego permite modo multijugador
     */
    public Juego(String nombre, Genero genero, double precio, int anioPublicado, String creador, String descripcion,
                 Suscripcion tipoSuscripcion, String requisitosMinimos, boolean multiplayer) {
        super(nombre, genero, precio, anioPublicado, creador, descripcion, tipoSuscripcion);
        this.requisitosMinimos = requisitosMinimos;
        this.multiplayer = multiplayer;
    }

    // Getter y Setter
    public String getRequisitosMinimos() {
        return requisitosMinimos;
    }

    public void setRequisitosMinimos(String requisitosMinimos) {
        this.requisitosMinimos = requisitosMinimos;
    }

    public boolean isMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    // To String
    @Override
    public String toString() {
        return "Juego{" +
                "requisitosMinimos='" + requisitosMinimos + '\'' +
                ", multiplayer=" + multiplayer + super.toString() +
                '}';
    }

}
