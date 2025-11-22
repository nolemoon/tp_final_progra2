package Productos;

import Exceptions.ProductoNoEncontradoException;
import Interfaces.ABMCL;

import java.util.Map;
import java.util.Scanner;

public class GestorSerie implements ABMCL<Serie> {
    @Override
    public boolean alta(Serie s) {
        CatalogoProducto.agregarProducto(s);
        System.out.println("\nSerie agregada con exito!");
        return true;
    }

    @Override
    public boolean baja(int id) {
        try{
            Serie s = (Serie) CatalogoProducto.buscarPorId(id);
            s.setAltaProducto(false);
            return true;
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean modificar(Serie s) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("""
                    --- MODIFICAR SERIE ---
                    1. Número de temporadas
                    2. Cantidad de capítulos
                    3. Salir
                    """);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1 -> {
                    System.out.println("\nIngrese nuevo número de temporadas:");
                    s.setTemporadas(sc.nextInt());
                    sc.nextLine();
                }
                case 2 -> {
                    System.out.println("\nIngrese nueva cantidad de capítulos:");
                    s.setCapitulos(sc.nextInt());
                    sc.nextLine();
                }
            }
        }while(opcion != 3);

        return true;
    }

    @Override
    public Serie consultar(String nombre) {
        try{
            Serie s = (Serie) CatalogoProducto.buscarPorNombre(nombre);
            s.setAltaProducto(false);
            return s;
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void listar() {
        Map<Integer, Producto> series = CatalogoProducto.filtrarPorTipo(Serie.class);
        CatalogoProducto.mostrarCatalogo(series);

    }
}
