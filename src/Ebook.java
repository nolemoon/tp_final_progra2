public final class Ebook extends AbstractProducto{

    // Atributos
    private int numPaginas;
    private String formato;
    private String idioma;

    // Constructores
    // TODO: añadir llamado al constructor super + sus atributos.
    public Ebook() {
    }

    public Ebook(int numPaginas, String formato, String idioma) {
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
    // TODO: Invocar al Super To String
    @Override
    public String toString() {
        return "Ebook{" +
                "numPaginas=" + numPaginas +
                ", formato='" + formato + '\'' +
                ", idioma='" + idioma + '\'' +
                '}';
    }

}
