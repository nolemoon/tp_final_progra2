package Usuarios;



import Exceptions.ProductoNoEncontradoException;
import Interfaces.ABMCL;
import Productos.CatalogoProducto;
import Productos.Producto;
import Enum.Suscripcion;
import Enum.Genero;


import java.util.Scanner;

public class Administrador extends Usuario implements ABMCL {

    public Administrador(String nombre, String email, String telefono, String password) {

        super(nombre, email, telefono,password);
    }

    public Administrador() {
    }


    /// Metodos

    @Override
    public boolean alta(Object o) {
// TODO: crear atributo altaProducto en Producto
CatalogoProducto catalogo=new CatalogoProducto();


        Producto producto = (Producto) o;

        catalogo.agregarProducto(producto);

        return true;
    }


    @Override
    public boolean baja(int id) throws ProductoNoEncontradoException {
// TODO: crear atributo altaProducto en Producto
CatalogoProducto catalogo=new CatalogoProducto();

Producto p=catalogo.buscarPorId(id);

       p.setAltaProducto(false);


        return false;
    }



    @Override
    public boolean modificar(Object o) {
        Scanner sc=new Scanner(System.in);


if (!(o instanceof Producto producto)) return false;



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

    @Override
    public Object consultar(String nombreProducto) throws ProductoNoEncontradoException {
        CatalogoProducto catalogo=new CatalogoProducto();


        return catalogo.buscarPorNombre(nombreProducto);
    }

    @Override
    public void lista() {

CatalogoProducto catalogo=new CatalogoProducto();

catalogo.mostrarCatalogo();

    }


    @Override
    public String toString() {
        return super.toString();
    }
}

