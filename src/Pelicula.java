public final class Pelicula extends Producto{

    // Atributos
    private double duracion;
    private String clasificacion;

    // Constructores
    public Pelicula() {
        super();
    }

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
