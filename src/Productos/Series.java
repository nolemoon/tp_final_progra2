package Productos;

public final class Series {

    // Atributos
    private int temporadas;
    private int capitulos;

    // Constructores
    // TODO: añadir llamado al constructor super + sus atributos.
    public Series() {
    }

    public Series(int temporadas, int capitulos) {
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
    // TODO: Invocar al Super To String
    @Override
    public String toString() {
        return "Productos.Series{" +
                "temporadas=" + temporadas +
                ", capitulos=" + capitulos +
                '}';
    }

}
