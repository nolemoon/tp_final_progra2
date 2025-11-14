package Productos;


import Enum.Genero;
import Enum.Suscripcion;
/**
 * Clase final que representa un eBook, extiende de la clase abstracta
 * {@code Producto}. Agrega como atributos específicos número de páginas, formato e idioma.
 * Es decir, contiene toda la info. general heredada de Producto, sumando datos propios.
 * @author Agustino
 */
public final class Ebook extends Producto {

    // Atributos
    private int numPaginas;
    private String formato;
    private String idioma;

    /**
     * Constructor que llama al super() vacío.
     */
    public Ebook() {
        super();
    }

    /**
     * Constructor que inicializa un eBook con todos sus atributos.
     *
     * @param nombre nombre del libro digital
     * @param genero género al que pertenece
     * @param precio precio del eBook
     * @param anioPublicado año en el que se publicó
     * @param creador autor del libro
     * @param descripcion sinopsis del libro
     * @param tipoSuscripcion suscripción necesaria para acceder
     * @param numPaginas cantidad total de páginas
     * @param formato formato digital del archivo
     * @param idioma idioma en el que está escrito
     */
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
