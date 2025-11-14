import Productos.Producto;
import Enum.Genero;
import Enum.Suscripcion;

public final class Ebook extends Producto {

    // Atributos
    private int numPaginas;
    private String formato;
    private String idioma;

    // Constructores
    public Ebook() {
        super();
    }

    public Ebook(String nombre, Genero genero, double precio, int anioPublicado, String creador, String descripcion,
                 Suscripcion tipoSuscripcion, int numPaginas, String formato, String idioma) {
        super(nombre, genero, precio, anioPublicado, creador, descripcion, tipoSuscripcion);
        this.numPaginas = numPaginas;
        this.formato = formato;
        this.idioma = idioma;
    }

    // Getter y Setter
    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    // To String
    @Override
    public String toString() {
        return "Ebook{" +
                "numPaginas=" + numPaginas +
                ", formato='" + formato + '\'' +
                ", idioma='" + idioma + '\'' +
                super.toString() +
                '}';
    }

}
