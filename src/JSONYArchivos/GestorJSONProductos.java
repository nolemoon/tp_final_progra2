package JSONYArchivos;

import Productos.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import Enum.Suscripcion;
import Enum.Genero;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public final class GestorJSONProductos {
    private final String aJson  = "productos.json";
private static final JSONArray json=new JSONArray();
    // Constructores
    public GestorJSONProductos() {

    }

    // Productos - Archivo intercambio.
    /**
     * Graba un producto en un archivo, llamando al metodo de serializar y grabar archivo.
     * @param p objeto Producto a grabar.
     */
    public void productoaArchivo(Producto p){


        json.put(serializarProducto(p));
        OperacionesArchivos.grabarArchivo(json,aJson);
    }

    /**
     * Lee un archivo de un producto y lo devuelve en un tipo objeto.
     * @return objeto Producto proveniente del archivo.
     */
    public Producto archivoAproducto(){
        JSONTokener token = OperacionesArchivos.leerArchivo(aJson);
        Producto p = null;
        try{
            p = deserializarProducto(new JSONObject(token));
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return p;
    }

    // Metodos Serializacion.
    /**
     * Serializa los atributos en comun de la clase abstracta Producto.
     * @param p objeto Producto a serializar
     * @return objeto JSON con los datos básicos del producto
     */
    private JSONObject serializarProductoABS(Producto p) {
        JSONObject jsonTemp = null;
        try{
            jsonTemp = new JSONObject();
            jsonTemp.put("nombre", p.getNombre());
            jsonTemp.put("genero", p.getGenero().toString());
            jsonTemp.put("precio", p.getPrecio());
            jsonTemp.put("anioPublicado", p.getAnioPublicado());
            jsonTemp.put("creador", p.getCreador());
            jsonTemp.put("descripcion", p.getDescripcion());
            jsonTemp.put("tipoSuscripcion", p.getTipoSuscripcion().toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonTemp;
    }

    /**
     * Serializa el objeto de tipo Juego sumando a los atributos de la clase abstracta.
     * @param j objeto Juego a serializar
     * @return objeto JSON con los datos completos del juego.
     */
    private JSONObject serializarJuego(Juego j){
        JSONObject jsonTemp = null;

        try{
            jsonTemp = serializarProductoABS(j);
            jsonTemp.put("requisitosMinimos", j.getRequisitosMinimos());
            jsonTemp.put("multiplayer", j.isMultiplayer());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonTemp;
    }

    /**
     * Serializa el objeto de tipo Pelicula sumando a los atributos de la clase abstracta.
     * @param p objeto Pelicula a serializar
     * @return objeto JSON con los datos completos de la pelicula.
     */
    public JSONObject serializarPelicula(Pelicula p){
        JSONObject jsonTemp = null;

        try {
            jsonTemp = serializarProductoABS(p);

            jsonTemp.put("duracion", p.getDuracion());
            jsonTemp.put("clasificacion", p.getClasificacion());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonTemp;
    }

    /**
     * Serializa el objeto de tipo Ebook sumando a los atributos de la clase abstracta.
     * @param e objeto Ebook a serializar
     * @return objeto JSON con los datos completos del eBook.
     */
    private JSONObject serializarEbook(Ebook e){
        JSONObject jsonTemp = null;

        try {
            jsonTemp = serializarProductoABS(e);

            jsonTemp.put("numPaginas", e.getNumPaginas());
            jsonTemp.put("formato", e.getFormato());
            jsonTemp.put("idioma", e.getIdioma());

        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        return jsonTemp;
    }

    /**
     * Serializa el objeto de tipo Serie sumando a los atributos de la clase abstracta.
     * @param s objeto Series a serializar
     * @return objeto JSON con los datos completos de la serie.
     */
    private JSONObject serializarSerie(Serie s){
        JSONObject jsonTemp = null;

        try {
            jsonTemp = serializarProductoABS(s);

            jsonTemp.put("temporadas", s.getTemporadas());
            jsonTemp.put("capitulos", s.getCapitulos());

        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        return jsonTemp;
    }

    /**
     * Serializa cualquier tipo de objeto que extienda de producto, llamando a los serializadores de cada objeto.
     * @param pd objeto a Serializar de manera completa.
     * @return objeto JSON con los datos completos del producto.
     */
    public JSONObject serializarProducto(Producto pd) {
        JSONObject jsono = null;
        try {
            if (pd instanceof Juego j) {
                jsono = serializarJuego(j);
            } else if (pd instanceof Pelicula p) {
                jsono = serializarPelicula(p);
            } else if (pd instanceof Ebook e) {
                jsono = serializarEbook(e);
            } else if (pd instanceof Serie s) {
                jsono = serializarSerie(s);
            }

            if (jsono != null) {
                jsono.put("tipo", pd.getClass().getSimpleName());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsono;
    }

    // Metodos Deserializacion.
    /**
     * Deserializa los atributos en comun de un producto desde un objeto JSON.
     * @param json objeto JSON con los datos básicos del producto.
     * @param p producto donde se cargan los datos deserializados.
     */
    private void deserializarProductoABS(JSONObject json, Producto p) {
        try {
            p.setNombre(json.getString("nombre"));
            p.setGenero(Genero.valueOf(json.getString("genero")));
            p.setPrecio(json.getDouble("precio"));
            p.setAnioPublicado(json.getInt("anioPublicado"));
            p.setCreador(json.getString("creador"));
            p.setDescripcion(json.getString("descripcion"));
            p.setTipoSuscripcion(Suscripcion.valueOf(json.getString("tipoSuscripcion")));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Deserializa un juego que extienda de producto, deserializando tambien sus atributos heredados.
     * @param json objeto JSON con los datos del juego.
     */
    private Juego deserializarJuego(JSONObject json) {
        Juego j = null;
        try {
            j = new Juego();
            deserializarProductoABS(json, j);
            j.setRequisitosMinimos(json.getString("requisitosMinimos"));
            j.setMultiplayer(json.getBoolean("multiplayer"));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return j;
    }

    /**
     * Deserializa una pelicula que extienda de producto, deserializando tambien sus atributos heredados.
     * @param json objeto JSON con los datos de la pelicula.
     */
    public Pelicula deserializarPelicula(JSONObject json) {
        Pelicula p = null;
        try {
            p = new Pelicula();
            deserializarProductoABS(json, p);
            p.setDuracion(json.getInt("duracion"));
            p.setClasificacion(json.getString("clasificacion"));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    /**
     * Deserializa un eBook que extienda de producto, deserializando tambien sus atributos heredados.
     * @param json objeto JSON con los datos del Ebook.
     */
    private Ebook deserializarEbook(JSONObject json) {
        Ebook e = null;
        try {
            e = new Ebook();
            deserializarProductoABS(json, e);
            e.setNumPaginas(json.getInt("numPaginas"));
            e.setFormato(json.getString("formato"));
            e.setIdioma(json.getString("idioma"));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return e;
    }

    /**
     * Deserializa una Serie que extienda de producto, deserializando tambien sus atributos heredados.
     * @param json objeto JSON con los datos de la serie.
     */
    private Serie deserializarSerie(JSONObject json) {
        Serie s = null;
        try {
            s = new Serie();
            deserializarProductoABS(json, s);
            s.setTemporadas(json.getInt("temporadas"));
            s.setCapitulos(json.getInt("capitulos"));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return s;
    }

    /**
     * Deserializa cualquier tipo que extienda de producto, llamando a los deserializadores de cada tipo de producto,
     * deserializando tambien sus atributos heredados.
     * @param jsono objeto JSON con los datos completos del producto.
     */
    public Producto deserializarProducto(JSONObject jsono) {
        try {


            String tipo = jsono.getString("tipo");

            if (tipo.equals(Juego.class.getSimpleName())) {
                return deserializarJuego(jsono);
            }
            else if (tipo.equals(Pelicula.class.getSimpleName())) {
                return deserializarPelicula(jsono);
            }
            else if (tipo.equals(Ebook.class.getSimpleName())) {
                return deserializarEbook(jsono);
            }
            else if (tipo.equals(Serie.class.getSimpleName())) {
                return deserializarSerie(jsono);
            }
            else {
                return null;
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Serializa un mapa de productos a un JSONObject y lo guarda en un archivo JSON.
     * @param productos {@code LinkedHashMap} de productos a serializar
     */
    public void mapaProductosToArchi(LinkedHashMap<Integer, Producto> productos){
        JSONArray ja = new JSONArray();
        try{
            for(Map.Entry<Integer, Producto> entry : productos.entrySet()){
                JSONObject jo = new JSONObject();
                jo.put("id", entry.getKey());
                jo.put("producto", serializarProducto(entry.getValue()));
                ja.put(jo);
            }

            OperacionesArchivos.grabarArchivo(ja, aJson);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    /**
     * Lee un archivo JSON y lo guarda en un mapa de productos.
     * @return {@code LinkedHashMap} de productos deserializados
     */
    public LinkedHashMap<Integer, Producto> archiToMapaProductos(){
        LinkedHashMap<Integer, Producto> mapa = new LinkedHashMap<>();
        JSONTokener tk = OperacionesArchivos.leerArchivo(aJson);

        try{
            JSONArray ja = new JSONArray(tk);

            for(int i = 0; i < ja.length(); i++){
                JSONObject obj = ja.getJSONObject(i);
                Integer id = obj.getInt("id");
                Producto p = deserializarProducto(obj.getJSONObject("producto"));
                mapa.put(id, p);
            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }
        return mapa;
    }

    public ArrayList<Producto> archiToArrayListProductos(){
        ArrayList<Producto> lista = new ArrayList<>();
        JSONTokener tk = OperacionesArchivos.leerArchivo(aJson);
        try{
            JSONObject jo = new JSONObject(tk);
            JSONArray ja = jo.getJSONArray("productos");
            for(int i = 0; i < ja.length(); i++){
                JSONObject obj = ja.getJSONObject(i);
                lista.add(deserializarProducto(obj.getJSONObject("producto")));
            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }
        return lista;
    }

}
