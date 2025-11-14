package Exceptions;

/**
 * Excepción personalizada que se lanza cuando se intenta añadir un usuario
 * que ya está registrado en el sistema.
 * @author Noel
 */
public class UsuarioExistenteException extends Exception{
    public UsuarioExistenteException(String mensaje){
        super(mensaje);

    }
}
