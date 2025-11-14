import Productos.Producto;
import java.util.*;

/**
 * La clase CatalogoProductos representa un catálogo de productos disponible en {@code Tienda}.
 * Los productos se almacenan en un {@code LinkedHashMap} para mantener el orden de inserción
 * y realizar búsquedas rápidas.
 * Métodos: filtrarPorTipo, filtrarPorGenero, mostrarCatalogo, agregarProducto, buscarPorNombre y buscarPorId.
 * @author Renata
 */
public class CatalogoProducto {
    private Map<Integer, Producto> productos;

    /**
     * Constructor vacío que inicializa el mapa de productos.
     */
    public CatalogoProducto() {
        this.productos = new LinkedHashMap<>();  //se cargan los datos al deserializar desde json
    }

    /**
     * Devuelve el mapa completo de productos.
     * @return mapa con todos los productos
     */
    public Map<Integer, Producto> getProductos() {
        return productos;
    }

    /**
     * Filtra los productos del catálogo por su clase.
     * @param tipoProducto clase del tipo de producto a filtrar
     * @return {@code Map} con productos del tipo indicado
     */
    public Map<Integer, Producto> filtrarPorTipo(Class<? extends Producto> tipoProducto){
        Map<Integer, Producto> filtrados = new LinkedHashMap<>();
        for(Map.Entry<Integer, Producto> entry : productos.entrySet()){
            if(tipoProducto.isInstance(entry.getValue())){
                filtrados.put(entry.getKey(), entry.getValue());
            }
        }
        return filtrados;
    }

    /**
     * Filtra por su género una lista anteriormente filtrada por su tipo de producto.
     * @param listaFiltrada mapa de productos a filtrar
     * @param generoIndicado género por el que se va a filtrar
     * @return {@code Map} con productos del tipo y género indicado
     */
    public Map<Integer, Producto> filtrarPorGenero(Map<Integer, Producto> listaFiltrada, String generoIndicado){
        Map<Integer, Producto> filtrados = new LinkedHashMap<>();
        for(Map.Entry<Integer, Producto> entry : listaFiltrada.entrySet()){
            Producto p = entry.getValue();
            if(p.getGenero().name().equalsIgnoreCase(generoIndicado)){
                filtrados.put(entry.getKey(), p);
            }
        }
        return filtrados;
    }

    /**
     * Muestra productos de un catálogo filtrado.
     * @param catalogoFiltrado mapa de productos a mostrar
     */
    public void mostrarCatalogo(Map<Integer, Producto> catalogoFiltrado){
        for(Map.Entry<Integer, Producto> entry : catalogoFiltrado.entrySet()){
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

    /**
     * Muestra el catálogo completo sin filtrar por ningún tipo.
     */
    public void mostrarCatalogo(){
        mostrarCatalogo(this.productos);  //muestra el catalogo completo, SIN filtrar.
    }

    /**
     * Busca y devuelve un producto a partir de su ID.
     * @param id identificador del producto a buscar
     * @return {@code Producto} correspondiente al ID indicado
     * @throws ProductoNoEncontradoException si no se encuentra ningún producto con el ID indicado.
     */
    public Producto buscarPorId(int id) throws ProductoNoEncontradoException{
        Producto p = productos.get(id);
        if(p == null){
            throw new ProductoNoEncontradoException("\nNo se ha encontrado un producto con el ID indicado.");
        }
        return p;
    }

    /**
     * Busca y devuelve un producto a partir de su nombre.
     * @param nombre nombre del producto a buscar
     * @return {@code Producto} correspondiente al nombre indicado
     * @throws ProductoNoEncontradoException si no se encuentra ningún producto con el nombre indicado.
     */
    public Producto buscarPorNombre(String nombre) throws ProductoNoEncontradoException{
        for(Producto p : productos.values()){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        throw new ProductoNoEncontradoException("\nNo se ha encontrado un producto con el nombre indicado.");
    }

    /**
     * Agrega un nuevo producto al catálogo.
     * @param p producto a agregar
     */
    public void agregarProducto(Producto p){
        productos.put(p.getId_Producto(), p);
    }
}
