package Usuarios;

import Exceptions.OpcionInvalidaException;
import Productos.Producto;

import java.util.ArrayList;
import java.util.Objects;

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

