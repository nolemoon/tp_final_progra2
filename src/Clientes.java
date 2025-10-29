
import Enum.Suscripcion;

public class Clientes extends Usuario{


    private static int contadorId = 0;
    private final int idCliente;
    private Suscripcion tipoSuscripcion;

    //private static Biblioteca productosAdquiridos;

    /// METODOS

    @Override
    public boolean alta() {
        return super.usuarioActivo = true;
    }

    @Override
    public boolean baja() {
        return super.usuarioActivo=false;
    }

    @Override
    public boolean modificar(int opcion) {

        return switch (opcion) {
            case 1 -> {
                super.usuarioActivo = true;
                yield true;
            }
            case 2 -> {
                super.usuarioActivo = false;
                yield true;
            }
            case 3 -> {
                this.tipoSuscripcion = Suscripcion.BASICA;
                yield true;
            }
            case 4 -> {
                this.tipoSuscripcion = Suscripcion.PREMIUM;
                yield true;
            }
            default -> false;
        };
    }

    @Override
    public String toString() {
        return super.toString()+
                "idCliente=" + idCliente
                + ", tipoSuscripcion=" + tipoSuscripcion;
    }

    @Override
    public boolean consultar(String email) {
        // TODO: crear lista usuarios.

        return false;
    }



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
