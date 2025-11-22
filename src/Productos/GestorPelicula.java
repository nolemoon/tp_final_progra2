package Productos;

import Exceptions.ProductoNoEncontradoException;
import Interfaces.ABMCL;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GestorPelicula implements ABMCL<Pelicula> {
    @Override
    public boolean alta(Pelicula p) {
        CatalogoProducto.agregarProducto(p);
        System.out.println("\nPelicula agregada con exito!");
        return true;
    }

    @Override
    public boolean baja(int id) throws ProductoNoEncontradoException {
        Pelicula p = (Pelicula) CatalogoProducto.buscarPorId(id);
        if(p == null)
            throw new ProductoNoEncontradoException("\nNo se ha encontrado una pelicula con ese ID.");

        p.setAltaProducto(false);
        return true;
    }

    @Override
    public boolean modificar(Pelicula p) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("""
                    --- MODIFICAR PELICULA ---
                    1. Duracion
                    2. Clasificacion
                    3. Salir
                    """);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1 -> {
                    System.out.println("\nIngrese nueva duracion:");
                    p.setDuracion(sc.nextDouble());
                    sc.nextLine();
                }
                case 2 -> {
                    System.out.println("\nIngrese nueva clasifacion");
                    p.setClasificacion(sc.nextLine());
                }
            }
        }while(opcion != 3);

        return true;
    }

    @Override
    public Pelicula consultar(String nombre) throws ProductoNoEncontradoException {
        Pelicula p = (Pelicula) CatalogoProducto.buscarPorNombre(nombre);
        if(p == null)
            throw new ProductoNoEncontradoException("\nNo se ha encontrado una pelicula con ese nombre.");

        p.setAltaProducto(false);
        return p;
    }

    @Override
    public void listar() {
        Map<Integer, Producto> peliculas = CatalogoProducto.filtrarPorTipo(Pelicula.class);
        CatalogoProducto.mostrarCatalogo(peliculas);

    }
}
