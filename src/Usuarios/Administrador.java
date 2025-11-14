package Usuarios;
import Exceptions.ProductoNoEncontradoException;
import Interfaces.ABMCL;
import Productos.CatalogoProducto;
import Productos.Producto;
import Enum.Suscripcion;
import Enum.Genero;
import java.util.Scanner;

/**
 * Clase que representa a un administrador, extiende de la clase abstracta {@code Usuario}.
 * Es un tipo de usuario con privilegios avanzados. Dentro de sus capacidades se encuentran:
 * dar de alta, baja, modificar, consultar y listar productos del catálogo.
 *
 * Implementa la interfaz {@link ABMCL}, aplicando sus operaciones sobre objetos de
 * tipo {@code Producto}.
 * @author Franco
 */
public class Administrador extends Usuario implements ABMCL<Producto> {

    /**
     * Constructor con todos los atributos.
     *
     * @param nombre nombre del administrador
     * @param email correo electrónico
     * @param telefono teléfono de contacto
     * @param contrasenia contraseña de acceso
     */
    public Administrador(String nombre, String email, String telefono, String contrasenia) {
        super(nombre, email, telefono, contrasenia);
    }

    /**
     * Constructor vacío. Crea un administrador sin inicializar sus atributos.
     */
    public Administrador() {
    }


    /// Metodos
    /**
     * Da de alta un producto en el catálogo.
     * @param p producto a dar de alta
     * @return {@code true} si la operación fue exitosa
     */
    @Override
    public boolean alta(Producto p) {
        CatalogoProducto catalogo = new CatalogoProducto();
        catalogo.agregarProducto(p);

        return true;
    }

    /**
     * Da de baja lógica un producto, cambiando su atributo {@code altaProducto} a {@code false}
     * @param id identificador del objeto a dar de baja
     * @return {@code true} si la operación fue exitosa
     * @throws ProductoNoEncontradoException si el producto no existe en el catálogo
     */
    @Override
    public boolean baja(int id) throws ProductoNoEncontradoException {
        CatalogoProducto catalogo = new CatalogoProducto();
        Producto p = catalogo.buscarPorId(id);
        p.setAltaProducto(false);

        return true;
    }


    /**
     * Modifica los atributos de un producto según la opción elegida por consola
     * @param producto producto a modificar
     * @return {@code true} si la operación fue exitosa
     */
    @Override
    public boolean modificar(Producto producto) {
        Scanner sc=new Scanner(System.in);

        System.out.println("""
                Ingrese el numero de la opcion que desea modificar\\
                               \s
                                1. Nombre\\
                               \s
                                2. genero\\
                               \s
                                3. precio\\
                               \s
                                4. tipoSuscripcion\\
                               \s
                                5. salir""\");""");
       int opcion= sc.nextInt();
        sc.nextLine();
        String aux;

switch (opcion){

            case 1:
                producto.setNombre(sc.nextLine());

            case 2: aux=sc.nextLine();
                aux=aux.toUpperCase();

                switch (aux) {
                    case "ACCION" -> producto.setGenero(Genero.ACCION);
                    case "AVENTURA" -> producto.setGenero(Genero.AVENTURA);
                    case "COMEDIA" -> producto.setGenero(Genero.COMEDIA);
                    case "DRAMA" -> producto.setGenero(Genero.DRAMA);
                    case "FANTASIA" -> producto.setGenero(Genero.FANTASIA) ;
                    case "TERROR" -> producto.setGenero(Genero.TERROR);
                    case "ROMANCE" -> producto.setGenero(Genero.ROMANCE) ;
                    case "CIENCIA_FICCION" -> producto.setGenero(Genero.CIENCIA_FICCION);
                } default:


            case 3: producto.setPrecio(sc.nextDouble());

            case 4: aux=sc.nextLine();
            aux=aux.toUpperCase();

            if (aux.equals("PREMIUM")){producto.setTipoSuscripcion(Suscripcion.PREMIUM);}
            else if(aux.equals("BASICA")|| aux.equals("BASICO")){producto.setTipoSuscripcion(Suscripcion.BASICA);}

            return true;
        }
    }

    /**
     * Consulta un producto por su nombre dentro del catálogo.
     * @param nombreProducto nombre del objeto a buscar
     * @return producto encontrado
     * @throws ProductoNoEncontradoException si no existe un producto con ese nombre
     */
    @Override
    public Producto consultar(String nombreProducto) throws ProductoNoEncontradoException {
        CatalogoProducto catalogo = new CatalogoProducto();
        return catalogo.buscarPorNombre(nombreProducto);
    }

    /**
     * Lista todos los productos del catálogo.
     */
    @Override
    public void listar() {
        CatalogoProducto catalogo = new CatalogoProducto();
        catalogo.mostrarCatalogo();

    }


    @Override
    public String toString() {
        return super.toString();
    }
}

