package Interfaces;


import Exceptions.ProductoNoEncontradoException;

/**
 * Interfaz genérica que define las operaciones básicas alta, baja, modificación, consulta y listado (Interfaces. ABMCL)
 * para ser implementadas en las clases {@code Usuario} y {@code Producto} y sus respectivas hijas.
 * @param <T> tipo genérico
 * @author Renata, Franco
 */
public interface ABMCL<T> {

    /**
     * Da de alta un nuevo objeto en el sistema
     * @param obj objeto a registrar
     * @return {@code true} si el alta fue exitoso, {@code false} en caso contrario
     */
     boolean alta(T obj);

    /**
     * Da de baja un objeto en el sistema por su id
     * @param id identificador del objeto a dar de baja
     * @return {@code true} si la baja fue exitosa, {@code false} en caso contrario
     */
    boolean baja(int id) throws ProductoNoEncontradoException;

    /**
     * Modifica un objeto existente en el sistema
     * @param obj objeto con datos actualizados
     * @return {@code true} si la modificación fue exitosa, {@code false} en caso contrario
     */
    boolean modificar(T obj);

    /**
     * Consulta un objeto del sistema a partir de su nombre
     * @param nombre nombre del objeto a buscar
     * @return objeto encontrado
     */
    T consultar(String nombre) throws ProductoNoEncontradoException;

    /**
     * Devuelve listado con los objetos registrados
     */
    void listar();
}

