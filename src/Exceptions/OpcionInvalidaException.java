package Exceptions;

/**
 * Excepción personalizada que se lanza cuando se ingresa una opción no válida
 * en un menú o selección.
 * @author Franco
 */
public class OpcionInvalidaException extends Exception{
    public OpcionInvalidaException(String mensaje){
    super(mensaje);
}

}
