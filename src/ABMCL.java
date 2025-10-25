public interface ABMCL<T> {

    boolean alta(T obj);
    T baja(int id);
    boolean modificar(T obj);
    T consultar(String nombre);
    String lista();

}
