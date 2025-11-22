package Productos;

import Exceptions.ProductoNoEncontradoException;
import Interfaces.ABMCL;

import java.util.Map;
import java.util.Scanner;

public class GestorEbook implements ABMCL<Ebook> {
    @Override
    public boolean alta(Ebook e) {
        CatalogoProducto.agregarProducto(e);
        System.out.println("\nEbook agregado con exito!");
        return true;
    }

    @Override
    public boolean baja(int id) {
        try{
            Ebook e = (Ebook) CatalogoProducto.buscarPorId(id);
            e.setAltaProducto(false);
            return true;
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean modificar(Ebook p) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("""
                    --- MODIFICAR EBOOK ---
                    1. Cantidad de páginas
                    2. Formato
                    3. Idioma
                    4. Salir
                    """);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1 -> {
                    System.out.println("\nIngrese nueva cantidad de paginas:");
                    p.setNumPaginas(sc.nextInt());
                    sc.nextLine();
                }
                case 2 -> {
                    System.out.println("\nIngrese nuevo formato");
                    p.setFormato(sc.nextLine());
                }
                case 3 -> {
                    System.out.println("\nIngrese nuevo idioma");
                    p.setIdioma(sc.nextLine());
                }
            }
        }while(opcion != 4);

        return true;
    }

    @Override
    public Ebook consultar(String nombre) {
        try{
            Ebook e = (Ebook) CatalogoProducto.buscarPorNombre(nombre);
            e.setAltaProducto(false);
            return e;
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void listar() {
        Map<Integer, Producto> ebooks = CatalogoProducto.filtrarPorTipo(Ebook.class);
        CatalogoProducto.mostrarCatalogo(ebooks);

    }
}
