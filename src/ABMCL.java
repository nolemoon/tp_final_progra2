public interface ABMCL<T> {

    abstract boolean alta();
    T baja();
    boolean modificar();
    T consultar(String nombre);
    String lista();

}
