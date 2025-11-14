import Productos.Producto;
import Enum.Genero;
import Enum.Suscripcion;

public final class Series extends Producto{

    // Atributos
    private int temporadas;
    private int capitulos;

    // Constructores
    public Series() {
        super();
    }

    public Series(String nombre, Genero genero, double precio, int anioPublicado, String creador, String descripcion,
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
