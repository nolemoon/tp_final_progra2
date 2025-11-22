package Usuarios;



import Exceptions.ProductoNoEncontradoException;
import Interfaces.ABMCL;
import Productos.*;
import Enum.Suscripcion;
import Enum.Genero;


import java.util.Scanner;

public class Administrador extends Usuario implements ABMCL<Producto> {
    private GestorPelicula gestorPeliculas = new GestorPelicula();
    private GestorSerie gestorSeries = new GestorSerie();
    private GestorEbook gestorEbooks = new GestorEbook();
    private GestorJuego gestorJuegos = new GestorJuego();

    public Administrador(String nombre, String email, String telefono, String password) {

        super(nombre, email, telefono,password);
    }

    public Administrador() {
    }


    /// Metodos

    @Override
    public boolean alta(Producto p) {
        if(p instanceof Pelicula pelicula)
            return gestorPeliculas.alta(pelicula);

        if(p instanceof Serie serie)
            return gestorSeries.alta(serie);

        if(p instanceof Ebook ebook)
            return gestorEbooks.alta(ebook);

        if(p instanceof Juego juego)
            return gestorJuegos.alta(juego);

        return false;
    }


    @Override
    public boolean baja(int id) throws ProductoNoEncontradoException {
        Producto p = CatalogoProducto.buscarPorId(id);

        if(p instanceof Pelicula)
            return gestorPeliculas.baja(id);

        if(p instanceof Serie)
            return gestorSeries.baja(id);

        if(p instanceof Ebook)
            return gestorEbooks.baja(id);

        if(p instanceof Juego)
            return gestorJuegos.baja(id);


        throw new ProductoNoEncontradoException("\nNo se ha encontrado el producto.");
    }



    @Override
    public boolean modificar(Producto p) {
        Scanner sc=new Scanner(System.in);

        System.out.println("""
                --- MODIFICAR PRODUCTO ---
                Ingrese el numero de la opcion que desea modificar:\\
                \s
                1. Nombre
                2. Genero
                3. Precio
                4. Tipo de suscripcion
                5. Atributos especificos
                6. Salir
                """);

        int opcion= sc.nextInt();
        sc.nextLine();

        switch (opcion){
            case 1 -> {
                System.out.println("\nIngrese nuevo nombre: ");
                p.setNombre(sc.nextLine());
                return true;
            }
            case 2 -> {
                System.out.println("""
                        ACCION, AVENTURA, COMEDIA, DRAMA,
                        FANTASIA, TERROR, ROMANCE, CIENCIA_FICCION
                        \nIngrese nuevo genero:
                        """);
                String g = sc.nextLine().toUpperCase();
                p.setGenero(Genero.valueOf(g));
                return true;
            }
            case 3 -> {
                System.out.println("\nIngrese nuevo precio: ");
                p.setPrecio(sc.nextDouble());
                sc.nextLine();
                return true;
            }
            case 4 -> {
                System.out.println("""
                        BASICA, PREMIUM
                        \nIngrese nuevo tipo de suscripcion:
                        """);
                String s = sc.nextLine().toUpperCase();
                p.setTipoSuscripcion(Suscripcion.valueOf(s));
                return true;
            }
            case 5 -> {
                if(p instanceof Pelicula pelicula){
                    return gestorPeliculas.modificar(pelicula);
                }
                if(p instanceof Serie serie){
                    return gestorSeries.modificar(serie);
                }
                if(p instanceof Ebook ebook){
                    return gestorEbooks.modificar(ebook);
                }
                if(p instanceof Juego juego){
                    return gestorJuegos.modificar(juego);
                }

                return true;
            }
            default -> {return false;}
        }

    }


    @Override
    public Producto consultar(String nombreProducto) throws ProductoNoEncontradoException {
        Producto p = CatalogoProducto.buscarPorNombre(nombreProducto);

        if(p instanceof Pelicula)
            return gestorPeliculas.consultar(nombreProducto);

        if(p instanceof Serie)
            return gestorSeries.consultar(nombreProducto);

        if(p instanceof Ebook)
            return gestorEbooks.consultar(nombreProducto);

        if(p instanceof Juego)
            return gestorJuegos.consultar(nombreProducto);


        throw new ProductoNoEncontradoException("\nNo se ha encontrado el producto.");
    }

    @Override
    public void listar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Ingrese el tipo de producto que desea ver:\\
                \s
                1. Peliculas
                2. Series
                3. Ebooks
                4. Juegos
                5. Salir
                """);

        int opcion= sc.nextInt();
        sc.nextLine();

        switch (opcion){
            case 1 -> {
                gestorPeliculas.listar();
            }
            case 2 -> {
                gestorSeries.listar();
            }
            case 3 -> {
                gestorEbooks.listar();
            }
            case 4 -> {
                gestorJuegos.listar();
            }
            default -> {
                System.out.println("\nOpcion inválida.");
            }
        }

    }


    @Override
    public String toString() {
        return super.toString();
    }
}

