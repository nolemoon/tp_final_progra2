import Productos.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase CatalogoProductos tiene como campo una lista de productos.
 * Métodos: filtrarPorTipo, filtrarPorGenero y mostrarCatalogo.
 * @author Renata
 */
public class CatalogoProducto {
    private List<Producto> productos;

    public CatalogoProducto() {
        this.productos = new ArrayList<>();  //se cargan los datos desde json, aca tendría que recibir la lista deserializada
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Producto> filtrarPorTipo(Class<? extends Producto> tipoProducto){
        List<Producto> listaFiltrada = new ArrayList<>();
        for(Producto p : productos){
            if(tipoProducto.isInstance(p)){
                listaFiltrada.add(p);
            }
        }
        return listaFiltrada;
    }

    public List<Producto> filtrarPorGenero(List<Producto> listaRecibida, String generoIndicado){
        List<Producto> listaFiltrada = new ArrayList<>();
        for(Producto p : productos){
            if(p.getGenero().name().equalsIgnoreCase(generoIndicado)){
                listaFiltrada.add(p);
            }
        }
        return listaFiltrada;
    }

    public void mostrarCatalogo(List<Producto> listaRecibida){
        for(Producto p : listaRecibida){
            System.out.println(p.toString());
        }
    }
}
