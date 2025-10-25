public interface ABM<T> {

    boolean alta(T obj);
    T baja(int id);
    boolean modificar(T obj);
}
