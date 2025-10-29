package Productos;
import Enum.Genero;
import Enum.Suscripcion;

public abstract class Producto {

    private int id_Producto ;
    private static int contador =0;
    private String nombre;
    private Genero genero;
    private double precio;
    private int anioPublicado ;
    private String creador;
    private String descripcion;
    private Suscripcion tipoSuscripcion ;
    //calificacion DOUBLE;


    public Producto() {
    this.id_Producto = contador++;

    }

    public Producto(String nombre, Genero genero, double precio, int anioPublicado, String creador, String descripcion,  Suscripcion tipoSuscripcion) {
        this.id_Producto = contador ++;
        this.nombre = nombre;
        this.genero = genero;
        this.precio = precio;
        this.anioPublicado = anioPublicado;
        this.creador = creador;
        this.descripcion = descripcion;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public int getId_Producto() {
        return id_Producto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero( Genero genero) {
        this.genero = genero;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getAnioPublicado() {
        return anioPublicado;
    }
    public void setAnioPublicado(int anioPublicado) {
        this.anioPublicado = anioPublicado;
    }
    public String getCreador() {
        return creador;
    }
    public void setCreador(String creador) {
        this.creador = creador;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Suscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }
    public void setTipoSuscripcion(Suscripcion tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_Producto=" + id_Producto +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", precio=" + precio +
                ", anioPublicado=" + anioPublicado +
                ", creador='" + creador + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipoSuscripcion=" + tipoSuscripcion +
                '}';
    }
}

