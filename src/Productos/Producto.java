package Productos;
import Enum.Genero;
import Enum.Suscripcion;

public abstract class Producto {

    private int id_Producto ;
    private String nombre;
    private Genero genero;
    private double precio;
    private int anioPublicado ;
    //private Creador creador ??
    private String descripcion;
    private Suscripcion tipoSuscripcion ;
    //calificacion DOUBLE ???


    public Producto() {
    }


}

