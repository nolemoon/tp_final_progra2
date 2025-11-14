package Productos;

import Enum.Genero;
import Enum.Suscripcion;

import java.util.Objects;

/**
 * La clase abstracta PRODUCTO posee como campos nombre, género, precio, año de publicación,
 * creador, descripcion, tipo de suscripción con la que se puede acceder al producto.
 * Funciona como base para productos específicos (Pelicula, Serie, Ebook, Juego) que la extienden.
 * Métodos: setters y getters de cada atributo, toString para devolver sus datos, equals y hashcode.
 * @author Noel
 */
public abstract class Producto {

    private final int id_Producto ;
    private static int contador =0;
    private String nombre;
    private Genero genero;
    private double precio;
    private int anioPublicado ;
    private String creador;
    private String descripcion;
    private Suscripcion tipoSuscripcion ;
    private boolean altaProducto;


    /**
     * Constructor vacío que asigna automáticamente un ID único.
     */
    public Producto() {
         this.id_Producto = contador++;
         this.altaProducto = true;

    }

    /**
     * Constructor con todos los atributos
     * @param nombre nombre del producto
     * @param genero genero al que pertenece
     * @param precio precio del producto
     * @param anioPublicado año en el que se publicó
     * @param creador autor o desarrollador
     * @param descripcion breve descripción del producto
     * @param tipoSuscripcion suscripción requerida para acceder al producto
     */
    public Producto(String nombre, Genero genero, double precio, int anioPublicado, String creador, String descripcion,  Suscripcion tipoSuscripcion) {
        this.id_Producto = contador ++;
        this.nombre = nombre;
        this.genero = genero;
        this.precio = precio;
        this.anioPublicado = anioPublicado;
        this.creador = creador;
        this.descripcion = descripcion;
        this.tipoSuscripcion = tipoSuscripcion;
        this.altaProducto = true;
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
    public boolean isAltaProducto() {return altaProducto;}

    public void setAltaProducto(boolean altaProducto) {this.altaProducto = altaProducto;}

    @Override
    public String toString() {
        return "Productos.Producto{" +
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto producto)) return false;
        return id_Producto == producto.id_Producto;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_Producto);
    }
}

