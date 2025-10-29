
import Enum.Suscripcion;

public class Clientes extends Usuario{


    private static int contadorId = 0;
    private final int idCliente;
    private Suscripcion tipoSuscripcion;

    //private static Biblioteca productosAdquiridos;

    /// METODOS



    /// CONSTRUCTOR - INICIO
    public Clientes(String nombre, String email, String telefono, int idCliente) {
        super(nombre, email, telefono);
        this.idCliente = idCliente;
    }


    public Clientes() {
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

    /*
    public Biblioteca getProductosAdquiridos() {
        return productosAdquiridos;
    }
    public static void setProductosAdquiridos(int productosAdquiridos) {
        Clientes.productosAdquiridos = productosAdquiridos;
    }
    */
/// GETTER AND SETTER - FINAL
}
