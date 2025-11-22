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
    public boolean baja(int id) {
        try{
            Juego j = (Juego) CatalogoProducto.buscarPorId(id);
            j.setAltaProducto(false);
            return true;
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
            return false;
        }
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
    public Juego consultar(String nombre){
        try{
            Juego j = (Juego) CatalogoProducto.buscarPorNombre(nombre);
            j.setAltaProducto(false);
            return j;
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void listar() {
        Map<Integer, Producto> juegos = CatalogoProducto.filtrarPorTipo(Juego.class);
        CatalogoProducto.mostrarCatalogo(juegos);

    }
}
