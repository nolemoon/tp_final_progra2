package Exceptions;

/**
 * Excepción personalizada que indica que un producto no fue encontrado.
 * Se lanza cuando se quiere consultar, modificar o dar de baja
 * un producto a través de un id o nombre que no existe.
 * @author Renata
 */
public class ProductoNoEncontradoException extends Exception {
    public ProductoNoEncontradoException(String message) {
        super(message);
    }
}
