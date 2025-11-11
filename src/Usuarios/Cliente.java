package Usuarios;

import Enum.Suscripcion;
import Exceptions.OpcionInvalidaException;
import Productos.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Cliente extends Usuario{


    private static int contadorId = 0;
    private final int idCliente;
    private Suscripcion tipoSuscripcion;

    //private static Biblioteca productosAdquiridos;

    /// METODOS

    @Override
    public boolean alta(Object o) {

        if (!(o instanceof Cliente cliente)) return false;
        return super.usuarioActivo = true;

    }

    @Override
    public boolean baja(Object o) {

if (!(o instanceof Cliente cliente)) return false;

return super.usuarioActivo=false;
    }

    @Override
    public Object modificar(int opcion, Object o) throws OpcionInvalidaException {


            return switch (opcion) {

                case 1 -> {
                    this.tipoSuscripcion = Suscripcion.BASICA;
                    yield true;
                }
                case 2 -> {
                    this.tipoSuscripcion = Suscripcion.PREMIUM;
                    yield true;
                }
                default -> throw new OpcionInvalidaException("Opcion invalida");

            };

        }

    @Override
    public Usuario consultar(String email) {
        for(int i=0; i<super.getListaUsuarios().size(); i++){

            if(super.getListaUsuarios().get(i).getEmail().equals(email)){
                return super.getListaUsuarios().get(i);
            }
        }
        return null;
    }

    @Override
    public void lista() {

        for(int i=0; i<super.getListaUsuarios().size(); i++){

            Cliente aux = (Cliente) super.getListaUsuarios().get(i);
            System.out.println("cliente numero "+ i +
                                aux.toString());
        }
    }

public boolean comprarProducto(String nombreProducto){

ArrayList<Producto> productos = new ArrayList<>();
HashMap<String,Producto> productosHashMap = new HashMap<>();

    for (Producto producto : productos) {

        if (producto.getNombre().equals(nombreProducto)) {
            productosHashMap.put(nombreProducto, producto);

            return true;
        }
    }

return false;
}

    @Override
    public String toString() {
        return "Usuarios.Cliente{" + "idCliente=" + idCliente + '\n' +
                ", tipoSuscripcion=" + tipoSuscripcion + '\n' +
                ", nombre='" + nombre + '\n' +
                ", email='" + email + '\n' +
                ", telefono='" + telefono + '\n' +
                ", usuarioActivo=" + usuarioActivo + '\n' +
                '}';
    }

    /// CONSTRUCTOR - INICIO
    public Cliente(String nombre, String email, String telefono) {
        super(nombre, email, telefono);
        this.idCliente = contadorId++;

    }

    public Cliente() {
        this.idCliente = contadorId++;
        }

   /// CONSTRUCTOR - FINAL

    /// GETTER AND SETTER - INICIO
    public int getIdCliente() {
        return idCliente;
    }

    public Suscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(Suscripcion tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cliente cliente)) return false;
        return idCliente == cliente.idCliente;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idCliente);
    }

/*
    public Biblioteca getProductosAdquiridos() {
        return productosAdquiridos;
    }
    public static void setProductosAdquiridos(int productosAdquiridos) {
        Usuarios.Cliente.productosAdquiridos = productosAdquiridos;
    }
    */
/// GETTER AND SETTER - FINAL
}
