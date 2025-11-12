package Productos;

public final class Pelicula {

    // Atributos
    private double duracion;
    private String clasificacion;

    // Constructores
    // TODO: añadir llamado al constructor super + sus atributos.
    public Pelicula() {
    }

    public Pelicula(double duracion, String clasificacion) {
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
    // TODO: Invocar al Super To String
    @Override
    public String toString() {
        return "Productos.Pelicula{" +
                "duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' +
                '}';
    }
}
