package Usuarios;



import Exceptions.ProductoNoEncontradoException;
import Interfaces.ABMCL;
import Productos.*;
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
                                5. salir""\");\\
                                \s
                                Juegos\\
                                \s
                                11. requisitosMinimos\\
                                12. multiplayer\\
                                \s
                                E-books\\
                                \s
                                21. formato\\
                                22. idioma\\
                                23. numPaginas\\
                                \s
                                Peliculas\\
                                \s
                                31. clasificacion\\
                                32. duracion\\
                                \s
                                Series\\
                                \s
                                41. temporadas\\
                                42. capitulos\\""");
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

            case 11: if(o instanceof Juego) {
            ((Juego) o).setRequisitosMinimos(sc.nextLine());
            }
            case 12: if(o instanceof Juego) {
                ((Juego) o).setMultiplayer(sc.nextBoolean());
            }
            case 21: if(o instanceof Ebook) {
                ((Ebook) o).setFormato(sc.nextLine());

            }
            case 22: if(o instanceof Ebook) {
                ((Ebook) o).setIdioma(sc.nextLine());
            }
            case 23: if(o instanceof Ebook) {
                ((Ebook) o).setNumPaginas(sc.nextInt());
            }
            case 31: if(o instanceof Pelicula){
                ((Pelicula) o).setClasificacion(sc.nextLine());

            }
            case 32: if(o instanceof Pelicula){
                ((Pelicula) o).setDuracion(sc.nextInt());
            }
    case 41: if(o instanceof Serie){
        ((Serie) o).setTemporadas(sc.nextInt());
    }
    case 42: if (o instanceof Serie){
        ((Serie) o).setCapitulos(sc.nextInt());
    }


            }
            return true;
        }


    @Override
    public Object consultar(String nombreProducto) throws ProductoNoEncontradoException {
        CatalogoProducto catalogo=new CatalogoProducto();


        return catalogo.buscarPorNombre(nombreProducto);
    }

    @Override
    public void listar() {

CatalogoProducto catalogo=new CatalogoProducto();

catalogo.mostrarCatalogo();

    }


    @Override
    public String toString() {
        return super.toString();
    }
}

