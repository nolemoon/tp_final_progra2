package Productos;

import Exceptions.ProductoNoEncontradoException;
import Interfaces.ABMCL;

import java.util.Map;
import java.util.Scanner;

public class GestorJuego implements ABMCL<Juego> {
    @Override
    public boolean alta(Juego j) {
        CatalogoProducto.agregarProducto(j);
        System.out.println("\nJuego agregado con exito!");
        return true;
    }

    @Override
    public boolean baja(int id) throws ProductoNoEncontradoException {
        Juego j = (Juego) CatalogoProducto.buscarPorId(id);
        if(j == null)
            throw new ProductoNoEncontradoException("\nNo se ha encontrado un juego con ese ID.");

        j.setAltaProducto(false);
        return true;
    }

    @Override
    public boolean modificar(Juego j) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("""
                    --- MODIFICAR JUEGO ---
                    1. Requisitos minimos
                    2. Multiplayer
                    3. Salir
                    """);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1 -> {
                    System.out.println("\nIngrese nuevos requisitos minimos:");
                    j.setRequisitosMinimos(sc.nextLine());
                }
                case 2 -> {
                    System.out.println("\nIngrese si es multiplayer (true/false):");
                    j.setMultiplayer(sc.nextBoolean());
                }
            }
        }while(opcion != 3);

        return true;
    }

    @Override
    public Juego consultar(String nombre) throws ProductoNoEncontradoException {
        Juego j = (Juego) CatalogoProducto.buscarPorNombre(nombre);
        if(j == null)
            throw new ProductoNoEncontradoException("\nNo se ha encontrado un juego con ese nombre.");

        j.setAltaProducto(false);
        return j;
    }

    @Override
    public void listar() {
        Map<Integer, Producto> juegos = CatalogoProducto.filtrarPorTipo(Juego.class);
        CatalogoProducto.mostrarCatalogo(juegos);

    }
}
