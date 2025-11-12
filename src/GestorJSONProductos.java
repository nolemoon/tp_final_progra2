package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public final class GestorJSONProductos {
    private String aJson  = "productos.json";

    // Constructores
    public GestorJSONProductos() {
    }

    // TODO: CREAR LA CLASE operacionesArchivos. Lo comento por que todavía no fue creada la clase.
      /*
    // Productos - Archivo intercambio.
    public void productoaArchivo(Producto p){
        operacionesArchivos.grabarArchivo(serializarProducto(p),aJson);
    }

    public Producto archivoAproducto(){
        JSONTokener token = operacionesArchivos.leerArchivo(aJson);
        Producto p = null;
        try{
            p = deserializarProducto(new JSONObject(token));
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return p;

    }
    */

    // Metodos Serializacion.
    public JSONObject serializarProductoABS(Producto p) {
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

    public JSONObject serializarJuego(Juego j){
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

    public JSONObject serializarEbook(Ebook e){
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

    public JSONObject serializarSerie(Series s){
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

    public JSONObject serializarProducto(Producto pd) {
        JSONObject json = null;
        try {
            if (pd instanceof Juego j) {
                json = serializarJuego(j);
            } else if (pd instanceof Pelicula p) {
                json = serializarPelicula(p);
            } else if (pd instanceof Ebook e) {
                json = serializarEbook(e);
            } else if (pd instanceof Series s) {
                json = serializarSerie(s);
            }

            if (json != null) {
                json.put("tipo", pd.getClass().getSimpleName());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    // Metodos Deserializacion.
    public void deserializarProductoABS(JSONObject json, Producto p) {
        try {
            p.setNombre(json.getString("nombre"));
            p.setGenero(Genero.valueOf(json.getString("genero")));
            p.setPrecio(json.getDouble("precio"));
            p.setAnioPublicado(json.getInt("anioPublicado"));
            p.setCreador(json.getString("creador"));
            p.setDescripcion(json.getString("descripcion"));
            p.setTipoSuscripcion(TipoSuscripcion.valueOf(json.getString("tipoSuscripcion")));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    public Juego deserializarJuego(JSONObject json) {
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

    public Ebook deserializarEbook(JSONObject json) {
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

    public Series deserializarSerie(JSONObject json) {
        Series s = null;
        try {
            s = new Series();
            deserializarProductoABS(json, s);
            s.setTemporadas(json.getInt("temporadas"));
            s.setCapitulos(json.getInt("capitulos"));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return s;
    }

    public Producto deserializarProducto(JSONObject json) {
        try {
            String tipo = json.getString("tipo");

            if (tipo.equals(Juego.class.getSimpleName())) {
                return deserializarJuego(json);
            }
            else if (tipo.equals(Pelicula.class.getSimpleName())) {
                return deserializarPelicula(json);
            }
            else if (tipo.equals(Ebook.class.getSimpleName())) {
                return deserializarEbook(json);
            }
            else if (tipo.equals(Series.class.getSimpleName())) {
                return deserializarSerie(json);
            }
            else {
                return null;
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    // TODO: Serializar colecciones.

}
