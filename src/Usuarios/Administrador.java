package Usuarios;

import Exceptions.OpcionInvalidaException;
import Productos.Producto;
import Enum.Suscripcion;
import Enum.Genero;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Administrador extends Usuario{
    private final int idAdministrador=contadorId;
    private static final int contadorId=0;


    public Administrador(String nombre, String email, String telefono) {
        super(nombre, email, telefono);
    }

    public Administrador() {
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Administrador that)) return false;
        return idAdministrador == that.idAdministrador;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idAdministrador);
    }


    /// Metodos

    @Override
    public boolean alta(Object o) {
// TODO: crear atributo altaProducto en Producto

        if (o instanceof Producto producto) {

            //o.altaProducto=true;
           return true;
        }


        return true;
    }


    @Override
    public boolean baja(Object o) {
// TODO: crear atributo altaProducto en Producto

        if (o instanceof Producto producto) {
           // o.altaProducto=false;
            return true;

        }
        return false;
    }

    @Override
    public Object modificar(int opcion,Object o) throws OpcionInvalidaException {
Scanner sc=new Scanner(System.in);
        String aux=null;
switch (opcion){

            case 1:
                o.nombre=sc.nextLine();

            case 2: aux=sc.nextLine();
            aux=aux.toUpperCase();

                switch (aux) {
                    case "ACCION" -> o.Genero = Genero.ACCION;
                    case "AVENTURA" -> o.Genero = Genero.AVENTURA;
                    case "COMEDIA" -> o.Genero = Genero.COMEDIA;
                    case "DRAMA" -> o.Genero = Genero.DRAMA;
                    case "FANTASIA" -> o.Genero = Genero.FANTASIA;
                    case "TERROR" -> o.Genero = Genero.TERROR;
                    case "ROMANCE" -> o.Genero = Genero.ROMANCE;
                    case "CIENCIA_FICCION" -> o.Genero = Genero.CIENCIA_FICCION;
                } default: throw new OpcionInvalidaException("Opcion invalida");


            case 3: o.precio=sc.nextDouble();

            case 4: aux=sc.nextLine();
            aux=aux.toUpperCase();

            if (aux.equals("PREMIUM")){o.Suscripcion=Suscripcion.PREMIUM;}
            else if(aux.equals("BASICA")|| aux.equals("BASICO")){o.Suscripcion=Suscripcion.BASICA;}

            return o;
        }


        return false;
    }

    @Override
    public Object consultar(String nombreProducto) {

        ArrayList<Producto> catalogo=new ArrayList<>();
        // TODO hacer clase catalogo.

        for (Producto producto : catalogo) {
            if (producto.getNombre().equals(nombreProducto)) {
                return producto;
            }

        }

        return null;
    }

    @Override
    public void lista() {
        //TODO: hacer clase catalogo.

       // Catalogo.showAll();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Administrador{").append('\'');
        sb.append("idAdministrador=").append(idAdministrador).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", usuarioActivo=").append(usuarioActivo);
        sb.append('}');
        return sb.toString();
    }
}

