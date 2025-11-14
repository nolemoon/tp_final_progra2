package Exceptions;

/**
 * Excepción personalizada que se lanza cuando se intenta consultar, modificar
 * o eliminar un usuario que no está registrado en el sistema.
 * @author Franco
 */
public class UsuarioNoEncontradoException extends Exception {
    public UsuarioNoEncontradoException(String mensaje){
        super(mensaje);

    }
}
