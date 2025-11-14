import Productos.Producto;
import Enum.Suscripcion;
import Enum.Genero;

public final class Juego extends Producto {

    // Atributos
    private String requisitosMinimos;
    private boolean multiplayer;

    // Constructor
    public Juego() {
        super();
    }

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
